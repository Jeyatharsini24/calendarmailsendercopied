package emailimpl;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import emailapi.Email;
import emailapi.EmailSender;

public class EmailSenderImpl implements EmailSender
{
  private MailSessionFactory mailSessionFactory;

  public EmailSenderImpl(MailSessionFactory mailSessionFactory)
  {
    this.mailSessionFactory = mailSessionFactory;
  }

  @Override public void send(Email email) throws IOException, MessagingException
  {
    sendEmail(email);
  }

  private void sendEmail(Email email) throws IOException, javax.mail.MessagingException
  {
    MimeMessage mimeMessage =
      MimeMessageBuilder.getInstance(mailSessionFactory.getSession()).from(email.getFrom()).recipients(email.getTo())
        .subject(email.getSubject()).body(email.getMessage(), email.getAttachments()).headers(email.getHeaders())
        .build();

    if (Objects.isNull(mimeMessage.getSentDate()))
    {
      mimeMessage.setSentDate(new Date());
    }
    Transport.send(mimeMessage);
  }
}
