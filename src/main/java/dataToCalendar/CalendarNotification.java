package dataToCalendar;

import java.util.List;

import org.joda.time.DateTime;

public class CalendarNotification
{
  private MeetingEventType meetingEventType;
  private List<String> attendees;
  private DateTime beginDateTime;
  private DateTime endDateTime;

  private CalendarNotification(Builder builder)
  {
    this.meetingEventType = builder.meetingEventType;
    this.attendees = builder.attendees;
    this.beginDateTime = builder.beginDateTime;
    this.endDateTime = builder.endDateTime;
  }

  public MeetingEventType getMeetingEventType()
  {
    return meetingEventType;
  }

  public List<String> getAttendees()
  {
    return attendees;
  }

  public DateTime getBeginDateTime()
  {
    return beginDateTime;
  }

  public DateTime getEndDateTime()
  {
    return endDateTime;
  }

  public static Builder getBuilder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private MeetingEventType meetingEventType;
    private List<String> attendees;
    private DateTime beginDateTime;
    private DateTime endDateTime;

    public Builder attendees(List<String> resourceIds)
    {
      this.attendees = resourceIds;
      return this;
    }

    public Builder beginDateTime(DateTime beginDateTime)
    {
      this.beginDateTime = beginDateTime;
      return this;
    }

    public Builder endDateTime(DateTime endDateTime)
    {
      this.endDateTime = endDateTime;
      return this;
    }

    public Builder meetingEventType(MeetingEventType meetingEventType)
    {
      this.meetingEventType = meetingEventType;
      return this;
    }

    public CalendarNotification build()
    {
      return new CalendarNotification(this);
    }
  }
}
