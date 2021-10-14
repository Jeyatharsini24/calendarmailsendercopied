package ics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the calendar tag of ICalendar.
 *
 * <pre>
 *   BEGIN:VCALENDAR
 *   METHOD:REQUEST
 *   VERSION:2.0
 *   BEGIN:VTIMEZONE
 *   TZID:Asia/Colombo
 *   END:VTIMEZONE
 *   BEGIN:VEVENT
 *   SUMMARY;LANGUAGE=en-US:This is a summary
 *   DTSTART:20210913T155437
 *   DTEND:20210913T165437
 *   DTSTAMP:20210913T155437
 *   ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:example@example.com
 *   ORGANIZER;ROLE=REQ-PARTICIPANT;CN=Cambio Cosmic:RSVP=FALSE:MAILTO:example@example.com
 *   UID:12345
 *   STATUS:CONFIRMED
 *   SEQUENCE:111
 *   LOCATION;LANGUAGE=US:location
 *   BEGIN:VALARM
 *   DESCRIPTION:REMINDER
 *   TRIGGER:-PT15M
 *   ACTION:DISPLAY
 *   END:VALARM
 *   END:VEVENT
 *   ENDVCALENDAR
 * </pre>
 */
public final class Calendar implements ICalComponent
{
  private List<ICalComponent> iCalComponents = new ArrayList<>();

  public static Calendar newInstance()
  {
    return new Calendar();
  }

  private Calendar()
  {
  }

  public Calendar method(Method method)
  {
    iCalComponents.add(method);
    return this;
  }

  public Calendar version(Version version)
  {
    iCalComponents.add(version);
    return this;
  }

  public Calendar timeZone(TimeZone timeZone)
  {
    iCalComponents.add(timeZone);
    return this;
  }

  public Calendar event(Event event)
  {
    iCalComponents.add(event);
    return this;
  }

  @Override
  public String value()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("BEGIN:VCALENDAR\n");
    for (ICalComponent iCalComponent : iCalComponents)
    {
      builder.append(iCalComponent.value()).append("\n");
    }
    builder.append("END:VCALENDAR");
    return builder.toString();
  }
}
