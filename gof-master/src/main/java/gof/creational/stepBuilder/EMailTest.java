package gof.creational.stepBuilder;

/**
 * @author Michael Liu
 */
public class EMailTest
{
  public static void main(String[] args)
  {
    EMail email = EMail.builder().withFrom("michael.xjl@gxxx.com").withTo("hi_git@g.com").withSubject("step builder partten").build();
    System.out.println(email);

    email = EMail.builder().withFrom("michael.xjl@gxxx.com").withTo("hi_git@g.com").withSubject("step builder partten").bcc("bcc@g.xom").build();
    System.out.println(email);
  }
}
