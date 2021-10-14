package ics;

public enum Role
{
  REQ_PARTICIPANT("REQ-PARTICIPANT"), CHAIR("CHAIR");

  private String role;

  Role(String role)
  {
    this.role = role;
  }

  public String value()
  {
    return role;
  }
}
