package generator;

public interface CalendarGeneratorFactory
{
  CalendarGenerator getCalendarGenerator(CalendarFormat calendarFormat);
}
