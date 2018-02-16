package com.db.amd.locate.receiver;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.mail.Mail;

@SpringBootApplication
public class LocateReceiverApplication {
	
	@Bean
	public LocateProcessor locateProcessor() {
		return new LocateProcessor();
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
		return IntegrationFlows.from(Mail.imapIdleAdapter("imaps://binaymishra136:Pa$$w0rd47@imap.gmail.com:993/inbox")
					.javaMailProperties(javaMailProperties())
					.shouldDeleteMessages(true)
					.shouldMarkMessagesAsRead(true)
					.shouldReconnectAutomatically(true)
				).handle(locateProcessor(), "process")
				.get();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocateReceiverApplication.class, args);
	}
}
