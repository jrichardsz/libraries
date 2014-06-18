package com.linet.mail.send;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import com.linet.mail.auth.*;
import com.linet.mail.base.*;

/**
 * 
 * - Richard Osmar Leon Ingaruca - Katerin Vanesa Bernal Punil
 * 
 */
public class MailSender extends MailParameters {

	public boolean send() throws Exception {

		boolean flagIsSucessSend = false;
		
		try {

			setDefaults();
			
			SMTPAuthentication auth = new SMTPAuthentication(getFrom(),getPassword());
			Session session = Session.getInstance(getProps(), auth);
			Message msg = getMessage(session, getFrom(), getTo(), getMessage(), getSubject(), isHtml());
			Transport.send(msg);

			flagIsSucessSend = true;
			
		} catch (Exception e) {
			throw new Exception("Error when try to send message",e);	
		}
		
		return flagIsSucessSend;

	}
	
	protected void setDefaults(){
		if(getProps()!=null){
			getProps().put("mail.smtp.host", getSmtpHost());
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
			msg.setFrom(new InternetAddress(from, getAlias()));
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

}


