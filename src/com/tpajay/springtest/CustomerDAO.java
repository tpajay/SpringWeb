package com.tpajay.springtest;

import java.util.List;
import javax.sql.DataSource;

import com.springhibernatetest.beans.*;

public interface CustomerDAO {
  
   public void setDataSource(DataSource ds);
   
   public void create(Integer id, String lastName, String firstName);
   
   public Customer getCustomer(Integer id);
  
   public List<Customer> listCustomers();
   
   public void delete(Integer id);
   
   public void update(Integer id, String phone);
}
