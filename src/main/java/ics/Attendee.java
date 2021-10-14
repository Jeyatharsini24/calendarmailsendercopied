package ics;

/**
 * Generates the attendee tag of ICalendar.
 *
 * <pre>
 *   ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE:MAILTO:example@example.com
 * </pre>
 */
public final class Attendee implements ICalComponent
{
  private String email;
  private Role role;
  private Rsvp rsvp;

  public Attendee(String email, Role role, Rsvp rsvp)
  {
    this.email = email;
    this.role = role;
    this.rsvp = rsvp;
  }

  @Override
  public String value()
  {
    return "ATTENDEE;ROLE=".concat(role.value()).concat(";RSVP=").concat(rsvp.value()).concat(":MAILTO:").concat(email);
  }
}
