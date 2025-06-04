/**
 * Add tooltip for zk paging related icon
 */
zk.afterLoad('zul.mesh', function() {
    const _xPaging = {};

    zk.override(zul.mesh.Paging.prototype, _xPaging, {
        bind_: function bind_() {
            _xPaging.bind_.apply(this, arguments);

            setTitleForIcon(this, 'button.z-paging-button.z-paging-first', msg.paging_first);
            setTitleForIcon(this, 'button.z-paging-button.z-paging-previous', msg.paging_pre);
            setTitleForIcon(this, 'button.z-paging-button.z-paging-next', msg.paging_next);
            setTitleForIcon(this, 'button.z-paging-button.z-paging-last', msg.paging_last);
        },
    });
});
