/**
 * Add tooltip for zk tabbox related icon
 */
zk.afterLoad('zul.tab', function() {
    const _xTab = {};
    zk.override(zul.tab.Tabbox.prototype, _xTab, {
        bind_: function bind_() {
            _xTab.bind_.apply(this, arguments);

            setTitleForIcon(this, 'div.z-tabbox-icon .z-icon-chevron-left', msg.tabbox_left);
            setTitleForIcon(this, 'div.z-tabbox-icon .z-icon-chevron-right', msg.tabbox_right);
        },
    });
});
