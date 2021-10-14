package emailimpl;

import javax.mail.Session;

public interface MailSessionFactory
{
  Session getSession();
}
