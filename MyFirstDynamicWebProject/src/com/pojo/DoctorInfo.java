package com.pojo;

import java.math.BigDecimal;

public class DoctorInfo {
    private String name;
    private String type;
    private String city;
    private String phone_no;
    private String doctorId;
    private String pass;
    
    public String getname(){return name;}
    public void setname(String name){this.name = name;}
    
    public String gettype(){return type;}
    public void settype(String type){this.type = type;}
    
    public String getcity(){return city;}
    public void setcity(String city){this.city = city;}

    public String getphone_no(){return phone_no;}
    public void setphone_no(String phone_no){this.phone_no = phone_no;}
    
    public String getdoctorId(){return doctorId;}
    public void setdoctorId(String doctorId){this.doctorId = doctorId;}
    
    public String getpass(){return pass;}
    public void setpass(String pass){this.pass = pass;}
}
