package com.dth.main.dao;

import java.util.Date;
import java.util.List;

import com.dth.main.model.Channels;
import com.dth.main.model.Customer;
import com.dth.main.model.SubscriptionsDetails;


public interface SubscriptionDetailsDAO {

	public void saveSubscription(long subscriber_id, String channel_name,Date date);
	public List<SubscriptionsDetails> getDetails(Long subscriberId);
	public void removeSubscription(String channel_name, Long subscriber_id);
	public List<Customer> getCustomerDetails(Long customerId);
	public List<Channels> getChannelList();
	public Double getCost(List<SubscriptionsDetails> listOfSubscriptions);
		
}
