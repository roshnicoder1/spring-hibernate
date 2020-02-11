package com.ibm.dao;

//public class CustomerDaoImpl {
//
//}

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.model.Customer;



@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	public CustomerDaoImpl(SessionFactory sessionFactory) {
                 this.sessionFactory= sessionFactory;
	}


	public boolean saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return true;
	}

	public boolean deleteCustomer(int custno) {
		 sessionFactory.getCurrentSession().delete(getCustomerByCustno(custno));
		   return true;
	}

	public Customer getCustomerByCustno(int custno) {
		return sessionFactory.getCurrentSession().find(Customer.class, custno);
	}
	public List<Customer> getAllCustomers() {
		CriteriaQuery<Customer> criteriaQuery = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(Customer.class);
		criteriaQuery.from(Customer.class);
		
		return sessionFactory.getCurrentSession().createQuery(criteriaQuery).getResultList();
	}


	public boolean UpdateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		return true;
	}


	

}
