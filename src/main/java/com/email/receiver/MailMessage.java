package com.email.receiver;

public class MailMessage {

  private String subject;
  private String content;

  public MailMessage() {
    // Default constructor
  }


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "LocateMail {"
        + " subject=" + subject
        + ", content=" + content
        + " }";
  }


}
