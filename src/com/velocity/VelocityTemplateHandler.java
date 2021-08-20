package com.velocity;
import com.velocity.pojo.FlightLegC;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.ConversionTool;
import org.apache.velocity.tools.generic.DateTool;
import org.apache.velocity.tools.generic.SortTool;

import java.io.StringWriter;
import java.util.*;

public class VelocityTemplateHandler {
    public static void main(String[] args) {
        String directory = "D:\\applications-inteliJ\\TestApp\\src\\com\\velocity\\templates";
        String template = "To__c.txt";
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
        vc.put("date", new DateTool());
        vc.put("sorter", new SortTool());
        vc.put("convert", new ConversionTool());


        vc.put("Flight_Leg__cList", flightLegCList);

        StringWriter writer = new StringWriter();
        templateObj.merge(vc, writer);

      return writer.toString();

    }

    private static  List<FlightLegC> prepareData(){

        List<FlightLegC> flightLegCList = new ArrayList<FlightLegC>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 27);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.HOUR, 10);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        Date d1 = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.HOUR, 6);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        Date d2 = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 27);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.HOUR, 10);
        cal.set(Calendar.MINUTE, 45);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        Date d3 = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 20);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.HOUR, 15);
        cal.set(Calendar.MINUTE, 7);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.AM_PM, 0);
        Date d4 = cal.getTime();
   /* System.out.println(d1);
    System.out.println(d2);
    System.out.println(d3);
    System.out.println(d4);
*/
        FlightLegC flightLegC2 = new FlightLegC("Booked", d2, d4, "KTEB", "KSAN");
        FlightLegC flightLegC1 = new FlightLegC("Booked", d1, d3, "KSAN", "KTEB");

        // FlightLegC flightLegC3 = new FlightLegC("Booked", d3, "KILM",  "MYEH");
        //FlightLegC flightLegC4 = new FlightLegC("Booked", d4, "Islamabad",  "KGPT");
        flightLegCList.add(flightLegC2);

        flightLegCList.add(flightLegC1);


        //   flightLegCList.add(flightLegC3);
     //   flightLegCList.add(flightLegC4);
        return flightLegCList;
    }

}
