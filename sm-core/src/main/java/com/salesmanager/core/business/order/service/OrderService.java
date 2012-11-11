package com.salesmanager.core.business.order.service;

import java.util.List;

import com.salesmanager.core.business.customer.model.Customer;
import com.salesmanager.core.business.generic.service.SalesManagerEntityService;
import com.salesmanager.core.business.merchant.model.MerchantStore;
import com.salesmanager.core.business.order.model.Order;

public interface OrderService extends SalesManagerEntityService<Long, Order> {
	
	Order getOrder(Long id);
	
	public List<Order> getMerchantOrders(MerchantStore merchantStore);
	
	public List<Order> getCustomerOrders(Customer customer);
}
