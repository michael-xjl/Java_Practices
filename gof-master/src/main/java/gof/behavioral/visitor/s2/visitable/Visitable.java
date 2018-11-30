package gof.behavioral.visitor.s2.visitable;

import gof.behavioral.visitor.s2.visitor.Visitor;

/**
 * @author Michael Liu
 */
public interface Visitable
{
  void accept(Visitor visitor);
}
