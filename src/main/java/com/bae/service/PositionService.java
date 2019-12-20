package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Position;
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
	public Position addNewPosition(Position position) {
		return positionRepo.save(position);
	}

//Read Position
	public List<Position> getAllPositions() {
		return this.positionRepo.findAll();

	}

// Update Members

	public Position updatePosition( Long id, Position position) {
		Position toUpdate = this.positionRepo.getOne(id);
		toUpdate.setPosition(position.getPosition());
		return null;

	}

// Deleting User
	public void deletePosition(long id) {

		this.positionRepo.deleteById(id);
	}

}
