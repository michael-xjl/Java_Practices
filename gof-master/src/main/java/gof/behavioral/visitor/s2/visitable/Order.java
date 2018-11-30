package gof.behavioral.visitor.s2.visitable;

import gof.behavioral.visitor.s2.visitor.Visitor;

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
