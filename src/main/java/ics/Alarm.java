package ics;

public final class Alarm implements ICalComponent
{
  private String description;

  public Alarm(String description)
  {
    this.description = description;
  }

  @Override
  public String value()
  {
    return "BEGIN:VALARM\n".concat("DESCRIPTION:").concat(description).concat("\nTRIGGER:-PT15M\n")
      .concat("ACTION:DISPLAY\n").concat("END:VALARM");
  }

}
