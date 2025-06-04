const t = typeof document == "undefined", e = {
  get userAgent() {
    return t ? "" : navigator.userAgent;
  },
  get touch() {
    return t ? !1 : "ontouchstart" in window || navigator.maxTouchPoints > 0;
  },
  get ie() {
    return t ? !1 : /(msie|trident)/i.test(e.userAgent);
  },
  get chrome() {
    return t ? !1 : !e.ie && /(Chrome|CriOS)/.test(e.userAgent);
  },
  get firefox() {
    return t ? !1 : /Firefox/.test(e.userAgent);
  },
  get safari() {
    return t ? !1 : !e.ie && !e.chrome && /(Version|PhantomJS)\/(\d+\.\d+).*Safari/.test(e.userAgent);
  },
  get webkit() {
    return t ? !1 : !e.ie && /webkit/.test(e.userAgent);
  },
  get windows() {
    return t ? !1 : navigator.platform.indexOf("Win") !== -1;
  },
  get iOS() {
    return t ? !1 : !!navigator.platform.match(/iPhone|iPad|iPod/) || !!(e.userAgent.match(/Mac/) && "ontouchend" in document);
  },
  get android() {
    return t ? !1 : !e.windows && /Android/.test(e.userAgent);
  },
  get androidPhone() {
    return t ? !1 : e.android && /(?=android)(?=.*mobile)/i.test(e.userAgent);
  },
  get ipad() {
    return t ? !1 : /ipad/i.test(e.userAgent) || /Macintosh/i.test(e.userAgent) && "ontouchend" in document;
  }
};
let i, s, n;
const o = () => {
  if (t || !e.windows)
    return !1;
  if (i === void 0) {
    const r = e.userAgent.match(/Windows NT (\d+).(\d)/);
    i = r ? parseFloat(r[1]) : 0;
  }
  return i >= 8;
}, d = () => {
  if (t || !e.webkit)
    return !1;
  if (s === void 0) {
    const r = e.userAgent.match(/(webkit)[ /]([\w.]+)/);
    s = r ? parseFloat(r[1]) : 0;
  }
  return s >= 537.1;
}, a = () => {
  if (t)
    return !1;
  if (n === void 0) {
    if (e.ipad) {
      n = !0;
      return;
    }
    if (e.touch) {
      if (o()) {
        n = !0;
        return;
      }
      if (e.chrome && e.android) {
        n = !/Mobile Safari\/[.0-9]+/.test(e.userAgent);
        return;
      }
      let r = window.devicePixelRatio ? window.devicePixelRatio : 1;
      e.android && d() && (r = 1), n = Math.min(window.screen.width / r, window.screen.height / r) >= 600;
      return;
    }
    n = e.ie && e.userAgent.indexOf("Touch") !== -1 || e.android && !e.androidPhone;
  }
}, g = () => e.safari, l = () => e.chrome, u = () => (a(), (e.touch || o()) && n), f = () => (a(), e.touch && !n), c = () => t ? !1 : !u() && !f() || o(), h = () => u() && c();
export {
  u as a,
  h as b,
  g as c,
  c as d,
  l as e,
  f as i
};
//# sourceMappingURL=Device.8e41a90c.mjs.map
