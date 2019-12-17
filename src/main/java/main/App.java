package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bae.persistence.domain.PlayerDomain;
import com.bae.persistence.domain.PositionDomain;
import com.bae.persistence.repo.PlayerRepository;
import com.bae.persistence.repo.PositionRepository;

import org.springframework.boot.SpringApplication;

@ComponentScan({ "com.bae.PlayerController", "com.bae.PlayerService" })

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
