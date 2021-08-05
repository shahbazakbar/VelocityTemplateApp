package com.velocity;
import com.velocity.pojo.FlightLegC;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.*;

public class VelocityTemplateHandler {
    public static void main(String[] args) {
        String directory = "D:\\applications-inteliJ\\TestApp\\src\\com\\velocity\\templates";
        String template = "flight.vm";
        Properties p = new Properties();
        VelocityEngine veEngine = new VelocityEngine();

        p.put(VelocityEngine.FILE_RESOURCE_LOADER_PATH,
                directory);
        veEngine.init(p);

        Template templateObj = loaFileByPath(veEngine, directory, template);
        List<FlightLegC> flightLegCList = prepareData();
       String processedTemplate = processTemplate(veEngine,templateObj, flightLegCList);
         System.out.println(processedTemplate);
    }

    private static Template loaFileByPath(VelocityEngine veEngine, String directory, String template) {


        Template templateObj = veEngine.getTemplate(template);

        return templateObj;
    }

    private static String processTemplate(VelocityEngine veEngine, Template templateObj, List<FlightLegC> flightLegCList ){

        VelocityContext vc = new VelocityContext();


        vc.put("Flight_Leg__cList", flightLegCList);

        StringWriter writer = new StringWriter();
        templateObj.merge(vc, writer);

      return writer.toString();

    }

    private static  List<FlightLegC> prepareData(){

        List<FlightLegC> flightLegCList = new ArrayList<FlightLegC>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        Date d1 = cal.getTime();
        cal.set(Calendar.YEAR, 2022);
        Date d2 = cal.getTime();
        cal.set(Calendar.YEAR, 2023);
        Date d3 = cal.getTime();



        FlightLegC flightLegC1 = new FlightLegC("Booked", d2, "test1@test.com");
        FlightLegC flightLegC2 = new FlightLegC("Booked", d1, "test2@test.com");
        FlightLegC flightLegC3 = new FlightLegC("Booked", d3, "test3@test.com");

        flightLegCList.add(flightLegC1);
        flightLegCList.add(flightLegC2);
        flightLegCList.add(flightLegC3);
        return flightLegCList;
    }

}
