package com.dth.main.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dth.main.dao.SubscriptionDetailsDAO;
import com.dth.main.model.Channels;
import com.dth.main.model.Customer;
import com.dth.main.model.SubscriptionsDetails;

@Controller
public class DthController extends AbstractController{
	
	SubscriptionsDetails subscriptionDetails;
	
	@Autowired
	SubscriptionDetailsDAO subscriptionDetailsDAO;
	@RequestMapping("/save")
	@ResponseBody
	public String subscribeCustomer(@RequestParam(name="channels") String channel_name,@RequestParam(name="subscription_id") Long subscriber_id, @RequestParam("date") Date date) {
		// TODO Auto-generated method stub
		
		System.out.println("Subscriber ID : " + subscriber_id +" " + "Channel Name : "+channel_name);
		
		subscriptionDetailsDAO.saveSubscription(subscriber_id , channel_name,date);
		return "Success";
	}
	
	@RequestMapping("/remove")
	public String  unsubscribeCustomer(@RequestParam(name="channels") String channel_name,@RequestParam(name="subscriber_id") Long subscriber_id) {
		// TODO Auto-generated method stub
		subscriptionDetailsDAO.removeSubscription(channel_name, subscriber_id);
		
		return "redirect:/";
	}
	
	@RequestMapping("/getChannels")
	public ModelAndView getChannels() {
		ModelAndView model=new ModelAndView("EditSubscription");
		List<Channels> listOfChannels= subscriptionDetailsDAO.getChannelList();
		System.out.println(listOfChannels);
		model.addObject("lists", listOfChannels);
		return model;
	}
	
	@RequestMapping("/getChannels1")
	public ModelAndView getChannels1() {
		ModelAndView model=new ModelAndView("ChannelSubscription");
		List<Channels> listOfChannels= subscriptionDetailsDAO.getChannelList();
		System.out.println(listOfChannels);
		model.addObject("lists", listOfChannels);
		return model;
	}
	@RequestMapping("/getDetails")
	public ModelAndView getAllDetails(@RequestParam(name = "customerId") Long customerId) {
		ModelAndView model=new ModelAndView("Success");
		List<SubscriptionsDetails> listOfSubscriptions= subscriptionDetailsDAO.getDetails(customerId);
		List<Customer> customers=subscriptionDetailsDAO.getCustomerDetails(customerId);
		Double cost=subscriptionDetailsDAO.getCost(listOfSubscriptions);
		model.addObject("lists", listOfSubscriptions);
		model.addObject("customers",customers);
		model.addObject("cost",cost);
		return model;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/Details")
	public String subscriptionDetail() {
		return ("SubscriptionDetails");
	}
	
}
