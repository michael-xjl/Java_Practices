package gof.behavioral.visitor.s1.structure;

import gof.behavioral.visitor.s1.visitors.MailClientVisitor;

public interface MailClient {
    void sendMail(String[] mailInfo);
    void receiveMail(String[] mailInfo);
    boolean accept(MailClientVisitor visitor);
}
