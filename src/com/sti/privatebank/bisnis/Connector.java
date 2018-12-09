package com.sti.privatebank.bisnis;

import java.util.List;

import com.sti.privatebank.model.Customer;

public interface Connector {
	List<Customer> getList() throws Exception;
	void insertCustomer(Customer customer) throws Exception;

}
