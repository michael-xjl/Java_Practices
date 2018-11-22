package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public class Order implements Visitable
{
  @Override public void accept(Visitor visitor)
  {
    visitor.visit(this);
  }
}
