/**
 * Add tooltip for zk datebox related icon
 */
zk.afterLoad('zul.db', function() {
    const _xDatebox = {};
    zk.override(zul.db.Datebox.prototype, _xDatebox, {
        bind_: function bind_() {
            _xDatebox.bind_.apply(this, arguments);

            setTitleForIcon(this, '.z-datebox-button', msg.databox_open_picker);
        },
    });
});
