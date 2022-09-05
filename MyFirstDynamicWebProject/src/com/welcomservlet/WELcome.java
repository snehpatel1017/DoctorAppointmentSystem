package com.welcomservlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WELcome
 */
@WebServlet("/WELcome")
public class WELcome extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		String type = request.getParameter("type");
		String s = "";
		if(city.equals(s)){
			response.sendRedirect("welcom.jsp");
		}
		
		Welcomdao d = new Welcomdao();
		
		
		PrintWriter out = response.getWriter();
		try {
			out.println("<html><body>");		
			out.println("<table border=1>");
			int i=0;
//			while(rs.next()){
//				out.println("<tr>");
//				out.println("<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getBigDecimal(3)+"</td>");
//				out.println("<td>");
//				out.println("<form action='BookAppointmentServlet' id=\"combine"+i+"\">");
//				out.println("<input type='hidden' name='doctorId' value='"+rs.getString(4)+"'>");
//				out.println("<input type='submit' value='book'>");
//				out.print("</form>");
//				out.println("</td>");
//				out.print("<td>");
//				out.println("<input type='date' name='appointmentdate' form='combine"+i+"' oninvalid=\"alert('You must enter the date')\" required");
//				out.print("</td>");
//				out.println("</tr>");
//				i++;
//				
//			}
			out.print("</table>");
			out.print("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
