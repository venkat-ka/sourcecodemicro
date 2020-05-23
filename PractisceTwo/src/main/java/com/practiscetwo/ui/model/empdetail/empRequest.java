package com.practiscetwo.ui.model.empdetail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class empRequest {

@NotNull(message="FirstName should not be empty")
private String firstName;

private String lastName;
@NotNull
@Size(max=16, min=8, message = "Password should be within 8 to 16 Charachter" )
private String password;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
