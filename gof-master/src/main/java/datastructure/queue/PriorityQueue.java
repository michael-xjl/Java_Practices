package datastructure.queue;

import java.util.Queue;

/**
 * @author Michael Liu
 */
public class PriorityQueue
{

  public static void main(String[] args)
  {
    Queue<QEle> pq = new java.util.PriorityQueue<>((e1,e2) -> e2.id - e1.id);
    pq.add(new QEle(20,"this 20"));
    pq.add(new QEle(5,"this 5"));
    pq.add(new QEle(12,"this 12"));
    pq.add(new QEle(43,"this 43"));
    System.out.println(pq);

    System.out.println((int)'(');
    System.out.println((int)')');
    System.out.println('(' - ')');
  }


  private static class QEle
  {
    int id;

    String name;

    public QEle(int id, String name)
    {
      this.id = id;
      this.name = name;
    }

    public String toString()
    {
      return id + "-" + name;
    }
  }
}
