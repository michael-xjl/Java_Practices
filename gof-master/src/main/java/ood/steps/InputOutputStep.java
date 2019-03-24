package ood.steps;

/**
 * @author Michael Liu
 */
public abstract class InputOutputStep<T> implements Step,
    StepInput<T> {

  private T returnValue;

  protected void setReturnValue(T returnValue) {
    this.returnValue = returnValue;
  }

  public T getInput() {
    return returnValue;
  }
}
