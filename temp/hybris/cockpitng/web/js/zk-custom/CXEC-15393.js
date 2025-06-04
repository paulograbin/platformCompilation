/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved
 */

/**
 * Customization for accessibility in collection browser
 * 1. Support for resize column width using `Shift + ArrowLeft / ArrowRight`
 * 2. Add aria attributes to listbox items.
 */

zk.afterLoad('zul.mesh', function () {
    var _xheader = {};

    zk.override(zul.mesh.HeaderWidget.prototype, _xheader, {
        /**
         * 1. Add listener to key down with Shift + ArrowLeft / ArrowRight
         * 2. Do column resize when keyDown
         */
        doKeyDown_: function doKeyDown_(evt) {
            // add suport for shiftKye
            if (evt.shiftKey) {
                const wgt = this;
                const key = evt.key;
                const mesh = this.getMeshWidget();
                if (key !== 'ArrowLeft' && key !== 'ArrowRight') {
                    return;
                }
                if (mesh) {
                    if (mesh.inSelectMold && mesh.inSelectMold()) {
                        return;
                    }

                    // re-use the code in zul.mesh#_aftersizing
                    const cidx = zk(wgt.$n()).cellIndex(),
                        hdfaker = mesh.ehdfaker,
                        bdfaker = mesh.ebdfaker,
                        ftfaker = mesh.eftfaker,
                        hdcols = hdfaker.childNodes,
                        bdcols = bdfaker.childNodes,
                        ftcols = ftfaker ? ftfaker.childNodes : null,
                        wds = [];

                    if (wgt.parent.isSizable() && cidx === 0) {
                        return;
                    }

                    for (let w = mesh.head.firstChild, i = 0; w; w = w.nextSibling, i++) {
                        const stylew = hdcols[i].style.width;
                        // ZK-1022: get original width if it is shrinked by Frozen.js#_doScrollNow
                        const isFixedWidth = stylew && stylew.indexOf('%') < 0;
                        let origWd = w._origWd;

                        if (origWd) {
                            if (isFixedWidth && zk.parseFloat(stylew) > 1) {
                                origWd = stylew; // use the latest one;
                            }

                            w._width = wds[i] = origWd;
                        } else {
                            wds[i] = isFixedWidth ? stylew : jq.px0(w.$n().offsetWidth);
                            if (w.isVisible()) {
                                w._width = wds[i];
                            } else if (!w._width && !w._hflex) {
                                //invisible and no width
                                w._width = '-1';
                            }
                        }

                        if (!isFixedWidth) {
                            hdcols[i].style.width = bdcols[i].style.width = wds[i];
                            if (ftcols) {
                                //ZK-2769: Listfooter is not aligned with listhead on changing width
                                ftcols[i].style.width = wds[i];
                            }
                        }
                    }

                    /**
                     * Cutomized part start
                     * Compute the new width of focused column
                     * ArrowRight means broaden 30px
                     * ArrowLeft means shorten 30px
                     * The min width is according to css style min-width. Default min-width is 30px.
                     */

                    const currentHeaderWidth = wds[cidx].slice(0, wds[cidx].length - 2);

                    const changedWidth = key === 'ArrowLeft' ? -30 : 30;

                    const targetWidth = +currentHeaderWidth + changedWidth;

                    let minWidth;
                    if (this.$n() && this.$n().style.minWidth)
                    {
                        minWidth = zk.parseInt(this.$n().style.minWidth);
                    }
                    minWidth = minWidth || 30;

                    const wd = (targetWidth > minWidth ? targetWidth : minWidth) + "px";

                    /**
                    * Cutomized part end
                    */

                    if (!wgt.origWd) {
                        wgt._width = wds[cidx] = wd;
                    }
                    hdcols[cidx].style.width = bdcols[cidx].style.width = wd;
                    if (ftcols) {
                        //ZK-2769: Listfooter is not aligned with listhead on changing width
                        ftcols[cidx].style.width = wd; //3. clear width=100% setting, otherwise it will try to expand to whole width
                    }

                    mesh.eheadtbl.width = '';
                    mesh.ebodytbl.width = '';
                    if (mesh.efoottbl) mesh.efoottbl.width = '';

                    delete mesh._span; //no span!
                    delete mesh._sizedByContent; //no sizedByContent!

                    for (let w = mesh.head.firstChild; w; w = w.nextSibling) {
                        w.setHflex_(null);
                    }

                    wgt.parent.fire('onColSize', zk.copy({
                        index: cidx,
                        column: wgt,
                        width: wd,
                        widths: wds
                    }, evt.data), null, 0);
                }
            } else {
                _xheader.doKeyDown_.apply(this, arguments);
            }
        },
    });
});

zk.afterLoad('zul.sel', function () {
    var _xListitem = {};
    const attr4AriaChecked = "aria-checked";

    zk.override(zul.sel.Listitem.prototype, _xListitem, {
        /**
         * override zul.sel.Listitem.prototype.bind_ in sel-a11y.js
         * make the aria-label of each row like `Row n of m, xxxx`
         */
        bind_: function bind_() {
            _xListitem.bind_.apply(this, arguments);

            const attr4AriaLable = "aria-label";
            var n = this.$n(),
                jqn = jq(n),
                parent = this.getListbox();
            jqn.attr('role', 'row');
            //rod
            if (parent._totalSize) {
                var rowIndex = this._index + 1;
                jqn.attr('aria-rowindex', rowIndex);
                const originalLabel = n.getAttribute(attr4AriaLable);
                if (originalLabel && originalLabel === n.textContent) {
                    var newLabel = "",
                        children = n.childNodes;
                    if (children.length > 1) {
                        children.forEach((e) => {
                            if (e.textContent) {
                                newLabel += `${e.getAttribute(attr4AriaLable)}: ${e.textContent}, `;
                            }
                        });
                    } else {
                        newLabel = originalLabel;
                    }
                    jqn.attr(attr4AriaLable, `Row ${rowIndex} of ${parent._totalSize}, ${newLabel}`);
                }
            }
            jq(this.$n('checkbox')).attr("aria-hidden", true);
        },

        /**
         * add aria-checked when first column is checkbox
         */
        _updateSelectedAriaAttr: function _updateSelectedAriaAttr() {
            _xListitem._updateSelectedAriaAttr.apply(this, arguments);
            var n = this.$n();
            if (n && this.isSelectable()) {
                var selected = this._selected || false;
                if (n.firstChild.getAttribute("role") === "checkbox") {
                    n.firstChild.setAttribute(attr4AriaChecked, selected);
                }
            }
        },
    });

    var _xListHeader = {};
    zk.override(zul.sel.Listheader.prototype, _xListHeader, {
        _doClick: function (e) {
            _xListHeader._doClick.apply(this, arguments);
            //add checkable status to "aria-checked" for ListHeader
            var nCm = this.$n("cm");
            nCm.setAttribute(attr4AriaChecked, this._checked);
        },
    });

    var _xListbox = {};
    zk.override(zul.sel.Listbox.prototype, _xListbox, {
        _updHeaderCM: function () {
            _xListbox._updHeaderCM.apply(this, arguments);
            //add "Select All" status to "aria-checked" for Listbox
            if (this._headercm && this._multiple && this.listhead && this.listhead.firstChild) {
                this._headercm.setAttribute(attr4AriaChecked, this._isAllSelected());
            }
        },
    });
});
