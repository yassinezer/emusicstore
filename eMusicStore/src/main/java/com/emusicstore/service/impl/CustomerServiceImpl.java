package com.emusicstore.service.impl;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;
import com.emusicstore.model.ProcessOrder;
import com.emusicstore.model.Product;
import com.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Le on 1/25/2016.
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }

	@Override
	public void setProcessing(Customer customer, Product product, int quantity) {
		customerDao.setProcessing(customer, product, quantity) ;
	}

	@Override
	public Set<ProcessOrder> getAllProcessingOrder() {
		return customerDao.getAllProcessingOrder() ;
		
	}

	@Override
	public void acceptOrder(int pOrderId) {
		 customerDao.acceptOrder(pOrderId);		
	}

	@Override
	public Set<ProcessOrder> getAllProcessingOrderOneCustomer(String customerName) {
		return customerDao.getAllProcessingOrderOneCustomer(customerName);
	}
}
