/**
 * Purpose: to fix ckeditor resize issues
 * Based on ckez version: 4.18.0.0
 */

 zk.afterLoad("ckez", function () {
  const _xckeditor = {};
  zk.override(ckez.CKeditor.prototype, _xckeditor, {
      _syncSize: function() {
          const editor = this._editor,
                n = this.$n();

          if ( !editor || !editor.document ||  !editor.document.getWindow ||  !editor.document.getWindow()  || !editor.document.getWindow().$ ) {
              return;
          }

          if (editor && n) {
              editor.resize('100%', n.clientHeight);
              jq(n).css("overflow", "auto");
          }
      }
   });
});

zk.afterLoad("zul.tab", function () {
const _xTab = {};
zk.override(zul.tab.Tab.prototype, _xTab, {
    _sel: function _sel(toSel, notify) {
        let tabbox = this.getTabbox();

        if (!tabbox || tabbox._animating) return;
        let panel = this.getLinkedPanel(),
            inAccordion = tabbox.inAccordionMold();

        if (toSel) {
          let ps;

          if (ps = tabbox.tabpanels) {
            if (ps._selPnl && ps._selPnl != panel) ps._selPnl._sel(false, false);
            ps._selPnl = panel; //stored in tabpanels
          }

          tabbox._selTab = this;
        }

        if (!this.desktop) return;
        if (toSel) jq(this).addClass(this.$s('selected'));else jq(this).removeClass(this.$s('selected'));
        if (panel && panel.isVisible()){	    	    	  
          panel._sel(toSel, false);
        }

        let tabs = this.parent;

        if (!inAccordion) {
          if (tabs) tabs._fixWidth(toSel); //ZK-2810: don't set height to tabbox when deselect
        }

        if (toSel) {
          if (tabbox.isVertical()) {
            tabs._scrollcheck('vsel', this);
          }
            else if (!tabbox.inAccordionMold()) {
              tabs._scrollcheck('sel', this);
            }
        }

        if (notify) this.fire('onSelect', {
          items: [this],
          reference: this.uuid
        });
      }
 });
});

zk.afterLoad("zul.wgt", function () {
const _xGroupbox = {};

function firstChild(wgt) {
  for (var w = wgt.firstChild, cap = wgt.caption; w; w = w.nextSibling) {
    if (w != cap) return w;
  }
}

function _render(wgt) {
  if (wgt._rodKid && (!wgt.parent || !wgt.parent.z_rod)) {
    delete wgt._rodKid;
    wgt._rodopen = true; //redraw counts on it

    var out = new zk.Buffer();

    wgt._redrawCave(out);

    jq('#' + wgt.uuid + '-cave').replaceWith(out.join(''));

    for (var w = firstChild(wgt); w; w = w.nextSibling) {
      w.unbind();
      w.bind(wgt.desktop);
    }

    wgt.clearCache();
    if (wgt._doScrollableSyncScroll) wgt.domListen_(wgt.getCaveNode(), 'onScroll', '_doScrollableSyncScroll');
  }
}

zk.override(zul.wgt.Groupbox.prototype, _xGroupbox, {
    setOpen: function (open, fromServer) {
        if (open) _render(this);
        let node = this.$n();
        if (node && this._closable) {
            const caveNode = this.getCaveNode();
            if (open) {
                jq(node).removeClass(this.$s('collapsed'));
                zk(this).redoCSS(-1, {'fixFontIcon': true});
            }
            jq(caveNode)[open ? 'show' : 'hide']();
            this._afterOpen(open);

            if (!fromServer) this.fire('onOpen', {open: open});
        }
        this._open = open;                
    }
 });
});
