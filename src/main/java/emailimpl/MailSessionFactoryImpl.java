package emailimpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailSessionFactoryImpl implements MailSessionFactory
{
  private Session session;

  public MailSessionFactoryImpl(EmailProperties emailProperties)
  {
    init(emailProperties);
  }

  private void init(EmailProperties emailProperties)
  {
    EmailAuthenticator authenticator = new EmailAuthenticator(emailProperties.getUsername(), emailProperties.getPassword());
    Properties properties = new PropertiesBuilder(emailProperties).build();
    this.session = Session.getInstance(properties, authenticator);
  }

  @Override
  public Session getSession()
  {
    return session;
  }

  private static class EmailAuthenticator extends Authenticator
  {
    private String username;
    private String password;

    private EmailAuthenticator(String username, String password)
    {
      this.username = username;
      this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication()
    {
      return new PasswordAuthentication(username, password);
    }
  }

  private static class PropertiesBuilder
  {
    private EmailProperties emailProperties;

    private PropertiesBuilder(EmailProperties emailProperties)
    {
      this.emailProperties = emailProperties;
    }

    private Properties build()
    {
      Properties properties = new Properties();
      properties.put("mail.smtp.auth", emailProperties.auth());
      properties.put("mail.smtp.starttls.enable", emailProperties.enableTls());
      properties.put("mail.smtp.host", emailProperties.getHost());
      properties.put("mail.smtp.port", emailProperties.getPort());
      return properties;
    }
  }
}
