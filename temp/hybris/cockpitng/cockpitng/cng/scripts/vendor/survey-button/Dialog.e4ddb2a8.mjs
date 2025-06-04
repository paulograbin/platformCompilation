var ve = Object.getPrototypeOf;
var we = Reflect.get;
var U = (t, e, o) => we(ve(t), o, e);
var l = (t, e, o) => new Promise((i, s) => {
  var a = (h) => {
    try {
      r(o.next(h));
    } catch (w) {
      s(w);
    }
  }, n = (h) => {
    try {
      r(o.throw(h));
    } catch (w) {
      s(w);
    }
  }, r = (h) => h.done ? i(h.value) : Promise.resolve(h.value).then(a, n);
  r((o = o.apply(t, e)).next());
});
import { e as ye, i as $e, d as xe } from "./Device.8e41a90c.mjs";
import { i as Se, e as m, l as p, a as R, p as c, c as oe, U as Re, b as ke, s as L } from "./parameters-bundle.css.11496d28.mjs";
import { s as C } from "./slot.f280b696.mjs";
import { b as ze, e as z, c as Me, a as Te, r as b, d as j, f as X, h as G, j as V, k as Y, l as Z, m as K, n as Q, I as Ee } from "./Icon.7310a395.mjs";
import { H as De, D as He, F as qe, G as Le, k as Ne, g as Pe, Q as N, r as f, h as Fe, c as Be, o as Oe, P as E } from "./CxQtxSurveyButton.96c49aa8.mjs";
import { g as Ae } from "./AriaLabelHelper.e3d1fa46.mjs";
import { R as J } from "./ResizeHandler.e19875b3.mjs";
import { s as k } from "./parameters-bundle.css.b6a86188.mjs";
/**
 * @license
 * Copyright 2018 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
class Ce extends He {
  constructor(e) {
    var o;
    if (super(e), e.type !== qe.ATTRIBUTE || e.name !== "style" || ((o = e.strings) === null || o === void 0 ? void 0 : o.length) > 2)
      throw new Error("The `styleMap` directive must be used in the `style` attribute and must be the only part in the attribute.");
  }
  render(e) {
    return "";
  }
  update(e, [o]) {
    const { style: i } = e.element;
    if (this._previousStyleProperties === void 0) {
      this._previousStyleProperties = /* @__PURE__ */ new Set();
      for (const s in o)
        this._previousStyleProperties.add(s);
    }
    this._previousStyleProperties.forEach((s) => {
      o[s] == null && (this._previousStyleProperties.delete(s), s.includes("-") ? i.removeProperty(s) : i[s] = "");
    });
    for (const s in o) {
      const a = o[s];
      a != null && (this._previousStyleProperties.add(s), s.includes("-") ? i.setProperty(s, a) : i[s] = a);
    }
    return Le;
  }
}
const T = De(Ce), x = (t, e, o) => Math.min(Math.max(t, e), o);
var B;
(function(t) {
  t.None = "None", t.Success = "Success", t.Warning = "Warning", t.Error = "Error", t.Information = "Information";
})(B || (B = {}));
const y = B, I = (t) => t.nodeName === "SLOT" ? !1 : t.offsetWidth <= 0 && t.offsetHeight <= 0 || t.style && t.style.visibility === "hidden", Ie = /^(?:a|area)$/i, We = /^(?:input|select|textarea|button)$/i, Ue = (t) => {
  if (t.disabled)
    return !1;
  const e = t.getAttribute("tabindex");
  return e != null ? parseInt(e) >= 0 : We.test(t.nodeName) || Ie.test(t.nodeName) && !!t.href;
}, je = (t) => t.hasAttribute("data-ui5-focus-trap"), ee = (t, e) => l(void 0, null, function* () {
  return !t || I(t) ? null : W(t, !0, e);
}), Xe = (t, e) => l(void 0, null, function* () {
  return !t || I(t) ? null : W(t, !1, e);
}), Ge = (t) => t.hasAttribute("data-ui5-focus-redirect") || !I(t), W = (t, e, o) => l(void 0, null, function* () {
  let i, s, a = -1;
  t.shadowRoot ? i = e ? t.shadowRoot.firstChild : t.shadowRoot.lastChild : t instanceof HTMLSlotElement && t.assignedNodes() ? (s = t.assignedNodes(), a = e ? 0 : s.length - 1, i = s[a]) : o ? i = t : i = e ? t.firstElementChild : t.lastElementChild;
  let n;
  for (; i; ) {
    const r = i;
    if (Se(i) && (i = yield i.getFocusDomRefAsync()), !i)
      return null;
    if (i.nodeType === 1 && Ge(i) && !je(i)) {
      if (Ue(i))
        return i && typeof i.focus == "function" ? i : null;
      if (n = yield W(i, e), n)
        return n && typeof n.focus == "function" ? n : null;
    }
    i = e ? r.nextSibling : r.previousSibling, s && !s[a].contains(i) && (a = e ? a + 1 : a - 1, i = s[a]);
  }
  return null;
}), Ve = "ui5-content-native-scrollbars", Ye = () => document.body.classList.contains(Ve), Ze = () => {
  let t = document.activeElement;
  for (; t && t.shadowRoot && t.shadowRoot.activeElement; )
    t = t.shadowRoot.activeElement;
  return t;
}, te = Ne("PopupUtilsData", { currentZIndex: 100 }), ie = () => {
  const t = Ze();
  return t && typeof t.focus == "function" ? t : null;
}, Ke = (t) => {
  const e = ie();
  return e ? se(t, e) : !1;
}, se = (t, e) => {
  let o = t;
  if (o.shadowRoot && (o = Array.from(o.shadowRoot.children).find((a) => a.localName !== "style"), !o))
    return !1;
  if (o === e)
    return !0;
  const i = o.localName === "slot" ? o.assignedNodes() : o.children;
  return i ? Array.from(i).some((s) => se(s, e)) : !1;
}, Qe = () => {
  const t = Pe("OpenUI5Support");
  return t && t.isLoaded() ? t.getNextZIndex() : (te.currentZIndex += 2, te.currentZIndex);
}, O = /* @__PURE__ */ new Map(), D = /* @__PURE__ */ new Map();
D.set("S", [0, 599]);
D.set("M", [600, 1023]);
D.set("L", [1024, 1439]);
D.set("XL", [1440, 1 / 0]);
var P;
(function(t) {
  t.RANGE_4STEPS = "4Step";
})(P || (P = {}));
const Je = (t, e) => {
  O.set(t, e);
}, et = (t, e = window.innerWidth) => {
  let o = O.get(t);
  o || (o = O.get(P.RANGE_4STEPS));
  let i;
  const s = Math.floor(e);
  return o.forEach((a, n) => {
    s >= a[0] && s <= a[1] && (i = n);
  }), i || [...o.keys()][0];
}, F = {
  RANGESETS: P,
  initRangeSet: Je,
  getCurrentRange: et
};
F.initRangeSet(F.RANGESETS.RANGE_4STEPS, D);
function tt(t, e, o) {
  return m`<section style="${T(this.styles.root)}" class="${N(this.classes.root)}" role="${p(this._role)}" aria-modal="${p(this._ariaModal)}" aria-label="${p(this._ariaLabel)}" aria-labelledby="${p(this._ariaLabelledBy)}" @keydown=${this._onkeydown} @focusout=${this._onfocusout} @mouseup=${this._onmouseup} @mousedown=${this._onmousedown}><span class="first-fe" data-ui5-focus-trap tabindex="0" @focusin=${this.forwardToLast}></span><div style="${T(this.styles.content)}" class="${N(this.classes.content)}"  @scroll="${this._scroll}" part="content"><slot></slot></div><span class="last-fe" data-ui5-focus-trap tabindex="0" @focusin=${this.forwardToFirst}></span></section> `;
}
function ot(t, e, o) {
  return m`<div class="ui5-block-layer" ?hidden=${this._blockLayerHidden} tabindex="0" style="${T(this.styles.blockLayer)}" @keydown="${this._preventBlockLayerFocus}" @mousedown="${this._preventBlockLayerFocus}"></div>`;
}
var A;
(function(t) {
  t.None = "None", t.Dialog = "Dialog", t.AlertDialog = "AlertDialog";
})(A || (A = {}));
const S = A;
let g = [];
const it = (t, e = []) => {
  g.some((o) => o.instance === t) || g.push({
    instance: t,
    parentPopovers: e
  }), ne(), g.length === 1 && at();
}, st = (t) => {
  g = g.filter((e) => e.instance !== t), ne(), g.length || nt();
}, ae = (t) => {
  !g.length || ze(t) && g[g.length - 1].instance.close(!0);
}, at = () => {
  document.addEventListener("keydown", ae);
}, nt = () => {
  document.removeEventListener("keydown", ae);
}, ne = () => {
  let t, e = !1;
  for (let o = g.length - 1; o >= 0; o--)
    t = g[o].instance, !e && t.isModal ? (t.isTopModalPopup = !0, e = !0) : t.isTopModalPopup = !1;
};
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const rt = { packageName: "@ui5/webcomponents", fileName: "themes/Popup.css", content: ":host{min-width:1px;display:none;position:fixed}" };
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const lt = { packageName: "@ui5/webcomponents", fileName: "themes/PopupStaticAreaStyles.css", content: ".ui5-block-layer{display:none;position:fixed;background-color:var(--sapBlockLayer_Background);opacity:.6;top:-500px;left:-500px;right:-500px;bottom:-500px;outline:none;pointer-events:all;z-index:-1}.ui5-block-layer:not([hidden]){display:inline-block}" };
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const ct = { packageName: "@ui5/webcomponents", fileName: "themes/PopupGlobal.css", content: ".ui5-popup-scroll-blocker{overflow:hidden}" };
var _ = globalThis && globalThis.__decorate || function(t, e, o, i) {
  var s = arguments.length, a = s < 3 ? e : i === null ? i = Object.getOwnPropertyDescriptor(e, o) : i, n;
  if (typeof Reflect == "object" && typeof Reflect.decorate == "function")
    a = Reflect.decorate(t, e, o, i);
  else
    for (var r = t.length - 1; r >= 0; r--)
      (n = t[r]) && (a = (s < 3 ? n(a) : s > 3 ? n(e, o, a) : n(e, o)) || a);
  return s > 3 && a && Object.defineProperty(e, o, a), a;
}, M;
const dt = () => {
  Fe("data-ui5-popup-scroll-blocker") || Be(ct, "data-ui5-popup-scroll-blocker");
};
dt();
const H = /* @__PURE__ */ new Set();
let d = M = class extends Re {
  constructor() {
    super(), this._resizeHandler = this._resize.bind(this);
  }
  onBeforeRendering() {
    this._blockLayerHidden = !this.isOpen() || !this.isTopModalPopup;
  }
  onEnterDOM() {
    J.register(this, this._resizeHandler);
  }
  onExitDOM() {
    this.isOpen() && (M.unblockPageScrolling(this), this._removeOpenedPopup()), J.deregister(this, this._resizeHandler);
  }
  get _displayProp() {
    return "block";
  }
  _resize() {
    this.mediaRange = F.getCurrentRange(F.RANGESETS.RANGE_4STEPS, this.getDomRef().offsetWidth);
  }
  _preventBlockLayerFocus(e) {
    e.preventDefault();
  }
  static blockPageScrolling(e) {
    H.add(e), H.size === 1 && document.documentElement.classList.add("ui5-popup-scroll-blocker");
  }
  static unblockPageScrolling(e) {
    H.delete(e), H.size === 0 && document.documentElement.classList.remove("ui5-popup-scroll-blocker");
  }
  _scroll(e) {
    this.fireEvent("scroll", {
      scrollTop: e.target.scrollTop,
      targetRef: e.target
    });
  }
  _onkeydown(e) {
    const o = e.target === this._root && Me(e), i = Te(e) && !this.isOpen();
    (o || i) && e.preventDefault();
  }
  _onfocusout(e) {
    e.relatedTarget || (this._shouldFocusRoot = !0);
  }
  _onmousedown(e) {
    this._root.removeAttribute("tabindex"), this.shadowRoot.contains(e.target) ? this._shouldFocusRoot = !0 : this._shouldFocusRoot = !1;
  }
  _onmouseup() {
    this._root.tabIndex = -1, this._shouldFocusRoot && (ye() && this._root.focus(), this._shouldFocusRoot = !1);
  }
  forwardToFirst() {
    return l(this, null, function* () {
      const e = yield ee(this);
      e ? e.focus({ focusVisible: !0 }) : this._root.focus();
    });
  }
  forwardToLast() {
    return l(this, null, function* () {
      const e = yield Xe(this);
      e ? e.focus({ focusVisible: !0 }) : this._root.focus();
    });
  }
  applyInitialFocus() {
    return l(this, null, function* () {
      yield this.applyFocus();
    });
  }
  applyFocus() {
    return l(this, null, function* () {
      yield this._waitForDomRef();
      const e = this.getRootNode().getElementById(this.initialFocus) || document.getElementById(this.initialFocus) || (yield ee(this)) || this._root;
      e && (e === this._root && (e.tabIndex = -1), e.focus({ focusVisible: !0 }));
    });
  }
  isOpen() {
    return this.opened;
  }
  isFocusWithin() {
    return Ke(this._root);
  }
  _open(e) {
    return l(this, null, function* () {
      var i;
      !this.fireEvent("before-open", {}, !0, !1) || (this.isModal && !this.shouldHideBackdrop && (this.getStaticAreaItemDomRef(), this._blockLayerHidden = !1, M.blockPageScrolling(this)), this._zIndex = Qe(), this.style.zIndex = ((i = this._zIndex) == null ? void 0 : i.toString()) || "", this._focusedElementBeforeOpen = ie(), this._show(), this._addOpenedPopup(), this.opened = !0, this.open = !0, yield Oe(), !this._disableInitialFocus && !e && (yield this.applyInitialFocus()), this.fireEvent("after-open", {}, !1, !1));
    });
  }
  _addOpenedPopup() {
    it(this);
  }
  close(e = !1, o = !1, i = !1) {
    !this.opened || !this.fireEvent("before-close", { escPressed: e }, !0, !1) || (this.isModal && (this._blockLayerHidden = !0, M.unblockPageScrolling(this)), this.hide(), this.opened = !1, this.open = !1, o || this._removeOpenedPopup(), !this.preventFocusRestore && !i && this.resetFocus(), this.fireEvent("after-close", {}, !1, !1));
  }
  _removeOpenedPopup() {
    st(this);
  }
  resetFocus() {
    !this._focusedElementBeforeOpen || (this._focusedElementBeforeOpen.focus({ focusVisible: !0 }), this._focusedElementBeforeOpen = null);
  }
  _show() {
    this.style.display = this._displayProp;
  }
  hide() {
    this.style.display = "none";
  }
  get _ariaLabel() {
    return Ae(this);
  }
  get _root() {
    return this.shadowRoot.querySelector(".ui5-popup-root");
  }
  get _role() {
    return this.accessibleRole === S.None ? void 0 : this.accessibleRole.toLowerCase();
  }
  get _ariaModal() {
    return this.accessibleRole === S.None ? void 0 : "true";
  }
  get contentDOM() {
    return this.shadowRoot.querySelector(".ui5-popup-content");
  }
  get styles() {
    return {
      root: {},
      content: {},
      blockLayer: {
        zIndex: this._zIndex ? this._zIndex - 1 : ""
      }
    };
  }
  get classes() {
    return {
      root: {
        "ui5-popup-root": !0,
        "ui5-content-native-scrollbars": Ye()
      },
      content: {
        "ui5-popup-content": !0
      }
    };
  }
};
_([
  c()
], d.prototype, "initialFocus", void 0);
_([
  c({ type: Boolean })
], d.prototype, "preventFocusRestore", void 0);
_([
  c({ type: Boolean })
], d.prototype, "open", void 0);
_([
  c({ type: Boolean, noAttribute: !0 })
], d.prototype, "opened", void 0);
_([
  c({ defaultValue: void 0 })
], d.prototype, "accessibleName", void 0);
_([
  c({ defaultValue: "" })
], d.prototype, "accessibleNameRef", void 0);
_([
  c({ type: S, defaultValue: S.Dialog })
], d.prototype, "accessibleRole", void 0);
_([
  c()
], d.prototype, "mediaRange", void 0);
_([
  c({ type: Boolean })
], d.prototype, "_disableInitialFocus", void 0);
_([
  c({ type: Boolean })
], d.prototype, "_blockLayerHidden", void 0);
_([
  c({ type: Boolean, noAttribute: !0 })
], d.prototype, "isTopModalPopup", void 0);
_([
  C({ type: HTMLElement, default: !0 })
], d.prototype, "content", void 0);
d = M = _([
  oe({
    renderer: ke,
    styles: rt,
    template: tt,
    staticAreaTemplate: ot,
    staticAreaStyles: lt
  }),
  z("before-open"),
  z("after-open"),
  z("before-close", {
    escPressed: { type: Boolean }
  }),
  z("after-close"),
  z("scroll")
], d);
const ht = d, pt = "resize-corner", re = "M384 224v32q0 12-10 22L182 470q-10 10-22 10h-32zM224 480l160-160v32q0 12-10 22l-96 96q-10 10-22 10h-32zm160-64v32q0 12-10 22t-22 10h-32z", ut = !1, _t = "SAP-icons-v4", ft = "@ui5/webcomponents-icons";
b(pt, { pathData: re, ltr: ut, collection: _t, packageName: ft });
const gt = "resize-corner", le = "M386.5 305q10-8 19-8 11 0 19 8 8 10 8 19t-8 19l-161 161q-10 8-19 8t-19-8q-8-8-8-18t8-20zm38-134q8 8 8 19 0 10-8 18l-296 296q-8 8-18 8-11 0-19-8-8-7-8-19 0-11 8-19l295-295q8-8 19-8 12 0 19 8z", mt = !1, bt = "SAP-icons-v5", vt = "@ui5/webcomponents-icons";
b(gt, { pathData: le, ltr: mt, collection: bt, packageName: vt });
E();
const ce = { key: "ICON_ERROR", defaultText: "Error" }, wt = "error", de = "M512 256q0 53-20.5 100t-55 81.5-81 54.5-99.5 20-100-20.5-81.5-55T20 355 0 256q0-54 20-100.5t55-81T156.5 20 256 0t99.5 20T437 75t55 81.5 20 99.5zM399 364q6-6 0-12l-86-86q-6-6 0-12l81-81q6-6 0-12l-37-37q-2-2-6-2t-6 2l-83 82q-1 3-6 3-3 0-6-3l-84-83q-1-2-6-2-4 0-6 2l-37 37q-6 6 0 12l83 82q6 6 0 12l-83 82q-2 2-2.5 6t2.5 6l36 37q4 2 6 2 4 0 6-2l85-84q2-2 6-2t6 2l88 88q4 2 6 2t6-2z", yt = !1, $t = ce, xt = "SAP-icons-v4", St = "@ui5/webcomponents-icons";
b(wt, { pathData: de, ltr: yt, accData: $t, collection: xt, packageName: St });
const Rt = "error", he = "M375 183q9-11 9-23 0-13-9-23-10-9-23-9-12 0-23 9l-73 74-73-74q-10-9-23-9-12 0-23 9-9 10-9 23 0 12 9 23l74 73-74 73q-9 10-9 23 0 12 9 23 11 9 23 9 13 0 23-9l73-74 73 74q11 9 23 9 13 0 23-9 9-11 9-23 0-13-9-23l-74-73zM256 512q-53 0-99.5-20T75 437t-55-81.5T0 256t20-99.5T75 75t81.5-55T256 0t99.5 20T437 75t55 81.5 20 99.5-20 99.5-55 81.5-81.5 55-99.5 20z", kt = !1, zt = ce, Mt = "SAP-icons-v5", Tt = "@ui5/webcomponents-icons";
b(Rt, { pathData: he, ltr: kt, accData: zt, collection: Mt, packageName: Tt });
E();
const Et = "alert", pe = "M501 374q5 10 7.5 19.5T512 412v5q0 31-23 47.5T439 481H74q-13 0-26-4.5T24.5 464t-17-20T1 417q-1-13 3-22.5t9-20.5L198 38q24-38 61-38t59 38zM257 127q-13 0-23.5 8T223 161q1 7 3 23 2 14 3.5 37t3.5 61q0 11 7.5 16t15.5 5q22 0 24-21l2-36 9-85q0-18-10.5-26t-23.5-8zm0 299q20 0 31.5-12t11.5-32q0-19-11.5-31T257 339t-31.5 12-11.5 31q0 20 11.5 32t31.5 12z", Dt = !1, Ht = "SAP-icons-v4", qt = "@ui5/webcomponents-icons";
b(Et, { pathData: pe, ltr: Dt, collection: Ht, packageName: qt });
const Lt = "alert", ue = "M200 34q9-17 24-25.5T256 0t32 8.5T312 34l192 353q8 13 8 30 0 25-18 44.5T448 481H64q-28 0-46-19.5T0 417q0-17 8-30zm88 119q0-13-9-22.5t-23-9.5-23 9.5-9 22.5v128q0 14 9 23.5t23 9.5 23-9.5 9-23.5V153zm6 238q0-16-11-27t-27-11-27 11-11 27q0 17 11 28t27 11 27-11 11-28z", Nt = !1, Pt = "SAP-icons-v5", Ft = "@ui5/webcomponents-icons";
b(Lt, { pathData: ue, ltr: Nt, collection: Pt, packageName: Ft });
E();
const Bt = "sys-enter-2", _e = "M512 256q0 54-20 100.5t-54.5 81T356 492t-100 20q-54 0-100.5-20t-81-55T20 355.5 0 256t20.5-100 55-81.5T157 20t99-20q53 0 100 20t81.5 54.5T492 156t20 100zm-118-87q4-8-1-13l-36-36q-3-4-8-4t-8 5L237 294q-3 1-4 0l-70-52q-4-3-7-3t-4.5 2-2.5 3l-29 41q-6 8 2 14l113 95q2 2 7 2t8-4z", Ot = !0, At = "SAP-icons-v4", Ct = "@ui5/webcomponents-icons";
b(Bt, { pathData: _e, ltr: Ot, collection: At, packageName: Ct });
const It = "sys-enter-2", fe = "M256 0q53 0 99.5 20T437 75t55 81.5 20 99.5-20 99.5-55 81.5-81.5 55-99.5 20-99.5-20T75 437t-55-81.5T0 256t20-99.5T75 75t81.5-55T256 0zM128 256q-14 0-23 9t-9 23q0 12 9 23l64 64q11 9 23 9 13 0 23-9l192-192q9-11 9-23 0-13-9.5-22.5T384 128q-12 0-23 9L192 307l-41-42q-10-9-23-9z", Wt = !0, Ut = "SAP-icons-v5", jt = "@ui5/webcomponents-icons";
b(It, { pathData: fe, ltr: Wt, collection: Ut, packageName: jt });
E();
const Xt = "information", ge = "M0 256q0-53 20.5-100t55-81.5T157 20t99-20q54 0 100.5 20t81 55 54.5 81.5 20 99.5q0 54-20 100.5t-54.5 81T356 492t-100 20q-54 0-100.5-20t-81-55T20 355.5 0 256zm192 112v33h128v-33h-32V215q0-6-7-6h-88v31h32v128h-33zm34-201q14 11 30 11 17 0 29.5-11.5T298 138q0-19-13-31-12-12-29-12-19 0-30.5 12.5T214 138q0 17 12 29z", Gt = !1, Vt = "SAP-icons-v4", Yt = "@ui5/webcomponents-icons";
b(Xt, { pathData: ge, ltr: Gt, collection: Vt, packageName: Yt });
const Zt = "information", me = "M256 0q53 0 99.5 20T437 75t55 81.5 20 99.5-20 99.5-55 81.5-81.5 55-99.5 20-99.5-20T75 437t-55-81.5T0 256t20-99.5T75 75t81.5-55T256 0zm38 140q0-16-11-27.5T256 101t-27 11.5-11 27.5 11 27 27 11 27-11 11-27zm-6 110q0-14-9-23t-23-9-23 9-9 23v128q0 13 9 22.5t23 9.5 23-9.5 9-22.5V250z", Kt = !1, Qt = "SAP-icons-v5", Jt = "@ui5/webcomponents-icons";
b(Zt, { pathData: me, ltr: Kt, collection: Qt, packageName: Jt });
E();
function eo(t, e, o) {
  return m`<section style="${T(this.styles.root)}" class="${N(this.classes.root)}" role="${p(this._role)}" aria-modal="${p(this._ariaModal)}" aria-label="${p(this._ariaLabel)}" aria-labelledby="${p(this._ariaLabelledBy)}" @keydown=${this._onkeydown} @focusout=${this._onfocusout} @mouseup=${this._onmouseup} @mousedown=${this._onmousedown}><span class="first-fe" data-ui5-focus-trap tabindex="0" @focusin=${this.forwardToLast}></span>${this._displayHeader ? to.call(this, t, e, o) : void 0}<div style="${T(this.styles.content)}" class="${N(this.classes.content)}"  @scroll="${this._scroll}" part="content"><slot></slot></div>${this.footer.length ? ao.call(this, t, e, o) : void 0}${this._showResizeHandle ? no.call(this, t, e, o) : void 0}<span class="last-fe" data-ui5-focus-trap tabindex="0" @focusin=${this.forwardToFirst}></span></section> `;
}
function to(t, e, o) {
  return m`<header class="ui5-popup-header-root" id="ui5-popup-header" tabindex="${p(this._headerTabIndex)}" @keydown="${this._onDragOrResizeKeyDown}" @mousedown="${this._onDragMouseDown}" part="header" state="${p(this.state)}">${this.hasValueState ? oo.call(this, t, e, o) : void 0}${this.header.length ? io.call(this, t, e, o) : so.call(this, t, e, o)}</header>`;
}
function oo(t, e, o) {
  return o ? m`<${L("ui5-icon", e, o)} class="ui5-dialog-value-state-icon" name="${p(this._dialogStateIcon)}"></${L("ui5-icon", e, o)}>` : m`<ui5-icon class="ui5-dialog-value-state-icon" name="${p(this._dialogStateIcon)}"></ui5-icon>`;
}
function io(t, e, o) {
  return m`<slot name="header"></slot>`;
}
function so(t, e, o) {
  return m`<h1 id="ui5-popup-header-text" class="ui5-popup-header-text">${p(this.headerText)}</h1>`;
}
function ao(t, e, o) {
  return m`<footer class="ui5-popup-footer-root" part="footer"><slot name="footer"></slot></footer>`;
}
function no(t, e, o) {
  return o ? m`<${L("ui5-icon", e, o)} name="resize-corner" class="ui5-popup-resize-handle" @mousedown="${this._onResizeMouseDown}"></${L("ui5-icon", e, o)}>` : m`<ui5-icon name="resize-corner" class="ui5-popup-resize-handle" @mousedown="${this._onResizeMouseDown}"></ui5-icon>`;
}
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const ro = { packageName: "@ui5/webcomponents", fileName: "themes/BrowserScrollbar.css", content: ":not(.ui5-content-native-scrollbars) ::-webkit-scrollbar:horizontal{height:var(--sapScrollBar_Dimension)}:not(.ui5-content-native-scrollbars) ::-webkit-scrollbar:vertical{width:var(--sapScrollBar_Dimension)}:not(.ui5-content-native-scrollbars) ::-webkit-scrollbar{background-color:var(--sapScrollBar_TrackColor);border-left:var(--browser_scrollbar_border)}:not(.ui5-content-native-scrollbars) ::-webkit-scrollbar-thumb{border-radius:var(--browser_scrollbar_border_radius);background-color:var(--sapScrollBar_FaceColor)}:not(.ui5-content-native-scrollbars) ::-webkit-scrollbar-thumb:hover{background-color:var(--sapScrollBar_Hover_FaceColor)}:not(.ui5-content-native-scrollbars) ::-webkit-scrollbar-corner{background-color:var(--sapScrollBar_TrackColor)}" };
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const lo = { packageName: "@ui5/webcomponents", fileName: "themes/PopupsCommon.css", content: ':host{display:none;position:fixed;background:var(--sapGroup_ContentBackground);box-shadow:var(--sapContent_Shadow2);border-radius:var(--_ui5_popup_border_radius);min-height:2rem;box-sizing:border-box}.ui5-popup-root{background:inherit;border-radius:inherit;width:100%;height:100%;box-sizing:border-box;display:flex;flex-direction:column;overflow:hidden;outline:none}.ui5-popup-root .ui5-popup-header-root{color:var(--sapPageHeader_TextColor);box-shadow:var(--sapContent_HeaderShadow);margin-bottom:.125rem}.ui5-popup-content{color:var(--sapTextColor)}.ui5-popup-footer-root{background:var(--sapPageFooter_Background);border-top:1px solid var(--sapPageFooter_BorderColor);color:var(--sapPageFooter_TextColor)}.ui5-popup-footer-root,.ui5-popup-header-root,:host([header-text]) .ui5-popup-header-text{margin:0;font-size:1rem;font-family:"72override",var(--_ui5_popup_header_font_family);display:flex;justify-content:center;align-items:center}.ui5-popup-header-root .ui5-popup-header-text{font-weight:var(--_ui5_popup_header_font_weight)}.ui5-popup-content{overflow:auto;box-sizing:border-box}:host([header-text]) .ui5-popup-header-text{text-align:center;min-height:var(--_ui5_popup_default_header_height);max-height:var(--_ui5_popup_default_header_height);line-height:var(--_ui5_popup_default_header_height);text-overflow:ellipsis;overflow:hidden;white-space:nowrap;max-width:100%;display:inline-block}:host([header-text]) .ui5-popup-header-root{justify-content:var(--_ui5_popup_header_prop_header_text_alignment)}:host(:not([header-text])) .ui5-popup-header-text{display:none}:host([disable-scrolling]) .ui5-popup-content{overflow:hidden}:host([media-range=S]) .ui5-popup-content{padding:1rem var(--_ui5_popup_content_padding_s)}:host([media-range=L]) .ui5-popup-content,:host([media-range=M]) .ui5-popup-content{padding:1rem var(--_ui5_popup_content_padding_m_l)}:host([media-range=XL]) .ui5-popup-content{padding:1rem var(--_ui5_popup_content_padding_xl)}.ui5-popup-header-root{background:var(--sapPageHeader_Background)}:host([media-range=S]) .ui5-popup-footer-root,:host([media-range=S]) .ui5-popup-header-root{padding-left:var(--_ui5_popup_header_footer_padding_s);padding-right:var(--_ui5_popup_header_footer_padding_s)}:host([media-range=L]) .ui5-popup-footer-root,:host([media-range=L]) .ui5-popup-header-root,:host([media-range=M]) .ui5-popup-footer-root,:host([media-range=M]) .ui5-popup-header-root{padding-left:var(--_ui5_popup_header_footer_padding_m_l);padding-right:var(--_ui5_popup_header_footer_padding_m_l)}:host([media-range=XL]) .ui5-popup-footer-root,:host([media-range=XL]) .ui5-popup-header-root{padding-left:var(--_ui5_popup_header_footer_padding_xl);padding-right:var(--_ui5_popup_header_footer_padding_xl)}' };
f("@ui5/webcomponents-theming", "sap_fiori_3", () => l(void 0, null, function* () {
  return R;
}));
f("@ui5/webcomponents", "sap_fiori_3", () => l(void 0, null, function* () {
  return k;
}));
const co = { packageName: "@ui5/webcomponents", fileName: "themes/Dialog.css", content: ':host{min-width:20rem;min-height:6rem;max-height:94%;max-width:90%;flex-direction:column;box-shadow:var(--sapContent_Shadow3);border-radius:var(--sapElement_BorderCornerRadius)}:host([stretch]){width:90%;height:94%}:host([stretch][on-phone]){width:100%;height:100%;max-height:100%;max-width:100%;border-radius:0}:host([draggable]) .ui5-popup-header-root,:host([draggable]) ::slotted([slot=header]){cursor:move}:host([draggable]) .ui5-popup-header-root *{cursor:auto}:host([draggable]) .ui5-popup-root{user-select:text}.ui5-popup-root{display:flex;flex-direction:column;max-width:100vw}.ui5-popup-header-root{position:relative}:host([state=Error]) .ui5-popup-header-root{box-shadow:var(--_ui5_dialog_header_error_state_box_shadow)}:host([state=Information]) .ui5-popup-header-root{box-shadow:var(--_ui5_dialog_header_information_state_box_shadow)}:host([state=Success]) .ui5-popup-header-root{box-shadow:var(--_ui5_dialog_header_success_state_box_shadow)}:host([state=Warning]) .ui5-popup-header-root{box-shadow:var(--_ui5_dialog_header_warning_state_box_shadow)}.ui5-dialog-value-state-icon{margin-inline-end:.5rem}:host([state=Error]) .ui5-dialog-value-state-icon{color:var(--_ui5_dialog_header_error_state_icon_color)}:host([state=Information]) .ui5-dialog-value-state-icon{color:var(--_ui5_dialog_header_information_state_icon_color)}:host([state=Success]) .ui5-dialog-value-state-icon{color:var(--_ui5_dialog_header_success_state_icon_color)}:host([state=Warning]) .ui5-dialog-value-state-icon{color:var(--_ui5_dialog_header_warning_state_icon_color)}.ui5-popup-header-root{outline:none}.ui5-popup-header-root:focus-visible:after{content:"";position:absolute;left:var(--_ui5_dialog_header_focus_left_offset);bottom:var(--_ui5_dialog_header_focus_bottom_offset);right:var(--_ui5_dialog_header_focus_right_offset);top:var(--_ui5_dialog_header_focus_top_offset);border:var(--sapContent_FocusWidth) var(--sapContent_FocusStyle) var(--sapContent_FocusColor);border-radius:var(--_ui5_dialog_header_border_radius) var(--_ui5_dialog_header_border_radius) 0 0;pointer-events:none}:host([stretch]) .ui5-popup-content{width:100%;height:100%}.ui5-popup-content{min-height:var(--_ui5_dialog_content_min_height);flex:1 1 auto}.ui5-popup-resize-handle{position:absolute;bottom:var(--_ui5_dialog_resize_handle_bottom);inset-inline-end:var(--_ui5_dialog_resize_handle_right);cursor:var(--_ui5_dialog_resize_cursor);color:var(--_ui5_dialog_resize_handle_color)}:host ::slotted([slot=footer]){height:var(--_ui5_dialog_footer_height)}:host ::slotted([slot=footer][ui5-bar][design=Footer]){border-top:none}' };
var v = globalThis && globalThis.__decorate || function(t, e, o, i) {
  var s = arguments.length, a = s < 3 ? e : i === null ? i = Object.getOwnPropertyDescriptor(e, o) : i, n;
  if (typeof Reflect == "object" && typeof Reflect.decorate == "function")
    a = Reflect.decorate(t, e, o, i);
  else
    for (var r = t.length - 1; r >= 0; r--)
      (n = t[r]) && (a = (s < 3 ? n(a) : s > 3 ? n(e, o, a) : n(e, o)) || a);
  return s > 3 && a && Object.defineProperty(e, o, a), a;
}, q;
const $ = 16, ho = {
  [y.Error]: "error",
  [y.Warning]: "alert",
  [y.Success]: "sys-enter-2",
  [y.Information]: "information"
};
let u = q = class be extends ht {
  constructor() {
    super(), this._revertSize = () => {
      Object.assign(this.style, {
        top: "",
        left: "",
        width: "",
        height: ""
      });
    }, this._screenResizeHandler = this._center.bind(this), this._dragMouseMoveHandler = this._onDragMouseMove.bind(this), this._dragMouseUpHandler = this._onDragMouseUp.bind(this), this._resizeMouseMoveHandler = this._onResizeMouseMove.bind(this), this._resizeMouseUpHandler = this._onResizeMouseUp.bind(this), this._dragStartHandler = this._handleDragStart.bind(this);
  }
  static _isHeader(e) {
    return e.classList.contains("ui5-popup-header-root") || e.getAttribute("slot") === "header";
  }
  show(e = !1) {
    return l(this, null, function* () {
      yield U(be.prototype, this, "_open").call(this, e);
    });
  }
  get isModal() {
    return !0;
  }
  get shouldHideBackdrop() {
    return !1;
  }
  get _ariaLabelledBy() {
    let e;
    return this.headerText !== "" && !this._ariaLabel && (e = "ui5-popup-header-text"), e;
  }
  get _displayProp() {
    return "flex";
  }
  get _displayHeader() {
    return this.header.length || this.headerText || this.draggable || this.resizable;
  }
  get _movable() {
    return !this.stretch && this.onDesktop && (this.draggable || this.resizable);
  }
  get _headerTabIndex() {
    return this._movable ? "0" : void 0;
  }
  get _showResizeHandle() {
    return this.resizable && this.onDesktop;
  }
  get _minHeight() {
    let e = Number.parseInt(window.getComputedStyle(this.contentDOM).minHeight);
    const o = this._root.querySelector(".ui5-popup-header-root");
    o && (e += o.offsetHeight);
    const i = this._root.querySelector(".ui5-popup-footer-root");
    return i && (e += i.offsetHeight), e;
  }
  get hasValueState() {
    return this.state !== y.None;
  }
  get _dialogStateIcon() {
    return ho[this.state];
  }
  get _role() {
    if (this.accessibleRole !== S.None)
      return this.state === y.Error || this.state === y.Warning ? S.AlertDialog.toLowerCase() : this.accessibleRole.toLowerCase();
  }
  _show() {
    super._show(), this._center();
  }
  onBeforeRendering() {
    super.onBeforeRendering(), this._isRTL = this.effectiveDir === "rtl", this.onPhone = $e(), this.onDesktop = xe();
  }
  onAfterRendering() {
    !this.isOpen() && this.open ? this.show() : this.isOpen() && !this.open && this.close();
  }
  onEnterDOM() {
    super.onEnterDOM(), this._attachScreenResizeHandler(), this.addEventListener("dragstart", this._dragStartHandler);
  }
  onExitDOM() {
    super.onExitDOM(), this._detachScreenResizeHandler(), this.removeEventListener("dragstart", this._dragStartHandler);
  }
  _resize() {
    super._resize(), this._screenResizeHandlerAttached && this._center();
  }
  _attachScreenResizeHandler() {
    this._screenResizeHandlerAttached || (window.addEventListener("resize", this._screenResizeHandler), this._screenResizeHandlerAttached = !0);
  }
  _detachScreenResizeHandler() {
    this._screenResizeHandlerAttached && (window.removeEventListener("resize", this._screenResizeHandler), this._screenResizeHandlerAttached = !1);
  }
  _center() {
    const e = window.innerHeight - this.offsetHeight, o = window.innerWidth - this.offsetWidth;
    Object.assign(this.style, {
      top: `${Math.round(e / 2)}px`,
      left: `${Math.round(o / 2)}px`
    });
  }
  _onDragMouseDown(e) {
    if (!this._movable || !this.draggable || !q._isHeader(e.target))
      return;
    e.preventDefault();
    const { top: o, left: i } = this.getBoundingClientRect(), { width: s, height: a } = window.getComputedStyle(this);
    Object.assign(this.style, {
      top: `${o}px`,
      left: `${i}px`,
      width: `${Math.round(Number.parseFloat(s) * 100) / 100}px`,
      height: `${Math.round(Number.parseFloat(a) * 100) / 100}px`
    }), this._x = e.clientX, this._y = e.clientY, this._attachMouseDragHandlers();
  }
  _onDragMouseMove(e) {
    e.preventDefault();
    const { clientX: o, clientY: i } = e, s = this._x - o, a = this._y - i, { left: n, top: r } = this.getBoundingClientRect();
    Object.assign(this.style, {
      left: `${Math.floor(n - s)}px`,
      top: `${Math.floor(r - a)}px`
    }), this._x = o, this._y = i;
  }
  _onDragMouseUp() {
    delete this._x, delete this._y, this._detachMouseDragHandlers();
  }
  _onDragOrResizeKeyDown(e) {
    if (!(!this._movable || !q._isHeader(e.target))) {
      if (this.draggable && [j, X, G, V].some((o) => o(e))) {
        this._dragWithEvent(e);
        return;
      }
      this.resizable && [Y, Z, K, Q].some((o) => o(e)) && this._resizeWithEvent(e);
    }
  }
  _dragWithEvent(e) {
    const { top: o, left: i, width: s, height: a } = this.getBoundingClientRect();
    let n = 0, r = "top";
    switch (!0) {
      case j(e):
        n = o - $, r = "top";
        break;
      case X(e):
        n = o + $, r = "top";
        break;
      case G(e):
        n = i - $, r = "left";
        break;
      case V(e):
        n = i + $, r = "left";
        break;
    }
    n = x(n, 0, r === "left" ? window.innerWidth - s : window.innerHeight - a), this.style[r] = `${n}px`;
  }
  _resizeWithEvent(e) {
    this._detachScreenResizeHandler(), this.addEventListener("ui5-before-close", this._revertSize, { once: !0 });
    const { top: o, left: i } = this.getBoundingClientRect(), s = window.getComputedStyle(this), a = Number.parseFloat(s.minWidth), n = window.innerWidth - i, r = window.innerHeight - o;
    let h = Number.parseFloat(s.width), w = Number.parseFloat(s.height);
    switch (!0) {
      case Y(e):
        w -= $;
        break;
      case Z(e):
        w += $;
        break;
      case K(e):
        h -= $;
        break;
      case Q(e):
        h += $;
        break;
    }
    h = x(h, a, n), w = x(w, this._minHeight, r), Object.assign(this.style, {
      width: `${h}px`,
      height: `${w}px`
    });
  }
  _attachMouseDragHandlers() {
    this._detachScreenResizeHandler(), window.addEventListener("mousemove", this._dragMouseMoveHandler), window.addEventListener("mouseup", this._dragMouseUpHandler);
  }
  _detachMouseDragHandlers() {
    window.removeEventListener("mousemove", this._dragMouseMoveHandler), window.removeEventListener("mouseup", this._dragMouseUpHandler);
  }
  _onResizeMouseDown(e) {
    if (!this._movable || !this.resizable)
      return;
    e.preventDefault();
    const { top: o, left: i } = this.getBoundingClientRect(), { width: s, height: a, minWidth: n } = window.getComputedStyle(this);
    this._initialX = e.clientX, this._initialY = e.clientY, this._initialWidth = Number.parseFloat(s), this._initialHeight = Number.parseFloat(a), this._initialTop = o, this._initialLeft = i, this._minWidth = Number.parseFloat(n), this._cachedMinHeight = this._minHeight, Object.assign(this.style, {
      top: `${o}px`,
      left: `${i}px`
    }), this._attachMouseResizeHandlers();
  }
  _onResizeMouseMove(e) {
    const { clientX: o, clientY: i } = e;
    let s, a;
    this._isRTL ? (s = x(this._initialWidth - (o - this._initialX), this._minWidth, this._initialLeft + this._initialWidth), a = x(this._initialLeft + (o - this._initialX), 0, this._initialX + this._initialWidth - this._minWidth)) : s = x(this._initialWidth + (o - this._initialX), this._minWidth, window.innerWidth - this._initialLeft);
    const n = x(this._initialHeight + (i - this._initialY), this._cachedMinHeight, window.innerHeight - this._initialTop);
    Object.assign(this.style, {
      height: `${n}px`,
      width: `${s}px`,
      left: a ? `${a}px` : void 0
    });
  }
  _onResizeMouseUp() {
    delete this._initialX, delete this._initialY, delete this._initialWidth, delete this._initialHeight, delete this._initialTop, delete this._initialLeft, delete this._minWidth, delete this._cachedMinHeight, this._detachMouseResizeHandlers();
  }
  _handleDragStart(e) {
    this.draggable && e.preventDefault();
  }
  _attachMouseResizeHandlers() {
    this._detachScreenResizeHandler(), window.addEventListener("mousemove", this._resizeMouseMoveHandler), window.addEventListener("mouseup", this._resizeMouseUpHandler), this.addEventListener("ui5-before-close", this._revertSize, { once: !0 });
  }
  _detachMouseResizeHandlers() {
    window.removeEventListener("mousemove", this._resizeMouseMoveHandler), window.removeEventListener("mouseup", this._resizeMouseUpHandler);
  }
};
v([
  c()
], u.prototype, "headerText", void 0);
v([
  c({ type: Boolean })
], u.prototype, "stretch", void 0);
v([
  c({ type: Boolean })
], u.prototype, "draggable", void 0);
v([
  c({ type: Boolean })
], u.prototype, "resizable", void 0);
v([
  c({ type: y, defaultValue: y.None })
], u.prototype, "state", void 0);
v([
  c({ type: Boolean })
], u.prototype, "onPhone", void 0);
v([
  c({ type: Boolean })
], u.prototype, "onDesktop", void 0);
v([
  C()
], u.prototype, "header", void 0);
v([
  C()
], u.prototype, "footer", void 0);
u = q = v([
  oe({
    tag: "ui5-dialog",
    template: eo,
    styles: [
      ro,
      lo,
      co
    ],
    dependencies: [
      Ee
    ]
  })
], u);
u.define();
const $o = u;
export {
  $o as default
};
//# sourceMappingURL=Dialog.e4ddb2a8.mjs.map
