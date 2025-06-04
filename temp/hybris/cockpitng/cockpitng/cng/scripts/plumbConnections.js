var conn_visible = false;
var cng_drawmode = 0;
var selected = null;
var jsPlumbInstance = null;

function initJsPlumbInstance()
{
    if (!jsPlumbInstance)
    {
        jsPlumbInstance = jsPlumb.newInstance({
            container: document.querySelector(".z-page")   //.cng-adminmode
        })
    }
    return jsPlumbInstance;
}

function createWidgetConnection(source,target,label,s_index,t_index,isTarget, component, isSourceStub, isTargetStub)
{
   source = document.querySelector("#" + source);
   target = document.querySelector("#" + target);

    var outputAnchors = [ [ 0.1, 0, 0, -1 ],[ 0.2, 0, 0, -1 ],[ 0.3, 0, 0, -1 ],[ 0.4, 0, 0, -1 ],[ 0.5, 0, 0, -1 ],
        [ 0.6, 0, 0, -1 ],[ 0.7, 0, 0, -1 ],[ 0.8, 0, 0, -1 ],[ 0.9, 0, 0, -1 ],
        [ 0.1, 1, 0, 1 ],[ 0.2, 1, 0, 1 ],[ 0.3, 1, 0, 1 ],[ 0.4, 1, 0, 1 ],[ 0.5, 1, 0, 1 ],
        [ 0.6, 1, 0, 1 ],[ 0.7, 1, 0, 1 ],[ 0.8, 1, 0, 1 ],[ 0.9, 1, 0, 1 ]];

    var inputAnchors = [[ 0, 0.1, -1, 0 ],[ 1, 0.1, 1, 0 ],[ 0, 0.2, -1, 0 ],[ 1, 0.2, 1, 0 ],[ 0, 0.3, -1, 0 ],[ 1, 0.3, 1, 0 ],
        [ 0, 0.4, -1, 0 ],[ 1, 0.4, 1, 0 ],[ 0, 0.5, -1, 0 ],[ 1, 0.5, 1, 0 ],[ 0, 0.6, -1, 0 ],[ 1, 0.6, 1, 0 ],
        [ 0, 0.7, -1, 0 ],[ 1, 0.7, 1, 0 ],[ 0, 0.8, -1, 0 ],[ 1, 0.8, 1, 0 ],[ 0, 0.9, -1, 0 ],[ 1, 0.9, 1, 0 ]];


    var stubAnchors = [[ 0.05, 1, 0, 1 ], [ 0.1, 1, 0, 1 ],[ 0.2, 1, 0, 1 ],[ 0.3, 1, 0, 1 ],[ 0.4, 1, 0, 1 ],[ 0.5, 1, 0, 1 ],
        [ 0.6, 1, 0, 1 ], [ 0.7, 1, 0, 1 ], [ 0.8, 1, 0, 1 ], [ 0.9, 1, 0, 1 ], [ 0.95, 1, 0, 1 ]];



    var stub = [20 + 4 * s_index, 26 + 3 * t_index];
    var cngConnectionLabelClass = "cngConnectionLabelEmpty";
    if(label!=null && label!="")
    {
        cngConnectionLabelClass="cngConnectionLabel";
    }

    var cngConnectionEndpointClass = "cngConnectionEndpoint";
    var cngConnectorClass = "cngConnection";
    if(isTarget)
    {
        cngConnectorClass+= " cngTarget";
        cngConnectionLabelClass+= " cngTarget";
        cngConnectionEndpointClass+= " cngTarget";
    }

    var connectors=[{type: "Flowchart", options: { stub:stub, midpoint:0.6, cssClass:cngConnectorClass }},
        {type: "Bezier", options: { curviness:150, cssClass:cngConnectorClass }},
        {type: "StateMachine", options: { curviness:50, cssClass:cngConnectorClass }}];

    var connectorType=connectors[0];

    if(cng_drawmode && cng_drawmode < 3 && cng_drawmode >= 0)
        connectorType=connectors[cng_drawmode];

    var inputAnchor;
    var outputAnchor;

    if(isSourceStub && !isTargetStub){
        inputAnchor= inputAnchors[t_index];
        outputAnchor = stubAnchors[s_index+t_index];
    }else if(!isSourceStub && isTargetStub){
        inputAnchor = stubAnchors[s_index+t_index];
        outputAnchor = outputAnchors[s_index];
    }
    else{
        inputAnchor= inputAnchors[t_index];
        outputAnchor= outputAnchors[s_index];
    }
    var ommitConnection=false;
    if(document.getElementsByClassName('no_stubs').length>0){
        ommitConnection =isSourceStub? !isTargetStub: isTargetStub;
    }


    if(!ommitConnection){
        var connection = jsPlumbInstance.connect({
            source:jsPlumbInstance.addEndpoint(source,{
                anchor: outputAnchor,
                endpoint: {
                    type:  "Rectangle",
                    options: {
                      cssClass: cngConnectionEndpointClass,
                      width: 12,
                      height: 12,
                      maxConnections: 1000
                   }
                }
             }),
            target:jsPlumbInstance.addEndpoint(target,{
                anchor: inputAnchor,
                endpoint: {
                    type:  "Rectangle",
                    options: {
                      cssClass: cngConnectionEndpointClass,
                      width: 8,
                      height: 8,
                      maxConnections: 1000
                   }
                }
             }),
            connector:connectorType,
            overlays:[
                {type:"Arrow", options:{ location: 1 }},
                {type:"Label", options:{ label:label, location:0.5, cssClass:cngConnectionLabelClass }}
            ]
        });
        connection.setHoverPaintStyle(null);
    }
}

function findFirstUnderlyingNonSvgElement(x, y, el) {
    $(el).hide();
    var bottomEl = document.elementFromPoint(x, y);
    if ($(bottomEl).is('svg')) {
        bottomEl = findFirstUnderlyingNonSvgElement(x, y, bottomEl);
    }
    $(el).show();
    return bottomEl;
}


function drawSelection(componentId)
{
    var selectionConnector = {type: "Straight", options: {cssClass:"cngSelection"}};
    var component = document.querySelector("#" + componentId);
    if(component)
    {
        jsPlumbInstance.connect({
            source:jsPlumbInstance.addEndpoint(component,{anchor:[0,0,0,0],endpoint:"Blank"}),
            target:jsPlumbInstance.addEndpoint(component,{anchor:[0,1,0,0],endpoint:"Blank"}),
            connector:selectionConnector,
        });
        jsPlumbInstance.connect({
            source:jsPlumbInstance.addEndpoint(component,{anchor:[0,1,0,0],endpoint:"Blank"}),
            target:jsPlumbInstance.addEndpoint(component,{anchor:[1,1,0,0],endpoint:"Blank"}),
            connector:selectionConnector,
        });
        jsPlumbInstance.connect({
            source:jsPlumbInstance.addEndpoint(component,{anchor:[1,1,0,0],endpoint: "Blank"}),
            target:jsPlumbInstance.addEndpoint(component,{anchor:[1,0,0,0],endpoint:"Blank"}),
            connector:selectionConnector,
        });
        jsPlumbInstance.connect({
            source:jsPlumbInstance.addEndpoint(component,{anchor:[1,0,0,0],endpoint: "Blank"}),
            target:jsPlumbInstance.addEndpoint(component,{anchor:[0,0,0,0],endpoint: "Blank"}),
            connector:selectionConnector,
        });
    }

}

function cngShowlabels(val)
{
    if(val)
        document.body.className+= " cng-connectionLabelsVisible";
    else
        document.body.className=document.body.className.replace(" cng-connectionLabelsVisible","");
}

function cngShowinputs(val)
{
    if(val)
        document.body.className+= " cng-targetConnectionsVisible";
    else
        document.body.className=document.body.className.replace(" cng-targetConnectionsVisible","");
}

function cngShowConnections(val)
{
    const cngConnectionsVisible = " cng-connectionsVisible";
    if(val)
    {
        if(document.body.className.search(cngConnectionsVisible) < 0)
        {
            document.body.className+= cngConnectionsVisible;
        }
    }
    else
    {
         document.body.className=document.body.className.replace(cngConnectionsVisible,"");
    }
}

function selectWidgetConnections(widgetID)
{
    if(conn_visible)
    {
        if(selected === widgetID && widgetID != null)
        {
            selected = null;
        }
        else
        {
            selected = widgetID;
        }
        drawConnections(selected);
        drawSelection(selected);
    }
}

function cngResetConnections()
{
    if (!jsPlumbInstance) {
        initJsPlumbInstance();
    }

    if(jsPlumbInstance) {
        selected=null;
        cngShowConnections(false);

        jsPlumbInstance.removeAllEndpoints(document.querySelector(".z-page"), true);
        jsPlumbInstance.deleteEveryConnection();
    }
}

function showConnectionsChecked(event)
{
    cngResetConnections();

    conn_visible = event.data;
    if(event.data && drawConnections)
    {
        drawConnections(null);
    }
}


function drawConnections(uid)
{
    cngShowConnections(true);
    drawConnectionsFunction(uid);
}

function drawConnectionsRequest()
{
    cngResetConnections();

    conn_visible = true;

    drawConnections(null);
}
