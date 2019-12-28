package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Player;
import com.bae.persistence.repo.PlayerRepository;

import exceptions.MemberNotFoundException;

@Service
public class PlayerService {

	private PlayerRepository playerRepo;

	
	@Autowired
	public PlayerService(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

	// Creating Members
	public Player addNewMember(Player member) {

		return this.playerRepo.save(member);

	}

	// Read Members
	public List<Player> readMembers() {
		return this.playerRepo.findAll();

	}

	public Player findMemberByID(Long id) {

		return this.playerRepo.findById(id).orElseThrow(
				() -> new MemberNotFoundException());
	}

	// Update Members
	public Player updateMember(Player player, Long id) {
		Player toUpdate = findMemberByID(id);
		toUpdate.setFirstName(player.getFirstName());
		toUpdate.setLastName(player.getLastName());
		toUpdate.setAge(player.getAge());
		toUpdate.setTypeOfInjury(player.getTypeOfInjury());
		toUpdate.setLengthOfInjury(player.getLengthOfInjury());
		toUpdate.setTimePeriod(player.getTimePeriod());
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
