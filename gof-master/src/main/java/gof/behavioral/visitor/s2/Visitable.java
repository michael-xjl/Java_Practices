package gof.behavioral.visitor.s2;

/**
 * @author Michael Liu
 */
public interface Visitable
{
  void accept(Visitor visitor);
}
