package com.in28minutes.springboot.restfulwedservices.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	public HelloWorldBean() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
