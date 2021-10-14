package ics;

import java.time.LocalDateTime;

/**
 * Generates the timstamp tag of ICalendar.
 *
 * <pre>
 *   DTSTAMP:20210913T155437
 * </pre>
 */
public final class TimeStamp implements ICalComponent
{
  private LocalDateTime currentDateTime;

  public TimeStamp()
  {
    this.currentDateTime = LocalDateTime.now();
  }

  @Override
  public String value()
  {
    return "DTSTAMP:".concat(DateTimeUtils.format(currentDateTime));
  }
}
