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

import com.bae.persistence.domain.MemberDomain;
import com.bae.service.MemberService;

@RestController
@RequestMapping("/injurylistapp")
public class MemberRest {

	private MemberService memberService;

	public MemberRest(MemberService memberService) {
		
		this.memberService = memberService;
	}

	@GetMapping("/getAll")
	public List<MemberDomain> getAllMembers() {

		return memberService.getAllMembers();

	}

	@PostMapping("/create")
	public MemberDomain addNewMember(@RequestBody MemberDomain member) {

		return memberService.addNewMember(member);

	}

	@PutMapping("/update/{id}")
	public MemberDomain updateMember(@PathParam("id") Long id, @RequestBody MemberDomain member) {
		
		return memberService.updateMember(id, member);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserDetails(@PathVariable Long id) {
		this.memberService.deleteMember(id);
	}
	
	
	
	
	
}
