package com.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class SendMailAPI {
	
	static Logger app=Logger.getLogger("app");
	
	static String host="smtp.gmail.com";
	static String from=null;
	static String password=null;
	static String port="587";
	static String authFlag="true";
	static String starttls="true";
	
	SendMailAPI(){

		from="daryabusiness@gmail.com";
		password="arya$786";
		
	}
	SendMailAPI(String host1,String from1,String password1,String port1){
		host=host1;
		from=from1;
		password=password1;
		port=port1;
	}
	
	SendMailAPI(String username,String password1){
		host=username;
		password=password1;
	}
	
	
	public Session getSession() {
		app.info("Mail getSession method start");
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host",host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", authFlag);
		prop.put("mail.smtp.starttls.enable", starttls);
		Authenticator auth=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,password);
			}
		};
		Session session=Session.getInstance(prop,auth);
		app.info("Mail getSession method end");
		
		return session;
	}
	
	//FilePathwithName    containe file path;FileName
	public Boolean sendmail(List<String> to,List<String> cc,String text,String html,List<String> filePathwithName) throws AddressException, MessagingException, URISyntaxException, IOException {
		app.info("Send mail started...");

		Boolean responseFlag=false;
		
		
		Session session=getSession();
		MimeMessage msg=getMimeMessage(session,to,cc);
		msg.setSubject("Text");
		Multipart multipart=new MimeMultipart();
		if(text!=null && !text.trim().equals("")) {
			multipart.addBodyPart(this.attachText(text));
		}
		if(html!=null && !html.trim().equals("")) {
			multipart.addBodyPart(this.attachHTML(html));
		}
		
		if(filePathwithName!=null ) {
			for(String file:filePathwithName) {
				if(file.split(";").length>1) {
					String filePath=file.split(";")[0];
					String name=file.split(";")[1];
					multipart.addBodyPart(this.attachFile(filePath, name));
					
				}else {
					app.error("Invalid filepathwithName "+file);
				}
			}
		}
		
		
		
		msg.setContent(multipart);
		Transport.send(msg);
		responseFlag=true;
		
		app.info("Send mail started...");
		return responseFlag;
	}
	
	public MimeMessage getMimeMessage(Session session,List<String> to, List<String> cc) throws MessagingException {
		app.info("getMimeMessage start with TO "+Common.listToString(to)+" CC "+Common.listToString(cc) );
		MimeMessage msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, this.converStringListToInternetAddressArray(to));
		msg.setRecipients(Message.RecipientType.CC, this.converStringListToInternetAddressArray(cc));
		app.info("getMimeMessage end with TO "+Common.listToString(to)+" CC "+Common.listToString(cc));
		return msg;
		
	}
	
	public BodyPart attachFile(String filepath,String filename) throws MessagingException {
		
		DataSource datasour=new FileDataSource(filepath);
		BodyPart bodypart=new MimeBodyPart();
		bodypart.setFileName(filename);
		bodypart.setDataHandler(new DataHandler(datasour));
		
		return bodypart;
	}
	public BodyPart attachText(String txt) throws MessagingException {
		BodyPart bodypart=new MimeBodyPart();
		bodypart.setText(txt);
		return bodypart;
	}
	
	public BodyPart attachHTML(String html) throws MessagingException {
		BodyPart bodypart=new MimeBodyPart();
		bodypart.setContent(html, "text/html");
		return bodypart;
	}

	public InternetAddress[] converStringListToInternetAddressArray(List<String> ls) throws AddressException {
		InternetAddress[] arr=new InternetAddress[ls.size()];
		for(int i=0;i<ls.size();i++) {
			arr[i]=new InternetAddress(ls.get(i));
		}
		return arr;
	}
	
}
