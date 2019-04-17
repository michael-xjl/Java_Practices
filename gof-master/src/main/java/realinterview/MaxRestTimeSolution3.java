package realinterview;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Michael Liu
 */

public class MaxRestTimeSolution3
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

  public static int getMaxRestTime(String S)
  {
    ArrayList<Scheduler> sts = new ArrayList<>();

    sts.add(new Scheduler("Mon 00:00-00:00"));
    sts.add(new Scheduler("Sun 24:00-24:00"));

    for (String schedule : S.split("\r\n"))
      sts.add(new Scheduler(schedule));

    sts.sort(Comparator.comparing(Scheduler::getsMin));

    int maxRestTime = 0;
    for(int i = 1 ; i < sts.size() ; i++)
      maxRestTime = Math.max(maxRestTime, sts.get(i).sMin - sts.get(i-1).eMin);

    return maxRestTime;
  }

  private static class Scheduler
  {
    static final List<String> weekDays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

    int sMin;
    int eMin;

    public Scheduler(String scheduler)
    {
      final String[] splits = scheduler.split("[ :-]");
      sMin = weekDays.indexOf(splits[0])*24*60 + Integer.valueOf(splits[1]) * 60 +  Integer.valueOf(splits[2]);
      eMin = weekDays.indexOf(splits[0])*24*60 + Integer.valueOf(splits[3]) * 60 +  Integer.valueOf(splits[4]);
    }


    public int getsMin()
    {
      return sMin;
    }
  }

}
