var _e = Object.defineProperty, pe = Object.defineProperties;
var fe = Object.getOwnPropertyDescriptors;
var $ = Object.getOwnPropertySymbols;
var ue = Object.prototype.hasOwnProperty, Ce = Object.prototype.propertyIsEnumerable;
var z = (o, e, t) => e in o ? _e(o, e, { enumerable: !0, configurable: !0, writable: !0, value: t }) : o[e] = t, A = (o, e) => {
  for (var t in e || (e = {}))
    ue.call(e, t) && z(o, t, e[t]);
  if ($)
    for (var t of $(e))
      Ce.call(e, t) && z(o, t, e[t]);
  return o;
}, U = (o, e) => pe(o, fe(e));
var C = (o, e, t) => new Promise((a, r) => {
  var n = (l) => {
    try {
      i(t.next(l));
    } catch (_) {
      r(_);
    }
  }, s = (l) => {
    try {
      i(t.throw(l));
    } catch (_) {
      r(_);
    }
  }, i = (l) => l.done ? a(l.value) : Promise.resolve(l.value).then(n, s);
  i((t = t.apply(o, e)).next());
});
import { g, h as N, c as D, E as R, b as ge, d as he, e as Q, f as ee, i as te, j as Be, k as oe, l as me, m as Se, n as ve, o as be, p as ye, s as W, q as ke, t as Te, u as Ie, v as Ae, w as we, x as xe, y as He, z as Le, A as Ee, B as Fe, C as F, D as Pe, F as Me, G as Oe, H as Ne, Z as De, I as Re, J as je } from "./CxQtxSurveyButton.96c49aa8.mjs";
const Ve = () => new Promise((o) => {
  document.body ? o() : document.addEventListener("DOMContentLoaded", () => {
    o();
  });
}), $e = {
  packageName: "@ui5/webcomponents-base",
  fileName: "FontFace.css",
  content: `@font-face{font-family:"72";font-style:normal;font-weight:400;src:local("72"),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Regular.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:"72full";font-style:normal;font-weight:400;src:local('72-full'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Regular-full.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:"72";font-style:normal;font-weight:700;src:local('72-Bold'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Bold.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:"72full";font-style:normal;font-weight:700;src:local('72-Bold-full'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Bold-full.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:'72-Bold';font-style:normal;src:local('72-Bold'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Bold.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:'72-Boldfull';font-style:normal;src:url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Bold-full.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:'72-Light';font-style:normal;src:local('72-Light'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Light.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:'72-Lightfull';font-style:normal;src:url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_fiori_3/fonts/72-Light-full.woff2?ui5-webcomponents) format("woff2")}@font-face{font-family:"72Black";font-style:bold;font-weight:900;src:local('72Black'),url(https://sdk.openui5.org/resources/sap/ui/core/themes/sap_horizon/fonts/72-Black.woff2?ui5-webcomponents) format("woff2")}`
}, ze = {
  packageName: "@ui5/webcomponents-base",
  fileName: "OverrideFontFace.css",
  content: "@font-face{font-family:'72override';unicode-range:U+0102-0103,U+01A0-01A1,U+01AF-01B0,U+1EA0-1EB7,U+1EB8-1EC7,U+1EC8-1ECB,U+1ECC-1EE3,U+1EE4-1EF1,U+1EF4-1EF7;src:local('Arial'),local('Helvetica'),local('sans-serif')}"
}, Ue = () => {
  const o = g("OpenUI5Support");
  (!o || !o.isLoaded()) && We(), Ge();
}, We = () => {
  N("data-ui5-font-face") || D($e, "data-ui5-font-face");
}, Ge = () => {
  N("data-ui5-font-face-override") || D(ze, "data-ui5-font-face-override");
}, qe = {
  packageName: "@ui5/webcomponents-base",
  fileName: "SystemCSSVars.css",
  content: ":root{--_ui5_content_density:cozy}.sapUiSizeCompact,.ui5-content-density-compact,[data-ui5-compact-size]{--_ui5_content_density:compact}[dir=rtl]{--_ui5_dir:rtl}[dir=ltr]{--_ui5_dir:ltr}"
}, Ze = () => {
  N("data-ui5-system-css-vars") || D(qe, "data-ui5-system-css-vars");
};
let ae = !1, v;
const Je = new R(), Ke = () => C(void 0, null, function* () {
  if (v !== void 0)
    return v;
  const o = (e) => C(void 0, null, function* () {
    if (typeof document == "undefined") {
      e();
      return;
    }
    ge(Xe), he();
    const t = g("OpenUI5Support"), a = t ? t.isLoaded() : !1, r = g("F6Navigation");
    t && (yield t.init()), r && !a && r.init(), yield Ve(), yield Q(ee()), t && t.attachListeners(), Ue(), Ze(), e(), ae = !0, yield Je.fireEventAsync("boot");
  });
  return v = new Promise(o), v;
}), Xe = (o) => {
  const e = ee();
  ae && o === e && Q(e);
}, w = /* @__PURE__ */ new Map(), x = /* @__PURE__ */ new Map(), G = (o) => {
  if (!w.has(o)) {
    const e = Ye(o.split("-"));
    w.set(o, e);
  }
  return w.get(o);
}, re = (o) => {
  if (!x.has(o)) {
    const e = o.replace(/([a-z])([A-Z])/g, "$1-$2").toLowerCase();
    x.set(o, e);
  }
  return x.get(o);
}, Ye = (o) => o.map((e, t) => t === 0 ? e.toLowerCase() : e.charAt(0).toUpperCase() + e.slice(1).toLowerCase()).join(""), Qe = (o) => {
  if (!(o instanceof HTMLElement))
    return "default";
  const e = o.getAttribute("slot");
  if (e) {
    const t = e.match(/^(.+?)-\d+$/);
    return t ? t[1] : e;
  }
  return "default";
}, ne = (o) => o instanceof HTMLSlotElement ? o.assignedNodes({ flatten: !0 }).filter((e) => e instanceof HTMLElement) : [o], et = (o) => o.reduce((e, t) => e.concat(ne(t)), []);
class tt {
  constructor(e) {
    this.metadata = e;
  }
  getInitialState() {
    if (Object.prototype.hasOwnProperty.call(this, "_initialState"))
      return this._initialState;
    const e = {}, t = this.slotsAreManaged(), a = this.getProperties();
    for (const r in a) {
      const n = a[r].type, s = a[r].defaultValue;
      n === Boolean ? (e[r] = !1, s !== void 0 && console.warn("The 'defaultValue' metadata key is ignored for all booleans properties, they would be initialized with 'false' by default")) : a[r].multiple ? e[r] = [] : n === Object ? e[r] = "defaultValue" in a[r] ? a[r].defaultValue : {} : n === String ? e[r] = "defaultValue" in a[r] ? a[r].defaultValue : "" : e[r] = s;
    }
    if (t) {
      const r = this.getSlots();
      for (const [n, s] of Object.entries(r)) {
        const i = s.propertyName || n;
        e[i] = [];
      }
    }
    return this._initialState = e, e;
  }
  static validatePropertyValue(e, t) {
    return t.multiple && e ? e.map((r) => q(r, t)) : q(e, t);
  }
  static validateSlotValue(e, t) {
    return ot(e, t);
  }
  getPureTag() {
    return this.metadata.tag || "";
  }
  getTag() {
    const e = this.metadata.tag;
    if (!e)
      return "";
    const t = te(e);
    return t ? `${e}-${t}` : e;
  }
  hasAttribute(e) {
    const t = this.getProperties()[e];
    return t.type !== Object && !t.noAttribute && !t.multiple;
  }
  getPropertiesList() {
    return Object.keys(this.getProperties());
  }
  getAttributesList() {
    return this.getPropertiesList().filter(this.hasAttribute.bind(this)).map(re);
  }
  canSlotText() {
    const e = this.getSlots().default;
    return e && e.type === Node;
  }
  hasSlots() {
    return !!Object.entries(this.getSlots()).length;
  }
  hasIndividualSlots() {
    return this.slotsAreManaged() && Object.values(this.getSlots()).some((e) => e.individualSlots);
  }
  slotsAreManaged() {
    return !!this.metadata.managedSlots;
  }
  supportsF6FastNavigation() {
    return !!this.metadata.fastNavigation;
  }
  getProperties() {
    return this.metadata.properties || (this.metadata.properties = {}), this.metadata.properties;
  }
  getEvents() {
    return this.metadata.events || (this.metadata.events = {}), this.metadata.events;
  }
  getSlots() {
    return this.metadata.slots || (this.metadata.slots = {}), this.metadata.slots;
  }
  isLanguageAware() {
    return !!this.metadata.languageAware;
  }
  isThemeAware() {
    return !!this.metadata.themeAware;
  }
  shouldInvalidateOnChildChange(e, t, a) {
    const r = this.getSlots()[e].invalidateOnChildChange;
    if (r === void 0)
      return !1;
    if (typeof r == "boolean")
      return r;
    if (typeof r == "object") {
      if (t === "property") {
        if (r.properties === void 0)
          return !1;
        if (typeof r.properties == "boolean")
          return r.properties;
        if (Array.isArray(r.properties))
          return r.properties.includes(a);
        throw new Error("Wrong format for invalidateOnChildChange.properties: boolean or array is expected");
      }
      if (t === "slot") {
        if (r.slots === void 0)
          return !1;
        if (typeof r.slots == "boolean")
          return r.slots;
        if (Array.isArray(r.slots))
          return r.slots.includes(a);
        throw new Error("Wrong format for invalidateOnChildChange.slots: boolean or array is expected");
      }
    }
    throw new Error("Wrong format for invalidateOnChildChange: boolean or object is expected");
  }
}
const q = (o, e) => {
  const t = e.type;
  let a = e.validator;
  return t && t.isDataTypeClass && (a = t), a ? a.isValid(o) ? o : e.defaultValue : !t || t === String ? typeof o == "string" || typeof o == "undefined" || o === null ? o : o.toString() : t === Boolean ? typeof o == "boolean" ? o : !1 : t === Object ? typeof o == "object" ? o : e.defaultValue : o in t ? o : e.defaultValue;
}, ot = (o, e) => (o && ne(o).forEach((t) => {
  if (!(t instanceof e.type))
    throw new Error(`The element is not of type ${e.type.toString()}`);
}), o);
class at extends HTMLElement {
}
customElements.get("ui5-static-area") || customElements.define("ui5-static-area", at);
const rt = () => oe("CustomStyle.eventProvider", new R()), nt = "CustomCSSChange", j = (o) => {
  rt().attachEvent(nt, o);
}, st = () => oe("CustomStyle.customCSSFor", {});
j((o) => {
  Be({ tag: o });
});
const it = (o) => {
  const e = st();
  return e[o] ? e[o].join("") : "";
}, lt = 10, H = (o) => Array.isArray(o) ? o.filter((e) => !!e).flat(lt).map((e) => typeof e == "string" ? e : e.content).join(" ") : typeof o == "string" ? o : o.content, k = /* @__PURE__ */ new Map();
j((o) => {
  k.delete(`${o}_normal`);
});
const se = (o, e = !1) => {
  const t = o.getMetadata().getTag(), a = `${t}_${e ? "static" : "normal"}`, r = g("OpenUI5Enablement");
  if (!k.has(a)) {
    let n, s = "";
    if (r && (s = H(r.getBusyIndicatorStyles())), e)
      n = H(o.staticAreaStyles);
    else {
      const i = it(t) || "";
      n = `${H(o.styles)} ${i}`;
    }
    n = `${n} ${s}`, k.set(a, n);
  }
  return k.get(a);
}, T = /* @__PURE__ */ new Map();
j((o) => {
  T.delete(`${o}_normal`);
});
const dt = (o, e = !1) => {
  const a = `${o.getMetadata().getTag()}_${e ? "static" : "normal"}`;
  if (!T.has(a)) {
    const r = se(o, e), n = new CSSStyleSheet();
    n.replaceSync(r), T.set(a, [n]);
  }
  return T.get(a);
}, P = (o, e = !1) => {
  let t;
  const a = o.constructor, r = e ? o.staticAreaItem.shadowRoot : o.shadowRoot;
  let n;
  if (e ? n = o.renderStatic() : n = o.render(), !r) {
    console.warn("There is no shadow root to update");
    return;
  }
  if (document.adoptedStyleSheets ? r.adoptedStyleSheets = dt(a, e) : t = se(a, e), a.renderer) {
    a.renderer(n, r, t, e, { host: o });
    return;
  }
  a.render(n, r, t, e, { host: o });
}, ct = "--_ui5_content_density", _t = (o) => getComputedStyle(o).getPropertyValue(ct), pt = (o) => {
  const e = /\$([-a-z0-9A-Z._]+)(?::([^$]*))?\$/.exec(o);
  return e && e[2] ? e[2].split(/,/) : null;
}, ft = {
  iw: "he",
  ji: "yi",
  in: "id",
  sh: "sr"
}, ut = pt("$cldr-rtl-locales:ar,fa,he$") || [], Ct = (o) => (o = o && ft[o] || o, ut.indexOf(o) >= 0), gt = () => {
  if (typeof document == "undefined")
    return !1;
  const o = me();
  return o !== void 0 ? !!o : Ct(Se() || ve());
}, ht = "--_ui5_dir", Bt = (o) => {
  const e = window.document, t = ["ltr", "rtl"], a = getComputedStyle(o).getPropertyValue(ht);
  return t.includes(a) ? a : t.includes(o.dir) ? o.dir : t.includes(e.documentElement.dir) ? e.documentElement.dir : t.includes(e.body.dir) ? e.body.dir : gt() ? "rtl" : void 0;
}, ie = Bt, b = "ui5-static-area-item", mt = "data-sap-ui-integration-popup-content";
class m extends HTMLElement {
  constructor() {
    super(), this._rendered = !1, this.attachShadow({ mode: "open" });
  }
  setOwnerElement(e) {
    this.ownerElement = e, this.classList.add(this.ownerElement._id), this.ownerElement.hasAttribute("data-ui5-static-stable") && this.setAttribute("data-ui5-stable", this.ownerElement.getAttribute("data-ui5-static-stable"));
  }
  update() {
    this._rendered && (this._updateAdditionalAttrs(), this._updateContentDensity(), this._updateDirection(), P(this.ownerElement, !0));
  }
  _updateContentDensity() {
    _t(this.ownerElement) === "compact" ? (this.classList.add("sapUiSizeCompact"), this.classList.add("ui5-content-density-compact")) : (this.classList.remove("sapUiSizeCompact"), this.classList.remove("ui5-content-density-compact"));
  }
  _updateDirection() {
    if (this.ownerElement) {
      const e = ie(this.ownerElement);
      e ? this.setAttribute("dir", e) : this.removeAttribute("dir");
    }
  }
  _updateAdditionalAttrs() {
    this.setAttribute(b, ""), this.setAttribute(mt, "");
  }
  getDomRef() {
    return C(this, null, function* () {
      return this._updateContentDensity(), this._rendered || (this._rendered = !0, P(this.ownerElement, !0)), yield be(), this.shadowRoot;
    });
  }
  static getTag() {
    const e = te(b);
    return e ? `${b}-${e}` : b;
  }
  static createInstance() {
    return customElements.get(m.getTag()) || customElements.define(m.getTag(), m), document.createElement(this.getTag());
  }
}
const M = /* @__PURE__ */ new WeakMap(), St = (o, e, t) => {
  const a = new MutationObserver(e);
  M.set(o, a), a.observe(o, t);
}, vt = (o) => {
  const e = M.get(o);
  e && (e.disconnect(), M.delete(o));
}, bt = [
  "value-changed",
  "click"
];
let L;
const yt = (o) => bt.includes(o), kt = (o) => {
  const e = le();
  return !(typeof e != "boolean" && e.events && e.events.includes && e.events.includes(o));
}, le = () => (L === void 0 && (L = ye()), L), Tt = (o) => {
  const e = le();
  return yt(o) ? !1 : e === !0 ? !0 : !kt(o);
}, It = [
  "disabled",
  "title",
  "hidden",
  "role",
  "draggable"
], Z = (o) => It.includes(o) || o.startsWith("aria") ? !0 : ![
  HTMLElement,
  Element,
  Node
].some((t) => t.prototype.hasOwnProperty(o)), J = (o, e) => {
  if (o.length !== e.length)
    return !1;
  for (let t = 0; t < o.length; t++)
    if (o[t] !== e[t])
      return !1;
  return !0;
}, At = (o, e) => {
  const t = wt(e), a = ke();
  return o.call(e, e, t, a);
}, wt = (o) => {
  const e = o.constructor, t = e.getMetadata().getPureTag(), a = e.getUniqueDependencies().map((r) => r.getMetadata().getPureTag()).filter(W);
  return W(t) && a.push(t), a;
}, K = At;
let xt = 0;
const X = /* @__PURE__ */ new Map(), E = /* @__PURE__ */ new Map();
function B(o) {
  this._suppressInvalidation || (this.onInvalidation(o), this._changedState.push(o), Fe(this), this._eventProvider.fireEvent("invalidate", U(A({}, o), { target: this })));
}
class V extends HTMLElement {
  constructor() {
    super();
    const e = this.constructor;
    this._changedState = [], this._suppressInvalidation = !0, this._inDOM = !1, this._fullyConnected = !1, this._childChangeListeners = /* @__PURE__ */ new Map(), this._slotChangeListeners = /* @__PURE__ */ new Map(), this._eventProvider = new R();
    let t;
    this._domRefReadyPromise = new Promise((a) => {
      t = a;
    }), this._domRefReadyPromise._deferredResolve = t, this._doNotSyncAttributes = /* @__PURE__ */ new Set(), this._state = A({}, e.getMetadata().getInitialState()), this._upgradeAllProperties(), e._needsShadowDOM() && this.attachShadow({ mode: "open" });
  }
  get _id() {
    return this.__id || (this.__id = `ui5wc_${++xt}`), this.__id;
  }
  render() {
    const e = this.constructor.template;
    return K(e, this);
  }
  renderStatic() {
    const e = this.constructor.staticAreaTemplate;
    return K(e, this);
  }
  connectedCallback() {
    return C(this, null, function* () {
      const e = this.constructor;
      this.setAttribute(e.getMetadata().getPureTag(), ""), e.getMetadata().supportsF6FastNavigation() && this.setAttribute("data-sap-ui-fastnavgroup", "true");
      const t = e.getMetadata().slotsAreManaged();
      this._inDOM = !0, t && (this._startObservingDOMChildren(), yield this._processChildren()), this._inDOM && (Te(this), this._domRefReadyPromise._deferredResolve(), this._fullyConnected = !0, this.onEnterDOM());
    });
  }
  disconnectedCallback() {
    const t = this.constructor.getMetadata().slotsAreManaged();
    this._inDOM = !1, t && this._stopObservingDOMChildren(), this._fullyConnected && (this.onExitDOM(), this._fullyConnected = !1), this.staticAreaItem && this.staticAreaItem.parentElement && this.staticAreaItem.parentElement.removeChild(this.staticAreaItem), Ie(this);
  }
  onBeforeRendering() {
  }
  onAfterRendering() {
  }
  onEnterDOM() {
  }
  onExitDOM() {
  }
  _startObservingDOMChildren() {
    const e = this.constructor;
    if (!e.getMetadata().hasSlots())
      return;
    const a = e.getMetadata().canSlotText(), r = {
      childList: !0,
      subtree: a,
      characterData: a
    };
    St(this, this._processChildren.bind(this), r);
  }
  _stopObservingDOMChildren() {
    vt(this);
  }
  _processChildren() {
    return C(this, null, function* () {
      this.constructor.getMetadata().hasSlots() && (yield this._updateSlots());
    });
  }
  _updateSlots() {
    return C(this, null, function* () {
      const e = this.constructor, t = e.getMetadata().getSlots(), a = e.getMetadata().canSlotText(), r = Array.from(a ? this.childNodes : this.children), n = /* @__PURE__ */ new Map(), s = /* @__PURE__ */ new Map();
      for (const [d, p] of Object.entries(t)) {
        const c = p.propertyName || d;
        s.set(c, d), n.set(c, [...this._state[c]]), this._clearSlot(d, p);
      }
      const i = /* @__PURE__ */ new Map(), l = /* @__PURE__ */ new Map(), _ = r.map((d, p) => C(this, null, function* () {
        const c = Qe(d), h = t[c];
        if (h === void 0) {
          if (c !== "default") {
            const u = Object.keys(t).join(", ");
            console.warn(`Unknown slotName: ${c}, ignoring`, d, `Valid values are: ${u}`);
          }
          return;
        }
        if (h.individualSlots) {
          const u = (i.get(c) || 0) + 1;
          i.set(c, u), d._individualSlot = `${c}-${u}`;
        }
        if (d instanceof HTMLElement) {
          const u = d.localName;
          if (u.includes("-")) {
            if (!window.customElements.get(u)) {
              const de = window.customElements.whenDefined(u);
              let S = X.get(u);
              S || (S = new Promise((ce) => setTimeout(ce, 1e3)), X.set(u, S)), yield Promise.race([de, S]);
            }
            window.customElements.upgrade(d);
          }
        }
        if (d = e.getMetadata().constructor.validateSlotValue(d, h), Y(d) && h.invalidateOnChildChange) {
          const u = this._getChildChangeListener(c);
          u && d.attachInvalidate.call(d, u);
        }
        d instanceof HTMLSlotElement && this._attachSlotChange(d, c);
        const I = h.propertyName || c;
        l.has(I) ? l.get(I).push({ child: d, idx: p }) : l.set(I, [{ child: d, idx: p }]);
      }));
      yield Promise.all(_), l.forEach((d, p) => {
        this._state[p] = d.sort((c, h) => c.idx - h.idx).map((c) => c.child);
      });
      let f = !1;
      for (const [d, p] of Object.entries(t)) {
        const c = p.propertyName || d;
        J(n.get(c), this._state[c]) || (B.call(this, {
          type: "slot",
          name: s.get(c),
          reason: "children"
        }), f = !0);
      }
      f || B.call(this, {
        type: "slot",
        name: "default",
        reason: "textcontent"
      });
    });
  }
  _clearSlot(e, t) {
    const a = t.propertyName || e;
    this._state[a].forEach((n) => {
      if (Y(n)) {
        const s = this._getChildChangeListener(e);
        s && n.detachInvalidate.call(n, s);
      }
      n instanceof HTMLSlotElement && this._detachSlotChange(n, e);
    }), this._state[a] = [];
  }
  attachInvalidate(e) {
    this._eventProvider.attachEvent("invalidate", e);
  }
  detachInvalidate(e) {
    this._eventProvider.detachEvent("invalidate", e);
  }
  _onChildChange(e, t) {
    !this.constructor.getMetadata().shouldInvalidateOnChildChange(e, t.type, t.name) || B.call(this, {
      type: "slot",
      name: e,
      reason: "childchange",
      child: t.target
    });
  }
  attributeChangedCallback(e, t, a) {
    let r;
    if (this._doNotSyncAttributes.has(e))
      return;
    const n = this.constructor.getMetadata().getProperties(), s = e.replace(/^ui5-/, ""), i = G(s);
    if (n.hasOwnProperty(i)) {
      const l = n[i], _ = l.type;
      let f = l.validator;
      _ && _.isDataTypeClass && (f = _), f ? r = f.attributeToProperty(a) : _ === Boolean ? r = a !== null : r = a, this[i] = r;
    }
  }
  _updateAttribute(e, t) {
    const a = this.constructor;
    if (!a.getMetadata().hasAttribute(e))
      return;
    const n = a.getMetadata().getProperties()[e], s = n.type;
    let i = n.validator;
    const l = re(e), _ = this.getAttribute(l);
    if (s && s.isDataTypeClass && (i = s), i) {
      const f = i.propertyToAttribute(t);
      f === null ? (this._doNotSyncAttributes.add(l), this.removeAttribute(l), this._doNotSyncAttributes.delete(l)) : this.setAttribute(l, f);
    } else
      s === Boolean ? t === !0 && _ === null ? this.setAttribute(l, "") : t === !1 && _ !== null && this.removeAttribute(l) : typeof t != "object" && _ !== t && this.setAttribute(l, t);
  }
  _upgradeProperty(e) {
    if (this.hasOwnProperty(e)) {
      const t = this[e];
      delete this[e], this[e] = t;
    }
  }
  _upgradeAllProperties() {
    this.constructor.getMetadata().getPropertiesList().forEach(this._upgradeProperty.bind(this));
  }
  _getChildChangeListener(e) {
    return this._childChangeListeners.has(e) || this._childChangeListeners.set(e, this._onChildChange.bind(this, e)), this._childChangeListeners.get(e);
  }
  _getSlotChangeListener(e) {
    return this._slotChangeListeners.has(e) || this._slotChangeListeners.set(e, this._onSlotChange.bind(this, e)), this._slotChangeListeners.get(e);
  }
  _attachSlotChange(e, t) {
    const a = this._getSlotChangeListener(t);
    a && e.addEventListener("slotchange", a);
  }
  _detachSlotChange(e, t) {
    e.removeEventListener("slotchange", this._getSlotChangeListener(t));
  }
  _onSlotChange(e) {
    B.call(this, {
      type: "slot",
      name: e,
      reason: "slotchange"
    });
  }
  onInvalidation(e) {
  }
  _render() {
    const e = this.constructor, t = e.getMetadata().hasIndividualSlots();
    this._suppressInvalidation = !0, this.onBeforeRendering(), this._onComponentStateFinalized && this._onComponentStateFinalized(), this._suppressInvalidation = !1, this._changedState = [], e._needsShadowDOM() && P(this), this.staticAreaItem && this.staticAreaItem.update(), t && this._assignIndividualSlotsToChildren(), this.onAfterRendering();
  }
  _assignIndividualSlotsToChildren() {
    Array.from(this.children).forEach((t) => {
      t._individualSlot && t.setAttribute("slot", t._individualSlot);
    });
  }
  _waitForDomRef() {
    return this._domRefReadyPromise;
  }
  getDomRef() {
    if (typeof this._getRealDomRef == "function")
      return this._getRealDomRef();
    if (!this.shadowRoot || this.shadowRoot.children.length === 0)
      return;
    const e = [...this.shadowRoot.children].filter((t) => !["link", "style"].includes(t.localName));
    return e.length !== 1 && console.warn(`The shadow DOM for ${this.constructor.getMetadata().getTag()} does not have a top level element, the getDomRef() method might not work as expected`), e[0];
  }
  getFocusDomRef() {
    const e = this.getDomRef();
    if (e)
      return e.querySelector("[data-sap-focus-ref]") || e;
  }
  getFocusDomRefAsync() {
    return C(this, null, function* () {
      return yield this._waitForDomRef(), this.getFocusDomRef();
    });
  }
  focus(e) {
    return C(this, null, function* () {
      yield this._waitForDomRef();
      const t = this.getFocusDomRef();
      t && typeof t.focus == "function" && t.focus(e);
    });
  }
  fireEvent(e, t, a = !1, r = !0) {
    const n = this._fireEvent(e, t, a, r), s = G(e);
    return s !== e ? n && this._fireEvent(s, t, a) : n;
  }
  _fireEvent(e, t, a = !1, r = !0) {
    const n = new CustomEvent(`ui5-${e}`, {
      detail: t,
      composed: !1,
      bubbles: r,
      cancelable: a
    }), s = this.dispatchEvent(n);
    if (Tt(e))
      return s;
    const i = new CustomEvent(e, {
      detail: t,
      composed: !1,
      bubbles: r,
      cancelable: a
    });
    return this.dispatchEvent(i) && s;
  }
  getSlottedNodes(e) {
    return et(this[e]);
  }
  get effectiveDir() {
    return Ae(this.constructor), ie(this);
  }
  get isUI5Element() {
    return !0;
  }
  get classes() {
    return {};
  }
  static get observedAttributes() {
    return this.getMetadata().getAttributesList();
  }
  static _needsShadowDOM() {
    return !!this.template || Object.prototype.hasOwnProperty.call(this.prototype, "render");
  }
  static _needsStaticArea() {
    return !!this.staticAreaTemplate || Object.prototype.hasOwnProperty.call(this.prototype, "renderStatic");
  }
  getStaticAreaItemDomRef() {
    if (!this.constructor._needsStaticArea())
      throw new Error("This component does not use the static area");
    return this.staticAreaItem || (this.staticAreaItem = m.createInstance(), this.staticAreaItem.setOwnerElement(this)), this.staticAreaItem.parentElement || we("ui5-static-area").appendChild(this.staticAreaItem), this.staticAreaItem.getDomRef();
  }
  static _generateAccessors() {
    const e = this.prototype, t = this.getMetadata().slotsAreManaged(), a = this.getMetadata().getProperties();
    for (const [r, n] of Object.entries(a)) {
      if (Z(r) || console.warn(`"${r}" is not a valid property name. Use a name that does not collide with DOM APIs`), n.type === Boolean && n.defaultValue)
        throw new Error(`Cannot set a default value for property "${r}". All booleans are false by default.`);
      if (n.type === Array)
        throw new Error(`Wrong type for property "${r}". Properties cannot be of type Array - use "multiple: true" and set "type" to the single value type, such as "String", "Object", etc...`);
      if (n.type === Object && n.defaultValue)
        throw new Error(`Cannot set a default value for property "${r}". All properties of type "Object" are empty objects by default.`);
      if (n.multiple && n.defaultValue)
        throw new Error(`Cannot set a default value for property "${r}". All multiple properties are empty arrays by default.`);
      Object.defineProperty(e, r, {
        get() {
          if (this._state[r] !== void 0)
            return this._state[r];
          const s = n.defaultValue;
          return n.type === Boolean ? !1 : n.type === String ? s : n.multiple ? [] : s;
        },
        set(s) {
          let i;
          s = this.constructor.getMetadata().constructor.validatePropertyValue(s, n);
          const f = n.type;
          let d = n.validator;
          const p = this._state[r];
          f && f.isDataTypeClass && (d = f), d ? i = !d.valuesAreEqual(p, s) : Array.isArray(p) && Array.isArray(s) && n.multiple && n.compareValues ? i = !J(p, s) : i = p !== s, i && (this._state[r] = s, B.call(this, {
            type: "property",
            name: r,
            newValue: s,
            oldValue: p
          }), this._updateAttribute(r, s));
        }
      });
    }
    if (t) {
      const r = this.getMetadata().getSlots();
      for (const [n, s] of Object.entries(r)) {
        Z(n) || console.warn(`"${n}" is not a valid property name. Use a name that does not collide with DOM APIs`);
        const i = s.propertyName || n;
        Object.defineProperty(e, i, {
          get() {
            return this._state[i] !== void 0 ? this._state[i] : [];
          },
          set() {
            throw new Error("Cannot set slot content directly, use the DOM APIs (appendChild, removeChild, etc...)");
          }
        });
      }
    }
  }
  static get styles() {
    return "";
  }
  static get staticAreaStyles() {
    return "";
  }
  static get dependencies() {
    return [];
  }
  static getUniqueDependencies() {
    if (!E.has(this)) {
      const e = this.dependencies.filter((t, a, r) => r.indexOf(t) === a);
      E.set(this, e);
    }
    return E.get(this) || [];
  }
  static whenDependenciesDefined() {
    return Promise.all(this.getUniqueDependencies().map((e) => e.define()));
  }
  static onDefine() {
    return C(this, null, function* () {
      return Promise.resolve();
    });
  }
  static define() {
    return C(this, null, function* () {
      yield Ke(), yield Promise.all([
        this.whenDependenciesDefined(),
        this.onDefine()
      ]);
      const e = this.getMetadata().getTag(), t = xe(e), a = customElements.get(e);
      return a && !t ? He(e) : a || (this._generateAccessors(), Le(e), window.customElements.define(e, this)), this;
    });
  }
  static getMetadata() {
    if (this.hasOwnProperty("_metadata"))
      return this._metadata;
    const e = [this.metadata];
    let t = this;
    for (; t !== V; )
      t = Object.getPrototypeOf(t), e.unshift(t.metadata);
    const a = Ee({}, ...e);
    return this._metadata = new tt(a), this._metadata;
  }
}
V.metadata = {};
const Y = (o) => "isUI5Element" in o, Pt = (o) => (e) => {
  if (Object.prototype.hasOwnProperty.call(e, "metadata") || (e.metadata = {}), typeof o == "string") {
    e.metadata.tag = o;
    return;
  }
  const { tag: t, languageAware: a, themeAware: r, fastNavigation: n } = o;
  e.metadata.tag = t, a && (e.metadata.languageAware = a), r && (e.metadata.themeAware = r), n && (e.metadata.fastNavigation = n), ["render", "renderer", "template", "staticAreaTemplate", "styles", "staticAreaStyles", "dependencies"].forEach((s) => {
    const l = o[s === "render" ? "renderer" : s];
    l && Object.defineProperty(e, s, {
      get: () => l
    });
  });
}, Mt = (o) => (e, t) => {
  const a = e.constructor;
  Object.prototype.hasOwnProperty.call(a, "metadata") || (a.metadata = {});
  const r = a.metadata;
  r.properties || (r.properties = {});
  const n = r.properties;
  n[t] || (n[t] = o || { type: String });
};
/**
 * @license
 * Copyright 2018 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const Ot = (o) => o != null ? o : F;
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
class O extends Pe {
  constructor(e) {
    if (super(e), this.it = F, e.type !== Me.CHILD)
      throw Error(this.constructor.directiveName + "() can only be used in child bindings");
  }
  render(e) {
    if (e === F || e == null)
      return this._t = void 0, this.it = e;
    if (e === Oe)
      return e;
    if (typeof e != "string")
      throw Error(this.constructor.directiveName + "() called with a non-string value");
    if (e === this.it)
      return this._t;
    this.it = e;
    const t = [e];
    return t.raw = t, this._t = { _$litType$: this.constructor.resultType, strings: t, values: [] };
  }
}
O.directiveName = "unsafeHTML", O.resultType = 1;
const Nt = Ne(O), y = (o, ...e) => {
  const t = g("LitStatic");
  return (t ? t.html : Re)(o, ...e);
}, Dt = (o, ...e) => {
  const t = g("LitStatic");
  return (t ? t.svg : je)(o, ...e);
}, Rt = (o, e, t, a, r) => {
  const n = g("OpenUI5Enablement");
  n && !a && (o = n.wrapTemplateResultInBusyMarkup(y, r.host, o)), typeof t == "string" ? o = y`<style>${t}</style>${o}` : Array.isArray(t) && t.length && (o = y`${t.map((s) => y`<link type="text/css" rel="stylesheet" href="${s}">`)}${o}`), De(o, e, r);
}, jt = (o, e, t) => {
  const a = g("LitStatic");
  if (a)
    return a.unsafeStatic((e || []).includes(o) ? `${o}-${t}` : o);
}, Vt = { packageName: "@ui5/webcomponents-theming", fileName: "themes/sap_fiori_3/parameters-bundle.css", content: ':root{--sapThemeMetaData-Base-baseLib:{"Path":"Base.baseLib.sap_fiori_3.css_variables","PathPattern":"/%frameworkId%/%libId%/%themeId%/%fileId%.css","Extends":["sap_base_fiori","baseTheme"],"Tags":["Fiori_3","LightColorScheme"],"FallbackThemeId":"sap_belize","Engine":{"Name":"theming-engine","Version":"1.23030.0-20230404052500+08ab7f203f968a8915a46326f198b28734934650"},"Version":{ "Build":"11.3.2.20230406131255","Source":"11.3.2"}};--sapBrandColor:#0a6ed1;--sapHighlightColor:#0854a0;--sapBaseColor:#fff;--sapShellColor:#354a5f;--sapBackgroundColor:#f7f7f7;--sapFontFamily:"72","72full",Arial,Helvetica,sans-serif;--sapFontSize:.875rem;--sapTextColor:#32363a;--sapLinkColor:#0a6ed1;--sapCompanyLogo:none;--sapBackgroundImage:none;--sapBackgroundImageOpacity:1.0;--sapBackgroundImageRepeat:false;--sapSelectedColor:#0854a0;--sapHoverColor:#ededed;--sapActiveColor:#0854a0;--sapHighlightTextColor:#fff;--sapTitleColor:#32363a;--sapNegativeColor:#b00;--sapCriticalColor:#df6e0c;--sapPositiveColor:#107e3e;--sapInformativeColor:#0a6ed1;--sapNeutralColor:#6a6d70;--sapNegativeElementColor:#b00;--sapCriticalElementColor:#df6e0c;--sapPositiveElementColor:#107e3e;--sapInformativeElementColor:#0a6ed1;--sapNeutralElementColor:#6a6d70;--sapNegativeTextColor:#b00;--sapCriticalTextColor:#b3590a;--sapPositiveTextColor:#107e3e;--sapInformativeTextColor:#0a6ed1;--sapNeutralTextColor:#6a6d70;--sapErrorColor:#b00;--sapWarningColor:#df6e0c;--sapSuccessColor:#107e3e;--sapInformationColor:#0a6ed1;--sapErrorBackground:#ffebeb;--sapWarningBackground:#fef7f1;--sapSuccessBackground:#f1fdf6;--sapInformationBackground:#f5faff;--sapNeutralBackground:#f4f4f4;--sapErrorBorderColor:#b00;--sapWarningBorderColor:#df6e0c;--sapSuccessBorderColor:#107e3e;--sapInformationBorderColor:#0a6ed1;--sapNeutralBorderColor:#6a6d70;--sapElement_LineHeight:2.75rem;--sapElement_Height:2.25rem;--sapElement_BorderWidth:.0625rem;--sapElement_BorderCornerRadius:.25rem;--sapElement_Compact_LineHeight:2rem;--sapElement_Compact_Height:1.625rem;--sapElement_Condensed_LineHeight:1.5rem;--sapElement_Condensed_Height:1.375rem;--sapContent_LineHeight:1.4;--sapContent_IconHeight:1rem;--sapContent_IconColor:#0854a0;--sapContent_ContrastIconColor:#fff;--sapContent_NonInteractiveIconColor:#6a6d70;--sapContent_MarkerIconColor:#286eb4;--sapContent_MarkerTextColor:#0e7581;--sapContent_MeasureIndicatorColor:#89919a;--sapContent_Selected_MeasureIndicatorColor:#89919a;--sapContent_Placeholderloading_Background:#ccc;--sapContent_Placeholderloading_Gradient:linear-gradient(90deg,#ccc 0%,#ccc 20%,#999 50%,#ccc 80%,#ccc);--sapContent_ImagePlaceholderBackground:#ccc;--sapContent_ImagePlaceholderForegroundColor:#fff;--sapContent_RatedColor:#d08014;--sapContent_UnratedColor:#89919a;--sapContent_BusyColor:#0854a0;--sapContent_FocusColor:#000;--sapContent_FocusStyle:dotted;--sapContent_FocusWidth:.0625rem;--sapContent_ContrastFocusColor:#fff;--sapContent_ShadowColor:#000;--sapContent_ContrastShadowColor:#fff;--sapContent_Shadow0:0 0 0 0.0625rem rgba(0,0,0,0.1),0 0.125rem 0.5rem 0 rgba(0,0,0,0.1);--sapContent_Shadow1:0 0 0 0.0625rem rgba(0,0,0,0.42),0 0.125rem 0.5rem 0 rgba(0,0,0,0.3);--sapContent_Shadow2:0 0 0 0.0625rem rgba(0,0,0,0.42),0 0.625rem 1.875rem 0 rgba(0,0,0,0.3);--sapContent_Shadow3:0 0 0 0.0625rem rgba(0,0,0,0.42),0 1.25rem 5rem 0 rgba(0,0,0,0.3);--sapContent_TextShadow:0 0 0.125rem #fff;--sapContent_ContrastTextShadow:0 0 0.0625rem rgba(0,0,0,0.7);--sapContent_HeaderShadow:0 0.125rem 0.125rem 0 rgba(0,0,0,0.05),inset 0 -0.0625rem 0 0 #d9d9d9;--sapContent_Interaction_Shadow:none;--sapContent_Selected_Shadow:none;--sapContent_Negative_Shadow:none;--sapContent_Critical_Shadow:none;--sapContent_Positive_Shadow:none;--sapContent_Informative_Shadow:none;--sapContent_Neutral_Shadow:none;--sapContent_SearchHighlightColor:#d4f7db;--sapContent_HelpColor:#3f8600;--sapContent_LabelColor:#6a6d70;--sapContent_MonospaceFontFamily:"72Mono","72Monofull",lucida console,monospace;--sapContent_MonospaceBoldFontFamily:"72Mono-Bold","72Mono-Boldfull",lucida console,monospace;--sapContent_IconFontFamily:"SAP-icons";--sapContent_DisabledTextColor:rgba(50,54,58,0.6);--sapContent_DisabledOpacity:0.4;--sapContent_ContrastTextThreshold:0.65;--sapContent_ContrastTextColor:#fff;--sapContent_ForegroundColor:#efefef;--sapContent_ForegroundBorderColor:#89919a;--sapContent_ForegroundTextColor:#32363a;--sapContent_BadgeBackground:#d04343;--sapContent_BadgeTextColor:#fff;--sapContent_DragAndDropActiveColor:#0854a0;--sapContent_Selected_TextColor:#fff;--sapContent_Selected_Background:#0854a0;--sapContent_Selected_Hover_Background:#095caf;--sapContent_Selected_ForegroundColor:#0854a0;--sapContent_ForcedColorAdjust:none;--sapContent_Illustrative_Color1:#0a6ed1;--sapContent_Illustrative_Color2:#72b5f8;--sapContent_Illustrative_Color3:#ffba10;--sapContent_Illustrative_Color4:#4a5055;--sapContent_Illustrative_Color5:#9da4aa;--sapContent_Illustrative_Color6:#c6cace;--sapContent_Illustrative_Color7:#e7e9ea;--sapContent_Illustrative_Color8:#fff;--sapContent_Illustrative_Color9:#64edd2;--sapContent_Illustrative_Color10:#e7e9ea;--sapContent_Illustrative_Color11:#f31ded;--sapContent_Illustrative_Color12:#5dc122;--sapContent_Illustrative_Color13:#4ba1f6;--sapContent_Illustrative_Color14:#298ff4;--sapContent_Illustrative_Color15:#e6a400;--sapContent_Illustrative_Color16:#085aaa;--sapContent_Illustrative_Color17:#00a5a8;--sapContent_Illustrative_Color18:#d9ddde;--sapContent_Illustrative_Color19:#ccd0d2;--sapContent_Illustrative_Color20:#bec4c6;--sapFontLightFamily:"72-Light","72-Lightfull","72","72full",Arial,Helvetica,sans-serif;--sapFontBoldFamily:"72-Bold","72-Boldfull","72","72full",Arial,Helvetica,sans-serif;--sapFontSemiboldFamily:"72-Semibold","72-Semiboldfull","72","72full",Arial,Helvetica,sans-serif;--sapFontSemiboldDuplexFamily:"72-SemiboldDuplex","72-SemiboldDuplexfull","72","72full",Arial,Helvetica,sans-serif;--sapFontBlackFamily:"72Black","72Blackfull","72","72full",Arial,Helvetica,sans-serif;--sapFontHeaderFamily:"72","72full",Arial,Helvetica,sans-serif;--sapFontSmallSize:.75rem;--sapFontLargeSize:1rem;--sapFontHeader1Size:2.25rem;--sapFontHeader2Size:1.5rem;--sapFontHeader3Size:1.25rem;--sapFontHeader4Size:1.125rem;--sapFontHeader5Size:1rem;--sapFontHeader6Size:.875rem;--sapLink_TextDecoration:none;--sapLink_Hover_Color:#0854a0;--sapLink_Hover_TextDecoration:underline;--sapLink_Active_Color:#0a6ed1;--sapLink_Active_TextDecoration:underline;--sapLink_Visited_Color:#0a6ed1;--sapLink_InvertedColor:#d3e8fd;--sapLink_SubtleColor:#074888;--sapShell_Background:#edeff0;--sapShell_BackgroundImage:linear-gradient(180deg,#dfe3e4,#f3f4f5);--sapShell_BackgroundImageOpacity:1.0;--sapShell_BackgroundImageRepeat:false;--sapShell_BorderColor:#354a5f;--sapShell_TextColor:#fff;--sapShell_InteractiveBackground:#354a5f;--sapShell_InteractiveTextColor:#d1e8ff;--sapShell_InteractiveBorderColor:#7996b4;--sapShell_GroupTitleTextColor:#32363a;--sapShell_GroupTitleTextShadow:0 0 0.125rem #fff;--sapShell_Hover_Background:#283848;--sapShell_Active_Background:#23303e;--sapShell_Active_TextColor:#fff;--sapShell_Selected_Background:#23303e;--sapShell_Selected_TextColor:#fff;--sapShell_Selected_Hover_Background:#23303e;--sapShell_Favicon:none;--sapShell_Navigation_Background:#354a5f;--sapShell_Navigation_Hover_Background:#283848;--sapShell_Navigation_SelectedColor:#d1e8ff;--sapShell_Navigation_Selected_TextColor:#d1e8ff;--sapShell_Navigation_TextColor:#fff;--sapShell_Navigation_Active_TextColor:#fff;--sapShell_Navigation_Active_Background:#23303e;--sapShell_Shadow:0 0.125rem 0.125rem 0 rgba(0,0,0,0.08),inset 0 -0.0625rem 0 0 rgba(0,0,0,0.18);--sapShell_NegativeColor:#f88;--sapShell_CriticalColor:#f8b67d;--sapShell_PositiveColor:#abe2c2;--sapShell_InformativeColor:#b1d6fb;--sapShell_NeutralColor:#d4d6d7;--sapShell_Category_1_Background:#286eb4;--sapShell_Category_1_BorderColor:#286eb4;--sapShell_Category_1_TextColor:#fff;--sapShell_Category_1_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_2_Background:#db1f77;--sapShell_Category_2_BorderColor:#db1f77;--sapShell_Category_2_TextColor:#fff;--sapShell_Category_2_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_3_Background:#d58215;--sapShell_Category_3_BorderColor:#d58215;--sapShell_Category_3_TextColor:#fff;--sapShell_Category_3_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_4_Background:#892971;--sapShell_Category_4_BorderColor:#892971;--sapShell_Category_4_TextColor:#fff;--sapShell_Category_4_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_5_Background:#bb2f2f;--sapShell_Category_5_BorderColor:#bb2f2f;--sapShell_Category_5_TextColor:#fff;--sapShell_Category_5_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_6_Background:#1193a2;--sapShell_Category_6_BorderColor:#1193a2;--sapShell_Category_6_TextColor:#fff;--sapShell_Category_6_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_7_Background:#cf5db3;--sapShell_Category_7_BorderColor:#cf5db3;--sapShell_Category_7_TextColor:#fff;--sapShell_Category_7_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_8_Background:#8b9668;--sapShell_Category_8_BorderColor:#8b9668;--sapShell_Category_8_TextColor:#fff;--sapShell_Category_8_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_9_Background:#597da1;--sapShell_Category_9_BorderColor:#597da1;--sapShell_Category_9_TextColor:#fff;--sapShell_Category_9_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_10_Background:#647987;--sapShell_Category_10_BorderColor:#647987;--sapShell_Category_10_TextColor:#fff;--sapShell_Category_10_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_11_Background:#dc5b5b;--sapShell_Category_11_BorderColor:#dc5b5b;--sapShell_Category_11_TextColor:#fff;--sapShell_Category_11_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_12_Background:#5154bd;--sapShell_Category_12_BorderColor:#5154bd;--sapShell_Category_12_TextColor:#fff;--sapShell_Category_12_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_13_Background:#bc1b66;--sapShell_Category_13_BorderColor:#bc1b66;--sapShell_Category_13_TextColor:#fff;--sapShell_Category_13_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_14_Background:#49797e;--sapShell_Category_14_BorderColor:#49797e;--sapShell_Category_14_TextColor:#fff;--sapShell_Category_14_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_15_Background:#476380;--sapShell_Category_15_BorderColor:#476380;--sapShell_Category_15_TextColor:#fff;--sapShell_Category_15_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapShell_Category_16_Background:#687a33;--sapShell_Category_16_BorderColor:#687a33;--sapShell_Category_16_TextColor:#fff;--sapShell_Category_16_TextShadow:0 0 .0625rem rgba(0,0,0,0.7);--sapAvatar_1_Background:#d08014;--sapAvatar_1_BorderColor:#d08014;--sapAvatar_1_TextColor:#fff;--sapAvatar_2_Background:#d04343;--sapAvatar_2_BorderColor:#d04343;--sapAvatar_2_TextColor:#fff;--sapAvatar_3_Background:#db1f77;--sapAvatar_3_BorderColor:#db1f77;--sapAvatar_3_TextColor:#fff;--sapAvatar_4_Background:#c0399f;--sapAvatar_4_BorderColor:#c0399f;--sapAvatar_4_TextColor:#fff;--sapAvatar_5_Background:#6367de;--sapAvatar_5_BorderColor:#6367de;--sapAvatar_5_TextColor:#fff;--sapAvatar_6_Background:#286eb4;--sapAvatar_6_BorderColor:#286eb4;--sapAvatar_6_TextColor:#fff;--sapAvatar_7_Background:#0f828f;--sapAvatar_7_BorderColor:#0f828f;--sapAvatar_7_TextColor:#fff;--sapAvatar_8_Background:#7ca10c;--sapAvatar_8_BorderColor:#7ca10c;--sapAvatar_8_TextColor:#fff;--sapAvatar_9_Background:#925ace;--sapAvatar_9_BorderColor:#925ace;--sapAvatar_9_TextColor:#fff;--sapAvatar_10_Background:#647987;--sapAvatar_10_BorderColor:#647987;--sapAvatar_10_TextColor:#fff;--sapButton_Background:#fff;--sapButton_BorderColor:#0854a0;--sapButton_BorderWidth:.0625rem;--sapButton_BorderCornerRadius:.25rem;--sapButton_TextColor:#0854a0;--sapButton_Hover_Background:#ebf5fe;--sapButton_Hover_BorderColor:#0854a0;--sapButton_Hover_TextColor:#0854a0;--sapButton_IconColor:#0854a0;--sapButton_Active_Background:#0854a0;--sapButton_Active_BorderColor:#0854a0;--sapButton_Active_TextColor:#fff;--sapButton_Emphasized_Background:#0a6ed1;--sapButton_Emphasized_BorderColor:#0a6ed1;--sapButton_Emphasized_TextColor:#fff;--sapButton_Emphasized_Hover_Background:#085caf;--sapButton_Emphasized_Hover_BorderColor:#085caf;--sapButton_Emphasized_Hover_TextColor:#fff;--sapButton_Emphasized_Active_Background:#0854a0;--sapButton_Emphasized_Active_BorderColor:#0854a0;--sapButton_Emphasized_Active_TextColor:#fff;--sapButton_Emphasized_TextShadow:transparent;--sapButton_Emphasized_FontWeight:bold;--sapButton_Reject_Background:#fff;--sapButton_Reject_BorderColor:#b00;--sapButton_Reject_TextColor:#b00;--sapButton_Reject_Hover_Background:#ffebeb;--sapButton_Reject_Hover_BorderColor:#b00;--sapButton_Reject_Hover_TextColor:#b00;--sapButton_Reject_Active_Background:#a20000;--sapButton_Reject_Active_BorderColor:#a20000;--sapButton_Reject_Active_TextColor:#fff;--sapButton_Reject_Selected_Background:#a20000;--sapButton_Reject_Selected_BorderColor:#a20000;--sapButton_Reject_Selected_TextColor:#fff;--sapButton_Reject_Selected_Hover_Background:#b00;--sapButton_Reject_Selected_Hover_BorderColor:#b00;--sapButton_Accept_Background:#fff;--sapButton_Accept_BorderColor:#107e3e;--sapButton_Accept_TextColor:#107e3e;--sapButton_Accept_Hover_Background:#f1fdf6;--sapButton_Accept_Hover_BorderColor:#107e3e;--sapButton_Accept_Hover_TextColor:#107e3e;--sapButton_Accept_Active_Background:#0d6733;--sapButton_Accept_Active_BorderColor:#0d6733;--sapButton_Accept_Active_TextColor:#fff;--sapButton_Accept_Selected_Background:#0d6733;--sapButton_Accept_Selected_BorderColor:#0d6733;--sapButton_Accept_Selected_TextColor:#fff;--sapButton_Accept_Selected_Hover_Background:#107e3e;--sapButton_Accept_Selected_Hover_BorderColor:#107e3e;--sapButton_Lite_Background:transparent;--sapButton_Lite_BorderColor:transparent;--sapButton_Lite_TextColor:#0854a0;--sapButton_Lite_Hover_Background:#ebf5fe;--sapButton_Lite_Hover_BorderColor:#0854a0;--sapButton_Lite_Hover_TextColor:#0854a0;--sapButton_Lite_Active_Background:#0854a0;--sapButton_Lite_Active_BorderColor:#0854a0;--sapButton_Selected_Background:#0854a0;--sapButton_Selected_BorderColor:#0854a0;--sapButton_Selected_TextColor:#fff;--sapButton_Selected_Hover_Background:#095caf;--sapButton_Selected_Hover_BorderColor:#095caf;--sapButton_Attention_Background:#fff;--sapButton_Attention_BorderColor:#df6e0c;--sapButton_Attention_TextColor:#32363a;--sapButton_Attention_Hover_Background:#fef7f1;--sapButton_Attention_Hover_BorderColor:#df6e0c;--sapButton_Attention_Hover_TextColor:#32363a;--sapButton_Attention_Active_Background:#f3801c;--sapButton_Attention_Active_BorderColor:#f3801c;--sapButton_Attention_Active_TextColor:#fff;--sapButton_Attention_Selected_Background:#f3801c;--sapButton_Attention_Selected_BorderColor:#f3801c;--sapButton_Attention_Selected_TextColor:#fff;--sapButton_Attention_Selected_Hover_Background:#f48e34;--sapButton_Attention_Selected_Hover_BorderColor:#f48e34;--sapButton_Negative_Background:#b00;--sapButton_Negative_BorderColor:#b00;--sapButton_Negative_TextColor:#fff;--sapButton_Negative_Hover_Background:#970000;--sapButton_Negative_Hover_BorderColor:#970000;--sapButton_Negative_Hover_TextColor:#fff;--sapButton_Negative_Active_Background:#800;--sapButton_Negative_Active_BorderColor:#800;--sapButton_Negative_Active_TextColor:#fff;--sapButton_Critical_Background:#df6e0c;--sapButton_Critical_BorderColor:#df6e0c;--sapButton_Critical_TextColor:#fff;--sapButton_Critical_Hover_Background:#f3801c;--sapButton_Critical_Hover_BorderColor:#f3801c;--sapButton_Critical_Hover_TextColor:#fff;--sapButton_Critical_Active_Background:#f5933e;--sapButton_Critical_Active_BorderColor:#f5933e;--sapButton_Critical_Active_TextColor:#fff;--sapButton_Success_Background:#107e3e;--sapButton_Success_BorderColor:#107e3e;--sapButton_Success_TextColor:#fff;--sapButton_Success_Hover_Background:#0c5e2e;--sapButton_Success_Hover_BorderColor:#0c5e2e;--sapButton_Success_Hover_TextColor:#fff;--sapButton_Success_Active_Background:#0a5128;--sapButton_Success_Active_BorderColor:#0a5128;--sapButton_Success_Active_TextColor:#fff;--sapButton_Information_Background:#0a6ed1;--sapButton_Information_BorderColor:#0a6ed1;--sapButton_Information_TextColor:#fff;--sapButton_Information_Hover_Background:#0961b9;--sapButton_Information_Hover_BorderColor:#0961b9;--sapButton_Information_Hover_TextColor:#fff;--sapButton_Information_Active_Background:#0854a0;--sapButton_Information_Active_BorderColor:#0854a0;--sapButton_Information_Active_TextColor:#fff;--sapButton_Neutral_Background:#6a6d70;--sapButton_Neutral_BorderColor:#6a6d70;--sapButton_Neutral_TextColor:#fff;--sapButton_Neutral_Hover_Background:#595b5e;--sapButton_Neutral_Hover_BorderColor:#595b5e;--sapButton_Neutral_Hover_TextColor:#fff;--sapButton_Neutral_Active_Background:#515456;--sapButton_Neutral_Active_BorderColor:#515456;--sapButton_Neutral_Active_TextColor:#fff;--sapButton_Track_Background:#ededed;--sapButton_Track_BorderColor:#89919a;--sapButton_Track_TextColor:#32363a;--sapButton_Track_Hover_Background:#ededed;--sapButton_Track_Hover_BorderColor:#0854a0;--sapButton_Track_Selected_Background:#ebf5fe;--sapButton_Track_Selected_BorderColor:#0854a0;--sapButton_Track_Selected_TextColor:#32363a;--sapButton_Track_Selected_Hover_Background:#ebf5fe;--sapButton_Track_Selected_Hover_BorderColor:#095caf;--sapButton_Handle_Background:#fff;--sapButton_Handle_BorderColor:#89919a;--sapButton_Handle_TextColor:#32363a;--sapButton_Handle_Hover_Background:#ebf5fe;--sapButton_Handle_Hover_BorderColor:#0854a0;--sapButton_Handle_Selected_Background:#0854a0;--sapButton_Handle_Selected_BorderColor:#0854a0;--sapButton_Handle_Selected_TextColor:#fff;--sapButton_Handle_Selected_Hover_Background:#095caf;--sapButton_Handle_Selected_Hover_BorderColor:#095caf;--sapButton_Track_Negative_Background:#ffebeb;--sapButton_Track_Negative_BorderColor:#b00;--sapButton_Track_Negative_TextColor:#b00;--sapButton_Track_Negative_Hover_Background:#ffebeb;--sapButton_Track_Negative_Hover_BorderColor:#b00;--sapButton_Handle_Negative_Background:#fff;--sapButton_Handle_Negative_BorderColor:#b00;--sapButton_Handle_Negative_TextColor:#b00;--sapButton_Handle_Negative_Hover_Background:#ffebeb;--sapButton_Handle_Negative_Hover_BorderColor:#b00;--sapButton_Track_Positive_Background:#f1fdf6;--sapButton_Track_Positive_BorderColor:#107e3e;--sapButton_Track_Positive_TextColor:#107e3e;--sapButton_Track_Positive_Hover_Background:#f1fdf6;--sapButton_Track_Positive_Hover_BorderColor:#107e3e;--sapButton_Handle_Positive_Background:#fff;--sapButton_Handle_Positive_BorderColor:#107e3e;--sapButton_Handle_Positive_TextColor:#107e3e;--sapButton_Handle_Positive_Hover_Background:#f1fdf6;--sapButton_Handle_Positive_Hover_BorderColor:#107e3e;--sapButton_TokenBackground:#fafafa;--sapButton_TokenBorderColor:#c2c2c2;--sapField_Background:#fff;--sapField_BackgroundStyle:none;--sapField_TextColor:#32363a;--sapField_PlaceholderTextColor:#74777a;--sapField_BorderColor:#89919a;--sapField_HelpBackground:#fff;--sapField_BorderWidth:.0625rem;--sapField_BorderStyle:solid;--sapField_BorderCornerRadius:.125rem;--sapField_Shadow:none;--sapField_Hover_Background:#fff;--sapField_Hover_BackgroundStyle:none;--sapField_Hover_BorderColor:#0854a0;--sapField_Hover_HelpBackground:#ebf5fe;--sapField_Hover_Shadow:none;--sapField_Hover_InvalidShadow:none;--sapField_Hover_WarningShadow:none;--sapField_Hover_SuccessShadow:none;--sapField_Hover_InformationShadow:none;--sapField_Active_BorderColor:#0854a0;--sapField_Focus_Background:#fff;--sapField_Focus_BorderColor:#89919a;--sapField_Focus_HelpBackground:#fff;--sapField_ReadOnly_Background:hsla(0,0%,94.9%,0.5);--sapField_ReadOnly_BackgroundStyle:none;--sapField_ReadOnly_BorderColor:#89919a;--sapField_ReadOnly_BorderStyle:solid;--sapField_ReadOnly_HelpBackground:hsla(0,0%,94.9%,0.5);--sapField_RequiredColor:#ce3b3b;--sapField_InvalidColor:#b00;--sapField_InvalidBackground:#fff;--sapField_InvalidBackgroundStyle:none;--sapField_InvalidBorderWidth:.125rem;--sapField_InvalidBorderStyle:solid;--sapField_InvalidShadow:none;--sapField_WarningColor:#df6e0c;--sapField_WarningBackground:#fff;--sapField_WarningBackgroundStyle:none;--sapField_WarningBorderWidth:.125rem;--sapField_WarningBorderStyle:solid;--sapField_WarningShadow:none;--sapField_SuccessColor:#107e3e;--sapField_SuccessBackground:#fff;--sapField_SuccessBackgroundStyle:none;--sapField_SuccessBorderWidth:.0625rem;--sapField_SuccessBorderStyle:solid;--sapField_SuccessShadow:none;--sapField_InformationColor:#0a6ed1;--sapField_InformationBackground:#fff;--sapField_InformationBackgroundStyle:none;--sapField_InformationBorderWidth:.125rem;--sapField_InformationBorderStyle:solid;--sapField_InformationShadow:none;--sapGroup_TitleBackground:transparent;--sapGroup_TitleBorderColor:#d9d9d9;--sapGroup_TitleTextColor:#32363a;--sapGroup_Title_FontSize:1.125rem;--sapGroup_ContentBackground:#fff;--sapGroup_ContentBorderColor:#d9d9d9;--sapGroup_BorderWidth:.0625rem;--sapGroup_BorderCornerRadius:0;--sapGroup_FooterBackground:transparent;--sapToolbar_Background:transparent;--sapToolbar_SeparatorColor:#d9d9d9;--sapList_HeaderBackground:#f2f2f2;--sapList_HeaderBorderColor:#e5e5e5;--sapList_HeaderTextColor:#32363a;--sapList_BorderColor:#e5e5e5;--sapList_BorderWidth:.0625rem;--sapList_TextColor:#32363a;--sapList_Active_TextColor:#fff;--sapList_Active_Background:#0854a0;--sapList_SelectionBackgroundColor:#e5f0fa;--sapList_SelectionBorderColor:#0854a0;--sapList_Hover_SelectionBackground:#d8e9f8;--sapList_Background:#fff;--sapList_Hover_Background:#f5f5f5;--sapList_AlternatingBackground:#f2f2f2;--sapList_GroupHeaderBackground:#fff;--sapList_GroupHeaderBorderColor:#d9d9d9;--sapList_GroupHeaderTextColor:#32363a;--sapList_TableGroupHeaderBackground:#efefef;--sapList_TableGroupHeaderBorderColor:#d9d9d9;--sapList_TableGroupHeaderTextColor:#32363a;--sapList_FooterBackground:#fafafa;--sapList_FooterTextColor:#32363a;--sapList_TableFooterBorder:#d9d9d9;--sapList_TableFixedBorderColor:#8c8c8c;--sapMessage_ErrorBorderColor:#b00;--sapMessage_WarningBorderColor:#df6e0c;--sapMessage_SuccessBorderColor:#107e3e;--sapMessage_InformationBorderColor:#0a6ed1;--sapPopover_BorderCornerRadius:.25rem;--sapProgress_Background:#fff;--sapProgress_BorderColor:#89919a;--sapProgress_TextColor:#32363a;--sapProgress_FontSize:.75rem;--sapProgress_NegativeBackground:#fff;--sapProgress_NegativeBorderColor:#89919a;--sapProgress_NegativeTextColor:#32363a;--sapProgress_CriticalBackground:#fff;--sapProgress_CriticalBorderColor:#89919a;--sapProgress_CriticalTextColor:#32363a;--sapProgress_PositiveBackground:#fff;--sapProgress_PositiveBorderColor:#89919a;--sapProgress_PositiveTextColor:#32363a;--sapProgress_InformationBackground:#fff;--sapProgress_InformationBorderColor:#89919a;--sapProgress_InformationTextColor:#32363a;--sapProgress_Value_Background:#6a6d70;--sapProgress_Value_BorderColor:#89919a;--sapProgress_Value_TextColor:#32363a;--sapProgress_Value_NegativeBackground:#b00;--sapProgress_Value_NegativeBorderColor:#fff;--sapProgress_Value_NegativeTextColor:#32363a;--sapProgress_Value_CriticalBackground:#df6e0c;--sapProgress_Value_CriticalBorderColor:#fff;--sapProgress_Value_CriticalTextColor:#32363a;--sapProgress_Value_PositiveBackground:#107e3e;--sapProgress_Value_PositiveBorderColor:#fff;--sapProgress_Value_PositiveTextColor:#32363a;--sapProgress_Value_InformationBackground:#0a6ed1;--sapProgress_Value_InformationBorderColor:#fff;--sapProgress_Value_InformationTextColor:#32363a;--sapScrollBar_FaceColor:#949494;--sapScrollBar_TrackColor:#fff;--sapScrollBar_BorderColor:#949494;--sapScrollBar_SymbolColor:#0854a0;--sapScrollBar_Dimension:.75rem;--sapScrollBar_Hover_FaceColor:#8c8c8c;--sapSlider_Background:#89919a;--sapSlider_BorderColor:#89919a;--sapSlider_Selected_Background:#0854a0;--sapSlider_Selected_BorderColor:#0854a0;--sapSlider_HandleBackground:#fff;--sapSlider_HandleBorderColor:#89919a;--sapSlider_RangeHandleBackground:transparent;--sapSlider_Hover_HandleBackground:#ebf5fe;--sapSlider_Hover_HandleBorderColor:#0854a0;--sapSlider_Hover_RangeHandleBackground:#ebf5fe;--sapSlider_Active_HandleBackground:#0854a0;--sapSlider_Active_HandleBorderColor:#0854a0;--sapSlider_Active_RangeHandleBackground:transparent;--sapPageHeader_Background:#fff;--sapPageHeader_BorderColor:#d9d9d9;--sapPageHeader_TextColor:#32363a;--sapPageFooter_Background:#fff;--sapPageFooter_BorderColor:#d9d9d9;--sapPageFooter_TextColor:#32363a;--sapInfobar_Background:#0f828f;--sapInfobar_Hover_Background:#0e7581;--sapInfobar_Active_Background:#0a545c;--sapInfobar_NonInteractive_Background:#e6e6e6;--sapInfobar_TextColor:#fff;--sapObjectHeader_Background:#fff;--sapObjectHeader_Hover_Background:#f5f5f5;--sapObjectHeader_BorderColor:#d9d9d9;--sapObjectHeader_Title_TextColor:#32363a;--sapObjectHeader_Title_FontSize:1.25rem;--sapObjectHeader_Title_SnappedFontSize:1.25rem;--sapObjectHeader_Title_FontFamily:"72","72full",Arial,Helvetica,sans-serif;--sapObjectHeader_Subtitle_TextColor:#6a6d70;--sapBlockLayer_Background:#000;--sapTile_Background:#fff;--sapTile_Hover_Background:#f5f5f5;--sapTile_Active_Background:#f5f5f5;--sapTile_BorderColor:transparent;--sapTile_BorderCornerRadius:.25rem;--sapTile_TitleTextColor:#32363a;--sapTile_TextColor:#6a6d70;--sapTile_IconColor:#5a7da0;--sapTile_SeparatorColor:#ccc;--sapTile_Interactive_BorderColor:#b3b3b3;--sapTile_OverlayBackground:rgba(0,0,0,0.8);--sapTile_OverlayForegroundColor:#fff;--sapAccentColor1:#d08014;--sapAccentColor2:#d04343;--sapAccentColor3:#db1f77;--sapAccentColor4:#c0399f;--sapAccentColor5:#6367de;--sapAccentColor6:#286eb4;--sapAccentColor7:#0f828f;--sapAccentColor8:#7ca10c;--sapAccentColor9:#925ace;--sapAccentColor10:#647987;--sapAccentBackgroundColor1:#fff3b8;--sapAccentBackgroundColor2:#ffd0e7;--sapAccentBackgroundColor3:#fff0fa;--sapAccentBackgroundColor4:#ffdcf3;--sapAccentBackgroundColor5:#ded3ff;--sapAccentBackgroundColor6:#d1efff;--sapAccentBackgroundColor7:#c2fcee;--sapAccentBackgroundColor8:#ebf5cb;--sapAccentBackgroundColor9:#dafdf5;--sapAccentBackgroundColor10:#eaecee;--sapIndicationColor_1:#800;--sapIndicationColor_1_Background:#800;--sapIndicationColor_1_BorderColor:#800;--sapIndicationColor_1_TextColor:#fff;--sapIndicationColor_1_Hover_Background:#6f0000;--sapIndicationColor_1_Active_Background:#500;--sapIndicationColor_1_Active_BorderColor:#800;--sapIndicationColor_1_Active_TextColor:#fff;--sapIndicationColor_1_Selected_Background:#500;--sapIndicationColor_1_Selected_BorderColor:#800;--sapIndicationColor_1_Selected_TextColor:#fff;--sapIndicationColor_1b:#fb9d9d;--sapIndicationColor_1b_BorderColor:#fb9d9d;--sapIndicationColor_1b_Hover_Background:#fa8585;--sapIndicationColor_2:#b00;--sapIndicationColor_2_Background:#b00;--sapIndicationColor_2_BorderColor:#b00;--sapIndicationColor_2_TextColor:#fff;--sapIndicationColor_2_Hover_Background:#a20000;--sapIndicationColor_2_Active_Background:#800;--sapIndicationColor_2_Active_BorderColor:#b00;--sapIndicationColor_2_Active_TextColor:#fff;--sapIndicationColor_2_Selected_Background:#800;--sapIndicationColor_2_Selected_BorderColor:#b00;--sapIndicationColor_2_Selected_TextColor:#fff;--sapIndicationColor_2b:#fcc4c4;--sapIndicationColor_2b_BorderColor:#fcc4c4;--sapIndicationColor_2b_Hover_Background:#fbacac;--sapIndicationColor_3:#df6e0c;--sapIndicationColor_3_Background:#df6e0c;--sapIndicationColor_3_BorderColor:#df6e0c;--sapIndicationColor_3_TextColor:#fff;--sapIndicationColor_3_Hover_Background:#d0670b;--sapIndicationColor_3_Active_Background:#c2600a;--sapIndicationColor_3_Active_BorderColor:#df6e0c;--sapIndicationColor_3_Active_TextColor:#fff;--sapIndicationColor_3_Selected_Background:#c2600a;--sapIndicationColor_3_Selected_BorderColor:#df6e0c;--sapIndicationColor_3_Selected_TextColor:#fff;--sapIndicationColor_3b:#fff2c0;--sapIndicationColor_3b_BorderColor:#fff2c0;--sapIndicationColor_3b_Hover_Background:#ffeda6;--sapIndicationColor_4:#107e3e;--sapIndicationColor_4_Background:#107e3e;--sapIndicationColor_4_BorderColor:#107e3e;--sapIndicationColor_4_TextColor:#fff;--sapIndicationColor_4_Hover_Background:#0d6733;--sapIndicationColor_4_Active_Background:#0a5128;--sapIndicationColor_4_Active_BorderColor:#107e3e;--sapIndicationColor_4_Active_TextColor:#fff;--sapIndicationColor_4_Selected_Background:#0a5128;--sapIndicationColor_4_Selected_BorderColor:#107e3e;--sapIndicationColor_4_Selected_TextColor:#fff;--sapIndicationColor_4b:#bae8bc;--sapIndicationColor_4b_BorderColor:#bae8bc;--sapIndicationColor_4b_Hover_Background:#a7e2a9;--sapIndicationColor_5:#0a6ed1;--sapIndicationColor_5_Background:#0a6ed1;--sapIndicationColor_5_BorderColor:#0a6ed1;--sapIndicationColor_5_TextColor:#fff;--sapIndicationColor_5_Hover_Background:#0961b9;--sapIndicationColor_5_Active_Background:#0854a0;--sapIndicationColor_5_Active_BorderColor:#0a6ed1;--sapIndicationColor_5_Active_TextColor:#fff;--sapIndicationColor_5_Selected_Background:#0854a0;--sapIndicationColor_5_Selected_BorderColor:#0a6ed1;--sapIndicationColor_5_Selected_TextColor:#fff;--sapIndicationColor_5b:#d3effd;--sapIndicationColor_5b_BorderColor:#d3effd;--sapIndicationColor_5b_Hover_Background:#bbe6fc;--sapIndicationColor_6:#0f828f;--sapIndicationColor_6_Background:#0f828f;--sapIndicationColor_6_BorderColor:#0f828f;--sapIndicationColor_6_TextColor:#fff;--sapIndicationColor_6_Hover_Background:#0d6d78;--sapIndicationColor_6_Active_Background:#0a5861;--sapIndicationColor_6_Active_BorderColor:#0f828f;--sapIndicationColor_6_Active_TextColor:#fff;--sapIndicationColor_6_Selected_Background:#0a5861;--sapIndicationColor_6_Selected_BorderColor:#0f828f;--sapIndicationColor_6_Selected_TextColor:#fff;--sapIndicationColor_6b:#cdf5ec;--sapIndicationColor_6b_BorderColor:#cdf5ec;--sapIndicationColor_6b_Hover_Background:#b8f1e4;--sapIndicationColor_7:#925ace;--sapIndicationColor_7_Background:#925ace;--sapIndicationColor_7_BorderColor:#925ace;--sapIndicationColor_7_TextColor:#fff;--sapIndicationColor_7_Hover_Background:#8546c8;--sapIndicationColor_7_Active_Background:#7838bd;--sapIndicationColor_7_Active_BorderColor:#925ace;--sapIndicationColor_7_Active_TextColor:#fff;--sapIndicationColor_7_Selected_Background:#7838bd;--sapIndicationColor_7_Selected_BorderColor:#925ace;--sapIndicationColor_7_Selected_TextColor:#fff;--sapIndicationColor_7b:#e2dbff;--sapIndicationColor_7b_BorderColor:#e2dbff;--sapIndicationColor_7b_Hover_Background:#cdc2ff;--sapIndicationColor_8:#c0399f;--sapIndicationColor_8_Background:#c0399f;--sapIndicationColor_8_BorderColor:#c0399f;--sapIndicationColor_8_TextColor:#fff;--sapIndicationColor_8_Hover_Background:#ac338f;--sapIndicationColor_8_Active_Background:#992d7e;--sapIndicationColor_8_Active_BorderColor:#c0399f;--sapIndicationColor_8_Active_TextColor:#fff;--sapIndicationColor_8_Selected_Background:#992d7e;--sapIndicationColor_8_Selected_BorderColor:#c0399f;--sapIndicationColor_8_Selected_TextColor:#fff;--sapIndicationColor_8b:#f8d6ff;--sapIndicationColor_8b_BorderColor:#f8d6ff;--sapIndicationColor_8b_Hover_Background:#f4bdff;--sapIndicationColor_9:#1d2d3e;--sapIndicationColor_9_Background:#1d2d3e;--sapIndicationColor_9_BorderColor:#1d2d3e;--sapIndicationColor_9_TextColor:#fff;--sapIndicationColor_9_Hover_Background:#15202d;--sapIndicationColor_9_Active_Background:#0d141b;--sapIndicationColor_9_Active_BorderColor:#1d2d3e;--sapIndicationColor_9_Active_TextColor:#fff;--sapIndicationColor_9_Selected_Background:#0d141b;--sapIndicationColor_9_Selected_BorderColor:#1d2d3e;--sapIndicationColor_9_Selected_TextColor:#fff;--sapIndicationColor_9b:#fff;--sapIndicationColor_9b_BorderColor:#d9d9d9;--sapIndicationColor_9b_Hover_Background:#f2f2f2;--sapIndicationColor_10:#45484a;--sapIndicationColor_10_Background:#45484a;--sapIndicationColor_10_BorderColor:#45484a;--sapIndicationColor_10_TextColor:#fff;--sapIndicationColor_10_Hover_Background:#393b3d;--sapIndicationColor_10_Active_Background:#2c2e30;--sapIndicationColor_10_Active_BorderColor:#45484a;--sapIndicationColor_10_Active_TextColor:#fff;--sapIndicationColor_10_Selected_Background:#2c2e30;--sapIndicationColor_10_Selected_BorderColor:#45484a;--sapIndicationColor_10_Selected_TextColor:#fff;--sapIndicationColor_10b:#eaecee;--sapIndicationColor_10b_BorderColor:#eaecee;--sapIndicationColor_10b_Hover_Background:#dcdfe3;--sapLegend_WorkingBackground:#fafafa;--sapLegend_NonWorkingBackground:#dedede;--sapLegend_CurrentDateTime:#c0399f;--sapLegendColor1:#d58215;--sapLegendColor2:#dc5b5b;--sapLegendColor3:#db1f77;--sapLegendColor4:#9b3b3b;--sapLegendColor5:#cf5db3;--sapLegendColor6:#286eb4;--sapLegendColor7:#1193a2;--sapLegendColor8:#8b9668;--sapLegendColor9:#647987;--sapLegendColor10:#892971;--sapLegendColor11:#725a3a;--sapLegendColor12:#bb2f2f;--sapLegendColor13:#bc1b66;--sapLegendColor14:#8b714f;--sapLegendColor15:#606190;--sapLegendColor16:#597da1;--sapLegendColor17:#49797e;--sapLegendColor18:#687a33;--sapLegendColor19:#295989;--sapLegendColor20:#5154bd;--sapLegendBackgroundColor1:#fdf3e7;--sapLegendBackgroundColor2:#faeaea;--sapLegendBackgroundColor3:#fce9f2;--sapLegendBackgroundColor4:#f8ecec;--sapLegendBackgroundColor5:#f9ebf5;--sapLegendBackgroundColor6:#ebf3fa;--sapLegendBackgroundColor7:#e8fbfd;--sapLegendBackgroundColor8:#f3f4ef;--sapLegendBackgroundColor9:#f1f3f4;--sapLegendBackgroundColor10:#f9ebf6;--sapLegendBackgroundColor11:#f6f2ed;--sapLegendBackgroundColor12:#faeaea;--sapLegendBackgroundColor13:#fce9f2;--sapLegendBackgroundColor14:#f5f2ee;--sapLegendBackgroundColor15:#f0f0f5;--sapLegendBackgroundColor16:#eff2f6;--sapLegendBackgroundColor17:#eff5f6;--sapLegendBackgroundColor18:#f5f7ed;--sapLegendBackgroundColor19:#ebf2f9;--sapLegendBackgroundColor20:#ecedf8;--sapChart_OrderedColor_1:#438cd5;--sapChart_OrderedColor_2:#e66729;--sapChart_OrderedColor_3:#16976c;--sapChart_OrderedColor_4:#ed4a7b;--sapChart_OrderedColor_5:#945ecf;--sapChart_OrderedColor_6:#1193a2;--sapChart_OrderedColor_7:#525df4;--sapChart_OrderedColor_8:#bf399e;--sapChart_OrderedColor_9:#6c8893;--sapChart_OrderedColor_10:#ed5f5f;--sapChart_OrderedColor_11:#2f6497;--sapChart_Bad:#dc0d0e;--sapChart_Critical:#cb7d0c;--sapChart_Good:#3c9d57;--sapChart_Neutral:#848f94;--sapChart_Sequence_1:#438cd5;--sapChart_Sequence_2:#e66729;--sapChart_Sequence_3:#16976c;--sapChart_Sequence_4:#ed4a7b;--sapChart_Sequence_5:#945ecf;--sapChart_Sequence_6:#1193a2;--sapChart_Sequence_7:#525df4;--sapChart_Sequence_8:#bf399e;--sapChart_Sequence_9:#6c8893;--sapChart_Sequence_10:#ed5f5f;--sapChart_Sequence_11:#2f6497;--sapChart_Sequence_Neutral:#848f94;}' };
export {
  V as U,
  Vt as a,
  Rt as b,
  Pt as c,
  Dt as d,
  y as e,
  K as f,
  Y as i,
  Ot as l,
  Nt as o,
  Mt as p,
  jt as s
};
//# sourceMappingURL=parameters-bundle.css.11496d28.mjs.map
