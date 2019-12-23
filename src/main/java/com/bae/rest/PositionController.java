package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Position;
import com.bae.service.PositionService;

@RestController
@RequestMapping("/position")
public class PositionController {
	
	private PositionService positionService;

	public PositionController(PositionService positionService) {
		
		this.positionService = positionService;
	}

	@GetMapping("/position")
	public List<Position> getAllPositions() {
		return positionService.getAllPositions();

	}

	@PostMapping("/position")
	public Position addNewPosition(@RequestBody Position position) {
		System.out.println("asd w");
		return positionService.addNewPosition(position);

	}

	@PutMapping("/position/{id}")
	public Position updatePosition(@RequestBody Position position, @PathVariable Long id) {
		System.out.println(id);
		return this.positionService.updatePosition(position, id);
		
	}
	
	@DeleteMapping("/position/{id}")
	public void deleteUserDetails(@PathVariable Long id) {
		this.positionService.deletePosition(id);
	}
}
