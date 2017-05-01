package com.emusicstore.service;

import com.emusicstore.model.Customer;
import com.emusicstore.model.ProcessOrder;
import com.emusicstore.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerService {

    void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);
    /** add a product on process mode with the customer*/
	void setProcessing(Customer customer, Product product);
    /** get all process order for all customers*/
	Set<ProcessOrder> getAllProcessingOrder();
    /** accept Order of one customer*/
	void acceptOrder(int pOrderId);

    /** get all Order in processs mode of one customer*/
	Set<ProcessOrder> getAllProcessingOrderOneCustomer(String customerName);
}
