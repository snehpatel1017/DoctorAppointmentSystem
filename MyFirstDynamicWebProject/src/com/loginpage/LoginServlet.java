package com.loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;


import com.doctorside.EnterDoctor;
import com.projectservice.GetPass;
import com.projectservice.InvalidMessage;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	static Logger logger = LogManager.getLogger(LoginServlet.class.getName());
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String utype = request.getParameter("utype");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		String type = "Patient";
		pass = GetPass.getpass(pass);
		LoginDao d = new LoginDao();
		HttpSession session = request.getSession();
		if (utype.equals(type)) {
			String patientname = (String) d.patient(uname, pass);
			if (patientname != null) {
				logger.info("Patient " + uname + " is login");
				session.setAttribute("patientId", uname);
				session.setAttribute("patientName", patientname);
				response.sendRedirect("welcom.jsp");
			} else {
				InvalidMessage inms = new InvalidMessage("Enter the valid userid and password");
				session.setAttribute("invalid", inms);
				response.sendRedirect("login.jsp");
			}
		} else {

			String doctorname = d.doctor(uname, pass);
			if (doctorname != null) {
				logger.info("Doctor " + uname + " is login");
				session.setAttribute("doctorId", uname);
				session.setAttribute("doctorName", doctorname);
				response.sendRedirect("doctorwelcom.jsp");
			} else {
				InvalidMessage inms = new InvalidMessage("Enter the valid userid and password");
				session.setAttribute("invalid", inms);
				response.sendRedirect("login.jsp");
			}
		}
	}

}
