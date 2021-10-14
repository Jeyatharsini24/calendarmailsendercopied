package service;

import java.util.List;

import generator.CalendarGenerator;
import generator.CalendarRequest;
import generator.CalendarResponse;
import ics.Alarm;
import ics.Attendee;
import ics.Attendees;
import ics.Calendar;
import ics.EndDateTime;
import ics.Event;
import ics.Location;
import ics.Method;
import ics.Organizer;
import ics.Role;
import ics.Rsvp;
import ics.Sequence;
import ics.StartDateTime;
import ics.Status;
import ics.Summary;
import ics.TimeStamp;
import ics.TimeZone;
import ics.Uid;
import ics.Version;

public class ICalendarGenerator implements CalendarGenerator
{
  @Override public CalendarResponse create(CalendarRequest calendarRequest)
  {
    TimeZone timeZone = new TimeZone(java.util.TimeZone.getDefault());

    Event event = Event.newInstance()
      .uId(new Uid((Math.ceil(Math.random() * 100000) % 8) + "")).status(Status.CONFIRMED)
             .organizer(new Organizer(calendarRequest.getOrganizer(), Role.CHAIR, "COSMIC"))
             .attendees(attendees(calendarRequest.getAttendees()))
             .startDateTime(new StartDateTime(calendarRequest.getStartDateTime()))
             .endDateTime(new EndDateTime(calendarRequest.getEndDateTime())).timeStamp(new TimeStamp())
             .summary(new Summary(calendarRequest.getSubject())).sequence(new Sequence("0"))
             .location(new Location("location")).alarm(new Alarm("REMINDER"));

    String iCalendar =
      Calendar.newInstance().version(Version.VERSION_2_0).method(Method.REQUEST).timeZone(timeZone).event(event)
        .value();

    return CalendarResponse.of(iCalendar);
  }

  @Override public CalendarResponse update(CalendarRequest calendarRequest)
  {
    TimeZone timeZone = new TimeZone(java.util.TimeZone.getDefault());

    Event event = Event.newInstance().uId(new Uid((Math.ceil(Math.random() * 100000) % 8) + "")).status(Status.CONFIRMED)
      .organizer(new Organizer(calendarRequest.getOrganizer(), Role.CHAIR, "COSMIC"))
      .attendees(attendees(calendarRequest.getAttendees()))
      .startDateTime(new StartDateTime(calendarRequest.getStartDateTime()))
      .endDateTime(new EndDateTime(calendarRequest.getEndDateTime())).timeStamp(new TimeStamp())
      .summary(new Summary(calendarRequest.getSubject())).sequence(new Sequence("1")).location(new Location("location"))
      .alarm(new Alarm("REMINDER"));

    String iCalendar =
      Calendar.newInstance().version(Version.VERSION_2_0).method(Method.REQUEST).timeZone(timeZone).event(event)
        .value();
    return CalendarResponse.of(iCalendar);
  }

  @Override public CalendarResponse cancel(CalendarRequest calendarRequest)
  {
    TimeZone timeZone = new TimeZone(java.util.TimeZone.getDefault());

    Event event = Event.newInstance().uId(new Uid((Math.ceil(Math.random() * 100000) % 8) + "")).status(Status.CANCELLED)
      .organizer(new Organizer(calendarRequest.getOrganizer(), Role.CHAIR, "COSMIC"))
      .attendees(attendees(calendarRequest.getAttendees()))
      .startDateTime(new StartDateTime(calendarRequest.getStartDateTime()))
      .endDateTime(new EndDateTime(calendarRequest.getEndDateTime())).sequence(new Sequence("1"));

    String iCalendar =
      Calendar.newInstance().version(Version.VERSION_2_0).method(Method.CANCEL).timeZone(timeZone).event(event).value();
    return CalendarResponse.of(iCalendar);
  }

  private Attendees attendees(List<String> emails)
  {
    Attendees attendees = new Attendees();
    for (String email : emails)
    {
      Attendee attendee = new Attendee(email, Role.REQ_PARTICIPANT, Rsvp.FALSE);
      attendees.add(attendee);
    }
    return attendees;
  }
}
