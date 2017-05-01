package com.emusicstore.dao;

import com.emusicstore.model.Customer;
import com.emusicstore.model.ProcessOrder;
import com.emusicstore.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by Le on 1/25/2016.
 */
public interface CustomerDao {

    void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);

    /**insert new product as processing with the specified customer*/
	void setProcessing(Customer customer, Product product);

    /**fetch all processing orders for all customers*/
	Set<ProcessOrder> getAllProcessingOrder();

	/**Change status to true of one processOrder*/
	void acceptOrder(int pOrderId);

	/**fetch data from processOrder given the customer Name*/
	Set<ProcessOrder> getAllProcessingOrderOneCustomer(String customerName);

}
