package com.bae.service;

import java.util.List;

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
	public PlayerDomain updateMember( PlayerDomain player, Long id) {
		System.out.println(id);
		PlayerDomain toUpdate = findMemberByID(id);
		System.out.println("2");
		System.out.println(toUpdate);
		toUpdate.setFirstName(player.getFirstName());
		toUpdate.setLastName(player.getLastName());
		toUpdate.setAge(player.getAge());
		toUpdate.setTypeOfInjury(player.getTypeOfInjury());
		toUpdate.setLengthOfInjury(player.getLengthOfInjury());
		toUpdate.setTimePeriod(player.getTimePeriod());
		System.out.println("3");
		System.out.println(toUpdate);
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

}
