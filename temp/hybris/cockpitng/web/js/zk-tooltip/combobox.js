/**
 * Add tooltip for zk combobox related icon
 */
zk.afterLoad('zul.inp', function() {
    const _xCombobox = {};
    zk.override(zul.inp.Combobox.prototype, _xCombobox, {
        bind_: function bind_() {
            _xCombobox.bind_.apply(this, arguments);
            setTitleForIcon(this, '.z-combobox-button', msg.common_expand_collapse);
        },
    });
});
