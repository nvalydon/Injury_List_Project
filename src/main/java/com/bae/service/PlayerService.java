package com.bae.service;

import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.PlayerDomain;
import com.bae.persistence.repo.PlayerRepository;

import exceptions.MemberNotFoundException;

@Service
public class PlayerService {

	private PlayerRepository playerRepo;

	// Constructor
	@Autowired
	public PlayerService(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

	// Creating Members
	public PlayerDomain addNewMember(PlayerDomain member) {

		return playerRepo.save(member);

	}

	// Read Members
	public List<PlayerDomain> readMembers() {
		return this.playerRepo.findAll();

	}

	public PlayerDomain findMemberByID(Long id) {

		return this.playerRepo.findById(id).orElseThrow(() -> new MemberNotFoundException());
	}

	// Update Members
	public PlayerDomain updateMember( PlayerDomain member, Long id) {
		PlayerDomain toUpdate = findMemberByID(id);
		toUpdate.setFirstName(member.getFirstName());
		toUpdate.setLastName(member.getLastName());
		toUpdate.setAge(member.getAge());
		toUpdate.setTypeOfInjury(member.getTypeOfInjury());
		toUpdate.setLengthOfInjury(member.getLengthOfInjury());
		toUpdate.setTimePeriod(member.getTimePeriod());

		return this.playerRepo.save(toUpdate);

	}

//Deleting User
	public boolean deleteMember(Long id) {

		if (!this.playerRepo.existsById(id)) {
			throw new MemberNotFoundException();
		}

		this.playerRepo.deleteById(id);
		return this.playerRepo.existsById(id);
	}

////Finding 1 User with ID
//
//	public List<MemberDomain> readMember() {
//		return this.memberRepo.findAll();
//	}

}
