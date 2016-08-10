package com.tpajay.simpleinterfacetest;

//interface defines the API not the implementation
//Person iterface is defined, not additional developers
//can implement the interface and customize their Person(Jason, Evan, etc) methods
//because the interfaces tells them what methods to code
public class PersonTest {
	
	public static void main(String[] args){
		
		//Polymorphic, stored in Person variable as Evan is a Person
		Jason person1 = new Jason();
		Person person2 = new Evan();
		
		int age = person1.getAge();
		String school = person1.getSchoolName();
		System.out.println(">>>>>> " + age);
		System.out.println(">>>>>> " + school);
		
		age = person2.getAge();
		System.out.println(">>>>>> " + age);
		
	}

}