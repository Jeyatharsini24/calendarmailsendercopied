package ics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeUtils
{
  static String format(LocalDateTime dateTime)
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
    return formatter.format(dateTime).replace(" ", "T");
  }
}
