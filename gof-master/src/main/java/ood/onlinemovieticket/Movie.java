package ood.onlinemovieticket;

import java.util.List;
import java.util.Objects;

/**
 * @author Michael Liu
 */
public class Movie
{
  int id;
  String name;
  String intro;

  MovieType movieType;

  public Movie(int i, String super_man)
  {
    this.id = id;
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getIntro()
  {
    return intro;
  }

  public void setIntro(String intro)
  {
    this.intro = intro;
  }

  public MovieType getMovieType()
  {
    return movieType;
  }

  public void setMovieType(MovieType movieType)
  {
    this.movieType = movieType;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Movie movie = (Movie) o;
    return id == movie.id &&
        Objects.equals(name, movie.name);
  }

  @Override public int hashCode()
  {
    return Objects.hash(id, name);
  }
}
