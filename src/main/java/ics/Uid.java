package ics;

/**
 * Generates the uid tag of ICalendar.
 *
 * <pre>
 *   UID:12345
 * </pre>
 */
public final class Uid implements ICalComponent
{
  private String uId;

  public Uid(String uId)
  {
    this.uId = uId;
  }

  @Override
  public String value()
  {
    return "UID:".concat(uId);
  }
}
