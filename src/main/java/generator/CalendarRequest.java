package generator;

import java.time.LocalDateTime;
import java.util.List;

public final class CalendarRequest
{
  private String organizer;
  private List<String> attendees;
  private String subject;
  private String message;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;

  private CalendarRequest(Builder builder)
  {
    this.organizer = builder.organizer;
    this.attendees = builder.attendees;
    this.subject = builder.subject;
    this.message = builder.message;
    this.startDateTime = builder.startDateTime;
    this.endDateTime = builder.endDateTime;
  }

  public String getOrganizer()
  {
    return organizer;
  }

  public List<String> getAttendees()
  {
    return attendees;
  }

  public String getSubject()
  {
    return subject;
  }

  public String getMessage()
  {
    return message;
  }

  public LocalDateTime getStartDateTime()
  {
    return startDateTime;
  }

  public LocalDateTime getEndDateTime()
  {
    return endDateTime;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static class Builder
  {
    private String organizer;
    private List<String> attendees;
    private String subject;
    private String message;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Builder organizer(String organizer)
    {
      this.organizer = organizer;
      return this;
    }

    public Builder attendees(List<String> attendees)
    {
      this.attendees = attendees;
      return this;
    }

    public Builder subject(String subject)
    {
      this.subject = subject;
      return this;
    }

    public Builder message(String message)
    {
      this.message = message;
      return this;
    }

    public Builder startDateTime(LocalDateTime startDateTime)
    {
      this.startDateTime = startDateTime;
      return this;
    }

    public Builder endDateTime(LocalDateTime endDateTime)
    {
      this.endDateTime = endDateTime;
      return this;
    }

    public CalendarRequest build()
    {
      return new CalendarRequest(this);
    }
  }
}
