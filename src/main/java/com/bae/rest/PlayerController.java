package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.PlayerDomain;
import com.bae.service.PlayerService;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {

	private PlayerService memberService;

	@Autowired
	public PlayerController(PlayerService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/getAll")
	public List<PlayerDomain> getAllMembers() {
		return memberService.readMembers();
	}

	@PostMapping("/create")
	public PlayerDomain addNewMember(@RequestBody PlayerDomain member) {
		return memberService.addNewMember(member);
	}

	@PutMapping("/update/{id}")
	public PlayerDomain updateMember(@PathVariable("id") Long id, @RequestBody PlayerDomain member) {
		return memberService.updateMember(member, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserDetails(@PathVariable Long id) {
		this.memberService.deleteMember(id);
	}
	
	
	
	
	
}
