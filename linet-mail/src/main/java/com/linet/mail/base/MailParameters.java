package com.linet.mail.base;

import java.util.*;

public class MailParameters{

	private String smtpHost;
	private String receiveHost;
	private String mailStoreType;
	private String from;
	private String alias;
	private String password;
	private String to;
	private String message;
	private String subject;
	private String vendor;
	private String folderToRead;
	private boolean isHtml;
	
	private Properties props;
	
	public String getSmtpHost(){
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost){
		this.smtpHost=smtpHost;
	}
	public String getFrom(){
		return from;
	}
	public void setFrom(String from){
		this.from=from;
	}
	public String getAlias(){
		return alias;
	}
	public void setAlias(String alias){
		this.alias=alias;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getTo(){
		return to;
	}
	public void setTo(String to){
		this.to=to;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public String getSubject(){
		return subject;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public String getVendor(){
		return vendor;
	}
	public void setVendor(String vendor){
		this.vendor=vendor;
	}
	public boolean isHtml(){
		return isHtml;
	}
	public void setIsHtml(boolean isHtml){
		this.isHtml=isHtml;
	}
	public Properties getProps(){
		return props;
	}
	public void setProps(Properties props){
		this.props=props;
	}
	public String getMailStoreType(){
		return mailStoreType;
	}
	public void setMailStoreType(String mailStoreType){
		this.mailStoreType=mailStoreType;
	}
	public String getFolderToRead(){
		return folderToRead;
	}
	public void setFolderToRead(String folderToRead){
		this.folderToRead=folderToRead;
	}
	public String getReceiveHost(){
		return receiveHost;
	}
	public void setReceiveHost(String receiveHost){
		this.receiveHost=receiveHost;
	}
	
}
