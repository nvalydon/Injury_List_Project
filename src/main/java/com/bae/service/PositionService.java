package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PositionRepository;

import exceptions.PositionNotFoundException;

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

	public Position findPositionByID(Long id) {

		return this.positionRepo.findById(id).orElseThrow(() -> new PositionNotFoundException());

	}

// Update Members

	public Position updatePosition(Position position, Long id) {
		Position toUpdate = findPositionByID(id);
		toUpdate.setPosition(position.getPosition());
		System.out.println(toUpdate);
		return this.positionRepo.save(toUpdate);

	}

// Deleting User
	public void deletePosition(long id) {

		this.positionRepo.deleteById(id);
	}

}
