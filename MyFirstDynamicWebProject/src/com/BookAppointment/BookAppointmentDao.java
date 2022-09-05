package com.BookAppointment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.pojo.DoctorInfo;
import com.pojo.PatientInfo;
import com.pojo.appointment;

public class BookAppointmentDao {
	String sql = "insert into appointment(patientid,doctorid,appointmentdate) values(?,?,?)";
	String cheking = "select patientid from appointment where patientid = ? and doctorid=? and appointmentdate=?";
	String url = "jdbc:mysql://localhost:3306/sneh";
	String username = "root";
	String password = "Sneh@0701";
	public void fillappointment(appointment d,ResultSet rs){
		try {
			d.setpatientid(rs.getString(1));
			d.setdoctorid(rs.getString(2));
			d.setdate(rs.getString(3));
			d.setpriciption(rs.getString(4));
			d.setstatus(rs.getString(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void filldoctor(DoctorInfo d,ResultSet rs){
		try{
			d.setname(rs.getString(1));
			d.settype(rs.getString(2));
			d.setcity(rs.getString(3));
			d.setphone_no(rs.getBigDecimal(4).toString());
			d.setdoctorId(rs.getString(5));
		}
		catch(Exception e){
			
		}
	}
	public void fillpatient(PatientInfo p,ResultSet rs){
		try{
			p.setid(rs.getString(2));
			p.setname(rs.getString(1));
			p.setpass(rs.getString(3));
		}
		catch(Exception e){
			
		}
	}
	public ArrayList<appointment> getappointmentdetails(String patientid){
		ArrayList<appointment> a = new ArrayList<appointment>();
		sql = "select * from appointment where patientid = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, patientid);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				appointment l = new appointment();
				fillappointment(l, rs);
				a.add(l);
			}
		}
		catch(Exception e){
			
		}
		return a;
	}
	public ArrayList<appointment> getappointmentdetailsbydoctorid(String doctorid){
		ArrayList<appointment> a = new ArrayList<appointment>();
		sql = "select * from appointment where doctorid = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, doctorid);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				appointment l = new appointment();
				fillappointment(l, rs);
				a.add(l);
			}
		}
		catch(Exception e){
			
		}
		return a;
	}
	public appointment getappointment(String patientid,String doctorid,String appointmentdate){
		appointment a = new appointment();
		sql = "select * from appointment where patientid = ? and doctorid = ? and appointmentdate = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, patientid);
			st.setString(2, doctorid);
			st.setString(3, appointmentdate);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				fillappointment(a, rs);
			}
			
		}
		catch(Exception e){
			
		}
		return a;
	}
	public DoctorInfo getdoctorbydoctorid(String doctorid){
		DoctorInfo d = new DoctorInfo();
		sql = "select * from doctor_Info where doctorid = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, doctorid);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				filldoctor(d, rs);
			}
		} catch (Exception e) {
			
		}
		return d;
	}
	public ArrayList<DoctorInfo> getdoctorlist(String city){
		ArrayList<DoctorInfo> d = new ArrayList<DoctorInfo>();
		sql = "select * from Doctor_Info where city = ?";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, city);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				
				DoctorInfo l = new DoctorInfo();
				filldoctor(l,rs);
				d.add(l);
			}
		}
		catch(Exception e){
			
		}
		return d;
	}
	public PatientInfo getpatient(String patientid){
		PatientInfo p = new PatientInfo();
		sql = "select * from patient where patientid = ?";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,patientid);
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				fillpatient(p,rs);
			}
		}
		catch(Exception e){
			
		}
		return p;
	}
   public void booking(String patientId,String doctorId,String appointmentdate){
	  
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(cheking);
		st.setString(1,patientId);
		st.setString(2,doctorId);
		st.setString(3,appointmentdate);
		ResultSet rs = st.executeQuery();
		if(rs.next())return;
		
		st = con.prepareStatement(sql);
		st.setString(1,patientId);
		st.setString(2,doctorId);
		st.setString(3,appointmentdate);
		st.execute();		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	   
   }
   public ArrayList<ArrayList<String>> bookedAp(String patientid){
	   ResultSet rs;
	   ArrayList<ArrayList<String>>s = new ArrayList<ArrayList<String>>();
	   try{
		   LocalDate ld =LocalDate.now();
			String c_date = ld.toString();
		   sql = "select d.* , a.* from doctor_info as d inner join appointment as a on d.doctorId=a.doctorId where a.patientId=? and a.appointmentdate >= ? order by a.appointmentdate asc";
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, patientid);
			st.setString(2, c_date);
			rs = st.executeQuery();
		    while(rs.next()){
		    	ArrayList<String> l = new ArrayList<String>();
		    	l.add(rs.getString(1));
		    	l.add(rs.getString(2));
		    	l.add(rs.getString(3));
		    	l.add(rs.getString(4));
		    	l.add(rs.getString(5));
		    	l.add(rs.getString(6));l.add(rs.getString(8));l.add(rs.getString(9));
		    	l.add(rs.getString(10));
		    	s.add(l);
		    }
	   }
	   catch (Exception e) {
	   }
	   return s;
	}
   public void deleteappointment(String appointmentdate,String doctorid,String patientid){
	   sql = "delete from appointment  where appointmentdate = ? and patientid = ? and doctorid = ?";
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, appointmentdate);
			st.setString(2, patientid);
			st.setString(3, doctorid);
			System.out.println(doctorid);
			 System.out.println(appointmentdate);
			 System.out.println(patientid);
			st.execute();		   
	   }catch (Exception e) {
		// TODO: handle exception
	}
   }
   }

