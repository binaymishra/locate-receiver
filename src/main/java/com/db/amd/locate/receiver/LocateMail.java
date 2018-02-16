package com.db.amd.locate.receiver;

public class LocateMail {
	
	private String subject;
	private String content;
	
	public LocateMail(){
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
