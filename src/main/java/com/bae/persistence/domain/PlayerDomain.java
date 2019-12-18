package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PlayerDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private int age;
	private String typeOfInjury;
	private int lengthOfInjury;
	private String timePeriod;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id")
	private List<PositionDomain> position;
	

	public PlayerDomain() {
		

	}

	public PlayerDomain(String firstName, String lastName, int age, String typeOfInjury, int lengthOfInjury, String timePeriod) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.typeOfInjury = typeOfInjury;
		this.lengthOfInjury = lengthOfInjury;
		this.timePeriod = timePeriod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTypeOfInjury() {
		return typeOfInjury;
	}

	public void setTypeOfInjury(String typeOfInjury) {
		this.typeOfInjury = typeOfInjury;
	}

	public int getLengthOfInjury() {
		return lengthOfInjury;
	}

	public void setLengthOfInjury(int lengthOfInjury) {
		this.lengthOfInjury = lengthOfInjury;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public List<PositionDomain> getPosition() {
		return position;
	}

	public void setPosition(List<PositionDomain> position) {
		this.position = position;
	}

	
	


}
