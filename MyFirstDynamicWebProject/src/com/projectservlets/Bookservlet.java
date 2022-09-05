package com.projectservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.BookAppointment.BookAppointmentDao;


@WebServlet("/bookservlet")
public class Bookservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String doctorid = request.getParameter("doctorId");
		 request.setAttribute("doctorid", doctorid);
		 RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
		 rd.forward(request, response);
	}
}
