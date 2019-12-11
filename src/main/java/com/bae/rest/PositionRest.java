package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.aspectj.weaver.Position;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.MemberDomain;
import com.bae.persistence.domain.PositionDomain;
import com.bae.service.MemberService;
import com.bae.service.PositionService;

@RestController
@RequestMapping("/injurylistapp")
public class PositionRest {
	
	private PositionService positionService;

	public PositionRest(PositionService positionService) {
		
		this.positionService = positionService;
	}

	@GetMapping("/getAll")
	public List<PositionDomain> getAllPositions() {

		return positionService.getAllPositions();

	}

	@PostMapping("/create")
	public PositionDomain addNewPosition(@RequestBody PositionDomain position) {

		return positionService.addNewPosition(position);

	}

	@PutMapping("/update/{id}")
	public PositionDomain updatePosition(@PathParam("id") long id,@RequestBody PositionDomain position) {
		
		return PositionService.updatePosition(id, position);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserDetails(@PathVariable Long id) {
		this.positionService.deletePosition(id);
	}
}
