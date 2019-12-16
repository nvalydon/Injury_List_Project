package com.bae.service;

import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.MemberDomain;
import com.bae.persistence.repo.MemberRepository;

import exceptions.MemberNotFoundException;

@Service
public class MemberService {

	private MemberRepository memberRepo;

	// Constructor
	@Autowired
	public MemberService(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}

	// Creating Members
	public MemberDomain addNewMember(MemberDomain member) {

		return memberRepo.save(member);

	}

	// Read Members
	public List<MemberDomain> readMembers() {
		return this.memberRepo.findAll();

	}

	public MemberDomain findMemberByID(Long id) {

		return this.memberRepo.findById(id).orElseThrow(() -> new MemberNotFoundException());
	}

	// Update Members
	public MemberDomain updateMember(MemberDomain member, Long id) {
		MemberDomain toUpdate = findMemberByID(id);
		toUpdate.setFirstName(member.getFirstName());
		toUpdate.setLastName(member.getLastName());
		toUpdate.setAge(member.getAge());
		toUpdate.setPosition(member.getPosition());
		toUpdate.setTypeOfInjury(member.getTypeOfInjury());
		toUpdate.setLengthOfInjury(member.getLengthOfInjury());
		toUpdate.setTimePeriod(member.getTimePeriod());
		
		return this.memberRepo.save(toUpdate);

	}

//Deleting User
	public boolean deleteMember(Long id) {

		if (!this.memberRepo.existsById(id)) {
			throw new MemberNotFoundException();
		}

		this.memberRepo.deleteById(id);
		return this.memberRepo.existsById(id);
	}

//Finding 1 User with ID

	public List<MemberDomain> readMember() {
		return this.memberRepo.findAll();
	}

}
