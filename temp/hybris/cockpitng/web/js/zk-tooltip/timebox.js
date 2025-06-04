/**
 * Add tooltip for zk timebox related icon
 */
zk.afterLoad('zul.db', function() {
    const _xTimebox = {};

    zk.override(zul.db.Timebox.prototype, _xTimebox, {
        bind_: function bind_() {
            _xTimebox.bind_.apply(this, arguments);

            setTitleForIcon(this, '.z-timebox-icon.z-timebox-up', msg.timebox_up);
            setTitleForIcon(this, '.z-timebox-icon.z-timebox-down', msg.timebox_down);
        },
    });
});
