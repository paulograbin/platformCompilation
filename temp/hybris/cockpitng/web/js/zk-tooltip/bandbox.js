/**
 * Add tooltip for zk bandbox related icon
 */
zk.afterLoad('zul.inp', function() {
    const _xBandbox = {};

    zk.override(zul.inp.Bandbox.prototype, _xBandbox, {
        bind_: function bind_() {
            _xBandbox.bind_.apply(this, arguments);

            // Set tooltip for icon of explorer tree filter text box
            setTitleForIcon(this, '.z-bandbox-icon.z-icon-cog', msg.bandbox_setting);

            // Set tooltip for icon of default reference editor
            setTitleForIcon(this, '.z-bandbox-icon.y-icon-reference-editor', msg.bandbox_open);

            // Set tooltip for icon of common bandbox
            setTitleForIcon(this, '.z-bandbox-icon.z-icon-search', msg.bandbox_search);

            setTitleForIcon(this, '.z-bandbox-icon', msg.common_expand_collapse);
        },
    });
});
