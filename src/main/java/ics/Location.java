package ics;

/**
 * Generates the location tag of ICalendar.
 *
 * <pre>
 *   LOCATION;LANGUAGE=US:location
 * </pre>
 */
public final class Location implements ICalComponent
{
  private String location;

  public Location(String location)
  {
    this.location = location;
  }

  @Override
  public String value()
  {
    return "LOCATION;LANGUAGE=US:".concat(location);
  }
}
