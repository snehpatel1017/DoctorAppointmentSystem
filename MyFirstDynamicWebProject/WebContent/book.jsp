<%@page import="sun.text.normalizer.ICUBinary.Authenticate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
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
	<%@page import="com.projectservice.* , com.pojo.*"%>
	<%
      
      response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
     response.setHeader("Pragma","no-cache");
     response.setHeader("Expires","0");
      if(session.getAttribute("patientId")==null){
    	  throw new Exception("Login First");
      }
      %>
	<%@include file="navbar.jsp"%>
	<%
      String doctorid = (String)request.getAttribute("doctorid");
      Authentication service = new Authentication();
      DoctorInfo d = service.getdoctorbydoctorid(doctorid);
     
      %>



	<div class="container-fluid" style="margin-top: 100px">
		<table class="table table-bordered table-hover table-responsive-sm"
			style="margin-left: auto; width: 250px; font-size: 19px; margin-right: auto;">
			<caption>&nbsp; Make an Appointment</caption>
			<tr>
				<td>
					<div class="card">
						<div class="card-boady" style="margin-left: 8px">
							<form action='bookingappointmentservlet'>
								<div class="form-group" style="margin-top: 5px">
									Doctor Name:
									<%=d.getname() %>
								</div>
								<div class="form-group">
									Doctor Type :
									<%=d.gettype() %>
								</div>
								<div class="form-group">
									<input type="hidden" name="doctorId"
										value="<%=d.getdoctorId() %>"> <label
										for="exampleInputDate">Enter the Date <span
										class="glyphicon glyphicon-calendar" style="margin-left: 8px"></span>
										:
									</label> <input type="date" name="appointmentdate"
										id="exampleInputDate">
								</div>
								<input type="submit" value="submit">
							</form>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

