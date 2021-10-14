package generator;

public final class CalendarResponse
{
  private String content;

  private CalendarResponse(String content)
  {
    this.content = content;
  }

  public static CalendarResponse of(String content)
  {
    return new CalendarResponse(content);
  }

  public String getContent()
  {
    return content;
  }
}
