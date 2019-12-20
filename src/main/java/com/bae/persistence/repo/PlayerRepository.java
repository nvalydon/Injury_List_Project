package com.bae.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	List<Player> findByTypeOfInjury(String typeOfInjury);
	
	
	
	
	
}
