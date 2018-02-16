package com.db.amd.locate.receiver;

import javax.mail.internet.MimeMessage;

import org.springframework.util.ReflectionUtils;


public class LocateProcessor {
	
	public void process(MimeMessage message) {
		try {
			LocateMail locateMail = new LocateMail();
			locateMail.setSubject(message.getSubject());
			locateMail.setContent(message.getContent().toString());
			System.out.println(locateMail);
		} catch (Exception e) {
			ReflectionUtils.rethrowRuntimeException(e);
		}
	}

}
