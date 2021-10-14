package service;

import generator.CalendarFormat;
import generator.CalendarGenerator;
import generator.CalendarGeneratorFactory;

public class CalendarGeneratorFactoryImpl implements CalendarGeneratorFactory
{
  private CalendarGeneratorRegistry calendarGeneratorRegistry;

  public CalendarGeneratorFactoryImpl(CalendarGeneratorRegistry calendarGeneratorRegistry)
  {
    this.calendarGeneratorRegistry = calendarGeneratorRegistry;
  }

  @Override
  public CalendarGenerator getCalendarGenerator(CalendarFormat calendarFormat)
  {
    return calendarGeneratorRegistry.getCalendarGenerator(calendarFormat);
  }
}
