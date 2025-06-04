/**
 * allow to stop sending rmDesktop request to server with zk.skipRmDesktop = true
 * base version: 9.6.5
 */
zk.afterLoad("zk", function () {
    var _xzAu = {};
    zk.override(zAu, _xzAu, {
        _rmDesktop: function _rmDesktop(dt, dummy) {
            var url = zk.ajaxURI(null, {
                    desktop: dt,
                    au: true
                }),
                data = jq.param({
                    dtid: dt.id,
                    cmd_0: dummy ? 'dummy' : 'rmDesktop',
                    opt_0: 'i'
                }),
                headers = {};

            if (zk.pfmeter) {
                var fakeFetachOpts = {
                    headers: {}
                };
                headers = fakeFetachOpts.headers;

                zAu._pfsend(dt, fakeFetachOpts, true, false);
            } // ZK-4943


            if (dt) dt.fire('onBeforeDestroy'); // ZK-4204

            if (zk.skipRmDesktop) {
                console.log("Skipping desktop cleanup notification since zk.skipRmDesktop is true!")
                return;
            }

            if (navigator.sendBeacon && window.URLSearchParams) {
                var params = new URLSearchParams(data);

                for (var key in headers) {
                    if (Object.prototype.hasOwnProperty.call(headers, key)) params.append(key, headers[key]);
                }

                navigator.sendBeacon(url, zk.chrome // https://crbug.com/747787
                    ? new Blob([params.toString()], {
                        type: 'application/x-www-form-urlencoded'
                    }) : params);
            } else {
                this._rmDesktopAjax(url, data, headers);
            } // B65-ZK-2210: clean up portlet2 data when desktop removed.


            if (!dummy && zk.portlet2Data && zk.portlet2Data[dt.id]) {
                delete zk.portlet2Data[dt.id];
            }
        }
    });

    /**
     * send a rmDesktop request to server with a synchronous AJAX
     * base on zAy._rmDesktopAjax()
     * The reason that current zk doesn't use synchronous AJAX, see https://tracker.zkoss.org/browse/ZK-4204
     * Purpose:
     * replacing sendBeacon() with this, to avoid sending a beacon after login page with an invalid session
     */
    zAu._rmDesktopSyncAjax = function(){
        zk.rmDesktoping = true;
        try {
            var dts = zk.Desktop.all;
            for (var dtid in dts){
                zAu.rmOneDesktopAjax(dts[dtid]);
            }
        } catch (e) {
            zk.debugLog((_a = e.message) !== null && _a !== void 0 ? _a : e);
        }
    };

    zAu.rmOneDesktopAjax = function(dt){
        var bRmDesktop = zk.opera || zk.keepDesktop;
        var url = zk.ajaxURI(undefined, {
                desktop: dt,
                au: true
            }),
            data = jq.param({
                dtid: dt.id,
                cmd_0: bRmDesktop ? 'dummy' : 'rmDesktop',
                opt_0: 'i'
            }),
            headers = {};
        let ajaxSetting = zAu.ajaxSettings;
        ajaxSetting.type = 'POST';
        jq.ajax(zk.$default({
            url: url,
            data: data,
            beforeSend: function (xhr) {
                for (var key in headers) {
                    if (Object.prototype.hasOwnProperty.call(headers, key)) xhr.setRequestHeader(key, headers[key]);
                }
            },
            //2011/04/22 feature 3291332
            //Use sync request for IE, chrome, safari and firefox (4 and later).
            //Note: when pressing F5, the request's URL still arrives before this even async:false
            async: false
        }, ajaxSetting));
    };
});