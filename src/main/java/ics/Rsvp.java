package ics;

public enum Rsvp
{
  TRUE("TRUE"), FALSE("FALSE");

  private String rsvp;

  Rsvp(String rsvp)
  {
    this.rsvp = rsvp;
  }

  public String value()
  {
    return rsvp;
  }
}
