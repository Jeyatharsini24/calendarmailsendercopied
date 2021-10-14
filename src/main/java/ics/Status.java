package ics;

/**
 * Generates the status tag of ICalendar.
 *
 * <pre>
 *   STATUS:CONFIRMED
 * </pre>
 */
public final class Status implements ICalComponent
{
  public final static Status CONFIRMED = new Status("CONFIRMED");
  public final static Status CANCELLED = new Status("CANCELLED");

  private String status;

  public Status(String status)
  {
    this.status = status;
  }

  @Override
  public String value()
  {
    return "STATUS:".concat(status);
  }
}
