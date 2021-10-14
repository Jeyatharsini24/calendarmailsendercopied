package ics;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates the attendees tag of ICalendar.
 *
 * <pre>
 *   ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:example1@example.com
 *   ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:example2@example.com
 * </pre>
 */
public final class Attendees implements ICalComponent
{
  private List<Attendee> attendees;

  public Attendees()
  {
    this.attendees = new ArrayList<>();
  }

  public void add(Attendee attendee)
  {
    attendees.add(attendee);
  }

  @Override
  public String value()
  {
    return attendees.stream().map(Attendee::value).collect(joining("\n"));
  }
}
