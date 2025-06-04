/**
 * Add tooltip for zk caption related icon
 */
zk.afterLoad('zul.wgt', function() {
    const _xCaption = {};

    zk.override(zul.wgt.Caption.prototype, _xCaption, {
        bind_: function bind_() {
            _xCaption.bind_.apply(this, arguments);
            setTitleForIcon(this, '.yw-caption-icon', msg.common_expand_collapse);
        },
    });
});
