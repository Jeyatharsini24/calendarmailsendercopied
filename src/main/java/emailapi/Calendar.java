package emailapi;

/**
 * This class holds the content for meeting email.
 *
 * <pre>
 *   {@code
 *    Calendar calendar = Calendar.getInstance("meeting ics", "appointment.ics", Method.REQUEST);
 *   }
 * </pre>
 */
public final class Calendar
{
  private String content;
  private String name;
  private Method method;

  public enum Method
  {
    REQUEST, UPDATE, CANCEL
  }

  private Calendar(String content, String name, Method method)
  {
    this.content = content;
    this.name = name;
    this.method = method;
  }

  public static Calendar getInstance(String content, String name, Method method)
  {
    return new Calendar(content, name, method);
  }

  public String getContent()
  {
    return content;
  }

  public String getName()
  {
    return name;
  }

  public String getMethod()
  {
    return method.name();
  }

}
