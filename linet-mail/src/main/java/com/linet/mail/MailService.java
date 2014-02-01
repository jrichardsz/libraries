package com.linet.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * - Richard Osmar Leon Ingaruca - Katerin Vanesa Bernal Punil
 * 
 */
public class MailService {

	private String host;
	private String from;
	private String alias;
	private String password;
	private String to;
	private String message;
	private String subject;
	private String vendor;
	private boolean isHtml;
	private Properties props;

	public boolean send() throws Exception {

		boolean flagIsSucessSend = false;
		
		try {

			setDefaults();
			
			SMTPAuthentication auth = new SMTPAuthentication(from,password);
			Session session = Session.getInstance(props, auth);
			Message msg = getMessage(session, from, to, message, subject, isHtml);
			Transport.send(msg);

			flagIsSucessSend = true;
			
		} catch (Exception e) {
			throw new Exception("Error when try to send message",e);	
		}
		
		return flagIsSucessSend;

	}
	
	protected void setDefaults(){
		if(props!=null){
			props.put("mail.smtp.host", host);
		}
	}

	private MimeMessage getMessage(Session session, String from,
			String to, String mensaje, String asunto, boolean isHtml) throws Exception {

		try {
			MimeMultipart multipart = new MimeMultipart();
			MimeMessage msg = new MimeMessage(session);
			msg.setText(mensaje);
			msg.setSubject(asunto);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from, alias));
			msg.setSentDate(new Date());

			// mensaje con formato
			MimeBodyPart mbp = new MimeBodyPart();
			if (isHtml) {
				mbp.setContent(mensaje, "text/html");
			} else {
				mbp.setText(mensaje.toString());
			}

			multipart.addBodyPart(mbp);
			msg.setContent(multipart);

			return msg;

		} catch (java.io.UnsupportedEncodingException e) {
			throw new Exception("Error when prepare message to send.",e);

		} catch (MessagingException e) {
			throw new Exception("Error when prepare message to send.",e);

		}

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	
	
}


