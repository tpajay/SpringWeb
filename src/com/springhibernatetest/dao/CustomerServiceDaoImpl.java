package com.springhibernatetest.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.springhibernatetest.beans.Customer;

//repository: a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects
//could also be @Component instead
@Repository
@Transactional
public class CustomerServiceDaoImpl implements CustomerServiceDao {
	
	//private static final Logger LOG = Logger.getLogger(ComputeServer.class);
	
	//@Autowired annotation tells Spring where an injection needs to occur
	//@Autowired annotation spares you the need to do the wiring 
	//in the XML file and just finds what needs to be injected and does that for you
	//Good practice: would be to use @Inject instead of @Autowired because it is not Spring-specific
	//Good practice: put the @Inject / @Autowired on a constructor instead of a method
	//               to validate injected bean is not null quickly
	
	//Injecting Hibernate to interact with DB
	@Autowired
	SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public Customer getById(int customerId) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>> CustomerServiceDaoImpl, getById(), customerId: " + customerId);
		
		//https://docs.jboss.org/hibernate/core/4.2/javadocs/org/hibernate/Session.html
		return (Customer)sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}
	 
	@Transactional(readOnly = true)
	public Customer getByName(String customerLastName, String customerFirstName) {
		return (Customer) sessionFactory.getCurrentSession()
		.createQuery("from customer cust " +
		"where cust.firstname = :fname and cust.lastname = :lname")
		.setParameter("lname", customerLastName)
		.setParameter("fname", customerFirstName)
		.uniqueResult();
	}
	
	//@Override
	public List getCustomerList() {
		@SuppressWarnings("unchecked")
		//List customerList = sessionFactory.getCurrentSession().createQuery("from customer").list();
        List<Customer> customerList = (List<Customer>) sessionFactory.getCurrentSession()
                .createCriteria(Customer.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		System.out.println(">>>>>> CustomerServiceDaoImpl, getCustomerList(), customerList size: " + customerList.size());
		return customerList;
	 }	
	 
	//@Transactional(readOnly = true)
	//public Collection<Customer> getAll() {
	//return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	//}
	 
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().merge(customer);
	}
	 
	public void delete(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}
	 
}