var S = (t, i, a) => new Promise((r, c) => {
  var n = (f) => {
    try {
      s(a.next(f));
    } catch (p) {
      c(p);
    }
  }, o = (f) => {
    try {
      s(a.throw(f));
    } catch (p) {
      c(p);
    }
  }, s = (f) => f.done ? r(f.value) : Promise.resolve(f.value).then(n, o);
  s((a = a.apply(t, i)).next());
});
import { e as d, l as T, d as U, a as y, U as C, f as K, p as N, c as tt, b as it } from "./parameters-bundle.css.11496d28.mjs";
import { H as at, D as rt, F as nt, K as ct, L as g, M as O, N as M, O as ot, G as st, f as lt, P as et, k as j, a as Q, r as X } from "./CxQtxSurveyButton.96c49aa8.mjs";
import { s as ut } from "./parameters-bundle.css.b6a86188.mjs";
const ft = (t, i = {}) => (a) => {
  Object.prototype.hasOwnProperty.call(a, "metadata") || (a.metadata = {});
  const r = a.metadata;
  r.events || (r.events = {});
  const c = r.events;
  c[t] || (c[t] = i);
};
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const W = (t, i, a) => {
  const r = /* @__PURE__ */ new Map();
  for (let c = i; c <= a; c++)
    r.set(t[c], c);
  return r;
}, ht = at(class extends rt {
  constructor(t) {
    if (super(t), t.type !== nt.CHILD)
      throw Error("repeat() can only be used in text expressions");
  }
  ht(t, i, a) {
    let r;
    a === void 0 ? a = i : i !== void 0 && (r = i);
    const c = [], n = [];
    let o = 0;
    for (const s of t)
      c[o] = r ? r(s, o) : o, n[o] = a(s, o), o++;
    return { values: n, keys: c };
  }
  render(t, i, a) {
    return this.ht(t, i, a).values;
  }
  update(t, [i, a, r]) {
    var c;
    const n = ct(t), { values: o, keys: s } = this.ht(i, a, r);
    if (!Array.isArray(n))
      return this.ut = s, o;
    const f = (c = this.ut) !== null && c !== void 0 ? c : this.ut = [], p = [];
    let R, G, l = 0, h = n.length - 1, e = 0, _ = o.length - 1;
    for (; l <= h && e <= _; )
      if (n[l] === null)
        l++;
      else if (n[h] === null)
        h--;
      else if (f[l] === s[e])
        p[e] = g(n[l], o[e]), l++, e++;
      else if (f[h] === s[_])
        p[_] = g(n[h], o[_]), h--, _--;
      else if (f[l] === s[_])
        p[_] = g(n[l], o[_]), O(t, p[_ + 1], n[l]), l++, _--;
      else if (f[h] === s[e])
        p[e] = g(n[h], o[e]), O(t, n[l], n[h]), h--, e++;
      else if (R === void 0 && (R = W(s, e, _), G = W(f, l, h)), R.has(f[l]))
        if (R.has(f[h])) {
          const D = G.get(s[e]), b = D !== void 0 ? n[D] : null;
          if (b === null) {
            const B = O(t, n[l]);
            g(B, o[e]), p[e] = B;
          } else
            p[e] = g(b, o[e]), O(t, n[l], b), n[D] = null;
          e++;
        } else
          M(n[h]), h--;
      else
        M(n[l]), l++;
    for (; e <= _; ) {
      const D = O(t, p[_ + 1]);
      g(D, o[e]), p[e++] = D;
    }
    for (; l <= h; ) {
      const D = n[l++];
      D !== null && M(D);
    }
    return this.ut = s, ot(t, p), st;
  }
});
var A;
(function(t) {
  t[t.BACKSPACE = 8] = "BACKSPACE", t[t.TAB = 9] = "TAB", t[t.ENTER = 13] = "ENTER", t[t.SHIFT = 16] = "SHIFT", t[t.CONTROL = 17] = "CONTROL", t[t.ALT = 18] = "ALT", t[t.BREAK = 19] = "BREAK", t[t.CAPS_LOCK = 20] = "CAPS_LOCK", t[t.ESCAPE = 27] = "ESCAPE", t[t.SPACE = 32] = "SPACE", t[t.PAGE_UP = 33] = "PAGE_UP", t[t.PAGE_DOWN = 34] = "PAGE_DOWN", t[t.END = 35] = "END", t[t.HOME = 36] = "HOME", t[t.ARROW_LEFT = 37] = "ARROW_LEFT", t[t.ARROW_UP = 38] = "ARROW_UP", t[t.ARROW_RIGHT = 39] = "ARROW_RIGHT", t[t.ARROW_DOWN = 40] = "ARROW_DOWN", t[t.PRINT = 44] = "PRINT", t[t.INSERT = 45] = "INSERT", t[t.DELETE = 46] = "DELETE", t[t.DIGIT_0 = 48] = "DIGIT_0", t[t.DIGIT_1 = 49] = "DIGIT_1", t[t.DIGIT_2 = 50] = "DIGIT_2", t[t.DIGIT_3 = 51] = "DIGIT_3", t[t.DIGIT_4 = 52] = "DIGIT_4", t[t.DIGIT_5 = 53] = "DIGIT_5", t[t.DIGIT_6 = 54] = "DIGIT_6", t[t.DIGIT_7 = 55] = "DIGIT_7", t[t.DIGIT_8 = 56] = "DIGIT_8", t[t.DIGIT_9 = 57] = "DIGIT_9", t[t.A = 65] = "A", t[t.B = 66] = "B", t[t.C = 67] = "C", t[t.D = 68] = "D", t[t.E = 69] = "E", t[t.F = 70] = "F", t[t.G = 71] = "G", t[t.H = 72] = "H", t[t.I = 73] = "I", t[t.J = 74] = "J", t[t.K = 75] = "K", t[t.L = 76] = "L", t[t.M = 77] = "M", t[t.N = 78] = "N", t[t.O = 79] = "O", t[t.P = 80] = "P", t[t.Q = 81] = "Q", t[t.R = 82] = "R", t[t.S = 83] = "S", t[t.T = 84] = "T", t[t.U = 85] = "U", t[t.V = 86] = "V", t[t.W = 87] = "W", t[t.X = 88] = "X", t[t.Y = 89] = "Y", t[t.Z = 90] = "Z", t[t.WINDOWS = 91] = "WINDOWS", t[t.CONTEXT_MENU = 93] = "CONTEXT_MENU", t[t.TURN_OFF = 94] = "TURN_OFF", t[t.SLEEP = 95] = "SLEEP", t[t.NUMPAD_0 = 96] = "NUMPAD_0", t[t.NUMPAD_1 = 97] = "NUMPAD_1", t[t.NUMPAD_2 = 98] = "NUMPAD_2", t[t.NUMPAD_3 = 99] = "NUMPAD_3", t[t.NUMPAD_4 = 100] = "NUMPAD_4", t[t.NUMPAD_5 = 101] = "NUMPAD_5", t[t.NUMPAD_6 = 102] = "NUMPAD_6", t[t.NUMPAD_7 = 103] = "NUMPAD_7", t[t.NUMPAD_8 = 104] = "NUMPAD_8", t[t.NUMPAD_9 = 105] = "NUMPAD_9", t[t.NUMPAD_ASTERISK = 106] = "NUMPAD_ASTERISK", t[t.NUMPAD_PLUS = 107] = "NUMPAD_PLUS", t[t.NUMPAD_MINUS = 109] = "NUMPAD_MINUS", t[t.NUMPAD_COMMA = 110] = "NUMPAD_COMMA", t[t.NUMPAD_SLASH = 111] = "NUMPAD_SLASH", t[t.F1 = 112] = "F1", t[t.F2 = 113] = "F2", t[t.F3 = 114] = "F3", t[t.F4 = 115] = "F4", t[t.F5 = 116] = "F5", t[t.F6 = 117] = "F6", t[t.F7 = 118] = "F7", t[t.F8 = 119] = "F8", t[t.F9 = 120] = "F9", t[t.F10 = 121] = "F10", t[t.F11 = 122] = "F11", t[t.F12 = 123] = "F12", t[t.NUM_LOCK = 144] = "NUM_LOCK", t[t.SCROLL_LOCK = 145] = "SCROLL_LOCK", t[t.OPEN_BRACKET = 186] = "OPEN_BRACKET", t[t.PLUS = 187] = "PLUS", t[t.COMMA = 188] = "COMMA", t[t.SLASH = 189] = "SLASH", t[t.DOT = 190] = "DOT", t[t.PIPE = 191] = "PIPE", t[t.SEMICOLON = 192] = "SEMICOLON", t[t.MINUS = 219] = "MINUS", t[t.GREAT_ACCENT = 220] = "GREAT_ACCENT", t[t.EQUALS = 221] = "EQUALS", t[t.SINGLE_QUOTE = 222] = "SINGLE_QUOTE", t[t.BACKSLASH = 226] = "BACKSLASH";
})(A || (A = {}));
const pt = (t) => (t.key ? t.key === "Enter" : t.keyCode === A.ENTER) && !E(t), $ = (t) => (t.key ? t.key === "Spacebar" || t.key === " " : t.keyCode === A.SPACE) && !E(t), wt = (t) => (t.key ? t.key === "ArrowLeft" || t.key === "Left" : t.keyCode === A.ARROW_LEFT) && !E(t), Lt = (t) => (t.key ? t.key === "ArrowRight" || t.key === "Right" : t.keyCode === A.ARROW_RIGHT) && !E(t), Ft = (t) => (t.key ? t.key === "ArrowUp" || t.key === "Up" : t.keyCode === A.ARROW_UP) && !E(t), Gt = (t) => (t.key ? t.key === "ArrowDown" || t.key === "Down" : t.keyCode === A.ARROW_DOWN) && !E(t), Bt = (t) => (t.key ? t.key === "ArrowUp" || t.key === "Up" : t.keyCode === A.ARROW_UP) && m(t, !1, !1, !0), Wt = (t) => (t.key ? t.key === "ArrowDown" || t.key === "Down" : t.keyCode === A.ARROW_DOWN) && m(t, !1, !1, !0), $t = (t) => (t.key ? t.key === "ArrowLeft" || t.key === "Left" : t.keyCode === A.ARROW_LEFT) && m(t, !1, !1, !0), Ht = (t) => (t.key ? t.key === "ArrowRight" || t.key === "Right" : t.keyCode === A.ARROW_RIGHT) && m(t, !1, !1, !0), xt = (t) => (t.key ? t.key === "Escape" || t.key === "Esc" : t.keyCode === A.ESCAPE) && !E(t), Vt = (t) => (t.key ? t.key === "Tab" : t.keyCode === A.TAB) && m(t, !1, !1, !0), E = (t) => t.shiftKey || t.altKey || Y(t), Y = (t) => !!(t.metaKey || t.ctrlKey), m = (t, i, a, r) => t.shiftKey === r && t.altKey === a && Y(t) === i;
var k;
(function(t) {
  t["SAP-icons"] = "SAP-icons-v4", t.horizon = "SAP-icons-v5", t["SAP-icons-TNT"] = "tnt", t.BusinessSuiteInAppSymbols = "business-suite";
})(k || (k = {}));
const q = (t) => k[t] ? k[t] : t, At = /* @__PURE__ */ new Map();
var P;
(function(t) {
  t.SAPIconsV4 = "SAP-icons-v4", t.SAPIconsV5 = "SAP-icons-v5", t.SAPIconsTNTV2 = "tnt-v2", t.SAPIconsTNTV3 = "tnt-v3", t.SAPBSIconsV1 = "business-suite-v1", t.SAPBSIconsV2 = "business-suite-v2";
})(P || (P = {}));
const _t = (t) => {
  const i = lt(), a = At.get(i);
  return !t && a ? q(a) : It(t);
}, It = (t) => {
  const i = et();
  return t ? t === "tnt" ? i ? P.SAPIconsTNTV2 : P.SAPIconsTNTV3 : t === "business-suite" ? i ? P.SAPBSIconsV1 : P.SAPBSIconsV2 : t : i ? P.SAPIconsV4 : P.SAPIconsV5;
}, H = /* @__PURE__ */ new Map(), v = j("SVGIcons.registry", /* @__PURE__ */ new Map()), w = j("SVGIcons.promises", /* @__PURE__ */ new Map()), L = "ICON_NOT_FOUND", Nt = (t) => S(void 0, null, function* () {
  if (!w.has(t)) {
    if (!H.has(t))
      throw new Error(`No loader registered for the ${t} icons collection. Probably you forgot to import the "AllIcons.js" module for the respective package.`);
    const i = H.get(t);
    w.set(t, i(t));
  }
  return w.get(t);
}), Tt = (t) => {
  Object.keys(t.data).forEach((i) => {
    const a = t.data[i];
    Dt(i, {
      pathData: a.path || a.paths,
      ltr: a.ltr,
      accData: a.acc,
      collection: t.collection,
      packageName: t.packageName
    });
  });
}, Dt = (t, i) => {
  const a = `${i.collection}/${t}`;
  v.set(a, {
    pathData: i.pathData,
    ltr: i.ltr,
    accData: i.accData,
    packageName: i.packageName,
    customTemplate: i.customTemplate,
    viewBox: i.viewBox,
    collection: i.collection
  });
}, J = (t) => {
  t.startsWith("sap-icon://") && (t = t.replace("sap-icon://", ""));
  let i;
  [t, i] = t.split("/").reverse(), t = t.replace("icon-", ""), i && (i = q(i)), i = _t(i);
  const a = `${i}/${t}`;
  return { name: t, collection: i, registryKey: a };
}, z = (t) => {
  const { registryKey: i } = J(t);
  return v.get(i);
}, Z = (t) => S(void 0, null, function* () {
  const { collection: i, registryKey: a } = J(t);
  let r = L;
  try {
    r = yield Nt(i);
  } catch (c) {
    console.error(c.message);
  }
  return r === L ? r : (v.has(a) || Tt(r), v.get(a));
}), jt = (t) => S(void 0, null, function* () {
  if (!t)
    return;
  let i = z(t);
  if (i || (i = yield Z(t)), i && i !== L && i.accData)
    return (yield Q(i.packageName)).getText(i.accData);
});
function Pt(t, i, a) {
  return d`<svg class="ui5-icon-root" part="root" tabindex="${T(this._tabIndex)}" dir="${T(this._dir)}" viewBox="${T(this.viewBox)}" role="${T(this.effectiveAccessibleRole)}" focusable="false" preserveAspectRatio="xMidYMid meet" aria-label="${T(this.effectiveAccessibleName)}" aria-hidden=${T(this.effectiveAriaHidden)} xmlns="http://www.w3.org/2000/svg" @focusin=${this._onfocusin} @focusout=${this._onfocusout} @keydown=${this._onkeydown} @keyup=${this._onkeyup}>${Ot.call(this, t, i, a)}</svg>`;
}
function St(t, i, a) {
  return U`<title id="${T(this._id)}-tooltip">${T(this.effectiveAccessibleName)}</title>`;
}
function gt(t, i, a) {
  return U`${T(this.customSvg)}`;
}
function Et(t, i, a, r, c) {
  return U`<path d="${T(r)}"></path>`;
}
function Ot(t, i, a) {
  return U`${this.hasIconTooltip ? St.call(this, t, i, a) : void 0}<g role="presentation">${this.customSvg ? gt.call(this, t, i, a) : void 0}${ht(this.pathData, (r, c) => r._id || c, (r, c) => Et.call(this, t, i, a, r, c))}</g>`;
}
var F;
(function(t) {
  t.Contrast = "Contrast", t.Critical = "Critical", t.Default = "Default", t.Information = "Information", t.Negative = "Negative", t.Neutral = "Neutral", t.NonInteractive = "NonInteractive", t.Positive = "Positive";
})(F || (F = {}));
const x = F;
X("@ui5/webcomponents-theming", "sap_fiori_3", () => S(void 0, null, function* () {
  return y;
}));
X("@ui5/webcomponents", "sap_fiori_3", () => S(void 0, null, function* () {
  return ut;
}));
const mt = { packageName: "@ui5/webcomponents", fileName: "themes/Icon.css", content: ":host{-webkit-tap-highlight-color:rgba(0,0,0,0)}:host([hidden]){display:none}:host([invalid]){display:none}:host(:not([hidden]).ui5_hovered){opacity:.7}:host{display:inline-block;width:1rem;height:1rem;color:var(--sapContent_NonInteractiveIconColor);fill:currentColor;outline:none}:host([design=Contrast]){color:var(--sapContent_ContrastIconColor)}:host([design=Critical]){color:var(--sapCriticalElementColor)}:host([design=Default]){color:var(--sapContent_IconColor)}:host([design=Information]){color:var(--sapInformativeElementColor)}:host([design=Negative]){color:var(--sapNegativeElementColor)}:host([design=Neutral]){color:var(--sapNeutralElementColor)}:host([design=NonInteractive]){color:var(--sapContent_NonInteractiveIconColor)}:host([design=Positive]){color:var(--sapPositiveElementColor)}:host([interactive][focused]) .ui5-icon-root{outline:var(--sapContent_FocusWidth) var(--sapContent_FocusStyle) var(--sapContent_FocusColor);border-radius:var(--ui5-icon-focus-border-radius)}.ui5-icon-root{display:flex;height:100%;width:100%;outline:none;vertical-align:top}:host([interactive]){cursor:pointer}.ui5-icon-root:not([dir=ltr]){transform:var(--_ui5_icon_transform_scale);transform-origin:center}" };
var I = globalThis && globalThis.__decorate || function(t, i, a, r) {
  var c = arguments.length, n = c < 3 ? i : r === null ? r = Object.getOwnPropertyDescriptor(i, a) : r, o;
  if (typeof Reflect == "object" && typeof Reflect.decorate == "function")
    n = Reflect.decorate(t, i, a, r);
  else
    for (var s = t.length - 1; s >= 0; s--)
      (o = t[s]) && (n = (c < 3 ? o(n) : c > 3 ? o(i, a, n) : o(i, a)) || n);
  return c > 3 && n && Object.defineProperty(i, a, n), n;
};
const Rt = "ICON_NOT_FOUND", V = "presentation";
let u = class extends C {
  _onFocusInHandler() {
    this.interactive && (this.focused = !0);
  }
  _onFocusOutHandler() {
    this.focused = !1;
  }
  _onkeydown(i) {
    !this.interactive || (pt(i) && this.fireEvent("click"), $(i) && i.preventDefault());
  }
  _onkeyup(i) {
    this.interactive && $(i) && this.fireEvent("click");
  }
  get _dir() {
    return this.ltr ? "ltr" : void 0;
  }
  get effectiveAriaHidden() {
    return this.ariaHidden === "" ? this.isDecorative ? !0 : void 0 : this.ariaHidden;
  }
  get _tabIndex() {
    return this.interactive ? "0" : void 0;
  }
  get isDecorative() {
    return this.effectiveAccessibleRole === V;
  }
  get effectiveAccessibleRole() {
    return this.accessibleRole ? this.accessibleRole : this.interactive ? "button" : this.effectiveAccessibleName ? "img" : V;
  }
  onBeforeRendering() {
    return S(this, null, function* () {
      const i = this.name;
      if (!i)
        return console.warn("Icon name property is required", this);
      let a = z(i);
      if (a || (a = yield Z(i)), !a)
        return this.invalid = !0, console.warn(`Required icon is not registered. Invalid icon name: ${this.name}`);
      if (a === Rt)
        return this.invalid = !0, console.warn(`Required icon is not registered. You can either import the icon as a module in order to use it e.g. "@ui5/webcomponents-icons/dist/${i.replace("sap-icon://", "")}.js", or setup a JSON build step and import "@ui5/webcomponents-icons/dist/AllIcons.js".`);
      if (this.viewBox = a.viewBox || "0 0 512 512", a.customTemplate && (a.pathData = [], this.customSvg = K(a.customTemplate, this)), this.invalid = !1, this.pathData = Array.isArray(a.pathData) ? a.pathData : [a.pathData], this.accData = a.accData, this.ltr = a.ltr, this.packageName = a.packageName, this._onfocusout = this.interactive ? this._onFocusOutHandler.bind(this) : void 0, this._onfocusin = this.interactive ? this._onFocusInHandler.bind(this) : void 0, this.accessibleName)
        this.effectiveAccessibleName = this.accessibleName;
      else if (this.accData) {
        const r = yield Q(this.packageName);
        this.effectiveAccessibleName = r.getText(this.accData) || void 0;
      } else
        this.effectiveAccessibleName = void 0;
    });
  }
  get hasIconTooltip() {
    return this.showTooltip && this.effectiveAccessibleName;
  }
};
I([
  N({ type: x, defaultValue: x.Default })
], u.prototype, "design", void 0);
I([
  N({ type: Boolean })
], u.prototype, "interactive", void 0);
I([
  N()
], u.prototype, "name", void 0);
I([
  N()
], u.prototype, "accessibleName", void 0);
I([
  N({ type: Boolean })
], u.prototype, "showTooltip", void 0);
I([
  N()
], u.prototype, "accessibleRole", void 0);
I([
  N()
], u.prototype, "ariaHidden", void 0);
I([
  N({ multiple: !0 })
], u.prototype, "pathData", void 0);
I([
  N({ type: Object, defaultValue: void 0, noAttribute: !0 })
], u.prototype, "accData", void 0);
I([
  N({ type: Boolean })
], u.prototype, "focused", void 0);
I([
  N({ type: Boolean })
], u.prototype, "invalid", void 0);
I([
  N({ noAttribute: !0, defaultValue: void 0 })
], u.prototype, "effectiveAccessibleName", void 0);
u = I([
  tt({
    tag: "ui5-icon",
    languageAware: !0,
    themeAware: !0,
    renderer: it,
    template: Pt,
    styles: mt
  }),
  ft("click")
], u);
u.define();
const kt = u, Xt = /* @__PURE__ */ Object.freeze(/* @__PURE__ */ Object.defineProperty({
  __proto__: null,
  default: kt
}, Symbol.toStringTag, { value: "Module" }));
export {
  kt as I,
  pt as a,
  xt as b,
  Vt as c,
  Ft as d,
  ft as e,
  Gt as f,
  jt as g,
  wt as h,
  $ as i,
  Lt as j,
  Bt as k,
  Wt as l,
  $t as m,
  Ht as n,
  Xt as o,
  Dt as r
};
//# sourceMappingURL=Icon.7310a395.mjs.map
