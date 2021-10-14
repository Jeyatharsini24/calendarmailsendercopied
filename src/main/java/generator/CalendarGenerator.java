package generator;

public interface CalendarGenerator
{
  CalendarResponse create(CalendarRequest calendarRequest);

  CalendarResponse update(CalendarRequest calendarRequest);

  CalendarResponse cancel(CalendarRequest calendarRequest);
}
