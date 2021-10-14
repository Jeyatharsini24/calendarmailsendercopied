import java.io.IOException;

import javax.mail.MessagingException;

import dataToCalendar.CalendarEmailGenerator;
import dataToCalendar.CalendarNotification;
import dataToCalendar.ICSGenerator;
import emailapi.Email;
import emailapi.EmailSender;
import emailimpl.EmailPropertyProvider;
import emailimpl.EmailSenderImpl;
import emailimpl.MailSessionFactory;
import emailimpl.MailSessionFactoryImpl;
import emailimpl.SampleEmailPropertyProvider;

public class CalendarGeneratorTest
{
  public static void main(String[] args) throws IOException, MessagingException
  {
    ICSGenerator icsGenerator = new ICSGenerator();
    String ics = icsGenerator.getCalendarICS();
    CalendarNotification calendarNotification = icsGenerator.getCalendarNotification();

    CalendarEmailGenerator calendarEmailGenerator = new CalendarEmailGenerator();
    Email email = calendarEmailGenerator.createEmail(calendarNotification, ics);
    getEmailSender().send(email);
  }

  private static EmailSender getEmailSender()
  {
    EmailPropertyProvider emailPropertyProvider = new SampleEmailPropertyProvider();
    MailSessionFactory emailSessionFactory = new MailSessionFactoryImpl(emailPropertyProvider.provide());
    return new EmailSenderImpl(emailSessionFactory);
  }
}
