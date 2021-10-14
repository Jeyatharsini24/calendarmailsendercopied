package emailapi;

import java.io.IOException;

import javax.mail.MessagingException;

/**
 * This interface defines the strategy for sending emails.
 *
 * <pre>
 * {@code
 * public class EmailClient
 * {
 *   private EmailSender emailSender;
 *
 *   public EmailClient(EmailSender emailSender)
 *   {
 *     this.emailSender = emailSender;
 *   }
 *
 *   public void sendEmail()
 *   {
 *     Email email = Email.builder()
 *       .from("example1@example.com")
 *       .to("example2@example.com")
 *       .subject("Email subject")
 *       .message("Email message")
 *       .build();
 *     emailSender.send(email);
 *   }
 * }
 * }
 * </pre>
 */
public interface EmailSender
{
  /**
   * Send the given {@code Email}.
   * @param email {@code Email} to be sent.
   */
  void send(Email email) throws IOException, MessagingException;
}
