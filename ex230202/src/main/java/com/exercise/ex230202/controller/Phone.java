package com.exercise.ex230202.controller;

public class Phone {

	private String name;
	private String number;
	
	public Phone() {
		super();
	}

	@Override
	public String toString() {
		return name + ", " + number;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
