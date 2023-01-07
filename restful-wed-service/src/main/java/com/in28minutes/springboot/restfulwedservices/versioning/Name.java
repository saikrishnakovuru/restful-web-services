package com.in28minutes.springboot.restfulwedservices.versioning;

public class Name {
private String firstName;
private String lastNmae;
public Name(String firstName, String lastNmae) {
	super();
	this.firstName = firstName;
	this.lastNmae = lastNmae;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastNmae() {
	return lastNmae;
}
public void setLastNmae(String lastNmae) {
	this.lastNmae = lastNmae;
}
@Override
public String toString() {
	return "Name [firstName=" + firstName + ", lastNmae=" + lastNmae + "]";
}

}
