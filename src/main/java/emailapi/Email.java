package emailapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class models an email. It holds all necessary information to create Java email message.
 * Use the convenient <code>Builder</code> to construct an instance.
 * We can use any standard headers or custom headers by adding {@code Header}.
 *
 * <pre>
 * {@code
 *   Email email = Email.builder()
 *    .from("example1@example.com")
 *    .to("example2@example.com")
 *    .subject("This is email subject")
 *    .message("This is email message")
 *    .build();
 * }</pre>
 * <p>
 * We can create email with attachment by adding {@code Attachment}.
 *
 * <pre>
 * {@code
 *   Attachment attachment = Attachment.builder().fileName("test.txt").data(new byte[0]).build();
 *
 *   Email email = Email.builder()
 *    .from("example1@example.com")
 *    .to("example2@example.com")
 *    .subject("An attachment")
 *    .message("This is email with attachment")
 *    .addAttachment(attachment) // .attachments()
 *    .build();
 * }</pre>
 */
public class Email
{
  private String from;
  private List<String> to;
  private String subject;
  private String message;
  private List<Attachment> attachments;
  private List<Header> headers;

  private Email(Builder builder)
  {
    this.from = builder.from;
    this.to = builder.to;
    this.subject = builder.subject;
    this.message = builder.message;
    this.attachments = builder.attachments;
    this.headers = builder.headers;
    this.attachCalendar(builder.calendar);
  }

  private void attachCalendar(Calendar calendar)
  {
    if (calendar != null)
    {
      Attachment calendarAttachment = Attachment.builder().fileName(calendar.getName()).content(calendar.getContent())
        .type("text/calendar;method=" + calendar.getMethod()).build();

      this.attachments.add(calendarAttachment);
    }
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public String getFrom()
  {
    return this.from;
  }

  public List<String> getTo()
  {
    return this.to;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public String getMessage()
  {
    return this.message;
  }

  public List<Attachment> getAttachments()
  {
    return attachments;
  }

  public List<Header> getHeaders()
  {
    return headers;
  }

  public static class Builder
  {
    private String from;
    private List<String> to;
    private String subject;
    private String message;
    private List<Attachment> attachments;
    private Calendar calendar;
    private List<Header> headers;

    private Builder()
    {
      this.to = new ArrayList<>();
      this.attachments = new ArrayList<>();
    }

    public Builder from(String from)
    {
      this.from = from;
      return this;
    }

    public Builder to(String... to)
    {
      this.to = Arrays.asList(to);
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

    public Builder attachments(List<Attachment> attachments)
    {
      this.attachments = attachments;
      return this;
    }

    public Builder addAttachment(Attachment attachment)
    {
      this.attachments.add(attachment);
      return this;
    }

    public Builder calendar(Calendar calendar)
    {
      this.calendar = calendar;
      return this;
    }

    public Builder headers(List<Header> headers)
    {
      this.headers = headers;
      return this;
    }

    public Email build()
    {
      return new Email(this);
    }
  }

}
