package emailimpl;

/**
 * default email configuration provider which can be used
 * when no other email configuration provided
 */
public class SampleEmailPropertyProvider implements EmailPropertyProvider
{
  @Override
  public EmailProperties provide()
  {
    return EmailProperties.builder()
      .auth(true)
      .enableTls(true)
      .host("smtp.gmail.com")
      .port("587")
      .authUser("jj@gmail.com")
      .authPassword("password")
      .build();
  }
}
