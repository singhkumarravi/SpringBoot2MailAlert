package com.olive.Email;



import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String to, String cc[], String bcc[],String subject,
			String text,Resource file) {
		boolean isSend=false;
		try {
	  MimeMessage message = sender.createMimeMessage();
			
	                  
	         MimeMessageHelper helper =new  MimeMessageHelper(message, file!=null);
	                      helper.setTo(to); 
	                      if(cc!=null)
	                      helper.setCc(cc);
	                      if(bcc!=null)
	                      helper.setBcc(bcc);
	                      helper.setSubject(subject);
	                      helper.setText(text);
	                   if(file!=null) {
	                	   helper.addAttachment(file.getFilename(), file);
	                   }
	                   
	                   sender.send(message);
			           isSend=true;
		} catch (Exception e) {
			isSend=false;
			e.printStackTrace();
		}
		
		
	  return isSend;
	}

	

}
