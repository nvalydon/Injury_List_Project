package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;
	private int age;
	private String typeOfInjury;
	private int lengthOfInjury;
	private String timePeriod;

	@ManyToMany
	private List<Position> positions;

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Player() {

	}

	public Player(String firstName, String lastName, int age, String typeOfInjury, int lengthOfInjury,
			String timePeriod) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.typeOfInjury = typeOfInjury;
		this.lengthOfInjury = lengthOfInjury;
		this.timePeriod = timePeriod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + lengthOfInjury;
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
		result = prime * result + ((timePeriod == null) ? 0 : timePeriod.hashCode());
		result = prime * result + ((typeOfInjury == null) ? 0 : typeOfInjury.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lengthOfInjury != other.lengthOfInjury)
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", typeOfInjury=" + typeOfInjury + ", lengthOfInjury=" + lengthOfInjury + ", timePeriod=" + timePeriod
				+ "]";
	}



}
