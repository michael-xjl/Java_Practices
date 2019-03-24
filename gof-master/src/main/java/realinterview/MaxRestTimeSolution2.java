package realinterview;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Michael Liu
 */

public class MaxRestTimeSolution2
{
  public static void main(String[] args)
  {
    //test case 1
    String S = "Mon 01:00-23:00\r\nTue 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [Sun 180] ==  " + getMaxRestTime(S));

    //test case 2
    S = "Mon 01:00-20:00\r\nTue 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [300] ==  " + getMaxRestTime(S));

    //test case 3
    S = "Mon 08:00-20:00\r\nTue 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [8*60 = 480] ==  " + getMaxRestTime(S));

    //test case 4
    S = "Mon 08:00-09:00\r\nMon 23:00-24:00\r\nTue 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [14*60 = 840] ==  " + getMaxRestTime(S));

    //test case 5
    S = "Mon 01:00-23:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [60+24*60+60 = 1560] ==  " + getMaxRestTime(S));

    //test case 6
    S = "Mon 01:00-24:00\r\nWed 01:00-23:00\r\nThu 01:00-23:00\r\nFri 01:00-23:00\r\nSat 01:00-23:00\r\nSun 01:00-21:00";
    System.out.println("max rest time : [24*60+60 = 1500] ==  " + getMaxRestTime(S));

    //test case 7
    S = "Mon 01:00-23:00";
    System.out.println("max rest time : [60+24*60*6 = 8700] ==  " + getMaxRestTime(S));

    //test case 8
    S = "Sun 02:00-21:00";
    System.out.println("max rest time : [24*60*6 + 60*2 = 8760] ==  " + getMaxRestTime(S));

  }

  //optimal way, this is what I want to implement in the test.
  public static int getMaxRestTime(String S)
  {
    final List<String> weekDays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

    String[] schedules = S.split("\r\n");

    List<Scheduler> sList = new ArrayList<>();
    //add start time
    sList.add(new Scheduler(0,"00:00","00:00"));

    for (String schedule : schedules)
      sList.add(new Scheduler(weekDays.indexOf(schedule.substring(0, 3)), schedule.substring(4, 9), schedule.substring(10, 15)));

    //add end time
    sList.add(new Scheduler(6,"24:00","24:00"));

    //sort by weekdays then start time
    sList.sort(Comparator.comparing(Scheduler::getDayOfWeek).thenComparing(Scheduler::getsTime));

    int maxRestTime = 0;
    //compare adjacent time periods, get max duration
    for(int i = 1 ; i < sList.size() ; i++)
      maxRestTime = Math.max(maxRestTime, (int)ChronoUnit.MINUTES.between( sList.get(i - 1).eDateTime , sList.get(i).sDateTime));

    return maxRestTime;
  }

  private static class Scheduler
  {
    int dayOfWeek; // 0 base, 0 - Monday

    String sTime;
    String eTime;

    LocalDateTime sDateTime;
    LocalDateTime eDateTime;

    public Scheduler(int dayOfWeek, String sTime, String eTime)
    {
      LocalDateTime dummyStartDate = LocalDateTime.of(2017,3,11,0,0);

      this.dayOfWeek = dayOfWeek;
      this.sTime = sTime;
      this.eTime = eTime;

      String[] sTimes = sTime.split(":");
      String[] eTimes = eTime.split(":");

      sDateTime = dummyStartDate.plusDays(dayOfWeek).plusHours(Integer.valueOf(sTimes[0]))
          .plusMinutes(Integer.valueOf(sTimes[1]));
      eDateTime = dummyStartDate.plusDays(dayOfWeek).plusHours(Integer.valueOf(eTimes[0]))
          .plusMinutes(Integer.valueOf(eTimes[1]));
    }

    public int getDayOfWeek()
    {
      return dayOfWeek;
    }

    public String getsTime()
    {
      return sTime;
    }
  }

}
