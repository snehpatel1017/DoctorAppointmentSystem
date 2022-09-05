package com.pojo;

import java.sql.Date;

public class appointment {
   private String patientid;
   private String doctorid;
   private String date;
   private String status;
   private String priciption;
   
   public String getpatientid(){return patientid;}
   public void setpatientid(String patientid){this.patientid = patientid;}
   
   public String getdoctorid(){return doctorid;}
   public void setdoctorid(String doctorid){this.doctorid = doctorid;}
   
   public String getdate(){return date;}
   public void setdate(String date){this.date = date;}
   
   public String getstatus(){return status;}
   public void setstatus(String status){this.status = status;}
   
   public String getpriciption(){return priciption;}
   public void setpriciption(String priciption){this.priciption = priciption;}
}
