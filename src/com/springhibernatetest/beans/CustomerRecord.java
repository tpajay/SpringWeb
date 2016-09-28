package com.springhibernatetest.beans;

//import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_RECORDS")
public class CustomerRecord {
	
	@Id
	@GeneratedValue
	@Column(name="RECID")
	private int recId;
	
	@Column(name="CUSTID")
	private String custId;
	
	@Column(name="RECTYPE")
	private String recType;
	
	@Column(name="RECDESC")
	private String recDesc;
	
	@ManyToOne
	@JoinColumn(name = "custid")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public String getRecDesc() {
		return recDesc;
	}

	public void setRecDesc(String recDesc) {
		this.recDesc = recDesc;
	}
	
}
