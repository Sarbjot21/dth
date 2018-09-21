package com.dth.main.test;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.dth.main.dao.SubscriptionDetailsDAO;

public class dthApplicationTest {

	@Autowired
	SubscriptionDetailsDAO subscriptionDetailsDAO;
	public String subscribeCustomer(@RequestParam(name="channels") String channel_name,@RequestParam(name="subscription_id") Long subscriber_id, @RequestParam("date") Date date) {
		// TODO Auto-generated method stub
		
		System.out.println("Subscriber ID : " + subscriber_id +" " + "Channel Name : "+channel_name);
		
		subscriptionDetailsDAO.saveSubscription(subscriber_id , channel_name,date);
		return "Success";
	}
	
	
	
}
