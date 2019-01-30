package com.jbk;
import javax.mail.*;
import javax.mail.internet.*;

import javax.activation.*;

import java.io.IOException;
import java.util.Properties;

public class sendAttachment {

public static void main(String[] args) throws IOException {
	
String to="ashwinirathod12345@gmail.com";
final String user="ashwinirathod12345@gmail.com";
final String password="ashwinirathod@28";

//1) get session object
Properties properties=System.getProperties();


/*
properties.setProperty("mail.smtp.host", "mail.javatpoint.com");
properties.put("mail.smtp.auth", "true");
*/
//Assuming you are sending email from localhost
String host = "localhost";

// Setup mail server
properties.setProperty("mail.smtp.host", host);

Session session=Session.getDefaultInstance(properties, new javax.mail.Authenticator()
		{
        protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(user,password);
	}
		}
	);

//2) compose message
try
{
	MimeMessage message=new MimeMessage(session);
	message.setFrom(new InternetAddress(user));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	message.setSubject("Message Alert");
	
	

//3) create mime body part object and set your message text	
	
	BodyPart messageBodyPart1=new MimeBodyPart();
	
	messageBodyPart1.setText("this is a messgae body");
	
//4 Create new MimeBodyPart object and set data handler object to this object	
	
	MimeBodyPart messageBodyPart2=new MimeBodyPart();
	String filename="sendAttachment.java"; // change accordingly
	
	DataSource source=new FileDataSource(filename);
	source.getOutputStream().close();

	messageBodyPart2.setDataHandler(new DataHandler(source));
	messageBodyPart2.setFileName(filename);
	
//5) create multi part object and add mime body part objects to this object 
	
	MimeMultipart multipart=new MimeMultipart();
	multipart.addBodyPart(messageBodyPart1);
	multipart.addBodyPart(messageBodyPart2);
	
//6) set multi part object to message object to message object 
	message.setContent(multipart);
	
//7) send message 
	Transport.send(message);
	System.out.println("Message Sent");
}
catch(MessagingException ex)
{
	ex.printStackTrace();
	
	}

	
	}



}	
	
	
	

