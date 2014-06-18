package com.linet.mail.gmx;

import java.util.Properties;

import org.junit.Test;

import com.linet.mail.send.*;

public class TestMailSend {
	
	@Test
	public void sendSimpleMail() throws Exception {
		
		MailSender mailService = new MailSender();
		mailService.setSmtpHost("mail.gmx.net");
		mailService.setAlias("Emiter");
		mailService.setFrom("sys.dev.0001@gmx.com");
		mailService.setPassword("pass");
		mailService.setTo("sys.dev.0002@gmx.com");
		mailService.setMessage("Test");
		mailService.setSubject("Test");
		mailService.setIsHtml(false);
		
        Properties props = new Properties();        
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        
        mailService.setProps(props);
        
        mailService.send();
	}
	
}
