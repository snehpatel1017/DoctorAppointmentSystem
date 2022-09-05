package com.welcomservlet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.xml.ws.Response;

public class Welcomdao {
	String sql1 = "select name,type,Phone_No,doctorId from doctor_info where city = ? and type = ?";
	String sql2 = "select name,type,Phone_No,doctorId from doctor_info where city = ?";
	static final String url = "jdbc:mysql://localhost:3306/sneh";
	static final String username = "root";
	static final String password = "Sneh@0701";
    public ResultSet chek(String city,String type){
    	ResultSet rs=null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st;
			String s = "null";
			
			if(type.equals(s)){
				
				st = con.prepareStatement(sql2);
				st.setString(1,city);
			}
			else{
				
				st = con.prepareStatement(sql1);
				st.setString(1,city);
				st.setString(2, type);
			}
			 rs = st.executeQuery();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	return rs;
    }
    public static ResultSet cities(){
    	String sql = "select distinct(city) from doctor_info order by city asc";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
		    Statement st = (Statement)con.createStatement();
		    ResultSet rs =  st.executeQuery(sql);
		    return rs;
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
    public static ResultSet types(){
    	String sql = "select distinct(type) from doctor_info order by type asc";
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
		    Statement st = (Statement)con.createStatement();
		    ResultSet rs =  st.executeQuery(sql);
		    return rs;
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
}
