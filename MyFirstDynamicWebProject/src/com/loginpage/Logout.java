package com.loginpage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.projectservice.Authentication;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	static Logger logger = LogManager.getLogger(Logout.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("patientId") != null){
			logger.info("Patient " + session.getAttribute("patientId") + " is log out ");
		session.removeAttribute("patientId");
		session.removeAttribute("patientName");
		
		}
		else{
			logger.info("Doctor " + session.getAttribute("doctorId") + " is log out ");
			session.removeAttribute("doctorId");
			session.removeAttribute("doctorName");
		}
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	
 
}
