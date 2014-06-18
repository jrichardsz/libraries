package com.linet.mail.gmx;

import java.util.*;

import javax.mail.*;

import org.junit.*;

import com.linet.mail.receive.*;

public class TestMailReceive {
	
	@Test
	public void sendSimpleMail() throws Exception {
		
		MailReceiver mailService = new MailReceiver();
		mailService.setReceiveHost("pop.gmx.net");
		mailService.setFrom("sys.dev.0001@gmx.com");
		mailService.setPassword("pass");
		mailService.setFolderToRead("INBOX");
		mailService.setMailStoreType("pop3");
		
        Properties props = new Properties();        
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        
        mailService.setProps(props);
        
        Message[] messages = mailService.receive();
        
		for(int i=0;i < messages.length;i++){
			Message message=messages[i];
			System.out.println("==============================");
			System.out.println("Email #" + (i + 1));
			System.out.println("Subject: " + message.getSubject());
			System.out.println("From: " + message.getFrom()[0]);
			System.out.println("Text: " + message.getContent().toString());
		}        
	}
	
}
