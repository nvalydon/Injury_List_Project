package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bae.persistence.domain.MemberDomain;
import com.bae.persistence.domain.PositionDomain;
import com.bae.persistence.repo.MemberRepository;
import com.bae.persistence.repo.PositionRepository;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
		ApplicationContext app = SpringApplication.run(App.class, args);
		MemberRepository memRepo = app.getBean(MemberRepository.class);
		PositionRepository posRepo = app.getBean(PositionRepository.class);
		memRepo.save(new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shoulder", 3, "Months"));
		memRepo.save(new MemberDomain("Jonathan", "Tah", 24, "CB", "Broken Ankle", 4, "Months"));
		posRepo.save(new PositionDomain(1L,"GK"));			
		MemberDomain member1 = new MemberDomain("Kieran", "Tierney", 22, "LB", "Dislocated Shouler", 3, "Months");
		System.out.println(member1);
	//	System.out.println(member2);
		
		

	}

}
