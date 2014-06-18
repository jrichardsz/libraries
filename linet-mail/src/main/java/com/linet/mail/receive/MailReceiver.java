package com.linet.mail.receive;

import java.util.*;
import javax.mail.*;
import com.linet.mail.base.*;
import com.sun.mail.pop3.*;

public class MailReceiver  extends MailParameters {

	public Message[] receive() throws Exception{

		Message[] messages = null;
		
		try{
			Properties properties=new Properties();
			properties.put("mail.pop3.host",getReceiveHost());
			Session emailSession=Session.getDefaultInstance(properties);

			POP3Store emailStore=(POP3Store) emailSession.getStore(getMailStoreType());
			emailStore.connect(getFrom(),getPassword());

			Folder emailFolder=emailStore.getFolder(getFolderToRead());
			emailFolder.open(Folder.READ_ONLY);

			messages=emailFolder.getMessages();
	        
			for(int i=0;i < messages.length;i++){
				Message message=messages[i];
				System.out.println("==============================");
				System.out.println("Email #" + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());
			} 

			emailFolder.close(false);
			emailStore.close();
		}
		catch(NoSuchProviderException e){
			throw new Exception("Error when try to receive message",e);	
		}
		catch(MessagingException e){
			throw new Exception("Error when try to receive message",e);	
		}
		
		return messages;

	}

}
