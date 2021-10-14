package emailapi;

import java.util.ArrayList;
import java.util.List;

/**
 * A convenient way to add email attachments. Use either {@code data} byte array or {@code content} string with type.
 *
 * <pre>
 *   {@code
 *    Attachment attachment = Attachment.builder().fileName("test.txt").data(new byte[0]).build();
 *   }
 * </pre>
 */
public final class Attachment
{
  private String fileName;
  private String type;
  private String content;
  private byte[] data;
  private List<Header> headers;

  private Attachment(Builder builder)
  {
    this.fileName = builder.fileName;
    this.type = builder.type;
    this.content = builder.content;
    this.headers = builder.headers;
    this.data = builder.data;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public String getFileName()
  {
    return fileName;
  }

  public String getType()
  {
    return type;
  }

  public String getContent()
  {
    return content;
  }

  public byte[] getData()
  {
    return data;
  }

  public List<Header> getHeaders()
  {
    return headers;
  }

  public static class Builder
  {
    private String fileName;
    private String type;
    private String content;
    private byte[] data;
    private List<Header> headers = new ArrayList<>();

    public Builder fileName(String fileName)
    {
      this.fileName = fileName;
      return this;
    }

    public Builder type(String type)
    {
      this.type = type;
      return this;
    }

    public Builder content(String content)
    {
      this.content = content;
      return this;
    }

    public Builder data(byte[] data)
    {
      this.data = data;
      return this;
    }

    public Builder headers(List<Header> headers)
    {
      this.headers = headers;
      return this;
    }

    public Builder addHeader(Header header)
    {
      this.headers.add(header);
      return this;
    }

    public Attachment build()
    {
      return new Attachment(this);
    }
  }

}
