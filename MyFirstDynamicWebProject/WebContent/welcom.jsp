<%@page import="com.projectservice.Authentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp" import="java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<%@include file="navbar.jsp" %>
<%@ page import="com.welcomservlet.Welcomdao , java.sql.* ,com.BookAppointment.BookAppointmentDao,java.util.*,com.pojo.*" %>
 
   <%
   
   response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
   response.setHeader("Pragma","no-cache");
   response.setHeader("Expires","0");
      if(session.getAttribute("patientId")==null){
    	  throw new Exception("Login First");
      }
      %>
      Welcome <% out.print(session.getAttribute("patientName").toString()); %>
      <br>
      <hr>
      <br>
      <%
      //----------------Booked Appointment---------------------------------------------------
        Authentication service = new Authentication(); 
        String patientid = (String)session.getAttribute("patientId");
        ArrayList<appointment>booked = service.bookap(patientid);
        if(booked.size() > 0){        	 
        	%>        	
        
        <table class="table table-bordered table-hover table-sm">
         <caption>Your booked appointments</caption>
        <thead>
			<tr>
      <th scope="col">Doctor Name</th>
      <th scope="col">Type</th>
      <th scope="col">City</th>
      <th scope="col">Phone</th>
      <th scope="col">Prescription</th>
      <th scope="col">Status</th>
      <th scope="col">Appointment Date</th>
      <th scope="col">Delete Appointment</th> 
    </tr>
    </thead>
        <tbody>      
        <%for(appointment l : booked){
        	 DoctorInfo d = service.getdoctorbydoctorid(l.getdoctorid());
        	 %><tr><td><%=d.getname() %></td><td><%=d.gettype() %></td><td><%=d.getcity() %></td><td><%=d.getphone_no() %></td>
        	<td>
        	<%=l.getpriciption()%></td><td><%=l.getstatus() %></td><td><%=l.getdate() %></td>
        	<td>
        	<form action="deleteservlet">
        	<input type='hidden' name='doctorId' value='<%=d.getdoctorId() %>'>
        	<input type='hidden' name='appointmentdate' value='<%=l.getdate() %>'>
        	<button type="submit" class="btn btn-outline-dark btn-sm">Delete</button>
        	</form>
        	</td></tr>
        <%}%>
   	  </tbody></table>
       <%}%>

      
            
    <%//--------------------Browse Doctor by City------------------------------------
        String city = request.getParameter("city");       
		if(city != null){
			
			 ArrayList<DoctorInfo> dl = service.doctorlist(city);
			 if(dl.size() > 0){
				
			%>
			<hr>
            <br>
			<table class="table table-bordered table-hover table-sm">
			 <caption>List of Doctor in  City <%=city %></caption>
			  <thead>
			<tr>
      <th scope="col">Doctor Name</th>
      <th scope="col">Type</th>
      <th scope="col">Phone</th>
      <th scope="col">Book Appointment</th>
    </tr>
    </thead>
    <tbody>
			<%
			
			for(DoctorInfo d : dl){
				%>
				<tr>
				<td><%=d.getname()%></td><td><%=d.gettype()%></td><td><%=d.getphone_no()%></td>
				<td>
				<form action="bookservlet" method="post">
				<input type="hidden" name="doctorId" value="<%=d.getdoctorId()%>">
				<button type="submit" class="btn btn-outline-dark btn-sm">Book</button>
				</form>
				</td>
				</tr>
				<% 				
			}
			%></tbody></table><%
			}
			 else{
				 out.print("No Doctor Found ");
			 }
		}
		
		%>    
      <hr>
      <br>
 
    Enter the City and Type Of Doctor :<br>
    <form action="welcom.jsp" method="post">
    <br>
    <label for="choosecity">Choose an City : </label>
    <select name="city" id="choosecity" oninvalid="alert('You must select City!');" required>
      <option value=""  selected disabled hidden>Choose an  City</option>
           <%           
           ResultSet rs = Welcomdao.cities(); 
           while(rs.next()){
        	   %>
        	   <option value="<%out.print(rs.getString(1));%>"><%out.print(rs.getString(1)); %></option>
            <% }
          rs.close();%>
    </select>
   &nbsp;
   <label for="choosetype">Choose Type of Daoctor :</label>
    <select name="type" id="choosetype">
      <option value="null" hidden>Choose an  Type</option>
            <%           
            rs = Welcomdao.types(); 
           while(rs.next()){
        	   %>
        	   <option value="<%out.print(rs.getString(1));%>"><%out.print(rs.getString(1)); %></option>
            <% }%>
    </select>
    &nbsp;
   <button type="submit" class="btn btn-outline-dark btn-sm">Search</button>
    </form>
   
</body>
</html>