package gof.behavioral.visitor.s2.visitable;

import gof.behavioral.visitor.s2.visitor.Visitor;

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
