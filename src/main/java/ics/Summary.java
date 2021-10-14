package ics;

/**
 * Generates the summary tag of ICalendar.
 *
 * <pre>
 *   SUMMARY;LANGUAGE=en-US:This is a summary.
 * </pre>
 */
public final class Summary implements ICalComponent
{
  private String summary;

  public Summary(String summary)
  {
    this.summary = summary;
  }

  @Override
  public String value()
  {
    return "SUMMARY;LANGUAGE=en-US:".concat(summary);
  }
}
