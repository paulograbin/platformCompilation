/**
 * Purpose: a patch
 * Based on version: 9.6.1
 */
 zk.afterLoad('zul.inp', function() {
    var exWidget = {};
    zk.override(zul.inp.Bandpopup.prototype, exWidget, {
        _focusout: function _focusout(e) {
            var bandbox = this.parent,
                self = this;
            //if clicking element is not receiving target, it's null. check target is also valid.
            if (e.relatedTarget || e.target) {
                if (bandbox && bandbox.isOpen() && !jq.isAncestor(bandbox.$n('pp'), e.relatedTarget || e.target)) {
                  bandbox.close({
                    sendOnOpen: true
                  });
                }
            } else {
              // for solving B96-ZK-4748, treechildren will rerender itself when clicking
              // the open icon, and JQ will simulate a fake focusout event without any relatedTarget.
              self._shallClosePopup = true;
              setTimeout(function () {
                if (bandbox && bandbox.isOpen() && self._shallClosePopup) {
                  bandbox.close({
                    sendOnOpen: true
                  });
                  self._shallClosePopup = false;
                }
              });
            }
        },
    });
});
