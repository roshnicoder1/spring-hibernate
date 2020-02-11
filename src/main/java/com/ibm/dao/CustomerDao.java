package com.ibm.dao;

import java.util.List;

import com.ibm.model.Customer;

public interface CustomerDao {
	public boolean saveCustomer(Customer customer);
	public boolean deleteCustomer(int custno);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByCustno(int custno);
	public boolean UpdateCustomer(Customer customer);
	
	

}
