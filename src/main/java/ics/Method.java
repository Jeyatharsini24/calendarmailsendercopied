package ics;

/**
 * Generates the method tag of ICalendar.
 *
 * <pre>
 *   METHOD:REQUEST
 * </pre>
 */
public final class Method implements ICalComponent
{
  public final static Method REQUEST = new Method("REQUEST");
  public final static Method CANCEL = new Method("CANCEL");

  private String method;

  public Method(String method)
  {
    this.method = method;
  }

  @Override
  public String value()
  {
    return "METHOD:".concat(method);
  }
}
