/**
 * Add tooltip for zk calendar related icon
 */
zk.afterLoad('zul.db', function() {
    const _xCalendar = {};

    zk.override(zul.db.Calendar.prototype, _xCalendar, {
        bind_: function bind_() {
            _xCalendar.bind_.apply(this, arguments);

            setTitleForIcon(this, '.z-calendar-icon.z-calendar-left', msg.calendar_pre);

            setTitleForIcon(this, '.z-calendar-icon.z-calendar-right', msg.calendar_next);
        },
    });
});
