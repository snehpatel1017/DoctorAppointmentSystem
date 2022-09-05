package com.projectservice;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.BookAppointment.BookAppointmentDao;
import com.loginpage.LoginServlet;
import com.pojo.*;
public class Authentication {
	static Logger logger = LogManager.getLogger(Authentication.class.getName());
    public ArrayList<appointment> bookap(String patientid){
    	logger.info("Patient " + patientid + " is accessing booked appointment details");
    	ArrayList<appointment> a = null;   
    	BookAppointmentDao d = new BookAppointmentDao();
    	a = d.getappointmentdetails(patientid);
    	return a;
    }
    public ArrayList<appointment> bookedappointment(String doctorid){
    	logger.info("Doctor " + doctorid + " is accessing booked appointment details");
    	ArrayList<appointment> a = null;   
    	BookAppointmentDao d = new BookAppointmentDao();
    	a = d.getappointmentdetailsbydoctorid(doctorid);
    	return a;
    }
    public PatientInfo getpatient(String patientid){
    	logger.info("fetching patient by patientid");
    	PatientInfo p = new PatientInfo();
    	BookAppointmentDao b = new BookAppointmentDao();
    	p = b.getpatient(patientid);
    	return p;
    }
    public DoctorInfo getdoctorbydoctorid(String doctorid){
    	logger.info("fetching doctor by doctorid");
    	DoctorInfo d = null;
    	BookAppointmentDao a = new BookAppointmentDao();
    	d = a.getdoctorbydoctorid(doctorid);
    	return d;
    }
    public ArrayList<DoctorInfo> doctorlist(String city){
    	logger.info("fetching doctors list by city");
    	ArrayList<DoctorInfo> a = null;
    	BookAppointmentDao d = new BookAppointmentDao();
    	a = d.getdoctorlist(city);
    	return a;
    }
    public appointment getappointment(String patientid , String doctorid, String appointmentdate){
    	logger.info("fetching appointment by patientid,doctorid and appointmentdate");
    	appointment a = new appointment();
    	BookAppointmentDao d = new BookAppointmentDao();
    	a = d.getappointment(patientid, doctorid, appointmentdate);
    	return a;
    }
   
}
