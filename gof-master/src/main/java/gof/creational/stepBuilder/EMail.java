package gof.creational.stepBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Michael Liu
 *
 * build order : from -> to -> subject -> content -> (cc/bcc - optional)
 *

 */
public class EMail
{
  private String from;
  private List<String> to;
  private List<String> cc;
  private List<String> bcc;
  private String subject;
  private String content;

  private EMail(Builder builder)
  {
    from = builder.from;
    to = builder.to;
    cc = builder.cc;
    bcc = builder.bcc;
    subject = builder.subject;
  }

  @Override public String toString()
  {
    return "EMail{" +
        "from='" + from + '\'' +
        ", to=" + to +
        ", cc=" + cc +
        ", bcc=" + bcc +
        ", subject='" + subject + '\'' +
        ", content='" + content + '\'' +
        '}';
  }

  public static IFrom builder()
  {
    return new Builder();
  }

  interface IBuild
  {
    EMail build();

    IBuild cc(String... cc);

    IBuild bcc(String... cc);
  }

  interface ITo
  {
    ISubject withTo(String... val);
  }

  interface IFrom
  {
    ITo withFrom(String val);
  }

  interface ISubject
  {
    IBuild withSubject(String val);

  }

  public static final class Builder implements ISubject, ITo, IFrom, IBuild
  {
    private String subject;
    private List<String> bcc;
    private List<String> cc;
    private List<String> to;
    private String from;

    private Builder()
    {
    }

    @Override
    public IBuild withSubject(String val)
    {
      subject = val;
      return this;
    }

    @Override
    public ISubject withTo(String... val)
    {
      Objects.requireNonNull(val);
      to = new ArrayList<>(Arrays.asList(val));
      return this;
    }

    @Override
    public ITo withFrom(String val)
    {
      from = val;
      return this;
    }

    public EMail build()
    {
      return new EMail(this);
    }

    @Override
    public IBuild cc(String... cc)
    {
      this.cc = Arrays.asList(cc);
      return this;
    }

    @Override
    public IBuild bcc(String... bcc)
    {
      this.bcc = Arrays.asList(bcc);
      return this;
    }
  }
}
