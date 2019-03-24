package ood.onlinemovieticket;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Michael Liu
 */
public class MovieTicketSystem
{
  public static void main(String[] args)
  {

    Theater theater1 = new Theater(1,"North York Farewell Mall Theater");
    Theater theater2 = new Theater(2,"Toronto York Dale Mall Theater");

    Movie movie1 = new Movie(1,"Ape");
    Movie movie2 = new Movie(2,"Super Man");


    LocalDateTime localDateTime1 = LocalDateTime.of(2019,03,18,18,15);
    LocalDateTime localDateTime2 = LocalDateTime.of(2019,03,19,18,15);
    ShowTime showTime1 = new ShowTime(1, localDateTime1, movie1,theater1);
    ShowTime showTime2 = new ShowTime(2, localDateTime2, movie2,theater1);

    final ShowTimeManage showTimeManage = new ShowTimeManage();
    showTimeManage.addShowTime(showTime1);
    showTimeManage.addShowTime(showTime2);



    /*******Build Ticket***********/

    final List<ShowTime> showTimes = showTimeManage.filterShowTimesByTime(localDateTime1);



  }

}
