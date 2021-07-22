package com.email.receiver;

import javax.mail.internet.MimeMessage;
import org.springframework.util.ReflectionUtils;


public class MailProcessor {

  public void process(MimeMessage message) {
    try {
      MailMessage locateMail = new MailMessage();
      locateMail.setSubject(message.getSubject());
      locateMail.setContent(message.getContent().toString());
    } catch (Exception e) {
      ReflectionUtils.rethrowRuntimeException(e);
    }
  }

}
