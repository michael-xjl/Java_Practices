package misc.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Michael Liu
 */
public class RawGenericType
{

  public static void main(String[] args)
  {
    List names = new ArrayList(); // warning: raw type!
    names.add("John");
    names.add("Mary");
    names.add(Boolean.FALSE); // not a compilation error!

    int[] nums = new int[]{2,1,3,4,5,6,9,-5};
    int subLen = 2;
    int[] winterTemps = Arrays.copyOfRange(nums, 0, subLen  );
    int[] springTemps = Arrays.copyOfRange(nums, subLen, subLen *2  );
    int[] summerTemps = Arrays.copyOfRange(nums, subLen*2, subLen*3  );
    int[] autumnTemps = Arrays.copyOfRange(nums, subLen*3, subLen *4 );
    Arrays.sort(winterTemps);
    Arrays.sort(springTemps);
    Arrays.sort(summerTemps);
    Arrays.sort(autumnTemps);

    int winterAmp = winterTemps[subLen - 1] - winterTemps[0];
    int springAmp = springTemps[subLen - 1] - springTemps[0];
    int summerAmp = summerTemps[subLen - 1] - summerTemps[0];
    int autumnAmp = autumnTemps[subLen - 1] - autumnTemps[0];

    System.out.println(winterTemps);

    int[] amps = new int[]{winterAmp, springAmp, summerAmp, autumnAmp} ;

    int maxAmpIndex = 0;

    for (int i = 0; i < amps.length; i++) {
      maxAmpIndex = amps[i] > amps[maxAmpIndex] ? i : maxAmpIndex;
    }



    Arrays.sort(new int[]{winterAmp, springAmp, summerAmp, autumnAmp });



    String S = "Mon 01:00-23:00\r\nTue 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    String[] schedules = S.split("\r\n");

    ArrayList<Scheduler> sList = new ArrayList<>();

    sList.add(new Scheduler("Mon","00:00","00:00"));


    SimpleDateFormat format1 = new SimpleDateFormat("EEE hh:mm");
    try
    {
      Date d11 = format1.parse("Tue 01:00");
      System.out.println(d11);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }

//    sList.sort( (s1,s2) -> {
//      try{
//        SimpleDateFormat format = new SimpleDateFormat("EEE");
//        Date d1 = format.parse(s1.weekDay);
//        Date d2 = format.parse(s2.weekDay);
//        if(d1.equals(d2)){
//          return s1.sTime.compareTo(s2.sTime);
//        }else{
//          Calendar cal1 = Calendar.getInstance();
//          Calendar cal2 = Calendar.getInstance();
//          cal1.setTime(d1);
//          cal2.setTime(d2);
//          return cal1.get(Calendar.DAY_OF_WEEK) - cal2.get(Calendar.DAY_OF_WEEK);
//        }
//      }catch(ParseException pe){
//        throw new RuntimeException(pe);
//      }
//    });



    for(String schedule : schedules)
    {
      sList.add(new Scheduler(schedule.substring(0,3), schedule.substring(4,9), schedule.substring(10,15)));
    }

    sList.add(new Scheduler("Sun","24:00","24:00"));

    sList.sort( (s1,s2) ->
    {
     return s1.sDate.compareTo(s2.sDate);
    });

    System.out.println(sList);

    for(int i = 0 ; i <  sList.size() ; i++)
    {

      final Scheduler scheduler = sList.get(i);

    }

    final Integer[] objects = sList.toArray(new Integer[0]);

    String strDate = "2019-03-11 Mon 01:00";
//    LocalDateTime aLD = LocalDateTime.parse(strDate);
//    DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyy-mm-dd E hh:mm");
//    System.out.println(aLD + " formats as " + dTF.format(aLD));

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-mm-dd E hh:mm");
    LocalDateTime ta = LocalDateTime.parse(strDate);
    for (Object o : names) {
      String name = (String) o;
      System.out.println(name);
    } // throws ClassCastException!
    //    java.lang.Boolean cannot be cast to java.lang.String
  }



  private static class Scheduler
  {
    String weekDay;
    String sTime;
    String eTime;
    Date sDate;
    Date eDate;
    static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-m-dd EEE hh:mm");

    public Scheduler(String weekDay, String sTime, String eTime)
    {
      try
      {
        this.weekDay = weekDay;
        this.sTime = sTime;
        this.eTime = eTime;

        String year = "2017-3-11";
        switch (weekDay)
        {
        case "Mon":
          year = "2017-3-11";
          break;
        case "Tue":
          year = "2017-3-12";
          break;
        case "Wed":
          year = "2017-3-13";
          break;
        case "Thu":
          year = "2017-3-14";
          break;
        case "Fri":
          year = "2017-3-15";
          break;
        case "Sat":
          year = "2017-3-16";
          break;
        case "Sun":
          year = "2017-3-17";

        }


        this.sDate = format1.parse(year + " " + weekDay + " " +  sTime);
        this.eDate = format1.parse(year + " " + weekDay + " " +  eTime);
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }

    }



    public Date getsDate()
    {
      return sDate;
    }

    public void setsDate(Date sDate)
    {
      this.sDate = sDate;
    }

    public Date geteDate()
    {
      return eDate;
    }

    public void seteDate(Date eDate)
    {
      this.eDate = eDate;
    }

    public String toString()
    {
      return sDate.toString() + " " + weekDay + " " + sTime + "-" + eTime;
    }
  }

}
