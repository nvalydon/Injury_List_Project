package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.PositionDomain;
import com.bae.persistence.repo.PositionRepository;

@Service
public class PositionService {

	private PositionRepository positionRepo;

//Constructor
	public PositionService(PositionRepository positionRepo) {
		super();
		this.positionRepo = positionRepo;

	}

//Create Position
	public PositionDomain addNewPosition(PositionDomain position) {
		return positionRepo.save(position);
	}

//Read Position
	public List<PositionDomain> getAllPositions() {
		return this.positionRepo.findAll();

	}

// Update Members

	public PositionDomain updatePosition( Long id, PositionDomain position) {
		PositionDomain toUpdate = this.positionRepo.getOne(id);
		toUpdate.setPosition(position.getPosition());
		return null;

	}

// Deleting User
	public void deletePosition(long id) {

		this.positionRepo.deleteById(id);
	}

}
