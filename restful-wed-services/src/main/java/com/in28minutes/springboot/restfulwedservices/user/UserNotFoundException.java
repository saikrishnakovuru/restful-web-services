package com.in28minutes.springboot.restfulwedservices.user;

//@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
//    static final long serialVersionUID = 0;
	public UserNotFoundException(String message) {
		super(message);
	}

}
