package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private int age;
	private String position;
	private String typeOfInjury;
	private int lengthOfInjury;
	private String timePeriod;

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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDomain other = (MemberDomain) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lengthOfInjury != other.lengthOfInjury)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (timePeriod == null) {
			if (other.timePeriod != null)
				return false;
		} else if (!timePeriod.equals(other.timePeriod))
			return false;
		if (typeOfInjury == null) {
			if (other.typeOfInjury != null)
				return false;
		} else if (!typeOfInjury.equals(other.typeOfInjury))
			return false;
		return true;
	}

	public MemberDomain(Long id, String firstName, String lastName, int age, String position, String typeOfInjury,
			int lengthOfInjury, String timePeriod) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.position = position;
		this.typeOfInjury = typeOfInjury;
		this.lengthOfInjury = lengthOfInjury;
		this.timePeriod = timePeriod;
	}

}
