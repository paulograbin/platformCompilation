/**
 * Add tooltip for zk treecell related icon
 */
zk.afterLoad('zul.sel', function() {

    const setTitleForArrowIcon = (component, selector, title) => {
        const jqBtns = jq(component.$n()).find(selector);

        for (const jqBtn of jqBtns) {
            const iconButtons = jq(jqBtn).parent('span');
            if (iconButtons.length > 0 && iconButtons[0] && !iconButtons[0].getAttribute('title')) {
                iconButtons[0].setAttribute('title', title);
            }
        }
    };

    const setTitleForCustomIcon = (component, selector, title) => {
        const treeIcons = jq(component.$n()).find(selector);
        for (const treeIcon of treeIcons) {
            const iconButtons = jq(treeIcon).parent('span.z-treecell-text').prev();
            if (iconButtons.length > 0 && iconButtons[0]) {
                iconButtons[0].setAttribute('title', title);
            }
        }
    };

    const _xTreecell = {};

    zk.override(zul.sel.Treecell.prototype, _xTreecell, {
        bind_: function bind_() {
            _xTreecell.bind_.apply(this, arguments);

            setTitleForArrowIcon(this, '.z-icon-caret-right', msg.common_expand);
            setTitleForArrowIcon(this, '.z-icon-caret-down', msg.common_collapse);

            // Set tooltip for localized icon of attribute picker
            setTitleForCustomIcon(this, '.y-icon-localized', msg.treecell_localized_more_languages);
        },
    });
});
