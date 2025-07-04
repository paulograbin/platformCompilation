<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="hac" uri="/WEB-INF/custom.tld" %> 
<html>
<head>
<title>Performance</title>
<link rel="stylesheet" href="<c:url value="/static/css/table.css"/>" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="<c:url value="/static/css/monitoring/performance.css"/>" type="text/css" media="screen, projection" />

<script type="text/javascript" src="<c:url value="/static/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/history.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/monitoring/performance.js?p=1"/>"></script>

</head>
<body>

	<div class="prepend-top span-17 colborder" id="content">
		<button id="toggleSidebarButton">&gt;</button>
		<div class="marginLeft marginBottom">
			<h2>Performance Tests</h2>
			<hac:note additionalCssClass="marginBottom">
				It is not possible to run different tests simultaneously. Tests started at the same time are queued and wait for their turn.
			</hac:note>			
			<div id="tabs">
				<ul>
					<li><a href="#tabs-1">LINPACK</a>
					</li>
					<li><a href="#tabs-2">SQL</a>
					</li>
					<li><a href="#tabs-3">SQL max</a>
					</li>
					<li><a href="#tabs-4">Overall</a>
					</li>
				</ul>
				<div id="tabs-1">
					<button id="runLinpack" data-url="<c:url value="/monitoring/performance/linpack/"/>">Run LINPACK</button>
					<pre id="resultLinpack" class="resultBox"></pre>
				</div>
				<div id="tabs-2">
					<form id="runSQLForm">
						<dl>
							<dt>SQL SELECT statement</dt>
							<dd>
								<select name="sqlStatementKey" id="sqlStatementKey">
									<c:forEach items="${availableSqlStatements}" var="sqlStatement">
										<option value="${sqlStatement.key}">${sqlStatement.value}</option>
									</c:forEach>
								</select>
								<div>
									<div>To use a different SQL statement, enter it as a property in local.properties. Follow the format:  <code>hac.performanceTest.statement.*</code></div>
									<div>Example: <code>hac.performanceTest.statement.selectFromMetainformations=SELECT * FROM metainformations</code></div>
								</div>
							</dd>
							<dt>Seconds to run</dt>
							<dd>
								<input name="number" id="seconds" type="number" value="3" min="1" />
							</dd>
							<dt>Maximum resultset count</dt>
							<dd>
								<input name="count" id="count" type="number" value="1" min="1" />
							</dd>
						</dl>
						<button id="runSQL" data-url="<c:url value="/monitoring/performance/sql/"/>">Run SQL</button>
					</form>
					<div id="resultSQL" class="resultBox">
						<dl>
							<dt>Total statements executed</dt>
							<dd id="statementsCount"></dd>
							<dt>Statements per Second</dt>
							<dd id="statementsPerSecond"></dd>
							<dt>Average Statement Execution Time</dt>
							<dd id="timePerStatement"></dd>
						</dl>
					</div>
				</div>
				<div id="tabs-3">
					<button id="runSQLMax" data-url="<c:url value="/monitoring/performance/sqlmax/"/>">Run SQL max</button>
					<div id="resultMax" class="resultBox">
						<dl>
							<dt>Time to add 10.000 rows</dt>
							<dd>
								<span id="durationAdded"></span> ms
							</dd>
							<dt>Time to add 10.000 rows using max() queries</dt>
							<dd>
								<span id="durationAddedMax"></span> ms
							</dd>
							<dt>Time to add 10.000 rows using max() queries and index</dt>
							<dd>
								<span id="durationAddedMaxIndex"></span> ms
							</dd>
						</dl>
					</div>
				</div>
				<div id="tabs-4">
					<form id="overallForm">
						<dl>
							<dt>Seconds per loop</dt>
							<dd>
								<input name="secondsPerLoop" id="secondsPerLoop" type="number" value="1" min="1"/>
							</dd>
						</dl>
						<button id="runOverall" data-url="<c:url value="/monitoring/performance/overall/"/>">Run</button>
					</form>
					<div id="resultOverall" class="resultBox">
						<table id="resultOverallTable">
							<thead>
								<tr>
									<th>Test name</th>
									<th>Count</th>
									<th>Count/s</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="span-6 last" id="sidebar1">
		<div class="prepend-top">
			<h3 class="caps">Page description</h3>
			<div class="box">
				<div class="quiet">
					This page enables you to run a test that computes LINPACK benchmarks to measure the performance of your system. <br /><br />
				   <hr />
					<hac:note>
						This test may last a few minutes. To get accurate results, the server should not be under load during the test.
					</hac:note>
				</div>
			</div>
		</div>
	</div>

	<div class="span-6 last" id="sidebar2">
		<div class="prepend-top">
			<h3 class="caps">Page description</h3>
			<div class="box">
				<div class="quiet">
					This page enables you to measure round trip times and the database performance.<br /><br />
					<hr />
					<hac:note>
						Even if you can measure how long specific statements last, it should mainly be used to test the network latency to the database server.
					</hac:note>
				</div>
			</div>
		</div>
	</div>

	<div class="span-6 last" id="sidebar3">
		<div class="prepend-top">
			<h3 class="caps">Page description</h3>
			<div class="box">
				<div class="quiet">
					This page enables you to run the performance test of the database with the SQL <strong>max()</strong> command.
				</div>
			</div>
		</div>
	</div>

	<div class="span-6 last" id="sidebar4">
		<div class="prepend-top">
			<h3 class="caps">Page description</h3>
			<div class="box">
				<div class="quiet">
					This page enables you to run miscellaneous performance tests:<br><br>
					<div id="overallTestNames" class="quiet">
						<ul>
							<c:forEach items="${overallTests}" var="test">
								<li><c:out value="${test.testName}" /></li>
							</c:forEach>
						</ul>
				    </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

