package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Position;
import com.bae.persistence.repo.PositionRepository;

import exceptions.PositionNotFoundException;

@Service
public class PositionService {

	private PositionRepository positionRepo;


	public PositionService(PositionRepository positionRepo) {
		super();
		this.positionRepo = positionRepo;

	}


	public Position addNewPosition(Position position) {
		return positionRepo.save(position);
	}


	public List<Position> getAllPositions() {
		return this.positionRepo.findAll();

	}

	public Position findPositionByID(Long id) {

		return this.positionRepo.findById(id).orElseThrow(() -> new PositionNotFoundException());

	}



	public Position updatePosition(Position position, Long id) {
		Position toUpdate = findPositionByID(id);
		toUpdate.setPosition(position.getPosition());
		return this.positionRepo.save(toUpdate);

	}


	public boolean deletePosition(Long id) {

		this.positionRepo.deleteById(id);
		return this.positionRepo.existsById(id);
	}

}
