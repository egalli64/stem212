package com.example.manuel;

import java.util.Objects;

public class Contatti {
	private String firstName;
	private String lastName;
	private String number;

	public Contatti(String firstName, String lastName, String number) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatti other = (Contatti) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(number, other.number);
	}

	@Override
	public String toString() {
		return "Contatti [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + "]";
	}

}
