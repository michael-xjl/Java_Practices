package ood.onlinemovieticket;

import java.util.List;

/**
 * @author Michael Liu
 */
public class Theater
{
  int id;
  String name;
  String addr;

  public Theater(int id, String name)
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

  public String getAddr()
  {
    return addr;
  }

  public void setAddr(String addr)
  {
    this.addr = addr;
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Theater theater = (Theater) o;

    if (id != theater.id)
      return false;
    return name != null ? name.equals(theater.name) : theater.name == null;
  }

  @Override public int hashCode()
  {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
