package realinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

/**
 * @author Michael Liu
 */
public class MaxRestTimeSolution1
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


  //brute force solution
  public static int getMaxRestTime(String S)
  {

    final List<String> weekDays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

    String[] schedules = S.split("\r\n");

    ArrayList<Scheduler> sList = new ArrayList<>();
    for (String schedule : schedules)
    {
      int dayOfWeek = weekDays.indexOf(schedule.substring(0, 3));
      String[] sTimes = schedule.substring(4, 9).split(":");
      String[] eTimes = schedule.substring(10, 15).split(":");
      int sMinutes = Integer.valueOf(sTimes[0]) * 60 + Integer.valueOf(sTimes[1]);
      int eMinutes = Integer.valueOf(eTimes[0]) * 60 + Integer.valueOf(eTimes[1]);

      sList.add(new Scheduler(dayOfWeek, sMinutes, eMinutes));
    }

    //sort by weekdays then start time./ also can group by weekdays the sor the meeting times
    sList.sort((s1, s2) -> s1.dayOfWeek == s2.dayOfWeek ? s1.sMinutes - s2.sMinutes : s1.dayOfWeek - s2.dayOfWeek);

    //System.out.println(sList);

    //group by weekdays, LinkedList will be easy get first/last element
    final Map<Integer, LinkedList<Scheduler>> sByweekDayMap = sList.stream()
        .collect(groupingBy(Scheduler::getDayOfWeek, toCollection(LinkedList::new)));

    //calculate rest time for each day
    for (int day = 0; day < weekDays.size(); day++)
    {
      if (sByweekDayMap.containsKey(day))
      {
        final LinkedList<Scheduler> sl = sByweekDayMap.get(day);

        //add last dummy meeting
        sl.addLast(new Scheduler(day, 24 * 60, 24 * 60));

        for (int j = 0; j < sl.size(); j++)
        {
          final Scheduler currS = sl.get(j);
          if (j == 0)
            currS.setRestMinutes(currS.sMinutes);
          else
            currS.setRestMinutes(currS.sMinutes - sl.get(j - 1).eMinutes);
        }
      }
      else //maybe no meeting for some days
      {
        LinkedList<Scheduler> missedS = new LinkedList<>();
        missedS.add(new Scheduler(day, 24 * 60, 0, 24 * 60));
        sByweekDayMap.put(day, missedS);
      }
    }

    //System.out.println(sList);

    //merge the rest time between days
    for (int day = 0; day < weekDays.size() - 1; day++)
    {
      final Scheduler currLast = sByweekDayMap.get(day).getLast();
      final Scheduler nextFirst = sByweekDayMap.get(day + 1).getFirst();

      nextFirst.setRestMinutes(currLast.getRestMinutes() + nextFirst.getRestMinutes());
    }

    //System.out.println(sByweekDayMap);

    return sByweekDayMap.values().stream().flatMap(List::stream).mapToInt(s -> s.restMinutes).max().getAsInt();

  }

  private static class Scheduler
  {
    int dayOfWeek; // 0 base, 0 - Monday

    int sMinutes; // meeting start time [minute]
    int eMinutes; // meeting end time [minute]

    int restMinutes; // rest minutes between curr meeting and pre meeting

    public Scheduler(int dayOfWeek, int sMinutes, int eMinutes)
    {
      this(dayOfWeek, sMinutes, eMinutes, 0);
    }

    public Scheduler(int dayOfWeek, int sMinutes, int eMinutes, int restMinutes)
    {
      this.dayOfWeek = dayOfWeek;
      this.sMinutes = sMinutes;
      this.eMinutes = eMinutes;
      this.restMinutes = restMinutes;
    }

    public int getDayOfWeek()
    {
      return dayOfWeek;
    }

    public int getsMinutes()
    {
      return sMinutes;
    }

    public int geteMinutes()
    {
      return eMinutes;
    }

    public int getRestMinutes()
    {
      return restMinutes;
    }

    public void setRestMinutes(int restMinutes)
    {
      this.restMinutes = restMinutes;
    }

    @Override public String toString()
    {
      return "Scheduler{" +
          "dayOfWeek=" + dayOfWeek +
          ", sMinutes=" + sMinutes +
          ", eMinutes=" + eMinutes +
          ", restMinutes=" + restMinutes +
          '}';
    }
  }

}
