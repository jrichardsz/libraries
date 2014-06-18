package com.linet.mail.auth;

import javax.mail.PasswordAuthentication;

public class SMTPAuthentication extends javax.mail.Authenticator {

	protected String username;
	protected String password;

	public SMTPAuthentication(String username, String password) {
		this.username = username;
		this.password = password;

	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
