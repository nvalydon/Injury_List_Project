package com.bae.persistence.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.PlayerDomain;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerDomain, Long> {
	

}
