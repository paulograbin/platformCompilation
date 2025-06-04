/**
 * Add tooltip for zk borderlayout related icon
 */
zk.afterLoad('zul.layout', function() {
    const _xBorderlayout = {};
    const tooltipCollapse = msg.common_collapse,
          tooltipExpand = msg.common_expand;

    const setTitleForIcon = (component, selector, text) => {
        jq(component.$n()).find(selector).each(function(index, icon){
            icon.setAttribute('title', text);
        });
    };

    zk.override(zul.layout.Borderlayout.prototype, _xBorderlayout, {
        bind_: function bind_() {
            _xBorderlayout.bind_.apply(this, arguments);

            setTitleForIcon(this, 'span.z-north-splitter-button i.z-north-icon', tooltipCollapse);
            setTitleForIcon(this, 'span.z-south-splitter-button i.z-south-icon', tooltipCollapse);
            setTitleForIcon(this, 'span.z-east-splitter-button i.z-east-icon', tooltipCollapse);
            setTitleForIcon(this, 'span.z-west-splitter-button i.z-west-icon', tooltipCollapse);

            setTitleForIcon(this, 'div.z-north-collapsed', tooltipExpand);
            setTitleForIcon(this, 'div.z-south-collapsed', tooltipExpand);
            setTitleForIcon(this, 'div.z-east-collapsed', tooltipExpand);
            setTitleForIcon(this, 'div.z-west-collapsed', tooltipExpand);
        }
    });
});
