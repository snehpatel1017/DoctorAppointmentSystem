package com.loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class LoginDao {
	String sql = "select name from patient where patientId = ? and pass = ?";
	String url = "jdbc:mysql://localhost:3306/sneh";
	String username = "root";
	String password = "Sneh@0701";
    public String patient(String uname,String pass){
    	try {
    		if(pass.length() == 0 || uname.length() == 0){
    			return null;
    		}
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1,uname);
    		st.setString(2, pass);
    		ResultSet rs  = st.executeQuery();
    		
    		if(rs.next()){
    			return rs.getString(1);
    		}
    	} catch (Exception e) {
    		
    		e.printStackTrace();
    	}
    	   return null;
    }
    public String doctor(String uname , String pass){
    	sql = "select d.name from doctorlogin as a,doctor_info as d where a.doctorId = ? and a.pass = ? and d.doctorId = a.doctorId";
    	try {   		
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection(url,username,password);
    		PreparedStatement st = con.prepareStatement(sql);
    		st.setString(1,uname);
    		st.setString(2, pass);
    		
    		ResultSet rs  = st.executeQuery();
    		if(rs.next()){
    			return rs.getString(1);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	   return null;
    }
    public ResultSet appointment(String uname){
    	sql = "select p.name , a.appointmentdate from appointment as a,patient as p where a.doctorId = ? and a.appointmentdate >= ? and a.patientId = p.patientId";
    	LocalDate ld = LocalDate.now();
    	String c_date = ld.toString();
    	ResultSet rs=null;
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,c_date);
			rs = st.executeQuery();
    	}
    	catch (Exception e) {
			
		}
    	return rs;
    }
}
