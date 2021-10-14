package ics;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the event tag of ICalendar.
 *
 * <pre>
 *   BEGIN:VEVENT
 *   SUMMARY;LANGUAGE=en-US:This is a summary
 *   DTSTART:20210913T155437
 *   DTEND:20210913T165437
 *   DTSTAMP:20210913T155437
 *   ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:example@example.com
 *   ORGANIZER;ROLE=REQ-PARTICIPANT;CN=Cambio Cosmic:RSVP=FALSE:MAILTO:example@example.com
 *   UID:12345
 *   STATUS:CONFIRMED
 *   SEQUENCE:1111
 *   LOCATION;LANGUAGE=US:location
 *   BEGIN:VALARM
 *   DESCRIPTION:REMINDER
 *   TRIGGER:-PT15M
 *   ACTION:DISPLAY
 *   END:VALARM
 *   END:VEVENT
 * </pre>
 */
public final class Event implements ICalComponent
{
  private List<ICalComponent> iCalComponents = new ArrayList<>();

  public static Event newInstance()
  {
    return new Event();
  }

  private Event()
  {
  }

  public Event status(Status status)
  {
    iCalComponents.add(status);
    return this;
  }

  public Event summary(Summary summary)
  {
    iCalComponents.add(summary);
    return this;
  }

  public Event startDateTime(StartDateTime startDateTime)
  {
    iCalComponents.add(startDateTime);
    return this;
  }

  public Event endDateTime(EndDateTime endDateTime)
  {
    iCalComponents.add(endDateTime);
    return this;
  }

  public Event attendees(Attendees attendees)
  {
    iCalComponents.add(attendees);
    return this;
  }

  public Event organizer(Organizer organizer)
  {
    iCalComponents.add(organizer);
    return this;
  }

  public Event uId(Uid uId)
  {
    iCalComponents.add(uId);
    return this;
  }

  public Event sequence(Sequence sequence)
  {
    iCalComponents.add(sequence);
    return this;
  }

  public Event timeStamp(TimeStamp timeStamp)
  {
    iCalComponents.add(timeStamp);
    return this;
  }

  public Event location(Location location)
  {
    iCalComponents.add(location);
    return this;
  }

  public Event alarm(Alarm alarm)
  {
    iCalComponents.add(alarm);
    return this;
  }

  @Override
  public String value()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("BEGIN:VEVENT\n");
    for (ICalComponent iCalComponent : iCalComponents)
    {
      builder.append(iCalComponent.value()).append("\n");
    }
    builder.append("END:VEVENT");
    return builder.toString();
  }
}
