package ood.onlinemovieticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Michael Liu
 */
public class ShowTime
{
  int id;
  LocalDateTime dateTime;

  public ShowTime(int id, LocalDateTime dateTime, Movie movie, Theater theater)
  {
    this.id = id;
    this.dateTime = dateTime;
    this.movie = movie;
    this.theater = theater;
  }

  //  List<Movie> movies;
//  List<Theater> theaters;

  Movie movie;

  Theater theater;
}
