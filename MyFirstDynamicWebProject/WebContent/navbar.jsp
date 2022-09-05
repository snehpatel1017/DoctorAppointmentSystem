<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><span
				class="glyphicon glyphicon-user"></span>&nbsp;<%=session.getAttribute("patientName") %></a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a
				href="http://localhost:8080/MyFirstDynamicWebProject/welcom.jsp">Home</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><form action="Logout">
					<button style="margin-top: 8px" class="btn">
						<span class="glyphicon glyphicon-log-out"></span> Logout
					</button>
				</form></li>
		</ul>
	</div>
</nav>
