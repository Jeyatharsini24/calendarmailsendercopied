package emailapi;

/**
 * This class holds Java email headers.
 *
 * <pre>
 *   {@code
 *    Header header = Header.getInstance("name", "value");
 *   }
 * </pre>
 */
public final class Header
{
  private String name;
  private String value;

  private Header(String name, String value)
  {
    this.name = name;
    this.value = value;
  }

  public static Header getInstance(String name, String value)
  {
    return new Header(name, value);
  }

  public String getName()
  {
    return name;
  }

  public String getValue()
  {
    return value;
  }

}
