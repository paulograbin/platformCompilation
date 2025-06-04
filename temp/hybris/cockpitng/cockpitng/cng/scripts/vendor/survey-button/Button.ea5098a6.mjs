var h = (n, t, o) => new Promise((u, c) => {
  var s = (_) => {
    try {
      d(o.next(_));
    } catch (m) {
      c(m);
    }
  }, l = (_) => {
    try {
      d(o.throw(_));
    } catch (m) {
      c(m);
    }
  }, d = (_) => _.done ? u(_.value) : Promise.resolve(_.value).then(s, l);
  d((o = o.apply(n, t)).next());
});
import { e as f, l as a, s as y, a as E, U as I, p as r, c as z, b as $ } from "./parameters-bundle.css.11496d28.mjs";
import { g as R, i as T, a as x, e as N, I as P } from "./Icon.7310a395.mjs";
import { s as H } from "./slot.f280b696.mjs";
import { g as O } from "./AriaLabelHelper.e3d1fa46.mjs";
import { r as C, g as A, a as S } from "./CxQtxSurveyButton.96c49aa8.mjs";
import { i as j, a as D, b as L, c as F, d as w } from "./Device.8e41a90c.mjs";
import { s as M } from "./parameters-bundle.css.b6a86188.mjs";
const U = /* @__PURE__ */ new WeakMap(), p = (n, t) => {
  U.set(n, t);
}, V = (n) => Array.from(n).filter((t) => t.nodeType !== Node.COMMENT_NODE && (t.nodeType !== Node.TEXT_NODE || (t.nodeValue || "").trim().length !== 0)).length > 0;
var B;
(function(n) {
  n.Default = "Default", n.Positive = "Positive", n.Negative = "Negative", n.Transparent = "Transparent", n.Emphasized = "Emphasized", n.Attention = "Attention";
})(B || (B = {}));
const g = B;
function Y(n, t, o) {
  return f`<button type="button" class="ui5-button-root" ?disabled="${this.disabled}" data-sap-focus-ref  @focusout=${this._onfocusout} @focusin=${this._onfocusin} @click=${this._onclick} @mousedown=${this._onmousedown} @mouseup=${this._onmouseup} @keydown=${this._onkeydown} @keyup=${this._onkeyup} @touchstart="${this._ontouchstart}" @touchend="${this._ontouchend}" tabindex=${a(this.tabIndexValue)} aria-expanded="${a(this.accessibilityAttributes.expanded)}" aria-controls="${a(this.accessibilityAttributes.controls)}" aria-haspopup="${a(this.accessibilityAttributes.hasPopup)}" aria-label="${a(this.ariaLabelText)}" title="${a(this.buttonTitle)}" part="button">${this.icon ? J.call(this, n, t, o) : void 0}<span id="${a(this._id)}-content" class="ui5-button-text"><bdi><slot></slot></bdi></span>${this.hasButtonType ? W.call(this, n, t, o) : void 0}</button> `;
}
function J(n, t, o) {
  return o ? f`<${y("ui5-icon", t, o)} class="ui5-button-icon" name="${a(this.icon)}" accessible-role="${a(this.iconRole)}" part="icon" ?show-tooltip=${this.showIconTooltip}></${y("ui5-icon", t, o)}>` : f`<ui5-icon class="ui5-button-icon" name="${a(this.icon)}" accessible-role="${a(this.iconRole)}" part="icon" ?show-tooltip=${this.showIconTooltip}></ui5-icon>`;
}
function W(n, t, o) {
  return f`<span class="ui5-hidden-text">${a(this.buttonTypeText)}</span>`;
}
const Z = { key: "BUTTON_ARIA_TYPE_ACCEPT", defaultText: "Positive Action" }, G = { key: "BUTTON_ARIA_TYPE_REJECT", defaultText: "Negative Action" }, X = { key: "BUTTON_ARIA_TYPE_EMPHASIZED", defaultText: "Emphasized" };
C("@ui5/webcomponents-theming", "sap_fiori_3", () => h(void 0, null, function* () {
  return E;
}));
C("@ui5/webcomponents", "sap_fiori_3", () => h(void 0, null, function* () {
  return M;
}));
const q = { packageName: "@ui5/webcomponents", fileName: "themes/Button.css", content: ':host{vertical-align:middle}.ui5-hidden-text{position:absolute;clip:rect(1px,1px,1px,1px);user-select:none;left:-1000px;top:-1000px;pointer-events:none;font-size:0}:host(:not([hidden])){display:inline-block}:host{min-width:var(--_ui5_button_base_min_width);height:var(--_ui5_button_base_height);line-height:normal;font-family:var(--_ui5_button_fontFamily);font-size:var(--sapFontSize);text-shadow:var(--_ui5_button_text_shadow);border-radius:var(--_ui5_button_border_radius);cursor:pointer;background-color:var(--sapButton_Background);border:var(--sapButton_BorderWidth) solid var(--sapButton_BorderColor);color:var(--sapButton_TextColor);box-sizing:border-box;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.ui5-button-root{min-width:inherit;cursor:inherit;height:100%;width:100%;box-sizing:border-box;display:flex;justify-content:center;align-items:center;outline:none;padding:0 var(--_ui5_button_base_padding);position:relative;background:transparent;border:none;color:inherit;text-shadow:inherit;font:inherit;white-space:inherit;overflow:inherit;text-overflow:inherit;letter-spacing:inherit;word-spacing:inherit;line-height:inherit;-webkit-user-select:none;-moz-user-select:none;user-select:none}:host(:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover),:host(:not([hidden]):not([disabled]).ui5_hovered){background:var(--sapButton_Hover_Background);box-shadow:var(--sapContent_Interaction_Shadow);border:1px solid var(--sapButton_Hover_BorderColor);color:var(--sapButton_Hover_TextColor)}.ui5-button-icon{color:inherit;flex-shrink:0}:host([icon-end]) .ui5-button-root{flex-direction:row-reverse}:host([icon-end]) .ui5-button-icon{margin-inline-start:var(--_ui5_button_base_icon_margin)}:host([icon-only]) .ui5-button-root{min-width:auto;padding:0}:host([icon-only]) .ui5-button-text{display:none}.ui5-button-text{outline:none;position:relative;white-space:inherit;overflow:inherit;text-overflow:inherit}:host([has-icon]:not([icon-end])) .ui5-button-text{margin-inline-start:var(--_ui5_button_base_icon_margin)}:host([has-icon][icon-end]) .ui5-button-text{margin-inline-start:0}:host([disabled]){opacity:var(--sapContent_DisabledOpacity);pointer-events:unset;cursor:default}:host([has-icon]:not([icon-only])) .ui5-button-text{min-width:calc(var(--_ui5_button_base_min_width) - var(--_ui5_button_base_icon_margin) - 1rem)}:host([disabled]:active){pointer-events:none}:host([focused]) .ui5-button-root:after{content:"";position:absolute;box-sizing:border-box;left:.0625rem;top:.0625rem;right:.0625rem;bottom:.0625rem;border:var(--_ui5_button_focused_border);border-radius:var(--_ui5_button_focused_border_radius)}:host([design=Emphasized][focused]) .ui5-button-root:after{border-color:var(--_ui5_button_emphasized_focused_border_color)}:host([design=Emphasized][focused]) .ui5-button-root:before{content:"";position:absolute;box-sizing:border-box;left:.0625rem;top:.0625rem;right:.0625rem;bottom:.0625rem;border:var(--_ui5_button_emphasized_focused_border_before);border-radius:var(--_ui5_button_focused_border_radius)}.ui5-button-root::-moz-focus-inner{border:0}bdi{display:block;white-space:inherit;overflow:inherit;text-overflow:inherit}:host([ui5-button][active]:not([disabled]):not([non-interactive])){background-image:none;background-color:var(--sapButton_Active_Background);border-color:var(--sapButton_Active_BorderColor);color:var(--sapButton_Active_TextColor)}:host([design=Positive]){background-color:var(--sapButton_Accept_Background);border-color:var(--sapButton_Accept_BorderColor);color:var(--sapButton_Accept_TextColor)}:host([design=Positive]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]).ui5_hovered),:host([design=Positive]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover){background-color:var(--sapButton_Accept_Hover_Background);border-color:var(--sapButton_Accept_Hover_BorderColor);box-shadow:var(--sapContent_Positive_Shadow);color:var(--sapButton_Accept_Hover_TextColor)}:host([ui5-button][design=Positive][active]:not([non-interactive])){background-color:var(--sapButton_Accept_Active_Background);border-color:var(--sapButton_Accept_Active_BorderColor);color:var(--sapButton_Accept_Active_TextColor)}:host([design=Negative]){background-color:var(--sapButton_Reject_Background);border-color:var(--sapButton_Reject_BorderColor);color:var(--sapButton_Reject_TextColor)}:host([design=Negative]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]).ui5_hovered),:host([design=Negative]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover){background-color:var(--sapButton_Reject_Hover_Background);border-color:var(--sapButton_Reject_Hover_BorderColor);box-shadow:var(--sapContent_Negative_Shadow);color:var(--sapButton_Reject_Hover_TextColor)}:host([ui5-button][design=Negative][active]:not([non-interactive])){background-color:var(--sapButton_Reject_Active_Background);border-color:var(--sapButton_Reject_Active_BorderColor);color:var(--sapButton_Reject_Active_TextColor)}:host([design=Attention]){background-color:var(--sapButton_Attention_Background);border-color:var(--sapButton_Attention_BorderColor);color:var(--sapButton_Attention_TextColor)}:host([design=Attention]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]).ui5_hovered),:host([design=Attention]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover){background-color:var(--sapButton_Attention_Hover_Background);border-color:var(--sapButton_Attention_Hover_BorderColor);color:var(--sapButton_Attention_Hover_TextColor);box-shadow:var(--sapContent_Critical_Shadow)}:host([ui5-button][design=Attention][active]:not([non-interactive])){background-color:var(--sapButton_Attention_Active_Background);border-color:var(--sapButton_Attention_Active_BorderColor);color:var(--sapButton_Attention_Active_TextColor)}:host([design=Emphasized]){background-color:var(--sapButton_Emphasized_Background);border-color:var(--sapButton_Emphasized_BorderColor);border-width:var(--_ui5_button_emphasized_border_width);color:var(--sapButton_Emphasized_TextColor);font-weight:var(--_ui5_button_emphasized_font_weight)}:host([design=Emphasized]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]).ui5_hovered),:host([design=Emphasized]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover){background-color:var(--sapButton_Emphasized_Hover_Background);border-color:var(--sapButton_Emphasized_Hover_BorderColor);border-width:var(--_ui5_button_emphasized_border_width);color:var(--sapButton_Emphasized_Hover_TextColor);box-shadow:none}:host([ui5-button][design=Empasized][active]:not([non-interactive])){background-color:var(--sapButton_Emphasized_Active_Background);border-color:var(--sapButton_Emphasized_Active_BorderColor);color:var(--sapButton_Emphasized_Active_TextColor)}:host([design=Emphasized][focused]) .ui5-button-root:after{border-color:var(--sapContent_ContrastFocusColor);outline:none}:host([design=Transparent]){background-color:var(--sapButton_Lite_Background);color:var(--sapButton_Lite_TextColor);border-color:var(--sapButton_Lite_BorderColor)}:host([design=Transparent]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]).ui5_hovered),:host([design=Transparent]:not([active]):not([non-interactive]):not([_is-touch]):not([disabled]):hover){background-color:var(--sapButton_Lite_Hover_Background);border-color:var(--sapButton_Lite_Hover_BorderColor);box-shadow:var(--sapContent_Interaction_Shadow);color:var(--sapButton_Lite_Hover_TextColor)}:host([ui5-button][design=Transparent][active]:not([non-interactive])){background-color:var(--sapButton_Lite_Active_Background);border-color:var(--sapButton_Lite_Active_BorderColor);color:var(--sapButton_Active_TextColor)}:host([pressed][focused]) .ui5-button-root:after,:host([ui5-segmented-button-item][active][focused]) .ui5-button-root:after{border-color:var(--_ui5_button_pressed_focused_border_color);outline:none}:host([ui5-segmented-button-item][focused]:not(:last-child)) .ui5-button-root:after{border-top-right-radius:var(--_ui5_button_focused_inner_border_radius);border-bottom-right-radius:var(--_ui5_button_focused_inner_border_radius)}:host([ui5-segmented-button-item][focused]:not(:first-child)) .ui5-button-root:after{border-top-left-radius:var(--_ui5_button_focused_inner_border_radius);border-bottom-left-radius:var(--_ui5_button_focused_inner_border_radius)}' };
var i = globalThis && globalThis.__decorate || function(n, t, o, u) {
  var c = arguments.length, s = c < 3 ? t : u === null ? u = Object.getOwnPropertyDescriptor(t, o) : u, l;
  if (typeof Reflect == "object" && typeof Reflect.decorate == "function")
    s = Reflect.decorate(n, t, o, u);
  else
    for (var d = n.length - 1; d >= 0; d--)
      (l = n[d]) && (s = (c < 3 ? l(s) : c > 3 ? l(t, o, s) : l(t, o)) || s);
  return c > 3 && s && Object.defineProperty(t, o, s), s;
}, b;
let k = !1, v = null, e = b = class extends I {
  constructor() {
    super(), this._deactivate = () => {
      v && (v.active = !1);
    }, k || (document.addEventListener("mouseup", this._deactivate), k = !0);
    const t = (o) => {
      p(o, "button"), !this.nonInteractive && (this.active = !0);
    };
    this._ontouchstart = {
      handleEvent: t,
      passive: !0
    };
  }
  onEnterDOM() {
    this._isTouch = (j() || D()) && !L();
  }
  onBeforeRendering() {
    return h(this, null, function* () {
      const t = A("FormSupport");
      this.submits && !t && console.warn('In order for the "submits" property to have effect, you should also: import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";'), this.iconOnly = this.isIconOnly, this.hasIcon = !!this.icon, this.buttonTitle = this.tooltip || (yield R(this.icon));
    });
  }
  _onclick(t) {
    var u;
    if (this.nonInteractive)
      return;
    p(t, "button");
    const o = A("FormSupport");
    o && this.submits && o.triggerFormSubmit(this), F() && ((u = this.getDomRef()) == null || u.focus());
  }
  _onmousedown(t) {
    this.nonInteractive || this._isTouch || (p(t, "button"), this.active = !0, v = this);
  }
  _ontouchend() {
    this.active = !1, v && (v.active = !1);
  }
  _onmouseup(t) {
    p(t, "button");
  }
  _onkeydown(t) {
    p(t, "button"), (T(t) || x(t)) && (this.active = !0);
  }
  _onkeyup(t) {
    (T(t) || x(t)) && (this.active = !1);
  }
  _onfocusout() {
    this.nonInteractive || (this.active = !1, w() && (this.focused = !1));
  }
  _onfocusin(t) {
    this.nonInteractive || (p(t, "button"), w() && (this.focused = !0));
  }
  get hasButtonType() {
    return this.design !== g.Default && this.design !== g.Transparent;
  }
  get iconRole() {
    return this.icon ? "presentation" : "";
  }
  get isIconOnly() {
    return !V(this.text);
  }
  static typeTextMappings() {
    return {
      Positive: Z,
      Negative: G,
      Emphasized: X
    };
  }
  get buttonTypeText() {
    return b.i18nBundle.getText(b.typeTextMappings()[this.design]);
  }
  get tabIndexValue() {
    const t = this.getAttribute("tabindex");
    return t || (this.nonInteractive ? "-1" : this._tabIndex);
  }
  get showIconTooltip() {
    return this.iconOnly && !this.tooltip;
  }
  get ariaLabelText() {
    return O(this);
  }
  static onDefine() {
    return h(this, null, function* () {
      b.i18nBundle = yield S("@ui5/webcomponents");
    });
  }
};
i([
  r({ type: g, defaultValue: g.Default })
], e.prototype, "design", void 0);
i([
  r({ type: Boolean })
], e.prototype, "disabled", void 0);
i([
  r()
], e.prototype, "icon", void 0);
i([
  r({ type: Boolean })
], e.prototype, "iconEnd", void 0);
i([
  r({ type: Boolean })
], e.prototype, "submits", void 0);
i([
  r()
], e.prototype, "tooltip", void 0);
i([
  r({ defaultValue: void 0 })
], e.prototype, "accessibleName", void 0);
i([
  r({ defaultValue: "" })
], e.prototype, "accessibleNameRef", void 0);
i([
  r({ type: Object })
], e.prototype, "accessibilityAttributes", void 0);
i([
  r({ type: Boolean })
], e.prototype, "active", void 0);
i([
  r({ type: Boolean })
], e.prototype, "iconOnly", void 0);
i([
  r({ type: Boolean })
], e.prototype, "focused", void 0);
i([
  r({ type: Boolean })
], e.prototype, "hasIcon", void 0);
i([
  r({ type: Boolean })
], e.prototype, "nonInteractive", void 0);
i([
  r({ noAttribute: !0 })
], e.prototype, "buttonTitle", void 0);
i([
  r({ type: Object })
], e.prototype, "_iconSettings", void 0);
i([
  r({ defaultValue: "0", noAttribute: !0 })
], e.prototype, "_tabIndex", void 0);
i([
  r({ type: Boolean })
], e.prototype, "_isTouch", void 0);
i([
  H({ type: Node, default: !0 })
], e.prototype, "text", void 0);
e = b = i([
  z({
    tag: "ui5-button",
    languageAware: !0,
    renderer: $,
    template: Y,
    styles: q,
    dependencies: [P]
  }),
  N("click")
], e);
e.define();
const st = e;
export {
  st as default
};
//# sourceMappingURL=Button.ea5098a6.mjs.map
