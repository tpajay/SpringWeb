package com.springhibernatetest.beans;

//import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="CUSTOMERID")
	private int customerId;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIPCODE")
	private String zipcode;
	
	@Column(name="PHONE")
	private String phone;
	
	public Customer() {}
	
	public Customer (Integer id,
			String lastName,
			String firstName,
			String address1,
			String city,
			String state,
			String zipcode,
			String phone) {
				setCustomerId(id);
				setLastName(lastName);
				setFirstName(firstName);
				setAddress1(address1);
				setCity(city);
				setState(state);
				setZipcode(zipcode);
				setPhone(phone);
			}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
		
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
