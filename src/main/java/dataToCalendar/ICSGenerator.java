package dataToCalendar;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;

import generator.CalendarFormat;
import generator.CalendarGenerator;
import generator.CalendarGeneratorFactory;
import generator.CalendarRequest;
import service.CalendarGeneratorFactoryImpl;
import service.CalendarGeneratorRegistry;
import service.ICalendarGenerator;

public class ICSGenerator
{
  public String getCalendarICS()
  {
    CalendarGeneratorRegistry calendarGeneratorRegistry = new CalendarGeneratorRegistry();
    calendarGeneratorRegistry.register(CalendarFormat.ICS, new ICalendarGenerator());

    CalendarGeneratorFactory calendarGeneratorFactory = new CalendarGeneratorFactoryImpl(calendarGeneratorRegistry);
    CalendarGenerator calendarGenerator = calendarGeneratorFactory.getCalendarGenerator(CalendarFormat.ICS);

    final CalendarRequest calendarRequest = getCalendarRequest();
    return calendarGenerator.create(calendarRequest).getContent();
  }

  private CalendarRequest getCalendarRequest()
  {
    CalendarNotification calendarNotification = getCalendarNotification();
    CalendarRequest.Builder calendarRequestBuilder =
      CalendarRequest.builder().attendees(calendarNotification.getAttendees()).organizer("scorpius.cambio@gmail.com")
        .startDateTime(toLocalDateTime(calendarNotification.getBeginDateTime()))
        .endDateTime(toLocalDateTime(calendarNotification.getEndDateTime()))
        .message("This will create the meeting request").subject("Create Meeting");

    return calendarRequestBuilder.build();
  }

  public CalendarNotification getCalendarNotification()
  {
    List<String> attendees = Arrays.asList("6tharshi@gmail.com", "jeyaganeshan.jeyatharsini@cambio.lk");

    return CalendarNotification.getBuilder().meetingEventType(MeetingEventType.BOOK)
      .beginDateTime(DateTime.now().plusDays(1).plusHours(1)).endDateTime(DateTime.now().plusDays(1).plusHours(2))
      .attendees(attendees).build();
  }

  private LocalDateTime toLocalDateTime(final DateTime dateTime)
  {
    return LocalDateTime.of(dateTime.getYear(),
                            dateTime.getMonthOfYear(),
                            dateTime.getDayOfMonth(),
                            dateTime.getHourOfDay(),
                            dateTime.getMinuteOfHour(),
                            dateTime.getSecondOfMinute());
  }
}
