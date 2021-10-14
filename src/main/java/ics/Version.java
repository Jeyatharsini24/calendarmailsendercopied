package ics;

/**
 * Generates the version tag of ICalendar.
 *
 * <pre>
 *   VERSION:2.0
 * </pre>
 */
public final class Version implements ICalComponent
{
  public final static Version VERSION_2_0 = new Version("2.0");

  private String version;

  public Version(String version)
  {
    this.version = version;
  }

  @Override
  public String value()
  {
    return "VERSION:".concat(version);
  }
}
