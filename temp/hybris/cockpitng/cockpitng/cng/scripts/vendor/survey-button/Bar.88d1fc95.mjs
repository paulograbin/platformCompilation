var b = (o, e, t) => new Promise((i, n) => {
  var r = (d) => {
    try {
      s(t.next(d));
    } catch (u) {
      n(u);
    }
  }, l = (d) => {
    try {
      s(t.throw(d));
    } catch (u) {
      n(u);
    }
  }, s = (d) => d.done ? i(d.value) : Promise.resolve(d.value).then(r, l);
  s((t = t.apply(o, e)).next());
});
import { e as v, l as _, a as y, U as w, p as x, c as R, b as B } from "./parameters-bundle.css.11496d28.mjs";
import { s as g } from "./slot.f280b696.mjs";
import { R as h } from "./ResizeHandler.e19875b3.mjs";
import { Q as C, r as m } from "./CxQtxSurveyButton.96c49aa8.mjs";
import { s as F } from "./parameters-bundle.css.e5697b28.mjs";
var f;
(function(o) {
  o.Header = "Header", o.Subheader = "Subheader", o.Footer = "Footer", o.FloatingFooter = "FloatingFooter";
})(f || (f = {}));
const p = f;
function E(o, e, t) {
  return v`<div class="${C(this.classes.root)}" aria-label="${_(this.accInfo.label)}" role="toolbar" part="bar"><div class="ui5-bar-content-container ui5-bar-startcontent-container"><slot name="startContent"></slot></div><div class="ui5-bar-content-container ui5-bar-midcontent-container"><slot></slot></div><div class="ui5-bar-content-container ui5-bar-endcontent-container"><slot name="endContent"></slot></div></div>`;
}
m("@ui5/webcomponents-theming", "sap_fiori_3", () => b(void 0, null, function* () {
  return y;
}));
m("@ui5/webcomponents-fiori", "sap_fiori_3", () => b(void 0, null, function* () {
  return F;
}));
const H = { packageName: "@ui5/webcomponents-fiori", fileName: "themes/Bar.css", content: ":host{background-color:var(--sapPageHeader_Background);height:var(--_ui5_bar_base_height);width:100%;box-shadow:inset 0 -.0625rem var(--sapPageHeader_BorderColor);display:block}.ui5-bar-root{display:flex;align-items:center;justify-content:space-between;height:inherit;width:inherit;background-color:inherit;box-shadow:inherit;border-radius:inherit}.ui5-bar-root .ui5-bar-startcontent-container{padding-inline-start:.5rem;display:flex;flex-direction:row;align-items:center;justify-content:flex-start}.ui5-bar-root .ui5-bar-content-container{min-width:30%}.ui5-bar-root.ui5-bar-root-shrinked .ui5-bar-content-container{min-width:0;overflow:hidden;height:100%}.ui5-bar-root .ui5-bar-endcontent-container{padding-inline-end:.5rem;display:flex;flex-direction:row;align-items:center;justify-content:flex-end}.ui5-bar-root .ui5-bar-midcontent-container{padding-left:.5rem;padding-right:.5rem;display:flex;flex-direction:row;align-items:center;justify-content:center}:host([design=Footer]){background-color:var(--sapPageFooter_Background);border-top:.0625rem solid var(--sapPageFooter_BorderColor);box-shadow:none}:host([design=Subheader]){height:var(--_ui5_bar_subheader_height)}:host([design=FloatingFooter]){border-radius:var(--sapElement_BorderCornerRadius);background-color:var(--sapPageFooter_Background);box-shadow:var(--sapContent_Shadow1);border:none}::slotted(*){margin:0 .25rem}" };
var c = globalThis && globalThis.__decorate || function(o, e, t, i) {
  var n = arguments.length, r = n < 3 ? e : i === null ? i = Object.getOwnPropertyDescriptor(e, t) : i, l;
  if (typeof Reflect == "object" && typeof Reflect.decorate == "function")
    r = Reflect.decorate(o, e, t, i);
  else
    for (var s = o.length - 1; s >= 0; s--)
      (l = o[s]) && (r = (n < 3 ? l(r) : n > 3 ? l(e, t, r) : l(e, t)) || r);
  return n > 3 && r && Object.defineProperty(e, t, r), r;
};
let a = class extends w {
  get accInfo() {
    return {
      label: this.design
    };
  }
  constructor() {
    super(), this._handleResizeBound = this.handleResize.bind(this);
  }
  handleResize() {
    const e = this.getDomRef(), t = e.offsetWidth, i = Array.from(e.children).some((n) => n.offsetWidth > t / 3);
    e.classList.toggle("ui5-bar-root-shrinked", i);
  }
  get classes() {
    return {
      root: {
        "ui5-bar-root": !0
      }
    };
  }
  onBeforeRendering() {
    [...this.startContent, ...this.middleContent, ...this.endContent].forEach((e) => e.classList.add("ui5-bar-content"));
  }
  onEnterDOM() {
    h.register(this, this._handleResizeBound), this.getDomRef().querySelectorAll(".ui5-bar-content-container").forEach((e) => {
      h.register(e, this._handleResizeBound);
    }, this);
  }
  onExitDOM() {
    h.deregister(this, this._handleResizeBound), this.getDomRef().querySelectorAll(".ui5-bar-content-container").forEach((e) => {
      h.deregister(e, this._handleResizeBound);
    }, this);
  }
};
c([
  x({ type: p, defaultValue: p.Header })
], a.prototype, "design", void 0);
c([
  g({ type: HTMLElement })
], a.prototype, "startContent", void 0);
c([
  g({ type: HTMLElement, default: !0 })
], a.prototype, "middleContent", void 0);
c([
  g({ type: HTMLElement })
], a.prototype, "endContent", void 0);
a = c([
  R({
    tag: "ui5-bar",
    fastNavigation: !0,
    renderer: B,
    styles: H,
    template: E
  })
], a);
a.define();
const T = a;
export {
  T as default
};
//# sourceMappingURL=Bar.88d1fc95.mjs.map
