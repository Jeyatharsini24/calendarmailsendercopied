package ics;

/**
 * Generates the time zone tag of ICalendar.
 *
 * <pre>
 *   BEGIN:VTIMEZONE
 *   TZID:Asia/Colombo
 *   END:VTIMEZONE
 * </pre>
 */
public final class TimeZone implements ICalComponent
{
  private String timeZoneId;

  public TimeZone(java.util.TimeZone timeZone)
  {
    this.timeZoneId = timeZone.getID();
  }

  @Override
  public String value()
  {
    return "BEGIN:VTIMEZONE\n" +
           "TZID:".concat(timeZoneId)
             .concat("\nEND:VTIMEZONE");
  }
}
