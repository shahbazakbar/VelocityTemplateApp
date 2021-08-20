package com.velocity.pojo;
import java.util.Calendar;
import java.util.Date;

public class FlightLegC {

    private  String Status__c;
    private Date Est_Departure_Time_EST__c;
    private Date Est_Arrival_Time_EST__c;
    private Calendar calDeparture;
    private String From__c;
    private  String To__c;
    public FlightLegC(){}
    public FlightLegC(String status, Date departureTime, Date est_Arrival_Time_EST, String fromC, String toC){
        Status__c = status;
        Est_Departure_Time_EST__c = departureTime;
        To__c = toC;
        From__c = fromC;
        Est_Arrival_Time_EST__c = est_Arrival_Time_EST;
    }


    public String getStatus__c() {
        return Status__c;
    }

    public void setStatus__c(String status__c) {
        this.Status__c = status__c;
    }

    public Date getEst_Departure_Time_EST__c() {
        return Est_Departure_Time_EST__c;
    }

    public void setEst_Departure_Time_EST__c(Date est_Departure_Time_EST__c) {
        this.Est_Departure_Time_EST__c = est_Departure_Time_EST__c;
    }

    public String getFrom__c() {    return From__c;    }

    public void setFrom__c(String from__c) {    From__c = from__c;
    }
    public String getTo__c() {
        return To__c;
    }

    public void setTo__c(String to__c) {
        this.To__c = to__c;
    }

    public Date getEst_Arrival_Time_EST__c() {
        return Est_Arrival_Time_EST__c;
    }

    public void setEst_Arrival_Time_EST__c(Date est_Arrival_Time_EST__c) {
        Est_Arrival_Time_EST__c = est_Arrival_Time_EST__c;
    }

    public Calendar getCalDeparture() {
        return calDeparture;
    }

    public void setCalDeparture(Calendar calDeparture) {
        this.calDeparture = calDeparture;
    }
}
