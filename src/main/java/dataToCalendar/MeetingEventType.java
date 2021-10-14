package dataToCalendar;

public enum MeetingEventType
{
  BOOK("resourceplanning.v1.event.appointment.booked"), REBOOK("resourceplanning.v1.event.appointment.rebooked"),
  CANCEL("resourceplanning.v1.event.appointment.canceled"), UPDATE("resourceplanning.v1.event.appointment.updated");

  private String eventType;

  MeetingEventType(String eventType)
  {
    this.eventType = eventType;
  }

  public String getValue()
  {
    return eventType;
  }
}
