package gof.creational.stepBuilder;

/**
 *
 *
 *
 * the build order will be protocol -> url -> ipAddress -> port -> description -> uptime
 *
 * all the steps are mandatory, if some parts are mandatory , others are optional, see EMail.java
 *
 * * Builder vs StepBuilder
 *
 * StepBuilder is like the enhanced version of Builder pattern, when need more steps control (sequence), StepBuilder is an option
 * but with the proper Builder constutor (with mandatory fields) , can archieve same target.
 *
 *
 *
 * @author Michael Liu
 */
public class Server
{
  final static int DEFAULT_PORT = 8080;

  private String protocol;
  private String url;
  private String ipAddress;
  private int port;
  private String description;
  private long uptime;


  private Server(Builder builder)
  {
    protocol = builder.protocol;
    url = builder.url;
    ipAddress = builder.ipAddress;
    port = builder.port;
    description = builder.description;
    uptime = builder.uptime;
  }

  public static IProtocol builder()
  {
    return new Builder();
  }

  interface IBuild
  {
    Server build();
  }

  interface IUptime
  {
    IBuild withUptime(long val);
  }

  interface IDescription
  {
    IUptime withDescription(String val);
  }

  interface IPort
  {
    IDescription withPort(int val);
  }

  interface IIpAddress
  {
    IPort withIpAddress(String val);
  }

  interface IUrl
  {
    IIpAddress withUrl(String val);
  }

  interface IProtocol
  {
    IUrl withProtocol(String val);
  }

  public static final class Builder implements IUptime, IDescription, IPort, IIpAddress, IUrl, IProtocol, IBuild
  {
    private long uptime;
    private String description;
    private int port;
    private String ipAddress;
    private String url;
    private String protocol;

    private Builder()
    {
    }

    @Override public IBuild withUptime(long val)
    {
      uptime = val;
      return this;
    }

    @Override public IUptime withDescription(String val)
    {
      description = val;
      return this;
    }

    @Override public IDescription withPort(int val)
    {
      port = val;
      return this;
    }

    @Override public IPort withIpAddress(String val)
    {
      ipAddress = val;
      return this;
    }

    @Override public IIpAddress withUrl(String val)
    {
      url = val;
      return this;
    }

    @Override public IUrl withProtocol(String val)
    {
      protocol = val;
      return this;
    }

    public Server build()
    {
      return new Server(this);
    }
  }
}
