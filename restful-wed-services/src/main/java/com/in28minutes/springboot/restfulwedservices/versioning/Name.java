package com.in28minutes.springboot.restfulwedservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Name {
private String firstName;
private String lastName;
//public Name(String firstName, String lastNmae) {
//	super();
//	this.firstName = firstName;
//	this.lastNmae = lastNmae;
//}
//public String getFirstName() {
//	return firstName;
//}
//public void setFirstName(String firstName) {
//	this.firstName = firstName;
//}
//public String getLastNmae() {
//	return lastNmae;
//}
//public void setLastNmae(String lastNmae) {
//	this.lastNmae = lastNmae;
//}
//@Override
//public String toString() {
//	return "Name [firstName=" + firstName + ", lastNmae=" + lastNmae + "]";
//}

}
