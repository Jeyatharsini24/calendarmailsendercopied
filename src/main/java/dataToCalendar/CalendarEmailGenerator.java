package dataToCalendar;

import java.util.ArrayList;
import java.util.List;

import emailapi.Calendar;
import emailapi.Email;
import emailapi.Header;

public class CalendarEmailGenerator
{
  public Email createEmail(final CalendarNotification calendarNotification, final String ics)
  {
    Calendar.Method method = getEmailMethod(calendarNotification.getMeetingEventType());

    return Email.builder().from("jj@gmail.com")
      .to(calendarNotification.getAttendees().toArray(new String[0])).subject("Appointment")
      .headers(getEmailHeader(method)).message("message").calendar(Calendar.getInstance(ics, "Appointment", method))
      .build();
  }

  private Calendar.Method getEmailMethod(final MeetingEventType meetingEventType)
  {
    Calendar.Method method;

    switch (meetingEventType)
    {
    case BOOK:
    case UPDATE:
    case REBOOK:
      method = Calendar.Method.REQUEST;
      break;
    case CANCEL:
      method = Calendar.Method.CANCEL;
      break;
    default:
      method = null;
    }
    return method;
  }

  private List<Header> getEmailHeader(final Calendar.Method method)
  {
    List<Header> headers = new ArrayList<>();
    headers.add(Header.getInstance("method", String.valueOf(method)));
    headers.add(Header.getInstance("charset", "UTF-8"));
    headers.add(Header.getInstance("component", "VEVENT"));

    return headers;
  }
}
