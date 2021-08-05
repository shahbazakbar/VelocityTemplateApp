package com.velocity.pojo;
import java.util.Date;

public class FlightLegC {


    private  String status__c;
    private Date departure_Time__c;
    private  String to__c;
    public FlightLegC(){}
    public FlightLegC(String status, Date departureTime, String toC){
        status__c = status;
        departure_Time__c = departureTime;
        to__c = toC;
    }


    public String getStatus__c() {
        return status__c;
    }

    public void setStatus__c(String status__c) {
        this.status__c = status__c;
    }

    public Date getDeparture_Time__c() {
        return departure_Time__c;
    }

    public void setDeparture_Time__c(Date departure_Time__c) {
        this.departure_Time__c = departure_Time__c;
    }

    public String getTo__c() {
        return to__c;
    }

    public void setTo__c(String to__c) {
        this.to__c = to__c;
    }


}
