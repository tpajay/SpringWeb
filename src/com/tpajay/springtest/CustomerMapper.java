package com.tpajay.springtest;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.springhibernatetest.beans.Customer;

public class CustomerMapper implements RowMapper<Customer> {
	
   public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Customer customer = new Customer();
	  customer.setCustomerId(rs.getInt("customerId"));
	  customer.setFirstName(rs.getString("firstName"));
	  customer.setLastName(rs.getString("lastName"));
	  customer.setPhone(rs.getString("phone"));
      return customer;
   }
   
}