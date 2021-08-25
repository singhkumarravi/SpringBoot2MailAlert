package com.olive.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.olive.Email.EmailService;
@Component
public class SenderService implements CommandLineRunner{
	
	@Autowired
	private EmailService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hi...");
	      Resource file =new  FileSystemResource("‪C\\Users\\USER\\Desktop\\hsbc-imps-bulk.txt");
      		System.out.println("hellow");
		boolean send = service.send("ravisingh@olivecrypto.com", null ,null, "Sub-Job", "Hellow Sir", file);
		if(send)
			System.out.println("Mail send");
		else
			System.out.println("Mail not send");
	}

}
