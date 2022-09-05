<%@page import="com.projectservice.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

	<%@page
		import="com.loginpage.LoginDao, java.sql.*,java.lang.*,java.util.*,com.pojo.*"%>
	<%
response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");

if(session.getAttribute("doctorId")==null)response.sendRedirect("login.jsp"); 
Authentication service = new Authentication();
DoctorInfo doc = service.getdoctorbydoctorid((String)session.getAttribute("doctorId"));
%>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><span
				class="glyphicon glyphicon-user"></span>&nbsp;<%=doc.getname() %></a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a
				href="http://localhost:8080/MyFirstDynamicWebProject/doctorwelcom.jsp">Home</a></li>
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

	Welcome....<%=doc.getname() %>
	<br>
	<hr>
	<%
   LoginDao d = new LoginDao();
   String doctorid = session.getAttribute("doctorId").toString();
   
   ArrayList<appointment> a = service.bookedappointment(doctorid);
   if(a.size() > 0){
    %><table class="table table-bordered table-hover table-sm">
		<thead>
			<tr>
				<th scope="col">Patient Name</th>
				<th scope="col">Appointment Date</th>
				<th scope="col">Prescription</th>
				<th scope="col">Close Appointment</th>
			</tr>
		</thead>
		<tbody>
			<%
      for(appointment l : a){
    	  PatientInfo p = service.getpatient(l.getpatientid());
	  %>
			<tr>
				<td>
					<%
	   out.print(p.getname());%>
				</td>
				<td>
					<%
	   out.print(l.getdate());%>
				</td>
				<td>
					<form action='priciptionservlet'>
						<input type="hidden" name="appointmentdate"
							value="<%=l.getdate()%>"> <input type="hidden"
							name="patientid" value="<%=p.getid()%>">
						<div>
							<input type="text" name='priciption'
								aria-label="Recipient's username"
								aria-describedby="button-addon2">&nbsp;
							<button class="btn btn-outline-secondary btn-sm" type="submit"
								id="button-addon2">Update</button>
						</div>
					</form>
				</td>
				<td>
					<form action="statusservlet">
						<input type="hidden" name="appointmentdate"
							value="<%=l.getdate()%>"> <input type="hidden"
							name="patientid" value="<%=p.getid()%>">
						<button type="submit" class="btn btn-outline-dark btn-sm">Close</button>
					</form>
				</td>
			</tr>
			<%
    }%>
		</tbody>
	</table>
	<%} %>
	<br>
	<br>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>