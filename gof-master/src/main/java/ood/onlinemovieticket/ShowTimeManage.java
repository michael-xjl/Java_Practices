package ood.onlinemovieticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Michael Liu
 */
public class ShowTimeManage
{
  List<ShowTime> showTimes = new ArrayList<>();

  public void addShowTime(ShowTime showTime)
  {
    showTimes.add(showTime);
  }

  public List<ShowTime> filterShowTimesByTheater(Theater theater)
  {
    return  showTimes.stream().filter( s -> s.theater.equals(theater)).collect(Collectors.toList());
  }

  public List<ShowTime> filterShowTimesByMovie(Movie movie)
  {
    return  showTimes.stream().filter( s -> s.movie.equals(movie)).collect(Collectors.toList());
  }


  public List<ShowTime> filterShowTimesByTime(LocalDateTime localDateTime)
  {
    return  showTimes.stream().filter( s -> s.dateTime.equals(localDateTime)).collect(Collectors.toList());
  }

}
