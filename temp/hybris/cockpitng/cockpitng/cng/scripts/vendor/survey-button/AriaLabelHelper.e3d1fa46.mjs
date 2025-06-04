const b = (t) => {
  const e = t;
  return e.accessibleNameRef ? f(t) : e.accessibleName ? e.accessibleName : void 0;
}, f = (t) => {
  var n, i;
  const e = (i = (n = t.accessibleNameRef) == null ? void 0 : n.split(" ")) != null ? i : [], r = t.getRootNode();
  let s = "";
  return e.forEach((a, l) => {
    const c = r.querySelector(`[id='${a}']`), o = `${c && c.textContent ? c.textContent : ""}`;
    o && (s += o, l < e.length - 1 && (s += " "));
  }), s;
};
export {
  b as g
};
//# sourceMappingURL=AriaLabelHelper.e3d1fa46.mjs.map
