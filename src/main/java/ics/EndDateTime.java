package ics;

import java.time.LocalDateTime;

/**
 * Generates the end datetime tag of ICalendar.
 *
 * <pre>
 *   DTEND:20210913T165437
 * </pre>
 */
public final class EndDateTime implements ICalComponent
{
  private LocalDateTime endDateTime;

  public EndDateTime(LocalDateTime endDateTime)
  {
    this.endDateTime = endDateTime;
  }

  @Override
  public String value()
  {
    return "DTEND:".concat(DateTimeUtils.format(endDateTime));
  }
}
