package service;

import static java.util.Objects.nonNull;

import java.util.EnumMap;

import generator.CalendarFormat;
import generator.CalendarGenerator;

public class CalendarGeneratorRegistry
{
  private EnumMap<CalendarFormat, CalendarGenerator> calendarGenerators = new EnumMap<>(CalendarFormat.class);

  public CalendarGenerator getCalendarGenerator(CalendarFormat calendarFormat)
  {
    CalendarGenerator calendarGenerator = calendarGenerators.get(calendarFormat);
    return nonNull(calendarGenerator) ? calendarGenerator : new DefaultCalendarGenerator();
  }

  public void register(CalendarFormat calendarFormat, CalendarGenerator calendarGenerator)
  {
    calendarGenerators.put(calendarFormat, calendarGenerator);
  }

}
