package com.tpajay.simpleinterfacetest;

public class Jason implements Person, School {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		String hello = "Hey! My name is Jason.";
		return hello;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		int age = 13;
		return age;
	}

	@Override
	public String getSchoolName() {
		// TODO Auto-generated method stub
		String schoolname = "Barrington";
		return schoolname;
	}

}
