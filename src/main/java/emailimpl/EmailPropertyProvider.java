package emailimpl;

/**
 * provider for email configuration values
 */
public interface EmailPropertyProvider
{
  /**
   * provide email configuration values
   *
   * @return email configuration values
   */
  EmailProperties provide();
}
