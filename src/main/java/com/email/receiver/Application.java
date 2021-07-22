package com.email.receiver;

import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.mail.Mail;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public MailProcessor locateProcessor() {
    return new MailProcessor();
  }

  @Bean
  public Properties javaMailProperties() {
    Properties props = new Properties();
    props.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.imap.socketFactory.fallback", "false");
    props.put("mail.store.protocol", "imaps");
    props.put("mail.debug", "false");
    return props;
  }

  @Bean
  public IntegrationFlow imapMailFlow() {
    return IntegrationFlows
        .from(
            Mail.imapIdleAdapter("imaps://binaymishra136:qnmtszxyustltypf@imap.gmail.com:993/inbox")
                .javaMailProperties(javaMailProperties())
                .maxFetchSize(10)
                .shouldDeleteMessages(true)
                .shouldMarkMessagesAsRead(true)
                .shouldReconnectAutomatically(true)
        ).handle(locateProcessor(), "process")
        .get();
  }
}
