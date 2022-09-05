package com.projectservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.BookAppointment.BookAppointmentDao;
import com.loginpage.LoginServlet;


@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {
	static Logger logger = LogManager.getLogger(deleteservlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String doctorid = request.getParameter("doctorId");
		 String appointmentdate = request.getParameter("appointmentdate");
		 HttpSession session = (HttpSession) request.getSession();
		
		 String patientid = (String) session.getAttribute("patientId");
		 BookAppointmentDao b = new BookAppointmentDao();
		 logger.info("Patient "+patientid+" is deleted the appointment with Doctor "+doctorid+" at appointment date "+appointmentdate);
		 b.deleteappointment(appointmentdate, doctorid, patientid);
		 response.sendRedirect("welcom.jsp");
	}

	

}
