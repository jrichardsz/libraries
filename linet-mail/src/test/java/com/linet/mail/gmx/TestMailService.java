package com.linet.mail.gmx;

import java.util.Properties;

import org.junit.Test;

import com.linet.mail.MailService;

public class TestMailService {
	
	@Test
	public void sendSimpleMail() throws Exception {
		
		MailService mailService = new MailService();
		mailService.setHost("mail.gmx.net");
		mailService.setAlias("Emiter");
		mailService.setFrom("sys.dev.0001@gmx.com");
		mailService.setPassword("sys.pass.0001");
		mailService.setTo("sys.dev.0002@gmx.com");
		mailService.setMessage("Test");
		mailService.setSubject("Test");
		mailService.setHtml(false);
		
        Properties props = new Properties();        
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        
        mailService.setProps(props);
        
        mailService.send();
	}
	
}
