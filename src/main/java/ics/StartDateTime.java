package ics;

import java.time.LocalDateTime;

/**
 * Generates the start datetime tag of ICalendar.
 *
 * <pre>
 *   DTSTART:20210913T155437
 * </pre>
 */
public final class StartDateTime implements ICalComponent
{
  private LocalDateTime startDateTime;

  public StartDateTime(LocalDateTime startDateTime)
  {
    this.startDateTime = startDateTime;
  }

  @Override
  public String value()
  {
    return "DTSTART:".concat(DateTimeUtils.format(startDateTime));
  }
}
