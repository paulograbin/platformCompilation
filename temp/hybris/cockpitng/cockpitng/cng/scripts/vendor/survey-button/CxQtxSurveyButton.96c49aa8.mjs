var Rn = Object.defineProperty, xn = Object.defineProperties;
var Kn = Object.getOwnPropertyDescriptors;
var Ar = Object.getOwnPropertySymbols, Mn = Object.getPrototypeOf, kn = Object.prototype.hasOwnProperty, Hn = Object.prototype.propertyIsEnumerable, $n = Reflect.get;
var At = (t, e, r) => e in t ? Rn(t, e, { enumerable: !0, configurable: !0, writable: !0, value: r }) : t[e] = r, St = (t, e) => {
  for (var r in e || (e = {}))
    kn.call(e, r) && At(t, r, e[r]);
  if (Ar)
    for (var r of Ar(e))
      Hn.call(e, r) && At(t, r, e[r]);
  return t;
}, Pt = (t, e) => xn(t, Kn(e));
var Sr = (t, e, r) => (At(t, typeof e != "symbol" ? e + "" : e, r), r);
var wt = (t, e, r) => $n(Mn(t), r, e);
var R = (t, e, r) => new Promise((n, _) => {
  var I = (p) => {
    try {
      h(r.next(p));
    } catch (f) {
      _(f);
    }
  }, v = (p) => {
    try {
      h(r.throw(p));
    } catch (f) {
      _(f);
    }
  }, h = (p) => p.done ? n(p.value) : Promise.resolve(p.value).then(I, v);
  h((r = r.apply(t, e)).next());
});
const Fn = (t, e) => {
  const r = t[e];
  return r ? typeof r == "function" ? r() : Promise.resolve(r) : new Promise((n, _) => {
    (typeof queueMicrotask == "function" ? queueMicrotask : setTimeout)(_.bind(null, new Error("Unknown variable dynamic import: " + e)));
  });
};
/**
 * @license
 * Copyright 2019 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const qe = window, ir = qe.ShadowRoot && (qe.ShadyCSS === void 0 || qe.ShadyCSS.nativeShadow) && "adoptedStyleSheets" in Document.prototype && "replace" in CSSStyleSheet.prototype, ar = Symbol(), Pr = /* @__PURE__ */ new WeakMap();
class bo {
  constructor(e, r, n) {
    if (this._$cssResult$ = !0, n !== ar)
      throw Error("CSSResult is not constructable. Use `unsafeCSS` or `css` instead.");
    this.cssText = e, this.t = r;
  }
  get styleSheet() {
    let e = this.o;
    const r = this.t;
    if (ir && e === void 0) {
      const n = r !== void 0 && r.length === 1;
      n && (e = Pr.get(r)), e === void 0 && ((this.o = e = new CSSStyleSheet()).replaceSync(this.cssText), n && Pr.set(r, e));
    }
    return e;
  }
  toString() {
    return this.cssText;
  }
}
const zn = (t) => new bo(typeof t == "string" ? t : t + "", void 0, ar), Gn = (t, ...e) => {
  const r = t.length === 1 ? t[0] : e.reduce((n, _, I) => n + ((v) => {
    if (v._$cssResult$ === !0)
      return v.cssText;
    if (typeof v == "number")
      return v;
    throw Error("Value passed to 'css' function must be a 'css' function result: " + v + ". Use 'unsafeCSS' to pass non-literal values, but take care to ensure page security.");
  })(_) + t[I + 1], t[0]);
  return new bo(r, t, ar);
}, jn = (t, e) => {
  ir ? t.adoptedStyleSheets = e.map((r) => r instanceof CSSStyleSheet ? r : r.styleSheet) : e.forEach((r) => {
    const n = document.createElement("style"), _ = qe.litNonce;
    _ !== void 0 && n.setAttribute("nonce", _), n.textContent = r.cssText, t.appendChild(n);
  });
}, wr = ir ? (t) => t : (t) => t instanceof CSSStyleSheet ? ((e) => {
  let r = "";
  for (const n of e.cssRules)
    r += n.cssText;
  return zn(r);
})(t) : t;
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
var Dt;
const Je = window, Dr = Je.trustedTypes, qn = Dr ? Dr.emptyScript : "", Br = Je.reactiveElementPolyfillSupport, Qt = { toAttribute(t, e) {
  switch (e) {
    case Boolean:
      t = t ? qn : null;
      break;
    case Object:
    case Array:
      t = t == null ? t : JSON.stringify(t);
  }
  return t;
}, fromAttribute(t, e) {
  let r = t;
  switch (e) {
    case Boolean:
      r = t !== null;
      break;
    case Number:
      r = t === null ? null : Number(t);
      break;
    case Object:
    case Array:
      try {
        r = JSON.parse(t);
      } catch (n) {
        r = null;
      }
  }
  return r;
} }, Io = (t, e) => e !== t && (e == e || t == t), Bt = { attribute: !0, type: String, converter: Qt, reflect: !1, hasChanged: Io };
class pe extends HTMLElement {
  constructor() {
    super(), this._$Ei = /* @__PURE__ */ new Map(), this.isUpdatePending = !1, this.hasUpdated = !1, this._$El = null, this.u();
  }
  static addInitializer(e) {
    var r;
    this.finalize(), ((r = this.h) !== null && r !== void 0 ? r : this.h = []).push(e);
  }
  static get observedAttributes() {
    this.finalize();
    const e = [];
    return this.elementProperties.forEach((r, n) => {
      const _ = this._$Ep(n, r);
      _ !== void 0 && (this._$Ev.set(_, n), e.push(_));
    }), e;
  }
  static createProperty(e, r = Bt) {
    if (r.state && (r.attribute = !1), this.finalize(), this.elementProperties.set(e, r), !r.noAccessor && !this.prototype.hasOwnProperty(e)) {
      const n = typeof e == "symbol" ? Symbol() : "__" + e, _ = this.getPropertyDescriptor(e, n, r);
      _ !== void 0 && Object.defineProperty(this.prototype, e, _);
    }
  }
  static getPropertyDescriptor(e, r, n) {
    return { get() {
      return this[r];
    }, set(_) {
      const I = this[e];
      this[r] = _, this.requestUpdate(e, I, n);
    }, configurable: !0, enumerable: !0 };
  }
  static getPropertyOptions(e) {
    return this.elementProperties.get(e) || Bt;
  }
  static finalize() {
    if (this.hasOwnProperty("finalized"))
      return !1;
    this.finalized = !0;
    const e = Object.getPrototypeOf(this);
    if (e.finalize(), e.h !== void 0 && (this.h = [...e.h]), this.elementProperties = new Map(e.elementProperties), this._$Ev = /* @__PURE__ */ new Map(), this.hasOwnProperty("properties")) {
      const r = this.properties, n = [...Object.getOwnPropertyNames(r), ...Object.getOwnPropertySymbols(r)];
      for (const _ of n)
        this.createProperty(_, r[_]);
    }
    return this.elementStyles = this.finalizeStyles(this.styles), !0;
  }
  static finalizeStyles(e) {
    const r = [];
    if (Array.isArray(e)) {
      const n = new Set(e.flat(1 / 0).reverse());
      for (const _ of n)
        r.unshift(wr(_));
    } else
      e !== void 0 && r.push(wr(e));
    return r;
  }
  static _$Ep(e, r) {
    const n = r.attribute;
    return n === !1 ? void 0 : typeof n == "string" ? n : typeof e == "string" ? e.toLowerCase() : void 0;
  }
  u() {
    var e;
    this._$E_ = new Promise((r) => this.enableUpdating = r), this._$AL = /* @__PURE__ */ new Map(), this._$Eg(), this.requestUpdate(), (e = this.constructor.h) === null || e === void 0 || e.forEach((r) => r(this));
  }
  addController(e) {
    var r, n;
    ((r = this._$ES) !== null && r !== void 0 ? r : this._$ES = []).push(e), this.renderRoot !== void 0 && this.isConnected && ((n = e.hostConnected) === null || n === void 0 || n.call(e));
  }
  removeController(e) {
    var r;
    (r = this._$ES) === null || r === void 0 || r.splice(this._$ES.indexOf(e) >>> 0, 1);
  }
  _$Eg() {
    this.constructor.elementProperties.forEach((e, r) => {
      this.hasOwnProperty(r) && (this._$Ei.set(r, this[r]), delete this[r]);
    });
  }
  createRenderRoot() {
    var e;
    const r = (e = this.shadowRoot) !== null && e !== void 0 ? e : this.attachShadow(this.constructor.shadowRootOptions);
    return jn(r, this.constructor.elementStyles), r;
  }
  connectedCallback() {
    var e;
    this.renderRoot === void 0 && (this.renderRoot = this.createRenderRoot()), this.enableUpdating(!0), (e = this._$ES) === null || e === void 0 || e.forEach((r) => {
      var n;
      return (n = r.hostConnected) === null || n === void 0 ? void 0 : n.call(r);
    });
  }
  enableUpdating(e) {
  }
  disconnectedCallback() {
    var e;
    (e = this._$ES) === null || e === void 0 || e.forEach((r) => {
      var n;
      return (n = r.hostDisconnected) === null || n === void 0 ? void 0 : n.call(r);
    });
  }
  attributeChangedCallback(e, r, n) {
    this._$AK(e, n);
  }
  _$EO(e, r, n = Bt) {
    var _;
    const I = this.constructor._$Ep(e, n);
    if (I !== void 0 && n.reflect === !0) {
      const v = (((_ = n.converter) === null || _ === void 0 ? void 0 : _.toAttribute) !== void 0 ? n.converter : Qt).toAttribute(r, n.type);
      this._$El = e, v == null ? this.removeAttribute(I) : this.setAttribute(I, v), this._$El = null;
    }
  }
  _$AK(e, r) {
    var n;
    const _ = this.constructor, I = _._$Ev.get(e);
    if (I !== void 0 && this._$El !== I) {
      const v = _.getPropertyOptions(I), h = typeof v.converter == "function" ? { fromAttribute: v.converter } : ((n = v.converter) === null || n === void 0 ? void 0 : n.fromAttribute) !== void 0 ? v.converter : Qt;
      this._$El = I, this[I] = h.fromAttribute(r, v.type), this._$El = null;
    }
  }
  requestUpdate(e, r, n) {
    let _ = !0;
    e !== void 0 && (((n = n || this.constructor.getPropertyOptions(e)).hasChanged || Io)(this[e], r) ? (this._$AL.has(e) || this._$AL.set(e, r), n.reflect === !0 && this._$El !== e && (this._$EC === void 0 && (this._$EC = /* @__PURE__ */ new Map()), this._$EC.set(e, n))) : _ = !1), !this.isUpdatePending && _ && (this._$E_ = this._$Ej());
  }
  _$Ej() {
    return R(this, null, function* () {
      this.isUpdatePending = !0;
      try {
        yield this._$E_;
      } catch (r) {
        Promise.reject(r);
      }
      const e = this.scheduleUpdate();
      return e != null && (yield e), !this.isUpdatePending;
    });
  }
  scheduleUpdate() {
    return this.performUpdate();
  }
  performUpdate() {
    var e;
    if (!this.isUpdatePending)
      return;
    this.hasUpdated, this._$Ei && (this._$Ei.forEach((_, I) => this[I] = _), this._$Ei = void 0);
    let r = !1;
    const n = this._$AL;
    try {
      r = this.shouldUpdate(n), r ? (this.willUpdate(n), (e = this._$ES) === null || e === void 0 || e.forEach((_) => {
        var I;
        return (I = _.hostUpdate) === null || I === void 0 ? void 0 : I.call(_);
      }), this.update(n)) : this._$Ek();
    } catch (_) {
      throw r = !1, this._$Ek(), _;
    }
    r && this._$AE(n);
  }
  willUpdate(e) {
  }
  _$AE(e) {
    var r;
    (r = this._$ES) === null || r === void 0 || r.forEach((n) => {
      var _;
      return (_ = n.hostUpdated) === null || _ === void 0 ? void 0 : _.call(n);
    }), this.hasUpdated || (this.hasUpdated = !0, this.firstUpdated(e)), this.updated(e);
  }
  _$Ek() {
    this._$AL = /* @__PURE__ */ new Map(), this.isUpdatePending = !1;
  }
  get updateComplete() {
    return this.getUpdateComplete();
  }
  getUpdateComplete() {
    return this._$E_;
  }
  shouldUpdate(e) {
    return !0;
  }
  update(e) {
    this._$EC !== void 0 && (this._$EC.forEach((r, n) => this._$EO(n, this[n], r)), this._$EC = void 0), this._$Ek();
  }
  updated(e) {
  }
  firstUpdated(e) {
  }
}
pe.finalized = !0, pe.elementProperties = /* @__PURE__ */ new Map(), pe.elementStyles = [], pe.shadowRootOptions = { mode: "open" }, Br == null || Br({ ReactiveElement: pe }), ((Dt = Je.reactiveElementVersions) !== null && Dt !== void 0 ? Dt : Je.reactiveElementVersions = []).push("1.6.1");
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
var Ut;
const Xe = window, be = Xe.trustedTypes, Ur = be ? be.createPolicy("lit-html", { createHTML: (t) => t }) : void 0, re = `lit$${(Math.random() + "").slice(9)}$`, sr = "?" + re, Zn = `<${sr}>`, Ie = document, Ue = (t = "") => Ie.createComment(t), Le = (t) => t === null || typeof t != "object" && typeof t != "function", Eo = Array.isArray, Ao = (t) => Eo(t) || typeof (t == null ? void 0 : t[Symbol.iterator]) == "function", De = /<(?:(!--|\/[^a-zA-Z])|(\/?[a-zA-Z][^>\s]*)|(\/?$))/g, Lr = /-->/g, Nr = />/g, se = RegExp(`>|[ 	
\f\r](?:([^\\s"'>=/]+)([ 	
\f\r]*=[ 	
\f\r]*(?:[^ 	
\f\r"'\`<>=]|("|')|))|$)`, "g"), Or = /'/g, Vr = /"/g, So = /^(?:script|style|textarea|title)$/i, Po = (t) => (e, ...r) => ({ _$litType$: t, strings: e, values: r }), ut = Po(1), Wn = Po(2), le = Symbol.for("lit-noChange"), G = Symbol.for("lit-nothing"), Rr = /* @__PURE__ */ new WeakMap(), ge = Ie.createTreeWalker(Ie, 129, null, !1), wo = (t, e) => {
  const r = t.length - 1, n = [];
  let _, I = e === 2 ? "<svg>" : "", v = De;
  for (let p = 0; p < r; p++) {
    const f = t[p];
    let d, g, C = -1, c = 0;
    for (; c < f.length && (v.lastIndex = c, g = v.exec(f), g !== null); )
      c = v.lastIndex, v === De ? g[1] === "!--" ? v = Lr : g[1] !== void 0 ? v = Nr : g[2] !== void 0 ? (So.test(g[2]) && (_ = RegExp("</" + g[2], "g")), v = se) : g[3] !== void 0 && (v = se) : v === se ? g[0] === ">" ? (v = _ != null ? _ : De, C = -1) : g[1] === void 0 ? C = -2 : (C = v.lastIndex - g[2].length, d = g[1], v = g[3] === void 0 ? se : g[3] === '"' ? Vr : Or) : v === Vr || v === Or ? v = se : v === Lr || v === Nr ? v = De : (v = se, _ = void 0);
    const l = v === se && t[p + 1].startsWith("/>") ? " " : "";
    I += v === De ? f + Zn : C >= 0 ? (n.push(d), f.slice(0, C) + "$lit$" + f.slice(C) + re + l) : f + re + (C === -2 ? (n.push(void 0), p) : l);
  }
  const h = I + (t[r] || "<?>") + (e === 2 ? "</svg>" : "");
  if (!Array.isArray(t) || !t.hasOwnProperty("raw"))
    throw Error("invalid template strings array");
  return [Ur !== void 0 ? Ur.createHTML(h) : h, n];
};
class Ne {
  constructor({ strings: e, _$litType$: r }, n) {
    let _;
    this.parts = [];
    let I = 0, v = 0;
    const h = e.length - 1, p = this.parts, [f, d] = wo(e, r);
    if (this.el = Ne.createElement(f, n), ge.currentNode = this.el.content, r === 2) {
      const g = this.el.content, C = g.firstChild;
      C.remove(), g.append(...C.childNodes);
    }
    for (; (_ = ge.nextNode()) !== null && p.length < h; ) {
      if (_.nodeType === 1) {
        if (_.hasAttributes()) {
          const g = [];
          for (const C of _.getAttributeNames())
            if (C.endsWith("$lit$") || C.startsWith(re)) {
              const c = d[v++];
              if (g.push(C), c !== void 0) {
                const l = _.getAttribute(c.toLowerCase() + "$lit$").split(re), a = /([.?@])?(.*)/.exec(c);
                p.push({ type: 1, index: I, name: a[2], strings: l, ctor: a[1] === "." ? Bo : a[1] === "?" ? Uo : a[1] === "@" ? Lo : Ke });
              } else
                p.push({ type: 6, index: I });
            }
          for (const C of g)
            _.removeAttribute(C);
        }
        if (So.test(_.tagName)) {
          const g = _.textContent.split(re), C = g.length - 1;
          if (C > 0) {
            _.textContent = be ? be.emptyScript : "";
            for (let c = 0; c < C; c++)
              _.append(g[c], Ue()), ge.nextNode(), p.push({ type: 2, index: ++I });
            _.append(g[C], Ue());
          }
        }
      } else if (_.nodeType === 8)
        if (_.data === sr)
          p.push({ type: 2, index: I });
        else {
          let g = -1;
          for (; (g = _.data.indexOf(re, g + 1)) !== -1; )
            p.push({ type: 7, index: I }), g += re.length - 1;
        }
      I++;
    }
  }
  static createElement(e, r) {
    const n = Ie.createElement("template");
    return n.innerHTML = e, n;
  }
}
function ce(t, e, r = t, n) {
  var _, I, v, h;
  if (e === le)
    return e;
  let p = n !== void 0 ? (_ = r._$Co) === null || _ === void 0 ? void 0 : _[n] : r._$Cl;
  const f = Le(e) ? void 0 : e._$litDirective$;
  return (p == null ? void 0 : p.constructor) !== f && ((I = p == null ? void 0 : p._$AO) === null || I === void 0 || I.call(p, !1), f === void 0 ? p = void 0 : (p = new f(t), p._$AT(t, r, n)), n !== void 0 ? ((v = (h = r)._$Co) !== null && v !== void 0 ? v : h._$Co = [])[n] = p : r._$Cl = p), p !== void 0 && (e = ce(t, p._$AS(t, e.values), p, n)), e;
}
class Do {
  constructor(e, r) {
    this.u = [], this._$AN = void 0, this._$AD = e, this._$AM = r;
  }
  get parentNode() {
    return this._$AM.parentNode;
  }
  get _$AU() {
    return this._$AM._$AU;
  }
  v(e) {
    var r;
    const { el: { content: n }, parts: _ } = this._$AD, I = ((r = e == null ? void 0 : e.creationScope) !== null && r !== void 0 ? r : Ie).importNode(n, !0);
    ge.currentNode = I;
    let v = ge.nextNode(), h = 0, p = 0, f = _[0];
    for (; f !== void 0; ) {
      if (h === f.index) {
        let d;
        f.type === 2 ? d = new Ae(v, v.nextSibling, this, e) : f.type === 1 ? d = new f.ctor(v, f.name, f.strings, this, e) : f.type === 6 && (d = new No(v, this, e)), this.u.push(d), f = _[++p];
      }
      h !== (f == null ? void 0 : f.index) && (v = ge.nextNode(), h++);
    }
    return I;
  }
  p(e) {
    let r = 0;
    for (const n of this.u)
      n !== void 0 && (n.strings !== void 0 ? (n._$AI(e, n, r), r += n.strings.length - 2) : n._$AI(e[r])), r++;
  }
}
class Ae {
  constructor(e, r, n, _) {
    var I;
    this.type = 2, this._$AH = G, this._$AN = void 0, this._$AA = e, this._$AB = r, this._$AM = n, this.options = _, this._$Cm = (I = _ == null ? void 0 : _.isConnected) === null || I === void 0 || I;
  }
  get _$AU() {
    var e, r;
    return (r = (e = this._$AM) === null || e === void 0 ? void 0 : e._$AU) !== null && r !== void 0 ? r : this._$Cm;
  }
  get parentNode() {
    let e = this._$AA.parentNode;
    const r = this._$AM;
    return r !== void 0 && e.nodeType === 11 && (e = r.parentNode), e;
  }
  get startNode() {
    return this._$AA;
  }
  get endNode() {
    return this._$AB;
  }
  _$AI(e, r = this) {
    e = ce(this, e, r), Le(e) ? e === G || e == null || e === "" ? (this._$AH !== G && this._$AR(), this._$AH = G) : e !== this._$AH && e !== le && this.g(e) : e._$litType$ !== void 0 ? this.$(e) : e.nodeType !== void 0 ? this.T(e) : Ao(e) ? this.k(e) : this.g(e);
  }
  O(e, r = this._$AB) {
    return this._$AA.parentNode.insertBefore(e, r);
  }
  T(e) {
    this._$AH !== e && (this._$AR(), this._$AH = this.O(e));
  }
  g(e) {
    this._$AH !== G && Le(this._$AH) ? this._$AA.nextSibling.data = e : this.T(Ie.createTextNode(e)), this._$AH = e;
  }
  $(e) {
    var r;
    const { values: n, _$litType$: _ } = e, I = typeof _ == "number" ? this._$AC(e) : (_.el === void 0 && (_.el = Ne.createElement(_.h, this.options)), _);
    if (((r = this._$AH) === null || r === void 0 ? void 0 : r._$AD) === I)
      this._$AH.p(n);
    else {
      const v = new Do(I, this), h = v.v(this.options);
      v.p(n), this.T(h), this._$AH = v;
    }
  }
  _$AC(e) {
    let r = Rr.get(e.strings);
    return r === void 0 && Rr.set(e.strings, r = new Ne(e)), r;
  }
  k(e) {
    Eo(this._$AH) || (this._$AH = [], this._$AR());
    const r = this._$AH;
    let n, _ = 0;
    for (const I of e)
      _ === r.length ? r.push(n = new Ae(this.O(Ue()), this.O(Ue()), this, this.options)) : n = r[_], n._$AI(I), _++;
    _ < r.length && (this._$AR(n && n._$AB.nextSibling, _), r.length = _);
  }
  _$AR(e = this._$AA.nextSibling, r) {
    var n;
    for ((n = this._$AP) === null || n === void 0 || n.call(this, !1, !0, r); e && e !== this._$AB; ) {
      const _ = e.nextSibling;
      e.remove(), e = _;
    }
  }
  setConnected(e) {
    var r;
    this._$AM === void 0 && (this._$Cm = e, (r = this._$AP) === null || r === void 0 || r.call(this, e));
  }
}
class Ke {
  constructor(e, r, n, _, I) {
    this.type = 1, this._$AH = G, this._$AN = void 0, this.element = e, this.name = r, this._$AM = _, this.options = I, n.length > 2 || n[0] !== "" || n[1] !== "" ? (this._$AH = Array(n.length - 1).fill(new String()), this.strings = n) : this._$AH = G;
  }
  get tagName() {
    return this.element.tagName;
  }
  get _$AU() {
    return this._$AM._$AU;
  }
  _$AI(e, r = this, n, _) {
    const I = this.strings;
    let v = !1;
    if (I === void 0)
      e = ce(this, e, r, 0), v = !Le(e) || e !== this._$AH && e !== le, v && (this._$AH = e);
    else {
      const h = e;
      let p, f;
      for (e = I[0], p = 0; p < I.length - 1; p++)
        f = ce(this, h[n + p], r, p), f === le && (f = this._$AH[p]), v || (v = !Le(f) || f !== this._$AH[p]), f === G ? e = G : e !== G && (e += (f != null ? f : "") + I[p + 1]), this._$AH[p] = f;
    }
    v && !_ && this.j(e);
  }
  j(e) {
    e === G ? this.element.removeAttribute(this.name) : this.element.setAttribute(this.name, e != null ? e : "");
  }
}
class Bo extends Ke {
  constructor() {
    super(...arguments), this.type = 3;
  }
  j(e) {
    this.element[this.name] = e === G ? void 0 : e;
  }
}
const Yn = be ? be.emptyScript : "";
class Uo extends Ke {
  constructor() {
    super(...arguments), this.type = 4;
  }
  j(e) {
    e && e !== G ? this.element.setAttribute(this.name, Yn) : this.element.removeAttribute(this.name);
  }
}
class Lo extends Ke {
  constructor(e, r, n, _, I) {
    super(e, r, n, _, I), this.type = 5;
  }
  _$AI(e, r = this) {
    var n;
    if ((e = (n = ce(this, e, r, 0)) !== null && n !== void 0 ? n : G) === le)
      return;
    const _ = this._$AH, I = e === G && _ !== G || e.capture !== _.capture || e.once !== _.once || e.passive !== _.passive, v = e !== G && (_ === G || I);
    I && this.element.removeEventListener(this.name, this, _), v && this.element.addEventListener(this.name, this, e), this._$AH = e;
  }
  handleEvent(e) {
    var r, n;
    typeof this._$AH == "function" ? this._$AH.call((n = (r = this.options) === null || r === void 0 ? void 0 : r.host) !== null && n !== void 0 ? n : this.element, e) : this._$AH.handleEvent(e);
  }
}
class No {
  constructor(e, r, n) {
    this.element = e, this.type = 6, this._$AN = void 0, this._$AM = r, this.options = n;
  }
  get _$AU() {
    return this._$AM._$AU;
  }
  _$AI(e) {
    ce(this, e);
  }
}
const Qn = { P: "$lit$", A: re, M: sr, C: 1, L: wo, R: Do, D: Ao, V: ce, I: Ae, H: Ke, N: Uo, U: Lo, B: Bo, F: No }, xr = Xe.litHtmlPolyfillSupport;
xr == null || xr(Ne, Ae), ((Ut = Xe.litHtmlVersions) !== null && Ut !== void 0 ? Ut : Xe.litHtmlVersions = []).push("2.6.1");
const Jn = (t, e, r) => {
  var n, _;
  const I = (n = r == null ? void 0 : r.renderBefore) !== null && n !== void 0 ? n : e;
  let v = I._$litPart$;
  if (v === void 0) {
    const h = (_ = r == null ? void 0 : r.renderBefore) !== null && _ !== void 0 ? _ : null;
    I._$litPart$ = v = new Ae(e.insertBefore(Ue(), h), h, void 0, r != null ? r : {});
  }
  return v._$AI(t), v;
};
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
var Lt, Nt;
class me extends pe {
  constructor() {
    super(...arguments), this.renderOptions = { host: this }, this._$Do = void 0;
  }
  createRenderRoot() {
    var e, r;
    const n = super.createRenderRoot();
    return (e = (r = this.renderOptions).renderBefore) !== null && e !== void 0 || (r.renderBefore = n.firstChild), n;
  }
  update(e) {
    const r = this.render();
    this.hasUpdated || (this.renderOptions.isConnected = this.isConnected), super.update(e), this._$Do = Jn(r, this.renderRoot, this.renderOptions);
  }
  connectedCallback() {
    var e;
    super.connectedCallback(), (e = this._$Do) === null || e === void 0 || e.setConnected(!0);
  }
  disconnectedCallback() {
    var e;
    super.disconnectedCallback(), (e = this._$Do) === null || e === void 0 || e.setConnected(!1);
  }
  render() {
    return le;
  }
}
me.finalized = !0, me._$litElement$ = !0, (Lt = globalThis.litElementHydrateSupport) === null || Lt === void 0 || Lt.call(globalThis, { LitElement: me });
const Kr = globalThis.litElementPolyfillSupport;
Kr == null || Kr({ LitElement: me });
((Nt = globalThis.litElementVersions) !== null && Nt !== void 0 ? Nt : globalThis.litElementVersions = []).push("3.2.2");
/**
 * @license
 * Copyright 2020 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const { I: Xn } = Qn, ei = (t) => t.strings === void 0, Mr = () => document.createComment(""), ul = (t, e, r) => {
  var n;
  const _ = t._$AA.parentNode, I = e === void 0 ? t._$AB : e._$AA;
  if (r === void 0) {
    const v = _.insertBefore(Mr(), I), h = _.insertBefore(Mr(), I);
    r = new Xn(v, h, t, t.options);
  } else {
    const v = r._$AB.nextSibling, h = r._$AM, p = h !== t;
    if (p) {
      let f;
      (n = r._$AQ) === null || n === void 0 || n.call(r, t), r._$AM = t, r._$AP !== void 0 && (f = t._$AU) !== h._$AU && r._$AP(f);
    }
    if (v !== I || p) {
      let f = r._$AA;
      for (; f !== v; ) {
        const d = f.nextSibling;
        _.insertBefore(f, I), f = d;
      }
    }
  }
  return r;
}, ll = (t, e, r = t) => (t._$AI(e, r), t), ti = {}, cl = (t, e = ti) => t._$AH = e, dl = (t) => t._$AH, pl = (t) => {
  var e;
  (e = t._$AP) === null || e === void 0 || e.call(t, !1, !0);
  let r = t._$AA;
  const n = t._$AB.nextSibling;
  for (; r !== n; ) {
    const _ = r.nextSibling;
    r.remove(), r = _;
  }
};
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const Oo = { ATTRIBUTE: 1, CHILD: 2, PROPERTY: 3, BOOLEAN_ATTRIBUTE: 4, EVENT: 5, ELEMENT: 6 }, Vo = (t) => (...e) => ({ _$litDirective$: t, values: e });
class Ro {
  constructor(e) {
  }
  get _$AU() {
    return this._$AM._$AU;
  }
  _$AT(e, r, n) {
    this._$Ct = e, this._$AM = r, this._$Ci = n;
  }
  _$AS(e, r) {
    return this.update(e, r);
  }
  update(e, r) {
    return this.render(...r);
  }
}
/**
 * @license
 * Copyright 2017 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const Be = (t, e) => {
  var r, n;
  const _ = t._$AN;
  if (_ === void 0)
    return !1;
  for (const I of _)
    (n = (r = I)._$AO) === null || n === void 0 || n.call(r, e, !1), Be(I, e);
  return !0;
}, et = (t) => {
  let e, r;
  do {
    if ((e = t._$AM) === void 0)
      break;
    r = e._$AN, r.delete(t), t = e;
  } while ((r == null ? void 0 : r.size) === 0);
}, xo = (t) => {
  for (let e; e = t._$AM; t = e) {
    let r = e._$AN;
    if (r === void 0)
      e._$AN = r = /* @__PURE__ */ new Set();
    else if (r.has(t))
      break;
    r.add(t), ni(e);
  }
};
function ri(t) {
  this._$AN !== void 0 ? (et(this), this._$AM = t, xo(this)) : this._$AM = t;
}
function oi(t, e = !1, r = 0) {
  const n = this._$AH, _ = this._$AN;
  if (_ !== void 0 && _.size !== 0)
    if (e)
      if (Array.isArray(n))
        for (let I = r; I < n.length; I++)
          Be(n[I], !1), et(n[I]);
      else
        n != null && (Be(n, !1), et(n));
    else
      Be(this, t);
}
const ni = (t) => {
  var e, r, n, _;
  t.type == Oo.CHILD && ((e = (n = t)._$AP) !== null && e !== void 0 || (n._$AP = oi), (r = (_ = t)._$AQ) !== null && r !== void 0 || (_._$AQ = ri));
};
class ii extends Ro {
  constructor() {
    super(...arguments), this._$AN = void 0;
  }
  _$AT(e, r, n) {
    super._$AT(e, r, n), xo(this), this.isConnected = e._$AU;
  }
  _$AO(e, r = !0) {
    var n, _;
    e !== this.isConnected && (this.isConnected = e, e ? (n = this.reconnected) === null || n === void 0 || n.call(this) : (_ = this.disconnected) === null || _ === void 0 || _.call(this)), r && (Be(this, e), et(this));
  }
  setValue(e) {
    if (ei(this._$Ct))
      this._$Ct._$AI(e, this);
    else {
      const r = [...this._$Ct._$AH];
      r[this._$Ci] = e, this._$Ct._$AI(r, this, 0);
    }
  }
  disconnected() {
  }
  reconnected() {
  }
}
/**
 * @license
 * Copyright 2020 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const ai = () => new si();
class si {
}
const Ot = /* @__PURE__ */ new WeakMap(), ui = Vo(class extends ii {
  render(t) {
    return G;
  }
  update(t, [e]) {
    var r;
    const n = e !== this.Y;
    return n && this.Y !== void 0 && this.rt(void 0), (n || this.lt !== this.ct) && (this.Y = e, this.dt = (r = t.options) === null || r === void 0 ? void 0 : r.host, this.rt(this.ct = t.element)), G;
  }
  rt(t) {
    var e;
    if (typeof this.Y == "function") {
      const r = (e = this.dt) !== null && e !== void 0 ? e : globalThis;
      let n = Ot.get(r);
      n === void 0 && (n = /* @__PURE__ */ new WeakMap(), Ot.set(r, n)), n.get(this.Y) !== void 0 && this.Y.call(this.dt, void 0), n.set(this.Y, t), t !== void 0 && this.Y.call(this.dt, t);
    } else
      this.Y.value = t;
  }
  get lt() {
    var t, e, r;
    return typeof this.Y == "function" ? (e = Ot.get((t = this.dt) !== null && t !== void 0 ? t : globalThis)) === null || e === void 0 ? void 0 : e.get(this.Y) : (r = this.Y) === null || r === void 0 ? void 0 : r.value;
  }
  disconnected() {
    this.lt === this.ct && this.rt(void 0);
  }
  reconnected() {
    this.rt(this.ct);
  }
});
/**
 * @license
 * Copyright 2018 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const li = Vo(class extends Ro {
  constructor(t) {
    var e;
    if (super(t), t.type !== Oo.ATTRIBUTE || t.name !== "class" || ((e = t.strings) === null || e === void 0 ? void 0 : e.length) > 2)
      throw Error("`classMap()` can only be used in the `class` attribute and must be the only part in the attribute.");
  }
  render(t) {
    return " " + Object.keys(t).filter((e) => t[e]).join(" ") + " ";
  }
  update(t, [e]) {
    var r, n;
    if (this.nt === void 0) {
      this.nt = /* @__PURE__ */ new Set(), t.strings !== void 0 && (this.st = new Set(t.strings.join(" ").split(/\s/).filter((I) => I !== "")));
      for (const I in e)
        e[I] && !(!((r = this.st) === null || r === void 0) && r.has(I)) && this.nt.add(I);
      return this.render(e);
    }
    const _ = t.element.classList;
    this.nt.forEach((I) => {
      I in e || (_.remove(I), this.nt.delete(I));
    });
    for (const I in e) {
      const v = !!e[I];
      v === this.nt.has(I) || ((n = this.st) === null || n === void 0 ? void 0 : n.has(I)) || (v ? (_.add(I), this.nt.add(I)) : (_.remove(I), this.nt.delete(I)));
    }
    return le;
  }
});
var Ko = { exports: {} };
(function(t, e) {
  (function(r, n) {
    t.exports = n();
  })(self, function() {
    return function() {
      var r = { 831: function(v, h, p) {
        var f, d;
        (function(g, C) {
          f = function() {
            var c = function() {
            }, l = "undefined", a = typeof window !== l && typeof window.navigator !== l && /Trident\/|MSIE /.test(window.navigator.userAgent), m = ["trace", "debug", "info", "warn", "error"];
            function i(U, E) {
              var y = U[E];
              if (typeof y.bind == "function")
                return y.bind(U);
              try {
                return Function.prototype.bind.call(y, U);
              } catch (A) {
                return function() {
                  return Function.prototype.apply.apply(y, [U, arguments]);
                };
              }
            }
            function o() {
              console.log && (console.log.apply ? console.log.apply(console, arguments) : Function.prototype.apply.apply(console.log, [console, arguments])), console.trace && console.trace();
            }
            function s(U, E) {
              for (var y = 0; y < m.length; y++) {
                var A = m[y];
                this[A] = y < U ? c : this.methodFactory(A, U, E);
              }
              this.log = this.debug;
            }
            function u(U, E, y) {
              return function() {
                typeof console !== l && (s.call(this, E, y), this[U].apply(this, arguments));
              };
            }
            function T(U, E, y) {
              return function(A) {
                return A === "debug" && (A = "log"), typeof console !== l && (A === "trace" && a ? o : console[A] !== void 0 ? i(console, A) : console.log !== void 0 ? i(console, "log") : c);
              }(U) || u.apply(this, arguments);
            }
            function S(U, E, y) {
              var A, B = this;
              E = E == null ? "WARN" : E;
              var w = "loglevel";
              function V() {
                var O;
                if (typeof window !== l && w) {
                  try {
                    O = window.localStorage[w];
                  } catch (L) {
                  }
                  if (typeof O === l)
                    try {
                      var H = window.document.cookie, M = H.indexOf(encodeURIComponent(w) + "=");
                      M !== -1 && (O = /^([^;]+)/.exec(H.slice(M))[1]);
                    } catch (L) {
                    }
                  return B.levels[O] === void 0 && (O = void 0), O;
                }
              }
              typeof U == "string" ? w += ":" + U : typeof U == "symbol" && (w = void 0), B.name = U, B.levels = { TRACE: 0, DEBUG: 1, INFO: 2, WARN: 3, ERROR: 4, SILENT: 5 }, B.methodFactory = y || T, B.getLevel = function() {
                return A;
              }, B.setLevel = function(O, H) {
                if (typeof O == "string" && B.levels[O.toUpperCase()] !== void 0 && (O = B.levels[O.toUpperCase()]), !(typeof O == "number" && O >= 0 && O <= B.levels.SILENT))
                  throw "log.setLevel() called with invalid level: " + O;
                if (A = O, H !== !1 && function(M) {
                  var L = (m[M] || "silent").toUpperCase();
                  if (typeof window !== l && w) {
                    try {
                      return void (window.localStorage[w] = L);
                    } catch (x) {
                    }
                    try {
                      window.document.cookie = encodeURIComponent(w) + "=" + L + ";";
                    } catch (x) {
                    }
                  }
                }(O), s.call(B, O, U), typeof console === l && O < B.levels.SILENT)
                  return "No console available for logging";
              }, B.setDefaultLevel = function(O) {
                E = O, V() || B.setLevel(O, !1);
              }, B.resetLevel = function() {
                B.setLevel(E, !1), function() {
                  if (typeof window !== l && w) {
                    try {
                      return void window.localStorage.removeItem(w);
                    } catch (O) {
                    }
                    try {
                      window.document.cookie = encodeURIComponent(w) + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
                    } catch (O) {
                    }
                  }
                }();
              }, B.enableAll = function(O) {
                B.setLevel(B.levels.TRACE, O);
              }, B.disableAll = function(O) {
                B.setLevel(B.levels.SILENT, O);
              };
              var N = V();
              N == null && (N = E), B.setLevel(N, !1);
            }
            var P = new S(), b = {};
            P.getLogger = function(U) {
              if (typeof U != "symbol" && typeof U != "string" || U === "")
                throw new TypeError("You must supply a name when creating a logger.");
              var E = b[U];
              return E || (E = b[U] = new S(U, P.getLevel(), P.methodFactory)), E;
            };
            var D = typeof window !== l ? window.log : void 0;
            return P.noConflict = function() {
              return typeof window !== l && window.log === P && (window.log = D), P;
            }, P.getLoggers = function() {
              return b;
            }, P.default = P, P;
          }, (d = f.call(h, p, h, v)) === void 0 || (v.exports = d);
        })();
      }, 3819: function(v, h, p) {
        var f;
        (function(d, g) {
          var C = "function", c = "undefined", l = "object", a = "string", m = "major", i = "model", o = "name", s = "type", u = "vendor", T = "version", S = "architecture", P = "console", b = "mobile", D = "tablet", U = "smarttv", E = "wearable", y = "embedded", A = "Amazon", B = "Apple", w = "ASUS", V = "BlackBerry", N = "Browser", O = "Chrome", H = "Firefox", M = "Google", L = "Huawei", x = "LG", ie = "Microsoft", gr = "Motorola", He = "Opera", Tt = "Samsung", mr = "Sharp", $e = "Sony", vt = "Xiaomi", bt = "Zebra", yr = "Facebook", Tr = "Chromium OS", vr = "Mac OS", Fe = function(F) {
            for (var z = {}, k = 0; k < F.length; k++)
              z[F[k].toUpperCase()] = F[k];
            return z;
          }, br = function(F, z) {
            return typeof F === a && Pe(z).indexOf(Pe(F)) !== -1;
          }, Pe = function(F) {
            return F.toLowerCase();
          }, It = function(F, z) {
            if (typeof F === a)
              return F = F.replace(/^\s\s*/, ""), typeof z === c ? F : F.substring(0, 350);
          }, we = function(F, z) {
            for (var k, q, X, $, te, K, Z = 0; Z < z.length && !te; ) {
              var ae = z[Z], ee = z[Z + 1];
              for (k = q = 0; k < ae.length && !te && ae[k]; )
                if (te = ae[k++].exec(F))
                  for (X = 0; X < ee.length; X++)
                    K = te[++q], typeof ($ = ee[X]) === l && $.length > 0 ? $.length === 2 ? typeof $[1] == C ? this[$[0]] = $[1].call(this, K) : this[$[0]] = $[1] : $.length === 3 ? typeof $[1] !== C || $[1].exec && $[1].test ? this[$[0]] = K ? K.replace($[1], $[2]) : g : this[$[0]] = K ? $[1].call(this, K, $[2]) : g : $.length === 4 && (this[$[0]] = K ? $[3].call(this, K.replace($[1], $[2])) : g) : this[$] = K || g;
              Z += 2;
            }
          }, Et = function(F, z) {
            for (var k in z)
              if (typeof z[k] === l && z[k].length > 0) {
                for (var q = 0; q < z[k].length; q++)
                  if (br(z[k][q], F))
                    return k === "?" ? g : k;
              } else if (br(z[k], F))
                return k === "?" ? g : k;
            return F;
          }, Ir = { ME: "4.90", "NT 3.11": "NT3.51", "NT 4.0": "NT4.0", 2e3: "NT 5.0", XP: ["NT 5.1", "NT 5.2"], Vista: "NT 6.0", 7: "NT 6.1", 8: "NT 6.2", 8.1: "NT 6.3", 10: ["NT 6.4", "NT 10.0"], RT: "ARM" }, Er = { browser: [[/\b(?:crmo|crios)\/([\w\.]+)/i], [T, [o, "Chrome"]], [/edg(?:e|ios|a)?\/([\w\.]+)/i], [T, [o, "Edge"]], [/(opera mini)\/([-\w\.]+)/i, /(opera [mobiletab]{3,6})\b.+version\/([-\w\.]+)/i, /(opera)(?:.+version\/|[\/ ]+)([\w\.]+)/i], [o, T], [/opios[\/ ]+([\w\.]+)/i], [T, [o, He + " Mini"]], [/\bopr\/([\w\.]+)/i], [T, [o, He]], [/(kindle)\/([\w\.]+)/i, /(lunascape|maxthon|netfront|jasmine|blazer)[\/ ]?([\w\.]*)/i, /(avant |iemobile|slim)(?:browser)?[\/ ]?([\w\.]*)/i, /(ba?idubrowser)[\/ ]?([\w\.]+)/i, /(?:ms|\()(ie) ([\w\.]+)/i, /(flock|rockmelt|midori|epiphany|silk|skyfire|bolt|iron|vivaldi|iridium|phantomjs|bowser|quark|qupzilla|falkon|rekonq|puffin|brave|whale(?!.+naver)|qqbrowserlite|qq|duckduckgo)\/([-\w\.]+)/i, /(heytap|ovi)browser\/([\d\.]+)/i, /(weibo)__([\d\.]+)/i], [o, T], [/(?:\buc? ?browser|(?:juc.+)ucweb)[\/ ]?([\w\.]+)/i], [T, [o, "UC" + N]], [/microm.+\bqbcore\/([\w\.]+)/i, /\bqbcore\/([\w\.]+).+microm/i], [T, [o, "WeChat(Win) Desktop"]], [/micromessenger\/([\w\.]+)/i], [T, [o, "WeChat"]], [/konqueror\/([\w\.]+)/i], [T, [o, "Konqueror"]], [/trident.+rv[: ]([\w\.]{1,9})\b.+like gecko/i], [T, [o, "IE"]], [/ya(?:search)?browser\/([\w\.]+)/i], [T, [o, "Yandex"]], [/(avast|avg)\/([\w\.]+)/i], [[o, /(.+)/, "$1 Secure " + N], T], [/\bfocus\/([\w\.]+)/i], [T, [o, H + " Focus"]], [/\bopt\/([\w\.]+)/i], [T, [o, He + " Touch"]], [/coc_coc\w+\/([\w\.]+)/i], [T, [o, "Coc Coc"]], [/dolfin\/([\w\.]+)/i], [T, [o, "Dolphin"]], [/coast\/([\w\.]+)/i], [T, [o, He + " Coast"]], [/miuibrowser\/([\w\.]+)/i], [T, [o, "MIUI " + N]], [/fxios\/([-\w\.]+)/i], [T, [o, H]], [/\bqihu|(qi?ho?o?|360)browser/i], [[o, "360 " + N]], [/(oculus|samsung|sailfish|huawei)browser\/([\w\.]+)/i], [[o, /(.+)/, "$1 " + N], T], [/(comodo_dragon)\/([\w\.]+)/i], [[o, /_/g, " "], T], [/(electron)\/([\w\.]+) safari/i, /(tesla)(?: qtcarbrowser|\/(20\d\d\.[-\w\.]+))/i, /m?(qqbrowser|baiduboxapp|2345Explorer)[\/ ]?([\w\.]+)/i], [o, T], [/(metasr)[\/ ]?([\w\.]+)/i, /(lbbrowser)/i, /\[(linkedin)app\]/i], [o], [/((?:fban\/fbios|fb_iab\/fb4a)(?!.+fbav)|;fbav\/([\w\.]+);)/i], [[o, yr], T], [/(kakao(?:talk|story))[\/ ]([\w\.]+)/i, /(naver)\(.*?(\d+\.[\w\.]+).*\)/i, /safari (line)\/([\w\.]+)/i, /\b(line)\/([\w\.]+)\/iab/i, /(chromium|instagram|snapchat)[\/ ]([-\w\.]+)/i], [o, T], [/\bgsa\/([\w\.]+) .*safari\//i], [T, [o, "GSA"]], [/musical_ly(?:.+app_?version\/|_)([\w\.]+)/i], [T, [o, "TikTok"]], [/headlesschrome(?:\/([\w\.]+)| )/i], [T, [o, O + " Headless"]], [/ wv\).+(chrome)\/([\w\.]+)/i], [[o, O + " WebView"], T], [/droid.+ version\/([\w\.]+)\b.+(?:mobile safari|safari)/i], [T, [o, "Android " + N]], [/(chrome|omniweb|arora|[tizenoka]{5} ?browser)\/v?([\w\.]+)/i], [o, T], [/version\/([\w\.\,]+) .*mobile\/\w+ (safari)/i], [T, [o, "Mobile Safari"]], [/version\/([\w(\.|\,)]+) .*(mobile ?safari|safari)/i], [T, o], [/webkit.+?(mobile ?safari|safari)(\/[\w\.]+)/i], [o, [T, Et, { "1.0": "/8", 1.2: "/1", 1.3: "/3", "2.0": "/412", "2.0.2": "/416", "2.0.3": "/417", "2.0.4": "/419", "?": "/" }]], [/(webkit|khtml)\/([\w\.]+)/i], [o, T], [/(navigator|netscape\d?)\/([-\w\.]+)/i], [[o, "Netscape"], T], [/mobile vr; rv:([\w\.]+)\).+firefox/i], [T, [o, H + " Reality"]], [/ekiohf.+(flow)\/([\w\.]+)/i, /(swiftfox)/i, /(icedragon|iceweasel|camino|chimera|fennec|maemo browser|minimo|conkeror|klar)[\/ ]?([\w\.\+]+)/i, /(seamonkey|k-meleon|icecat|iceape|firebird|phoenix|palemoon|basilisk|waterfox)\/([-\w\.]+)$/i, /(firefox)\/([\w\.]+)/i, /(mozilla)\/([\w\.]+) .+rv\:.+gecko\/\d+/i, /(polaris|lynx|dillo|icab|doris|amaya|w3m|netsurf|sleipnir|obigo|mosaic|(?:go|ice|up)[\. ]?browser)[-\/ ]?v?([\w\.]+)/i, /(links) \(([\w\.]+)/i, /panasonic;(viera)/i], [o, T], [/(cobalt)\/([\w\.]+)/i], [o, [T, /master.|lts./, ""]]], cpu: [[/(?:(amd|x(?:(?:86|64)[-_])?|wow|win)64)[;\)]/i], [[S, "amd64"]], [/(ia32(?=;))/i], [[S, Pe]], [/((?:i[346]|x)86)[;\)]/i], [[S, "ia32"]], [/\b(aarch64|arm(v?8e?l?|_?64))\b/i], [[S, "arm64"]], [/\b(arm(?:v[67])?ht?n?[fl]p?)\b/i], [[S, "armhf"]], [/windows (ce|mobile); ppc;/i], [[S, "arm"]], [/((?:ppc|powerpc)(?:64)?)(?: mac|;|\))/i], [[S, /ower/, "", Pe]], [/(sun4\w)[;\)]/i], [[S, "sparc"]], [/((?:avr32|ia64(?=;))|68k(?=\))|\barm(?=v(?:[1-7]|[5-7]1)l?|;|eabi)|(?=atmel )avr|(?:irix|mips|sparc)(?:64)?\b|pa-risc)/i], [[S, Pe]]], device: [[/\b(sch-i[89]0\d|shw-m380s|sm-[ptx]\w{2,4}|gt-[pn]\d{2,4}|sgh-t8[56]9|nexus 10)/i], [i, [u, Tt], [s, D]], [/\b((?:s[cgp]h|gt|sm)-\w+|sc[g-]?[\d]+a?|galaxy nexus)/i, /samsung[- ]([-\w]+)/i, /sec-(sgh\w+)/i], [i, [u, Tt], [s, b]], [/(?:\/|\()(ip(?:hone|od)[\w, ]*)(?:\/|;)/i], [i, [u, B], [s, b]], [/\((ipad);[-\w\),; ]+apple/i, /applecoremedia\/[\w\.]+ \((ipad)/i, /\b(ipad)\d\d?,\d\d?[;\]].+ios/i], [i, [u, B], [s, D]], [/(macintosh);/i], [i, [u, B]], [/\b(sh-?[altvz]?\d\d[a-ekm]?)/i], [i, [u, mr], [s, b]], [/\b((?:ag[rs][23]?|bah2?|sht?|btv)-a?[lw]\d{2})\b(?!.+d\/s)/i], [i, [u, L], [s, D]], [/(?:huawei|honor)([-\w ]+)[;\)]/i, /\b(nexus 6p|\w{2,4}e?-[atu]?[ln][\dx][012359c][adn]?)\b(?!.+d\/s)/i], [i, [u, L], [s, b]], [/\b(poco[\w ]+|m2\d{3}j\d\d[a-z]{2})(?: bui|\))/i, /\b; (\w+) build\/hm\1/i, /\b(hm[-_ ]?note?[_ ]?(?:\d\w)?) bui/i, /\b(redmi[\-_ ]?(?:note|k)?[\w_ ]+)(?: bui|\))/i, /\b(mi[-_ ]?(?:a\d|one|one[_ ]plus|note lte|max|cc)?[_ ]?(?:\d?\w?)[_ ]?(?:plus|se|lite)?)(?: bui|\))/i], [[i, /_/g, " "], [u, vt], [s, b]], [/\b(mi[-_ ]?(?:pad)(?:[\w_ ]+))(?: bui|\))/i], [[i, /_/g, " "], [u, vt], [s, D]], [/; (\w+) bui.+ oppo/i, /\b(cph[12]\d{3}|p(?:af|c[al]|d\w|e[ar])[mt]\d0|x9007|a101op)\b/i], [i, [u, "OPPO"], [s, b]], [/vivo (\w+)(?: bui|\))/i, /\b(v[12]\d{3}\w?[at])(?: bui|;)/i], [i, [u, "Vivo"], [s, b]], [/\b(rmx[12]\d{3})(?: bui|;|\))/i], [i, [u, "Realme"], [s, b]], [/\b(milestone|droid(?:[2-4x]| (?:bionic|x2|pro|razr))?:?( 4g)?)\b[\w ]+build\//i, /\bmot(?:orola)?[- ](\w*)/i, /((?:moto[\w\(\) ]+|xt\d{3,4}|nexus 6)(?= bui|\)))/i], [i, [u, gr], [s, b]], [/\b(mz60\d|xoom[2 ]{0,2}) build\//i], [i, [u, gr], [s, D]], [/((?=lg)?[vl]k\-?\d{3}) bui| 3\.[-\w; ]{10}lg?-([06cv9]{3,4})/i], [i, [u, x], [s, D]], [/(lm(?:-?f100[nv]?|-[\w\.]+)(?= bui|\))|nexus [45])/i, /\blg[-e;\/ ]+((?!browser|netcast|android tv)\w+)/i, /\blg-?([\d\w]+) bui/i], [i, [u, x], [s, b]], [/(ideatab[-\w ]+)/i, /lenovo ?(s[56]000[-\w]+|tab(?:[\w ]+)|yt[-\d\w]{6}|tb[-\d\w]{6})/i], [i, [u, "Lenovo"], [s, D]], [/(?:maemo|nokia).*(n900|lumia \d+)/i, /nokia[-_ ]?([-\w\.]*)/i], [[i, /_/g, " "], [u, "Nokia"], [s, b]], [/(pixel c)\b/i], [i, [u, M], [s, D]], [/droid.+; (pixel[\daxl ]{0,6})(?: bui|\))/i], [i, [u, M], [s, b]], [/droid.+ (a?\d[0-2]{2}so|[c-g]\d{4}|so[-gl]\w+|xq-a\w[4-7][12])(?= bui|\).+chrome\/(?![1-6]{0,1}\d\.))/i], [i, [u, $e], [s, b]], [/sony tablet [ps]/i, /\b(?:sony)?sgp\w+(?: bui|\))/i], [[i, "Xperia Tablet"], [u, $e], [s, D]], [/ (kb2005|in20[12]5|be20[12][59])\b/i, /(?:one)?(?:plus)? (a\d0\d\d)(?: b|\))/i], [i, [u, "OnePlus"], [s, b]], [/(alexa)webm/i, /(kf[a-z]{2}wi|aeo[c-r]{2})( bui|\))/i, /(kf[a-z]+)( bui|\)).+silk\//i], [i, [u, A], [s, D]], [/((?:sd|kf)[0349hijorstuw]+)( bui|\)).+silk\//i], [[i, /(.+)/g, "Fire Phone $1"], [u, A], [s, b]], [/(playbook);[-\w\),; ]+(rim)/i], [i, u, [s, D]], [/\b((?:bb[a-f]|st[hv])100-\d)/i, /\(bb10; (\w+)/i], [i, [u, V], [s, b]], [/(?:\b|asus_)(transfo[prime ]{4,10} \w+|eeepc|slider \w+|nexus 7|padfone|p00[cj])/i], [i, [u, w], [s, D]], [/ (z[bes]6[027][012][km][ls]|zenfone \d\w?)\b/i], [i, [u, w], [s, b]], [/(nexus 9)/i], [i, [u, "HTC"], [s, D]], [/(htc)[-;_ ]{1,2}([\w ]+(?=\)| bui)|\w+)/i, /(zte)[- ]([\w ]+?)(?: bui|\/|\))/i, /(alcatel|geeksphone|nexian|panasonic(?!(?:;|\.))|sony(?!-bra))[-_ ]?([-\w]*)/i], [u, [i, /_/g, " "], [s, b]], [/droid.+; ([ab][1-7]-?[0178a]\d\d?)/i], [i, [u, "Acer"], [s, D]], [/droid.+; (m[1-5] note) bui/i, /\bmz-([-\w]{2,})/i], [i, [u, "Meizu"], [s, b]], [/(blackberry|benq|palm(?=\-)|sonyericsson|acer|asus|dell|meizu|motorola|polytron|infinix|tecno)[-_ ]?([-\w]*)/i, /(hp) ([\w ]+\w)/i, /(asus)-?(\w+)/i, /(microsoft); (lumia[\w ]+)/i, /(lenovo)[-_ ]?([-\w]+)/i, /(jolla)/i, /(oppo) ?([\w ]+) bui/i], [u, i, [s, b]], [/(kobo)\s(ereader|touch)/i, /(archos) (gamepad2?)/i, /(hp).+(touchpad(?!.+tablet)|tablet)/i, /(kindle)\/([\w\.]+)/i, /(nook)[\w ]+build\/(\w+)/i, /(dell) (strea[kpr\d ]*[\dko])/i, /(le[- ]+pan)[- ]+(\w{1,9}) bui/i, /(trinity)[- ]*(t\d{3}) bui/i, /(gigaset)[- ]+(q\w{1,9}) bui/i, /(vodafone) ([\w ]+)(?:\)| bui)/i], [u, i, [s, D]], [/(surface duo)/i], [i, [u, ie], [s, D]], [/droid [\d\.]+; (fp\du?)(?: b|\))/i], [i, [u, "Fairphone"], [s, b]], [/(u304aa)/i], [i, [u, "AT&T"], [s, b]], [/\bsie-(\w*)/i], [i, [u, "Siemens"], [s, b]], [/\b(rct\w+) b/i], [i, [u, "RCA"], [s, D]], [/\b(venue[\d ]{2,7}) b/i], [i, [u, "Dell"], [s, D]], [/\b(q(?:mv|ta)\w+) b/i], [i, [u, "Verizon"], [s, D]], [/\b(?:barnes[& ]+noble |bn[rt])([\w\+ ]*) b/i], [i, [u, "Barnes & Noble"], [s, D]], [/\b(tm\d{3}\w+) b/i], [i, [u, "NuVision"], [s, D]], [/\b(k88) b/i], [i, [u, "ZTE"], [s, D]], [/\b(nx\d{3}j) b/i], [i, [u, "ZTE"], [s, b]], [/\b(gen\d{3}) b.+49h/i], [i, [u, "Swiss"], [s, b]], [/\b(zur\d{3}) b/i], [i, [u, "Swiss"], [s, D]], [/\b((zeki)?tb.*\b) b/i], [i, [u, "Zeki"], [s, D]], [/\b([yr]\d{2}) b/i, /\b(dragon[- ]+touch |dt)(\w{5}) b/i], [[u, "Dragon Touch"], i, [s, D]], [/\b(ns-?\w{0,9}) b/i], [i, [u, "Insignia"], [s, D]], [/\b((nxa|next)-?\w{0,9}) b/i], [i, [u, "NextBook"], [s, D]], [/\b(xtreme\_)?(v(1[045]|2[015]|[3469]0|7[05])) b/i], [[u, "Voice"], i, [s, b]], [/\b(lvtel\-)?(v1[12]) b/i], [[u, "LvTel"], i, [s, b]], [/\b(ph-1) /i], [i, [u, "Essential"], [s, b]], [/\b(v(100md|700na|7011|917g).*\b) b/i], [i, [u, "Envizen"], [s, D]], [/\b(trio[-\w\. ]+) b/i], [i, [u, "MachSpeed"], [s, D]], [/\btu_(1491) b/i], [i, [u, "Rotor"], [s, D]], [/(shield[\w ]+) b/i], [i, [u, "Nvidia"], [s, D]], [/(sprint) (\w+)/i], [u, i, [s, b]], [/(kin\.[onetw]{3})/i], [[i, /\./g, " "], [u, ie], [s, b]], [/droid.+; (cc6666?|et5[16]|mc[239][23]x?|vc8[03]x?)\)/i], [i, [u, bt], [s, D]], [/droid.+; (ec30|ps20|tc[2-8]\d[kx])\)/i], [i, [u, bt], [s, b]], [/smart-tv.+(samsung)/i], [u, [s, U]], [/hbbtv.+maple;(\d+)/i], [[i, /^/, "SmartTV"], [u, Tt], [s, U]], [/(nux; netcast.+smarttv|lg (netcast\.tv-201\d|android tv))/i], [[u, x], [s, U]], [/(apple) ?tv/i], [u, [i, B + " TV"], [s, U]], [/crkey/i], [[i, O + "cast"], [u, M], [s, U]], [/droid.+aft(\w+)( bui|\))/i], [i, [u, A], [s, U]], [/\(dtv[\);].+(aquos)/i, /(aquos-tv[\w ]+)\)/i], [i, [u, mr], [s, U]], [/(bravia[\w ]+)( bui|\))/i], [i, [u, $e], [s, U]], [/(mitv-\w{5}) bui/i], [i, [u, vt], [s, U]], [/Hbbtv.*(technisat) (.*);/i], [u, i, [s, U]], [/\b(roku)[\dx]*[\)\/]((?:dvp-)?[\d\.]*)/i, /hbbtv\/\d+\.\d+\.\d+ +\([\w\+ ]*; *([\w\d][^;]*);([^;]*)/i], [[u, It], [i, It], [s, U]], [/\b(android tv|smart[- ]?tv|opera tv|tv; rv:)\b/i], [[s, U]], [/(ouya)/i, /(nintendo) ([wids3utch]+)/i], [u, i, [s, P]], [/droid.+; (shield) bui/i], [i, [u, "Nvidia"], [s, P]], [/(playstation [345portablevi]+)/i], [i, [u, $e], [s, P]], [/\b(xbox(?: one)?(?!; xbox))[\); ]/i], [i, [u, ie], [s, P]], [/((pebble))app/i], [u, i, [s, E]], [/(watch)(?: ?os[,\/]|\d,\d\/)[\d\.]+/i], [i, [u, B], [s, E]], [/droid.+; (glass) \d/i], [i, [u, M], [s, E]], [/droid.+; (wt63?0{2,3})\)/i], [i, [u, bt], [s, E]], [/(quest( 2| pro)?)/i], [i, [u, yr], [s, E]], [/(tesla)(?: qtcarbrowser|\/[-\w\.]+)/i], [u, [s, y]], [/(aeobc)\b/i], [i, [u, A], [s, y]], [/droid .+?; ([^;]+?)(?: bui|\) applew).+? mobile safari/i], [i, [s, b]], [/droid .+?; ([^;]+?)(?: bui|\) applew).+?(?! mobile) safari/i], [i, [s, D]], [/\b((tablet|tab)[;\/]|focus\/\d(?!.+mobile))/i], [[s, D]], [/(phone|mobile(?:[;\/]| [ \w\/\.]*safari)|pda(?=.+windows ce))/i], [[s, b]], [/(android[-\w\. ]{0,9});.+buil/i], [i, [u, "Generic"]]], engine: [[/windows.+ edge\/([\w\.]+)/i], [T, [o, "EdgeHTML"]], [/webkit\/537\.36.+chrome\/(?!27)([\w\.]+)/i], [T, [o, "Blink"]], [/(presto)\/([\w\.]+)/i, /(webkit|trident|netfront|netsurf|amaya|lynx|w3m|goanna)\/([\w\.]+)/i, /ekioh(flow)\/([\w\.]+)/i, /(khtml|tasman|links)[\/ ]\(?([\w\.]+)/i, /(icab)[\/ ]([23]\.[\d\.]+)/i, /\b(libweb)/i], [o, T], [/rv\:([\w\.]{1,9})\b.+(gecko)/i], [T, o]], os: [[/microsoft (windows) (vista|xp)/i], [o, T], [/(windows) nt 6\.2; (arm)/i, /(windows (?:phone(?: os)?|mobile))[\/ ]?([\d\.\w ]*)/i, /(windows)[\/ ]?([ntce\d\. ]+\w)(?!.+xbox)/i], [o, [T, Et, Ir]], [/(win(?=3|9|n)|win 9x )([nt\d\.]+)/i], [[o, "Windows"], [T, Et, Ir]], [/ip[honead]{2,4}\b(?:.*os ([\w]+) like mac|; opera)/i, /(?:ios;fbsv\/|iphone.+ios[\/ ])([\d\.]+)/i, /cfnetwork\/.+darwin/i], [[T, /_/g, "."], [o, "iOS"]], [/(mac os x) ?([\w\. ]*)/i, /(macintosh|mac_powerpc\b)(?!.+haiku)/i], [[o, vr], [T, /_/g, "."]], [/droid ([\w\.]+)\b.+(android[- ]x86|harmonyos)/i], [T, o], [/(android|webos|qnx|bada|rim tablet os|maemo|meego|sailfish)[-\/ ]?([\w\.]*)/i, /(blackberry)\w*\/([\w\.]*)/i, /(tizen|kaios)[\/ ]([\w\.]+)/i, /\((series40);/i], [o, T], [/\(bb(10);/i], [T, [o, V]], [/(?:symbian ?os|symbos|s60(?=;)|series60)[-\/ ]?([\w\.]*)/i], [T, [o, "Symbian"]], [/mozilla\/[\d\.]+ \((?:mobile|tablet|tv|mobile; [\w ]+); rv:.+ gecko\/([\w\.]+)/i], [T, [o, H + " OS"]], [/web0s;.+rt(tv)/i, /\b(?:hp)?wos(?:browser)?\/([\w\.]+)/i], [T, [o, "webOS"]], [/watch(?: ?os[,\/]|\d,\d\/)([\d\.]+)/i], [T, [o, "watchOS"]], [/crkey\/([\d\.]+)/i], [T, [o, O + "cast"]], [/(cros) [\w]+(?:\)| ([\w\.]+)\b)/i], [[o, Tr], T], [/panasonic;(viera)/i, /(netrange)mmh/i, /(nettv)\/(\d+\.[\w\.]+)/i, /(nintendo|playstation) ([wids345portablevuch]+)/i, /(xbox); +xbox ([^\);]+)/i, /\b(joli|palm)\b ?(?:os)?\/?([\w\.]*)/i, /(mint)[\/\(\) ]?(\w*)/i, /(mageia|vectorlinux)[; ]/i, /([kxln]?ubuntu|debian|suse|opensuse|gentoo|arch(?= linux)|slackware|fedora|mandriva|centos|pclinuxos|red ?hat|zenwalk|linpus|raspbian|plan 9|minix|risc os|contiki|deepin|manjaro|elementary os|sabayon|linspire)(?: gnu\/linux)?(?: enterprise)?(?:[- ]linux)?(?:-gnu)?[-\/ ]?(?!chrom|package)([-\w\.]*)/i, /(hurd|linux) ?([\w\.]*)/i, /(gnu) ?([\w\.]*)/i, /\b([-frentopcghs]{0,5}bsd|dragonfly)[\/ ]?(?!amd|[ix346]{1,2}86)([\w\.]*)/i, /(haiku) (\w+)/i], [o, T], [/(sunos) ?([\w\.\d]*)/i], [[o, "Solaris"], T], [/((?:open)?solaris)[-\/ ]?([\w\.]*)/i, /(aix) ((\d)(?=\.|\)| )[\w\.])*/i, /\b(beos|os\/2|amigaos|morphos|openvms|fuchsia|hp-ux|serenityos)/i, /(unix) ?([\w\.]*)/i], [o, T]] }, Y = function(F, z) {
            if (typeof F === l && (z = F, F = g), !(this instanceof Y))
              return new Y(F, z).getResult();
            var k = typeof d !== c && d.navigator ? d.navigator : g, q = F || (k && k.userAgent ? k.userAgent : ""), X = k && k.userAgentData ? k.userAgentData : g, $ = z ? function(K, Z) {
              var ae = {};
              for (var ee in K)
                Z[ee] && Z[ee].length % 2 == 0 ? ae[ee] = Z[ee].concat(K[ee]) : ae[ee] = K[ee];
              return ae;
            }(Er, z) : Er, te = k && k.userAgent == q;
            return this.getBrowser = function() {
              var K, Z = {};
              return Z[o] = g, Z[T] = g, we.call(Z, q, $.browser), Z[m] = typeof (K = Z[T]) === a ? K.replace(/[^\d\.]/g, "").split(".")[0] : g, te && k && k.brave && typeof k.brave.isBrave == C && (Z[o] = "Brave"), Z;
            }, this.getCPU = function() {
              var K = {};
              return K[S] = g, we.call(K, q, $.cpu), K;
            }, this.getDevice = function() {
              var K = {};
              return K[u] = g, K[i] = g, K[s] = g, we.call(K, q, $.device), te && !K[s] && X && X.mobile && (K[s] = b), te && K[i] == "Macintosh" && k && typeof k.standalone !== c && k.maxTouchPoints && k.maxTouchPoints > 2 && (K[i] = "iPad", K[s] = D), K;
            }, this.getEngine = function() {
              var K = {};
              return K[o] = g, K[T] = g, we.call(K, q, $.engine), K;
            }, this.getOS = function() {
              var K = {};
              return K[o] = g, K[T] = g, we.call(K, q, $.os), te && !K[o] && X && X.platform != "Unknown" && (K[o] = X.platform.replace(/chrome os/i, Tr).replace(/macos/i, vr)), K;
            }, this.getResult = function() {
              return { ua: this.getUA(), browser: this.getBrowser(), engine: this.getEngine(), os: this.getOS(), device: this.getDevice(), cpu: this.getCPU() };
            }, this.getUA = function() {
              return q;
            }, this.setUA = function(K) {
              return q = typeof K === a && K.length > 350 ? It(K, 350) : K, this;
            }, this.setUA(q), this;
          };
          Y.VERSION = "1.0.36", Y.BROWSER = Fe([o, T, m]), Y.CPU = Fe([S]), Y.DEVICE = Fe([i, u, s, P, b, U, D, E, y]), Y.ENGINE = Y.OS = Fe([o, T]), typeof h !== c ? (v.exports && (h = v.exports = Y), h.UAParser = Y) : p.amdO ? (f = function() {
            return Y;
          }.call(h, p, h, v)) === g || (v.exports = f) : typeof d !== c && (d.UAParser = Y);
          var de = typeof d !== c && (d.jQuery || d.Zepto);
          if (de && !de.ua) {
            var ze = new Y();
            de.ua = ze.getResult(), de.ua.get = function() {
              return ze.getUA();
            }, de.ua.set = function(F) {
              ze.setUA(F);
              var z = ze.getResult();
              for (var k in z)
                de.ua[k] = z[k];
            };
          }
        })(typeof window == "object" ? window : this);
      }, 1650: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(E, y, A, B) {
          B === void 0 && (B = A);
          var w = Object.getOwnPropertyDescriptor(y, A);
          w && !("get" in w ? !y.__esModule : w.writable || w.configurable) || (w = { enumerable: !0, get: function() {
            return y[A];
          } }), Object.defineProperty(E, B, w);
        } : function(E, y, A, B) {
          B === void 0 && (B = A), E[B] = y[A];
        }), d = this && this.__setModuleDefault || (Object.create ? function(E, y) {
          Object.defineProperty(E, "default", { enumerable: !0, value: y });
        } : function(E, y) {
          E.default = y;
        }), g = this && this.__importStar || function(E) {
          if (E && E.__esModule)
            return E;
          var y = {};
          if (E != null)
            for (var A in E)
              A !== "default" && Object.prototype.hasOwnProperty.call(E, A) && f(y, E, A);
          return d(y, E), y;
        }, C = this && this.__awaiter || function(E, y, A, B) {
          return new (A || (A = Promise))(function(w, V) {
            function N(M) {
              try {
                H(B.next(M));
              } catch (L) {
                V(L);
              }
            }
            function O(M) {
              try {
                H(B.throw(M));
              } catch (L) {
                V(L);
              }
            }
            function H(M) {
              var L;
              M.done ? w(M.value) : (L = M.value, L instanceof A ? L : new A(function(x) {
                x(L);
              })).then(N, O);
            }
            H((B = B.apply(E, y || [])).next());
          });
        }, c = this && this.__generator || function(E, y) {
          var A, B, w, V, N = { label: 0, sent: function() {
            if (1 & w[0])
              throw w[1];
            return w[1];
          }, trys: [], ops: [] };
          return V = { next: O(0), throw: O(1), return: O(2) }, typeof Symbol == "function" && (V[Symbol.iterator] = function() {
            return this;
          }), V;
          function O(H) {
            return function(M) {
              return function(L) {
                if (A)
                  throw new TypeError("Generator is already executing.");
                for (; V && (V = 0, L[0] && (N = 0)), N; )
                  try {
                    if (A = 1, B && (w = 2 & L[0] ? B.return : L[0] ? B.throw || ((w = B.return) && w.call(B), 0) : B.next) && !(w = w.call(B, L[1])).done)
                      return w;
                    switch (B = 0, w && (L = [2 & L[0], w.value]), L[0]) {
                      case 0:
                      case 1:
                        w = L;
                        break;
                      case 4:
                        return N.label++, { value: L[1], done: !1 };
                      case 5:
                        N.label++, B = L[1], L = [0];
                        continue;
                      case 7:
                        L = N.ops.pop(), N.trys.pop();
                        continue;
                      default:
                        if (!((w = (w = N.trys).length > 0 && w[w.length - 1]) || L[0] !== 6 && L[0] !== 2)) {
                          N = 0;
                          continue;
                        }
                        if (L[0] === 3 && (!w || L[1] > w[0] && L[1] < w[3])) {
                          N.label = L[1];
                          break;
                        }
                        if (L[0] === 6 && N.label < w[1]) {
                          N.label = w[1], w = L;
                          break;
                        }
                        if (w && N.label < w[2]) {
                          N.label = w[2], N.ops.push(L);
                          break;
                        }
                        w[2] && N.ops.pop(), N.trys.pop();
                        continue;
                    }
                    L = y.call(E, N);
                  } catch (x) {
                    L = [6, x], B = 0;
                  } finally {
                    A = w = 0;
                  }
                if (5 & L[0])
                  throw L[1];
                return { value: L[0] ? L[1] : void 0, done: !0 };
              }([H, M]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ControllerProvider = void 0;
        var l = p(7765), a = g(p(7650)), m = p(5937), i = p(434), o = p(8733), s = p(1532), u = p(41), T = p(1727), S = p(6955), P = p(9549), b = p(6139), D = p(4673), U = function() {
          function E(y) {
            this._logger = new m.Logger(l.Constants.FILE_INIT_CONTROLLER), this._centralConfig = y, this._qualtricsBridge = new u.QualtricsBridge(), this._contextDataController = new o.ContextDataController(), this._initThemeValueFetcher();
          }
          return Object.defineProperty(E.prototype, "centralConfig", { get: function() {
            return this._centralConfig;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "contextDataController", { get: function() {
            return this._contextDataController;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "qualtricsBridge", { get: function() {
            return this._qualtricsBridge;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "storageService", { get: function() {
            return this._storageService;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "validationHandler", { get: function() {
            return this._validationHandler;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "timedPushController", { get: function() {
            return this._timedPushController;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "presentationController", { get: function() {
            return this._presentationController;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "themeValueFetcher", { get: function() {
            return this._themeValueFetcher;
          }, enumerable: !1, configurable: !0 }), E.prototype.initStorage = function() {
            this._storageService = new T.StorageService();
          }, E.prototype.initValidationHandler = function() {
            this._validationHandler = new b.ValidationHandler(), this._validationHandler.init(this.storageService, this.centralConfig);
          }, E.prototype.initTimedPushController = function(y) {
            y.timedPush ? (this._timedPushController = new P.TimedPushController(this.centralConfig, this.storageService), this._timedPushController.init(this._timedPushCallback.bind(this))) : this._logger.info(i.LoggerTexts.CONTROLLER_PROVIDER.INIT_TIMED_PUSH_NOT_AVAILABLE);
          }, E.prototype.initPresentationController = function(y) {
            this._presentationController = new S.PresentationController(this.storageService, this.centralConfig, this.qualtricsBridge, this.contextDataController, y);
          }, E.prototype.destroy = function() {
            var y, A;
            this._contextDataController.reset(), this._qualtricsBridge.destroy(), (y = this._timedPushController) === null || y === void 0 || y.destroy(), (A = this._presentationController) === null || A === void 0 || A.destroy();
          }, E.prototype._timedPushCallback = function() {
            return C(this, void 0, void 0, function() {
              var y;
              return c(this, function(A) {
                switch (A.label) {
                  case 0:
                    return y = new s.PushContextData(l.Constants.GENERIC_TRIGGER_AREAID, a.TRIGGER_TYPE.timed), this.presentationController ? [4, this.presentationController.displayInvitationDialog(a.CLIENT_ACTION.timedPushFeedback, y)] : [3, 2];
                  case 1:
                    A.sent(), A.label = 2;
                  case 2:
                    return [2];
                }
              });
            });
          }, E.prototype._initThemeValueFetcher = function() {
            this._centralConfig.themingConfig && (this._themeValueFetcher = new D.ThemeValueFetcher(this._centralConfig.themingConfig, this._contextDataController));
          }, E;
        }();
        h.ControllerProvider = U;
      }, 1904: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(E, y, A, B) {
          B === void 0 && (B = A);
          var w = Object.getOwnPropertyDescriptor(y, A);
          w && !("get" in w ? !y.__esModule : w.writable || w.configurable) || (w = { enumerable: !0, get: function() {
            return y[A];
          } }), Object.defineProperty(E, B, w);
        } : function(E, y, A, B) {
          B === void 0 && (B = A), E[B] = y[A];
        }), d = this && this.__setModuleDefault || (Object.create ? function(E, y) {
          Object.defineProperty(E, "default", { enumerable: !0, value: y });
        } : function(E, y) {
          E.default = y;
        }), g = this && this.__importStar || function(E) {
          if (E && E.__esModule)
            return E;
          var y = {};
          if (E != null)
            for (var A in E)
              A !== "default" && Object.prototype.hasOwnProperty.call(E, A) && f(y, E, A);
          return d(y, E), y;
        }, C = this && this.__awaiter || function(E, y, A, B) {
          return new (A || (A = Promise))(function(w, V) {
            function N(M) {
              try {
                H(B.next(M));
              } catch (L) {
                V(L);
              }
            }
            function O(M) {
              try {
                H(B.throw(M));
              } catch (L) {
                V(L);
              }
            }
            function H(M) {
              var L;
              M.done ? w(M.value) : (L = M.value, L instanceof A ? L : new A(function(x) {
                x(L);
              })).then(N, O);
            }
            H((B = B.apply(E, y || [])).next());
          });
        }, c = this && this.__generator || function(E, y) {
          var A, B, w, V, N = { label: 0, sent: function() {
            if (1 & w[0])
              throw w[1];
            return w[1];
          }, trys: [], ops: [] };
          return V = { next: O(0), throw: O(1), return: O(2) }, typeof Symbol == "function" && (V[Symbol.iterator] = function() {
            return this;
          }), V;
          function O(H) {
            return function(M) {
              return function(L) {
                if (A)
                  throw new TypeError("Generator is already executing.");
                for (; V && (V = 0, L[0] && (N = 0)), N; )
                  try {
                    if (A = 1, B && (w = 2 & L[0] ? B.return : L[0] ? B.throw || ((w = B.return) && w.call(B), 0) : B.next) && !(w = w.call(B, L[1])).done)
                      return w;
                    switch (B = 0, w && (L = [2 & L[0], w.value]), L[0]) {
                      case 0:
                      case 1:
                        w = L;
                        break;
                      case 4:
                        return N.label++, { value: L[1], done: !1 };
                      case 5:
                        N.label++, B = L[1], L = [0];
                        continue;
                      case 7:
                        L = N.ops.pop(), N.trys.pop();
                        continue;
                      default:
                        if (!((w = (w = N.trys).length > 0 && w[w.length - 1]) || L[0] !== 6 && L[0] !== 2)) {
                          N = 0;
                          continue;
                        }
                        if (L[0] === 3 && (!w || L[1] > w[0] && L[1] < w[3])) {
                          N.label = L[1];
                          break;
                        }
                        if (L[0] === 6 && N.label < w[1]) {
                          N.label = w[1], w = L;
                          break;
                        }
                        if (w && N.label < w[2]) {
                          N.label = w[2], N.ops.push(L);
                          break;
                        }
                        w[2] && N.ops.pop(), N.trys.pop();
                        continue;
                    }
                    L = y.call(E, N);
                  } catch (x) {
                    L = [6, x], B = 0;
                  } finally {
                    A = w = 0;
                  }
                if (5 & L[0])
                  throw L[1];
                return { value: L[0] ? L[1] : void 0, done: !0 };
              }([H, M]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.InitController = void 0;
        var l = p(7765), a = g(p(7650)), m = p(3614), i = p(2675), o = p(5937), s = p(434), u = p(3138), T = p(3347), S = p(7134), P = p(453), b = p(1650), D = p(2678), U = function() {
          function E() {
            this._logger = new o.Logger(l.Constants.FILE_INIT_CONTROLLER);
          }
          return Object.defineProperty(E.prototype, "controllerProvider", { get: function() {
            return this._controllerProvider;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "centralConfig", { get: function() {
            return this._centralConfig;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(E.prototype, "qualtricsBridge", { get: function() {
            return this._controllerProvider.qualtricsBridge;
          }, enumerable: !1, configurable: !0 }), E.prototype.prepareInit = function(y, A, B) {
            var w = this.areMandatoryInitParametersValid(y);
            return (0, m.isError)(w) ? w : this.identifyInitMode(A, B);
          }, E.prototype.areMandatoryInitParametersValid = function(y) {
            return y ? y.tenantId ? y.tenantRole ? (this._logger.info(s.LoggerTexts.INIT_CONTROLLER.INIT_MANDATORY_PARAMS_VALID), { success: !0, result: !0 }) : { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_ROLE) } : { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_ID) } : { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_INFO) };
          }, E.prototype.identifyInitMode = function(y, A) {
            if (!y && !A)
              return { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_CFG_ID_OR_CFG_JSON_NEED_TO_BE_PROVIDED) };
            if (y && A)
              return { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_BOTH_CFG_IDENTIFIER_CFG_JSON_NOT_POSSIBLE) };
            if (y && !A) {
              var B = P.ConfigValidation.isConfigIdentifierIsValid(y);
              return (0, m.isError)(B) ? B : (this._logger.info("Init Mode set to: automatic."), { success: !0, result: a.API_INIT_MODE.automatic });
            }
            return this._logger.info("Init Mode set to: manual."), { success: !0, result: a.API_INIT_MODE.manual };
          }, E.prototype.loadConfiguration = function(y, A, B, w) {
            return C(this, void 0, void 0, function() {
              var V, N;
              return c(this, function(O) {
                switch (O.label) {
                  case 0:
                    return V = { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_CFG_LOAD_FAILED) }, y === a.API_INIT_MODE.automatic && B ? [4, this._initWithCentralConfig(A, B)] : [3, 2];
                  case 1:
                    return V = O.sent(), [3, 3];
                  case 2:
                    y === a.API_INIT_MODE.manual && w && (V = T.ConfigJsonParser.parseJsonToCentralConfig(A, w)), O.label = 3;
                  case 3:
                    return (0, m.isError)(V) ? [2, V] : (this._centralConfig = V.result, N = P.ConfigValidation.areMandatorySettingsExistent(this._centralConfig), (0, m.isError)(N) && (this._centralConfig = void 0), [2, N]);
                }
              });
            });
          }, E.prototype.hasAnyScopeItemConfigured = function() {
            return !!u.ScopeCheck.hasAnyScopeItemConfigured(this._centralConfig.startupConfig);
          }, E.prototype.determineRuntimeScope = function(y) {
            var A = { manual: !1, timedPush: !1, appPush: !1 };
            return y ? (this._isAppPushPossible() && (A.appPush = !0), this._isTimedPushPossible() && (A.timedPush = !0), A) : (this._logger.info(s.LoggerTexts.INIT_CONTROLLER.SURVEY_INVITATION_DIALOG_CALLBACK_NOT_PROVIDED), A);
          }, E.prototype.initFeatures = function(y, A) {
            return C(this, void 0, void 0, function() {
              return c(this, function(B) {
                switch (B.label) {
                  case 0:
                    return this._controllerProvider = new b.ControllerProvider(this._centralConfig), this.controllerProvider.initStorage(), this._ensureUserStateIsValid(this.controllerProvider.storageService), (y.timedPush || y.appPush) && (this._controllerProvider.initValidationHandler(), this._setupInitialPushDates(this.controllerProvider.storageService, y), A ? (this._controllerProvider.initPresentationController(A), y.timedPush && this._controllerProvider.initTimedPushController(y)) : this._logger.warn(s.LoggerTexts.INIT_CONTROLLER.INIT_PUSH_FEATURES_NOT_POSSIBLE)), [4, this._tryLoadQualtricsApi()];
                  case 1:
                    return [2, B.sent()];
                }
              });
            });
          }, E.prototype._ensureUserStateIsValid = function(y) {
            if (y) {
              var A = y.readUserState();
              A && u.ScopeCheck.isTestModeActive() !== A.isDebugState && y.saveUserState(y.getInitialUserState());
            }
          }, E.prototype.setInitialContextData = function() {
            this.controllerProvider.contextDataController.setDeviceContext();
            var y = { tenantId: this.centralConfig.tenantInfo.tenantId, tenantRole: this.centralConfig.tenantInfo.tenantRole, productName: this.centralConfig.startupConfig.productName, platformType: this.centralConfig.startupConfig.platformType };
            this.controllerProvider.contextDataController.setSessionContext(y);
          }, E.prototype._initWithCentralConfig = function(y, A) {
            return C(this, void 0, void 0, function() {
              return c(this, function(B) {
                return [2, new S.ConfigurationLoader(A, y).loadConfiguration()];
              });
            });
          }, E.prototype._isAppPushPossible = function() {
            if (u.ScopeCheck.isAppPushAvailable(this._centralConfig.startupConfig)) {
              if (P.ConfigValidation.isAppPushConfigIsValid(this._centralConfig))
                return !0;
              this._logger.warn(s.LoggerTexts.INIT_CONTROLLER.APP_PUSH_SCOPE_SET_INCONSISTENT);
            }
            return !1;
          }, E.prototype._isTimedPushPossible = function() {
            if (u.ScopeCheck.isTimedPushAvailable(this._centralConfig.startupConfig)) {
              if (P.ConfigValidation.isTimedPushConfigIsValid(this._centralConfig))
                return !0;
              this._logger.warn(s.LoggerTexts.INIT_CONTROLLER.TIMED_PUSH_SCOPE_SET_INCONSISTENT);
            }
            return !1;
          }, E.prototype._setupInitialPushDates = function(y, A) {
            var B = y.readUserState(), w = this._centralConfig.pushConfig;
            if (B && w) {
              var V = B.timedPushDate, N = B.appPushDate, O = !1;
              if (!V && A.timedPush) {
                var H = D.DateCalculator.calculateInitialTimedPushDate(w);
                B.timedPushDate = H, O = !0;
              }
              !N && A.appPush && (H = D.DateCalculator.calculateInitialAppPushDate(w), B.appPushDate = H, O = !0), O && y.saveUserState(B);
            }
          }, E.prototype._tryLoadQualtricsApi = function() {
            return C(this, void 0, void 0, function() {
              var y, A, B, w, V;
              return c(this, function(N) {
                switch (N.label) {
                  case 0:
                    return y = this._centralConfig.startupConfig.qualtricsInternalUri, A = this._centralConfig.runtimeConfig, this.qualtricsBridge.registerCSPExceptionEvent(), [4, this.qualtricsBridge.canLoadQualtricsScript(y)];
                  case 1:
                    return N.sent() ? (A && !A.useApi && A.domElementId && this.qualtricsBridge.renderQualtricsButton(A.domElementId), B = this.qualtricsBridge.registerApiLoadedEvent(), [4, this.qualtricsBridge.renderQualtricsScript(y, this._centralConfig.startupConfig.enableQualtricsRestrictedMode)]) : [2, { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_QUALTRICS_URI_CANNOT_BE_REACHED) }];
                  case 2:
                    return w = N.sent(), this.qualtricsBridge.deregisterQualtricsScriptLoadedEvent(y), w ? [4, B] : [2, { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.RENDER_QUALTRICS_SCRIPT_FAILED) }];
                  case 3:
                    return V = N.sent(), this.qualtricsBridge.isCSPExceptionOccurred ? [2, { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_QUALTRICS_LOADING_FAILED) }] : V ? [2, { success: !0, result: V }] : [2, { success: !1, error: new i.InitControllerError(void 0, s.LoggerTexts.INIT_CONTROLLER.INIT_QUALTRICS_LOADING_FAILED) }];
                }
              });
            });
          }, E;
        }();
        h.InitController = U;
      }, 9709: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.OptOutHandler = void 0;
        var f = p(9160), d = p(3138), g = p(2678), C = function() {
          function c() {
            this._optOutSelection = [];
          }
          return Object.defineProperty(c.prototype, "controllerProvider", { get: function() {
            return this._controllerProvider;
          }, set: function(l) {
            this._controllerProvider = l, this._optOutSelection.length > 0 && this._updateTimedPush();
          }, enumerable: !1, configurable: !0 }), c.prototype.getCurrentSelection = function() {
            return this._optOutSelection;
          }, c.prototype.addOptOut = function(l) {
            this._optOutSelection.includes(l) || this._optOutSelection.push(l), this._updateTimedPush();
          }, c.prototype.removeOptOut = function(l) {
            this._optOutSelection.includes(l) && (this._optOutSelection = this._optOutSelection.filter(function(a) {
              return a !== l;
            }), l === f.PushType.timedPush ? this._updateTimedPush() : l === f.PushType.appPush && this._updateAppPush());
          }, c.prototype.hasOptedOutFromAppPush = function() {
            return !!this._optOutSelection.includes(f.PushType.appPush);
          }, c.prototype.hasOptedOutFromTimedPush = function() {
            return !!this._optOutSelection.includes(f.PushType.timedPush);
          }, c.prototype._updateTimedPush = function() {
            var l = this.hasOptedOutFromTimedPush();
            this._controllerProvider && this._controllerProvider.timedPushController && d.ScopeCheck.isTimedPushAvailable(this._controllerProvider.centralConfig.startupConfig) && (l || this._calculateNextTimedPushDate(), this._controllerProvider.timedPushController.hasOptedOut = l);
          }, c.prototype._updateAppPush = function() {
            this._controllerProvider && d.ScopeCheck.isAppPushAvailable(this._controllerProvider.centralConfig.startupConfig) && this._calculateNextAppPushDate();
          }, c.prototype._calculateNextTimedPushDate = function() {
            if (this._controllerProvider) {
              var l = this._controllerProvider.storageService;
              if (l) {
                var a = this._controllerProvider.centralConfig.pushConfig, m = this._getUserState(l);
                m && a && (m.timedPushDate = g.DateCalculator.calculateNextTimedPushDate(a), this._saveUserState(l, m));
              }
            }
          }, c.prototype._calculateNextAppPushDate = function() {
            if (this._controllerProvider) {
              var l = this._controllerProvider.storageService;
              if (l) {
                var a = this._controllerProvider.centralConfig.pushConfig, m = this._getUserState(l);
                a && m && (m.appPushDate = g.DateCalculator.calculateNextAppPushDate(a), this._saveUserState(l, m));
              }
            }
          }, c.prototype._getUserState = function(l) {
            return l.readUserState();
          }, c.prototype._saveUserState = function(l, a) {
            l.saveUserState(a);
          }, c;
        }();
        h.OptOutHandler = C;
      }, 7777: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(y, A, B, w) {
          w === void 0 && (w = B);
          var V = Object.getOwnPropertyDescriptor(A, B);
          V && !("get" in V ? !A.__esModule : V.writable || V.configurable) || (V = { enumerable: !0, get: function() {
            return A[B];
          } }), Object.defineProperty(y, w, V);
        } : function(y, A, B, w) {
          w === void 0 && (w = B), y[w] = A[B];
        }), d = this && this.__setModuleDefault || (Object.create ? function(y, A) {
          Object.defineProperty(y, "default", { enumerable: !0, value: A });
        } : function(y, A) {
          y.default = A;
        }), g = this && this.__importStar || function(y) {
          if (y && y.__esModule)
            return y;
          var A = {};
          if (y != null)
            for (var B in y)
              B !== "default" && Object.prototype.hasOwnProperty.call(y, B) && f(A, y, B);
          return d(A, y), A;
        }, C = this && this.__awaiter || function(y, A, B, w) {
          return new (B || (B = Promise))(function(V, N) {
            function O(L) {
              try {
                M(w.next(L));
              } catch (x) {
                N(x);
              }
            }
            function H(L) {
              try {
                M(w.throw(L));
              } catch (x) {
                N(x);
              }
            }
            function M(L) {
              var x;
              L.done ? V(L.value) : (x = L.value, x instanceof B ? x : new B(function(ie) {
                ie(x);
              })).then(O, H);
            }
            M((w = w.apply(y, A || [])).next());
          });
        }, c = this && this.__generator || function(y, A) {
          var B, w, V, N, O = { label: 0, sent: function() {
            if (1 & V[0])
              throw V[1];
            return V[1];
          }, trys: [], ops: [] };
          return N = { next: H(0), throw: H(1), return: H(2) }, typeof Symbol == "function" && (N[Symbol.iterator] = function() {
            return this;
          }), N;
          function H(M) {
            return function(L) {
              return function(x) {
                if (B)
                  throw new TypeError("Generator is already executing.");
                for (; N && (N = 0, x[0] && (O = 0)), O; )
                  try {
                    if (B = 1, w && (V = 2 & x[0] ? w.return : x[0] ? w.throw || ((V = w.return) && V.call(w), 0) : w.next) && !(V = V.call(w, x[1])).done)
                      return V;
                    switch (w = 0, V && (x = [2 & x[0], V.value]), x[0]) {
                      case 0:
                      case 1:
                        V = x;
                        break;
                      case 4:
                        return O.label++, { value: x[1], done: !1 };
                      case 5:
                        O.label++, w = x[1], x = [0];
                        continue;
                      case 7:
                        x = O.ops.pop(), O.trys.pop();
                        continue;
                      default:
                        if (!((V = (V = O.trys).length > 0 && V[V.length - 1]) || x[0] !== 6 && x[0] !== 2)) {
                          O = 0;
                          continue;
                        }
                        if (x[0] === 3 && (!V || x[1] > V[0] && x[1] < V[3])) {
                          O.label = x[1];
                          break;
                        }
                        if (x[0] === 6 && O.label < V[1]) {
                          O.label = V[1], V = x;
                          break;
                        }
                        if (V && O.label < V[2]) {
                          O.label = V[2], O.ops.push(x);
                          break;
                        }
                        V[2] && O.ops.pop(), O.trys.pop();
                        continue;
                    }
                    x = A.call(y, O);
                  } catch (ie) {
                    x = [6, ie], w = 0;
                  } finally {
                    B = V = 0;
                  }
                if (5 & x[0])
                  throw x[1];
                return { value: x[0] ? x[1] : void 0, done: !0 };
              }([M, L]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PxApi = void 0;
        var l = p(7765), a = g(p(7650)), m = p(9160), i = p(3614), o = p(9395), s = p(5937), u = p(434), T = p(3138), S = p(6610), P = p(8564), b = p(1532), D = p(1904), U = p(9709), E = function() {
          function y() {
            this._currentThemeId = m.ThemeId.none, this._isInitialized = !1, this._window = window, this._logger = new s.Logger(l.Constants.FILE_PX_API), this._optOutHandler = new U.OptOutHandler(), this.setBuildInfo();
          }
          return y.prototype.setBuildInfo = function() {
            o.LibInfo.setInfoData();
          }, y.prototype.initialize = function(A, B, w, V) {
            return C(this, void 0, void 0, function() {
              var N, O, H, M, L;
              return c(this, function(x) {
                switch (x.label) {
                  case 0:
                    return this._isInitialized ? (this._logger.error(u.LoggerTexts.PX_API.API_ALREADY_INITIALIZED), [2, !1]) : (N = new D.InitController(), O = N.prepareInit(A, B, w), (0, i.isError)(O) ? (this._logger.logError(O.error), [2, !1]) : [4, N.loadConfiguration(O.result, A, B, w)]);
                  case 1:
                    return H = x.sent(), (0, i.isError)(H) ? (this._logger.logError(H.error), [2, !1]) : N.hasAnyScopeItemConfigured() ? (M = !!V, this._runtimeScope = N.determineRuntimeScope(M), [4, N.initFeatures(this._runtimeScope, V)]) : (this._logger.warn(u.LoggerTexts.PX_API.CFG_NO_SCOPE_ITEM_FOUND), [2, !1]);
                  case 2:
                    return L = x.sent(), (0, i.isError)(L) ? (this._logger.logError(L.error), [2, !1]) : (N.setInitialContextData(), this._logger.info(u.LoggerTexts.PX_API.FEATURES_INITIALIZED_SUCCESSFULLY), this._controllerProvider = N.controllerProvider, this._updateThemeId(), this._optOutHandler.controllerProvider = this._controllerProvider, this._isInitialized = !0, [2, !0]);
                }
              });
            });
          }, y.prototype.openSurvey = function(A) {
            return C(this, void 0, void 0, function() {
              return c(this, function(B) {
                switch (B.label) {
                  case 0:
                    return this.isUserInitiatedFeedbackEnabled ? (this._resetVariableContextData(), this._setAppContext(P.AppContextDataContainer.create(A, a.CLIENT_ACTION.navBarClick)), [4, this._openSurvey()]) : [3, 2];
                  case 1:
                    return B.sent(), [3, 3];
                  case 2:
                    this._logger.error(u.LoggerTexts.PX_API.CFG_NO_MANUAL_SCOPE_SET), B.label = 3;
                  case 3:
                    return [2];
                }
              });
            });
          }, y.prototype.requestPush = function(A) {
            var B;
            return C(this, void 0, void 0, function() {
              return c(this, function(w) {
                switch (w.label) {
                  case 0:
                    return !((B = this._runtimeScope) === null || B === void 0) && B.appPush ? [3, 1] : (this._logger.info(u.LoggerTexts.PX_API.REQUEST_PUSH_NOT_POSSIBLE), [3, 5]);
                  case 1:
                    if (!A)
                      throw new Error(u.LoggerTexts.PX_API.PUSH_DATA_NOT_VALID);
                    return this._optOutHandler.hasOptedOutFromAppPush() ? (this._logger.info(u.LoggerTexts.PX_API.REQUEST_PUSH_APP_PUSH_OPTED_OUT), [3, 5]) : [3, 2];
                  case 2:
                    return S.SettingsCheck.isStandaloneModeActive() ? [3, 5] : this._controllerProvider ? [4, this._fireAppTriggeredPush(A)] : [3, 4];
                  case 3:
                    return w.sent(), [3, 5];
                  case 4:
                    this._logger.error(u.LoggerTexts.PX_API.FEATURES_COULD_NOT_BE_INITIALIZED), w.label = 5;
                  case 5:
                    return [2];
                }
              });
            });
          }, Object.defineProperty(y.prototype, "currentThemeId", { get: function() {
            return this._currentThemeId;
          }, set: function(A) {
            this._currentThemeId = m.ThemeId[A], this._updateThemeId();
          }, enumerable: !1, configurable: !0 }), y.prototype.addOptOut = function(A) {
            this._optOutHandler.addOptOut(A);
          }, y.prototype.removeOptOut = function(A) {
            this._optOutHandler.removeOptOut(A);
          }, Object.defineProperty(y.prototype, "optOutSelection", { get: function() {
            return this._optOutHandler.getCurrentSelection();
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(y.prototype, "isUserInitiatedFeedbackEnabled", { get: function() {
            return !!this._controllerProvider && T.ScopeCheck.isUserInitiatedFeedbackPossible(this._controllerProvider.centralConfig.startupConfig);
          }, enumerable: !1, configurable: !0 }), y.prototype._fireAppTriggeredPush = function(A) {
            var B, w;
            return C(this, void 0, void 0, function() {
              var V, N;
              return c(this, function(O) {
                switch (O.label) {
                  case 0:
                    return (V = (B = this._controllerProvider.validationHandler) === null || B === void 0 ? void 0 : B.validate(A)) ? (N = new b.PushContextData(A.areaId, A.triggerName, A.shortText, A.payload), [4, (w = this._controllerProvider.presentationController) === null || w === void 0 ? void 0 : w.displayInvitationDialog(a.CLIENT_ACTION.appPushFeedback, N, V)]) : [3, 2];
                  case 1:
                    O.sent(), O.label = 2;
                  case 2:
                    return [2];
                }
              });
            });
          }, y.prototype._updateThemeId = function() {
            this._currentThemeId && this._controllerProvider && this._controllerProvider.themeValueFetcher && this._controllerProvider.themeValueFetcher.updateCurrentTheme(this.currentThemeId);
          }, y.prototype._openSurvey = function() {
            return C(this, void 0, void 0, function() {
              var A, B;
              return c(this, function(w) {
                switch (w.label) {
                  case 0:
                    return this._controllerProvider.qualtricsBridge.isApiLoaded ? (A = this._controllerProvider.centralConfig.runtimeConfig) ? A.useApi ? (this._window.QSI.API.unload(), [4, this._window.QSI.API.load()]) : [3, 2] : [3, 4] : [3, 5];
                  case 1:
                    return w.sent(), this._window.QSI.API.run(), [3, 3];
                  case 2:
                    (B = document.body.querySelector('button[id="'.concat(this._controllerProvider.qualtricsBridge.surveyTriggerButtonId, '"]'))) && B.click(), w.label = 3;
                  case 3:
                    return [3, 5];
                  case 4:
                    this._logger.error(u.LoggerTexts.PX_API.RUNTIME_CFG_UNDEFINED), w.label = 5;
                  case 5:
                    return [2];
                }
              });
            });
          }, y.prototype._resetVariableContextData = function() {
            this._controllerProvider.contextDataController.resetVariableContextData();
          }, y.prototype._setAppContext = function(A) {
            this._controllerProvider.contextDataController.setAppContext(A);
          }, y.prototype._unloadQSIAPI = function() {
            var A = window;
            A.QSI && (A.QSI.API && (this._logger.warn(u.LoggerTexts.PX_API.LOADED_QSI_API_UNLOADED), A.QSI.API.unload()), A.QSI = void 0);
          }, y.prototype.destroy = function() {
            this._runtimeScope = void 0, this.currentThemeId = m.ThemeId.none, this._controllerProvider && this._controllerProvider.destroy(), this._unloadQSIAPI(), this._optOutHandler.controllerProvider = void 0, this._controllerProvider = void 0, this._currentThemeId = m.ThemeId.none, this._optOutHandler = new U.OptOutHandler(), this._isInitialized = !1;
          }, y;
        }();
        h.PxApi = E;
      }, 41: function(v, h, p) {
        var f = this && this.__awaiter || function(l, a, m, i) {
          return new (m || (m = Promise))(function(o, s) {
            function u(P) {
              try {
                S(i.next(P));
              } catch (b) {
                s(b);
              }
            }
            function T(P) {
              try {
                S(i.throw(P));
              } catch (b) {
                s(b);
              }
            }
            function S(P) {
              var b;
              P.done ? o(P.value) : (b = P.value, b instanceof m ? b : new m(function(D) {
                D(b);
              })).then(u, T);
            }
            S((i = i.apply(l, a || [])).next());
          });
        }, d = this && this.__generator || function(l, a) {
          var m, i, o, s, u = { label: 0, sent: function() {
            if (1 & o[0])
              throw o[1];
            return o[1];
          }, trys: [], ops: [] };
          return s = { next: T(0), throw: T(1), return: T(2) }, typeof Symbol == "function" && (s[Symbol.iterator] = function() {
            return this;
          }), s;
          function T(S) {
            return function(P) {
              return function(b) {
                if (m)
                  throw new TypeError("Generator is already executing.");
                for (; s && (s = 0, b[0] && (u = 0)), u; )
                  try {
                    if (m = 1, i && (o = 2 & b[0] ? i.return : b[0] ? i.throw || ((o = i.return) && o.call(i), 0) : i.next) && !(o = o.call(i, b[1])).done)
                      return o;
                    switch (i = 0, o && (b = [2 & b[0], o.value]), b[0]) {
                      case 0:
                      case 1:
                        o = b;
                        break;
                      case 4:
                        return u.label++, { value: b[1], done: !1 };
                      case 5:
                        u.label++, i = b[1], b = [0];
                        continue;
                      case 7:
                        b = u.ops.pop(), u.trys.pop();
                        continue;
                      default:
                        if (!((o = (o = u.trys).length > 0 && o[o.length - 1]) || b[0] !== 6 && b[0] !== 2)) {
                          u = 0;
                          continue;
                        }
                        if (b[0] === 3 && (!o || b[1] > o[0] && b[1] < o[3])) {
                          u.label = b[1];
                          break;
                        }
                        if (b[0] === 6 && u.label < o[1]) {
                          u.label = o[1], o = b;
                          break;
                        }
                        if (o && u.label < o[2]) {
                          u.label = o[2], u.ops.push(b);
                          break;
                        }
                        o[2] && u.ops.pop(), u.trys.pop();
                        continue;
                    }
                    b = a.call(l, u);
                  } catch (D) {
                    b = [6, D], i = 0;
                  } finally {
                    m = o = 0;
                  }
                if (5 & b[0])
                  throw b[1];
                return { value: b[0] ? b[1] : void 0, done: !0 };
              }([S, P]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.QualtricsBridge = void 0;
        var g = p(7765), C = p(5937), c = function() {
          function l() {
            this._qsiEnableJSSanitization = !1, this._qsiEnableSecureVariables = !1, this._isApiLoaded = !1, this._surveyTriggerButtonId = "", this._isCSPExceptionOccurred = !1, this._logger = new C.Logger(g.Constants.FILE_INIT_CONTROLLER), this._isCSPExceptionOccurred = !1;
          }
          return Object.defineProperty(l.prototype, "isApiLoaded", { get: function() {
            return this._isApiLoaded;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "surveyTriggerButtonId", { get: function() {
            return this._surveyTriggerButtonId;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "isQsiJSSanitizationEnabled", { get: function() {
            return this._qsiEnableJSSanitization;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "isQsiSecureVariablesEnabled", { get: function() {
            return this._qsiEnableSecureVariables;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "isCSPExceptionOccurred", { get: function() {
            return this._isCSPExceptionOccurred;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "qualtricsUrl", { get: function() {
            return this._qualtricsUrl;
          }, enumerable: !1, configurable: !0 }), l.prototype.renderQualtricsButton = function(a) {
            if (document.body && a) {
              if (!document.body.querySelector('button[id="'.concat(a, '"]'))) {
                var m = document.createElement("button");
                m.id = a, m.hidden = !0, m.type = "button", document.body.appendChild(m);
              }
              this._surveyTriggerButtonId = a;
            }
          }, l.prototype.renderQualtricsScript = function(a, m) {
            return f(this, void 0, void 0, function() {
              var i = this;
              return d(this, function(o) {
                return [2, new Promise(function(s) {
                  if (m && (i._qsiEnableJSSanitization = !0, i._qsiEnableSecureVariables = !0), i._applySecuritySettings(), document.head && a) {
                    i._qualtricsUrl = a;
                    var u = i._getQualtricsScriptTag(a);
                    u && u.remove();
                    var T = document.createElement("script");
                    T.type = "text/javascript", T.src = a, i._qualtricsScriptLoadedEventHandlerBound = i._qualtricsScriptEventHandler.bind(i, s, !0), i._qualtricsScriptFailedEventHandlerBound = i._qualtricsScriptEventHandler.bind(i, s, !1), T.addEventListener("load", i._qualtricsScriptLoadedEventHandlerBound), T.addEventListener("error", i._qualtricsScriptFailedEventHandlerBound), document.head.appendChild(T);
                  } else
                    s(!1);
                })];
              });
            });
          }, l.prototype.registerApiLoadedEvent = function() {
            var a = this;
            return new Promise(function(m) {
              a._qsiJsLoadedEventHandlerBound = a._qsiJsLoadedEventHandler.bind(a, m), window.addEventListener("qsi_js_loaded", a._qsiJsLoadedEventHandlerBound, !1);
            });
          }, l.prototype.canLoadQualtricsScript = function(a) {
            return f(this, void 0, void 0, function() {
              return d(this, function(m) {
                switch (m.label) {
                  case 0:
                    return m.trys.push([0, 2, , 3]), [4, fetch(a, { method: "HEAD", mode: "no-cors" })];
                  case 1:
                    return m.sent(), [2, !0];
                  case 2:
                    return m.sent(), [2, !1];
                  case 3:
                    return [2];
                }
              });
            });
          }, l.prototype.registerCSPExceptionEvent = function() {
            this._securityPolicyExceptionEventHandlerBound = this._securityPolicyExceptionEventHandler.bind(this), document.addEventListener("securitypolicyviolation", this._securityPolicyExceptionEventHandlerBound);
          }, l.prototype.deregisterQualtricsScriptLoadedEvent = function(a) {
            var m = this._getQualtricsScriptTag(a);
            m && (m.removeEventListener("load", this._qualtricsScriptLoadedEventHandlerBound), m.removeEventListener("error", this._qualtricsScriptFailedEventHandlerBound));
          }, l.prototype.destroy = function() {
            window.removeEventListener("qsi_js_loaded", this._qsiJsLoadedEventHandlerBound, !1), document.removeEventListener("securitypolicyviolation", this._securityPolicyExceptionEventHandlerBound), this._removeSurveyTriggerButton(), this._removeQualtricsScript(), this._isCSPExceptionOccurred = !1, this._securityPolicyExceptionEventHandlerBound = void 0, this._qualtricsScriptLoadedEventHandlerBound = void 0, this._qualtricsScriptFailedEventHandlerBound = void 0, this._qsiJsLoadedEventHandlerBound = void 0;
          }, l.prototype._removeSurveyTriggerButton = function() {
            if (this._surveyTriggerButtonId) {
              var a = document.body.querySelector('button[id="'.concat(this._surveyTriggerButtonId, '"]'));
              a && a.remove(), this._surveyTriggerButtonId = void 0;
            }
          }, l.prototype._removeQualtricsScript = function() {
            var a = this._getQualtricsScriptTag(this.qualtricsUrl);
            a && a.remove(), this._qualtricsUrl = void 0;
          }, l.prototype._getQualtricsScriptTag = function(a) {
            return document.head.querySelector('script[src="'.concat(a, '"]'));
          }, l.prototype._qsiJsLoadedEventHandler = function(a) {
            var m = window;
            this._isApiLoaded = !1, m.QSI && m.QSI.API && (this._isApiLoaded = !0), a(this._isApiLoaded);
          }, l.prototype._qualtricsScriptEventHandler = function(a, m) {
            a(m);
          }, l.prototype._securityPolicyExceptionEventHandler = function(a) {
            this._isCSPExceptionOccurred = !0;
            var m = `Content Security Policy(CSP) Error occurred, Please review your 'required' CSP Settings.
			Blocked URI / Missing Value: "`.concat(a.blockedURI, `"
			Problematic Directive: "`).concat(a.violatedDirective, `"
			Current CSP Policy: "`).concat(a.originalPolicy, '"');
            this._logger.error(m);
          }, l.prototype._applySecuritySettings = function() {
            var a = window;
            a.QSI = void 0, this._qsiEnableJSSanitization && this._qsiEnableSecureVariables && (a.QSI || (a.QSI = { global: {}, config: {} }), a.QSI.global.enableJSSanitization = this._qsiEnableJSSanitization, a.QSI.config.enableSecureVariables = this._qsiEnableSecureVariables);
          }, l;
        }();
        h.QualtricsBridge = c;
      }, 7765: function(v, h) {
        var p = this && this.__setFunctionName || function(d, g, C) {
          return typeof g == "symbol" && (g = g.description ? "[".concat(g.description, "]") : ""), Object.defineProperty(d, "name", { configurable: !0, value: C ? "".concat(C, " ", g) : g });
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.Constants = void 0;
        var f = function() {
          function d() {
          }
          var g, C, c;
          return d.CLIENT_ACTION = "clientAction", d.URL_PARAM_SCOPE_SET = "sap-px-scopeSet", d.SCOPE_USER_INITIATED = "manual", d.SCOPE_APP_PUSH = "appPush", d.SCOPE_TIMED_PUSH = "timedPush", d.URL_PARAM_TEST_MODE = "sap-px-testMode", d.URL_PARAM_DEBUG_MODE = "sap-px-debug", d.URL_PARAM_UI5_DEBUG_MODE = "sap-ui-debug", d.URL_PARAM_STANDALONE_MODE = "sap-px-standalone", d.VALUE_NOT_AVAILABLE = "N/A", d.STOR_PUSH_STATE = "sap.feedback.ui.pushState", d.GENERIC_TRIGGER_AREAID = "sap.feedback.generic", d.SUPPORTED_MAJOR_CFG_VERSION = 0, d.FILE_APP_CONTEXT_DATA_CONTAINER = "api.data.AppContextDataContainer", d.FILE_USER_STATE = "api.data.UserState", d.FILE_PX_API = "api.PxApi", d.FILE_PUSH_HANDLER = "api.config.push.PushHandler", d.FILE_INIT_CONTROLLER = "api.InitController", d.FILE_CONTROLLER_PROVIDER = "api.ControllerProvider", d.FILE_CFG_VALIDATION = "api.config.ConfigValidation", d.FILE_TIMED_PUSH_CONTROLLER = "api.survey.TimedPushController", d.FILE_VALIDATION_HANDLER = "api.survey.ValidationHandler", d.FILE_CENTRAL_CFG = "api.config.CentralConfig", d.FILE_CFG_LOADER = "api.config.ConfigurationLoader", d.FILE_THEME_VALUE_FETCHER = "api.theming.ThemeValueFetcher", d.FILE_PUSH_CONTEXT_DATA = "api.data.PushContextData", d.LIMITS = (p(g = function() {
          }, "LIMITS"), g.MIN_RECOMMENDED_INTERVAL_TIMER_IN_MINUTES = 30, g.MIN_RECOMMENDED_MIN_TIME_TO_START_TIME_IN_HRS = 3, g.MIN_RECOMMENDED_INTERVAL_INITIAL_PUSH_IN_DAYS = 3, g.MIN_RECOMMENDED_DEVIATION_INITIAL_PUSH_IN_DAYS = 1, g.MIN_RECOMMENDED_INTERVAL_NEXT_PUSH_IN_DAYS = 3, g.MIN_RECOMMENDED_DEVIATION_NEXT_PUSH_IN_DAYS = 1, g.MAX_APP_TRIGGERED_PUSH_PAYLOAD_SIZE_IN_CHARS = 250, g.MAX_SNOOZE_COUNT = 2, g), d.DEFAULTS = (p(C = function() {
          }, "DEFAULTS"), C.DAYS_UNTIL_STATE_EXPIRY = 180, C.PUSH_GENERAL_QUIET_PERIOD_IN_HRS = 48, C.PUSH_GENERAL_SNOOZE_PERIOD_IN_HRS = 25, C.TIMED_PUSH_INTERVAL_TIMER_IN_MINS = 30, C.TIMED_PUSH_MIN_TIME_TO_START_TIMER_IN_HRS = 12, C.TIMED_PUSH_INTERVAL_INIT_PUSH_IN_DAYS = 35, C.TIMED_PUSH_DEVIATION_INIT_PUSH_IN_DAYS = 7, C.TIMED_PUSH_INTERVAL_NEXT_PUSH_IN_DAYS = 90, C.TIMED_PUSH_DEVIATION_NEXT_PUSH_IN_DAYS = 28, C.APP_PUSH_INTERVAL_INIT_PUSH_IN_DAYS = 14, C.APP_PUSH_DEVIATION_INIT_PUSH_IN_DAYS = 7, C.APP_PUSH_INTERVAL_NEXT_PUSH_IN_DAYS = 45, C.APP_PUSH_DEVIATION_NEXT_PUSH_IN_DAYS = 7, C), d.DEVICE = (p(c = function() {
          }, "DEVICE"), c.TYPE = { PHONE: "phone", TABLET: "tablet", DESKTOP: "desktop" }, c.ORIENTATION = { PORTRAIT: "portrait", LANDSCAPE: "landscape" }, c.OS_NAME = { MAC: "macOS", WINDOWS: "windows" }, c.BROWSER_NAME = { CHROME: "chrome", EDGE: "edge", FIREFOX: "firefox", IE: "internet explorer", OPERA: "opera", SAFARI: "safari" }, c), d;
        }();
        h.Constants = f;
      }, 8501: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.DateTimeUtil = void 0;
        var f = p(7650), d = function() {
          function g() {
          }
          return g.getCurrentDateInISO8601 = function() {
            return new Date().toISOString();
          }, g.isDateValidInISO = function(C) {
            if (!/\d{4}-\d{2}-\d{2}T\d{2}:\d{2}(:\d{2})?(.[0-9]+)?(Z)/.test(C))
              return !1;
            var c = new Date(C);
            return c instanceof Date && !isNaN(c.getTime());
          }, g.getTimeFromISODate = function(C) {
            return new Date(C).getTime();
          }, g.getMillisecondsFromHours = function(C) {
            return C * f.Time.hoursToMilliseconds;
          }, g.getMillisecondsFromMinutes = function(C) {
            return C * f.Time.minutesToMilliseconds;
          }, g;
        }();
        h.DateTimeUtil = d;
      }, 9160: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.Environment = h.ThemeId = h.PushType = void 0, h.PushType = { appPush: "appPush", timedPush: "timedPush" }, h.ThemeId = { none: "none", sap_horizon: "sap_horizon", sap_horizon_dark: "sap_horizon_dark", sap_horizon_hcb: "sap_horizon_hcb", sap_horizon_hcw: "sap_horizon_hcw", sap_fiori_3: "sap_fiori_3", sap_fiori_3_dark: "sap_fiori_3_dark", sap_fiori_3_hcb: "sap_fiori_3_hcb", sap_fiori_3_hcw: "sap_fiori_3_hcw", sap_belize: "sap_belize", sap_belize_plus: "sap_belize_plus", sap_belize_hcb: "sap_belize_hcb", sap_belize_hcw: "sap_belize_hcw" }, h.Environment = { dev: "dev", test: "test", prod: "prod" };
      }, 7650: function(v, h) {
        var p, f, d, g, C;
        Object.defineProperty(h, "__esModule", { value: !0 }), h.API_INIT_MODE = h.CLIENT_ACTION = h.TRIGGER_TYPE = h.PUSH_SRC_TYPE = h.Time = void 0, function(c) {
          c[c.minutesToMilliseconds = 6e4] = "minutesToMilliseconds", c[c.hoursToMilliseconds = 36e5] = "hoursToMilliseconds", c[c.daysToMilliseconds = 864e5] = "daysToMilliseconds";
        }(p || (h.Time = p = {})), function(c) {
          c[c.unknown = 0] = "unknown", c[c.appPush = 4] = "appPush", c[c.timed = 5] = "timed";
        }(f || (h.PUSH_SRC_TYPE = f = {})), function(c) {
          c.recurring = "recurring", c.themeChanged = "themeChanged", c.timed = "timed";
        }(d || (h.TRIGGER_TYPE = d = {})), function(c) {
          c.none = "none", c.navBarClick = "navBarClick", c.appPushFeedback = "inAppPushFeedback", c.timedPushFeedback = "dynamicPushFeedback";
        }(g || (h.CLIENT_ACTION = g = {})), function(c) {
          c[c.invalid = 0] = "invalid", c[c.manual = 1] = "manual", c[c.automatic = 2] = "automatic";
        }(C || (h.API_INIT_MODE = C = {}));
      }, 9395: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.LibInfo = void 0;
        var f = p(1117), d = function() {
          function g() {
          }
          return g.getBuildInfo = function() {
            return { name: "pxapi", version: "2.8.2" };
          }, g.setInfoData = function() {
            f.Util.ensureGlobalContext("qtx", "info").pxclient = "".concat(this.getBuildInfo().name, "/").concat(this.getBuildInfo().version);
          }, g;
        }();
        h.LibInfo = d;
      }, 5937: function(v, h, p) {
        var f = this && this.__importDefault || function(l) {
          return l && l.__esModule ? l : { default: l };
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.Logger = void 0;
        var d = f(p(831)), g = p(7765), C = p(1117), c = function() {
          function l(a) {
            this._fileName = a, this._setLogLevel();
          }
          return Object.defineProperty(l.prototype, "fileName", { get: function() {
            return this._fileName;
          }, enumerable: !1, configurable: !0 }), l.prototype.log = function(a) {
            d.default.log(this._getMessage(a));
          }, l.prototype.info = function(a) {
            d.default.info(this._getMessage(a));
          }, l.prototype.warn = function(a) {
            d.default.warn(this._getMessage(a));
          }, l.prototype.error = function(a) {
            d.default.error(this._getMessage(a));
          }, l.prototype.logError = function(a) {
            d.default.error(a);
          }, l.prototype._getMessage = function(a) {
            return "Date: ".concat(Date(), ` 
Message: `).concat(a, ` 
File: `).concat(this.fileName);
          }, l.prototype._setLogLevel = function() {
            C.Util.isUrlParamDefined(g.Constants.URL_PARAM_DEBUG_MODE) || C.Util.isUrlParamDefined(g.Constants.URL_PARAM_UI5_DEBUG_MODE) ? d.default.setLevel(0) : d.default.setLevel(3);
          }, l;
        }();
        h.Logger = c;
      }, 434: function(v, h) {
        var p = this && this.__setFunctionName || function(d, g, C) {
          return typeof g == "symbol" && (g = g.description ? "[".concat(g.description, "]") : ""), Object.defineProperty(d, "name", { configurable: !0, value: C ? "".concat(C, " ", g) : g });
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.LoggerTexts = void 0;
        var f = function() {
          function d() {
          }
          var g, C, c, l, a, m, i, o, s, u, T, S, P, b, D, U, E, y, A;
          return d.PXAPI_ERROR = (p(g = function() {
          }, "PXAPI_ERROR"), g.ERROR_HEADER = "An unknown error occurred in PxApi.", g), d.APP_CNTXT_CTRL = (p(C = function() {
          }, "APP_CNTXT_CTRL"), C.CTOR_APP_CNTXT_DATA_NOT_PROVIDED = "appContextData is not provided!", C), d.BALANCER = (p(c = function() {
          }, "BALANCER"), c.CTOR_STORAGE_NOT_PROVIDED = "storage is not provided!", c), d.CENTRAL_CFG = (p(l = function() {
          }, "CENTRAL_CFG"), l.CTOR_CFG_ID_CANNOT_BE_NULL = "ConfigIdentifier cannot be null", l.CTOR_TENANT_INFO_CANNOT_BE_NULL = "TenantInfo cannot be null", l.CTOR_PUSH_CFG_EMPTY = "pushConfig empty and will be ignored.", l.CTOR_THEMING_CFG_EMPTY = "themingConfig empty and will be ignored.", l), d.CFG_LOADER = (p(a = function() {
          }, "CFG_LOADER"), a.ERROR_HEADER = "Loading PX-Config", a.GET_CENTRAL_CFG_LOADING_ERROR_OCCURRED = "An error has occurred while loading the Central Configuration", a.GET_CENTRAL_CFG_LOADING_INVALID_CONTENT_TYPE = "Configuration response is not in JSON format", a), d.CFG_JSON_PARSER = (p(m = function() {
          }, "CFG_JSON_PARSER"), m.ERROR_HEADER = "Parsing PX-Config JSON failed", m.CTOR_TENANT_INFO_CANNOT_BE_NULL = "tenantInfo cannot be null", m.CTOR_JSON_DATA_CANNOT_BE_NULL = "jsonData cannot be null", m.CTOR_JSON_DATA_VERSION_MISSING_OR_EMPTY = "version field in jsonData missing or empty. Required to parse config correctly.", m.CTOR_JSON_DATA_VERSION_NOT_A_STRING = "version field in jsonData must be a string", m.CTOR_JSON_DATA_ENV_NOT_VALID_VALUE = "environment field has no valid value", m.CTOR_JSON_DATA_VERSION_EMPTY_STRING = "version field in jsonData cannot be empty", m.CTOR_JSON_DATA_UNEXPECTED_ERROR = "An unexpected error occured when parsing the configuration: ", m), d.CFG_VALIDATION = (p(i = function() {
          }, "CFG_VALIDATION"), i.ERROR_HEADER = "Config validation failed", i.CENTRAL_CFG_CANNOT_BE_NULL = "Central config cannot be null.", i.CENTRAL_CFG_STARTUP_CFG_CANNOT_BE_NULL = "Central config: startupConfig cannot be null.", i.CENTRAL_CFG_RUNTIME_CFG_CANNOT_BE_NULL = "Central config: runtimeConfig cannot be null.", i.USE_API_FALSE_DEPRECATION_WARNING = "[DEPRECATION WARNING] PxApi - Central config: runtimeConfig.useApi should not be set to false anymore.", i.CENTRAL_CFG_HEADER_VERSION_NOT_FOUND = "Central config header: version property not found.", i.CENTRAL_CFG_HEADER_VERSION_NOT_A_STRING = "Central config header: version must be a string.", i.CENTRAL_CFG_HEADER_CFG_ID_CANNOT_BE_NULL = "Central config header: configIdentifier cannot be null.", i.CENTRAL_CFG_HEADER_CFG_ID_UNIT_ID_CANNOT_BE_NULL = "Central config header: configIdentifier.unitId cannot be null.", i.CENTRAL_CFG_HEADER_CFG_ID_ENV_CANNOT_BE_NULL = "Central config header: configIdentifier.environment cannot be null.", i.CENTRAL_CFG_HEADER_TENANT_ID_CANNOT_BE_NULL = "Central config header: tenantInfo cannot be null.", i.STARTUP_CFG_QUALTRICS_INT_URI_CANNOT_BE_NULL = "Startup config: qualtricsInternalUri cannot be null.", i.RUNTIME_CFG_USEAPI_FALSE_WHEN_DOMELEMENT_ID_NOT_SET = "Runtime config: useApi cannot be false when domElementId is not set.", i.RUNTIME_CFG_USEAPI_TRUE_THEN_DOMELEMENT_ID_NO_EFFECT = "Runtime config: when useApi=true domElementId will have not effect.", i.THEMING_CFG_WRITE_TO_GLOBALS_SET_TO_FALSE_NO_EFFECT = "Theming config: writeToGlobals=false has no effect.", i.THEMING_CFG_REQUIRES_RUNTIME_CFG_USEAPI_TO_BE_TRUE = "Theming config enabled requires runtimeConfig.useApi to be enabled too.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_TIMER_MIN = "Timed Push config: intervalTimerInMinutes is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_MIN_START_TIMER = "Timed Push config: minimumTimeToStartTimerInHrs is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_INIT_PUSH = "Timed Push config: intervalInitialPushInDays is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_DEVIATION_INIT_PUSH = "Timed Push config: deviationInitialPushInDays is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_NEXT_PUSH = "Timed Push config: intervalNextPushInDays is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_VALUE_BELOW_LIMIT_DEVIATION_NEXT_PUSH = "Timed Push config: deviationNextPushInDays is below the acceptable limit, please review to avoid problems.", i.TIMED_PUSH_CONFIG_NOT_PROVIDED = "Time controlled push configuration is not provided. Please check the configuration at pushConfig.timedPush", i.TIMED_PUSH_INVALID_INTERVALS = { INTERVAL_TIMER_IN_MINUTES: 'Invalid "intervalTimerInMinutes" provided at "pushConfig.timedPush". Please check the configuration further.', MIN_TIME_TO_START_TIMER_IN_HRS: 'Invalid "minimumTimeToStartTimerInHrs" provided at "pushConfig.timedPush". Please check the configuration further.', INTERVAL_INITIAL_PUSH_IN_DAYS: 'Invalid "intervalInitialPushInDays" provided at "pushConfig.timedPush". Please check the configuration further.', DEVIATION_INITIAL_PUSH_IN_DAYS: 'Invalid "deviationInitialPushInDays" provided at "pushConfig.timedPush". Please check the configuration further.', INTERVAL_NEXT_PUSH_IN_DAYS: 'Invalid "intervalNextPushInDays" provided at "pushConfig.timedPush". Please check the configuration further.', DEVIATION_NEXT_PUSH_IN_DAYS: 'Invalid "deviationNextPushInDays" provided at "pushConfig.timedPush". Please check the configuration further.' }, i.APP_PUSH_VALUE_BELOW_LIMIT_INTERVAL_INIT_PUSH = "App Push config: intervalInitialPushInDays is below the acceptable limit, please review to avoid problems.", i.APP_PUSH_VALUE_BELOW_LIMIT_DEVIATION_INIT_PUSH = "App Push config: deviationInitialPushInDays is below the acceptable limit, please review to avoid problems.", i.APP_PUSH_VALUE_BELOW_LIMIT_INTERVAL_NEXT_PUSH = "App Push config: intervalNextPushInDays is below the acceptable limit, please review to avoid problems.", i.APP_PUSH_VALUE_BELOW_LIMIT_DEVIATION_NEXT_PUSH = "App Push config: deviationNextPushInDays is below the acceptable limit, please review to avoid problems.", i.APP_PUSH_CONFIGS_NOT_MAINTAINED = "Application triggered Configurations are not set. Please provide the configuration(appPush.configs[{...}]) to activate Application triggered push.", i.APP_PUSH_CONFIG_NOT_PROVIDED = "Application triggered push configuration is not provided. Please refer the configuration at pushConfig.appPush", i.APP_PUSH_INVALID_INTERVALS = { INTERVAL_INITIAL_PUSH_IN_DAYS: 'Invalid "intervalInitialPushInDays" provided at "pushConfig.appPush". Please check the configuration further.', DEVIATION_INITIAL_PUSH_IN_DAYS: 'Invalid "deviationInitialPushInDays" provided at "pushConfig.appPush". Please check the configuration further.', INTERVAL_NEXT_PUSH_IN_DAYS: 'Invalid "intervalNextPushInDays" provided at "pushConfig.appPush". Please check the configuration further.', DEVIATION_NEXT_PUSH_IN_DAYS: 'Invalid "deviationNextPushInDays" provided at "pushConfig.appPush". Please check the configuration further.' }, i), d.CONTROLLER_PROVIDER = (p(o = function() {
          }, "CONTROLLER_PROVIDER"), o.INIT_TIMED_PUSH_NOT_AVAILABLE = "TimedPushController cannot be initialized due to invalid/insufficient timedPush configuration.", o), d.TIMED_PUSH_CTRL = (p(s = function() {
          }, "TIMED_PUSH_CTRL"), s.INIT_INTERVAL_NOT_VALID = "Interval for Timed Push is invalid, could not start Timed Push trigger.", s.INIT_MIN_TIME_NOT_VALID = "Minimum time to start timer for Timed Push is invalid, could not start Timed Push trigger.", s.INFO_PUSH_TRIGGERED = "Px Api: timed push was triggered.", s), d.APP_PUSH_CFG = (p(u = function() {
          }, "APP_PUSH_CFG"), u.VALID_FROM_CANNOT_BE_AFTER_VALID_TO = "Valid-From date cannot be after Valid-to date.", u.AREAID_CANNOT_BE_EMTPY = "areaId cannot be empty.", u.TRIGGERNAME_CANNOT_BE_EMTPY = "triggerName cannot be empty.", u), d.APP_PUSH_STATE = (p(T = function() {
          }, "APP_PUSH_STATE"), T.CTOR_AREA_ID_NOT_PROVIDED = "areaId is not provided!", T.CTOR_TRIGGER_NAME_NOT_PROVIDED = "triggerName is not provided!", T.CTOR_TRIGGER_TYPE_NOT_PROVIDED = "triggerType is not provided!", T), d.INIT_CONTROLLER = (p(S = function() {
          }, "INIT_CONTROLLER"), S.ERROR_HEADER = "Init failed.", S.INIT_MODE_COULD_NOT_BE_IDENTIFIED = "Init mode could not be identified.", S.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_INFO = 'Mandatory paramter "tenantInfo" null or empty.', S.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_ID = 'Mandatory parameter "tenantInfo.tenantId" null or empty.', S.INIT_MANDATORY_PARAMS_NOT_VALID_TENANT_ROLE = 'Mandatory parameter "tenantRole.tenantRole" null or empty.', S.INIT_MANDATORY_PARAMS_VALID = "Mandatory init parameters are validated successfully.", S.INIT_CFG_ID_OR_CFG_JSON_NEED_TO_BE_PROVIDED = 'Either "configIdentifier" or "configJson" must be provided.', S.INIT_BOTH_CFG_IDENTIFIER_CFG_JSON_NOT_POSSIBLE = "Please provide either configIdentifier or configJson, but not both.", S.INIT_CFG_IDENTIFIER_INVALID_UNIT_ID = "configIdentifier has either invalid unitId or it is missing.", S.INIT_CFG_IDENTIFIER_INVALID_ENVIRONMENT = "configIdentifier has either invalid environment or it is missing.", S.INIT_CFG_IDENTIFIER_INVALID_CFG_URL = "configIdentifier has either invalid configUrl or it is missing.", S.INIT_QUALTRICS_URI_CANNOT_BE_REACHED = "Qualtrics Uri cannot be reached. Please make sure to pass the correct Uri. Additionally, make sure that there is no Ad Blocker active in your browser.", S.INIT_QUALTRICS_LOADING_FAILED = "QSI API did not load successfully.", S.RENDER_QUALTRICS_SCRIPT_FAILED = 'Qualtrics "Script" could not be rendered.', S.INIT_CFG_LOAD_FAILED = "Could not load Config due to incorrect combination of Init mode with configIdentifier or configJson.", S.INIT_LOADING_MANUAL_CFG_FAILED = "Loading of manual config failed.", S.APP_PUSH_SCOPE_SET_INCONSISTENT = 'scopeSet "appPush" is configured in configuration but same could not be validated successfully during the runtime. Application triggered Push functionality will not be enabled!', S.TIMED_PUSH_SCOPE_SET_INCONSISTENT = 'scopeSet "timedPush" is configured in configuration but same could not be validated successfully during the runtime. Time Controlled Push functionality will not be enabled!', S), d.PRESENTATION_CTRL = (p(P = function() {
          }, "PRESENTATION_CTRL"), P.CTOR_STORAGE_SRVC_NOT_PROVIDED = "StorageService is not provided!", P.CTOR_CENTRAL_CFG_NOT_PROVIDED = "CentralConfig is not provided!", P.CTOR_QUALTRICS_BRIDGE_NOT_PROVIDED = "QualtricsBridge is not provided!", P.CTOR_CNTXT_DATA_CTRL_NOT_PROVIDED = "ContextDataController is not provided!", P.CTOR_INVITATION_CALLBACK_NOT_PROVIDED = "surveyInvitationDialogCallback is not provided!", P.APP_PUSH_STATE_NOT_UPDATED = "App Push state could not be updated.", P), d.PUSH_CFG = (p(b = function() {
          }, "PUSH_CFG"), b.CTOR_STARTUPCFG_CANNOT_BE_NULL = "startupConfig cannot be null", b), d.PX_API = (p(D = function() {
          }, "PX_API"), D.API_COULD_NOT_BE_INITIALIZED_MANDATORY_PARAMS_INVALID = "API could not be initialized correctly. Mandatory parameters invalid.", D.API_COULD_NOT_BE_INITIALIZED_API_MODE_INVALID = "API could not be initialized correctly. API_INIT_MODE invalid.", D.CFG_WAS_NOT_LOADED = "Config could not be loaded.", D.FEATURES_COULD_NOT_BE_INITIALIZED = "Features could not be initialized.", D.FEATURES_INITIALIZED_SUCCESSFULLY = "Features initialized successfully.", D.REQUEST_PUSH_NOT_POSSIBLE = `"requestPush" method cannot be invoked because application triggered push could not be enabled! 
        You might need to provide the "surveyInvitationDialogCallback" to "initializeFeedback" method to use App Push and Timed Push features.
		Other possibility could be that, the PX Configuration validation might not be successful. Please check the configuration further or you could open a internal ticket (component "CA-PX-API").`, D.PUSH_DATA_NOT_VALID = "pushData is not provided!", D.REQUEST_PUSH_APP_PUSH_OPTED_OUT = "requestPush cannot be triggered since appPush has been Opted out.", D.LOADED_QSI_API_UNLOADED = "Loaded QSI.API instance found, will be unloaded. Running two instances in parallel not possible.", D.CFG_NO_SCOPE_ITEM_FOUND = "No Scope Set item defined. Further initialization aborted as not necessary.", D.CFG_NO_MANUAL_SCOPE_SET = 'Scope Set item "manual" is required in order to use User-initiated feedback.', D.RUNTIME_CFG_UNDEFINED = '"requestPush" is not possible because runtime configuration is undefined.', D.API_ALREADY_INITIALIZED = 'PX-API already initialized. If initialization with different configuration required, create new instance or call "destroy" first.', D), d.RECURRING_TRIGGER = (p(U = function() {
          }, "RECURRING_TRIGGER"), U.CTOR_INTERVAL_NOT_VALID_NUMBER = "Interval is not a valid number: ", U.CTOR_MAX_LIMIT_NOT_VALID_NUMBER = "Max Limit is not a valid number: ", U.CTOR_START_THRESHOLD_NOT_VALID_NUMBER = "Start Threshold is not a valid number: ", U), d.THEME_VALUE_FETCHER = (p(E = function() {
          }, "THEME_VALUE_FETCHER"), E.LOAD_KEY_MAP_ERROR = "Something went wrong when trying to load the theming key map", E), d.VALIDATION_HANDLER = (p(y = function() {
          }, "VALIDATION_HANDLER"), y.CTOR_PARAM_STORAGE_NOT_PROVIDED = "storage is not provided!", y.CTOR_PARAM_CENTRAL_CFG_NOT_PROVIDED = "centralConfig is not provided!", y), d.PUSH_CONTEXT_DATA = (p(A = function() {
          }, "PUSH_CONTEXT_DATA"), A.INVALID_PAYLOAD = "Invalid payload provided in PushFeedbackRequestData!.", A), d;
        }();
        h.LoggerTexts = f;
      }, 3138: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ScopeCheck = void 0;
        var f = p(7765), d = p(1117), g = function() {
          function C() {
          }
          return C.hasAnyScopeItemConfigured = function(c) {
            return this.isUserInitiatedFeedbackPossible(c) || this.isAnyPushFeatureActive(c);
          }, C.isScopeItemActive = function(c, l) {
            var a;
            return !!(!((a = c == null ? void 0 : c.scopeSet) === null || a === void 0) && a.includes(l));
          }, C.isAnyPushFeatureActive = function(c) {
            return this.isAppPushAvailable(c) || this.isTimedPushAvailable(c);
          }, C.isUserInitiatedScopeSetActive = function(c) {
            return this.isScopeItemActive(c, f.Constants.SCOPE_USER_INITIATED);
          }, C.isAppPushScopeSetActive = function(c) {
            return this.isScopeItemActive(c, f.Constants.SCOPE_APP_PUSH);
          }, C.isTimedPushScopeSetActive = function(c) {
            return this.isScopeItemActive(c, f.Constants.SCOPE_TIMED_PUSH);
          }, C.isTestModeActive = function() {
            return d.Util.isUrlParamActive(f.Constants.URL_PARAM_TEST_MODE, "true");
          }, C.isUserInitiatedFeedbackPossible = function(c) {
            return !(!this.containsUserInitiatedUrlParam() && !this.isUserInitiatedScopeSetActive(c));
          }, C.isAppPushAvailable = function(c) {
            return !(!this.containsAppPushUrlParam() && !this.isAppPushScopeSetActive(c) || !d.Util.isLocalStorageAvailable());
          }, C.isTimedPushAvailable = function(c) {
            return !(!this.containsTimedPushUrlParam() && !this.isTimedPushScopeSetActive(c) || !d.Util.isLocalStorageAvailable());
          }, C.isScopeSetUrlParamDefined = function() {
            return d.Util.isUrlParamDefined(f.Constants.URL_PARAM_SCOPE_SET);
          }, C.containsUserInitiatedUrlParam = function() {
            return this.isScopeSetUrlParamDefined() && d.Util.containsUrlParam(f.Constants.URL_PARAM_SCOPE_SET, f.Constants.SCOPE_USER_INITIATED);
          }, C.containsAppPushUrlParam = function() {
            return this.isScopeSetUrlParamDefined() && d.Util.containsUrlParam(f.Constants.URL_PARAM_SCOPE_SET, f.Constants.SCOPE_APP_PUSH);
          }, C.containsTimedPushUrlParam = function() {
            return this.isScopeSetUrlParamDefined() && d.Util.containsUrlParam(f.Constants.URL_PARAM_SCOPE_SET, f.Constants.SCOPE_TIMED_PUSH);
          }, C;
        }();
        h.ScopeCheck = g;
      }, 6610: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.SettingsCheck = void 0;
        var f = p(7765), d = p(1117), g = function() {
          function C() {
          }
          return C.isStandaloneModeActive = function() {
            return this.isStandaloneModeParamDefined() ? this.isStandaloneModeParamActive() : this.isStandaloneModeGlobalDefinedAndActive();
          }, C.isStandaloneModeParamDefined = function() {
            return d.Util.isUrlParamDefined(f.Constants.URL_PARAM_STANDALONE_MODE);
          }, C.isStandaloneModeParamActive = function() {
            return d.Util.isUrlParamActive(f.Constants.URL_PARAM_STANDALONE_MODE, "true");
          }, C.isStandaloneModeGlobalDefinedAndActive = function() {
            d.Util.ensureGlobalContext("pxdata", "settings");
            var c = window;
            return !(!c.sap.pxdata.settings.standalone || c.sap.pxdata.settings.standalone !== !0);
          }, C;
        }();
        h.SettingsCheck = g;
      }, 1117: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.Util = void 0;
        var p = function() {
          function f() {
          }
          return f.isString = function(d) {
            return typeof d == "string" || d instanceof String;
          }, f.isObjectEmpty = function(d) {
            return !(!d || Object.keys(d).length !== 0);
          }, f.stringIsEmpty = function(d) {
            return !(!this.isString(d) || d.length !== 0 && d.trim());
          }, f.getTrimmedLowercaseString = function(d) {
            return this.isString(d) ? d.trim().toLowerCase() : null;
          }, f.getTrimmedUppercaseString = function(d) {
            return this.isString(d) ? d.trim().toUpperCase() : null;
          }, f.getCombinedKey = function(d, g) {
            return "".concat(d.trim().toLowerCase(), "/").concat(g.trim().toLowerCase());
          }, f.stringToTitleCase = function(d) {
            return this.isString(d) && !this.stringIsEmpty(d) ? d.replace(/\w\S*/g, function(g) {
              return g.charAt(0).toUpperCase() + g.substring(1).toLowerCase();
            }) : d;
          }, f.isQualtricsSurveyPopupOpen = function() {
            var d = !1, g = document.getElementsByClassName("QSIPopOver");
            return g != null && g.length && (d = !0), d;
          }, f.readUserState = function(d) {
            return d.readUserState();
          }, f.randomInt = function(d, g) {
            return d = Math.ceil(d), g = Math.floor(g), Math.floor(Math.random() * (g - d)) + d;
          }, f.isLocalStorageAvailable = function() {
            return !!localStorage;
          }, f.ensureGlobalContext = function(d, g) {
            if (window.sap || (window.sap = {}), d) {
              window.sap[d] || (window.sap[d] = {});
              var C = window.sap[d];
              return g ? (C[g] || (C[g] = {}), C[g]) : C;
            }
            return window.sap;
          }, f.getWindowSearchLocation = function() {
            return window.location.search;
          }, f.isUrlParamDefined = function(d) {
            var g = this.getWindowSearchLocation();
            if (g) {
              var C = new URLSearchParams(g);
              if (C && C.has(d))
                return !0;
            }
            return !1;
          }, f.isUrlParamActive = function(d, g) {
            var C = f.getWindowSearchLocation();
            if (C) {
              var c = new URLSearchParams(C);
              if (c && c.has(d)) {
                var l = c.get(d);
                if (l && l.trim().toLocaleLowerCase() === g)
                  return !0;
              }
            }
            return !1;
          }, f.containsUrlParam = function(d, g) {
            var C = f.getWindowSearchLocation();
            if (C) {
              var c = new URLSearchParams(C);
              if (c && c.has(d)) {
                var l = c.get(d);
                if (l)
                  return l.trim().split(",").findIndex(function(a) {
                    return a.trim().toLocaleLowerCase() === g.trim().toLocaleLowerCase();
                  }) !== -1;
              }
            }
            return !1;
          }, f;
        }();
        h.Util = p;
      }, 9554: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(l, a) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(m, i) {
            m.__proto__ = i;
          } || function(m, i) {
            for (var o in i)
              Object.prototype.hasOwnProperty.call(i, o) && (m[o] = i[o]);
          }, f(l, a);
        }, function(l, a) {
          if (typeof a != "function" && a !== null)
            throw new TypeError("Class extends value " + String(a) + " is not a constructor or null");
          function m() {
            this.constructor = l;
          }
          f(l, a), l.prototype = a === null ? Object.create(a) : (m.prototype = a.prototype, new m());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigJsonParserError = void 0;
        var g = p(1093), C = p(434), c = function(l) {
          function a(m, i) {
            var o = this, s = i ? i.trim() : "";
            o = l.call(this, s) || this, Error.captureStackTrace && Error.captureStackTrace(o, a), o.name = "PxApi.ConfigJsonParserError", o._initialError = m;
            var u = C.LoggerTexts.CFG_JSON_PARSER.ERROR_HEADER;
            return s && (u += ": ".concat(s)), o.message = u, o;
          }
          return d(a, l), a;
        }(g.PxApiError);
        h.ConfigJsonParserError = c;
      }, 3828: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(l, a) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(m, i) {
            m.__proto__ = i;
          } || function(m, i) {
            for (var o in i)
              Object.prototype.hasOwnProperty.call(i, o) && (m[o] = i[o]);
          }, f(l, a);
        }, function(l, a) {
          if (typeof a != "function" && a !== null)
            throw new TypeError("Class extends value " + String(a) + " is not a constructor or null");
          function m() {
            this.constructor = l;
          }
          f(l, a), l.prototype = a === null ? Object.create(a) : (m.prototype = a.prototype, new m());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigValidationError = void 0;
        var g = p(1093), C = p(434), c = function(l) {
          function a(m, i) {
            var o = this, s = i ? i.trim() : "";
            o = l.call(this, s) || this, Error.captureStackTrace && Error.captureStackTrace(o, a), o.name = "PxApi.ConfigValidationError", o._initialError = m;
            var u = C.LoggerTexts.CFG_VALIDATION.ERROR_HEADER;
            return s && (u += ": ".concat(s)), o.message = u, o;
          }
          return d(a, l), a;
        }(g.PxApiError);
        h.ConfigValidationError = c;
      }, 6491: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(l, a) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(m, i) {
            m.__proto__ = i;
          } || function(m, i) {
            for (var o in i)
              Object.prototype.hasOwnProperty.call(i, o) && (m[o] = i[o]);
          }, f(l, a);
        }, function(l, a) {
          if (typeof a != "function" && a !== null)
            throw new TypeError("Class extends value " + String(a) + " is not a constructor or null");
          function m() {
            this.constructor = l;
          }
          f(l, a), l.prototype = a === null ? Object.create(a) : (m.prototype = a.prototype, new m());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigurationLoadingError = void 0;
        var g = p(1093), C = p(434), c = function(l) {
          function a(m, i, o, s) {
            var u = this, T = s ? s.trim() : "";
            u = l.call(this, T) || this, Error.captureStackTrace && Error.captureStackTrace(u, a), u.name = "PxApi.ConfigurationLoadingError", u._url = m, u._statusCode = i, u._initialError = o;
            var S = C.LoggerTexts.CFG_LOADER.ERROR_HEADER;
            return u._url && !u._statusCode ? S += " from ".concat(u._url, " failed with an unknown error.") : u._url && u._statusCode && (S += " from ".concat(u._url, " failed with ").concat(u._statusCode, ".")), T && (S += " ".concat(T)), u.message = S, u;
          }
          return d(a, l), a;
        }(g.PxApiError);
        h.ConfigurationLoadingError = c;
      }, 3614: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.isError = h.ensureError = void 0;
        var f = p(1093);
        h.ensureError = function(d) {
          if (d instanceof Error)
            return d;
          var g = "[Unable to stringify the thrown value]";
          try {
            g = JSON.stringify(d);
          } catch (C) {
            return new f.PxApiError(g);
          }
          return new f.PxApiError("This value was thrown as is, not through an Error: ".concat(g));
        }, h.isError = function(d) {
          return d.success === !1;
        };
      }, 2675: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(l, a) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(m, i) {
            m.__proto__ = i;
          } || function(m, i) {
            for (var o in i)
              Object.prototype.hasOwnProperty.call(i, o) && (m[o] = i[o]);
          }, f(l, a);
        }, function(l, a) {
          if (typeof a != "function" && a !== null)
            throw new TypeError("Class extends value " + String(a) + " is not a constructor or null");
          function m() {
            this.constructor = l;
          }
          f(l, a), l.prototype = a === null ? Object.create(a) : (m.prototype = a.prototype, new m());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.InitControllerError = void 0;
        var g = p(1093), C = p(434), c = function(l) {
          function a(m, i) {
            var o = this, s = i ? i.trim() : "";
            o = l.call(this, s) || this, Error.captureStackTrace && Error.captureStackTrace(o, a), o.name = "PxApi.InitControllerError", o._initialError = m;
            var u = C.LoggerTexts.INIT_CONTROLLER.ERROR_HEADER;
            return s && (u += " ".concat(s)), o.message = u, o;
          }
          return d(a, l), a;
        }(g.PxApiError);
        h.InitControllerError = c;
      }, 1093: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(c, l) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(a, m) {
            a.__proto__ = m;
          } || function(a, m) {
            for (var i in m)
              Object.prototype.hasOwnProperty.call(m, i) && (a[i] = m[i]);
          }, f(c, l);
        }, function(c, l) {
          if (typeof l != "function" && l !== null)
            throw new TypeError("Class extends value " + String(l) + " is not a constructor or null");
          function a() {
            this.constructor = c;
          }
          f(c, l), c.prototype = l === null ? Object.create(l) : (a.prototype = l.prototype, new a());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PxApiError = void 0;
        var g = p(434), C = function(c) {
          function l(a) {
            var m = this, i = a ? a.trim() : "";
            m = c.call(this, i) || this, Error.captureStackTrace && Error.captureStackTrace(m, l), m.name = "PxApi.Error";
            var o = g.LoggerTexts.PXAPI_ERROR.ERROR_HEADER;
            return i && i.length > 0 && (o += " ".concat(i)), m.message = o, m;
          }
          return d(l, c), l;
        }(Error);
        h.PxApiError = C;
      }, 3567: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.CentralConfig = void 0;
        var f = p(9349), d = p(7765), g = p(5937), C = p(434), c = p(3138), l = p(1117), a = function() {
          function m(i, o) {
            if (this._logger = new g.Logger(d.Constants.FILE_CENTRAL_CFG), !i)
              throw new Error(C.LoggerTexts.CENTRAL_CFG.CTOR_CFG_ID_CANNOT_BE_NULL);
            if (!o)
              throw new Error(C.LoggerTexts.CENTRAL_CFG.CTOR_TENANT_INFO_CANNOT_BE_NULL);
            this._configIdentifier = i, this._tenantInfo = o;
          }
          return m.prototype.initWithConfig = function(i) {
            var o = i.startupConfig, s = i.runtimeConfig, u = i.pushConfig, T = i.themingConfig;
            this._version = i.version, this._startupConfig = f.ConfigFactory.createStartupConfig(o), this._runtimeConfig = f.ConfigFactory.createRuntimeConfig(s), c.ScopeCheck.isAnyPushFeatureActive(o) && (this._pushConfig = f.ConfigFactory.createPushConfig(o, u)), T && !l.Util.isObjectEmpty(T) ? this._themingConfig = f.ConfigFactory.createThemingConfig(T) : this._logger.info(C.LoggerTexts.CENTRAL_CFG.CTOR_THEMING_CFG_EMPTY);
          }, Object.defineProperty(m.prototype, "version", { get: function() {
            return this._version;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "configIdentifier", { get: function() {
            return this._configIdentifier;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "tenantInfo", { get: function() {
            return this._tenantInfo;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "startupConfig", { get: function() {
            return this._startupConfig;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "runtimeConfig", { get: function() {
            return this._runtimeConfig;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "pushConfig", { get: function() {
            return this._pushConfig;
          }, set: function(i) {
            this._pushConfig = i;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "themingConfig", { get: function() {
            return this._themingConfig;
          }, enumerable: !1, configurable: !0 }), m;
        }();
        h.CentralConfig = a;
      }, 9349: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigFactory = void 0;
        var f = p(4087), d = p(7400), g = p(2378), C = p(4136), c = function() {
          function l() {
          }
          return l.createStartupConfig = function(a) {
            return new g.StartupConfig(a);
          }, l.createRuntimeConfig = function(a) {
            return new d.RuntimeConfig(a);
          }, l.createPushConfig = function(a, m) {
            return new f.PushConfig(a, m);
          }, l.createThemingConfig = function(a) {
            return new C.ThemingConfig(a);
          }, l;
        }();
        h.ConfigFactory = c;
      }, 3347: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigJsonParser = void 0;
        var f = p(3567), d = p(7765), g = p(9160), C = p(9554), c = p(434), l = p(1117), a = function() {
          function m() {
          }
          return m.parseJsonToCentralConfig = function(i, o) {
            if (!i)
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_TENANT_INFO_CANNOT_BE_NULL) };
            if (!o)
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_JSON_DATA_CANNOT_BE_NULL) };
            var s = o.version;
            if (!s)
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_JSON_DATA_VERSION_MISSING_OR_EMPTY) };
            if (!l.Util.isString(s))
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_JSON_DATA_VERSION_NOT_A_STRING) };
            var u = o.environment;
            if (!m._isEnvValueValid(u))
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_JSON_DATA_ENV_NOT_VALID_VALUE) };
            var T = s, S = d.Constants.SUPPORTED_MAJOR_CFG_VERSION + ".";
            if (T.startsWith(S))
              return this._parseCfgMajorVersion0(i, o);
            var P = "Version of PX-Config schema is not supported. Expected major version: ".concat(d.Constants.SUPPORTED_MAJOR_CFG_VERSION, ". Instead received: ").concat(T, " from server.");
            return { success: !1, error: new C.ConfigJsonParserError(void 0, P) };
          }, m._isEnvValueValid = function(i) {
            return !(!l.Util.isString(i) || !g.Environment[i.toLowerCase()]);
          }, m._parseCfgMajorVersion0 = function(i, o) {
            try {
              var s = o.version, u = o.unitId, T = o.environment, S = { unitId: u, environment: g.Environment[T.toLowerCase()] }, P = { version: s, startupConfig: o.startupConfig, runtimeConfig: void 0, pushConfig: void 0 };
              o.runtimeConfig && (P.runtimeConfig = o.runtimeConfig), o.pushConfig && (P.pushConfig = o.pushConfig), o.themingConfig && (P.themingConfig = o.themingConfig);
              var b = new f.CentralConfig(S, i);
              return b.initWithConfig(P), { success: !0, result: b };
            } catch (D) {
              return { success: !1, error: new C.ConfigJsonParserError(void 0, c.LoggerTexts.CFG_JSON_PARSER.CTOR_JSON_DATA_UNEXPECTED_ERROR + D.message) };
            }
          }, m;
        }();
        h.ConfigJsonParser = a;
      }, 453: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigValidation = void 0;
        var f = p(7765), d = p(3828), g = p(3614), C = p(5937), c = p(434), l = p(3138), a = p(1117), m = function() {
          function i() {
          }
          return i.areMandatorySettingsExistent = function(o) {
            var s = this._getLogger();
            if (!o)
              return { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_CANNOT_BE_NULL) };
            var u = this._isConfigHeaderValid(o);
            if ((0, g.isError)(u))
              return u;
            if (!o.startupConfig)
              return { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_STARTUP_CFG_CANNOT_BE_NULL) };
            var T = this._isStartupConfigValid(o.startupConfig);
            if ((0, g.isError)(T))
              return T;
            if (!o.runtimeConfig)
              return { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_RUNTIME_CFG_CANNOT_BE_NULL) };
            this._checkForApiUseFalseDeprecation(s, o.runtimeConfig);
            var S = this._isRuntimeConfigValid(s, o.runtimeConfig);
            if ((0, g.isError)(S))
              return S;
            if (o.themingConfig) {
              var P = this._isThemingConfigValid(s, o.themingConfig, o.runtimeConfig);
              if ((0, g.isError)(P))
                return P;
            }
            return { success: !0, result: !0 };
          }, i.isTimedPushConfigIsValid = function(o) {
            var s = this._getLogger(), u = o == null ? void 0 : o.pushConfig;
            if (u) {
              if (this._isValidIntervalTimerInMinutes(s, u.intervalTimerInMinutes) && this._isValidMinimumTimeToStartTimerInHrs(s, u.minimumTimeToStartTimerInHrs) && this._isValidIntervalInitialTimedPushInDays(s, u.intervalInitialTimedPushInDays) && this._isValidDeviationInitialTimedPushInDays(s, u.deviationInitialTimedPushInDays) && this._isValidIntervalNextTimedPushInDays(s, u.intervalNextTimedPushInDays) && this._isDeviationNextTimedPushInDays(s, u.deviationNextTimedPushInDays))
                return this._validateTimedPushConfigValuesLimits(u), !0;
            } else
              s.info(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_CONFIG_NOT_PROVIDED);
            return !1;
          }, i.isAppPushConfigIsValid = function(o) {
            var s, u = this._getLogger(), T = o == null ? void 0 : o.pushConfig;
            if (T)
              if (((s = T.appPushConfigs) === null || s === void 0 ? void 0 : s.size) > 0) {
                if (this._isValidIntervalInitialAppPushInDays(u, T.intervalInitialAppPushInDays) && this._isValidDeviationInitialAppPushInDays(u, T.deviationInitialAppPushInDays) && this._isValidIntervalNextAppPushInDays(u, T.intervalNextAppPushInDays) && this._isValidDeviationNextAppPushInDays(u, T.deviationNextAppPushInDays))
                  return this._validateAppPushConfigValuesLimits(T), !0;
              } else
                u.info(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_CONFIGS_NOT_MAINTAINED);
            else
              u.info(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_CONFIG_NOT_PROVIDED);
            return !1;
          }, i._isValidIntervalTimerInMinutes = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.INTERVAL_TIMER_IN_MINUTES), u;
          }, i._isValidMinimumTimeToStartTimerInHrs = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.MIN_TIME_TO_START_TIMER_IN_HRS), u;
          }, i._isValidIntervalInitialTimedPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.INTERVAL_INITIAL_PUSH_IN_DAYS), u;
          }, i._isValidDeviationInitialTimedPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.DEVIATION_INITIAL_PUSH_IN_DAYS), u;
          }, i._isValidIntervalNextTimedPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.INTERVAL_NEXT_PUSH_IN_DAYS), u;
          }, i._isDeviationNextTimedPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_INVALID_INTERVALS.DEVIATION_NEXT_PUSH_IN_DAYS), u;
          }, i._validateTimedPushConfigValuesLimits = function(o) {
            var s = this._getLogger();
            l.ScopeCheck.isTestModeActive() || (o.intervalTimerInMinutes < f.Constants.LIMITS.MIN_RECOMMENDED_INTERVAL_TIMER_IN_MINUTES && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_TIMER_MIN), o.minimumTimeToStartTimerInHrs < f.Constants.LIMITS.MIN_RECOMMENDED_MIN_TIME_TO_START_TIME_IN_HRS && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_MIN_START_TIMER), o.intervalInitialTimedPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_INTERVAL_INITIAL_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_INIT_PUSH), o.deviationInitialTimedPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_DEVIATION_INITIAL_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_DEVIATION_INIT_PUSH), o.intervalNextTimedPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_INTERVAL_NEXT_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_INTERVAL_NEXT_PUSH), o.deviationNextTimedPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_DEVIATION_NEXT_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.TIMED_PUSH_VALUE_BELOW_LIMIT_DEVIATION_NEXT_PUSH));
          }, i._isValidIntervalInitialAppPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_INVALID_INTERVALS.INTERVAL_INITIAL_PUSH_IN_DAYS), u;
          }, i._isValidDeviationInitialAppPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_INVALID_INTERVALS.DEVIATION_INITIAL_PUSH_IN_DAYS), u;
          }, i._isValidIntervalNextAppPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_INVALID_INTERVALS.INTERVAL_NEXT_PUSH_IN_DAYS), u;
          }, i._isValidDeviationNextAppPushInDays = function(o, s) {
            var u = this._isValidPxConfigNumber(s);
            return u || o.error(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_INVALID_INTERVALS.DEVIATION_NEXT_PUSH_IN_DAYS), u;
          }, i._isValidPxConfigNumber = function(o) {
            return Number.isFinite(o) && o >= 0 && !this._isScientificNumber(o);
          }, i._isScientificNumber = function(o) {
            return /^[+-]?\d+(\.\d+)?[eE][+-]?\d+$/.test(o.toString());
          }, i._validateAppPushConfigValuesLimits = function(o) {
            var s = this._getLogger();
            l.ScopeCheck.isTestModeActive() || (o.intervalInitialAppPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_INTERVAL_INITIAL_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_VALUE_BELOW_LIMIT_INTERVAL_INIT_PUSH), o.deviationInitialAppPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_DEVIATION_INITIAL_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_VALUE_BELOW_LIMIT_DEVIATION_INIT_PUSH), o.intervalNextAppPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_INTERVAL_NEXT_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_VALUE_BELOW_LIMIT_INTERVAL_NEXT_PUSH), o.deviationNextAppPushInDays < f.Constants.LIMITS.MIN_RECOMMENDED_DEVIATION_NEXT_PUSH_IN_DAYS && s.warn(c.LoggerTexts.CFG_VALIDATION.APP_PUSH_VALUE_BELOW_LIMIT_DEVIATION_NEXT_PUSH));
          }, i.isConfigIdentifierIsValid = function(o) {
            return o.unitId ? o.environment ? o.configUrl && this._isValidConfigUrl(o.configUrl) ? { success: !0, result: !0 } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.INIT_CONTROLLER.INIT_CFG_IDENTIFIER_INVALID_CFG_URL) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.INIT_CONTROLLER.INIT_CFG_IDENTIFIER_INVALID_ENVIRONMENT) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.INIT_CONTROLLER.INIT_CFG_IDENTIFIER_INVALID_UNIT_ID) };
          }, i._isValidConfigUrl = function(o) {
            var s;
            try {
              s = new URL(o);
            } catch (u) {
              return !1;
            }
            return s.protocol === "https:";
          }, i._getLogger = function() {
            return new C.Logger(f.Constants.FILE_CFG_VALIDATION);
          }, i._isConfigHeaderValid = function(o) {
            return o.version ? a.Util.isString(o.version) ? o.configIdentifier ? o.configIdentifier.unitId ? o.configIdentifier.environment ? o.tenantInfo ? { success: !0, result: !0 } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_TENANT_ID_CANNOT_BE_NULL) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_CFG_ID_ENV_CANNOT_BE_NULL) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_CFG_ID_UNIT_ID_CANNOT_BE_NULL) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_CFG_ID_CANNOT_BE_NULL) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_VERSION_NOT_A_STRING) } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.CENTRAL_CFG_HEADER_VERSION_NOT_FOUND) };
          }, i._isStartupConfigValid = function(o) {
            return o.qualtricsInternalUri ? { success: !0, result: !0 } : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.STARTUP_CFG_QUALTRICS_INT_URI_CANNOT_BE_NULL) };
          }, i._isRuntimeConfigValid = function(o, s) {
            return s.useApi !== !1 || s.domElementId ? (s.useApi === !0 && s.domElementId && o.warn(c.LoggerTexts.CFG_VALIDATION.RUNTIME_CFG_USEAPI_TRUE_THEN_DOMELEMENT_ID_NO_EFFECT), { success: !0, result: !0 }) : { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.RUNTIME_CFG_USEAPI_FALSE_WHEN_DOMELEMENT_ID_NOT_SET) };
          }, i._checkForApiUseFalseDeprecation = function(o, s) {
            s.useApi || o.warn(c.LoggerTexts.CFG_VALIDATION.USE_API_FALSE_DEPRECATION_WARNING);
          }, i._isThemingConfigValid = function(o, s, u) {
            if (s.writeToGlobals) {
              if (s.writeToGlobals && !u.useApi)
                return { success: !1, error: new d.ConfigValidationError(void 0, c.LoggerTexts.CFG_VALIDATION.THEMING_CFG_REQUIRES_RUNTIME_CFG_USEAPI_TO_BE_TRUE) };
            } else
              o.warn(c.LoggerTexts.CFG_VALIDATION.THEMING_CFG_WRITE_TO_GLOBALS_SET_TO_FALSE_NO_EFFECT);
            return { success: !0, result: !0 };
          }, i;
        }();
        h.ConfigValidation = m;
      }, 7134: function(v, h, p) {
        var f = this && this.__awaiter || function(i, o, s, u) {
          return new (s || (s = Promise))(function(T, S) {
            function P(U) {
              try {
                D(u.next(U));
              } catch (E) {
                S(E);
              }
            }
            function b(U) {
              try {
                D(u.throw(U));
              } catch (E) {
                S(E);
              }
            }
            function D(U) {
              var E;
              U.done ? T(U.value) : (E = U.value, E instanceof s ? E : new s(function(y) {
                y(E);
              })).then(P, b);
            }
            D((u = u.apply(i, o || [])).next());
          });
        }, d = this && this.__generator || function(i, o) {
          var s, u, T, S, P = { label: 0, sent: function() {
            if (1 & T[0])
              throw T[1];
            return T[1];
          }, trys: [], ops: [] };
          return S = { next: b(0), throw: b(1), return: b(2) }, typeof Symbol == "function" && (S[Symbol.iterator] = function() {
            return this;
          }), S;
          function b(D) {
            return function(U) {
              return function(E) {
                if (s)
                  throw new TypeError("Generator is already executing.");
                for (; S && (S = 0, E[0] && (P = 0)), P; )
                  try {
                    if (s = 1, u && (T = 2 & E[0] ? u.return : E[0] ? u.throw || ((T = u.return) && T.call(u), 0) : u.next) && !(T = T.call(u, E[1])).done)
                      return T;
                    switch (u = 0, T && (E = [2 & E[0], T.value]), E[0]) {
                      case 0:
                      case 1:
                        T = E;
                        break;
                      case 4:
                        return P.label++, { value: E[1], done: !1 };
                      case 5:
                        P.label++, u = E[1], E = [0];
                        continue;
                      case 7:
                        E = P.ops.pop(), P.trys.pop();
                        continue;
                      default:
                        if (!((T = (T = P.trys).length > 0 && T[T.length - 1]) || E[0] !== 6 && E[0] !== 2)) {
                          P = 0;
                          continue;
                        }
                        if (E[0] === 3 && (!T || E[1] > T[0] && E[1] < T[3])) {
                          P.label = E[1];
                          break;
                        }
                        if (E[0] === 6 && P.label < T[1]) {
                          P.label = T[1], T = E;
                          break;
                        }
                        if (T && P.label < T[2]) {
                          P.label = T[2], P.ops.push(E);
                          break;
                        }
                        T[2] && P.ops.pop(), P.trys.pop();
                        continue;
                    }
                    E = o.call(i, P);
                  } catch (y) {
                    E = [6, y], u = 0;
                  } finally {
                    s = T = 0;
                  }
                if (5 & E[0])
                  throw E[1];
                return { value: E[0] ? E[1] : void 0, done: !0 };
              }([D, U]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ConfigurationLoader = void 0;
        var g = p(3347), C = p(7765), c = p(6491), l = p(3614), a = p(434), m = function() {
          function i(o, s) {
            this._configIdentifier = o, this._tenantInfo = s;
          }
          return i.prototype.loadConfiguration = function() {
            return f(this, void 0, void 0, function() {
              var o, s;
              return d(this, function(u) {
                switch (u.label) {
                  case 0:
                    return o = this._centralConfigurationUrl(), [4, this._getConfiguration(o, 1)];
                  case 1:
                    return s = u.sent(), (0, l.isError)(s) ? [2, s] : [2, g.ConfigJsonParser.parseJsonToCentralConfig(this._tenantInfo, s.result)];
                }
              });
            });
          }, i.prototype._getConfiguration = function(o, s) {
            return f(this, void 0, void 0, function() {
              var u, T, S, P, b;
              return d(this, function(D) {
                switch (D.label) {
                  case 0:
                    return D.trys.push([0, 6, , 7]), [4, fetch(o)];
                  case 1:
                    return u = D.sent(), (T = u.headers.get("content-type")) && T.includes("application/json") ? u.ok ? (b = { success: !0 }, [4, u.json()]) : [3, 3] : [2, { success: !1, error: new c.ConfigurationLoadingError(o, void 0, void 0, a.LoggerTexts.CFG_LOADER.GET_CENTRAL_CFG_LOADING_INVALID_CONTENT_TYPE) }];
                  case 2:
                    return [2, (b.result = D.sent(), b)];
                  case 3:
                    return s > 0 ? [4, this._getConfiguration(o, s - 1)] : [3, 5];
                  case 4:
                    return [2, D.sent()];
                  case 5:
                    return [2, { success: !1, error: new c.ConfigurationLoadingError(o, u.status) }];
                  case 6:
                    return S = D.sent(), P = (0, l.ensureError)(S), [2, { success: !1, error: new c.ConfigurationLoadingError(o, void 0, P) }];
                  case 7:
                    return [2];
                }
              });
            });
          }, i.prototype._centralConfigurationUrl = function() {
            var o = new URL(this._configIdentifier.configUrl), s = new URLSearchParams({ unitId: this._configIdentifier.unitId, env: this._configIdentifier.environment, tenantId: this._tenantInfo.tenantId.trim().toLowerCase(), version: C.Constants.SUPPORTED_MAJOR_CFG_VERSION.toString() });
            return o.search = s.toString(), o;
          }, i;
        }();
        h.ConfigurationLoader = m;
      }, 7400: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.RuntimeConfig = void 0;
        var f = p(7765), d = function() {
          function g(C) {
            this._useApi = !0, this._daysUntilLocalStateExpiry = f.Constants.DEFAULTS.DAYS_UNTIL_STATE_EXPIRY, (C == null ? void 0 : C.useApi) !== void 0 && (this._useApi = C.useApi), C != null && C.domElementId && (this._domElementId = C.domElementId), C != null && C.daysUntilLocalStateExpiry && (this._daysUntilLocalStateExpiry = C.daysUntilLocalStateExpiry);
          }
          return Object.defineProperty(g.prototype, "useApi", { get: function() {
            return this._useApi;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(g.prototype, "domElementId", { get: function() {
            return this._domElementId;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(g.prototype, "daysUntilLocalStateExpiry", { get: function() {
            return this._daysUntilLocalStateExpiry;
          }, enumerable: !1, configurable: !0 }), g;
        }();
        h.RuntimeConfig = d;
      }, 2378: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.StartupConfig = void 0;
        var p = function() {
          function f(d) {
            this._enableQualtricsRestrictedMode = !1, this._scopeSet = [], this._qualtricsInternalUri = d.qualtricsInternalUri, this._enableQualtricsRestrictedMode = !!d.enableQualtricsRestrictedMode, this._productName = d.productName, this._platformType = d.platformType, this._scopeSet = d.scopeSet || [];
          }
          return Object.defineProperty(f.prototype, "qualtricsInternalUri", { get: function() {
            return this._qualtricsInternalUri;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "enableQualtricsRestrictedMode", { get: function() {
            return this._enableQualtricsRestrictedMode;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "productName", { get: function() {
            return this._productName;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "platformType", { get: function() {
            return this._platformType;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "scopeSet", { get: function() {
            return this._scopeSet;
          }, enumerable: !1, configurable: !0 }), f;
        }();
        h.StartupConfig = p;
      }, 4136: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ThemingConfig = void 0;
        var p = function() {
          function f(d) {
            this._writeToGlobals = !1, this._writeToGlobals = d.writeToGlobals;
          }
          return Object.defineProperty(f.prototype, "writeToGlobals", { get: function() {
            return this._writeToGlobals;
          }, enumerable: !1, configurable: !0 }), f;
        }();
        h.ThemingConfig = p;
      }, 3540: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.AppPushConfig = void 0;
        var f = p(8501), d = p(434), g = p(1117), C = function() {
          function c() {
          }
          return c.prototype.init = function(l, a, m, i, o) {
            if (g.Util.stringIsEmpty(l))
              throw Error(d.LoggerTexts.APP_PUSH_CFG.AREAID_CANNOT_BE_EMTPY);
            if (this._areaId = l, g.Util.stringIsEmpty(a))
              throw Error(d.LoggerTexts.APP_PUSH_CFG.TRIGGERNAME_CANNOT_BE_EMTPY);
            if (this._triggerName = a, !f.DateTimeUtil.isDateValidInISO(m))
              throw Error("Valid-From(".concat(m, ") is not a valid date for ").concat(l, " ").concat(a));
            if (!f.DateTimeUtil.isDateValidInISO(i))
              throw Error("Valid-To(".concat(i, ") is not a valid date for ").concat(l, " ").concat(a));
            var s = f.DateTimeUtil.getTimeFromISODate(m), u = f.DateTimeUtil.getTimeFromISODate(i);
            if (s >= u)
              throw Error(d.LoggerTexts.APP_PUSH_CFG.VALID_FROM_CANNOT_BE_AFTER_VALID_TO);
            this._validFrom = s, this._validTo = u, this._isEnabled = o;
          }, c.prototype.initFromJsonObject = function(l) {
            var a = l.areaId, m = l.triggerName, i = l.validFrom, o = l.validTo, s = l.isEnabled;
            this.init(a, m, i, o, s);
          }, Object.defineProperty(c.prototype, "combinedKey", { get: function() {
            return g.Util.getCombinedKey(this._areaId, this._triggerName);
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "areaId", { get: function() {
            return this._areaId;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggerName", { get: function() {
            return this._triggerName;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "validFrom", { get: function() {
            return this._validFrom;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "validTo", { get: function() {
            return this._validTo;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "isEnabled", { get: function() {
            return this._isEnabled;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggerType", { get: function() {
            return this._triggerType;
          }, set: function(l) {
            this._triggerType = l;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggerConfig", { get: function() {
            return this._triggerConfig;
          }, set: function(l) {
            this._triggerConfig = l;
          }, enumerable: !1, configurable: !0 }), c.prototype.isQualifiedForPush = function(l, a) {
            return this.triggerConfig.isQualifiedForPush(l, a);
          }, c.prototype.isActive = function() {
            return !(!this.isEnabled || this.isExpired());
          }, c.prototype.isExpired = function() {
            var l = Date.now();
            return !this._isValidNow(l) && !this._isValidInFuture(l);
          }, c.prototype._isValidNow = function(l) {
            return this.validFrom < l && this.validTo > l;
          }, c.prototype._isValidInFuture = function(l) {
            return this.validFrom > l && this.validTo > l && this.validTo > this.validFrom;
          }, c;
        }();
        h.AppPushConfig = C;
      }, 4087: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PushConfig = void 0;
        var f = p(3540), d = p(457), g = p(7765), C = p(434), c = p(3138), l = p(1117), a = function() {
          function m(i, o) {
            if (this._immediateTestValue = 0, this._immediateTestTimedPushInterval = 2, !i)
              throw new Error(C.LoggerTexts.PUSH_CFG.CTOR_STARTUPCFG_CANNOT_BE_NULL);
            this._startupConfig = i, o != null && o.general && (this._generalPushInfo = o.general), o != null && o.timedPush && (this._timedPush = o.timedPush), o != null && o.appPush && (this._appPush = o.appPush), c.ScopeCheck.isTestModeActive() ? this._activateTestMode() : this._applyLoadedConfig(), (o == null ? void 0 : o.appPush) && o.appPush.configs && this._parseAppPushConfigs(o.appPush.configs);
          }
          return m.prototype._applyLoadedConfig = function() {
            this._preparePushConfigGeneralInfo(), this._prepareTimedPushInfo(), this._prepareAppPushInfo();
          }, m.prototype._preparePushConfigGeneralInfo = function() {
            var i, o, s, u;
            this._quietPeriodInHrs = (o = (i = this._generalPushInfo) === null || i === void 0 ? void 0 : i.quietPeriodInHrs) !== null && o !== void 0 ? o : g.Constants.DEFAULTS.PUSH_GENERAL_QUIET_PERIOD_IN_HRS, this._snoozePeriodInHrs = (u = (s = this._generalPushInfo) === null || s === void 0 ? void 0 : s.snoozePeriodInHrs) !== null && u !== void 0 ? u : g.Constants.DEFAULTS.PUSH_GENERAL_SNOOZE_PERIOD_IN_HRS;
          }, m.prototype._prepareTimedPushInfo = function() {
            var i, o, s, u, T, S;
            c.ScopeCheck.isTimedPushAvailable(this._startupConfig) && (this._timedPush || (this._timedPush = {}), this._intervalTimerInMinutes = (i = this._timedPush.intervalTimerInMinutes) !== null && i !== void 0 ? i : g.Constants.DEFAULTS.TIMED_PUSH_INTERVAL_TIMER_IN_MINS, this._minimumTimeToStartTimerInHrs = (o = this._timedPush.minimumTimeToStartTimerInHrs) !== null && o !== void 0 ? o : g.Constants.DEFAULTS.TIMED_PUSH_MIN_TIME_TO_START_TIMER_IN_HRS, this._intervalInitialTimedPushInDays = (s = this._timedPush.intervalInitialPushInDays) !== null && s !== void 0 ? s : g.Constants.DEFAULTS.TIMED_PUSH_INTERVAL_INIT_PUSH_IN_DAYS, this._deviationInitialTimedPushInDays = (u = this._timedPush.deviationInitialPushInDays) !== null && u !== void 0 ? u : g.Constants.DEFAULTS.TIMED_PUSH_DEVIATION_INIT_PUSH_IN_DAYS, this._intervalNextTimedPushInDays = (T = this._timedPush.intervalNextPushInDays) !== null && T !== void 0 ? T : g.Constants.DEFAULTS.TIMED_PUSH_INTERVAL_NEXT_PUSH_IN_DAYS, this._deviationNextTimedPushInDays = (S = this._timedPush.deviationNextPushInDays) !== null && S !== void 0 ? S : g.Constants.DEFAULTS.TIMED_PUSH_DEVIATION_NEXT_PUSH_IN_DAYS);
          }, m.prototype._prepareAppPushInfo = function() {
            var i, o, s, u;
            c.ScopeCheck.isAppPushAvailable(this._startupConfig) && (this._appPush || (this._appPush = {}), this._intervalInitialAppPushInDays = (i = this._appPush.intervalInitialPushInDays) !== null && i !== void 0 ? i : g.Constants.DEFAULTS.APP_PUSH_INTERVAL_INIT_PUSH_IN_DAYS, this._deviationInitialAppPushInDays = (o = this._appPush.deviationInitialPushInDays) !== null && o !== void 0 ? o : g.Constants.DEFAULTS.APP_PUSH_DEVIATION_INIT_PUSH_IN_DAYS, this._intervalNextAppPushInDays = (s = this._appPush.intervalNextPushInDays) !== null && s !== void 0 ? s : g.Constants.DEFAULTS.APP_PUSH_INTERVAL_NEXT_PUSH_IN_DAYS, this._deviationNextAppPushInDays = (u = this._appPush.deviationNextPushInDays) !== null && u !== void 0 ? u : g.Constants.DEFAULTS.APP_PUSH_DEVIATION_NEXT_PUSH_IN_DAYS);
          }, m.prototype._activateTestMode = function() {
            var i;
            this._quietPeriodInHrs = this._immediateTestValue, this._snoozePeriodInHrs = this._immediateTestValue, this._intervalInitialTimedPushInDays = this._immediateTestValue, this._deviationInitialTimedPushInDays = this._immediateTestValue, this._intervalInitialAppPushInDays = this._immediateTestValue, this._deviationInitialAppPushInDays = this._immediateTestValue, this._intervalNextTimedPushInDays = this._immediateTestValue, this._deviationNextTimedPushInDays = this._immediateTestValue, this._intervalNextAppPushInDays = this._immediateTestValue, this._deviationNextAppPushInDays = this._immediateTestValue, this._intervalTimerInMinutes = this._immediateTestTimedPushInterval, this._minimumTimeToStartTimerInHrs = ((i = this._timedPush) === null || i === void 0 ? void 0 : i.minimumTimeToStartTimerInHrs) || 0;
          }, Object.defineProperty(m.prototype, "quietPeriodInHrs", { get: function() {
            return this._quietPeriodInHrs;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "snoozePeriodInHrs", { get: function() {
            return this._snoozePeriodInHrs;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "intervalInitialTimedPushInDays", { get: function() {
            return this._intervalInitialTimedPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "deviationInitialTimedPushInDays", { get: function() {
            return this._deviationInitialTimedPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "intervalInitialAppPushInDays", { get: function() {
            return this._intervalInitialAppPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "deviationInitialAppPushInDays", { get: function() {
            return this._deviationInitialAppPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "intervalNextTimedPushInDays", { get: function() {
            return this._intervalNextTimedPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "deviationNextTimedPushInDays", { get: function() {
            return this._deviationNextTimedPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "intervalNextAppPushInDays", { get: function() {
            return this._intervalNextAppPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "deviationNextAppPushInDays", { get: function() {
            return this._deviationNextAppPushInDays;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "intervalTimerInMinutes", { get: function() {
            return this._intervalTimerInMinutes;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "minimumTimeToStartTimerInHrs", { get: function() {
            return this._minimumTimeToStartTimerInHrs;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(m.prototype, "appPushConfigs", { get: function() {
            return this._appPushConfigs;
          }, enumerable: !1, configurable: !0 }), m.prototype._parseAppPushConfigs = function(i) {
            var o = this;
            this._appPushConfigs = /* @__PURE__ */ new Map(), i.forEach(function(s) {
              var u = s.trigger, T = u.type, S = new d.RecurringTrigger(u), P = new f.AppPushConfig();
              P.initFromJsonObject(s), P.triggerType = T, P.triggerConfig = S, o._addAppPushConfig(P);
            });
          }, m.prototype._addAppPushConfig = function(i) {
            this._appPushConfigs.set(i.combinedKey, i);
          }, m.prototype.findAppPushConfigById = function(i, o) {
            var s = l.Util.getCombinedKey(i, o), u = this._appPushConfigs.get(s);
            if (u != null && u.isActive())
              return u;
          }, m.prototype.findExpiredAppPushConfigs = function() {
            var i = [];
            return this._appPushConfigs.forEach(function(o) {
              o.isExpired() && i.push(o);
            }), i;
          }, m;
        }();
        h.PushConfig = a;
      }, 7764: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.BaseTrigger = void 0;
        var p = function() {
          function f(d, g, C, c) {
            c === void 0 && (c = !1), this._interval = -1, this._maxLimitCount = -1, this._thresholdCountStart = -1, this._isForcePush = !1, this._interval = d, this._maxLimitCount = g, this._thresholdCountStart = C, this._isForcePush = !!c;
          }
          return Object.defineProperty(f.prototype, "interval", { get: function() {
            return this._interval;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "maxLimitCount", { get: function() {
            return this._maxLimitCount;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "thresholdCountStart", { get: function() {
            return this._thresholdCountStart;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "isForcePush", { get: function() {
            return this._isForcePush;
          }, enumerable: !1, configurable: !0 }), f.prototype.isQualifiedForPush = function(d, g) {
            var C = d.triggeredCount, c = d.executedCount;
            return !!(this._isMinimumThresholdReached(C) && this._hasNotReachedMaxLimit(c) && this._isIntervalMatching(C));
          }, f.prototype._isMinimumThresholdReached = function(d) {
            return d >= this.thresholdCountStart;
          }, f.prototype._hasNotReachedMaxLimit = function(d) {
            return d < this.maxLimitCount;
          }, f.prototype._isIntervalMatching = function(d) {
            return this.interval === d || d % this.interval == 0;
          }, f;
        }();
        h.BaseTrigger = p;
      }, 457: function(v, h, p) {
        var f, d = this && this.__extends || (f = function(l, a) {
          return f = Object.setPrototypeOf || { __proto__: [] } instanceof Array && function(m, i) {
            m.__proto__ = i;
          } || function(m, i) {
            for (var o in i)
              Object.prototype.hasOwnProperty.call(i, o) && (m[o] = i[o]);
          }, f(l, a);
        }, function(l, a) {
          if (typeof a != "function" && a !== null)
            throw new TypeError("Class extends value " + String(a) + " is not a constructor or null");
          function m() {
            this.constructor = l;
          }
          f(l, a), l.prototype = a === null ? Object.create(a) : (m.prototype = a.prototype, new m());
        });
        Object.defineProperty(h, "__esModule", { value: !0 }), h.RecurringTrigger = void 0;
        var g = p(7764), C = p(434), c = function(l) {
          function a(m) {
            var i = m.interval, o = m.maxLimit, s = m.startThreshold;
            if (!Number.isInteger(i))
              throw Error(C.LoggerTexts.RECURRING_TRIGGER.CTOR_INTERVAL_NOT_VALID_NUMBER + i);
            if (!Number.isInteger(o))
              throw Error(C.LoggerTexts.RECURRING_TRIGGER.CTOR_MAX_LIMIT_NOT_VALID_NUMBER + o);
            if (!Number.isInteger(s))
              throw Error(C.LoggerTexts.RECURRING_TRIGGER.CTOR_START_THRESHOLD_NOT_VALID_NUMBER + s);
            return l.call(this, i, o, s) || this;
          }
          return d(a, l), a;
        }(g.BaseTrigger);
        h.RecurringTrigger = c;
      }, 8564: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(i, o, s, u) {
          u === void 0 && (u = s);
          var T = Object.getOwnPropertyDescriptor(o, s);
          T && !("get" in T ? !o.__esModule : T.writable || T.configurable) || (T = { enumerable: !0, get: function() {
            return o[s];
          } }), Object.defineProperty(i, u, T);
        } : function(i, o, s, u) {
          u === void 0 && (u = s), i[u] = o[s];
        }), d = this && this.__setModuleDefault || (Object.create ? function(i, o) {
          Object.defineProperty(i, "default", { enumerable: !0, value: o });
        } : function(i, o) {
          i.default = o;
        }), g = this && this.__importStar || function(i) {
          if (i && i.__esModule)
            return i;
          var o = {};
          if (i != null)
            for (var s in i)
              s !== "default" && Object.prototype.hasOwnProperty.call(i, s) && f(o, i, s);
          return d(o, i), o;
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.AppContextDataContainer = void 0;
        var C = p(7765), c = g(p(7650)), l = p(5937), a = p(1117), m = function() {
          function i() {
            this._logger = new l.Logger(C.Constants.FILE_APP_CONTEXT_DATA_CONTAINER);
          }
          return i.create = function(o, s) {
            s === void 0 && (s = c.CLIENT_ACTION.none);
            var u = new i();
            return o || (o = {}), u.appId = o.appId, u.appTitle = o.appTitle, u.appVersion = o.appVersion, u.appSupportInfo = o.appSupportInfo, u.technicalAppComponentId = o.technicalAppComponentId, u.appFrameworkId = o.appFrameworkId, u.appFrameworkVersion = o.appFrameworkVersion, u.theme = o.theme, u.previousTheme = o.previousTheme, u.languageTag = o.languageTag, u.clientAction = s, u;
          }, i.prototype.toQualtricsContextData = function() {
            var o = {};
            return o.appId = this.appId, o.appTitle = this.appTitle, o.appVersion = this.appVersion, o.appSupportInfo = this.appSupportInfo, o.technicalAppComponentId = this.technicalAppComponentId, o.appFrameworkId = this.appFrameworkId, o.appFrameworkVersion = this.appFrameworkVersion, o.theme = this.theme, o.previousTheme = this.previousTheme, o.languageTag = this.languageTag, o[C.Constants.CLIENT_ACTION] = this.clientAction, o;
          }, Object.defineProperty(i.prototype, "appId", { get: function() {
            return this._isValidNonEmptyString(this._appId) ? this._appId : (this._logger.info('appId is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appId = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "appTitle", { get: function() {
            return this._isValidNonEmptyString(this._appTitle) ? this._appTitle : (this._logger.info('appTitle is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appTitle = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "appVersion", { get: function() {
            return this._isValidNonEmptyString(this._appVersion) ? this._appVersion : (this._logger.info('appVersion is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appVersion = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "appSupportInfo", { get: function() {
            return a.Util.getTrimmedUppercaseString(this._appSupportInfo) || (this._logger.info('appSupportInfo is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appSupportInfo = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "technicalAppComponentId", { get: function() {
            return this._isValidNonEmptyString(this._technicalAppComponentId) ? this._technicalAppComponentId : (this._logger.info('technicalAppComponentId is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._technicalAppComponentId = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "appFrameworkId", { get: function() {
            return this._isValidNonEmptyString(this._appFrameworkId) ? this._appFrameworkId : (this._logger.info('appFrameworkId is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appFrameworkId = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "appFrameworkVersion", { get: function() {
            return this._isValidNonEmptyString(this._appFrameworkVersion) ? this._appFrameworkVersion : (this._logger.info('appFrameworkVersion is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._appFrameworkVersion = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "theme", { get: function() {
            return a.Util.getTrimmedLowercaseString(this._theme) || (this._logger.info('theme is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._theme = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "previousTheme", { get: function() {
            return a.Util.getTrimmedLowercaseString(this._previousTheme) || (this._logger.info('previousTheme is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._previousTheme = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "languageTag", { get: function() {
            var o = a.Util.getTrimmedUppercaseString(this._languageTag);
            return o && o.length > 0 ? o : (this._logger.info('languageTag is not valid or missing, "'.concat(C.Constants.VALUE_NOT_AVAILABLE, '" will be assigned to it.')), C.Constants.VALUE_NOT_AVAILABLE);
          }, set: function(o) {
            this._languageTag = o;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(i.prototype, "clientAction", { get: function() {
            return this._clientAction;
          }, set: function(o) {
            this._clientAction = o;
          }, enumerable: !1, configurable: !0 }), i.prototype._isValidNonEmptyString = function(o) {
            return a.Util.isString(o) && !a.Util.stringIsEmpty(o);
          }, i;
        }();
        h.AppContextDataContainer = m;
      }, 214: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.AppPushState = void 0;
        var f = p(7765), d = p(434), g = p(1117), C = function() {
          function c() {
            this._triggeredCount = 0, this._executedCount = 0;
          }
          return c.prototype.init = function(l, a, m, i, o, s) {
            if (!l || g.Util.stringIsEmpty(l))
              throw Error(d.LoggerTexts.APP_PUSH_STATE.CTOR_AREA_ID_NOT_PROVIDED);
            if (!a || g.Util.stringIsEmpty(a))
              throw Error(d.LoggerTexts.APP_PUSH_STATE.CTOR_TRIGGER_NAME_NOT_PROVIDED);
            if (!m)
              throw Error(d.LoggerTexts.APP_PUSH_STATE.CTOR_TRIGGER_TYPE_NOT_PROVIDED);
            this._areaId = l, this._triggerName = a, this._triggerType = m, this._triggeredCount = i != null ? i : 0, this._executedCount = o != null ? o : 0, this._lastChanged = s != null ? s : Date.now();
          }, c.prototype.initFromJsonObject = function(l) {
            var a = l.areaId, m = l.triggerName, i = l.triggerType, o = l.triggeredCount, s = l.executedCount, u = l.lastChanged;
            this.init(a, m, i, o, s, u);
          }, Object.defineProperty(c.prototype, "combinedKey", { get: function() {
            return g.Util.getCombinedKey(this._areaId, this._triggerName);
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "areaId", { get: function() {
            return this._areaId;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggerName", { get: function() {
            return this._triggerName;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggerType", { get: function() {
            return this._triggerType;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "triggeredCount", { get: function() {
            return this._triggeredCount;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "executedCount", { get: function() {
            return this._executedCount;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(c.prototype, "lastChanged", { get: function() {
            return this._lastChanged;
          }, set: function(l) {
            this._lastChanged = l;
          }, enumerable: !1, configurable: !0 }), c.prototype.increaseTriggeredCount = function() {
            this._triggeredCount++, this.lastChanged = Date.now();
          }, c.prototype.increaseExecutedCount = function() {
            this._executedCount++, this.lastChanged = Date.now();
          }, c.prototype.hasReachedExpiryDate = function() {
            return Number.isInteger(this.lastChanged) ? (Date.now() - this.lastChanged) / 864e5 >= f.Constants.DEFAULTS.DAYS_UNTIL_STATE_EXPIRY : (this.lastChanged = Date.now(), !1);
          }, Object.defineProperty(c.prototype, "appPushStateObject", { get: function() {
            var l = { areaId: this.areaId, triggerName: this.triggerName, triggerType: this.triggerType, lastChanged: this.lastChanged };
            return this.triggeredCount >= 0 && (l.triggeredCount = this.triggeredCount), this.executedCount >= 0 && (l.executedCount = this.executedCount), l;
          }, enumerable: !1, configurable: !0 }), c;
        }();
        h.AppPushState = C;
      }, 8733: function(v, h, p) {
        var f = this && this.__importDefault || function(c) {
          return c && c.__esModule ? c : { default: c };
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ContextDataController = void 0;
        var d = f(p(7264)), g = p(1117), C = function() {
          function c() {
            this._window = window, this._initContext(), this._mockUi5();
          }
          return Object.defineProperty(c.prototype, "globalWindow", { get: function() {
            return this._window;
          }, enumerable: !1, configurable: !0 }), c.prototype.reset = function() {
            this._window.sap && (this._window.sap.qtx && (this._window.sap.qtx = void 0), this._window.sap.pxdata && (this._window.sap.pxdata = void 0));
          }, c.prototype.setAppContext = function(l) {
            var a = l.toQualtricsContextData();
            this._applyProperties(a, this._window.sap.qtx.appcontext);
          }, c.prototype.setSessionContext = function(l) {
            this._window.sap.qtx.session = {};
            var a = l;
            this._applyProperties(a, this._window.sap.qtx.session);
          }, c.prototype.setDeviceContext = function() {
            var l = d.default.createDeviceContextData();
            this._window.sap.qtx.device.type = l.deviceType, this._window.sap.qtx.device.orientation = l.orientationType, this._window.sap.qtx.device.osName = l.operatingSystemName, this._window.sap.qtx.device.browserName = l.browserName;
          }, c.prototype.setPushContext = function(l) {
            this._window.sap.qtx.push = {}, l && (this._window.sap.qtx.push.type = l.type, this._window.sap.qtx.push.areaId = l.areaId, this._window.sap.qtx.push.triggerName = l.triggerName, this._window.sap.qtx.push.shortText = l.shortText, this._window.sap.qtx.push.payload = l.payloadToString);
          }, c.prototype.setPushTelemetryContext = function(l) {
            this._window.sap.qtx.metrics.push = {}, l && (this._window.sap.qtx.metrics.push.triggered = l.pushEventTriggeredCount, this._window.sap.qtx.metrics.push.executed = l.pushEventExecutedCount, this._window.sap.qtx.metrics.push.snoozed = l.pushEventSnoozedCount, this._window.sap.qtx.metrics.push.timeSinceLastPush = l.timeSinceLastPushEvent);
          }, c.prototype.setThemingDataContext = function(l) {
            var a = this;
            this._window.sap.qtx.theming = {}, l && l.length > 0 && l.forEach(function(m) {
              a._window.sap.qtx.theming[m.embeddedDataKey] = m.cssValue;
            });
          }, c.prototype.resetThemingContextData = function() {
            this._window.sap.qtx.theming = void 0;
          }, c.prototype.resetVariableContextData = function() {
            this._window.sap.qtx.appcontext = {}, this._window.sap.qtx.push = {}, this._window.sap.qtx.metrics.push = {};
          }, c.prototype._initContext = function() {
            g.Util.ensureGlobalContext("pxdata", "settings"), g.Util.ensureGlobalContext("qtx", "appcontext"), g.Util.ensureGlobalContext("qtx", "session"), g.Util.ensureGlobalContext("qtx", "push"), g.Util.ensureGlobalContext("qtx", "device");
            var l = g.Util.ensureGlobalContext("qtx", "metrics");
            l.push || (l.push = {});
          }, c.prototype._mockUi5 = function() {
            g.Util.ensureGlobalContext(), this._window.sap.ui || (this._window.sap.ui = { core: { theming: { Parameters: { get: function() {
              return "";
            } } } } });
          }, c.prototype._applyProperties = function(l, a) {
            l && Object.keys(l).forEach(function(m) {
              a[m] = l[m];
            });
          }, c;
        }();
        h.ContextDataController = C;
      }, 7264: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 });
        var f = p(6227), d = function() {
          function g() {
          }
          return g.createDeviceContextData = function() {
            return new f.DeviceContextData();
          }, g;
        }();
        h.default = d;
      }, 6227: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.DeviceContextData = void 0;
        var f = p(3819), d = p(7765), g = function() {
          function C(c) {
            this.uaParser = new f.UAParser(c);
          }
          return Object.defineProperty(C.prototype, "deviceType", { get: function() {
            var c = this.uaParser.getDevice().type;
            if (c) {
              if (/mobile/.test(c.toLowerCase()))
                return d.Constants.DEVICE.TYPE.PHONE;
              if (/tablet/.test(c.toLowerCase()))
                return d.Constants.DEVICE.TYPE.TABLET;
            }
            return d.Constants.DEVICE.TYPE.DESKTOP;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(C.prototype, "orientationType", { get: function() {
            return window.matchMedia("(orientation: landscape)").matches ? d.Constants.DEVICE.ORIENTATION.LANDSCAPE : d.Constants.DEVICE.ORIENTATION.PORTRAIT;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(C.prototype, "operatingSystemName", { get: function() {
            var c = this.uaParser.getOS().name;
            return c ? /mac/.test(c.toLowerCase()) ? d.Constants.DEVICE.OS_NAME.MAC : /windows/.test(c.toLowerCase()) ? d.Constants.DEVICE.OS_NAME.WINDOWS : c : d.Constants.VALUE_NOT_AVAILABLE;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(C.prototype, "browserName", { get: function() {
            var c = this.uaParser.getBrowser().name;
            return c ? /chrome/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.CHROME : /edge/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.EDGE : /firefox/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.FIREFOX : /safari/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.SAFARI : /ie/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.IE : /opera/.test(c.toLowerCase()) ? d.Constants.DEVICE.BROWSER_NAME.OPERA : c : d.Constants.VALUE_NOT_AVAILABLE;
          }, enumerable: !1, configurable: !0 }), C;
        }();
        h.DeviceContextData = g;
      }, 1532: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PushContextData = void 0;
        var f = p(7765), d = p(7650), g = p(5937), C = p(434), c = function() {
          function l(a, m, i, o) {
            this._type = d.PUSH_SRC_TYPE.unknown, this._logger = new g.Logger(f.Constants.FILE_PUSH_CONTEXT_DATA), this._areaId = a, this._triggerName = m, this._shortText = i == null ? void 0 : i.trim(), this._payload = this._verifyPayload(o);
          }
          return Object.defineProperty(l.prototype, "type", { get: function() {
            return this._type;
          }, set: function(a) {
            this._type = a;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "areaId", { get: function() {
            return this._areaId;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "triggerName", { get: function() {
            return this._triggerName;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "shortText", { get: function() {
            return this._shortText || f.Constants.VALUE_NOT_AVAILABLE;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "payloadToString", { get: function() {
            return this._payload ? JSON.stringify(this._payload) : void 0;
          }, enumerable: !1, configurable: !0 }), l.prototype._verifyPayload = function(a) {
            if (a)
              try {
                var m = JSON.stringify(a);
                if (!(m.length > f.Constants.LIMITS.MAX_APP_TRIGGERED_PUSH_PAYLOAD_SIZE_IN_CHARS))
                  return JSON.parse(m);
                this._logger.error("'payload' size has exceeded its limit of ".concat(f.Constants.LIMITS.MAX_APP_TRIGGERED_PUSH_PAYLOAD_SIZE_IN_CHARS, " characters in PushFeedbackRequestData!. payload will be set to 'null'."));
              } catch (i) {
                throw Error(C.LoggerTexts.PUSH_CONTEXT_DATA.INVALID_PAYLOAD);
              }
          }, l;
        }();
        h.PushContextData = c;
      }, 1378: function(v, h) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PushTelemetryData = void 0;
        var p = function() {
          function f() {
            this._pushEventTriggeredCount = 0, this._pushEventExecutedCount = 0, this._pushEventSnoozedCount = 0, this._timeSinceLastPushEvent = 0;
          }
          return Object.defineProperty(f.prototype, "pushEventTriggeredCount", { get: function() {
            return this._pushEventTriggeredCount;
          }, set: function(d) {
            this._pushEventTriggeredCount = d;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "pushEventExecutedCount", { get: function() {
            return this._pushEventExecutedCount;
          }, set: function(d) {
            this._pushEventExecutedCount = d;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "pushEventSnoozedCount", { get: function() {
            return this._pushEventSnoozedCount;
          }, set: function(d) {
            this._pushEventSnoozedCount = d;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(f.prototype, "timeSinceLastPushEvent", { get: function() {
            return this._timeSinceLastPushEvent;
          }, set: function(d) {
            this._timeSinceLastPushEvent = d;
          }, enumerable: !1, configurable: !0 }), f;
        }();
        h.PushTelemetryData = p;
      }, 719: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.UserState = void 0;
        var f = p(214), d = p(7765), g = p(5937), C = p(1117), c = function() {
          function l(a) {
            a === void 0 && (a = !1), this._version = 1, this._isDebugState = !1, this._snoozeCount = 0, this._isDebugState = a, this.appPushStates = /* @__PURE__ */ new Map(), this._logger = new g.Logger(d.Constants.FILE_USER_STATE);
          }
          return l.prototype.initFromJsonObject = function(a) {
            this._isDebugState = !!a.isDebugState, a.version && (this._version = a.version), a.lastPush && (this._lastPush = a.lastPush), a.timedPushDate && (this._timedPushDate = a.timedPushDate), a.appPushDate && (this._appPushDate = a.appPushDate), a.lastTheme && (this._lastTheme = a.lastTheme), a.currentTheme && (this._currentTheme = a.currentTheme), a.toggleStart && (this._themeToggleStart = a.toggleStart), a.snoozeCount && (this._snoozeCount = a.snoozeCount), this.appPushStates = /* @__PURE__ */ new Map(), a.appPushStates && this._parseAppPushStates(a.appPushStates);
          }, l.prototype._parseAppPushStates = function(a) {
            var m = this;
            new Map(Object.entries(a)).forEach(function(i, o) {
              try {
                var s = new f.AppPushState();
                s.initFromJsonObject(a[o]);
                var u = s.combinedKey;
                m.appPushStates.set(u, s);
              } catch (T) {
                m._logger.error("App Push state could not be parsed correctly, will be ignored. ".concat(T.message));
              }
            });
          }, Object.defineProperty(l.prototype, "appPushStates", { get: function() {
            return this._appPushStates;
          }, set: function(a) {
            this._appPushStates = a;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "isDebugState", { get: function() {
            return this._isDebugState;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "lastPush", { get: function() {
            return this._lastPush;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "timedPushDate", { get: function() {
            return this._timedPushDate;
          }, set: function(a) {
            this._timedPushDate = a;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "appPushDate", { get: function() {
            return this._appPushDate;
          }, set: function(a) {
            this._appPushDate = a;
          }, enumerable: !1, configurable: !0 }), l.prototype.updateLastPushToNow = function() {
            this._lastPush = Date.now();
          }, Object.defineProperty(l.prototype, "lastTheme", { get: function() {
            return this._lastTheme;
          }, set: function(a) {
            this._lastTheme = a;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "currentTheme", { get: function() {
            return this._currentTheme;
          }, set: function(a) {
            this._currentTheme = a;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "themeToggleStart", { get: function() {
            return this._themeToggleStart;
          }, set: function(a) {
            this._themeToggleStart = a;
          }, enumerable: !1, configurable: !0 }), l.prototype.clearThemeToggleStart = function() {
            this._themeToggleStart = void 0;
          }, Object.defineProperty(l.prototype, "snoozeCount", { get: function() {
            return this._snoozeCount;
          }, enumerable: !1, configurable: !0 }), l.prototype.increaseSnoozeCount = function() {
            this._snoozeCount++;
          }, l.prototype.resetSnoozeCount = function() {
            this._snoozeCount = 0;
          }, l.prototype.createAndAddAppPushState = function(a, m, i) {
            var o = new f.AppPushState();
            return o.init(a, m, i), this.addAppPushState(o), o;
          }, l.prototype.addAppPushState = function(a) {
            this.appPushStates.set(a.combinedKey, a);
          }, l.prototype.removeAppPushState = function(a, m) {
            var i = C.Util.getCombinedKey(a, m);
            this.appPushStates.has(i) && this.appPushStates.delete(i);
          }, l.prototype.getAppPushState = function(a, m) {
            var i = C.Util.getCombinedKey(a, m);
            return this.appPushStates.get(i);
          }, l.prototype.findAppPushStatesReachedExpiryDate = function() {
            var a = [];
            return this.appPushStates.forEach(function(m) {
              m.hasReachedExpiryDate() && a.push(m);
            }), a.length > 0 ? a : [];
          }, Object.defineProperty(l.prototype, "userStateJson", { get: function() {
            var a = {};
            return a.version = this._version, this._isDebugState && (a.isDebugState = this._isDebugState), this.lastPush && (a.lastPush = this.lastPush), this.timedPushDate && (a.timedPushDate = this.timedPushDate), this.appPushDate && (a.appPushDate = this.appPushDate), this.lastTheme && (a.lastTheme = this.lastTheme), this.currentTheme && (a.currentTheme = this.currentTheme), this.themeToggleStart && (a.toggleStart = this.themeToggleStart), this.snoozeCount && (a.snoozeCount = this.snoozeCount), this.appPushStates && (a.appPushStates = {}, this.appPushStates.forEach(function(m, i) {
              a.appPushStates[i] = m.appPushStateObject;
            })), a;
          }, enumerable: !1, configurable: !0 }), l;
        }();
        h.UserState = c;
      }, 7528: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.LocalStorageHandler = void 0;
        var f = p(7765), d = p(5937), g = p(3138), C = p(719), c = function() {
          function l() {
            this._logger = new d.Logger(f.Constants.FILE_PX_API), this.getValue(f.Constants.STOR_PUSH_STATE) || this._initNewStorage();
          }
          return Object.defineProperty(l.prototype, "localStorage", { get: function() {
            return localStorage;
          }, enumerable: !1, configurable: !0 }), l.prototype._initNewStorage = function() {
            var a = this.getNewUserState();
            return this.saveUserState(a), a;
          }, l.prototype.getNewUserState = function() {
            return g.ScopeCheck.isTestModeActive() ? new C.UserState(!0) : new C.UserState();
          }, l.prototype.getValue = function(a) {
            return this.localStorage && a ? this.localStorage.getItem(a) : null;
          }, l.prototype.updateValue = function(a, m) {
            this.localStorage && a && m && this.localStorage.setItem(a, m);
          }, l.prototype.readUserState = function() {
            var a = this.getValue(f.Constants.STOR_PUSH_STATE);
            return a ? this._parseExistingUserState(a) : this._initNewStorage();
          }, l.prototype.saveUserState = function(a) {
            if (a)
              try {
                var m = JSON.stringify(a.userStateJson);
                this.updateValue(f.Constants.STOR_PUSH_STATE, m);
              } catch (o) {
                var i = "Saving user state failed. ".concat(o.message);
                this._logger.error(i);
              }
          }, l.prototype._parseExistingUserState = function(a) {
            try {
              var m = JSON.parse(a);
              if (m) {
                var i = this.getNewUserState();
                return i.initFromJsonObject(m), i;
              }
            } catch (s) {
              var o = "Reading user state failed.' ".concat(s.message);
              this._logger.error(o);
            }
          }, l;
        }();
        h.LocalStorageHandler = c;
      }, 1727: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.StorageService = void 0;
        var f = p(7528), d = function() {
          function g() {
            this._initLocalStorageHandler();
          }
          return g.prototype._initLocalStorageHandler = function() {
            this._localStorageHandler = new f.LocalStorageHandler();
          }, Object.defineProperty(g.prototype, "localStorageHandler", { get: function() {
            return this._localStorageHandler;
          }, enumerable: !1, configurable: !0 }), g.prototype.readUserState = function() {
            return this.localStorageHandler.readUserState();
          }, g.prototype.getInitialUserState = function() {
            return this.localStorageHandler.getNewUserState();
          }, g.prototype.saveUserState = function(C) {
            this.localStorageHandler.saveUserState(C);
          }, g;
        }();
        h.StorageService = d;
      }, 7591: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.Balancer = void 0;
        var f = p(7650), d = p(434), g = function() {
          function C() {
          }
          return C.prototype.init = function(c) {
            if (!c)
              throw new Error(d.LoggerTexts.BALANCER.CTOR_STORAGE_NOT_PROVIDED);
            this._storage = c;
          }, C.prototype.balance = function(c) {
            return this._isSurveyTimeFrameReached(c);
          }, C.prototype._isSurveyTimeFrameReached = function(c) {
            var l = this._readUserState();
            return (c === f.PUSH_SRC_TYPE.timed && l ? l.timedPushDate : c === f.PUSH_SRC_TYPE.appPush && l ? l.appPushDate : Date.now() + 850301) <= Date.now();
          }, C.prototype._readUserState = function() {
            return this._storage.readUserState();
          }, C;
        }();
        h.Balancer = g;
      }, 2678: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.DateCalculator = void 0;
        var f = p(7650), d = function() {
          function g() {
          }
          return g.calculateInitialTimedPushDate = function(C) {
            return this._calculateNextSurveyDate(C.intervalInitialTimedPushInDays, C.deviationInitialTimedPushInDays);
          }, g.calculateInitialAppPushDate = function(C) {
            return this._calculateNextSurveyDate(C.intervalInitialAppPushInDays, C.deviationInitialAppPushInDays);
          }, g.calculateNextTimedPushDate = function(C) {
            return this._calculateNextSurveyDate(C.intervalNextTimedPushInDays, C.deviationNextTimedPushInDays);
          }, g.calculateNextAppPushDate = function(C) {
            return this._calculateNextSurveyDate(C.intervalNextAppPushInDays, C.deviationNextAppPushInDays);
          }, g._calculateNextSurveyDate = function(C, c) {
            var l = C + Math.round(Math.random() * c * 2) - c;
            return Date.now() + l * f.Time.daysToMilliseconds;
          }, g;
        }();
        h.DateCalculator = d;
      }, 6955: function(v, h, p) {
        var f = this && this.__awaiter || function(o, s, u, T) {
          return new (u || (u = Promise))(function(S, P) {
            function b(E) {
              try {
                U(T.next(E));
              } catch (y) {
                P(y);
              }
            }
            function D(E) {
              try {
                U(T.throw(E));
              } catch (y) {
                P(y);
              }
            }
            function U(E) {
              var y;
              E.done ? S(E.value) : (y = E.value, y instanceof u ? y : new u(function(A) {
                A(y);
              })).then(b, D);
            }
            U((T = T.apply(o, s || [])).next());
          });
        }, d = this && this.__generator || function(o, s) {
          var u, T, S, P, b = { label: 0, sent: function() {
            if (1 & S[0])
              throw S[1];
            return S[1];
          }, trys: [], ops: [] };
          return P = { next: D(0), throw: D(1), return: D(2) }, typeof Symbol == "function" && (P[Symbol.iterator] = function() {
            return this;
          }), P;
          function D(U) {
            return function(E) {
              return function(y) {
                if (u)
                  throw new TypeError("Generator is already executing.");
                for (; P && (P = 0, y[0] && (b = 0)), b; )
                  try {
                    if (u = 1, T && (S = 2 & y[0] ? T.return : y[0] ? T.throw || ((S = T.return) && S.call(T), 0) : T.next) && !(S = S.call(T, y[1])).done)
                      return S;
                    switch (T = 0, S && (y = [2 & y[0], S.value]), y[0]) {
                      case 0:
                      case 1:
                        S = y;
                        break;
                      case 4:
                        return b.label++, { value: y[1], done: !1 };
                      case 5:
                        b.label++, T = y[1], y = [0];
                        continue;
                      case 7:
                        y = b.ops.pop(), b.trys.pop();
                        continue;
                      default:
                        if (!((S = (S = b.trys).length > 0 && S[S.length - 1]) || y[0] !== 6 && y[0] !== 2)) {
                          b = 0;
                          continue;
                        }
                        if (y[0] === 3 && (!S || y[1] > S[0] && y[1] < S[3])) {
                          b.label = y[1];
                          break;
                        }
                        if (y[0] === 6 && b.label < S[1]) {
                          b.label = S[1], S = y;
                          break;
                        }
                        if (S && b.label < S[2]) {
                          b.label = S[2], b.ops.push(y);
                          break;
                        }
                        S[2] && b.ops.pop(), b.trys.pop();
                        continue;
                    }
                    y = s.call(o, b);
                  } catch (A) {
                    y = [6, A], T = 0;
                  } finally {
                    u = S = 0;
                  }
                if (5 & y[0])
                  throw y[1];
                return { value: y[0] ? y[1] : void 0, done: !0 };
              }([U, E]);
            };
          }
        }, g = this && this.__importDefault || function(o) {
          return o && o.__esModule ? o : { default: o };
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PresentationController = void 0;
        var C = p(6661), c = g(p(8741)), l = p(434), a = p(1117), m = p(8564), i = function() {
          function o(s, u, T, S, P) {
            if (this._isInvitationDialogOpen = !1, this._isDestroyCalled = !1, this._window = window, !s)
              throw new Error(l.LoggerTexts.PRESENTATION_CTRL.CTOR_STORAGE_SRVC_NOT_PROVIDED);
            if (!u)
              throw new Error(l.LoggerTexts.PRESENTATION_CTRL.CTOR_CENTRAL_CFG_NOT_PROVIDED);
            if (!T)
              throw new Error(l.LoggerTexts.PRESENTATION_CTRL.CTOR_QUALTRICS_BRIDGE_NOT_PROVIDED);
            if (!S)
              throw new Error(l.LoggerTexts.PRESENTATION_CTRL.CTOR_CNTXT_DATA_CTRL_NOT_PROVIDED);
            if (!P)
              throw new Error(l.LoggerTexts.PRESENTATION_CTRL.CTOR_INVITATION_CALLBACK_NOT_PROVIDED);
            this._storage = s, this._centralConfig = u, this._qualtricsBridge = T, this._contextDataController = S, this._surveyInvitationDialogCallback = P, this._initializePushHandler();
          }
          return o.prototype.displayInvitationDialog = function(s, u, T) {
            return f(this, void 0, void 0, function() {
              var S, P, b;
              return d(this, function(D) {
                switch (D.label) {
                  case 0:
                    return this._isDestroyCalled ? [3, 5] : (T && (this.pushHandler.stateConfig = T), this._checkIfSurveyInvitationDialogCanBeOpened() ? (this.isInvitationDialogOpen = !0, this._resetVariableContextData(), [4, this._surveyInvitationDialogCallback(this._getSurveyInvitationDialogEventData())]) : [3, 5]);
                  case 1:
                    return S = D.sent(), P = S.appContextData, b = S.surveyUser, this.isInvitationDialogOpen = !1, this._setAppContext(m.AppContextDataContainer.create(P, s)), b ? [4, this._surveyUser(u)] : [3, 3];
                  case 2:
                    return D.sent(), [3, 4];
                  case 3:
                    this.pushHandler.snoozePush(), D.label = 4;
                  case 4:
                    return [2, b];
                  case 5:
                    return [2, !1];
                }
              });
            });
          }, o.prototype.destroy = function() {
            this._isDestroyCalled = !0, this._pushHandler = void 0, this._surveyInvitationDialogCallback && (this._surveyInvitationDialogCallback = void 0);
          }, o.prototype._getSurveyInvitationDialogEventData = function() {
            return { pushType: this.pushHandler.getPushTypeForConsumers() };
          }, o.prototype._initializePushHandler = function() {
            this._pushHandler = new C.PushHandler(this._storage, this._centralConfig, this._contextDataController);
          }, Object.defineProperty(o.prototype, "pushHandler", { get: function() {
            return this._pushHandler;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(o.prototype, "isInvitationDialogOpen", { get: function() {
            return this._isInvitationDialogOpen;
          }, set: function(s) {
            this._isInvitationDialogOpen = s;
          }, enumerable: !1, configurable: !0 }), o.prototype._checkIfSurveyInvitationDialogCanBeOpened = function() {
            if (this.isInvitationDialogOpen)
              return !1;
            if (!a.Util.isQualtricsSurveyPopupOpen()) {
              if (this.pushHandler.isForcePush())
                return !0;
              var s = this.pushHandler.getPushType();
              return this._canUserDigestSurvey(s);
            }
            return !1;
          }, o.prototype._canUserDigestSurvey = function(s) {
            var u = c.default.createBalancer();
            return u.init(this._storage), u.balance(s);
          }, o.prototype._surveyUser = function(s) {
            return f(this, void 0, void 0, function() {
              return d(this, function(u) {
                switch (u.label) {
                  case 0:
                    return this.pushHandler.setPushContextData(s), this.pushHandler.setPushTelemetryContextData(), [4, this._openSurvey()];
                  case 1:
                    return u.sent(), this.pushHandler.updateLastPushTimestamp(), this.pushHandler.updatePushState(), this.pushHandler.updateNextPushDates(), [2];
                }
              });
            });
          }, o.prototype._openSurvey = function() {
            return f(this, void 0, void 0, function() {
              return d(this, function(s) {
                switch (s.label) {
                  case 0:
                    return this._qualtricsBridge.isApiLoaded ? (this._window.QSI.API.unload(), [4, this._window.QSI.API.load()]) : [3, 2];
                  case 1:
                    s.sent(), this._window.QSI.API.run(), s.label = 2;
                  case 2:
                    return [2];
                }
              });
            });
          }, o.prototype._resetVariableContextData = function() {
            this._contextDataController.resetVariableContextData();
          }, o.prototype._setAppContext = function(s) {
            this._contextDataController.setAppContext(s);
          }, o;
        }();
        h.PresentationController = i;
      }, 6661: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(P, b, D, U) {
          U === void 0 && (U = D);
          var E = Object.getOwnPropertyDescriptor(b, D);
          E && !("get" in E ? !b.__esModule : E.writable || E.configurable) || (E = { enumerable: !0, get: function() {
            return b[D];
          } }), Object.defineProperty(P, U, E);
        } : function(P, b, D, U) {
          U === void 0 && (U = D), P[U] = b[D];
        }), d = this && this.__setModuleDefault || (Object.create ? function(P, b) {
          Object.defineProperty(P, "default", { enumerable: !0, value: b });
        } : function(P, b) {
          P.default = b;
        }), g = this && this.__importStar || function(P) {
          if (P && P.__esModule)
            return P;
          var b = {};
          if (P != null)
            for (var D in P)
              D !== "default" && Object.prototype.hasOwnProperty.call(P, D) && f(b, P, D);
          return d(b, P), b;
        }, C = this && this.__importDefault || function(P) {
          return P && P.__esModule ? P : { default: P };
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.PushHandler = void 0;
        var c = p(7765), l = p(8501), a = g(p(7650)), m = p(9160), i = p(5937), o = p(434), s = p(1117), u = p(2678), T = C(p(8741)), S = function() {
          function P(b, D, U) {
            this._logger = new i.Logger(c.Constants.FILE_PUSH_HANDLER), this._storage = b, this._centralConfig = D, this._contextDataController = U;
          }
          return Object.defineProperty(P.prototype, "pushConfig", { get: function() {
            return this._centralConfig.pushConfig;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(P.prototype, "stateConfig", { get: function() {
            return this._stateConfig;
          }, set: function(b) {
            this._stateConfig = b;
          }, enumerable: !1, configurable: !0 }), P.prototype.isForcePush = function() {
            var b, D;
            return !!(!((D = (b = this.stateConfig) === null || b === void 0 ? void 0 : b.config) === null || D === void 0) && D.triggerConfig) && this.stateConfig.config.triggerConfig.isForcePush;
          }, P.prototype.getPushType = function() {
            return this.stateConfig ? a.PUSH_SRC_TYPE.appPush : a.PUSH_SRC_TYPE.timed;
          }, P.prototype.getPushTypeForConsumers = function() {
            return this.getPushType() === a.PUSH_SRC_TYPE.appPush ? m.PushType.appPush : m.PushType.timedPush;
          }, P.prototype.snoozePush = function() {
            var b = this._getUserState();
            if (b && this.pushConfig) {
              var D = b.snoozeCount;
              D >= c.Constants.LIMITS.MAX_SNOOZE_COUNT ? this._skipOnSnooze() : this._updateSnoozeValues(D + 1, this.pushConfig);
            }
          }, P.prototype.updateLastPushTimestamp = function() {
            var b = this._getUserState();
            b && (b.updateLastPushToNow(), b.resetSnoozeCount(), this._saveUserState(b));
          }, P.prototype.updatePushState = function() {
            if (this.stateConfig) {
              var b = this.stateConfig.state, D = this._getUserState();
              if (D) {
                D.resetSnoozeCount();
                var U = D.getAppPushState(b.areaId, b.triggerName);
                U ? (U.increaseExecutedCount(), this._saveUserState(D)) : this._logger.error(o.LoggerTexts.PRESENTATION_CTRL.APP_PUSH_STATE_NOT_UPDATED);
              }
            }
          }, P.prototype.updateNextPushDates = function(b) {
            b === void 0 && (b = !1);
            var D = this._getUserState();
            if (D && this.pushConfig) {
              var U = this.getPushType();
              (U === a.PUSH_SRC_TYPE.timed || b) && this._updateTimedPushDate(D, this.pushConfig), (U === a.PUSH_SRC_TYPE.appPush || b) && this._updateAppPushDate(D, this.pushConfig), this._saveUserState(D);
            }
          }, P.prototype.setPushContextData = function(b) {
            b.type = this.getPushType(), this._contextDataController.setPushContext(b);
          }, P.prototype.setPushTelemetryContextData = function() {
            var b, D = this._getUserState(), U = T.default.createTelemetryData();
            D && (U.pushEventSnoozedCount = D.snoozeCount, U.timeSinceLastPushEvent = Date.now() - D.lastPush), !((b = this.stateConfig) === null || b === void 0) && b.state && (U.pushEventTriggeredCount = this.stateConfig.state.triggeredCount, U.pushEventExecutedCount = this.stateConfig.state.executedCount), this._contextDataController.setPushTelemetryContext(U);
          }, P.prototype._getUserState = function() {
            return s.Util.readUserState(this._storage);
          }, P.prototype._saveUserState = function(b) {
            this._storage.saveUserState(b);
          }, P.prototype._skipOnSnooze = function() {
            this.updateNextPushDates(!0);
            var b = this._getUserState();
            b && (b.resetSnoozeCount(), this._saveUserState(b));
          }, P.prototype._updateTimedPushDate = function(b, D) {
            var U = Date.now() + l.DateTimeUtil.getMillisecondsFromHours(D.quietPeriodInHrs);
            b.timedPushDate = u.DateCalculator.calculateNextTimedPushDate(D);
            var E = b.appPushDate;
            E && E < U && (b.appPushDate = U);
          }, P.prototype._updateAppPushDate = function(b, D) {
            var U = Date.now() + l.DateTimeUtil.getMillisecondsFromHours(D.quietPeriodInHrs);
            b.appPushDate = u.DateCalculator.calculateNextAppPushDate(D);
            var E = b.timedPushDate;
            E && E < U && (b.timedPushDate = U);
          }, P.prototype._updateSnoozeValues = function(b, D) {
            var U = this._getUserState();
            if (U) {
              var E = U.appPushDate, y = U.timedPushDate, A = Date.now() + l.DateTimeUtil.getMillisecondsFromHours(D.snoozePeriodInHrs * b);
              E && E < A && (U.appPushDate = A), y && y < A && (U.timedPushDate = A), U.increaseSnoozeCount(), this._saveUserState(U);
            }
          }, P;
        }();
        h.PushHandler = S;
      }, 8741: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 });
        var f = p(7591), d = p(1378), g = function() {
          function C() {
          }
          return C.createBalancer = function() {
            return new f.Balancer();
          }, C.createTelemetryData = function() {
            return new d.PushTelemetryData();
          }, C;
        }();
        h.default = g;
      }, 9549: function(v, h, p) {
        var f = this && this.__awaiter || function(o, s, u, T) {
          return new (u || (u = Promise))(function(S, P) {
            function b(E) {
              try {
                U(T.next(E));
              } catch (y) {
                P(y);
              }
            }
            function D(E) {
              try {
                U(T.throw(E));
              } catch (y) {
                P(y);
              }
            }
            function U(E) {
              var y;
              E.done ? S(E.value) : (y = E.value, y instanceof u ? y : new u(function(A) {
                A(y);
              })).then(b, D);
            }
            U((T = T.apply(o, s || [])).next());
          });
        }, d = this && this.__generator || function(o, s) {
          var u, T, S, P, b = { label: 0, sent: function() {
            if (1 & S[0])
              throw S[1];
            return S[1];
          }, trys: [], ops: [] };
          return P = { next: D(0), throw: D(1), return: D(2) }, typeof Symbol == "function" && (P[Symbol.iterator] = function() {
            return this;
          }), P;
          function D(U) {
            return function(E) {
              return function(y) {
                if (u)
                  throw new TypeError("Generator is already executing.");
                for (; P && (P = 0, y[0] && (b = 0)), b; )
                  try {
                    if (u = 1, T && (S = 2 & y[0] ? T.return : y[0] ? T.throw || ((S = T.return) && S.call(T), 0) : T.next) && !(S = S.call(T, y[1])).done)
                      return S;
                    switch (T = 0, S && (y = [2 & y[0], S.value]), y[0]) {
                      case 0:
                      case 1:
                        S = y;
                        break;
                      case 4:
                        return b.label++, { value: y[1], done: !1 };
                      case 5:
                        b.label++, T = y[1], y = [0];
                        continue;
                      case 7:
                        y = b.ops.pop(), b.trys.pop();
                        continue;
                      default:
                        if (!((S = (S = b.trys).length > 0 && S[S.length - 1]) || y[0] !== 6 && y[0] !== 2)) {
                          b = 0;
                          continue;
                        }
                        if (y[0] === 3 && (!S || y[1] > S[0] && y[1] < S[3])) {
                          b.label = y[1];
                          break;
                        }
                        if (y[0] === 6 && b.label < S[1]) {
                          b.label = S[1], S = y;
                          break;
                        }
                        if (S && b.label < S[2]) {
                          b.label = S[2], b.ops.push(y);
                          break;
                        }
                        S[2] && b.ops.pop(), b.trys.pop();
                        continue;
                    }
                    y = s.call(o, b);
                  } catch (A) {
                    y = [6, A], T = 0;
                  } finally {
                    u = S = 0;
                  }
                if (5 & y[0])
                  throw y[1];
                return { value: y[0] ? y[1] : void 0, done: !0 };
              }([U, E]);
            };
          }
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.TimedPushController = void 0;
        var g = p(7765), C = p(8501), c = p(5937), l = p(434), a = p(6610), m = p(1117), i = function() {
          function o(s, u) {
            this._hasOptedOut = !1, this._isDestroyCalled = !1, this._centralConfig = s, this._storage = u, this._logger = new c.Logger(g.Constants.FILE_TIMED_PUSH_CONTROLLER);
          }
          return o.prototype.init = function(s) {
            var u = this._centralConfig.pushConfig;
            if (u) {
              this._timedPushDelayInMinutes = u.intervalTimerInMinutes, this._minimumTimeToStartTimerForTimedPushInHrs = u.minimumTimeToStartTimerInHrs;
              var T = m.Util.readUserState(this._storage);
              T && (this._nextTimedPushDate = T.timedPushDate);
            }
            Number.isFinite(this._timedPushDelayInMinutes) ? Number.isFinite(this._minimumTimeToStartTimerForTimedPushInHrs) ? (this._handleTimedPush = s, this._canTimerStart() && this._start()) : this._logger.error(l.LoggerTexts.TIMED_PUSH_CTRL.INIT_MIN_TIME_NOT_VALID) : this._logger.error(l.LoggerTexts.TIMED_PUSH_CTRL.INIT_INTERVAL_NOT_VALID);
          }, Object.defineProperty(o.prototype, "hasOptedOut", { get: function() {
            return this._hasOptedOut;
          }, set: function(s) {
            this._hasOptedOut = s, s || this._intervalTimer || this._canTimerStart() && this._start();
          }, enumerable: !1, configurable: !0 }), o.prototype.destroy = function() {
            this._isDestroyCalled = !0, this._intervalTimer && window.clearTimeout(this._intervalTimer);
          }, o.prototype._canTimerStart = function() {
            return !!(!this.hasOptedOut && this._nextTimedPushDate && this._nextTimedPushDate - Date.now() <= C.DateTimeUtil.getMillisecondsFromHours(this._minimumTimeToStartTimerForTimedPushInHrs));
          }, o.prototype._start = function() {
            var s = this;
            this._runTimer().finally(function() {
              s._start();
            });
          }, o.prototype._runTimer = function() {
            return f(this, void 0, void 0, function() {
              var s = this;
              return d(this, function(u) {
                return [2, new Promise(function(T) {
                  s._intervalTimer = window.setTimeout(function() {
                    return f(s, void 0, void 0, function() {
                      return d(this, function(S) {
                        switch (S.label) {
                          case 0:
                            return !this._handleTimedPush || this._isDestroyCalled || this.hasOptedOut || a.SettingsCheck.isStandaloneModeActive() ? [3, 2] : [4, this._handleTimedPush()];
                          case 1:
                            S.sent(), this._logger.info(l.LoggerTexts.TIMED_PUSH_CTRL.INFO_PUSH_TRIGGERED), S.label = 2;
                          case 2:
                            return T(), [2];
                        }
                      });
                    });
                  }, C.DateTimeUtil.getMillisecondsFromMinutes(s._timedPushDelayInMinutes));
                })];
              });
            });
          }, o;
        }();
        h.TimedPushController = i;
      }, 6139: function(v, h, p) {
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ValidationHandler = void 0;
        var f = p(7765), d = p(5937), g = p(434), C = p(1117), c = function() {
          function l() {
          }
          return Object.defineProperty(l.prototype, "storage", { get: function() {
            return this._storage;
          }, enumerable: !1, configurable: !0 }), Object.defineProperty(l.prototype, "centralConfig", { get: function() {
            return this._centralConfig;
          }, enumerable: !1, configurable: !0 }), l.prototype.init = function(a, m) {
            if (!a)
              throw new Error(g.LoggerTexts.VALIDATION_HANDLER.CTOR_PARAM_STORAGE_NOT_PROVIDED);
            if (!m)
              throw new Error(g.LoggerTexts.VALIDATION_HANDLER.CTOR_PARAM_CENTRAL_CFG_NOT_PROVIDED);
            this._storage = a, this._centralConfig = m, this._logger = new d.Logger(f.Constants.FILE_VALIDATION_HANDLER);
          }, l.prototype.validate = function(a) {
            if (this._isPushDataValid(a))
              return this._getRelevantStateConfig(a.areaId, a.triggerName);
          }, l.prototype._isPushDataValid = function(a) {
            if (!a.areaId || !a.triggerName)
              return this._logger.error("Event Payload data is invalid!"), !1;
            var m = a.areaId, i = a.triggerName;
            return !C.Util.isString(m) || C.Util.stringIsEmpty(m) ? (this._logger.error('Event Payload data is invalid - Area ID "'.concat(m, '" is invalid.')), !1) : !(!C.Util.isString(i) || C.Util.stringIsEmpty(i)) || (this._logger.error('Event Payload data is invalid - Trigger Name "'.concat(i, '" is invalid.')), !1);
          }, l.prototype._getRelevantStateConfig = function(a, m) {
            var i = this._collectConfigurationsForTrigger(a, m);
            if (i) {
              var o = this._combineRelatedStateConfig(i);
              if (o)
                return this._increaseTriggeredCount(o), this._filterQualifiedConfig(o);
            }
          }, l.prototype._collectConfigurationsForTrigger = function(a, m) {
            var i = this._centralConfig.pushConfig;
            if (i) {
              var o = i.findAppPushConfigById(a, m);
              if (o)
                return o;
            }
          }, l.prototype._combineRelatedStateConfig = function(a) {
            var m = {};
            m.combinedKey = a.combinedKey, m.config = a;
            var i = this._findStateById(a.areaId, a.triggerName);
            if (!i) {
              var o = C.Util.readUserState(this._storage);
              o && (i = o.createAndAddAppPushState(a.areaId, a.triggerName, a.triggerType), this._saveUserState(o));
            }
            if (i)
              return m.state = i, m;
          }, l.prototype._findStateById = function(a, m) {
            var i = C.Util.readUserState(this._storage);
            if (i)
              return i.getAppPushState(a, m);
          }, l.prototype._increaseTriggeredCount = function(a) {
            if (a.config) {
              var m = C.Util.readUserState(this._storage);
              if (m) {
                var i = m.getAppPushState(a.config.areaId, a.config.triggerName);
                i && (i.increaseTriggeredCount(), this._saveUserState(m));
              }
            }
          }, l.prototype._saveUserState = function(a) {
            a && this._storage.saveUserState(a);
          }, l.prototype._filterQualifiedConfig = function(a) {
            if (a) {
              var m = C.Util.readUserState(this._storage);
              if (m && a.config.isQualifiedForPush(a.state, m))
                return a;
            }
          }, l;
        }();
        h.ValidationHandler = c;
      }, 4673: function(v, h, p) {
        var f = this && this.__createBinding || (Object.create ? function(o, s, u, T) {
          T === void 0 && (T = u);
          var S = Object.getOwnPropertyDescriptor(s, u);
          S && !("get" in S ? !s.__esModule : S.writable || S.configurable) || (S = { enumerable: !0, get: function() {
            return s[u];
          } }), Object.defineProperty(o, T, S);
        } : function(o, s, u, T) {
          T === void 0 && (T = u), o[T] = s[u];
        }), d = this && this.__setModuleDefault || (Object.create ? function(o, s) {
          Object.defineProperty(o, "default", { enumerable: !0, value: s });
        } : function(o, s) {
          o.default = s;
        }), g = this && this.__importStar || function(o) {
          if (o && o.__esModule)
            return o;
          var s = {};
          if (o != null)
            for (var u in o)
              u !== "default" && Object.prototype.hasOwnProperty.call(o, u) && f(s, o, u);
          return d(s, o), s;
        };
        Object.defineProperty(h, "__esModule", { value: !0 }), h.ThemeValueFetcher = void 0;
        var C = g(p(759)), c = p(7765), l = p(9160), a = p(5937), m = p(434), i = function() {
          function o(s, u) {
            this._logger = new a.Logger(c.Constants.FILE_THEME_VALUE_FETCHER), this._themingConfig = s, this._contextDataController = u, this._loadThemeKeyMap();
          }
          return o.prototype.updateCurrentTheme = function(s) {
            if (this._themeKeyMap) {
              if (s === l.ThemeId.none)
                this._contextDataController.resetThemingContextData();
              else if (this._themingConfig.writeToGlobals) {
                var u = this._themeKeyMap[s];
                this._contextDataController.setThemingDataContext(u);
              }
            } else
              this._logger.error(m.LoggerTexts.THEME_VALUE_FETCHER.LOAD_KEY_MAP_ERROR);
          }, o.prototype._loadThemeKeyMap = function() {
            C && (this._themeKeyMap = C);
          }, o;
        }();
        h.ThemeValueFetcher = i;
      }, 759: function(v) {
        v.exports = JSON.parse('{"sap_horizon":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#f5f6f7"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#1d2d3e"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#1d2d3e"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#0064d9"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#0064d9"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#556b82"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#1d2d3e"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#eff1f2"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#556b81"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#556b82"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#131e29"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".5rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#1d2d3e"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#a8b2bd"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"solid"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#d9d9d9"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".75rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#1d2d3e"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#0070f2"}],"sap_horizon_dark":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#12171c"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#2e3b47"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#2e3b47"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#1d232a"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#213131"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#4db1ff"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#4db1ff"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#0070f2"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#0064d9"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#0064d9"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#213131"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#4db1ff"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#8396A8"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#242e38"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#a9b4be"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#8396A8"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".5rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#1d232a"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#768ea5"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#1d232a"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"solid"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#323c48"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".75rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#4db1ff"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#eaecee"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#4db1ff"}],"sap_horizon_hcb":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#000"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#795100"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#795100"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#795100"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#795100"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#999"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#0f5c93"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#fff"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#0f5c93"}],"sap_horizon_hcw":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#e97624"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#e97624"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#e97624"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#e97624"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#000"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#585858"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#5c93ff"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#000"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#5c93ff"}],"sap_fiori_3":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#f7f7f7"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#32363a"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#ebf5fe"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#0a6ed1"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#0a6ed1"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#085caf"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#085caf"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#6a6d70"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#32363a"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#89919a"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#74777a"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#32363a"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#32363a"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"transparent"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#d9d9d9"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#d9d9d9"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#0854a0"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#ebf5fe"}],"sap_fiori_3_dark":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#1c2228"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#29313a"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#062e4f"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#29313a"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#1b8dec"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#1b8dec"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#2e96ee"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#2e96ee"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#d3d7d9"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#29313a"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#8696a9"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#b8bec1"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"transparent"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#495767"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#29313a"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#3e4a58"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#062e4f"}],"sap_fiori_3_hcb":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#000"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#999"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#0f5d94"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#fff"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#0f5d94"}],"sap_fiori_3_hcw":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#000"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#585858"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#8fb5ff"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#000"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#8fb5ff"}],"sap_belize":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#3f5161"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#f7f7f7"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#435667"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#346187"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#cae4fb"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#ababab"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#a0b2c1"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#eaeaea"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#4f657a"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#427cac"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#2f3c48"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#427cac"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#5496cd"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#427cac"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#427cac"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#666"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#ddd"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#495e70"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#bfbfbf"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#7891a7"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#757575"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#c3d7e8"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".1875rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"transparent"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#ccc"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#69859d"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#3f5161"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#ebebeb"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#4f667a"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#427cac"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#346187"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#cae4fb"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#346187"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#62b0f2"}],"sap_belize_plus":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#3f5161"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#f7f7f7"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#435667"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#346187"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#cae4fb"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#ababab"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#a0b2c1"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#eaeaea"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#4f657a"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#427cac"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#2f3c48"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#427cac"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#5496cd"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#408ac7"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#427cac"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#427cac"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#666"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#ddd"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#495e70"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#bfbfbf"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#7891a7"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#757575"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#c3d7e8"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".1875rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#333"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fafafa"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"transparent"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#ccc"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#69859d"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#3f5161"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#ebebeb"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#4f667a"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#427cac"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#91c8f6"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#346187"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#cae4fb"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#346187"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#62b0f2"}],"sap_belize_hcb":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#000"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#7a5100"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#999"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#0f5d94"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#fff"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#0f5d94"}],"sap_belize_hcw":[{"embeddedDataKey":"sapUiBackgroundColor","cssKey":"--sapBackgroundColor","cssValue":"#fff"},{"embeddedDataKey":"sapUiQuestionTextColor","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBackgroundColor","cssKey":"--sapButton_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiStandardButtonTextColor","cssKey":"--sapButton_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonBorderColor","cssKey":"--sapButton_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonHoverBackgroundColor","cssKey":"--sapButton_Hover_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiStandardButtonActiveBackgroundColor","cssKey":"--sapButton_Active_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiStandardButtonActiveTextColor","cssKey":"--sapButton_Active_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiStandardButtonActiveBorderColor","cssKey":"--sapButton_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiEmphasizedButtonBorderColor","cssKey":"--sapButton_Emphasized_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedButtonTextColor","cssKey":"--sapButton_Emphasized_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Hover_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonBorderColor","cssKey":"--sapButton_Emphasized_Hover_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedHoverButtonTextColor","cssKey":"--sapButton_Emphasized_Hover_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBackgroundColor","cssKey":"--sapButton_Emphasized_Active_Background","cssValue":"#ec8b46"},{"embeddedDataKey":"sapUiEmphasizedActiveButtonBorderColor","cssKey":"--sapButton_Emphasized_Active_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiContentLabelColor","cssKey":"--sapContent_LabelColor","cssValue":"#000"},{"embeddedDataKey":"sapUiBaseText","cssKey":"--sapTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldBackground","cssKey":"--sapField_Background","cssValue":"#fff"},{"embeddedDataKey":"sapUiFieldBorderColor","cssKey":"--sapField_BorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiFieldPlaceholderTextColor","cssKey":"--sapField_PlaceholderTextColor","cssValue":"#585858"},{"embeddedDataKey":"sapUiFieldTextColor","cssKey":"--sapField_TextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiButtonBorderCornerRadius","cssKey":"--sapButton_BorderCornerRadius","cssValue":".375rem"},{"embeddedDataKey":"sapUiGroupTitleTextColor","cssKey":"--sapGroup_TitleTextColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupTitleBackground","cssKey":"--sapGroup_TitleBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiGroupTitleBorderColor","cssKey":"--sapGroup_TitleBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiGroupContentBackground","cssKey":"--sapGroup_ContentBackground","cssValue":"#fff"},{"embeddedDataKey":"sapUiButtonBorderWidth","cssKey":"--sapButton_BorderWidth","cssValue":".0625rem"},{"embeddedDataKey":"sapUiContentFocusStyle","cssKey":"--sapContent_FocusStyle","cssValue":"dotted"},{"embeddedDataKey":"sapUiContentBorderColor","cssKey":"--sapGroup_ContentBorderColor","cssValue":"#000"},{"embeddedDataKey":"sapUiElementBorderCornerRadius","cssKey":"--sapElement_BorderCornerRadius","cssValue":".25rem"},{"embeddedDataKey":"sapSelectedColor","cssKey":"--sapSelectedColor","cssValue":"#8fb5ff"},{"embeddedDataKey":"sapContent_IconColor","cssKey":"--sapContent_IconColor","cssValue":"#000"},{"embeddedDataKey":"sapButton_Selected_Background","cssKey":"--sapButton_Track_Selected_Background","cssValue":"#8fb5ff"}]}');
      } }, n = {};
      function _(v) {
        var h = n[v];
        if (h !== void 0)
          return h.exports;
        var p = n[v] = { exports: {} };
        return r[v].call(p.exports, p, p.exports, _), p.exports;
      }
      _.amdO = {};
      var I = {};
      return function() {
        var v = I;
        Object.defineProperty(v, "__esModule", { value: !0 }), v.Environment = v.ThemeId = v.PushType = v.PxApi = void 0;
        var h = _(7777);
        Object.defineProperty(v, "PxApi", { enumerable: !0, get: function() {
          return h.PxApi;
        } });
        var p = _(9160);
        Object.defineProperty(v, "PushType", { enumerable: !0, get: function() {
          return p.PushType;
        } }), Object.defineProperty(v, "ThemeId", { enumerable: !0, get: function() {
          return p.ThemeId;
        } }), Object.defineProperty(v, "Environment", { enumerable: !0, get: function() {
          return p.Environment;
        } });
      }(), I;
    }();
  });
})(Ko);
/**
 * @license
 * Copyright 2020 Google LLC
 * SPDX-License-Identifier: BSD-3-Clause
 */
const Mo = Symbol.for(""), ci = (t) => {
  if ((t == null ? void 0 : t.r) === Mo)
    return t == null ? void 0 : t._$litStatic$;
}, di = (t) => ({ _$litStatic$: t, r: Mo }), kr = /* @__PURE__ */ new Map(), ko = (t) => (e, ...r) => {
  const n = r.length;
  let _, I;
  const v = [], h = [];
  let p, f = 0, d = !1;
  for (; f < n; ) {
    for (p = e[f]; f < n && (I = r[f], (_ = ci(I)) !== void 0); )
      p += _ + e[++f], d = !0;
    h.push(I), v.push(p), f++;
  }
  if (f === n && v.push(e[n]), d) {
    const g = v.join("$$lit$$");
    (e = kr.get(g)) === void 0 && (v.raw = v, kr.set(g, e = v)), r = h;
  }
  return t(e, ...r);
}, pi = ko(ut), _i = ko(Wn);
let Ho, Hr = {
  include: [/^ui5-/],
  exclude: []
};
const Vt = /* @__PURE__ */ new Map(), hi = (t) => {
  if (!t.match(/^[a-zA-Z0-9_-]+$/))
    throw new Error("Only alphanumeric characters and dashes allowed for the scoping suffix");
  Ho = t;
}, fi = () => Ho, Ci = (t) => {
  if (!Vt.has(t)) {
    const e = Hr.include.some((r) => t.match(r)) && !Hr.exclude.some((r) => t.match(r));
    Vt.set(t, e);
  }
  return Vt.get(t);
}, _l = (t) => {
  if (Ci(t))
    return fi();
}, $o = /* @__PURE__ */ new Map(), gi = (t, e) => {
  $o.set(t, e);
}, ur = (t) => $o.get(t);
class lt {
}
lt.html = pi;
lt.svg = _i;
lt.unsafeStatic = di;
gi("LitStatic", lt);
class ct {
  constructor() {
    this._eventRegistry = /* @__PURE__ */ new Map();
  }
  attachEvent(e, r) {
    const n = this._eventRegistry, _ = n.get(e);
    if (!Array.isArray(_)) {
      n.set(e, [r]);
      return;
    }
    _.includes(r) || _.push(r);
  }
  detachEvent(e, r) {
    const n = this._eventRegistry, _ = n.get(e);
    if (!_)
      return;
    const I = _.indexOf(r);
    I !== -1 && _.splice(I, 1), _.length === 0 && n.delete(e);
  }
  fireEvent(e, r) {
    const _ = this._eventRegistry.get(e);
    return _ ? _.map((I) => I.call(this, r)) : [];
  }
  fireEventAsync(e, r) {
    return Promise.all(this.fireEvent(e, r));
  }
  isHandlerAttached(e, r) {
    const _ = this._eventRegistry.get(e);
    return _ ? _.includes(r) : !1;
  }
  hasListeners(e) {
    return !!this._eventRegistry.get(e);
  }
}
const mi = new ct(), yi = "languageChange", Fo = (t) => {
  mi.attachEvent(yi, t);
}, Me = { themes: { default: "sap_fiori_3", all: ["sap_fiori_3", "sap_fiori_3_dark", "sap_belize", "sap_belize_hcb", "sap_belize_hcw", "sap_fiori_3_hcb", "sap_fiori_3_hcw", "sap_horizon", "sap_horizon_dark", "sap_horizon_hcb", "sap_horizon_hcw", "sap_horizon_exp"] }, languages: { default: "en", all: ["ar", "bg", "ca", "cs", "cy", "da", "de", "el", "en", "en_GB", "en_US_sappsd", "en_US_saprigi", "en_US_saptrc", "es", "es_MX", "et", "fi", "fr", "fr_CA", "hi", "hr", "hu", "in", "it", "iw", "ja", "kk", "ko", "lt", "lv", "ms", "nl", "no", "pl", "pt_PT", "pt", "ro", "ru", "sh", "sk", "sl", "sv", "th", "tr", "uk", "vi", "zh_CN", "zh_TW"] }, locales: { default: "en", all: ["ar", "ar_EG", "ar_SA", "bg", "ca", "cs", "da", "de", "de_AT", "de_CH", "el", "el_CY", "en", "en_AU", "en_GB", "en_HK", "en_IE", "en_IN", "en_NZ", "en_PG", "en_SG", "en_ZA", "es", "es_AR", "es_BO", "es_CL", "es_CO", "es_MX", "es_PE", "es_UY", "es_VE", "et", "fa", "fi", "fr", "fr_BE", "fr_CA", "fr_CH", "fr_LU", "he", "hi", "hr", "hu", "id", "it", "it_CH", "ja", "kk", "ko", "lt", "lv", "ms", "nb", "nl", "nl_BE", "pl", "pt", "pt_PT", "ro", "ru", "ru_UA", "sk", "sl", "sr", "sr_Latn", "sv", "th", "tr", "uk", "vi", "zh_CN", "zh_HK", "zh_SG", "zh_TW"] } }, tt = Me.themes.default, Ti = Me.themes.all, dt = Me.languages.default, oe = Me.locales.default, $r = Me.locales.all, vi = () => {
  const t = navigator.languages, e = () => navigator.language;
  return t && t[0] || e() || dt;
};
var zo = {}, Go = zo.hasOwnProperty, bi = zo.toString, jo = Go.toString, Ii = jo.call(Object), Fr = function(t) {
  var e, r;
  return !t || bi.call(t) !== "[object Object]" ? !1 : (e = Object.getPrototypeOf(t), e ? (r = Go.call(e, "constructor") && e.constructor, typeof r == "function" && jo.call(r) === Ii) : !0);
}, Ei = /* @__PURE__ */ Object.create(null), qo = function(t, e, r, n) {
  var _, I, v, h, p, f, d = arguments[2] || {}, g = 3, C = arguments.length, c = arguments[0] || !1, l = arguments[1] ? void 0 : Ei;
  for (typeof d != "object" && typeof d != "function" && (d = {}); g < C; g++)
    if ((p = arguments[g]) != null)
      for (h in p)
        _ = d[h], v = p[h], !(h === "__proto__" || d === v) && (c && v && (Fr(v) || (I = Array.isArray(v))) ? (I ? (I = !1, f = _ && Array.isArray(_) ? _ : []) : f = _ && Fr(_) ? _ : {}, d[h] = qo(c, arguments[1], f, v)) : v !== l && (d[h] = v));
  return d;
};
const Zo = function(t, e) {
  return qo(!0, !1, ...arguments);
}, Ai = (t) => {
  const e = document.querySelector(`META[name="${t}"]`);
  return e && e.getAttribute("content");
}, Si = (t) => {
  const e = Ai("sap-allowedThemeOrigins");
  return e && e.split(",").some((r) => r === "*" || t === r.trim());
}, Pi = (t, e) => {
  const r = new URL(t).pathname;
  return new URL(r, e).toString();
}, wi = (t) => {
  let e;
  try {
    if (t.startsWith(".") || t.startsWith("/"))
      e = new URL(t, window.location.href).toString();
    else {
      const r = new URL(t), n = r.origin;
      n && Si(n) ? e = r.toString() : e = Pi(r.toString(), window.location.href);
    }
    return e.endsWith("/") || (e = `${e}/`), `${e}UI5/`;
  } catch (r) {
  }
};
var Jt;
(function(t) {
  t.Full = "full", t.Basic = "basic", t.Minimal = "minimal", t.None = "none";
})(Jt || (Jt = {}));
const Di = Jt;
let zr = !1, Q = {
  animationMode: Di.Full,
  theme: tt,
  themeRoot: void 0,
  rtl: void 0,
  language: void 0,
  timezone: void 0,
  calendarType: void 0,
  noConflict: !1,
  formatSettings: {},
  fetchDefaultLanguage: !1
};
const Bi = () => (Se(), Q.theme), Ui = () => (Se(), Q.themeRoot), hl = () => (Se(), Q.rtl), Li = () => (Se(), Q.language), Ni = () => (Se(), Q.fetchDefaultLanguage), fl = () => (Se(), Q.noConflict), rt = /* @__PURE__ */ new Map();
rt.set("true", !0);
rt.set("false", !1);
const Oi = () => {
  const t = document.querySelector("[data-ui5-config]") || document.querySelector("[data-id='sap-ui-config']");
  let e;
  if (t) {
    try {
      e = JSON.parse(t.innerHTML);
    } catch (r) {
      console.warn("Incorrect data-sap-ui-config format. Please use JSON");
    }
    e && (Q = Zo(Q, e));
  }
}, Vi = () => {
  const t = new URLSearchParams(window.location.search);
  t.forEach((e, r) => {
    const n = r.split("sap-").length;
    n === 0 || n === r.split("sap-ui-").length || Gr(r, e, "sap");
  }), t.forEach((e, r) => {
    !r.startsWith("sap-ui") || Gr(r, e, "sap-ui");
  });
}, Ri = (t) => {
  const e = t.split("@")[1];
  return wi(e);
}, xi = (t, e) => t === "theme" && e.includes("@") ? e.split("@")[0] : e, Gr = (t, e, r) => {
  const n = e.toLowerCase(), _ = t.split(`${r}-`)[1];
  rt.has(e) && (e = rt.get(n)), _ === "theme" ? (Q.theme = xi(_, e), e && e.includes("@") && (Q.themeRoot = Ri(e))) : Q[_] = e;
}, Ki = () => {
  const t = ur("OpenUI5Support");
  if (!t || !t.isLoaded())
    return;
  const e = t.getConfigurationSettingsObject();
  Q = Zo(Q, e);
}, Se = () => {
  typeof document == "undefined" || zr || (Oi(), Vi(), Ki(), zr = !0);
}, jr = 10;
class Mi {
  constructor() {
    this.list = [], this.lookup = /* @__PURE__ */ new Set();
  }
  add(e) {
    this.lookup.has(e) || (this.list.push(e), this.lookup.add(e));
  }
  remove(e) {
    !this.lookup.has(e) || (this.list = this.list.filter((r) => r !== e), this.lookup.delete(e));
  }
  shift() {
    const e = this.list.shift();
    if (e)
      return this.lookup.delete(e), e;
  }
  isEmpty() {
    return this.list.length === 0;
  }
  isAdded(e) {
    return this.lookup.has(e);
  }
  process(e) {
    let r;
    const n = /* @__PURE__ */ new Map();
    for (r = this.shift(); r; ) {
      const _ = n.get(r) || 0;
      if (_ > jr)
        throw new Error(`Web component processed too many times this task, max allowed is: ${jr}`);
      e(r), n.set(r, _ + 1), r = this.shift();
    }
  }
}
const ki = (t, e = document.body, r) => {
  let n = document.querySelector(t);
  return n || (n = r ? r() : document.createElement(t), e.insertBefore(n, e.firstChild));
}, Hi = () => {
  const t = document.createElement("meta");
  return t.setAttribute("name", "ui5-shared-resources"), t.setAttribute("content", ""), t;
}, $i = () => typeof document == "undefined" ? null : ki('meta[name="ui5-shared-resources"]', document.head, Hi), pt = (t, e) => {
  const r = t.split(".");
  let n = $i();
  if (!n)
    return e;
  for (let _ = 0; _ < r.length; _++) {
    const I = r[_], v = _ === r.length - 1;
    Object.prototype.hasOwnProperty.call(n, I) || (n[I] = v ? e : {}), n = n[I];
  }
  return n;
}, Fi = {
  version: "1.13.3",
  major: 1,
  minor: 13,
  patch: 3,
  suffix: "",
  isNext: !1,
  buildTime: 1684402228
};
let Ze, zi = "";
const Rt = /* @__PURE__ */ new Map(), Oe = pt("Runtimes", []), Cl = () => {
  if (Ze === void 0) {
    Ze = Oe.length;
    const t = Fi;
    Oe.push(Pt(St({}, t), {
      alias: zi,
      description: `Runtime ${Ze} - ver ${t.version}`
    }));
  }
}, Wo = () => Ze, Gi = (t, e) => {
  const r = `${t},${e}`;
  if (Rt.has(r))
    return Rt.get(r);
  const n = Oe[t], _ = Oe[e];
  if (!n || !_)
    throw new Error("Invalid runtime index supplied");
  if (n.isNext || _.isNext)
    return n.buildTime - _.buildTime;
  const I = n.major - _.major;
  if (I)
    return I;
  const v = n.minor - _.minor;
  if (v)
    return v;
  const h = n.patch - _.patch;
  if (h)
    return h;
  const f = new Intl.Collator(void 0, { numeric: !0, sensitivity: "base" }).compare(n.suffix, _.suffix);
  return Rt.set(r, f), f;
}, ji = () => Oe, Yo = pt("Tags", /* @__PURE__ */ new Map()), lr = /* @__PURE__ */ new Set();
let ue = /* @__PURE__ */ new Map(), xt;
const Qo = -1, gl = (t) => {
  lr.add(t), Yo.set(t, Wo());
}, ml = (t) => lr.has(t), qi = () => [...lr.values()], yl = (t) => {
  let e = Yo.get(t);
  e === void 0 && (e = Qo), ue.has(e) || ue.set(e, /* @__PURE__ */ new Set()), ue.get(e).add(t), xt || (xt = setTimeout(() => {
    Zi(), ue = /* @__PURE__ */ new Map(), xt = void 0;
  }, 1e3));
}, Zi = () => {
  const t = ji(), e = Wo(), r = t[e];
  let n = "Multiple UI5 Web Components instances detected.";
  t.length > 1 && (n = `${n}
Loading order (versions before 1.1.0 not listed): ${t.map((_) => `
${_.description}`).join("")}`), [...ue.keys()].forEach((_) => {
    let I, v;
    _ === Qo ? (I = 1, v = {
      description: "Older unknown runtime"
    }) : (I = Gi(e, _), v = t[_]);
    let h;
    I > 0 ? h = "an older" : I < 0 ? h = "a newer" : h = "the same", n = `${n}

"${r.description}" failed to define ${ue.get(_).size} tag(s) as they were defined by a runtime of ${h} version "${v.description}": ${[...ue.get(_)].sort().join(", ")}.`, I > 0 ? n = `${n}
WARNING! If your code uses features of the above web components, unavailable in ${v.description}, it might not work as expected!` : n = `${n}
Since the above web components were defined by the same or newer version runtime, they should be compatible with your code.`;
  }), n = `${n}

To prevent other runtimes from defining tags that you use, consider using scoping or have third-party libraries use scoping: https://github.com/SAP/ui5-webcomponents/blob/main/docs/2-advanced/03-scoping.md.`, console.warn(n);
}, Jo = /* @__PURE__ */ new Set(), Tl = (t) => {
  Jo.add(t);
}, Wi = (t) => Jo.has(t), cr = /* @__PURE__ */ new Set(), Yi = new ct(), Ee = new Mi();
let _e, We, Kt, Ge;
const Qi = (t) => R(void 0, null, function* () {
  Ee.add(t), yield Xi();
}), Ji = (t) => {
  Yi.fireEvent("beforeComponentRender", t), cr.add(t), t._render();
}, vl = (t) => {
  Ee.remove(t), cr.delete(t);
}, Xi = () => R(void 0, null, function* () {
  Ge || (Ge = new Promise((t) => {
    window.requestAnimationFrame(() => {
      Ee.process(Ji), Ge = null, t(), Kt || (Kt = setTimeout(() => {
        Kt = void 0, Ee.isEmpty() && oa();
      }, 200));
    });
  })), yield Ge;
}), ea = () => _e || (_e = new Promise((t) => {
  We = t, window.requestAnimationFrame(() => {
    Ee.isEmpty() && (_e = void 0, t());
  });
}), _e), ta = () => {
  const t = qi().map((e) => customElements.whenDefined(e));
  return Promise.all(t);
}, ra = () => R(void 0, null, function* () {
  yield ta(), yield ea();
}), oa = () => {
  !Ee.isEmpty() || We && (We(), We = void 0, _e = void 0);
}, na = (t) => R(void 0, null, function* () {
  cr.forEach((e) => {
    const r = e.constructor, n = r.getMetadata().getTag(), _ = Wi(r), I = r.getMetadata().isLanguageAware(), v = r.getMetadata().isThemeAware();
    (!t || t.tag === n || t.rtlAware && _ || t.languageAware && I || t.themeAware && v) && Qi(e);
  }), yield ra();
});
let Mt, Xt;
const ia = () => (Mt === void 0 && (Mt = Li()), Mt), Xo = (t) => {
  Xt = t;
}, aa = () => (Xt === void 0 && Xo(Ni()), Xt), sa = /^((?:[A-Z]{2,3}(?:-[A-Z]{3}){0,3})|[A-Z]{4}|[A-Z]{5,8})(?:-([A-Z]{4}))?(?:-([A-Z]{2}|[0-9]{3}))?((?:-[0-9A-Z]{5,8}|-[0-9][0-9A-Z]{3})*)((?:-[0-9A-WYZ](?:-[0-9A-Z]{2,8})+)*)(?:-(X(?:-[0-9A-Z]{1,8})+))?$/i;
class en {
  constructor(e) {
    const r = sa.exec(e.replace(/_/g, "-"));
    if (r === null)
      throw new Error(`The given language ${e} does not adhere to BCP-47.`);
    this.sLocaleId = e, this.sLanguage = r[1] || dt, this.sScript = r[2] || "", this.sRegion = r[3] || "", this.sVariant = r[4] && r[4].slice(1) || null, this.sExtension = r[5] && r[5].slice(1) || null, this.sPrivateUse = r[6] || null, this.sLanguage && (this.sLanguage = this.sLanguage.toLowerCase()), this.sScript && (this.sScript = this.sScript.toLowerCase().replace(/^[a-z]/, (n) => n.toUpperCase())), this.sRegion && (this.sRegion = this.sRegion.toUpperCase());
  }
  getLanguage() {
    return this.sLanguage;
  }
  getScript() {
    return this.sScript;
  }
  getRegion() {
    return this.sRegion;
  }
  getVariant() {
    return this.sVariant;
  }
  getVariantSubtags() {
    return this.sVariant ? this.sVariant.split("-") : [];
  }
  getExtension() {
    return this.sExtension;
  }
  getExtensionSubtags() {
    return this.sExtension ? this.sExtension.slice(2).split("-") : [];
  }
  getPrivateUse() {
    return this.sPrivateUse;
  }
  getPrivateUseSubtags() {
    return this.sPrivateUse ? this.sPrivateUse.slice(2).split("-") : [];
  }
  hasPrivateUseSubtag(e) {
    return this.getPrivateUseSubtags().indexOf(e) >= 0;
  }
  toString() {
    const e = [this.sLanguage];
    return this.sScript && e.push(this.sScript), this.sRegion && e.push(this.sRegion), this.sVariant && e.push(this.sVariant), this.sExtension && e.push(this.sExtension), this.sPrivateUse && e.push(this.sPrivateUse), e.join("-");
  }
}
const kt = /* @__PURE__ */ new Map(), tn = (t) => (kt.has(t) || kt.set(t, new en(t)), kt.get(t)), qr = (t) => {
  try {
    if (t && typeof t == "string")
      return tn(t);
  } catch (e) {
  }
  return new en(oe);
}, er = (t) => {
  if (t)
    return qr(t);
  const e = ia();
  return e ? tn(e) : qr(vi());
}, ua = /* @__PURE__ */ new Map(), ot = /* @__PURE__ */ new Map(), Ht = /* @__PURE__ */ new Map(), Zr = /* @__PURE__ */ new Set();
let Wr = !1;
const la = {
  iw: "he",
  ji: "yi",
  in: "id"
}, Yr = (t) => {
  Wr || (console.warn(`[LocaleData] Supported locale "${t}" not configured, import the "Assets.js" module from the webcomponents package you are using.`), Wr = !0);
}, ca = (t, e, r) => {
  t = t && la[t] || t, t === "no" && (t = "nb"), t === "zh" && !e && (r === "Hans" ? e = "CN" : r === "Hant" && (e = "TW")), (t === "sh" || t === "sr" && r === "Latn") && (t = "sr", e = "Latn");
  let n = `${t}_${e}`;
  return $r.includes(n) || (n = t, $r.includes(n)) ? ot.has(n) ? n : (Yr(n), oe) : oe;
}, Qr = (t, e) => {
  ua.set(t, e);
}, da = (t) => {
  if (!Ht.get(t)) {
    const e = ot.get(t);
    if (!e)
      throw new Error(`CLDR data for locale ${t} is not loaded!`);
    Ht.set(t, e(t));
  }
  return Ht.get(t);
}, pa = (t, e, r) => R(void 0, null, function* () {
  const n = ca(t, e, r), _ = ur("OpenUI5Support");
  if (_) {
    const I = _.getLocaleDataObject();
    if (I) {
      Qr(n, I);
      return;
    }
  }
  try {
    const I = yield da(n);
    Qr(n, I);
  } catch (I) {
    const v = I;
    Zr.has(v.message) || (Zr.add(v.message), console.error(v.message));
  }
}), rn = (t, e) => {
  ot.set(t, e);
};
rn("en", () => R(void 0, null, function* () {
  return (yield fetch("https://sdk.openui5.org/1.103.0/resources/sap/ui/core/cldr/en.json")).json();
}));
Fo(() => {
  const t = er();
  return pa(t.getLanguage(), t.getRegion(), t.getScript());
});
const _a = ["ar", "ar_EG", "ar_SA", "bg", "ca", "cs", "da", "de", "de_AT", "de_CH", "el", "el_CY", "en", "en_AU", "en_GB", "en_HK", "en_IE", "en_IN", "en_NZ", "en_PG", "en_SG", "en_ZA", "es", "es_AR", "es_BO", "es_CL", "es_CO", "es_MX", "es_PE", "es_UY", "es_VE", "et", "fa", "fi", "fr", "fr_BE", "fr_CA", "fr_CH", "fr_LU", "he", "hi", "hr", "hu", "id", "it", "it_CH", "ja", "kk", "ko", "lt", "lv", "ms", "nb", "nl", "nl_BE", "pl", "pt", "pt_PT", "ro", "ru", "ru_UA", "sk", "sl", "sr", "sr_Latn", "sv", "th", "tr", "uk", "vi", "zh_CN", "zh_HK", "zh_SG", "zh_TW"], ha = (t) => R(void 0, null, function* () {
  switch (t) {
    case "ar":
      return (yield import("./ar.f347be7b.mjs")).default;
    case "ar_EG":
      return (yield import("./ar_EG.fc5d6513.mjs")).default;
    case "ar_SA":
      return (yield import("./ar_SA.2cff542a.mjs")).default;
    case "bg":
      return (yield import("./bg.0f4bfe7f.mjs")).default;
    case "ca":
      return (yield import("./ca.5cf799a3.mjs")).default;
    case "cs":
      return (yield import("./cs.4cf0b438.mjs")).default;
    case "da":
      return (yield import("./da.57e1b53e.mjs")).default;
    case "de":
      return (yield import("./de.5a2f473b.mjs")).default;
    case "de_AT":
      return (yield import("./de_AT.3512bd77.mjs")).default;
    case "de_CH":
      return (yield import("./de_CH.0a0014e0.mjs")).default;
    case "el":
      return (yield import("./el.b544da0e.mjs")).default;
    case "el_CY":
      return (yield import("./el_CY.8e52f4ba.mjs")).default;
    case "en":
      return (yield import("./en.67e9fbcd.mjs")).default;
    case "en_AU":
      return (yield import("./en_AU.8966b656.mjs")).default;
    case "en_GB":
      return (yield import("./en_GB.ee8afac4.mjs")).default;
    case "en_HK":
      return (yield import("./en_HK.edbccbb9.mjs")).default;
    case "en_IE":
      return (yield import("./en_IE.c9aea40e.mjs")).default;
    case "en_IN":
      return (yield import("./en_IN.14ec38ae.mjs")).default;
    case "en_NZ":
      return (yield import("./en_NZ.86d7ed76.mjs")).default;
    case "en_PG":
      return (yield import("./en_PG.c9daccf9.mjs")).default;
    case "en_SG":
      return (yield import("./en_SG.4d0215f7.mjs")).default;
    case "en_ZA":
      return (yield import("./en_ZA.04ddfc7b.mjs")).default;
    case "es":
      return (yield import("./es.0eee740f.mjs")).default;
    case "es_AR":
      return (yield import("./es_AR.5d434d79.mjs")).default;
    case "es_BO":
      return (yield import("./es_BO.92c4ef65.mjs")).default;
    case "es_CL":
      return (yield import("./es_CL.d151d919.mjs")).default;
    case "es_CO":
      return (yield import("./es_CO.af198627.mjs")).default;
    case "es_MX":
      return (yield import("./es_MX.5af15912.mjs")).default;
    case "es_PE":
      return (yield import("./es_PE.7772fb2b.mjs")).default;
    case "es_UY":
      return (yield import("./es_UY.f24d55b1.mjs")).default;
    case "es_VE":
      return (yield import("./es_VE.1a74eba0.mjs")).default;
    case "et":
      return (yield import("./et.aa59f91f.mjs")).default;
    case "fa":
      return (yield import("./fa.19387a0a.mjs")).default;
    case "fi":
      return (yield import("./fi.46909aab.mjs")).default;
    case "fr":
      return (yield import("./fr.c920021f.mjs")).default;
    case "fr_BE":
      return (yield import("./fr_BE.8c83fe17.mjs")).default;
    case "fr_CA":
      return (yield import("./fr_CA.3ae37b8a.mjs")).default;
    case "fr_CH":
      return (yield import("./fr_CH.b4ea6104.mjs")).default;
    case "fr_LU":
      return (yield import("./fr_LU.f39e0218.mjs")).default;
    case "he":
      return (yield import("./he.10debdb1.mjs")).default;
    case "hi":
      return (yield import("./hi.a134f7b9.mjs")).default;
    case "hr":
      return (yield import("./hr.36504ce6.mjs")).default;
    case "hu":
      return (yield import("./hu.1e9d3921.mjs")).default;
    case "id":
      return (yield import("./id.853a5ce3.mjs")).default;
    case "it":
      return (yield import("./it.7f0e7ea1.mjs")).default;
    case "it_CH":
      return (yield import("./it_CH.574311ae.mjs")).default;
    case "ja":
      return (yield import("./ja.e6ccf95f.mjs")).default;
    case "kk":
      return (yield import("./kk.3597571f.mjs")).default;
    case "ko":
      return (yield import("./ko.0020cd57.mjs")).default;
    case "lt":
      return (yield import("./lt.b975abb1.mjs")).default;
    case "lv":
      return (yield import("./lv.8a20a879.mjs")).default;
    case "ms":
      return (yield import("./ms.7e6e4c57.mjs")).default;
    case "nb":
      return (yield import("./nb.162789a5.mjs")).default;
    case "nl":
      return (yield import("./nl.e928f595.mjs")).default;
    case "nl_BE":
      return (yield import("./nl_BE.b597614b.mjs")).default;
    case "pl":
      return (yield import("./pl.c0a5b3fe.mjs")).default;
    case "pt":
      return (yield import("./pt.c63bb78d.mjs")).default;
    case "pt_PT":
      return (yield import("./pt_PT.0cbef583.mjs")).default;
    case "ro":
      return (yield import("./ro.d4b50284.mjs")).default;
    case "ru":
      return (yield import("./ru.b693b1fa.mjs")).default;
    case "ru_UA":
      return (yield import("./ru_UA.74e14f07.mjs")).default;
    case "sk":
      return (yield import("./sk.ff11232f.mjs")).default;
    case "sl":
      return (yield import("./sl.deda70b4.mjs")).default;
    case "sr":
      return (yield import("./sr.b4b62f3c.mjs")).default;
    case "sr_Latn":
      return (yield import("./sr_Latn.32ed8b6e.mjs")).default;
    case "sv":
      return (yield import("./sv.3b2e965e.mjs")).default;
    case "th":
      return (yield import("./th.7af350e1.mjs")).default;
    case "tr":
      return (yield import("./tr.c6bfd7c9.mjs")).default;
    case "uk":
      return (yield import("./uk.adc890e9.mjs")).default;
    case "vi":
      return (yield import("./vi.ec92d703.mjs")).default;
    case "zh_CN":
      return (yield import("./zh_CN.312d818d.mjs")).default;
    case "zh_HK":
      return (yield import("./zh_HK.c2c6b12d.mjs")).default;
    case "zh_SG":
      return (yield import("./zh_SG.e46caf82.mjs")).default;
    case "zh_TW":
      return (yield import("./zh_TW.92d0fab3.mjs")).default;
    default:
      throw "unknown locale";
  }
}), fa = (t) => R(void 0, null, function* () {
  const e = yield ha(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[LocaleData] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
});
_a.forEach((t) => rn(t, fa));
const on = new ct(), nn = "themeRegistered", bl = (t) => {
  on.attachEvent(nn, t);
}, Ca = (t) => on.fireEvent(nn, t), an = /* @__PURE__ */ new Map(), sn = /* @__PURE__ */ new Map(), un = /* @__PURE__ */ new Set(), nt = /* @__PURE__ */ new Set(), dr = (t, e, r) => {
  sn.set(`${t}/${e}`, r), un.add(t), nt.add(e), Ca(e);
}, ln = (t, e) => R(void 0, null, function* () {
  const r = an.get(`${t}_${e}`);
  if (r !== void 0)
    return r;
  if (!nt.has(e)) {
    const n = [...nt.values()].join(", ");
    return console.warn(`You have requested a non-registered theme ${e} - falling back to ${tt}. Registered themes are: ${n}`), Jr(t, tt);
  }
  return Jr(t, e);
}), Jr = (t, e) => R(void 0, null, function* () {
  const r = sn.get(`${t}/${e}`);
  if (!r) {
    console.error(`Theme [${e}] not registered for package [${t}]`);
    return;
  }
  let n;
  try {
    n = yield r(e);
  } catch (I) {
    console.error(t, I.message);
    return;
  }
  const _ = n._ || n;
  return an.set(`${t}_${e}`, _), _;
}), cn = () => un, ga = (t) => nt.has(t), ma = (t) => R(void 0, null, function* () {
  switch (t) {
    case "sap_belize":
      return (yield import("./parameters-bundle.css.a326add1.mjs")).default;
    case "sap_belize_hcb":
      return (yield import("./parameters-bundle.css.470f436e.mjs")).default;
    case "sap_belize_hcw":
      return (yield import("./parameters-bundle.css.99b46682.mjs")).default;
    case "sap_fiori_3":
      return (yield import("./parameters-bundle.css.23ddd23b.mjs")).default;
    case "sap_fiori_3_dark":
      return (yield import("./parameters-bundle.css.52b0d1a3.mjs")).default;
    case "sap_fiori_3_hcb":
      return (yield import("./parameters-bundle.css.41a8b709.mjs")).default;
    case "sap_fiori_3_hcw":
      return (yield import("./parameters-bundle.css.1ca8a62f.mjs")).default;
    case "sap_horizon":
      return (yield import("./parameters-bundle.css.7ed4f134.mjs")).default;
    case "sap_horizon_dark":
      return (yield import("./parameters-bundle.css.f162f8e0.mjs")).default;
    case "sap_horizon_exp":
      return (yield import("./parameters-bundle.css.fca20775.mjs")).default;
    case "sap_horizon_hcb":
      return (yield import("./parameters-bundle.css.ddc7aad1.mjs")).default;
    case "sap_horizon_hcw":
      return (yield import("./parameters-bundle.css.8b36735b.mjs")).default;
    default:
      throw "unknown theme";
  }
}), ya = (t) => R(void 0, null, function* () {
  const e = yield ma(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[themes] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
});
["sap_belize", "sap_belize_hcb", "sap_belize_hcw", "sap_fiori_3", "sap_fiori_3_dark", "sap_fiori_3_hcb", "sap_fiori_3_hcw", "sap_horizon", "sap_horizon_dark", "sap_horizon_exp", "sap_horizon_hcb", "sap_horizon_hcw"].forEach((t) => dr("@ui5/webcomponents-theming", t, ya));
const Ta = /^((?:[A-Z]{2,3}(?:-[A-Z]{3}){0,3})|[A-Z]{4}|[A-Z]{5,8})(?:-([A-Z]{4}))?(?:-([A-Z]{2}|[0-9]{3}))?((?:-[0-9A-Z]{5,8}|-[0-9][0-9A-Z]{3})*)((?:-[0-9A-WYZ](?:-[0-9A-Z]{2,8})+)*)(?:-(X(?:-[0-9A-Z]{1,8})+))?$/i, Xr = /(?:^|-)(saptrc|sappsd)(?:-|$)/i, va = {
  he: "iw",
  yi: "ji",
  nb: "no",
  sr: "sh"
}, ba = (t) => {
  let e;
  if (!t)
    return oe;
  if (typeof t == "string" && (e = Ta.exec(t.replace(/_/g, "-")))) {
    let r = e[1].toLowerCase(), n = e[3] ? e[3].toUpperCase() : void 0;
    const _ = e[2] ? e[2].toLowerCase() : void 0, I = e[4] ? e[4].slice(1) : void 0, v = e[6];
    return r = va[r] || r, v && (e = Xr.exec(v)) || I && (e = Xr.exec(I)) ? `en_US_${e[1].toLowerCase()}` : (r === "zh" && !n && (_ === "hans" ? n = "CN" : _ === "hant" && (n = "TW")), r + (n ? "_" + n + (I ? "_" + I.replace("-", "_") : "") : ""));
  }
  return oe;
}, Ia = (t) => {
  if (!t)
    return oe;
  if (t === "zh_HK")
    return "zh_TW";
  const e = t.lastIndexOf("_");
  return e >= 0 ? t.slice(0, e) : t !== oe ? oe : "";
}, eo = /* @__PURE__ */ new Set(), to = /* @__PURE__ */ new Set(), pr = /* @__PURE__ */ new Map(), $t = /* @__PURE__ */ new Map(), _r = /* @__PURE__ */ new Map(), _t = (t, e, r) => {
  const n = `${t}/${e}`;
  _r.set(n, r);
}, ro = (t, e) => {
  pr.set(t, e);
}, Ea = (t) => pr.get(t), dn = (t, e) => {
  const r = `${t}/${e}`;
  return _r.has(r);
}, Aa = (t, e) => {
  const r = `${t}/${e}`, n = _r.get(r);
  return n && !$t.get(r) && $t.set(r, n(e)), $t.get(r);
}, Sa = (t) => {
  eo.has(t) || (console.warn(`[${t}]: Message bundle assets are not configured. Falling back to English texts.`, ` Add \`import "${t}/dist/Assets.js"\` in your bundle and make sure your build tool supports dynamic imports and JSON imports. See section "Assets" in the documentation for more information.`), eo.add(t));
}, oo = (t, e) => e !== dt && !dn(t, e), pn = (t) => R(void 0, null, function* () {
  const e = er().getLanguage(), r = er().getRegion();
  let n = e + (r ? `-${r}` : "");
  if (oo(t, n))
    for (n = ba(n); oo(t, n); )
      n = Ia(n);
  const _ = aa();
  if (n === dt && !_) {
    ro(t, null);
    return;
  }
  if (!dn(t, n)) {
    Sa(t);
    return;
  }
  try {
    const I = yield Aa(t, n);
    ro(t, I);
  } catch (I) {
    const v = I;
    to.has(v.message) || (to.add(v.message), console.error(v.message));
  }
});
Fo((t) => {
  const e = [...pr.keys()];
  return Promise.all(e.map(pn));
});
const Pa = (t) => R(void 0, null, function* () {
  switch (t) {
    case "ar":
      return (yield import("./messagebundle_ar.7263db8b.mjs")).default;
    case "bg":
      return (yield import("./messagebundle_bg.cc7a4f47.mjs")).default;
    case "ca":
      return (yield import("./messagebundle_ca.537020dc.mjs")).default;
    case "cs":
      return (yield import("./messagebundle_cs.bff8332a.mjs")).default;
    case "cy":
      return (yield import("./messagebundle_cy.a0a0cee7.mjs")).default;
    case "da":
      return (yield import("./messagebundle_da.698fd178.mjs")).default;
    case "de":
      return (yield import("./messagebundle_de.8b3b0b6b.mjs")).default;
    case "el":
      return (yield import("./messagebundle_el.cc922fd4.mjs")).default;
    case "en":
      return (yield import("./messagebundle_en.c6963555.mjs")).default;
    case "en_GB":
      return (yield import("./messagebundle_en_GB.2addf20a.mjs")).default;
    case "en_US_sappsd":
      return (yield import("./messagebundle_en_US_sappsd.e0c3400b.mjs")).default;
    case "en_US_saprigi":
      return (yield import("./messagebundle_en_US_saprigi.6250c8bb.mjs")).default;
    case "en_US_saptrc":
      return (yield import("./messagebundle_en_US_saptrc.a62c5d28.mjs")).default;
    case "es":
      return (yield import("./messagebundle_es.ffc33c29.mjs")).default;
    case "es_MX":
      return (yield import("./messagebundle_es_MX.4591c308.mjs")).default;
    case "et":
      return (yield import("./messagebundle_et.c8701eca.mjs")).default;
    case "fi":
      return (yield import("./messagebundle_fi.a7137a31.mjs")).default;
    case "fr":
      return (yield import("./messagebundle_fr.f5c75c14.mjs")).default;
    case "fr_CA":
      return (yield import("./messagebundle_fr_CA.0d7a3305.mjs")).default;
    case "hi":
      return (yield import("./messagebundle_hi.f23624a0.mjs")).default;
    case "hr":
      return (yield import("./messagebundle_hr.fd3cc8b0.mjs")).default;
    case "hu":
      return (yield import("./messagebundle_hu.a4769890.mjs")).default;
    case "in":
      return (yield import("./messagebundle_in.f99cfb0d.mjs")).default;
    case "it":
      return (yield import("./messagebundle_it.92aa7ae1.mjs")).default;
    case "iw":
      return (yield import("./messagebundle_iw.c9881603.mjs")).default;
    case "ja":
      return (yield import("./messagebundle_ja.807a26a3.mjs")).default;
    case "kk":
      return (yield import("./messagebundle_kk.e591fb90.mjs")).default;
    case "ko":
      return (yield import("./messagebundle_ko.d8ca2bd7.mjs")).default;
    case "lt":
      return (yield import("./messagebundle_lt.b2def06f.mjs")).default;
    case "lv":
      return (yield import("./messagebundle_lv.a9c4c029.mjs")).default;
    case "ms":
      return (yield import("./messagebundle_ms.6b7db072.mjs")).default;
    case "nl":
      return (yield import("./messagebundle_nl.2cd2caa4.mjs")).default;
    case "no":
      return (yield import("./messagebundle_no.d22d8b12.mjs")).default;
    case "pl":
      return (yield import("./messagebundle_pl.329119e4.mjs")).default;
    case "pt":
      return (yield import("./messagebundle_pt.572cee52.mjs")).default;
    case "pt_PT":
      return (yield import("./messagebundle_pt_PT.a2fdb2f8.mjs")).default;
    case "ro":
      return (yield import("./messagebundle_ro.097cfefc.mjs")).default;
    case "ru":
      return (yield import("./messagebundle_ru.6f84257b.mjs")).default;
    case "sh":
      return (yield import("./messagebundle_sh.1120a8f0.mjs")).default;
    case "sk":
      return (yield import("./messagebundle_sk.900a24ac.mjs")).default;
    case "sl":
      return (yield import("./messagebundle_sl.639ebae5.mjs")).default;
    case "sv":
      return (yield import("./messagebundle_sv.9729e0e2.mjs")).default;
    case "th":
      return (yield import("./messagebundle_th.4b287d73.mjs")).default;
    case "tr":
      return (yield import("./messagebundle_tr.45a0dfce.mjs")).default;
    case "uk":
      return (yield import("./messagebundle_uk.2679703b.mjs")).default;
    case "vi":
      return (yield import("./messagebundle_vi.129b5e22.mjs")).default;
    case "zh_CN":
      return (yield import("./messagebundle_zh_CN.062e1cd5.mjs")).default;
    case "zh_TW":
      return (yield import("./messagebundle_zh_TW.08aa4870.mjs")).default;
    default:
      throw "unknown locale";
  }
}), wa = (t) => R(void 0, null, function* () {
  const e = yield Pa(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[i18n] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
}), Da = [
  "ar",
  "bg",
  "ca",
  "cs",
  "cy",
  "da",
  "de",
  "el",
  "en",
  "en_GB",
  "en_US_sappsd",
  "en_US_saprigi",
  "en_US_saptrc",
  "es",
  "es_MX",
  "et",
  "fi",
  "fr",
  "fr_CA",
  "hi",
  "hr",
  "hu",
  "in",
  "it",
  "iw",
  "ja",
  "kk",
  "ko",
  "lt",
  "lv",
  "ms",
  "nl",
  "no",
  "pl",
  "pt",
  "pt_PT",
  "ro",
  "ru",
  "sh",
  "sk",
  "sl",
  "sv",
  "th",
  "tr",
  "uk",
  "vi",
  "zh_CN",
  "zh_TW"
];
Da.forEach((t) => {
  _t("@ui5/webcomponents-icons", t, wa);
});
const Ba = (t) => R(void 0, null, function* () {
  switch (t) {
    case "sap_belize":
      return (yield import("./parameters-bundle.css.57d06e5e.mjs")).default;
    case "sap_belize_hcb":
      return (yield import("./parameters-bundle.css.6cc67ace.mjs")).default;
    case "sap_belize_hcw":
      return (yield import("./parameters-bundle.css.ba88b374.mjs")).default;
    case "sap_fiori_3":
      return (yield import("./parameters-bundle.css.47a1e6f7.mjs")).default;
    case "sap_fiori_3_dark":
      return (yield import("./parameters-bundle.css.7bbfe90a.mjs")).default;
    case "sap_fiori_3_hcb":
      return (yield import("./parameters-bundle.css.b7f2248b.mjs")).default;
    case "sap_fiori_3_hcw":
      return (yield import("./parameters-bundle.css.bb26c74c.mjs")).default;
    case "sap_horizon":
      return (yield import("./parameters-bundle.css.2c2432d5.mjs")).default;
    case "sap_horizon_dark":
      return (yield import("./parameters-bundle.css.58118a4b.mjs")).default;
    case "sap_horizon_exp":
      return (yield import("./parameters-bundle.css.1070e149.mjs")).default;
    case "sap_horizon_hcb":
      return (yield import("./parameters-bundle.css.d0ceade2.mjs")).default;
    case "sap_horizon_hcw":
      return (yield import("./parameters-bundle.css.338a145f.mjs")).default;
    default:
      throw "unknown theme";
  }
}), Ua = (t) => R(void 0, null, function* () {
  const e = yield Ba(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[themes] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
});
["sap_belize", "sap_belize_hcb", "sap_belize_hcw", "sap_fiori_3", "sap_fiori_3_dark", "sap_fiori_3_hcb", "sap_fiori_3_hcw", "sap_horizon", "sap_horizon_dark", "sap_horizon_exp", "sap_horizon_hcb", "sap_horizon_hcw"].forEach((t) => dr("@ui5/webcomponents", t, Ua));
const La = (t) => R(void 0, null, function* () {
  switch (t) {
    case "ar":
      return (yield import("./messagebundle_ar.ecafe08a.mjs")).default;
    case "bg":
      return (yield import("./messagebundle_bg.a17b9345.mjs")).default;
    case "ca":
      return (yield import("./messagebundle_ca.6522d42f.mjs")).default;
    case "cs":
      return (yield import("./messagebundle_cs.769a3f86.mjs")).default;
    case "cy":
      return (yield import("./messagebundle_cy.2a8b5566.mjs")).default;
    case "da":
      return (yield import("./messagebundle_da.a511c584.mjs")).default;
    case "de":
      return (yield import("./messagebundle_de.94537da2.mjs")).default;
    case "el":
      return (yield import("./messagebundle_el.b3420bff.mjs")).default;
    case "en":
      return (yield import("./messagebundle_en.ba647578.mjs")).default;
    case "en_GB":
      return (yield import("./messagebundle_en_GB.cb068fa7.mjs")).default;
    case "en_US_sappsd":
      return (yield import("./messagebundle_en_US_sappsd.934330b4.mjs")).default;
    case "en_US_saprigi":
      return (yield import("./messagebundle_en_US_saprigi.c639e439.mjs")).default;
    case "en_US_saptrc":
      return (yield import("./messagebundle_en_US_saptrc.40d6f935.mjs")).default;
    case "es":
      return (yield import("./messagebundle_es.1aff852a.mjs")).default;
    case "es_MX":
      return (yield import("./messagebundle_es_MX.f9c83015.mjs")).default;
    case "et":
      return (yield import("./messagebundle_et.58a4928a.mjs")).default;
    case "fi":
      return (yield import("./messagebundle_fi.de000491.mjs")).default;
    case "fr":
      return (yield import("./messagebundle_fr.b3349416.mjs")).default;
    case "fr_CA":
      return (yield import("./messagebundle_fr_CA.a3dcae3a.mjs")).default;
    case "hi":
      return (yield import("./messagebundle_hi.9c1d4241.mjs")).default;
    case "hr":
      return (yield import("./messagebundle_hr.46e63b6b.mjs")).default;
    case "hu":
      return (yield import("./messagebundle_hu.66e995fb.mjs")).default;
    case "in":
      return (yield import("./messagebundle_in.17944ecc.mjs")).default;
    case "it":
      return (yield import("./messagebundle_it.8a5cbeae.mjs")).default;
    case "iw":
      return (yield import("./messagebundle_iw.06186b77.mjs")).default;
    case "ja":
      return (yield import("./messagebundle_ja.29300850.mjs")).default;
    case "kk":
      return (yield import("./messagebundle_kk.c0c3b4d0.mjs")).default;
    case "ko":
      return (yield import("./messagebundle_ko.cf12f809.mjs")).default;
    case "lt":
      return (yield import("./messagebundle_lt.47646763.mjs")).default;
    case "lv":
      return (yield import("./messagebundle_lv.e0a205c6.mjs")).default;
    case "ms":
      return (yield import("./messagebundle_ms.b920eaae.mjs")).default;
    case "nl":
      return (yield import("./messagebundle_nl.1106c6c9.mjs")).default;
    case "no":
      return (yield import("./messagebundle_no.f6b467bc.mjs")).default;
    case "pl":
      return (yield import("./messagebundle_pl.ca56df89.mjs")).default;
    case "pt":
      return (yield import("./messagebundle_pt.c88097e0.mjs")).default;
    case "pt_PT":
      return (yield import("./messagebundle_pt_PT.fea206da.mjs")).default;
    case "ro":
      return (yield import("./messagebundle_ro.d0815bff.mjs")).default;
    case "ru":
      return (yield import("./messagebundle_ru.5136310b.mjs")).default;
    case "sh":
      return (yield import("./messagebundle_sh.89fdd3d4.mjs")).default;
    case "sk":
      return (yield import("./messagebundle_sk.ab182417.mjs")).default;
    case "sl":
      return (yield import("./messagebundle_sl.3d0a096a.mjs")).default;
    case "sv":
      return (yield import("./messagebundle_sv.3d80f822.mjs")).default;
    case "th":
      return (yield import("./messagebundle_th.a37acf64.mjs")).default;
    case "tr":
      return (yield import("./messagebundle_tr.a44f6836.mjs")).default;
    case "uk":
      return (yield import("./messagebundle_uk.ddc381d7.mjs")).default;
    case "vi":
      return (yield import("./messagebundle_vi.7734c1e2.mjs")).default;
    case "zh_CN":
      return (yield import("./messagebundle_zh_CN.542ddd0e.mjs")).default;
    case "zh_TW":
      return (yield import("./messagebundle_zh_TW.ff798824.mjs")).default;
    default:
      throw "unknown locale";
  }
}), Na = (t) => R(void 0, null, function* () {
  const e = yield La(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[i18n] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
}), Oa = [
  "ar",
  "bg",
  "ca",
  "cs",
  "cy",
  "da",
  "de",
  "el",
  "en",
  "en_GB",
  "en_US_sappsd",
  "en_US_saprigi",
  "en_US_saptrc",
  "es",
  "es_MX",
  "et",
  "fi",
  "fr",
  "fr_CA",
  "hi",
  "hr",
  "hu",
  "in",
  "it",
  "iw",
  "ja",
  "kk",
  "ko",
  "lt",
  "lv",
  "ms",
  "nl",
  "no",
  "pl",
  "pt",
  "pt_PT",
  "ro",
  "ru",
  "sh",
  "sk",
  "sl",
  "sv",
  "th",
  "tr",
  "uk",
  "vi",
  "zh_CN",
  "zh_TW"
];
Oa.forEach((t) => {
  _t("@ui5/webcomponents", t, Na);
});
const Va = (t) => R(void 0, null, function* () {
  switch (t) {
    case "sap_belize":
      return (yield import("./parameters-bundle.css.82b86717.mjs")).default;
    case "sap_belize_hcb":
      return (yield import("./parameters-bundle.css.935ecccf.mjs")).default;
    case "sap_belize_hcw":
      return (yield import("./parameters-bundle.css.b0a7ae0b.mjs")).default;
    case "sap_fiori_3":
      return (yield import("./parameters-bundle.css.30bc18eb.mjs")).default;
    case "sap_fiori_3_dark":
      return (yield import("./parameters-bundle.css.92fe97d1.mjs")).default;
    case "sap_fiori_3_hcb":
      return (yield import("./parameters-bundle.css.2469cb5a.mjs")).default;
    case "sap_fiori_3_hcw":
      return (yield import("./parameters-bundle.css.5b9cb7f9.mjs")).default;
    case "sap_horizon":
      return (yield import("./parameters-bundle.css.20b55295.mjs")).default;
    case "sap_horizon_dark":
      return (yield import("./parameters-bundle.css.c755fde7.mjs")).default;
    case "sap_horizon_exp":
      return (yield import("./parameters-bundle.css.f2da4a5f.mjs")).default;
    case "sap_horizon_hcb":
      return (yield import("./parameters-bundle.css.c0ef3a5c.mjs")).default;
    case "sap_horizon_hcw":
      return (yield import("./parameters-bundle.css.41de509d.mjs")).default;
    default:
      throw "unknown theme";
  }
}), Ra = (t) => R(void 0, null, function* () {
  const e = yield Va(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[themes] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
});
["sap_belize", "sap_belize_hcb", "sap_belize_hcw", "sap_fiori_3", "sap_fiori_3_dark", "sap_fiori_3_hcb", "sap_fiori_3_hcw", "sap_horizon", "sap_horizon_dark", "sap_horizon_exp", "sap_horizon_hcb", "sap_horizon_hcw"].forEach((t) => dr("@ui5/webcomponents-fiori", t, Ra));
const xa = (t) => R(void 0, null, function* () {
  switch (t) {
    case "ar":
      return (yield import("./messagebundle_ar.68d16ce9.mjs")).default;
    case "bg":
      return (yield import("./messagebundle_bg.033c85fa.mjs")).default;
    case "ca":
      return (yield import("./messagebundle_ca.9473b4f3.mjs")).default;
    case "cs":
      return (yield import("./messagebundle_cs.4ed220b0.mjs")).default;
    case "cy":
      return (yield import("./messagebundle_cy.bd7bdb17.mjs")).default;
    case "da":
      return (yield import("./messagebundle_da.23d177d6.mjs")).default;
    case "de":
      return (yield import("./messagebundle_de.a08cd498.mjs")).default;
    case "el":
      return (yield import("./messagebundle_el.b585b9c2.mjs")).default;
    case "en":
      return (yield import("./messagebundle_en.4993de0e.mjs")).default;
    case "en_GB":
      return (yield import("./messagebundle_en_GB.64e4fdbf.mjs")).default;
    case "en_US_sappsd":
      return (yield import("./messagebundle_en_US_sappsd.6d3380d1.mjs")).default;
    case "en_US_saprigi":
      return (yield import("./messagebundle_en_US_saprigi.7f1bdfee.mjs")).default;
    case "en_US_saptrc":
      return (yield import("./messagebundle_en_US_saptrc.c77d9b42.mjs")).default;
    case "es":
      return (yield import("./messagebundle_es.a5795e4c.mjs")).default;
    case "es_MX":
      return (yield import("./messagebundle_es_MX.aba8f90f.mjs")).default;
    case "et":
      return (yield import("./messagebundle_et.c3ef49f3.mjs")).default;
    case "fi":
      return (yield import("./messagebundle_fi.1d101f32.mjs")).default;
    case "fr":
      return (yield import("./messagebundle_fr.3ba4950e.mjs")).default;
    case "fr_CA":
      return (yield import("./messagebundle_fr_CA.8f8e7845.mjs")).default;
    case "hi":
      return (yield import("./messagebundle_hi.d53ff246.mjs")).default;
    case "hr":
      return (yield import("./messagebundle_hr.f644eb38.mjs")).default;
    case "hu":
      return (yield import("./messagebundle_hu.addbfeab.mjs")).default;
    case "in":
      return (yield import("./messagebundle_in.8d5abc20.mjs")).default;
    case "it":
      return (yield import("./messagebundle_it.067c0c4f.mjs")).default;
    case "iw":
      return (yield import("./messagebundle_iw.3273d093.mjs")).default;
    case "ja":
      return (yield import("./messagebundle_ja.14151180.mjs")).default;
    case "kk":
      return (yield import("./messagebundle_kk.89cffe87.mjs")).default;
    case "ko":
      return (yield import("./messagebundle_ko.094a9ac2.mjs")).default;
    case "lt":
      return (yield import("./messagebundle_lt.66a3d6ed.mjs")).default;
    case "lv":
      return (yield import("./messagebundle_lv.9fe22d37.mjs")).default;
    case "ms":
      return (yield import("./messagebundle_ms.575e4eac.mjs")).default;
    case "nl":
      return (yield import("./messagebundle_nl.0fd0e296.mjs")).default;
    case "no":
      return (yield import("./messagebundle_no.601e0aa8.mjs")).default;
    case "pl":
      return (yield import("./messagebundle_pl.c36138cc.mjs")).default;
    case "pt":
      return (yield import("./messagebundle_pt.817e6030.mjs")).default;
    case "pt_PT":
      return (yield import("./messagebundle_pt_PT.4bbb877b.mjs")).default;
    case "ro":
      return (yield import("./messagebundle_ro.9f2db3df.mjs")).default;
    case "ru":
      return (yield import("./messagebundle_ru.2aa4f814.mjs")).default;
    case "sh":
      return (yield import("./messagebundle_sh.52e4fa4e.mjs")).default;
    case "sk":
      return (yield import("./messagebundle_sk.8d1af979.mjs")).default;
    case "sl":
      return (yield import("./messagebundle_sl.b4e3d588.mjs")).default;
    case "sv":
      return (yield import("./messagebundle_sv.9bc22bc0.mjs")).default;
    case "th":
      return (yield import("./messagebundle_th.4a5ee908.mjs")).default;
    case "tr":
      return (yield import("./messagebundle_tr.248e72ee.mjs")).default;
    case "uk":
      return (yield import("./messagebundle_uk.67b92877.mjs")).default;
    case "vi":
      return (yield import("./messagebundle_vi.14a9cbca.mjs")).default;
    case "zh_CN":
      return (yield import("./messagebundle_zh_CN.52b122f0.mjs")).default;
    case "zh_TW":
      return (yield import("./messagebundle_zh_TW.fd4ffdd3.mjs")).default;
    default:
      throw "unknown locale";
  }
}), Ka = (t) => R(void 0, null, function* () {
  const e = yield xa(t);
  if (typeof e == "string" && e.endsWith(".json"))
    throw new Error(`[i18n] Invalid bundling detected - dynamic JSON imports bundled as URLs. Switch to inlining JSON files from the build or use 'import ".../Assets-static.js"'. Check the "Assets" documentation for more information.`);
  return e;
}), Ma = [
  "ar",
  "bg",
  "ca",
  "cs",
  "cy",
  "da",
  "de",
  "el",
  "en",
  "en_GB",
  "en_US_sappsd",
  "en_US_saprigi",
  "en_US_saptrc",
  "es",
  "es_MX",
  "et",
  "fi",
  "fr",
  "fr_CA",
  "hi",
  "hr",
  "hu",
  "in",
  "it",
  "iw",
  "ja",
  "kk",
  "ko",
  "lt",
  "lv",
  "ms",
  "nl",
  "no",
  "pl",
  "pt",
  "pt_PT",
  "ro",
  "ru",
  "sh",
  "sk",
  "sl",
  "sv",
  "th",
  "tr",
  "uk",
  "vi",
  "zh_CN",
  "zh_TW"
];
Ma.forEach((t) => {
  _t("@ui5/webcomponents-fiori", t, Ka);
});
const no = /* @__PURE__ */ new Map(), hr = pt("SVGIllustration.registry", /* @__PURE__ */ new Map()), Ft = pt("SVGIllustration.promises", /* @__PURE__ */ new Map()), ka = (t, e) => {
  hr.set(`${e.set}/${t}`, {
    dialogSvg: e.dialogSvg,
    sceneSvg: e.sceneSvg,
    spotSvg: e.spotSvg,
    title: e.title,
    subtitle: e.subtitle
  });
}, Ha = (t) => R(void 0, null, function* () {
  if (!Ft.has(t)) {
    if (!no.has(t)) {
      const r = t.startsWith("Tnt") ? `tnt/${t.replace(/^Tnt/, "")}` : t;
      throw new Error(`No loader registered for the ${t} illustration. Probably you forgot to import the "@ui5/webcomponents-fiori/dist/illustrations/${r}.js" module. Or you can import the "@ui5/webcomponents-fiori/dist/illustrations/AllIllustrations.js" module that will make all illustrations available, but fetch only the ones used.`);
    }
    const e = no.get(t);
    Ft.set(t, e(t));
  }
  return Ft.get(t);
}), Il = (t) => {
  let e = "fiori";
  return t.startsWith("Tnt") && (e = "tnt", t = t.replace(/^Tnt/, "")), hr.get(`${e}/${t}`);
}, El = (t) => R(void 0, null, function* () {
  let e = "fiori";
  return yield Ha(t), t.startsWith("Tnt") && (e = "tnt", t = t.replace(/^Tnt/, "")), hr.get(`${e}/${t}`);
}), $a = `<svg width="160" height="160" viewBox="0 0 160 160" fill="none" xmlns="http://www.w3.org/2000/svg" id="sapIllus-Dialog-Survey">
<mask id="mask0_49_23941" style="mask-type:alpha" maskUnits="userSpaceOnUse" x="3" y="3" width="154" height="154">
<circle cx="79.8854" cy="79.8854" r="76.8854" style="fill:var(--sapContent_Illustrative_Color7)"/>
</mask>
<g mask="url(#mask0_49_23941)">
<path d="M199.36 -2.30273H-32.1658C-33.675 -2.30412 -35.1696 -2.00808 -36.5642 -1.43152C-37.9589 -0.854964 -39.2262 -0.00919863 -40.2938 1.05743C-41.3615 2.12406 -42.2084 3.39062 -42.7862 4.78475C-43.3641 6.17888 -43.6615 7.67322 -43.6615 9.18235V145.275C-43.6615 148.324 -42.4504 151.248 -40.2945 153.403C-38.1386 155.559 -35.2147 156.77 -32.1658 156.77H199.36C202.409 156.77 205.333 155.559 207.489 153.403C209.644 151.248 210.856 148.324 210.856 145.275V9.18235C210.856 7.67322 210.558 6.17888 209.98 4.78475C209.402 3.39062 208.555 2.12406 207.488 1.05743C206.42 -0.00919863 205.153 -0.854964 203.758 -1.43152C202.364 -2.00808 200.869 -2.30412 199.36 -2.30273V-2.30273Z" style="fill:var(--sapContent_Illustrative_Color7)"/>
<path d="M159.021 21.7357C159.254 20.7422 156.556 19.2718 152.745 18.1889C153.426 14.2892 153.248 11.2292 152.254 10.9988C151.26 10.7683 149.759 13.4582 148.641 17.2767C144.715 16.6362 141.641 16.827 141.421 17.8257C141.201 18.8244 143.885 20.2918 147.696 21.3724C147.026 25.2747 147.194 28.3321 148.185 28.562C149.177 28.792 150.683 26.1031 151.8 22.2847C155.726 22.9252 158.799 22.7339 159.021 21.7357Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M137.012 11.0859H93.2815C91.5066 11.0859 89.7492 11.4358 88.1094 12.1157C86.4696 12.7955 84.9797 13.792 83.7247 15.0481C82.4697 16.3043 81.4741 17.7956 80.7949 19.4369C80.1157 21.0782 79.7661 22.8373 79.7661 24.6138C79.7661 26.3903 80.1157 28.1494 80.7949 29.7907C81.4741 31.4319 82.4697 32.9232 83.7247 34.1794C84.9797 35.4356 86.4696 36.432 88.1094 37.1119C89.7492 37.7917 91.5066 38.1416 93.2815 38.1416H137.012C140.596 38.1416 144.034 36.7164 146.569 34.1794C149.103 31.6424 150.527 28.2016 150.527 24.6138C150.527 21.026 149.103 17.5851 146.569 15.0481C144.034 12.5112 140.596 11.0859 137.012 11.0859V11.0859Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M57.9258 122.431H14.1956C12.4207 122.431 10.6632 122.781 9.02346 123.46C7.38369 124.14 5.89378 125.137 4.63876 126.393C3.38373 127.649 2.38815 129.14 1.70894 130.782C1.02973 132.423 0.680176 134.182 0.680176 135.958C0.680176 137.735 1.02973 139.494 1.70894 141.135C2.38815 142.777 3.38373 144.268 4.63876 145.524C5.89378 146.78 7.38369 147.777 9.02346 148.457C10.6632 149.136 12.4207 149.486 14.1956 149.486H57.9258C61.5103 149.486 64.948 148.061 67.4826 145.524C70.0173 142.987 71.4412 139.546 71.4412 135.958C71.4412 132.371 70.0173 128.93 67.4826 126.393C64.948 123.856 61.5103 122.431 57.9258 122.431V122.431Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M169.27 33.9795H125.54C123.765 33.9795 122.008 34.3294 120.368 35.0092C118.728 35.6891 117.238 36.6855 115.983 37.9417C114.728 39.1979 113.733 40.6892 113.054 42.3305C112.374 43.9717 112.025 45.7308 112.025 47.5073C112.025 49.2838 112.374 51.0429 113.054 52.6842C113.733 54.3255 114.728 55.8168 115.983 57.073C117.238 58.3291 118.728 59.3256 120.368 60.0054C122.008 60.6853 123.765 61.0352 125.54 61.0352H169.27C172.855 61.0352 176.293 59.6099 178.827 57.073C181.362 54.536 182.786 51.0951 182.786 47.5073C182.786 43.9195 181.362 40.4787 178.827 37.9417C176.293 35.4047 172.855 33.9795 169.27 33.9795V33.9795Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
</g>
<path d="M112.339 132.013C112.347 131.528 110.946 131.116 109.068 130.996C108.992 129.117 108.602 127.713 108.117 127.706C107.632 127.699 107.205 129.099 107.07 130.985C105.182 131.082 103.774 131.479 103.772 131.965C103.77 132.451 105.164 132.863 107.043 132.982C107.124 134.862 107.509 136.265 107.992 136.272C108.476 136.279 108.905 134.879 109.04 132.993C110.928 132.896 112.336 132.499 112.339 132.013Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M65.4429 25.7407C65.4431 25.3735 64.3775 25.0791 62.9536 25.0116C62.8729 23.5894 62.56 22.5318 62.1928 22.5324C61.8256 22.533 61.5198 23.5985 61.4409 25.0279C60.0128 25.1249 58.9509 25.4435 58.9556 25.8115C58.9603 26.1794 60.021 26.4738 61.445 26.5405C61.5298 27.9627 61.8386 29.0203 62.205 29.0197C62.5714 29.0191 62.8788 27.9536 62.9577 26.5242C64.3858 26.4272 65.4468 26.1086 65.4429 25.7407Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M137.71 54.0908C137.71 50.7771 135.024 48.0908 131.71 48.0908H43.5394C40.2257 48.0908 37.5394 50.7771 37.5394 54.0908V103.094C37.5394 105.91 39.8225 108.193 42.6389 108.193H47.2024C49.9705 108.193 51.3898 111.51 49.4786 113.512V113.512C46.9219 116.191 50.2867 120.317 53.4249 118.352L68.3425 109.009C69.1939 108.476 70.1781 108.193 71.1827 108.193H131.71C135.024 108.193 137.71 105.507 137.71 102.193V54.0908Z" style="fill:var(--sapContent_Illustrative_Color8)"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M49.932 112.915C50.0647 112.689 50.1647 112.455 50.2341 112.216C50.2644 112.112 50.2888 112.007 50.3076 111.902C50.3521 111.652 50.3648 111.401 50.3483 111.153C50.3313 110.898 50.2835 110.647 50.2073 110.405C49.5352 110.449 48.9544 110.945 48.8309 111.638C48.7805 111.921 48.6482 112.21 48.3935 112.477C47.5402 113.371 47.1127 114.435 47.0776 115.511C47.0506 116.339 47.6999 117.032 48.5278 117.059C48.6557 117.063 48.7804 117.051 48.8999 117.025C48.788 116.796 48.7024 116.555 48.6472 116.306C48.5933 116.063 48.5685 115.813 48.5768 115.56C48.5851 115.307 48.6264 115.051 48.7047 114.798C48.777 114.564 48.8808 114.332 49.0193 114.105C49.1437 113.902 49.2961 113.704 49.4786 113.512C49.6588 113.324 49.8093 113.123 49.932 112.915ZM58.4256 115.22C58.8653 115.922 58.6526 116.848 57.9505 117.287L54.2211 119.623C53.1737 120.279 52.0451 120.484 50.9844 120.302C50.1679 120.161 49.6196 119.386 49.7597 118.569C49.7814 118.443 49.8182 118.324 49.868 118.212C50.0692 118.367 50.2882 118.5 50.5208 118.604C50.7482 118.706 50.9886 118.78 51.2381 118.823C51.9253 118.941 52.6815 118.817 53.4249 118.352L58.4256 115.22ZM76.4656 108.193C76.4656 109.022 75.7941 109.693 74.9657 109.693H71.1827C70.4597 109.693 69.7514 109.897 69.1387 110.28L65.4093 112.616C64.7072 113.056 63.7816 112.843 63.3419 112.141L68.3425 109.009C69.1939 108.476 70.1781 108.193 71.1827 108.193H76.4656ZM91.5975 108.193C91.5975 109.022 90.9259 109.693 90.0975 109.693H82.5316C81.7031 109.693 81.0316 109.022 81.0316 108.193H91.5975ZM106.729 108.193C106.729 109.022 106.058 109.693 105.229 109.693H97.6634C96.835 109.693 96.1634 109.022 96.1634 108.193H106.729ZM121.861 108.193C121.861 109.022 121.19 109.693 120.361 109.693H112.795C111.967 109.693 111.295 109.022 111.295 108.193H121.861ZM135.31 106.994C135.34 107.048 135.368 107.105 135.392 107.163C135.71 107.929 135.347 108.806 134.581 109.124C133.695 109.491 132.724 109.693 131.71 109.693H127.927C127.099 109.693 126.427 109.022 126.427 108.193H131.71C132.524 108.193 133.299 108.031 134.007 107.738C134.239 107.642 134.464 107.531 134.68 107.408C134.899 107.283 135.109 107.145 135.31 106.994ZM137.71 96.6847C138.539 96.6847 139.21 97.3563 139.21 98.1847V102.193C139.21 103.207 139.008 104.178 138.64 105.065C138.323 105.83 137.445 106.193 136.68 105.876C136.621 105.851 136.565 105.823 136.511 105.793C136.661 105.592 136.8 105.382 136.925 105.163C137.048 104.947 137.159 104.722 137.255 104.49C137.548 103.783 137.71 103.007 137.71 102.193V96.6847ZM137.71 80.6506C138.539 80.6506 139.21 81.3221 139.21 82.1506V90.1676C139.21 90.996 138.539 91.6676 137.71 91.6676V80.6506ZM137.71 64.6164C138.539 64.6164 139.21 65.288 139.21 66.1164V74.1335C139.21 74.9619 138.539 75.6335 137.71 75.6335V64.6164ZM136.511 50.4914C136.565 50.4606 136.621 50.4329 136.68 50.4085C137.445 50.0912 138.323 50.4543 138.64 51.2195C139.008 52.1059 139.21 53.0766 139.21 54.0908V58.0994C139.21 58.9278 138.539 59.5994 137.71 59.5994V54.0908C137.71 53.2773 137.548 52.5015 137.255 51.7941C137.159 51.5619 137.048 51.3371 136.925 51.1207C136.8 50.9019 136.661 50.6918 136.511 50.4914ZM126.536 48.0908C126.536 47.2624 127.208 46.5908 128.036 46.5908H131.71C132.724 46.5908 133.695 46.7929 134.581 47.1605C135.347 47.4778 135.71 48.3554 135.392 49.1207C135.368 49.1795 135.34 49.236 135.31 49.29C135.109 49.1395 134.899 49.0012 134.68 48.8763C134.464 48.7528 134.239 48.6424 134.007 48.5461C133.299 48.2527 132.524 48.0908 131.71 48.0908H126.536ZM111.841 48.0908C111.841 47.2624 112.513 46.5908 113.341 46.5908H120.689C121.517 46.5908 122.189 47.2624 122.189 48.0908H111.841ZM97.1461 48.0908C97.1461 47.2624 97.8177 46.5908 98.6461 46.5908H105.994C106.822 46.5908 107.494 47.2624 107.494 48.0908H97.1461ZM82.451 48.0908C82.451 47.2624 83.1226 46.5908 83.951 46.5908H91.2985C92.127 46.5908 92.7985 47.2624 92.7985 48.0908H82.451ZM67.7559 48.0908C67.7559 47.2624 68.4274 46.5908 69.2559 46.5908H76.6034C77.4319 46.5908 78.1034 47.2624 78.1034 48.0908H67.7559ZM53.0608 48.0908C53.0608 47.2624 53.7323 46.5908 54.5608 46.5908H61.9083C62.7367 46.5908 63.4083 47.2624 63.4083 48.0908H53.0608ZM40.5693 48.8764C40.7857 48.7528 41.0105 48.6424 41.2427 48.5461C41.9501 48.2527 42.7259 48.0908 43.5394 48.0908H48.7132C48.7132 47.2624 48.0416 46.5908 47.2132 46.5908H43.5394C42.5253 46.5908 41.5545 46.7929 40.6681 47.1605C39.9029 47.4778 39.5398 48.3554 39.8571 49.1207C39.8815 49.1795 39.9092 49.236 39.94 49.29C40.1404 49.1395 40.3505 49.0012 40.5693 48.8764ZM37.5394 59.6744C36.711 59.6744 36.0394 59.0028 36.0394 58.1744V54.0908C36.0394 53.0766 36.2415 52.1059 36.6091 51.2195C36.9265 50.4543 37.804 50.0912 38.5693 50.4085C38.6281 50.4329 38.6846 50.4606 38.7386 50.4914C38.5881 50.6918 38.4498 50.9019 38.325 51.1207C38.2014 51.3371 38.091 51.5619 37.9947 51.7941C37.7013 52.5015 37.5394 53.2773 37.5394 54.0908V59.6744ZM37.5394 76.0087C36.711 76.0087 36.0394 75.3372 36.0394 74.5087V66.3416C36.0394 65.5131 36.711 64.8416 37.5394 64.8416V76.0087ZM37.5394 92.343C36.711 92.343 36.0394 91.6715 36.0394 90.843V82.6759C36.0394 81.8475 36.711 81.1759 37.5394 81.1759V92.343ZM38.6991 106.332C38.6365 106.369 38.5704 106.403 38.501 106.431C37.7357 106.749 36.8581 106.386 36.5408 105.62C36.2172 104.84 36.0394 103.986 36.0394 103.094V99.0102C36.0394 98.1818 36.711 97.5102 37.5394 97.5102V103.094C37.5394 103.785 37.677 104.445 37.9264 105.046C38.0228 105.278 38.1358 105.502 38.2641 105.715C38.394 105.932 38.5395 106.138 38.6991 106.332ZM49.9537 109.812C49.4575 110.267 48.6974 110.345 48.1109 109.956C47.8717 109.797 47.5712 109.693 47.2024 109.693H46.0615C45.6048 109.693 45.1957 109.489 44.9206 109.167C44.6455 109.489 44.2365 109.693 43.7797 109.693H42.6389C41.7468 109.693 40.8925 109.515 40.1123 109.192C39.347 108.875 38.9839 107.997 39.3013 107.232C39.3301 107.162 39.3635 107.096 39.401 107.034C39.5949 107.193 39.8008 107.339 40.0172 107.469C40.2307 107.597 40.4545 107.71 40.6869 107.806C41.2881 108.056 41.9474 108.193 42.6389 108.193H47.2024C47.8691 108.193 48.4575 108.386 48.9401 108.706C49.151 108.846 49.3418 109.01 49.5099 109.193C49.6824 109.382 49.8312 109.59 49.9537 109.812Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M102.163 79.2212C102.163 82.5405 104.854 85.2314 108.173 85.2314C111.493 85.2314 114.184 82.5405 114.184 79.2212C114.184 75.9018 111.493 73.2109 108.173 73.2109C104.854 73.2109 102.163 75.9018 102.163 79.2212Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M62.0944 79.2212C62.0944 82.5405 64.7853 85.2314 68.1046 85.2314C71.424 85.2314 74.1149 82.5405 74.1149 79.2212C74.1149 75.9018 71.424 73.2109 68.1046 73.2109C64.7853 73.2109 62.0944 75.9018 62.0944 79.2212Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M82.1289 79.2212C82.1289 82.5405 84.8198 85.2314 88.1392 85.2314C91.4585 85.2314 94.1494 82.5405 94.1494 79.2212C94.1494 75.9018 91.4585 73.2109 88.1392 73.2109C84.8198 73.2109 82.1289 75.9018 82.1289 79.2212Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M39.2614 30.2548C39.4291 30.233 39.5997 30.2463 39.7622 30.2939C39.9247 30.3415 40.0756 30.4224 40.2053 30.5314C40.335 30.6404 40.4406 30.7751 40.5154 30.9269C40.5901 31.0786 40.6324 31.2442 40.6396 31.413L41.1208 36.8635C41.1374 37.0595 41.1147 37.2567 41.0541 37.4436C40.9935 37.6306 40.8962 37.8034 40.7678 37.9521C40.6394 38.1007 40.4825 38.2223 40.3063 38.3096C40.1301 38.3969 39.9381 38.4482 39.7415 38.4605C39.6606 38.4679 39.5792 38.4686 39.4981 38.4626C39.1982 38.445 38.9154 38.3159 38.7055 38.1007C38.4955 37.8856 38.3736 37.6001 38.3638 37.3004L37.8841 31.8523C37.8672 31.6563 37.8895 31.4591 37.9498 31.2721C38.0102 31.0852 38.1073 30.9123 38.2356 30.7636C38.3638 30.6148 38.5206 30.4932 38.6968 30.4058C38.8729 30.3185 39.0649 30.2672 39.2614 30.2548Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M24.801 35.9516C24.9855 35.9396 25.1706 35.9654 25.3448 36.0272C25.519 36.089 25.6788 36.1856 25.8143 36.3111L31.95 41.8797C32.2238 42.131 32.3896 42.4781 32.4127 42.8485C32.4359 43.2189 32.3146 43.5838 32.0742 43.8671C31.8501 44.1289 31.5357 44.2971 31.1931 44.3385C30.9956 44.362 30.7953 44.3427 30.6059 44.2821C30.4166 44.2214 30.2425 44.1207 30.0957 43.9869L23.9599 38.4183C23.6844 38.1658 23.5178 37.8167 23.495 37.4442C23.4722 37.0717 23.5951 36.705 23.8378 36.421C23.9584 36.2821 24.1058 36.1689 24.2713 36.0882C24.4369 36.0076 24.617 35.9611 24.801 35.9516V35.9516Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M19.8188 52.493C19.9296 52.284 20.0946 52.1086 20.2966 51.985C20.4985 51.8614 20.7298 51.7944 20.9662 51.7908L26.5873 51.5606C27.517 51.522 28.0457 52.2682 28.0728 52.9955C28.0947 53.2928 28.0194 53.5895 27.8582 53.8411C27.6969 54.0926 27.4585 54.2855 27.1786 54.3907C27.0419 54.4375 26.899 54.4634 26.7546 54.4676L21.1335 54.6979C20.8871 54.713 20.6414 54.6614 20.4225 54.5485C20.2036 54.4356 20.0196 54.2655 19.8899 54.0564C19.7457 53.824 19.6634 53.5583 19.651 53.2847C19.6385 53.0111 19.6963 52.7386 19.8188 52.493Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
</svg>
`, Fa = `<svg width="320" height="207" viewBox="0 0 320 207" fill="none" xmlns="http://www.w3.org/2000/svg" id="sapIllus-Scene-Survey">
<path d="M299.77 7.00001H29.7028C27.9425 6.99839 26.199 7.34268 24.5722 8.01321C22.9454 8.68374 21.4671 9.66735 20.2217 10.9078C18.9764 12.1483 17.9885 13.6213 17.3144 15.2427C16.6404 16.864 16.2935 18.6019 16.2935 20.357V178.631C16.2935 182.176 17.7062 185.577 20.221 188.084C22.7357 190.591 26.1464 192 29.7028 192H299.77C303.327 192 306.737 190.591 309.252 188.084C311.767 185.577 313.18 182.176 313.18 178.631V20.357C313.18 18.6019 312.833 16.864 312.159 15.2427C311.485 13.6213 310.497 12.1483 309.251 10.9078C308.006 9.66735 306.528 8.68374 304.901 8.01321C303.274 7.34268 301.531 6.99839 299.77 7.00001Z" style="fill:var(--sapContent_Illustrative_Color7)"/>
<path d="M243.714 2H197.161C195.271 2 193.4 2.3725 191.655 3.09623C189.909 3.81995 188.323 4.88073 186.987 6.218C185.651 7.55528 184.591 9.14286 183.868 10.8901C183.145 12.6373 182.773 14.51 182.773 16.4012C182.773 18.2924 183.145 20.1651 183.868 21.9123C184.591 23.6595 185.651 25.2471 186.987 26.5844C188.323 27.9216 189.909 28.9824 191.655 29.7062C193.4 30.4299 195.271 30.8024 197.161 30.8024H243.714C247.53 30.8024 251.19 29.2851 253.888 26.5844C256.586 23.8836 258.102 20.2206 258.102 16.4012C258.102 12.5818 256.586 8.91875 253.888 6.218C251.19 3.51726 247.53 2 243.714 2V2Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M204.941 23H158.388C156.498 23 154.628 23.3725 152.882 24.0962C151.136 24.82 149.55 25.8807 148.214 27.218C146.878 28.5553 145.818 30.1429 145.095 31.8901C144.372 33.6373 144 35.51 144 37.4012C144 39.2924 144.372 41.1651 145.095 42.9123C145.818 44.6595 146.878 46.2471 148.214 47.5844C149.55 48.9216 151.136 49.9824 152.882 50.7062C154.628 51.4299 156.498 51.8024 158.388 51.8024H204.941C208.757 51.8024 212.417 50.2851 215.115 47.5844C217.813 44.8836 219.329 41.2206 219.329 37.4012C219.329 33.5818 217.813 29.9188 215.115 27.218C212.417 24.5173 208.757 23 204.941 23V23Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M74.6954 97.8382H68.421C68.421 94.6064 67.1044 91.5069 64.7609 89.2217C62.4174 86.9364 59.239 85.6526 55.9248 85.6526H15.4962C12.182 85.6526 9.00357 86.9364 6.66008 89.2217C4.31658 91.5069 3 94.6064 3 97.8382C3 101.07 4.31658 104.17 6.66008 106.455C9.00357 108.74 12.182 110.024 15.4962 110.024H21.7706C21.7706 113.256 23.0872 116.355 25.4307 118.64C27.7742 120.926 30.9526 122.209 34.2668 122.209H74.6954C78.0096 122.209 81.188 120.926 83.5315 118.64C85.875 116.355 87.1916 113.256 87.1916 110.024C87.1916 106.792 85.875 103.693 83.5315 101.407C81.188 99.1221 78.0096 97.8382 74.6954 97.8382V97.8382Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M93.8515 170.952H47.2981C45.4086 170.952 43.5377 171.325 41.7921 172.048C40.0464 172.772 38.4603 173.833 37.1243 175.17C35.7883 176.507 34.7284 178.095 34.0053 179.842C33.2823 181.589 32.9102 183.462 32.9102 185.353C32.9102 187.245 33.2823 189.117 34.0053 190.864C34.7284 192.612 35.7883 194.199 37.1243 195.537C38.4603 196.874 40.0464 197.935 41.7921 198.658C43.5377 199.382 45.4086 199.755 47.2981 199.755H93.8515C97.6674 199.755 101.327 198.237 104.025 195.537C106.724 192.836 108.239 189.173 108.239 185.353C108.239 181.534 106.724 177.871 104.025 175.17C101.327 172.469 97.6674 170.952 93.8515 170.952V170.952Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M293.253 125.533H246.699C244.81 125.533 242.939 125.905 241.193 126.629C239.448 127.353 237.862 128.414 236.526 129.751C235.19 131.088 234.13 132.676 233.407 134.423C232.684 136.17 232.312 138.043 232.312 139.934C232.312 141.825 232.684 143.698 233.407 145.445C234.13 147.192 235.19 148.78 236.526 150.117C237.862 151.455 239.448 152.515 241.193 153.239C242.939 153.963 244.81 154.335 246.699 154.335H293.253C297.069 154.335 300.728 152.818 303.427 150.117C306.125 147.417 307.641 143.754 307.641 139.934C307.641 136.115 306.125 132.452 303.427 129.751C300.728 127.05 297.069 125.533 293.253 125.533V125.533Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M264.45 142.15H217.897C216.007 142.15 214.136 142.522 212.391 143.246C210.645 143.97 209.059 145.03 207.723 146.368C206.387 147.705 205.327 149.293 204.604 151.04C203.881 152.787 203.509 154.66 203.509 156.551C203.509 158.442 203.881 160.315 204.604 162.062C205.327 163.809 206.387 165.397 207.723 166.734C209.059 168.071 210.645 169.132 212.391 169.856C214.136 170.58 216.007 170.952 217.897 170.952H264.45C268.266 170.952 271.926 169.435 274.624 166.734C277.322 164.033 278.838 160.37 278.838 156.551C278.838 152.731 277.322 149.068 274.624 146.368C271.926 143.667 268.266 142.15 264.45 142.15V142.15Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M84.4246 17.1007C84.7117 17.0628 85.0036 17.0859 85.2819 17.1684C85.5601 17.2509 85.8185 17.391 86.0406 17.5799C86.2626 17.7687 86.4434 18.0021 86.5714 18.2652C86.6994 18.5282 86.7718 18.8151 86.784 19.1076L87.6079 28.5527C87.6363 28.8924 87.5976 29.2341 87.4938 29.558C87.3901 29.8819 87.2234 30.1814 87.0036 30.439C86.7837 30.6966 86.5151 30.9073 86.2134 31.0585C85.9118 31.2098 85.583 31.2988 85.2464 31.3201C85.1079 31.3329 84.9685 31.3341 84.8297 31.3238C84.3163 31.2932 83.8322 31.0695 83.4727 30.6967C83.1132 30.3239 82.9045 29.8291 82.8877 29.3098L82.0665 19.8688C82.0374 19.5292 82.0757 19.1875 82.179 18.8635C82.2823 18.5396 82.4486 18.24 82.6682 17.9822C82.8878 17.7244 83.1562 17.5137 83.4578 17.3623C83.7594 17.211 84.088 17.122 84.4246 17.1007Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M59.6674 26.973C59.9833 26.9523 60.3001 26.9968 60.5984 27.1039C60.8967 27.2111 61.1702 27.3785 61.4022 27.596L71.9071 37.2457C72.3759 37.6811 72.6597 38.2827 72.6993 38.9245C72.7389 39.5663 72.5313 40.1987 72.1197 40.6896C71.7361 41.1432 71.1977 41.4347 70.6112 41.5064C70.273 41.5471 69.9302 41.5138 69.6059 41.4087C69.2817 41.3036 68.9837 41.1291 68.7323 40.8972L58.2274 31.2475C57.7557 30.81 57.4704 30.2049 57.4314 29.5595C57.3924 28.914 57.6028 28.2785 58.0183 27.7863C58.2247 27.5456 58.4772 27.3495 58.7606 27.2097C59.044 27.07 59.3524 26.9894 59.6674 26.973V26.973Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M51.1374 55.6365C51.3271 55.2744 51.6097 54.9703 51.9554 54.7562C52.3011 54.5421 52.6971 54.4259 53.1019 54.4198L62.7257 54.0207C64.3173 53.9539 65.2224 55.2469 65.2689 56.5073C65.3065 57.0224 65.1776 57.5365 64.9015 57.9725C64.6254 58.4085 64.2171 58.7427 63.738 58.925C63.5039 59.0061 63.2592 59.051 63.0121 59.0582L53.3883 59.4573C52.9664 59.4835 52.5458 59.3941 52.171 59.1984C51.7962 59.0027 51.4811 58.7081 51.2591 58.3457C51.0122 57.9429 50.8713 57.4826 50.85 57.0085C50.8287 56.5344 50.9276 56.0621 51.1374 55.6365Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M294.642 34.191C294.641 33.3608 292.227 32.6992 289.003 32.5522C288.815 29.3364 288.102 26.9459 287.271 26.9488C286.44 26.9516 285.751 29.3622 285.579 32.5951C282.346 32.8199 279.943 33.5445 279.955 34.3766C279.967 35.2086 282.37 35.8703 285.594 36.0154C285.791 39.2312 286.495 41.6217 287.324 41.6188C288.154 41.616 288.846 39.2054 289.019 35.9726C292.251 35.7477 294.652 35.0231 294.642 34.191Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M163.901 177.686C163.903 177.045 162.042 176.527 159.554 176.404C159.419 173.922 158.876 172.075 158.234 172.075C157.593 172.075 157.054 173.933 156.911 176.427C154.416 176.591 152.559 177.143 152.566 177.785C152.573 178.428 154.425 178.945 156.913 179.067C157.056 181.549 157.591 183.396 158.231 183.396C158.872 183.396 159.413 181.538 159.556 179.044C162.051 178.88 163.906 178.328 163.901 177.686Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M40.7249 28.6721C40.7316 28.2337 39.4631 27.8633 37.7622 27.7575C37.691 26.058 37.3357 24.7897 36.8968 24.784C36.4579 24.7782 36.0734 26.0449 35.9537 27.7502C34.2449 27.8406 32.97 28.2021 32.9691 28.6415C32.9681 29.0809 34.2308 29.4512 35.9317 29.5561C36.0078 31.2556 36.3582 32.5239 36.7962 32.5296C37.2341 32.5354 37.6206 31.2687 37.7403 29.5634C39.449 29.473 40.723 29.1115 40.7249 28.6721Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M267.832 64H238.168C236.964 64 235.772 64.2328 234.66 64.6851C233.547 65.1374 232.537 65.8003 231.685 66.636C230.834 67.4718 230.159 68.4639 229.698 69.5558C229.237 70.6478 229 71.8181 229 73C229 74.1819 229.237 75.3522 229.698 76.4442C230.159 77.5361 230.834 78.5282 231.685 79.364C232.537 80.1997 233.547 80.8626 234.66 81.3149C235.772 81.7672 236.964 82 238.168 82H267.832C270.263 82 272.595 81.0518 274.315 79.364C276.034 77.6761 277 75.3869 277 73C277 70.613 276.034 68.3239 274.315 66.636C272.595 64.9482 270.263 64 267.832 64V64Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M254.467 54.6345C254.467 50.9636 251.491 47.9878 247.821 47.9878H88.2996C84.6287 47.9878 81.6529 50.9636 81.6529 54.6345V145.03C81.6529 148.701 84.6287 151.676 88.2996 151.676H101.707C105.995 151.676 108.794 156.175 106.9 160.022V160.022C104.234 165.436 110.595 170.805 115.485 167.269L135.299 152.938C136.432 152.118 137.795 151.676 139.194 151.676H247.821C251.491 151.676 254.467 148.701 254.467 145.03V54.6345Z" style="fill:var(--sapContent_Illustrative_Color8)"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M107.295 158.987C107.397 158.62 107.46 158.251 107.487 157.885C107.504 157.648 107.507 157.412 107.495 157.178C107.476 156.806 107.421 156.439 107.332 156.082C107.241 155.719 107.115 155.366 106.958 155.028C105.95 155.279 105.228 156.215 105.282 157.291C105.311 157.857 105.202 158.453 104.912 159.043C104.057 160.779 103.87 162.576 104.224 164.232C104.479 165.429 105.657 166.192 106.853 165.936C107 165.905 107.139 165.86 107.272 165.803C107.061 165.496 106.878 165.168 106.729 164.824C106.583 164.487 106.468 164.134 106.39 163.77C106.28 163.251 106.242 162.709 106.291 162.153C106.322 161.791 106.39 161.424 106.497 161.054C106.596 160.712 106.73 160.367 106.9 160.022C107.067 159.681 107.199 159.335 107.295 158.987ZM122.233 162.388C122.95 163.379 122.728 164.764 121.736 165.481L116.783 169.064C115.216 170.198 113.476 170.684 111.783 170.613C110.56 170.562 109.611 169.53 109.662 168.307C109.668 168.158 109.689 168.012 109.723 167.872C110.061 168.029 110.415 168.154 110.779 168.243C111.136 168.331 111.503 168.384 111.875 168.4C113.067 168.45 114.318 168.113 115.485 167.269L122.233 162.388ZM146.841 151.677C146.841 152.9 145.849 153.892 144.625 153.892H139.194C138.261 153.892 137.352 154.186 136.597 154.733L131.643 158.316C130.652 159.033 129.267 158.81 128.55 157.819L135.298 152.938C136.432 152.118 137.795 151.677 139.194 151.677H146.841ZM168.566 151.677C168.566 152.9 167.574 153.892 166.35 153.892H155.488C154.264 153.892 153.272 152.9 153.272 151.677H168.566ZM190.291 151.677C190.291 152.9 189.299 153.892 188.076 153.892H177.213C175.989 153.892 174.997 152.9 174.997 151.677H190.291ZM212.017 151.677C212.017 152.9 211.025 153.892 209.801 153.892H198.938C197.715 153.892 196.723 152.9 196.723 151.677H212.017ZM233.742 151.677C233.742 152.9 232.75 153.892 231.526 153.892H220.664C219.44 153.892 218.448 152.9 218.448 151.677H233.742ZM254.467 137.165C255.691 137.165 256.683 138.157 256.683 139.38V145.03C256.683 149.924 252.715 153.892 247.82 153.892H242.389C241.165 153.892 240.173 152.9 240.173 151.677H247.82C251.491 151.677 254.467 148.701 254.467 145.03V137.165ZM254.467 114.566C255.691 114.566 256.683 115.558 256.683 116.781V128.081C256.683 129.304 255.691 130.296 254.467 130.296V114.566ZM254.467 91.9671C255.691 91.9671 256.683 92.959 256.683 94.1826V105.482C256.683 106.706 255.691 107.698 254.467 107.698V91.9671ZM254.467 69.3683C255.691 69.3683 256.683 70.3602 256.683 71.5838V82.8832C256.683 84.1069 255.691 85.0988 254.467 85.0988V69.3683ZM239.908 47.988C239.908 46.7644 240.9 45.7725 242.123 45.7725H247.82C252.715 45.7725 256.683 49.7402 256.683 54.6347V60.2844C256.683 61.5081 255.691 62.5 254.467 62.5V54.6347C254.467 50.9639 251.491 47.988 247.82 47.988H239.908ZM217.119 47.988C217.119 46.7644 218.111 45.7725 219.334 45.7725H230.729C231.952 45.7725 232.944 46.7644 232.944 47.988H217.119ZM194.33 47.988C194.33 46.7644 195.322 45.7725 196.546 45.7725H207.94C209.164 45.7725 210.156 46.7644 210.156 47.988H194.33ZM171.541 47.988C171.541 46.7644 172.533 45.7725 173.757 45.7725H185.151C186.375 45.7725 187.367 46.7644 187.367 47.988H171.541ZM148.753 47.988C148.753 46.7644 149.745 45.7725 150.968 45.7725H162.363C163.586 45.7725 164.578 46.7644 164.578 47.988H148.753ZM125.964 47.988C125.964 46.7644 126.956 45.7725 128.18 45.7725H139.574C140.798 45.7725 141.79 46.7644 141.79 47.988H125.964ZM119.001 47.988C119.001 46.7644 118.009 45.7725 116.785 45.7725H105.391C104.167 45.7725 103.175 46.7644 103.175 47.988H119.001ZM81.6526 62.5C80.429 62.5 79.4371 61.5081 79.4371 60.2844V54.6347C79.4371 49.7402 83.4048 45.7725 88.2993 45.7725H93.9965C95.2202 45.7725 96.2121 46.7644 96.2121 47.988H88.2993C84.6285 47.988 81.6526 50.9639 81.6526 54.6347V62.5ZM81.6526 85.0988C80.429 85.0988 79.4371 84.1069 79.4371 82.8833V71.5838C79.4371 70.3602 80.429 69.3683 81.6526 69.3683V85.0988ZM81.6526 107.698C80.429 107.698 79.4371 106.706 79.4371 105.482V94.1827C79.4371 92.959 80.429 91.9671 81.6526 91.9671V107.698ZM81.6526 130.296C80.429 130.296 79.4371 129.305 79.4371 128.081V116.781C79.4371 115.558 80.429 114.566 81.6526 114.566V130.296ZM93.8668 151.677C93.8668 152.9 92.8749 153.892 91.6512 153.892H88.2993C83.4048 153.892 79.4371 149.924 79.4371 145.03V139.38C79.4371 138.157 80.429 137.165 81.6526 137.165V145.03C81.6526 148.701 84.6285 151.677 88.2993 151.677H93.8668ZM106.213 153.83C105.543 154.624 104.384 154.859 103.443 154.334C102.947 154.058 102.364 153.892 101.707 153.892H98.355C97.1313 153.892 96.1394 152.9 96.1394 151.677H101.707C102.748 151.677 103.701 151.942 104.521 152.399C104.847 152.58 105.151 152.792 105.432 153.029C105.718 153.271 105.979 153.54 106.213 153.83Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M192.875 102.114C192.875 107.841 197.517 112.483 203.243 112.483C208.97 112.483 213.612 107.841 213.612 102.114C213.612 96.3877 208.97 91.7454 203.243 91.7454C197.517 91.7454 192.875 96.3877 192.875 102.114Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M123.748 102.114C123.748 107.841 128.39 112.483 134.117 112.483C139.844 112.483 144.486 107.841 144.486 102.114C144.486 96.3877 139.844 91.7454 134.117 91.7454C128.39 91.7454 123.748 96.3877 123.748 102.114Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M158.312 102.114C158.312 107.841 162.954 112.483 168.68 112.483C174.407 112.483 179.049 107.841 179.049 102.114C179.049 96.3877 174.407 91.7454 168.68 91.7454C162.954 91.7454 158.312 96.3877 158.312 102.114Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
</svg>
`, za = `<svg width="128" height="128" viewBox="0 0 128 128" fill="none" xmlns="http://www.w3.org/2000/svg" id="sapIllus-Spot-Survey">
<g clip-path="url(#clip0_49_23917)">
<mask id="mask0_49_23917" style="mask-type:alpha" maskUnits="userSpaceOnUse" x="0" y="0" width="128" height="128">
<circle cx="64" cy="64" r="64" style="fill:var(--sapContent_Illustrative_Color7)"/>
</mask>
<g mask="url(#mask0_49_23917)">
<path d="M155.132 -1.7417H-34.9693C-36.2084 -1.74284 -37.4356 -1.49976 -38.5807 -1.02636C-39.7259 -0.55296 -40.7665 0.141484 -41.6431 1.01727C-42.5197 1.89306 -43.2151 2.93302 -43.6895 4.07771C-44.164 5.22241 -44.4082 6.44939 -44.4082 7.68851V119.432C-44.4082 121.935 -43.4138 124.336 -41.6436 126.106C-39.8735 127.876 -37.4726 128.871 -34.9693 128.871H155.132C157.636 128.871 160.037 127.876 161.807 126.106C163.577 124.336 164.571 121.935 164.571 119.432V7.68851C164.571 6.44939 164.327 5.22241 163.853 4.07771C163.378 2.93302 162.683 1.89306 161.806 1.01727C160.93 0.141484 159.889 -0.55296 158.744 -1.02636C157.599 -1.49976 156.372 -1.74284 155.132 -1.7417V-1.7417Z" style="fill:var(--sapContent_Illustrative_Color7)"/>
<path d="M139.857 87.7551C140.673 94.7045 141.007 102.706 135.647 102.798C128.926 102.911 128.733 96.2995 127.917 89.3283C127.101 82.3571 127.423 76.5148 132.43 75.9217C137.128 75.3575 139.036 80.7752 139.857 87.7551Z" style="fill:var(--sapContent_Illustrative_Color7)"/>
<path d="M153.666 106.453L122.739 106.732C122.373 106.736 122.079 107.038 122.082 107.408L122.273 128.507C122.276 128.877 122.576 129.174 122.942 129.171L153.869 128.891C154.235 128.888 154.529 128.585 154.526 128.215L154.335 107.116C154.332 106.746 154.032 106.449 153.666 106.453Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M153.611 102.697L122.731 102.976C122.365 102.979 122.071 103.282 122.074 103.651L122.143 111.225C122.146 111.595 122.445 111.892 122.811 111.889L153.691 111.609C154.057 111.606 154.351 111.304 154.348 110.934L154.28 103.36C154.276 102.991 153.977 102.693 153.611 102.697Z" style="fill:var(--sapContent_Illustrative_Color7)"/>
<path d="M155.456 99.7711L121.082 100.082C120.716 100.085 120.422 100.388 120.426 100.757L120.501 109.057C120.504 109.427 120.803 109.724 121.169 109.721L155.543 109.41C155.909 109.407 156.203 109.104 156.2 108.734L156.125 100.435C156.122 100.065 155.822 99.7678 155.456 99.7711Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M-0.435314 49.6328C-2.11847 49.6328 -3.48293 48.2684 -3.48293 46.5852C-3.48293 44.9021 -2.11847 43.5376 -0.435314 43.5376C1.24784 43.5376 2.6123 44.9021 2.6123 46.5852C2.6123 48.2684 1.24784 49.6328 -0.435314 49.6328ZM-0.435316 48.8201C-1.66963 48.8201 -2.67024 47.8195 -2.67024 46.5852C-2.67024 45.3509 -1.66963 44.3502 -0.435316 44.3502C0.798997 44.3502 1.7996 45.3509 1.7996 46.5852C1.7996 47.8195 0.798997 48.8201 -0.435316 48.8201Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M122.011 17.9962C122.202 17.1805 119.987 15.9732 116.858 15.084C117.417 11.882 117.271 9.36956 116.455 9.18034C115.638 8.99112 114.406 11.1998 113.488 14.335C110.265 13.8091 107.74 13.9658 107.56 14.7858C107.379 15.6058 109.583 16.8106 112.712 17.698C112.162 20.9021 112.3 23.4124 113.114 23.6012C113.928 23.79 115.165 21.5822 116.082 18.447C119.305 18.9729 121.828 18.8158 122.011 17.9962Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M106.012 10H63.988C62.2824 10 60.5935 10.3363 59.0177 10.9896C57.442 11.6429 56.0102 12.6004 54.8041 13.8076C53.5981 15.0148 52.6413 16.4479 51.9886 18.0251C51.3359 19.6023 51 21.2928 51 23C51 24.7072 51.3359 26.3977 51.9886 27.9749C52.6413 29.5521 53.5981 30.9852 54.8041 32.1924C56.0102 33.3995 57.442 34.3571 59.0177 35.0104C60.5935 35.6637 62.2824 36 63.988 36H106.012C109.457 36 112.76 34.6304 115.196 32.1924C117.632 29.7544 119 26.4478 119 23C119 19.5522 117.632 16.2456 115.196 13.8076C112.76 11.3696 109.457 10 106.012 10V10Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M128.012 31H85.988C84.2824 31 82.5935 31.3363 81.0177 31.9896C79.442 32.6429 78.0102 33.6004 76.8041 34.8076C75.5981 36.0148 74.6413 37.4479 73.9886 39.0251C73.3359 40.6023 73 42.2928 73 44C73 45.7072 73.3359 47.3977 73.9886 48.9749C74.6413 50.5521 75.5981 51.9852 76.8041 53.1924C78.0102 54.3995 79.442 55.3571 81.0177 56.0104C82.5935 56.6637 84.2824 57 85.988 57H128.012C131.457 57 134.76 55.6304 137.196 53.1924C139.632 50.7544 141 47.4478 141 44C141 40.5522 139.632 37.2456 137.196 34.8076C134.76 32.3696 131.457 31 128.012 31V31Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
<path d="M113 44.9482C113 41.6345 110.314 38.9482 107 38.9482H31.2566C27.9429 38.9482 25.2566 41.6345 25.2566 44.9482V87.1275C25.2566 89.5944 27.2565 91.5943 29.7234 91.5943H33.7208C36.1455 91.5943 37.3887 94.4996 35.7146 96.2536V96.2536C33.4751 98.5998 36.4225 102.214 39.1713 100.493L52.2383 92.309C52.984 91.842 53.8461 91.5943 54.7261 91.5943H107C110.314 91.5943 113 88.908 113 85.5943V44.9482Z" style="fill:var(--sapContent_Illustrative_Color8)"/>
<path fill-rule="evenodd" clip-rule="evenodd" d="M36.1579 95.6485C36.2837 95.4172 36.3712 95.1758 36.4234 94.9312C36.4297 94.9017 36.4355 94.8721 36.4408 94.8425C36.4853 94.5928 36.4935 94.3406 36.4686 94.093C36.4428 93.8378 36.3819 93.5876 36.289 93.3499C35.6389 93.4156 35.0844 93.9042 34.964 94.5793C34.9263 94.7911 34.8271 95.0109 34.6295 95.2179C33.8513 96.0331 33.4577 97.0087 33.4254 97.9979C33.3984 98.8259 34.0477 99.519 34.8757 99.546C35.0216 99.5508 35.1633 99.5345 35.298 99.5C35.1706 99.2783 35.0722 99.0401 35.0082 98.7922C34.9459 98.5508 34.9164 98.3003 34.9246 98.0468C34.9299 97.887 34.9501 97.7261 34.9867 97.5656C35.0414 97.3256 35.1327 97.0865 35.2647 96.8538C35.3816 96.6476 35.5306 96.4463 35.7146 96.2536C35.8958 96.0637 36.0429 95.8603 36.1579 95.6485ZM43.7093 97.6505C44.149 98.3526 43.9363 99.2782 43.2342 99.7179L39.9675 101.764C39.0123 102.362 37.9775 102.551 37.0021 102.384C36.1856 102.244 35.6373 101.468 35.7774 100.652C35.8021 100.508 35.8465 100.372 35.9074 100.247C36.099 100.417 36.3125 100.561 36.5424 100.674C36.7664 100.783 37.0059 100.863 37.2558 100.905C37.8577 101.009 38.5201 100.9 39.1713 100.493L43.7093 97.6505ZM60.5822 91.5943C60.5822 92.4227 59.9106 93.0943 59.0822 93.0943H54.726C54.1277 93.0943 53.5415 93.2627 53.0344 93.5803L49.7677 95.6262C49.0656 96.0659 48.14 95.8532 47.7002 95.1511L52.2382 92.309C52.984 91.842 53.8461 91.5943 54.726 91.5943H60.5822ZM78.0069 91.5943C78.0069 92.4227 77.3353 93.0943 76.5069 93.0943H67.7945C66.9661 93.0943 66.2945 92.4227 66.2945 91.5943H78.0069ZM95.4315 91.5943C95.4315 92.4227 94.7599 93.0943 93.9315 93.0943H85.2192C84.3907 93.0943 83.7192 92.4227 83.7192 91.5943H95.4315ZM110.599 90.3951C110.63 90.4491 110.658 90.5056 110.682 90.5644C111 91.3297 110.637 92.2073 109.871 92.5246C108.985 92.8922 108.014 93.0943 107 93.0943H102.644C101.815 93.0943 101.144 92.4227 101.144 91.5943H107C107.814 91.5943 108.589 91.4324 109.297 91.139C109.529 91.0427 109.754 90.9323 109.97 90.8087C110.189 90.6839 110.399 90.5456 110.599 90.3951ZM113 80.7071C113.828 80.7071 114.5 81.3787 114.5 82.2071V85.5943C114.5 86.6085 114.298 87.5792 113.93 88.4656C113.613 89.2308 112.735 89.5939 111.97 89.2766C111.911 89.2522 111.855 89.2245 111.801 89.1937C111.951 88.9933 112.09 88.7832 112.214 88.5644C112.338 88.348 112.448 88.1232 112.545 87.891C112.838 87.1836 113 86.4078 113 85.5943V80.7071ZM113 67.1584C113.828 67.1584 114.5 67.83 114.5 68.6584V75.4328C114.5 76.2612 113.828 76.9328 113 76.9328V67.1584ZM113 53.6098C113.828 53.6098 114.5 54.2813 114.5 55.1098V61.8841C114.5 62.7125 113.828 63.3841 113 63.3841V53.6098ZM111.801 41.3488C111.855 41.3181 111.911 41.2903 111.97 41.2659C112.735 40.9486 113.613 41.3117 113.93 42.0769C114.298 42.9633 114.5 43.9341 114.5 44.9482V48.3354C114.5 49.1638 113.828 49.8354 113 49.8354V44.9482C113 44.1347 112.838 43.359 112.545 42.6515C112.448 42.4193 112.338 42.1945 112.214 41.9781C112.09 41.7593 111.951 41.5492 111.801 41.3488ZM101.713 38.9482C101.713 38.1198 102.384 37.4482 103.213 37.4482H107C108.014 37.4482 108.985 37.6504 109.871 38.0179C110.637 38.3353 111 39.2129 110.682 39.9781C110.658 40.037 110.63 40.0934 110.599 40.1474C110.399 39.9969 110.189 39.8587 109.97 39.7338C109.754 39.6103 109.529 39.4998 109.297 39.4035C108.589 39.1102 107.814 38.9482 107 38.9482H101.713ZM86.5641 38.9482C86.5641 38.1198 87.2357 37.4482 88.0641 37.4482H95.6385C96.4669 37.4482 97.1385 38.1198 97.1385 38.9482H86.5641ZM71.4155 38.9482C71.4155 38.1198 72.087 37.4482 72.9155 37.4482H80.4898C81.3182 37.4482 81.9898 38.1198 81.9898 38.9482H71.4155ZM56.2668 38.9482C56.2668 38.1198 56.9383 37.4482 57.7668 37.4482H65.3411C66.1695 37.4482 66.8411 38.1198 66.8411 38.9482H56.2668ZM41.1181 38.9482C41.1181 38.1198 41.7897 37.4482 42.6181 37.4482H50.1924C51.0209 37.4482 51.6924 38.1198 51.6924 38.9482H41.1181ZM36.5438 38.9482C36.5438 38.1198 35.8722 37.4482 35.0438 37.4482H31.2566C30.2424 37.4482 29.2717 37.6504 28.3853 38.0179C27.62 38.3353 27.2569 39.2129 27.5743 39.9781C27.5987 40.037 27.6264 40.0934 27.6571 40.1474C27.8575 39.9969 28.0677 39.8586 28.2865 39.7338C28.5028 39.6102 28.7277 39.4998 28.9599 39.4035C29.6673 39.1102 30.443 38.9482 31.2566 38.9482H36.5438ZM25.2566 49.9632C24.4282 49.9632 23.7566 49.2916 23.7566 48.4632V44.9482C23.7566 43.9341 23.9587 42.9633 24.3263 42.0769C24.6436 41.3117 25.5212 40.9486 26.2865 41.2659C26.3453 41.2903 26.4018 41.3181 26.4557 41.3488C26.3052 41.5492 26.167 41.7593 26.0421 41.9781C25.9186 42.1945 25.8082 42.4193 25.7119 42.6515C25.4185 43.359 25.2566 44.1347 25.2566 44.9482V49.9632ZM25.2566 64.0229C24.4282 64.0229 23.7566 63.3514 23.7566 62.5229V55.4931C23.7566 54.6646 24.4282 53.993 25.2566 53.993V64.0229ZM25.2566 78.0827C24.4282 78.0827 23.7566 77.4111 23.7566 76.5827V69.5528C23.7566 68.7244 24.4282 68.0528 25.2566 68.0528V78.0827ZM26.3952 90.1067C26.3247 90.151 26.2496 90.19 26.1701 90.2229C25.4049 90.5402 24.5273 90.1771 24.2099 89.4119C23.9173 88.7063 23.7566 87.9338 23.7566 87.1275V83.6125C23.7566 82.7841 24.4282 82.1125 25.2566 82.1125V87.1275C25.2566 87.7331 25.3771 88.3106 25.5955 88.8373C25.692 89.0699 25.8075 89.2926 25.9402 89.5035C26.0749 89.7174 26.2272 89.9192 26.3952 90.1067ZM36.2178 93.1836C36.11 92.9523 35.9711 92.7354 35.8043 92.5406C35.6424 92.3516 35.4542 92.1834 35.2429 92.0432C34.8202 91.7628 34.3047 91.5943 33.7207 91.5943H29.7234C29.1177 91.5943 28.5402 91.4737 28.0136 91.2553C27.7809 91.1589 27.5582 91.0433 27.3474 90.9106C27.1334 90.776 26.9317 90.6236 26.7442 90.4557C26.6999 90.5262 26.6609 90.6013 26.628 90.6808C26.3106 91.446 26.6737 92.3236 27.439 92.6409C28.1446 92.9335 28.9171 93.0943 29.7234 93.0943H30.7227C31.1066 93.0943 31.4568 92.9501 31.7221 92.7129C31.9874 92.9501 32.3375 93.0943 32.7214 93.0943H33.7207C34.0069 93.0943 34.2344 93.1742 34.4137 93.2932C34.9851 93.6723 35.7214 93.6085 36.2178 93.1836Z" style="fill:var(--sapContent_Illustrative_Color3)"/>
<path d="M78.4618 66.2692C78.4618 68.627 80.3732 70.5384 82.731 70.5384C85.0889 70.5384 87.0002 68.627 87.0002 66.2692C87.0002 63.9114 85.0889 62 82.731 62C80.3732 62 78.4618 63.9114 78.4618 66.2692Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M50 66.2692C50 68.627 51.9114 70.5384 54.2692 70.5384C56.6271 70.5384 58.5385 68.627 58.5385 66.2692C58.5385 63.9114 56.6271 62 54.2692 62C51.9114 62 50 63.9114 50 66.2692Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M64.2311 66.2692C64.2311 68.627 66.1425 70.5384 68.5003 70.5384C70.8581 70.5384 72.7695 68.627 72.7695 66.2692C72.7695 63.9114 70.8581 62 68.5003 62C66.1425 62 64.2311 63.9114 64.2311 66.2692Z" style="fill:var(--sapContent_Illustrative_Color14)"/>
<path d="M27.0133 24.3295C27.1565 24.3099 27.3021 24.3218 27.441 24.3647C27.5798 24.4075 27.7087 24.4802 27.8194 24.5783C27.9302 24.6763 28.0204 24.7974 28.0842 24.934C28.1481 25.0705 28.1842 25.2194 28.1903 25.3712L28.6013 30.2737C28.6155 30.45 28.5962 30.6274 28.5444 30.7955C28.4926 30.9636 28.4095 31.1191 28.2998 31.2528C28.1902 31.3866 28.0562 31.4959 27.9057 31.5744C27.7552 31.6529 27.5912 31.6991 27.4233 31.7102C27.3542 31.7168 27.2846 31.7174 27.2154 31.7121C26.9593 31.6962 26.7177 31.5801 26.5384 31.3866C26.3591 31.1931 26.2549 30.9362 26.2466 30.6667L25.8369 25.7663C25.8224 25.5901 25.8415 25.4127 25.893 25.2445C25.9446 25.0764 26.0276 24.9209 26.1371 24.7871C26.2466 24.6533 26.3805 24.5439 26.531 24.4653C26.6814 24.3868 26.8454 24.3406 27.0133 24.3295Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M14.6627 29.4537C14.8203 29.443 14.9784 29.4661 15.1272 29.5217C15.276 29.5773 15.4124 29.6642 15.5282 29.7771L20.7687 34.7858C21.0025 35.0119 21.1441 35.3241 21.1639 35.6572C21.1836 35.9904 21.08 36.3186 20.8747 36.5734C20.6834 36.8089 20.4148 36.9602 20.1222 36.9974C19.9535 37.0185 19.7824 37.0012 19.6207 36.9467C19.459 36.8921 19.3103 36.8015 19.1849 36.6812L13.9444 31.6725C13.7091 31.4454 13.5668 31.1313 13.5473 30.7963C13.5278 30.4613 13.6328 30.1314 13.8401 29.8759C13.943 29.751 14.069 29.6492 14.2104 29.5766C14.3517 29.5041 14.5056 29.4623 14.6627 29.4537V29.4537Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M10.4076 44.3319C10.5022 44.144 10.6432 43.9862 10.8156 43.875C10.9881 43.7639 11.1857 43.7036 11.3876 43.7004L16.1885 43.4932C16.9825 43.4586 17.4341 44.1297 17.4572 44.7839C17.476 45.0513 17.4117 45.3182 17.274 45.5445C17.1363 45.7708 16.9326 45.9442 16.6935 46.0388C16.5768 46.0809 16.4547 46.1042 16.3314 46.108L11.5305 46.3151C11.32 46.3287 11.1102 46.2823 10.9232 46.1808C10.7362 46.0792 10.5791 45.9263 10.4683 45.7382C10.3451 45.5291 10.2749 45.2902 10.2642 45.0441C10.2536 44.798 10.3029 44.5528 10.4076 44.3319Z" style="fill:var(--sapContent_Illustrative_Color5)"/>
<path d="M40.0119 106H-2.01198C-3.71759 106 -5.40648 106.336 -6.98227 106.99C-8.55805 107.643 -9.98983 108.6 -11.1959 109.808C-12.4019 111.015 -13.3587 112.448 -14.0114 114.025C-14.6641 115.602 -15 117.293 -15 119C-15 120.707 -14.6641 122.398 -14.0114 123.975C-13.3587 125.552 -12.4019 126.985 -11.1959 128.192C-9.98983 129.4 -8.55805 130.357 -6.98227 131.01C-5.40648 131.664 -3.71759 132 -2.01198 132H40.0119C43.4566 132 46.7601 130.63 49.1959 128.192C51.6316 125.754 53 122.448 53 119C53 115.552 51.6316 112.246 49.1959 109.808C46.7601 107.37 43.4566 106 40.0119 106V106Z" style="fill:var(--sapContent_Illustrative_Color18)"/>
</g>
</g>
<defs>
<clipPath id="clip0_49_23917">
<rect width="128" height="128" style="fill:var(--sapContent_Illustrative_Color8)"/>
</clipPath>
</defs>
</svg>
`, Al = { key: "IM_TITLE_BEFORESEARCH", defaultText: "Let''s get some results" }, Sl = { key: "IM_SUBTITLE_BEFORESEARCH", defaultText: "Start by providing your search criteria." }, Ga = { key: "IM_TITLE_SURVEY", defaultText: "Your Opinion Matters" }, ja = { key: "IM_SUBTITLE_SURVEY", defaultText: "We want to hear what you think about SAP software. Share your feedback with us by taking our short survey. It will only take a few minutes." }, qa = "Survey", Za = "fiori", Wa = Ga, Ya = ja;
ka(qa, {
  dialogSvg: $a,
  sceneSvg: Fa,
  spotSvg: za,
  title: Wa,
  subtitle: Ya,
  set: Za
});
var _n = {}, hn = _n.hasOwnProperty, Qa = _n.toString, fn = hn.toString, Ja = fn.call(Object), io = function(t) {
  var e, r;
  return !t || Qa.call(t) !== "[object Object]" ? !1 : (e = Object.getPrototypeOf(t), e ? (r = hn.call(e, "constructor") && e.constructor, typeof r == "function" && fn.call(r) === Ja) : !0);
}, Xa = /* @__PURE__ */ Object.create(null), Cn = function(t, e, r, n) {
  var _, I, v, h, p, f, d = arguments[2] || {}, g = 3, C = arguments.length, c = arguments[0] || !1, l = arguments[1] ? void 0 : Xa;
  for (typeof d != "object" && typeof d != "function" && (d = {}); g < C; g++)
    if ((p = arguments[g]) != null)
      for (h in p)
        _ = d[h], v = p[h], !(h === "__proto__" || d === v) && (c && v && (io(v) || (I = Array.isArray(v))) ? (I ? (I = !1, f = _ && Array.isArray(_) ? _ : []) : f = _ && io(_) ? _ : {}, d[h] = Cn(c, arguments[1], f, v)) : v !== l && (d[h] = v));
  return d;
};
const gn = function(t, e) {
  return Cn(!0, !1, ...arguments);
}, mn = /* @__PURE__ */ new Map(), es = (t, e) => {
  mn.set(t, e);
}, yn = (t) => mn.get(t), ht = { themes: { default: "sap_fiori_3", all: ["sap_fiori_3", "sap_fiori_3_dark", "sap_belize", "sap_belize_hcb", "sap_belize_hcw", "sap_fiori_3_hcb", "sap_fiori_3_hcw", "sap_horizon", "sap_horizon_dark", "sap_horizon_hcb", "sap_horizon_hcw", "sap_horizon_exp"] }, languages: { default: "en", all: ["ar", "bg", "ca", "cs", "cy", "da", "de", "el", "en", "en_GB", "en_US_sappsd", "en_US_saprigi", "en_US_saptrc", "es", "es_MX", "et", "fi", "fr", "fr_CA", "hi", "hr", "hu", "in", "it", "iw", "ja", "kk", "ko", "lt", "lv", "ms", "nl", "no", "pl", "pt_PT", "pt", "ro", "ru", "sh", "sk", "sl", "sv", "th", "tr", "uk", "vi", "zh_CN", "zh_TW"] }, locales: { default: "en", all: ["ar", "ar_EG", "ar_SA", "bg", "ca", "cs", "da", "de", "de_AT", "de_CH", "el", "el_CY", "en", "en_AU", "en_GB", "en_HK", "en_IE", "en_IN", "en_NZ", "en_PG", "en_SG", "en_ZA", "es", "es_AR", "es_BO", "es_CL", "es_CO", "es_MX", "es_PE", "es_UY", "es_VE", "et", "fa", "fi", "fr", "fr_BE", "fr_CA", "fr_CH", "fr_LU", "he", "hi", "hr", "hu", "id", "it", "it_CH", "ja", "kk", "ko", "lt", "lv", "ms", "nb", "nl", "nl_BE", "pl", "pt", "pt_PT", "ro", "ru", "ru_UA", "sk", "sl", "sr", "sr_Latn", "sv", "th", "tr", "uk", "vi", "zh_CN", "zh_HK", "zh_SG", "zh_TW"] } }, it = ht.themes.default, ts = ht.themes.all, ft = ht.languages.default, ye = ht.locales.default, rs = (t) => {
  const e = document.querySelector(`META[name="${t}"]`);
  return e && e.getAttribute("content");
}, os = (t) => {
  const e = rs("sap-allowedThemeOrigins");
  return e && e.split(",").some((r) => r === "*" || t === r.trim());
}, ns = (t, e) => {
  const r = new URL(t).pathname;
  return new URL(r, e).toString();
}, is = (t) => {
  let e;
  try {
    if (t.startsWith(".") || t.startsWith("/"))
      e = new URL(t, window.location.href).toString();
    else {
      const r = new URL(t), n = r.origin;
      n && os(n) ? e = r.toString() : e = ns(r.toString(), window.location.href);
    }
    return e.endsWith("/") || (e = `${e}/`), `${e}UI5/`;
  } catch (r) {
  }
};
var tr;
(function(t) {
  t.Full = "full", t.Basic = "basic", t.Minimal = "minimal", t.None = "none";
})(tr || (tr = {}));
const as = tr;
let ao = !1, J = {
  animationMode: as.Full,
  theme: it,
  themeRoot: void 0,
  rtl: void 0,
  language: void 0,
  timezone: void 0,
  calendarType: void 0,
  noConflict: !1,
  formatSettings: {},
  fetchDefaultLanguage: !1
};
const ss = () => (Ct(), J.theme), us = () => (Ct(), J.themeRoot), ls = () => (Ct(), J.language), cs = () => (Ct(), J.fetchDefaultLanguage), at = /* @__PURE__ */ new Map();
at.set("true", !0);
at.set("false", !1);
const ds = () => {
  const t = document.querySelector("[data-ui5-config]") || document.querySelector("[data-id='sap-ui-config']");
  let e;
  if (t) {
    try {
      e = JSON.parse(t.innerHTML);
    } catch (r) {
      console.warn("Incorrect data-sap-ui-config format. Please use JSON");
    }
    e && (J = gn(J, e));
  }
}, ps = () => {
  const t = new URLSearchParams(window.location.search);
  t.forEach((e, r) => {
    const n = r.split("sap-").length;
    n === 0 || n === r.split("sap-ui-").length || so(r, e, "sap");
  }), t.forEach((e, r) => {
    !r.startsWith("sap-ui") || so(r, e, "sap-ui");
  });
}, _s = (t) => {
  const e = t.split("@")[1];
  return is(e);
}, hs = (t, e) => t === "theme" && e.includes("@") ? e.split("@")[0] : e, so = (t, e, r) => {
  const n = e.toLowerCase(), _ = t.split(`${r}-`)[1];
  at.has(e) && (e = at.get(n)), _ === "theme" ? (J.theme = hs(_, e), e && e.includes("@") && (J.themeRoot = _s(e))) : J[_] = e;
}, fs = () => {
  const t = yn("OpenUI5Support");
  if (!t || !t.isOpenUI5Detected())
    return;
  const e = t.getConfigurationSettingsObject();
  J = gn(J, e);
}, Ct = () => {
  typeof document == "undefined" || ao || (ds(), ps(), fs(), ao = !0);
};
class gt {
  constructor() {
    this._eventRegistry = /* @__PURE__ */ new Map();
  }
  attachEvent(e, r) {
    const n = this._eventRegistry, _ = n.get(e);
    if (!Array.isArray(_)) {
      n.set(e, [r]);
      return;
    }
    _.includes(r) || _.push(r);
  }
  detachEvent(e, r) {
    const n = this._eventRegistry, _ = n.get(e);
    if (!_)
      return;
    const I = _.indexOf(r);
    I !== -1 && _.splice(I, 1), _.length === 0 && n.delete(e);
  }
  fireEvent(e, r) {
    const _ = this._eventRegistry.get(e);
    return _ ? _.map((I) => I.call(this, r)) : [];
  }
  fireEventAsync(e, r) {
    return Promise.all(this.fireEvent(e, r));
  }
  isHandlerAttached(e, r) {
    const _ = this._eventRegistry.get(e);
    return _ ? _.includes(r) : !1;
  }
  hasListeners(e) {
    return !!this._eventRegistry.get(e);
  }
}
const uo = 10;
class Cs {
  constructor() {
    this.list = [], this.lookup = /* @__PURE__ */ new Set();
  }
  add(e) {
    this.lookup.has(e) || (this.list.push(e), this.lookup.add(e));
  }
  remove(e) {
    !this.lookup.has(e) || (this.list = this.list.filter((r) => r !== e), this.lookup.delete(e));
  }
  shift() {
    const e = this.list.shift();
    if (e)
      return this.lookup.delete(e), e;
  }
  isEmpty() {
    return this.list.length === 0;
  }
  isAdded(e) {
    return this.lookup.has(e);
  }
  process(e) {
    let r;
    const n = /* @__PURE__ */ new Map();
    for (r = this.shift(); r; ) {
      const _ = n.get(r) || 0;
      if (_ > uo)
        throw new Error(`Web component processed too many times this task, max allowed is: ${uo}`);
      e(r), n.set(r, _ + 1), r = this.shift();
    }
  }
}
const gs = (t, e = document.body, r) => {
  let n = document.querySelector(t);
  return n || (n = r ? r() : document.createElement(t), e.insertBefore(n, e.firstChild));
}, ms = () => {
  const t = document.createElement("meta");
  return t.setAttribute("name", "ui5-shared-resources"), t.setAttribute("content", ""), t;
}, ys = () => typeof document == "undefined" ? null : gs('meta[name="ui5-shared-resources"]', document.head, ms), ke = (t, e) => {
  const r = t.split(".");
  let n = ys();
  if (!n)
    return e;
  for (let _ = 0; _ < r.length; _++) {
    const I = r[_], v = _ === r.length - 1;
    Object.prototype.hasOwnProperty.call(n, I) || (n[I] = v ? e : {}), n = n[I];
  }
  return n;
};
let Ts;
ke("Runtimes", []);
const fr = () => Ts;
ke("Tags", /* @__PURE__ */ new Map());
const vs = /* @__PURE__ */ new Set(), bs = () => [...vs.values()], Is = /* @__PURE__ */ new Set(), Es = (t) => Is.has(t), Tn = /* @__PURE__ */ new Set(), As = new gt(), Ve = new Cs();
let he, Ye, zt, je;
const Ss = (t) => R(void 0, null, function* () {
  Ve.add(t), yield ws();
}), Ps = (t) => {
  As.fireEvent("beforeComponentRender", t), Tn.add(t), t._render();
}, ws = () => R(void 0, null, function* () {
  je || (je = new Promise((t) => {
    window.requestAnimationFrame(() => {
      Ve.process(Ps), je = null, t(), zt || (zt = setTimeout(() => {
        zt = void 0, Ve.isEmpty() && Ls();
      }, 200));
    });
  })), yield je;
}), Ds = () => he || (he = new Promise((t) => {
  Ye = t, window.requestAnimationFrame(() => {
    Ve.isEmpty() && (he = void 0, t());
  });
}), he), Bs = () => {
  const t = bs().map((e) => customElements.whenDefined(e));
  return Promise.all(t);
}, Us = () => R(void 0, null, function* () {
  yield Bs(), yield Ds();
}), Ls = () => {
  !Ve.isEmpty() || Ye && (Ye(), Ye = void 0, he = void 0);
}, Ns = (t) => R(void 0, null, function* () {
  Tn.forEach((e) => {
    const r = e.constructor, n = r.getMetadata().getTag(), _ = Es(r), I = r.getMetadata().isLanguageAware(), v = r.getMetadata().isThemeAware();
    (!t || t.tag === n || t.rtlAware && _ || t.languageAware && I || t.themeAware && v) && Ss(e);
  }), yield Us();
});
new gt();
const vn = /* @__PURE__ */ new Map(), Os = /* @__PURE__ */ new Map(), Vs = /* @__PURE__ */ new Set(), rr = /* @__PURE__ */ new Set(), bn = (t, e) => R(void 0, null, function* () {
  const r = vn.get(`${t}_${e}`);
  if (r !== void 0)
    return r;
  if (!rr.has(e)) {
    const n = [...rr.values()].join(", ");
    return console.warn(`You have requested a non-registered theme ${e} - falling back to ${it}. Registered themes are: ${n}`), lo(t, it);
  }
  return lo(t, e);
}), lo = (t, e) => R(void 0, null, function* () {
  const r = Os.get(`${t}/${e}`);
  if (!r) {
    console.error(`Theme [${e}] not registered for package [${t}]`);
    return;
  }
  let n;
  try {
    n = yield r(e);
  } catch (I) {
    console.error(t, I.message);
    return;
  }
  const _ = n._ || n;
  return vn.set(`${t}_${e}`, _), _;
}), In = () => Vs, Rs = (t) => rr.has(t), xs = (t, e) => {
  const r = document.createElement("style");
  return r.type = "text/css", e && Object.entries(e).forEach((n) => r.setAttribute(...n)), r.textContent = t, document.head.appendChild(r), r;
}, Ks = (t, e) => {
  const r = document.createElement("link");
  return r.type = "text/css", r.rel = "stylesheet", e && Object.entries(e).forEach((n) => r.setAttribute(...n)), r.href = t, document.head.appendChild(r), new Promise((n) => {
    r.addEventListener("load", n), r.addEventListener("error", n);
  });
}, mt = (t, e) => e ? `${t}|${e}` : t, Ms = (t, e, r = "") => {
  let n = typeof t == "string" ? t : t.content;
  if (n.includes("[_ui5host]") && (n = n.replaceAll("[_ui5host]", `[_ui5rt${fr()}]`)), document.adoptedStyleSheets) {
    const _ = new CSSStyleSheet();
    _.replaceSync(n), _._ui5StyleId = mt(e, r), document.adoptedStyleSheets = [...document.adoptedStyleSheets, _];
  } else {
    const _ = {};
    _[e] = r, xs(n, _);
  }
}, ks = (t, e, r = "") => {
  let n = typeof t == "string" ? t : t.content;
  if (n.includes("[_ui5host]") && (n = n.replaceAll("[_ui5host]", `[_ui5rt${fr()}]`)), document.adoptedStyleSheets) {
    const _ = document.adoptedStyleSheets.find((I) => I._ui5StyleId === mt(e, r));
    _ && _.replaceSync(n || "");
  } else {
    const _ = document.querySelector(`head>style[${e}="${r}"]`);
    _ && (_.textContent = n || "");
  }
}, Hs = (t, e = "") => document.adoptedStyleSheets ? !!document.adoptedStyleSheets.find((r) => r._ui5StyleId === mt(t, e)) : !!document.querySelector(`head>style[${t}="${e}"]`), $s = (t, e = "") => {
  var r;
  if (document.adoptedStyleSheets)
    document.adoptedStyleSheets = document.adoptedStyleSheets.filter((n) => n._ui5StyleId !== mt(t, e));
  else {
    const n = document.querySelector(`head > style[${t}="${e}"]`);
    (r = n == null ? void 0 : n.parentElement) == null || r.removeChild(n);
  }
}, En = (t, e, r = "") => {
  Hs(e, r) ? ks(t, e, r) : Ms(t, e, r);
}, fe = /* @__PURE__ */ new Set(), Fs = () => {
  let t = document.querySelector(".sapThemeMetaData-Base-baseLib") || document.querySelector(".sapThemeMetaData-UI5-sap-ui-core");
  if (t)
    return getComputedStyle(t).backgroundImage;
  t = document.createElement("span"), t.style.display = "none", t.classList.add("sapThemeMetaData-Base-baseLib"), document.body.appendChild(t);
  let e = getComputedStyle(t).backgroundImage;
  return e === "none" && (t.classList.add("sapThemeMetaData-UI5-sap-ui-core"), e = getComputedStyle(t).backgroundImage), document.body.removeChild(t), e;
}, zs = (t) => {
  const e = /\(["']?data:text\/plain;utf-8,(.*?)['"]?\)$/i.exec(t);
  if (e && e.length >= 2) {
    let r = e[1];
    if (r = r.replace(/\\"/g, '"'), r.charAt(0) !== "{" && r.charAt(r.length - 1) !== "}")
      try {
        r = decodeURIComponent(r);
      } catch (n) {
        fe.has("decode") || (console.warn("Malformed theme metadata string, unable to decodeURIComponent"), fe.add("decode"));
        return;
      }
    try {
      return JSON.parse(r);
    } catch (n) {
      fe.has("parse") || (console.warn("Malformed theme metadata string, unable to parse JSON"), fe.add("parse"));
    }
  }
}, Gs = (t) => {
  let e, r;
  try {
    e = t.Path.match(/\.([^.]+)\.css_variables$/)[1], r = t.Extends[0];
  } catch (n) {
    fe.has("object") || (console.warn("Malformed theme metadata Object", t), fe.add("object"));
    return;
  }
  return {
    themeName: e,
    baseThemeName: r
  };
}, or = () => {
  const t = Fs();
  if (!t || t === "none")
    return;
  const e = zs(t);
  if (e)
    return Gs(e);
}, js = new gt(), qs = "themeLoaded", Zs = (t) => js.fireEvent(qs, t);
let Gt;
const An = () => (Gt === void 0 && (Gt = us()), Gt), Ws = (t) => `${An()}Base/baseLib/${t}/css_variables.css`, Ys = (t) => R(void 0, null, function* () {
  const e = document.querySelector(`[sap-ui-webcomponents-theme="${t}"]`);
  e && document.head.removeChild(e), yield Ks(Ws(t), { "sap-ui-webcomponents-theme": t });
}), Qs = ke("PopupUtilsData", { currentZIndex: 100 }), co = () => Qs.currentZIndex;
class W {
  static isAtLeastVersion116() {
    const r = window.sap.ui.version.split(".");
    return !r || r.length < 2 ? !1 : parseInt(r[0]) > 1 || parseInt(r[1]) >= 116;
  }
  static isOpenUI5Detected() {
    var e, r;
    return typeof ((r = (e = window.sap) == null ? void 0 : e.ui) == null ? void 0 : r.require) == "function";
  }
  static init() {
    return W.isOpenUI5Detected() ? new Promise((e) => {
      window.sap.ui.require(["sap/ui/core/Core"], (r) => R(this, null, function* () {
        const n = () => {
          let _ = ["sap/ui/core/Popup", "sap/ui/core/LocaleData"];
          W.isAtLeastVersion116() && (_ = [
            ..._,
            "sap/base/i18n/Formatting",
            "sap/base/i18n/Localization",
            "sap/ui/core/ControlBehavior",
            "sap/ui/core/Theming",
            "sap/ui/core/date/CalendarUtils"
          ]), window.sap.ui.require(_, (I) => {
            I.setInitialZIndex(co()), e();
          });
        };
        W.isAtLeastVersion116() ? (yield r.ready(), n()) : r.attachInit(n);
      }));
    }) : Promise.resolve();
  }
  static getConfigurationSettingsObject() {
    if (!W.isOpenUI5Detected())
      return {};
    if (W.isAtLeastVersion116()) {
      const _ = window.sap.ui.require("sap/ui/core/ControlBehavior"), I = window.sap.ui.require("sap/base/i18n/Localization"), v = window.sap.ui.require("sap/ui/core/Theming"), h = window.sap.ui.require("sap/base/i18n/Formatting"), p = window.sap.ui.require("sap/ui/core/date/CalendarUtils");
      return {
        animationMode: _.getAnimationMode(),
        language: I.getLanguage(),
        theme: v.getTheme(),
        themeRoot: v.getThemeRoot(),
        rtl: I.getRTL(),
        timezone: I.getTimezone(),
        calendarType: h.getCalendarType(),
        formatSettings: {
          firstDayOfWeek: p.getWeekConfigurationValues().firstDayOfWeek,
          legacyDateCalendarCustomizing: h.getLegacyDateCalendarCustomizing()
        }
      };
    }
    const r = window.sap.ui.require("sap/ui/core/Core").getConfiguration(), n = window.sap.ui.require("sap/ui/core/LocaleData");
    return {
      animationMode: r.getAnimationMode(),
      language: r.getLanguage(),
      theme: r.getTheme(),
      themeRoot: r.getThemeRoot(),
      rtl: r.getRTL(),
      timezone: r.getTimezone(),
      calendarType: r.getCalendarType(),
      formatSettings: {
        firstDayOfWeek: n ? n.getInstance(r.getLocale()).getFirstDayOfWeek() : void 0,
        legacyDateCalendarCustomizing: r.getFormatSettings().getLegacyDateCalendarCustomizing()
      }
    };
  }
  static getLocaleDataObject() {
    if (!W.isOpenUI5Detected())
      return;
    const e = window.sap.ui.require("sap/ui/core/LocaleData");
    if (W.isAtLeastVersion116()) {
      const _ = window.sap.ui.require("sap/base/i18n/Localization");
      return e.getInstance(_.getLanguageTag())._get();
    }
    const n = window.sap.ui.require("sap/ui/core/Core").getConfiguration();
    return e.getInstance(n.getLocale())._get();
  }
  static _listenForThemeChange() {
    if (W.isAtLeastVersion116()) {
      const e = window.sap.ui.require("sap/ui/core/Theming");
      e.attachApplied(() => {
        po(e.getTheme());
      });
    } else {
      const e = window.sap.ui.require("sap/ui/core/Core"), r = e.getConfiguration();
      e.attachThemeChanged(() => {
        po(r.getTheme());
      });
    }
  }
  static attachListeners() {
    !W.isOpenUI5Detected() || W._listenForThemeChange();
  }
  static cssVariablesLoaded() {
    if (!W.isOpenUI5Detected())
      return;
    const e = [...document.head.children].find((r) => r.id === "sap-ui-theme-sap.ui.core");
    return e ? !!e.href.match(/\/css(-|_)variables\.css/) : !1;
  }
  static getNextZIndex() {
    if (!W.isOpenUI5Detected())
      return;
    const e = window.sap.ui.require("sap/ui/core/Popup");
    return e || console.warn(`The OpenUI5Support feature hasn't been initialized properly. Make sure you import the "@ui5/webcomponents-base/dist/features/OpenUI5Support.js" module before all components' modules.`), e.getNextZIndex();
  }
  static setInitialZIndex() {
    if (!W.isOpenUI5Detected())
      return;
    window.sap.ui.require("sap/ui/core/Popup").setInitialZIndex(co());
  }
}
es("OpenUI5Support", W);
const Re = "@ui5/webcomponents-theming", Js = () => In().has(Re), Xs = (t) => R(void 0, null, function* () {
  if (!Js())
    return;
  const e = yield bn(Re, t);
  e && En(e, "data-ui5-theme-properties", Re);
}), eu = () => {
  $s("data-ui5-theme-properties", Re);
}, tu = (t) => R(void 0, null, function* () {
  const r = [...In()].map((n) => R(void 0, null, function* () {
    if (n === Re)
      return;
    const _ = yield bn(n, t);
    _ && En(_, `data-ui5-component-properties-${fr()}`, n);
  }));
  return Promise.all(r);
}), ru = (t) => R(void 0, null, function* () {
  var n;
  const e = or();
  if (e)
    return e;
  const r = yn("OpenUI5Support");
  if (r && W.isOpenUI5Detected()) {
    if (r.cssVariablesLoaded())
      return {
        themeName: (n = r.getConfigurationSettingsObject()) == null ? void 0 : n.theme,
        baseThemeName: ""
      };
  } else if (An())
    return yield Ys(t), or();
}), ou = (t) => R(void 0, null, function* () {
  const e = yield ru(t);
  !e || t !== e.themeName ? yield Xs(t) : eu();
  const r = Rs(t) ? t : e && e.baseThemeName;
  yield tu(r || it), Zs(t);
});
let Te;
const nu = () => (Te === void 0 && (Te = ss()), Te), po = (t) => R(void 0, null, function* () {
  Te !== t && (Te = t, yield ou(Te), yield Ns({ themeAware: !0 }));
}), iu = () => {
  var e, r;
  const t = nu();
  return au(t) ? !t.startsWith("sap_horizon") : !((r = (e = or()) == null ? void 0 : e.baseThemeName) != null && r.startsWith("sap_horizon"));
}, au = (t) => ts.includes(t);
var _o;
(function(t) {
  t["SAP-icons"] = "SAP-icons-v4", t.horizon = "SAP-icons-v5", t["SAP-icons-TNT"] = "tnt", t.BusinessSuiteInAppSymbols = "business-suite";
})(_o || (_o = {}));
var ne;
(function(t) {
  t.SAPIconsV4 = "SAP-icons-v4", t.SAPIconsV5 = "SAP-icons-v5", t.SAPIconsTNTV2 = "tnt-v2", t.SAPIconsTNTV3 = "tnt-v3", t.SAPBSIconsV1 = "business-suite-v1", t.SAPBSIconsV2 = "business-suite-v2";
})(ne || (ne = {}));
const Cr = /* @__PURE__ */ new Map();
Cr.set("SAP-icons", {
  legacy: ne.SAPIconsV4,
  sap_horizon: ne.SAPIconsV5
});
Cr.set("tnt", {
  legacy: ne.SAPIconsTNTV2,
  sap_horizon: ne.SAPIconsTNTV3
});
Cr.set("business-suite", {
  legacy: ne.SAPBSIconsV1,
  sap_horizon: ne.SAPBSIconsV2
});
const su = () => {
  const t = navigator.languages, e = () => navigator.language;
  return t && t[0] || e() || ft;
}, uu = new gt(), lu = "languageChange", cu = (t) => {
  uu.attachEvent(lu, t);
};
let jt, nr;
const du = () => (jt === void 0 && (jt = ls()), jt), pu = (t) => {
  nr = t;
}, _u = () => (nr === void 0 && pu(cs()), nr), hu = /^((?:[A-Z]{2,3}(?:-[A-Z]{3}){0,3})|[A-Z]{4}|[A-Z]{5,8})(?:-([A-Z]{4}))?(?:-([A-Z]{2}|[0-9]{3}))?((?:-[0-9A-Z]{5,8}|-[0-9][0-9A-Z]{3})*)((?:-[0-9A-WYZ](?:-[0-9A-Z]{2,8})+)*)(?:-(X(?:-[0-9A-Z]{1,8})+))?$/i;
class Sn {
  constructor(e) {
    const r = hu.exec(e.replace(/_/g, "-"));
    if (r === null)
      throw new Error(`The given language ${e} does not adhere to BCP-47.`);
    this.sLocaleId = e, this.sLanguage = r[1] || ft, this.sScript = r[2] || "", this.sRegion = r[3] || "", this.sVariant = r[4] && r[4].slice(1) || null, this.sExtension = r[5] && r[5].slice(1) || null, this.sPrivateUse = r[6] || null, this.sLanguage && (this.sLanguage = this.sLanguage.toLowerCase()), this.sScript && (this.sScript = this.sScript.toLowerCase().replace(/^[a-z]/, (n) => n.toUpperCase())), this.sRegion && (this.sRegion = this.sRegion.toUpperCase());
  }
  getLanguage() {
    return this.sLanguage;
  }
  getScript() {
    return this.sScript;
  }
  getRegion() {
    return this.sRegion;
  }
  getVariant() {
    return this.sVariant;
  }
  getVariantSubtags() {
    return this.sVariant ? this.sVariant.split("-") : [];
  }
  getExtension() {
    return this.sExtension;
  }
  getExtensionSubtags() {
    return this.sExtension ? this.sExtension.slice(2).split("-") : [];
  }
  getPrivateUse() {
    return this.sPrivateUse;
  }
  getPrivateUseSubtags() {
    return this.sPrivateUse ? this.sPrivateUse.slice(2).split("-") : [];
  }
  hasPrivateUseSubtag(e) {
    return this.getPrivateUseSubtags().indexOf(e) >= 0;
  }
  toString() {
    const e = [this.sLanguage];
    return this.sScript && e.push(this.sScript), this.sRegion && e.push(this.sRegion), this.sVariant && e.push(this.sVariant), this.sExtension && e.push(this.sExtension), this.sPrivateUse && e.push(this.sPrivateUse), e.join("-");
  }
}
const qt = /* @__PURE__ */ new Map(), Pn = (t) => (qt.has(t) || qt.set(t, new Sn(t)), qt.get(t)), ho = (t) => {
  try {
    if (t && typeof t == "string")
      return Pn(t);
  } catch (e) {
  }
  return new Sn(ye);
}, fo = (t) => {
  if (t)
    return ho(t);
  const e = du();
  return e ? Pn(e) : ho(su());
}, fu = /^((?:[A-Z]{2,3}(?:-[A-Z]{3}){0,3})|[A-Z]{4}|[A-Z]{5,8})(?:-([A-Z]{4}))?(?:-([A-Z]{2}|[0-9]{3}))?((?:-[0-9A-Z]{5,8}|-[0-9][0-9A-Z]{3})*)((?:-[0-9A-WYZ](?:-[0-9A-Z]{2,8})+)*)(?:-(X(?:-[0-9A-Z]{1,8})+))?$/i, Co = /(?:^|-)(saptrc|sappsd)(?:-|$)/i, Cu = {
  he: "iw",
  yi: "ji",
  nb: "no",
  sr: "sh"
}, gu = (t) => {
  let e;
  if (!t)
    return ye;
  if (typeof t == "string" && (e = fu.exec(t.replace(/_/g, "-")))) {
    let r = e[1].toLowerCase(), n = e[3] ? e[3].toUpperCase() : void 0;
    const _ = e[2] ? e[2].toLowerCase() : void 0, I = e[4] ? e[4].slice(1) : void 0, v = e[6];
    return r = Cu[r] || r, v && (e = Co.exec(v)) || I && (e = Co.exec(I)) ? `en_US_${e[1].toLowerCase()}` : (r === "zh" && !n && (_ === "hans" ? n = "CN" : _ === "hant" && (n = "TW")), r + (n ? "_" + n + (I ? "_" + I.replace("-", "_") : "") : ""));
  }
  return ye;
}, mu = (t) => {
  if (!t)
    return ye;
  if (t === "zh_HK")
    return "zh_TW";
  const e = t.lastIndexOf("_");
  return e >= 0 ? t.slice(0, e) : t !== ye ? ye : "";
}, go = /* @__PURE__ */ new Set(), mo = /* @__PURE__ */ new Set(), wn = /* @__PURE__ */ new Map(), Zt = /* @__PURE__ */ new Map(), Dn = /* @__PURE__ */ new Map(), yo = (t, e) => {
  wn.set(t, e);
}, Bn = (t, e) => {
  const r = `${t}/${e}`;
  return Dn.has(r);
}, yu = (t, e) => {
  const r = `${t}/${e}`, n = Dn.get(r);
  return n && !Zt.get(r) && Zt.set(r, n(e)), Zt.get(r);
}, Tu = (t) => {
  go.has(t) || (console.warn(`[${t}]: Message bundle assets are not configured. Falling back to English texts.`, ` Add \`import "${t}/dist/Assets.js"\` in your bundle and make sure your build tool supports dynamic imports and JSON imports. See section "Assets" in the documentation for more information.`), go.add(t));
}, To = (t, e) => e !== ft && !Bn(t, e), vu = (t) => R(void 0, null, function* () {
  const e = fo().getLanguage(), r = fo().getRegion();
  let n = e + (r ? `-${r}` : "");
  if (To(t, n))
    for (n = gu(n); To(t, n); )
      n = mu(n);
  const _ = _u();
  if (n === ft && !_) {
    yo(t, null);
    return;
  }
  if (!Bn(t, n)) {
    Tu(t);
    return;
  }
  try {
    const I = yield yu(t, n);
    yo(t, I);
  } catch (I) {
    const v = I;
    mo.has(v.message) || (mo.add(v.message), console.error(v.message));
  }
});
cu((t) => {
  const e = [...wn.keys()];
  return Promise.all(e.map(vu));
});
const bu = ke("SVGIcons.registry", /* @__PURE__ */ new Map());
ke("SVGIcons.promises", /* @__PURE__ */ new Map());
const Un = (t, e) => {
  const r = `${e.collection}/${t}`;
  bu.set(r, {
    pathData: e.pathData,
    ltr: e.ltr,
    accData: e.accData,
    packageName: e.packageName,
    customTemplate: e.customTemplate,
    viewBox: e.viewBox,
    collection: e.collection
  });
}, Iu = "feedback", Ln = "M368 32q30 0 56 11.5t45.5 31 31 45.5 11.5 56-11.5 56-31 45.5-45.5 31-56 11.5-56-11.5-45.5-31-31-45.5-11.5-56 11.5-56 31-45.5 45.5-31T368 32zM254 176q0 24 9 44.5t24.5 36 36 24.5 44.5 9 44.5-9 36-24.5 24.5-36 9-44.5-9-44.5-24.5-36-36-24.5-44.5-9-44.5 9-36 24.5-24.5 36-9 44.5zM0 160q0-26 19-45t45-19h147q-7 13-12 32H64q-14 0-23 10-9 9-9 22v192q0 14 9 23t23 9h64v80l64-79 224-1q14 0 23-9t9-23v-19q10-6 18-11t14-10v40q0 27-18.5 45.5T416 416H208l-78 92q-4 4-13 4-8 0-14.5-5.5T96 492v-76H64q-27 0-45.5-18.5T0 352V160zm293 38l2-2q3-3 7-3 5 0 8 4 27 30 58 30 33 0 58-30 3-3 8-3 4 0 7 3h1q0 1 .5 1t.5 1q8 7 1 14-16 20-35.5 29.5T369 252t-40-9.5-37-29.5q-3-3-2.5-7.5t3.5-7.5zm94-68q0-10 6.5-15t14.5-5 14 5 6 15-6 15-14 5-14.5-5-6.5-15zm-59-20q8 0 14 5t6 15-6 15-14 5-14.5-5-6.5-15 6.5-15 14.5-5z", Eu = !1, Au = "SAP-icons-v4", Su = "@ui5/webcomponents-icons";
Un(Iu, { pathData: Ln, ltr: Eu, collection: Au, packageName: Su });
const Pu = "feedback", Nn = "M319.376 320.374q-32.935 0-62.378-12.974t-50.9-34.433-33.934-50.402-12.476-61.879 12.476-62.378 34.432-50.9 50.402-34.433T318.378 0t62.378 12.975 50.9 34.432 34.434 50.901 12.974 62.378q0 31.938-11.976 60.881t-33.435 50.9-50.9 34.933-63.377 12.974zm165.677-31.937q10.978 0 18.464 7.485t7.485 18.464v11.977q0 37.925-25.95 63.875t-62.877 25.95H233.544l-94.815 88.826Q131.743 512 121.762 512q-10.978 0-18.464-7.485t-7.485-18.464v-69.864h-5.988q-37.926 0-63.876-25.95T0 326.364V122.76q0-37.926 25.95-63.875t63.875-25.95H101.8q10.979 0 18.464 7.486t7.485 18.464-7.485 17.965-18.464 6.986H89.825q-16.967 0-27.946 10.979T50.901 122.76v203.603q0 16.966 10.978 27.945t27.946 10.979h31.937q10.979 0 17.965 6.986t6.986 17.965v36.928l59.883-54.893q5.989-6.986 16.967-6.986h198.612q15.97 0 26.948-10.979t10.978-27.945v-11.977q0-10.979 6.987-18.464t17.965-7.485zM430.16 163.68q0-21.957-8.484-41.918t-23.454-35.43-35.43-24.952-44.414-9.481q-21.957 0-41.419 8.483t-33.934 23.454-22.955 35.431-8.483 44.413q0 43.915 27.446 74.854t74.355 30.94q20.959 0 41.918-7.486t37.427-20.959 26.947-33.434 10.48-43.915zM271.47 128.75q-15.969 0-15.969-15.97t15.969-15.968 15.969 15.969-15.97 15.969zm95.813 0q-15.97 0-15.97-15.97t15.97-15.968 15.968 15.969-15.968 15.969zM319.376 240.53q-10.978 0-25.45-3.493t-26.947-9.98-20.96-16.967-8.483-23.455q0-10.978 6.487-18.463t17.466-7.486q14.971 0 22.955 13.973 2.995 4.99 10.48 9.98t24.452 4.99q23.953 0 34.932-15.968 8.982-12.975 22.955-12.975 9.98 0 16.967 7.486t6.986 19.462q0 12.974-8.483 22.456t-20.96 16.468-26.946 10.479-25.45 3.493z", wu = !1, Du = "SAP-icons-v5", Bu = "@ui5/webcomponents-icons";
Un(Pu, { pathData: Nn, ltr: wu, collection: Du, packageName: Bu });
iu();
const Uu = /('')|'([^']+(?:''[^']*)*)(?:'|$)|\{([0-9]+(?:\s*,[^{}]*)?)\}|[{}]/g, Lu = (t, e) => (e = e || [], t.replace(Uu, (r, n, _, I, v) => {
  if (n)
    return "'";
  if (_)
    return _.replace(/''/g, "'");
  if (I) {
    const h = typeof I == "string" ? parseInt(I) : I;
    return String(e[h]);
  }
  throw new Error(`[i18n]: pattern syntax error at pos ${v}`);
})), Wt = /* @__PURE__ */ new Map();
class Nu {
  constructor(e) {
    this.packageName = e;
  }
  getText(e, ...r) {
    if (typeof e == "string" && (e = { key: e, defaultText: e }), !e || !e.key)
      return "";
    const n = Ea(this.packageName);
    n && !n[e.key] && console.warn(`Key ${e.key} not found in the i18n bundle, the default text will be used`);
    const _ = n && n[e.key] ? n[e.key] : e.defaultText || e.key;
    return Lu(_, r);
  }
}
const Ou = (t) => {
  if (Wt.has(t))
    return Wt.get(t);
  const e = new Nu(t);
  return Wt.set(t, e), e;
}, Vu = (t) => R(void 0, null, function* () {
  return yield pn(t), Ou(t);
}), Ru = (t, e) => {
  const r = document.createElement("style");
  return r.type = "text/css", e && Object.entries(e).forEach((n) => r.setAttribute(...n)), r.textContent = t, document.head.appendChild(r), r;
}, xu = (t, e) => {
  const r = document.createElement("link");
  return r.type = "text/css", r.rel = "stylesheet", e && Object.entries(e).forEach((n) => r.setAttribute(...n)), r.href = t, document.head.appendChild(r), new Promise((n) => {
    r.addEventListener("load", n), r.addEventListener("error", n);
  });
}, yt = (t, e) => e ? `${t}|${e}` : t, Ku = (t, e, r = "") => {
  const n = typeof t == "string" ? t : t.content;
  if (document.adoptedStyleSheets) {
    const _ = new CSSStyleSheet();
    _.replaceSync(n), _._ui5StyleId = yt(e, r), document.adoptedStyleSheets = [...document.adoptedStyleSheets, _];
  } else {
    const _ = {};
    _[e] = r, Ru(n, _);
  }
}, Mu = (t, e, r = "") => {
  const n = typeof t == "string" ? t : t.content;
  if (document.adoptedStyleSheets) {
    const _ = document.adoptedStyleSheets.find((I) => I._ui5StyleId === yt(e, r));
    _ && _.replaceSync(n || "");
  } else {
    const _ = document.querySelector(`head>style[${e}="${r}"]`);
    _ && (_.textContent = n || "");
  }
}, ku = (t, e = "") => document.adoptedStyleSheets ? !!document.adoptedStyleSheets.find((r) => r._ui5StyleId === yt(t, e)) : !!document.querySelector(`head>style[${t}="${e}"]`), Hu = (t, e = "") => {
  var r;
  if (document.adoptedStyleSheets)
    document.adoptedStyleSheets = document.adoptedStyleSheets.filter((n) => n._ui5StyleId !== yt(t, e));
  else {
    const n = document.querySelector(`head > style[${t}="${e}"]`);
    (r = n == null ? void 0 : n.parentElement) == null || r.removeChild(n);
  }
}, On = (t, e, r = "") => {
  ku(e, r) ? Mu(t, e, r) : Ku(t, e, r);
}, Ce = /* @__PURE__ */ new Set(), $u = () => {
  let t = document.querySelector(".sapThemeMetaData-Base-baseLib") || document.querySelector(".sapThemeMetaData-UI5-sap-ui-core");
  if (t)
    return getComputedStyle(t).backgroundImage;
  t = document.createElement("span"), t.style.display = "none", t.classList.add("sapThemeMetaData-Base-baseLib"), document.body.appendChild(t);
  let e = getComputedStyle(t).backgroundImage;
  return e === "none" && (t.classList.add("sapThemeMetaData-UI5-sap-ui-core"), e = getComputedStyle(t).backgroundImage), document.body.removeChild(t), e;
}, Fu = (t) => {
  const e = /\(["']?data:text\/plain;utf-8,(.*?)['"]?\)$/i.exec(t);
  if (e && e.length >= 2) {
    let r = e[1];
    if (r = r.replace(/\\"/g, '"'), r.charAt(0) !== "{" && r.charAt(r.length - 1) !== "}")
      try {
        r = decodeURIComponent(r);
      } catch (n) {
        Ce.has("decode") || (console.warn("Malformed theme metadata string, unable to decodeURIComponent"), Ce.add("decode"));
        return;
      }
    try {
      return JSON.parse(r);
    } catch (n) {
      Ce.has("parse") || (console.warn("Malformed theme metadata string, unable to parse JSON"), Ce.add("parse"));
    }
  }
}, zu = (t) => {
  let e, r;
  try {
    e = t.Path.match(/\.([^.]+)\.css_variables$/)[1], r = t.Extends[0];
  } catch (n) {
    Ce.has("object") || (console.warn("Malformed theme metadata Object", t), Ce.add("object"));
    return;
  }
  return {
    themeName: e,
    baseThemeName: r
  };
}, st = () => {
  const t = $u();
  if (!t || t === "none")
    return;
  const e = Fu(t);
  if (e)
    return zu(e);
}, Gu = new ct(), ju = "themeLoaded", qu = (t) => Gu.fireEvent(ju, t);
let Yt;
const Vn = () => (Yt === void 0 && (Yt = Ui()), Yt), Zu = (t) => `${Vn()}Base/baseLib/${t}/css_variables.css`, Wu = (t) => R(void 0, null, function* () {
  const e = document.querySelector(`[sap-ui-webcomponents-theme="${t}"]`);
  e && document.head.removeChild(e), yield xu(Zu(t), { "sap-ui-webcomponents-theme": t });
}), xe = "@ui5/webcomponents-theming", Yu = () => cn().has(xe), Qu = (t) => R(void 0, null, function* () {
  if (!Yu())
    return;
  const e = yield ln(xe, t);
  e && On(e, "data-ui5-theme-properties", xe);
}), Ju = () => {
  Hu("data-ui5-theme-properties", xe);
}, Xu = (t) => R(void 0, null, function* () {
  const r = [...cn()].map((n) => R(void 0, null, function* () {
    if (n === xe)
      return;
    const _ = yield ln(n, t);
    _ && On(_, "data-ui5-theme-properties", n);
  }));
  return Promise.all(r);
}), el = (t) => R(void 0, null, function* () {
  var n;
  const e = st();
  if (e)
    return e;
  const r = ur("OpenUI5Support");
  if (r) {
    if (r.cssVariablesLoaded())
      return {
        themeName: (n = r.getConfigurationSettingsObject()) == null ? void 0 : n.theme,
        baseThemeName: ""
      };
  } else if (Vn())
    return yield Wu(t), st();
}), tl = (t) => R(void 0, null, function* () {
  const e = yield el(t);
  !e || t !== e.themeName ? yield Qu(t) : Ju();
  const r = ga(t) ? t : e && e.baseThemeName;
  yield Xu(r || tt), qu(t);
});
let ve;
const rl = () => (ve === void 0 && (ve = Bi()), ve), vo = (t) => R(void 0, null, function* () {
  ve !== t && (ve = t, yield tl(ve), yield na({ themeAware: !0 }));
}), Pl = () => {
  var e, r;
  const t = rl();
  return ol(t) ? !t.startsWith("sap_horizon") : !((r = (e = st()) == null ? void 0 : e.baseThemeName) != null && r.startsWith("sap_horizon"));
}, ol = (t) => Ti.includes(t), nl = ut`
  <svg
    version="1.1"
    viewBox="0 0 16 15"
    width="16"
    height="15"
    xmlns="http://www.w3.org/2000/svg"
    xmlns:svg="http://www.w3.org/2000/svg"
  >
    <g class="pathGroup legacyFeedbackIcon">
        <path
            class="backgroundCircle"
            style="stroke-width:0.0257446"
            d="m 11.5,0.79276785 q 0.77234,0 1.441702,0.29606375 0.66936,0.2960636 1.171381,0.7980845 0.502022,0.5020211 0.798086,1.1713824 0.296063,0.6693614 0.296063,1.4417015 0,0.77234 -0.296063,1.4417015 Q 14.615105,6.6110627 14.113083,7.1130839 13.611062,7.6151046 12.941702,7.9111681 12.27234,8.2072317 11.5,8.2072317 q -0.77234,0 -1.441701,-0.2960636 Q 9.3889383,7.6151046 8.8869163,7.1130839 8.3848954,6.6110627 8.0888316,5.9417015 7.792768,5.27234 7.792768,4.5 q 0,-0.7723401 0.2960636,-1.4417015 Q 8.3848954,2.3889372 8.8869163,1.8869161 9.3889383,1.3848952 10.058299,1.0888316 10.72766,0.79276785 11.5,0.79276785 Z"
        />
        <path
            class="foregroundIcon"
            d="m 11.5,0 q 0.9375,0 1.75,0.359375 0.8125,0.35937501 1.421874,0.96875 Q 15.28125,1.9375 15.640626,2.75 16,3.5625 16,4.5 16,5.4375001 15.640626,6.2500002 15.28125,7.0625 14.671874,7.6718752 14.0625,8.2812502 13.25,8.6406251 12.4375,8.9999998 11.5,8.9999998 q -0.9375,0 -1.7499995,-0.3593747 Q 8.9375006,8.2812502 8.3281251,7.6718752 7.7187501,7.0625 7.359375,6.2500002 7.0000001,5.4375001 7.0000001,4.5 q 0,-0.9375 0.3593749,-1.75 Q 7.7187501,1.9375 8.3281251,1.328125 8.9375006,0.71875001 9.7500005,0.359375 10.5625,0 11.5,0 Z M 7.9375002,4.5 q 0,0.7500001 0.2812498,1.3906251 Q 8.5,6.53125 8.984375,7.0156251 9.4687505,7.5000001 10.109376,7.7812502 10.75,8.0625 11.5,8.0625 q 0.75,0 1.390624,-0.2812498 Q 13.53125,7.5000001 14.015625,7.0156251 14.5,6.53125 14.78125,5.8906251 15.062499,5.2500001 15.062499,4.5 q 0,-0.75 -0.281249,-1.3906249 Q 14.5,2.4687501 14.015625,1.9843751 13.53125,1.5 12.890624,1.21875 12.25,0.93750001 11.5,0.93750001 q -0.75,0 -1.390624,0.28124999 Q 9.4687505,1.5 8.984375,1.9843751 8.5,2.4687501 8.21875,3.1093751 7.9375002,3.75 7.9375002,4.5 Z M 0,3.9999998 Q 0,3.1875001 0.59375,2.59375 1.1875,2.0000002 2.0000002,2.0000002 h 4.59375 Q 6.375,2.40625 6.2187502,3 h -4.21875 Q 1.5624999,3 1.28125,3.3124999 0.99999999,3.59375 0.99999999,3.9999998 v 6.0000001 q 0,0.4375001 0.28125001,0.7187491 Q 1.5624999,11 2.0000002,11 h 1.9999996 v 2.500001 L 6.0000001,11.03125 13.000001,11 q 0.4375,0 0.718749,-0.281251 Q 14,10.4375 14,10.000001 V 9.406253 Q 14.3125,9.218753 14.5625,9.0625025 14.8125,8.9062526 15,8.7500027 v 1.2500003 q 0,0.84375 -0.578124,1.421875 -0.578126,0.578125 -1.421875,0.578125 H 6.5000001 l -2.4375,2.875 q -0.125,0.125001 -0.4062502,0.125001 -0.2499998,0 -0.4531248,-0.171875 Q 3,14.656254 3,14.375003 V 12.000004 H 2.0000002 q -0.8437503,0 -1.4218752,-0.578125 Q 0,10.84375 0,9.9999999 Z M 12.09375,3.0625001 Q 12.09375,2.75 12.296874,2.59375 12.5,2.4375 12.750001,2.4375 q 0.25,0 0.437499,0.15625 0.1875,0.15625 0.1875,0.4687501 0,0.3125 -0.1875,0.4687501 Q 13.000001,3.6875 12.750001,3.6875 12.5,3.6875 12.296874,3.5312502 12.09375,3.3750001 12.09375,3.0625001 Z M 10.249999,2.4375 q 0.25,0 0.437501,0.15625 0.187501,0.15625 0.187501,0.4687501 0,0.3125 -0.187501,0.4687501 Q 10.499999,3.6875 10.249999,3.6875 9.9999999,3.6875 9.7968755,3.5312502 9.5937501,3.3750001 9.5937501,3.0625001 9.5937501,2.75 9.7968755,2.59375 9.9999999,2.4375 10.249999,2.4375 Z m -1.0937487,2.7499999 0.062501,-0.062499 q 0.093749,-0.093751 0.21875,-0.093751 0.1562504,0 0.2500004,0.125 0.8437513,0.9375001 1.8124993,0.9375001 1.031251,0 1.8125,-0.9375001 0.09374,-0.093751 0.25,-0.093751 0.125,0 0.21875,0.093751 h 0.03125 q 0,0.031249 0.01561,0.031249 0.01562,0 0.01562,0.03125 0.125001,0.1249999 0.125001,0.21875 0,0.125 -0.09376,0.21875 -0.5,0.6250001 -1.109375,0.9218751 -0.609376,0.2968747 -1.234374,0.2968747 -0.625001,0 -1.250001,-0.2968747 Q 9.6562318,6.2812505 9.1249813,5.6562504 9.0312322,5.5625 9.0312322,5.4687503 q 0,-0.03125 0.015627,-0.109375 0.015628,-0.078125 0.1093752,-0.1718751 z"
            style="stroke-width:0.0312499"
        />
    </g>
  </svg>
`, il = ut`
    <svg
        version="1.1"
        width="18.190166"
        height="20"
        viewBox="0 0 18.190167 20"
        xmlns="http://www.w3.org/2000/svg"
        xmlns:svg="http://www.w3.org/2000/svg"
    >
        <g class="pathGroup newFeedackIcon">
            <path
                d="M 3.665181,2.7601972 H 2.7601972 c -0.9996179,0 -1.80996746,0.8103496 -1.80996746,1.8099675 v 9.0498373 c 0,0.999645 0.81034956,1.809967 1.80996746,1.809967 h 1.8099675 v 3.619936 L 8.1900998,15.429969 H 15.42997 c 0.999645,0 1.809967,-0.810322 1.809967,-1.809967 v -0.904984"
                stroke-linecap="round"
                stroke-linejoin="round"
            />
            <path
                class="smiley"
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="m 11.810035,11.810035 c 2.998844,0 5.429902,-2.4310584 5.429902,-5.4299028 0,-2.9988537 -2.431058,-5.42990246 -5.429902,-5.42990246 -2.9988444,0 -5.4299028,2.43104876 -5.4299028,5.42990246 0,2.9988444 2.4310584,5.4299028 5.4299028,5.4299028 z"
                stroke-linecap="round"
                stroke-linejoin="round"
            />
            <path
                d="m 10.000068,7.2851161 c 0,0 0.452491,0.9049837 1.809967,0.9049837 1.357475,0 1.809967,-0.9049837 1.809967,-0.9049837"
                stroke-linecap="round"
                stroke-linejoin="round"
            />
            <path
                class="eye"
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="m 10.000068,5.4751485 c 0.499821,0 0.904983,-0.4051794 0.904983,-0.9049838 0,-0.4998044 -0.405162,-0.9049838 -0.904983,-0.9049838 -0.4998231,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.4051609,0.9049838 0.904984,0.9049838 z"
            />
            <path
                class="eye"
                fill-rule="evenodd"
                clip-rule="evenodd"
                d="m 13.620002,5.4751485 c 0.499823,0 0.904984,-0.4051794 0.904984,-0.9049838 0,-0.4998044 -0.405161,-0.9049838 -0.904984,-0.9049838 -0.499822,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.405162,0.9049838 0.904984,0.9049838 z"
            />
        </g>
    </svg>
`, al = Gn`
    :host {
        font-family: var(--sapFontFamily);
    }

    :host(:focus) {
        outline: none;
        box-shadow: none;
    }

    .notificationBadge .smiley,
    .notificationBadge .backgroundCircle {
        fill: var(--qtxSurveyButton_NotificationColor, #64edd2); /* Teal 2 */
    }

    path {
        stroke: var(--sapShell_InteractiveTextColor, #1d2d3e);
        stroke-width: 2px;
        vector-effect: non-scaling-stroke;
    }
    .eye,
    .foregroundIcon {
        fill: var(--sapShell_InteractiveTextColor, #1d2d3e);
        stroke: transparent;
    }

    .pathGroup {
        fill: none;
    }
`;
hi("cx-qtx-btn");
const j = class extends me {
  constructor() {
    var e;
    super(), this.theme = ((e = st()) == null ? void 0 : e.themeName) || "sap_horizon", vo(this.theme), import("./Button.ea5098a6.mjs"), import("./Dialog.e4ddb2a8.mjs"), import("./Icon.7310a395.mjs").then((r) => r.o), import("./Bar.88d1fc95.mjs"), import("./IllustratedMessage.8afc4d6c.mjs"), this._version = "5.0.5", this.timePushDisabled = !1, this.appPushConfigs = [], this.surveyNotificationPromise = {
      resolve() {
      },
      reject() {
      }
    }, this.contextParams = {}, this.allowedOrigins = [window.location.origin], this.interceptUrl = "", this.tenantId = "", this.tenantRole = "", this.productName = "", this.platformType = "", this.unitId = "", this.environment = "", this._pxApi = new Ko.exports.PxApi(), this._pxApiInitialized = !1, this._dialogRef = ai(), this._showNotificationBadge = this._getLocalStorageSetting("showNotificationBadge") || !1, this._addPostMessageEventHandler(), this._registerI18nLoader();
  }
  static get properties() {
    return {
      timePushDisabled: {
        type: Boolean,
        attribute: "time-push-disabled"
      },
      timePushSuspended: {
        type: Boolean,
        attribute: "time-push-suspended"
      },
      appPushConfigs: {
        type: Array,
        attribute: "app-push-configs"
      },
      interceptUrl: {
        type: String,
        attribute: "intercept-url"
      },
      contextParams: {
        type: Object,
        attribute: "context-params",
        reflect: !0
      },
      theme: {
        type: String,
        attribute: "theme"
      },
      allowedOrigins: {
        type: Array,
        attribute: "allowed-origins"
      },
      tenantId: {
        type: String,
        attribute: "tenant-id"
      },
      tenantRole: {
        type: String,
        attribute: "tenant-role"
      },
      productName: {
        type: String,
        attribute: "product-name"
      },
      platformType: {
        type: String,
        attribute: "platform-type"
      },
      unitId: {
        type: String,
        attribute: "unit-id"
      },
      environment: {
        type: String
      },
      _showNotificationBadge: {
        type: Boolean,
        state: !0
      }
    };
  }
  _validateProps() {
    const e = [
      {
        property: "interceptUrl",
        attribute: j.properties.interceptUrl.attribute,
        value: this.interceptUrl
      },
      {
        property: "tenantId",
        attribute: j.properties.tenantId.attribute,
        value: this.tenantId
      },
      {
        property: "tenantRole",
        attribute: j.properties.tenantRole.attribute,
        value: this.tenantRole
      },
      {
        property: "productName",
        attribute: j.properties.productName.attribute,
        value: this.productName
      },
      {
        property: "platformType",
        attribute: j.properties.platformType.attribute,
        value: this.platformType
      },
      {
        property: "unitId",
        attribute: j.properties.unitId.attribute,
        value: this.unitId
      },
      {
        property: "environment",
        attribute: j.properties.environment.attribute,
        value: this.environment
      }
    ];
    return e.map((r) => r.value === "" ? (console.error(
      `CxQtxSurveyButton: Required property '${r.property}' or attribute '${r.attribute}' missing.`
    ), !1) : !0).filter((r) => r).length === e.length;
  }
  _getLocalStorageSetting(e) {
    try {
      return JSON.parse(localStorage.getItem("sap.cx.qtx.survey.button"))[e];
    } catch (r) {
      localStorage.setItem("sap.cx.qtx.survey.button", "{}");
      return;
    }
  }
  _setLocalStorageSetting(e, r) {
    try {
      const n = JSON.parse(localStorage.getItem("sap.cx.qtx.survey.button"));
      n[e] = r, localStorage.setItem("sap.cx.qtx.survey.button", JSON.stringify(n));
    } catch (n) {
      localStorage.setItem("sap.cx.qtx.survey.button", JSON.stringify({
        [e]: r
      }));
    }
  }
  _addPostMessageEventHandler() {
    window.addEventListener("message", (e) => {
      var r, n, _;
      if (((r = e.data) == null ? void 0 : r.receiver) === "cx-qtx-survey-button") {
        if (!this.allowedOrigins.includes(e.origin))
          return console.error(
            `CxQtxSurveyButton: Ignoring postMessage. Source origin '${e.origin}' is not part of the allowed origins: '${this.allowedOrigins}'.`
          );
        this[(n = e.data) == null ? void 0 : n.method](...(_ = e.data) == null ? void 0 : _.params);
      }
    });
  }
  _registerI18nLoader() {
    Xo(!0), [
      "ar",
      "bg",
      "ca",
      "cs",
      "cy",
      "da",
      "de",
      "el",
      "en",
      "en_GB",
      "en_US_saprigi",
      "es",
      "es_MX",
      "et",
      "fi",
      "fr",
      "fr_CA",
      "hi",
      "hr",
      "hu",
      "id",
      "it",
      "iw",
      "ja",
      "kk",
      "ko",
      "lt",
      "lv",
      "ms",
      "nl",
      "no",
      "pl",
      "pt",
      "pt_PT",
      "ro",
      "ru",
      "sh",
      "sk",
      "sl",
      "sv",
      "th",
      "tr",
      "uk",
      "vi",
      "zh_CN",
      "zh_TW"
    ].forEach((r) => {
      _t(
        "cx-qtx-survey-button",
        r,
        (n) => R(this, null, function* () {
          return (yield Fn(/* @__PURE__ */ Object.assign({ "../i18n/i18n_ar.json": () => import("./i18n_ar.4c014ddc.mjs"), "../i18n/i18n_bg.json": () => import("./i18n_bg.46ef0fe1.mjs"), "../i18n/i18n_ca.json": () => import("./i18n_ca.862d780e.mjs"), "../i18n/i18n_cs.json": () => import("./i18n_cs.de4c4dc7.mjs"), "../i18n/i18n_cy.json": () => import("./i18n_cy.680385c3.mjs"), "../i18n/i18n_da.json": () => import("./i18n_da.1d34b467.mjs"), "../i18n/i18n_de.json": () => import("./i18n_de.db5b3082.mjs"), "../i18n/i18n_el.json": () => import("./i18n_el.8dde9c48.mjs"), "../i18n/i18n_en.json": () => import("./i18n_en.ef3e8951.mjs"), "../i18n/i18n_en_GB.json": () => import("./i18n_en_GB.36072423.mjs"), "../i18n/i18n_en_US_saprigi.json": () => import("./i18n_en_US_saprigi.15bfdb37.mjs"), "../i18n/i18n_es.json": () => import("./i18n_es.7c826bc7.mjs"), "../i18n/i18n_es_MX.json": () => import("./i18n_es_MX.a871e936.mjs"), "../i18n/i18n_et.json": () => import("./i18n_et.fcf634ca.mjs"), "../i18n/i18n_fi.json": () => import("./i18n_fi.44c03048.mjs"), "../i18n/i18n_fr.json": () => import("./i18n_fr.16aca596.mjs"), "../i18n/i18n_fr_CA.json": () => import("./i18n_fr_CA.ab2b4b02.mjs"), "../i18n/i18n_hi.json": () => import("./i18n_hi.e3320cfd.mjs"), "../i18n/i18n_hr.json": () => import("./i18n_hr.ecc1b1c2.mjs"), "../i18n/i18n_hu.json": () => import("./i18n_hu.971bc05a.mjs"), "../i18n/i18n_id.json": () => import("./i18n_id.a747f124.mjs"), "../i18n/i18n_it.json": () => import("./i18n_it.11a1d95d.mjs"), "../i18n/i18n_iw.json": () => import("./i18n_iw.1bb98610.mjs"), "../i18n/i18n_ja.json": () => import("./i18n_ja.686f2c17.mjs"), "../i18n/i18n_kk.json": () => import("./i18n_kk.9a9abdc7.mjs"), "../i18n/i18n_ko.json": () => import("./i18n_ko.24beaebb.mjs"), "../i18n/i18n_lt.json": () => import("./i18n_lt.801054aa.mjs"), "../i18n/i18n_lv.json": () => import("./i18n_lv.a791d731.mjs"), "../i18n/i18n_ms.json": () => import("./i18n_ms.293a6c98.mjs"), "../i18n/i18n_nl.json": () => import("./i18n_nl.d6b6c277.mjs"), "../i18n/i18n_no.json": () => import("./i18n_no.09e3617b.mjs"), "../i18n/i18n_pl.json": () => import("./i18n_pl.3b5d12b1.mjs"), "../i18n/i18n_pt.json": () => import("./i18n_pt.2118952e.mjs"), "../i18n/i18n_pt_PT.json": () => import("./i18n_pt_PT.24db6401.mjs"), "../i18n/i18n_ro.json": () => import("./i18n_ro.d629a834.mjs"), "../i18n/i18n_ru.json": () => import("./i18n_ru.3c43bc93.mjs"), "../i18n/i18n_sh.json": () => import("./i18n_sh.5f00153d.mjs"), "../i18n/i18n_sk.json": () => import("./i18n_sk.3655028c.mjs"), "../i18n/i18n_sl.json": () => import("./i18n_sl.5d2dfcd5.mjs"), "../i18n/i18n_sv.json": () => import("./i18n_sv.3037e6c1.mjs"), "../i18n/i18n_th.json": () => import("./i18n_th.cc2a7c04.mjs"), "../i18n/i18n_tr.json": () => import("./i18n_tr.351ed871.mjs"), "../i18n/i18n_uk.json": () => import("./i18n_uk.572ccbef.mjs"), "../i18n/i18n_vi.json": () => import("./i18n_vi.52cd9cbe.mjs"), "../i18n/i18n_zh_CN.json": () => import("./i18n_zh_CN.0492dd58.mjs"), "../i18n/i18n_zh_TW.json": () => import("./i18n_zh_TW.ca619a78.mjs") }), `../i18n/i18n_${n}.json`)).default;
        })
      );
    });
  }
  _onClick() {
    return R(this, null, function* () {
      !this._pxApiInitialized || (yield this._pxApi.openSurvey(this.contextParams), this._setLocalStorageSetting("showNotificationBadge", !1), this._showNotificationBadge = !1);
    });
  }
  _resolveSurveyNotification(e) {
    this._setLocalStorageSetting("showNotificationBadge", !e), this._showNotificationBadge = !e, this.surveyNotificationPromise.resolve({
      appContextData: this.contextParams,
      surveyUser: e
    });
  }
  _onSurveyNotification() {
    return R(this, null, function* () {
      return new Promise((e, r) => {
        var n;
        this.surveyNotificationPromise.reject(), this.surveyNotificationPromise = {
          resolve: e,
          reject: r
        }, document.body.appendChild(this._dialogRef.value), (n = this._dialogRef.value) == null || n.show();
      }).finally(() => {
        var e;
        (e = this._dialogRef.value) == null || e.close();
      });
    });
  }
  _handleDialogClose({ detail: e }) {
    e.escPressed && this._resolveSurveyNotification(!1);
  }
  setContextParams(e) {
    this.contextParams = JSON.parse(JSON.stringify(e));
  }
  updateContextParam(e, r) {
    this.contextParams[e] = r;
  }
  requestSurveyPush(e) {
    !this._pxApiInitialized || this._pxApi.requestPush(e);
  }
  _initializePXApi() {
    return R(this, null, function* () {
      this._pxApiInitialized && this._pxApi.destroy();
      const e = [
        "manual",
        ...this.timePushDisabled ? [] : ["timedPush"],
        ...this.appPushConfigs.length > 0 ? ["appPush"] : []
      ], r = {
        version: "0.3.1",
        unitId: this.unitId,
        environment: this.environment,
        startupConfig: {
          qualtricsInternalUri: this.interceptUrl,
          enableQualtricsRestrictedMode: !0,
          productName: this.productName,
          platformType: this.platformType,
          scopeSet: e
        },
        themingConfig: {
          writeToGlobals: !0
        },
        pushConfig: {
          appPush: {
            configs: this.appPushConfigs
          }
        }
      };
      yield this._pxApi.initialize(
        {
          tenantId: this.tenantId,
          tenantRole: this.tenantRole
        },
        null,
        r,
        this._onSurveyNotification.bind(this)
      ), this._pxApi.currentThemeId = this.theme, this._pxApiInitialized = !0;
    });
  }
  connectedCallback() {
    setTimeout(() => R(this, null, function* () {
      !this._validateProps() || (this.i18n = yield Vu("cx-qtx-survey-button"), wt(j.prototype, this, "connectedCallback").call(this), this._initializePXApi(), this.setAttribute("aria-hidden", "true"));
    }));
  }
  updated(e) {
    var r, n;
    e.has("theme") && (vo(this.theme), this._pxApi.currentThemeId = this.theme), e.has("timePushSuspended") && (sap = sap != null ? sap : {}, sap.pxdata = (r = sap.pxdata) != null ? r : {}, sap.pxdata.settings = (n = sap.pxdata.settings) != null ? n : {}, sap.pxdata.settings.standalone = !!this.timePushSuspended);
  }
  attributeChangedCallback(e, r, n) {
    return R(this, null, function* () {
      wt(j.prototype, this, "attributeChangedCallback").call(this, e, r, n);
      const _ = [
        j.properties.tenantId.attribute,
        j.properties.tenantRole.attribute,
        j.properties.interceptUrl.attribute,
        j.properties.productName.attribute,
        j.properties.platformType.attribute,
        j.properties.unitId.attribute,
        j.properties.environment.attribute,
        j.properties.timePushDisabled.attribute
      ];
      r !== n && _.includes(e) && this._pxApiInitialized && (yield this._initializePXApi());
    });
  }
  disconnectedCallback() {
    var e;
    (e = this._dialogRef.value) == null || e.remove(), this._pxApi.destroy(), super.disconnectedCallback();
  }
  render() {
    const e = /sap_horizon.*/.test(this.theme) ? il : nl;
    return ut`
            <div @click="${this._onClick}" class=${li({ notificationBadge: this._showNotificationBadge })}>
                <slot>
                    <ui5-button-cx-qtx-btn
                        design="Transparent"
                        tooltip="${this.i18n.getText(
      "SHELLBAR_BUTTON_TOOLTIP"
    )}"
                        accessible-name="${this.i18n.getText(
      "SHELLBAR_BUTTON_TOOLTIP"
    )}"
                    >
                        ${e}
                    </ui5-button-cx-qtx-btn>
                </slot>
            </div>
            <ui5-dialog-cx-qtx-btn
                id="cx-qtx-survey-button-dialog"
                initial-focus="provide-feedback-button"
                ${ui(this._dialogRef)}
                @before-close="${this._handleDialogClose}"
            >
                <style>
                    ::part(footer),
                    ::part(header) {
                        padding-inline: 0;
                    }
                </style>
                <ui5-bar-cx-qtx-btn slot="header">
                    <ui5-icon-cx-qtx-btn
                        slot="startContent"
                        design="Default"
                        name="feedback"
                    ></ui5-icon-cx-qtx-btn>
                    <p slot="startContent">${this.i18n.getText("YOUR_OPINION_TITLE")}</p>
                </ui5-bar-cx-qtx-btn>
                <ui5-illustrated-message-cx-qtx-btn
                    name="Survey"
                    size="Dialog"
                    title-text=" "
                    subtitle-text="${this.i18n.getText("YOUR_OPINION_TEXT")}"
                ></ui5-illustrated-message-cx-qtx-btn>
                <ui5-bar-cx-qtx-btn slot="footer">
                    <ui5-button-cx-qtx-btn
                        id="provide-feedback-button"
                        slot="endContent"
                        design="Emphasized"
                        @click="${() => this._resolveSurveyNotification(!0)}"
                        >${this.i18n.getText(
      "YOUR_OPINION_PROVIDEBUTTON"
    )}</ui5-button-cx-qtx-btn
                    >
                    <ui5-button-cx-qtx-btn
                        id="ask-later-button"
                        slot="endContent"
                        design="Transparent"
                        @click="${() => this._resolveSurveyNotification(!1)}"
                        >${this.i18n.getText(
      "YOUR_OPINION_ASKLATERBUTTON"
    )}</ui5-button-cx-qtx-btn
                    >
                </ui5-bar-cx-qtx-btn>
            </ui5-dialog-cx-qtx-btn>
        `;
  }
  static get styles() {
    return [al];
  }
};
let Qe = j;
Sr(Qe, "shadowRootOptions", Pt(St({}, me.shadowRootOptions), {
  delegatesFocus: !0
}));
window.customElements.define("cx-qtx-survey-button", Qe);
export {
  Zo as A,
  Qi as B,
  G as C,
  Ro as D,
  ct as E,
  Oo as F,
  le as G,
  Vo as H,
  ut as I,
  Wn as J,
  dl as K,
  ll as L,
  ul as M,
  pl as N,
  cl as O,
  Pl as P,
  li as Q,
  ka as R,
  Al as S,
  Sl as T,
  Il as U,
  El as V,
  Qe as W,
  Jn as Z,
  Vu as a,
  bl as b,
  Ku as c,
  Cl as d,
  tl as e,
  rl as f,
  ur as g,
  ku as h,
  _l as i,
  na as j,
  pt as k,
  hl as l,
  ia as m,
  vi as n,
  ra as o,
  fl as p,
  fi as q,
  dr as r,
  Ci as s,
  Ji as t,
  vl as u,
  Tl as v,
  ki as w,
  ml as x,
  yl as y,
  gl as z
};
//# sourceMappingURL=CxQtxSurveyButton.96c49aa8.mjs.map
