package com.travelport.kafka.producer.api.message;

public class Greeting {
	private String message;
	private String name;

	public Greeting() {

	}

	public Greeting(String msg, String name) {
		this.message = msg;
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return message + ", " + name + "!";
	}
}
