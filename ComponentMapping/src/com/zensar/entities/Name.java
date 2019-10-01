package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Dipankar Chakraborty
 * @creation_date 26 Sep 2019 2:45 PM
 * @modification_date 26 Sep 2019 2:45 PM
 * @version 1.0
 * @copyright Zensar Technologies. All rights reserved.
 */
@Embeddable
public class Name {
	@Column(name = "first", length = 30)
private String firstName;
	@Column(name = "middle", length = 30)
private String middleName;
private String lastName;
public Name() {
	// TODO Auto-generated constructor stub
}
public Name(String firstName, String middleName, String lastName) {
	super();
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getMiddleName() {
	return middleName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
@Override
public String toString() {
	return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
}
}
