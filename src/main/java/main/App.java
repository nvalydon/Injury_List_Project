package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bae.persistence.domain.MemberDomain;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
		MemberDomain member1 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		MemberDomain member2 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		member2.setId(1L);
		System.out.println(member1);
		System.out.println(member2);
		
		

	}

}
