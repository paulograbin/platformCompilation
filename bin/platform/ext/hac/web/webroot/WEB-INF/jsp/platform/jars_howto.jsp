<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="hac" uri="/WEB-INF/custom.tld" %>
<html>
<head>
    <title>Classpath Analyzer</title>
    <link rel="stylesheet" href="<c:url value="/static/css/table.css"/>" type="text/css" media="screen, projection"/>

    <script type="text/javascript" src="<c:url value="/static/js/jquery.dataTables.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/js/history.js"/>"></script>
</head>
<body>
<div class="prepend-top span-17 colborder" id="content">
    <button id="toggleSidebarButton">&gt;</button>
    <div class="marginLeft" id="inner">
        <h2>
            Classpath Analyzer
        </h2>
        <p>
            To activate this feature, you need to add a property definition <strong>classloader.monitor.enabled</strong>
            with required value.
            <br>
            This must be followed by rebuilding the SAP Commerce Suite and restarting your application server to collect
            the data.
            <br>
            Refer to the documentation for more information.
        </p>
    </div>
</div>
<div class="span-6 last" id="sidebar">
    <div class="prepend-top" id="recent-reviews">
        <h3 class="caps">
            Page description
        </h3>
        <div class="box">
            <div class="quiet">
                This page enables you to search for the same classes loaded from different JAR files. For the scope of
                the hybris platform classloader or for a chosen web application, you can determine:<br><br>
                <ul>
                    <li>The order of loading JAR files at run time</li>
                    <li>Which classes are referenced in more than one JAR file</li>
                </ul>
            </div>
        </div>
        <h3 class="caps">See also in the documentation</h3>
        <div class="box">
            <ul>
                <li>
                    <a href="${wikiClassLoaderMonitor}" target="_blank" rel="noopener noreferrer" class="quiet">
                        Classpath Analyzer
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>

