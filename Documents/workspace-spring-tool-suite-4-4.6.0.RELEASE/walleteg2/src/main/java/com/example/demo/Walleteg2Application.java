package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Transaction;
import com.example.demo.models.UserD;
import com.example.demo.service.TransactionService;
import com.example.demo.service.UserService;

@SpringBootApplication(scanBasePackages={})
public class Walleteg2Application implements CommandLineRunner {
	@Autowired
	UserService serv1;
	@Autowired
	TransactionService serv2;
	public static void main(String[] args) {
		SpringApplication.run(Walleteg2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//UserD admin=new UserD("admin1","admin","admin","helpcanter@gmail.com",00000,"unknown");
		//serv1.save(admin);
		
		UserD u1=new UserD("6911260","sanjay123","sanjay","sanjay@gmail.com",10111,"8876754209");
		Transaction t1=new Transaction(10111,0.0);
		u1.getTransactions().add(t1);
		t1.setUser(u1);
		serv2.save(t1);
		serv1.save(u1);
		
		/**UserD u1=new UserD("65557265","amrita","amrita123","amrita@gmail.com",11392,"9999898676");
		Transaction t1=new Transaction(11392,0.0);
		u1.getTransactions().add(t1);
		t1.setUser(u1);
		serv2.save(t1);
		serv1.save(u1);**/
		                                                                                                                                                                                                                                                                                   
		/**UserD u1=new UserD("60081115","anya","anya123","anya@gmail.com",11802,"9181354543");
		Transaction t1=new Transaction(11802,0.0);
		u1.getTransactions().add(t1);
		t1.setUser(u1);
		serv2.save(t1);
		serv1.save(u1);**/
		
		/**UserD u1=new UserD("606600915","anujan","anujan123","anujan@gmail.com",12401,"9141754143");
		Transaction t1=new Transaction(12401,0.0);
		u1.getTransactions().add(t1);
		t1.setUser(u1);
		serv2.save(t1);
		serv1.save(u1);**/
		
		
		
	}


}
