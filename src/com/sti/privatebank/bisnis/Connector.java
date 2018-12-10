package com.sti.privatebank.bisnis;

import java.util.List;

import com.sti.privatebank.model.Customer;

public interface Connector {
	List<Customer> getList() throws Exception;
	void insertCustomer(Customer insertCustomer) throws Exception;
	String updateCustomer(Customer updateCustomer) throws Exception;
	String deleteCust(Customer cust);
	List<Customer> getSearch(Customer searchCustomer) throws Exception;
}
