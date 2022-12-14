package com.example.stem.martin.phone;

public class Contact {
	private String firstName;
	private String lastName;
	private String number;

	public Contact(String firstName,String lastName, String number) {
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
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + "]";
	}


}
