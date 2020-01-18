	package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Player;
import com.bae.service.PlayerService;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {
	
	private PlayerService playerService;

	@Autowired
	public PlayerController(PlayerService playerService) {
		super();
		this.playerService = playerService;
	}

	@GetMapping("/getAll")
	public List<Player> getAllMembers() {
		return playerService.readMembers();
	}

	@PostMapping("/create")
	public Player addNewMember(@RequestBody Player member) {
		return playerService.addNewMember(member);
	}

	@PutMapping("/update/{id}")
	public Player updateMember(@PathVariable("id") Long id, @RequestBody Player member) {
		return playerService.updateMember(member, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserDetails(@PathVariable Long id) {
		this.playerService.deleteMember(id);
	}
	
	@GetMapping("/get/{id}")
	public Player getPlayer(@PathVariable Long id) {
		
		return this.playerService.findMemberByID(id);
		
	}
	
	
	
}
