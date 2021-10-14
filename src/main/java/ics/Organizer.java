package ics;

/**
 * Generates the organizer tag of ICalendar.
 *
 * <pre>
 *   ORGANIZER;ROLE=REQ-PARTICIPANT;CN=Cambio Cosmic:RSVP=FALSE:MAILTO:example@example.com
 * </pre>
 */
public final class Organizer implements ICalComponent
{
  private String email;
  private Role role;
  private String cn;

  public Organizer(String email, Role role, String cn)
  {
    this.email = email;
    this.role = role;
    this.cn = cn;
  }

  @Override
  public String value()
  {
    return "ORGANIZER;ROLE=".concat(role.value())
      .concat(";CN=").concat(cn)
      .concat(":MAILTO:").concat(email);
  }
}
