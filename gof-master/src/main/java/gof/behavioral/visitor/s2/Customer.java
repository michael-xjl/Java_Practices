package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public class Customer implements Visitable
{
  @Override public void accept(Visitor visitor)
  {
    visitor.visit(this);
  }
}
