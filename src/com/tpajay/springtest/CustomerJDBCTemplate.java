package com.tpajay.springtest;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springhibernatetest.beans.Customer;

public class CustomerJDBCTemplate implements CustomerDAO {
	
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(Integer id, String lastName, String firstName) {
      String SQL = "insert into Customer (customerid, lastname, firstname) values (?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, id, lastName, firstName);
      System.out.println("Created Record Name = " + lastName + ", " + firstName);
      return;
   }

   public Customer getCustomer(Integer id) {
      String SQL = "select * from Customer where customerid = ?";
      Customer customer = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new CustomerMapper());
      return customer;
   }

   public List<Customer> listCustomers() {
      String SQL = "select * from Customer";
      List <Customer> customers = jdbcTemplateObject.query(SQL, 
                                new CustomerMapper());
      return customers;
   }

   public void delete(Integer id){
      String SQL = "delete from Customer where customerid = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, String phone){
      String SQL = "update customer set phone = ? where customerid = ?";
      jdbcTemplateObject.update(SQL, phone, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}
