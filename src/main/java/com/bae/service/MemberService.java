package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.MemberDomain;
import com.bae.persistence.repo.MemberRepository;

@Service
public class MemberService {

	private MemberRepository memberRepo;

	//Constructor
	@Autowired
	public MemberService(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}

	//Creating Members
	public MemberDomain addNewMember(MemberDomain member) {

		return memberRepo.save(member);

	}

	//Read Members
	public List<MemberDomain> getAllMembers() {
		return this.memberRepo.findAll();

	}

	//Update Members
	public MemberDomain updateMember( Long id, MemberDomain member) {
		MemberDomain toUpdate = this.memberRepo.getOne(id);
		toUpdate.setFirstName(member.getFirstName());
		toUpdate.setLastName(member.getLastName());
		toUpdate.setAge(member.getAge());
		toUpdate.setPosition(member.getPosition());
		toUpdate.setTypeOfInjury(member.getTypeOfInjury());
		toUpdate.setLengthOfInjury(member.getLengthOfInjury());
		toUpdate.setTimePeriod(member.getTimePeriod());
		return null;

	}

//Deleting User
	public void deleteMember(long id) {

		this.memberRepo.deleteById(id);
	}

}
