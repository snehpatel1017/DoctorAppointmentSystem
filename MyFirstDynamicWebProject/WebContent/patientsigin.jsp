<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.projectservice.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<main>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header">Sigin Here</div>
					<%if(session.getAttribute("invalid")!=null){
						 InvalidMessage m = (InvalidMessage)session.getAttribute("invalid");
						%>
						<div class="alert alert-danger" role="alert">
                            <%=m.getMessage() %>
                        </div>
						<%	
						session.removeAttribute("invalid");
					}
						%>
					<div class="card-boady">
						<form action="SiginServlet" method="post">
							<div class="form-group" style="margin-top: 5px">
								<label for="exampleInputEmail1"><span
									class="glyphicon glyphicon-user" style="margin-left: 8px"></span>
									Enter Your Name :</label> <input type="text" name="name"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter name" oninvalid="alert('You must enter your name)" required>
							</div>
							<div class="form-group">
								<label for="exampleInputId"><span
									class="glyphicon glyphicon-user" style="margin-left: 8px"></span>
									Enter Yout UserId</label> <input type="text" name="uname"
									class="form-control" id="exampleInputId"
									aria-describedby="emailHelp" placeholder="Enter userid" oninvalid="alert('You must enter userid)" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1"><span
									class="glyphicon glyphicon-lock" style="margin-left: 8px"></span>
									Password</label> <input type="password" name="pass"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password" oninvalid="alert('You must enter password)" required>
							</div>
							<div class="form-group">
								<label for="exampleInputCPassword1"><span
									class="glyphicon glyphicon-lock" style="margin-left: 8px"></span>
									Confirm Password</label> <input type="password" name="cpass"
									class="form-control" id="exampleInputCPassword1"
									placeholder="Password" oninvalid="alert('You must enter confirm password)" required>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
					<div class="class-footer">
						You Have an Account <a
							href="http://localhost:8080/MyFirstDynamicWebProject/login.jsp">Click
							here</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</main>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>