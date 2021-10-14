package emailimpl;

/**
 * Configurations for email sender
 */
class EmailProperties
{
  private boolean auth;
  private boolean enableTls;
  private String host;
  private String port;
  private String username;
  private String password;

  private EmailProperties(Builder builder)
  {
    this.auth = builder.auth;
    this.enableTls = builder.enableTls;
    this.host = builder.host;
    this.port = builder.port;
    this.username = builder.authUser;
    this.password = builder.authPassword;
  }

  static EmailProperties.Builder builder()
  {
    return new EmailProperties.Builder();
  }

  boolean auth()
  {
    return auth;
  }

  boolean enableTls()
  {
    return enableTls;
  }

  String getHost()
  {
    return host;
  }

  String getPort()
  {
    return port;
  }

  String getUsername()
  {
    return username;
  }

  String getPassword()
  {
    return password;
  }

  public static class Builder
  {
    private boolean auth = true;
    private boolean enableTls = true;
    private String host = "";
    private String port = "";
    private String authUser = "";
    private String authPassword = "";

    Builder auth(boolean auth)
    {
      this.auth = auth;
      return this;
    }

    Builder enableTls(boolean tls)
    {
      this.enableTls = tls;
      return this;
    }

    Builder host(String host)
    {
      this.host = host;
      return this;
    }

    Builder port(String port)
    {
      this.port = port;
      return this;
    }

    Builder authUser(String authUser)
    {
      this.authUser = authUser;
      return this;
    }

    Builder authPassword(String authPassword)
    {
      this.authPassword = authPassword;
      return this;
    }

    EmailProperties build()
    {
      return new EmailProperties(this);
    }
  }
}
