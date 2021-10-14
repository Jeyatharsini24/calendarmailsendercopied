package emailimpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import emailapi.Attachment;
import emailapi.Header;

class MimeMessageBuilder
{
  private MimeMessage mimeMessage;

  private MimeMessageBuilder(Session session)
  {
    this.mimeMessage = new MimeMessage(session);
  }

  static MimeMessageBuilder getInstance(Session session)
  {
    return new MimeMessageBuilder(session);
  }

  MimeMessageBuilder from(String from) throws UnsupportedEncodingException, MessagingException
  {
    mimeMessage.setFrom(internetAddress(from));
    return this;
  }

  MimeMessageBuilder recipients(List<String> recipients) throws UnsupportedEncodingException, MessagingException
  {
    mimeMessage.setRecipients(Message.RecipientType.TO, internetAddresses(recipients));
    return this;
  }

  MimeMessageBuilder subject(String subject) throws MessagingException
  {
    mimeMessage.setSubject(subject);
    return this;
  }

  MimeMessageBuilder headers(List<Header> headers) throws MessagingException
  {
    if (Objects.nonNull(headers))
    {
      for (Header header : headers)
      {
        mimeMessage.setHeader(header.getName(), header.getValue());
      }
    }
    return this;
  }

  MimeMessageBuilder body(String message, List<Attachment> attachments) throws MessagingException, IOException
  {
    BodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setText(message);

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    addAttachments(attachments, multipart);

    mimeMessage.setContent(multipart);

    return this;
  }

  MimeMessage build()
  {
    return mimeMessage;
  }

  private void addAttachments(List<Attachment> attachments, Multipart multipart) throws MessagingException, IOException
  {
    if (Objects.nonNull(attachments))
    {
      for (Attachment attachment : attachments)
      {
        MimeBodyPart attachmentPart = new MimeBodyPart();
        if (Objects.nonNull(attachment.getHeaders()))
        {
          for (Header header : attachment.getHeaders())
          {
            attachmentPart.setHeader(header.getName(), header.getValue());
          }
        }
        attachmentPart.setFileName(attachment.getFileName());
        ByteArrayDataSource byteArrayDataSource = getByteArrayDataSource(attachment);
        attachmentPart.setDataHandler(new DataHandler(byteArrayDataSource));
        multipart.addBodyPart(attachmentPart);
      }
    }
  }

  private ByteArrayDataSource getByteArrayDataSource(Attachment attachment) throws IOException
  {
    if (Objects.nonNull(attachment.getData()))
    {
      return new ByteArrayDataSource(attachment.getData(), attachment.getType());
    }
    else
    {
      return new ByteArrayDataSource(attachment.getContent(), attachment.getType());
    }
  }

  private InternetAddress[] internetAddresses(List<String> addresses)
    throws UnsupportedEncodingException, AddressException
  {
    List<InternetAddress> internetAddresses = new ArrayList<>();
    for (String address : addresses)
    {
      internetAddresses.add(internetAddress(address));
    }
    return internetAddresses.toArray(new InternetAddress[0]);
  }

  private InternetAddress internetAddress(String address) throws AddressException, UnsupportedEncodingException
  {
    InternetAddress[] parsed = InternetAddress.parse(address);
    InternetAddress raw = parsed[0];
    return new InternetAddress(raw.getAddress(), raw.getPersonal());
  }
}
