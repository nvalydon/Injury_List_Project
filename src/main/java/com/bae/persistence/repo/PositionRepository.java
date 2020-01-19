package com.bae.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
	
	List<Position> findByPosition(String position);

}