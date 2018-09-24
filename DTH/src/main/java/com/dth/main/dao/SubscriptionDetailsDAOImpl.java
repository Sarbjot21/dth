package com.dth.main.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dth.main.model.SubscriptionsDetails;
import com.dth.main.model.Channels;
import com.dth.main.model.Customer;
import com.dth.main.model.SubscriptionDetailsPK;

@Repository

public class SubscriptionDetailsDAOImpl implements SubscriptionDetailsDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveSubscription(long subscriber_id, String channel_name,Date date) {
		// TODO Auto-generated method stub
		List<Channels> channel;
		System.out.println("Subscription Details Saved as :\n");
		String sql="FROM Channels where name=:name";
		
		Session session=sessionFactory.openSession();
		channel=session.createQuery(sql).setParameter("name",channel_name).getResultList();
		System.out.println("Channel : "+channel);
		SubscriptionsDetails subscriptionsDetails=new SubscriptionsDetails();
		
		subscriptionsDetails.setSubscriptionDetailsPK(new SubscriptionDetailsPK(Integer.parseInt(channel.get(0).getId().toString()), subscriber_id));
		subscriptionsDetails.setSubscriptionDate(date);
		System.out.println("Subscriber Id : "+subscriptionsDetails.getSubscriptionDetailsPK().getSubscriberID());
		System.out.println("Channel Id : "+subscriptionsDetails.getSubscriptionDetailsPK().getChannelId());
		System.out.println("Channel name : "+channel.get(0).getName());
		System.out.println("Date : "+subscriptionsDetails.getSubscriptionDate());
		
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(subscriptionsDetails);
		tx.commit();
		
	}

	@Override
	public List<SubscriptionsDetails> getDetails(Long subscriberId) {
		// TODO Auto-generated method stub
		
	/*	String sql="FROM ((SubscriptionsDetails s INNER JOIN Customer ON s.subscriptionDetailsPK.subscriberID = Customer.subscriberID) INNER JOIN Channels ON s.channelId=Channels.ChannelID)";
		
		 
	*/	/*  String sql="Select s.subscriptionDetailsPK.subscriberID, s.subscriptionDetailsPK.channelId,cu.firstName,cu.lastName,ch.name, ch.costPerMonth From SubscriptionsDetails s, Customer cu, Channels ch Where s.subscriptionDetailsPK.subscriberID="+subscriberId;
		*/
		String sql="\r\n" + 
				" Select s.SUBSCRIPTION_ID, s.Channel_id,ch.CHANNEL_NAME, ch.COST_PER_MONTH, cu.FIRST_NAME, cu.LAST_NAME " + 
				" from subscription_details s " + 
				" INNER JOIN Channels ch ON s.channel_id=ch.channel_id " + 
				" INNER JOIN Customer cu ON s.SUBSCRIPTION_ID=cu.SUBSCRIBER_ID AND s.SUBSCRIPTION_ID= :id";
		
		Session session=sessionFactory.openSession();
		
		List<SubscriptionsDetails> list=(List<SubscriptionsDetails>)session.createSQLQuery(sql).setParameter("id", subscriberId).setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP).getResultList();
		Iterator it = list.listIterator();
		while(it.hasNext()) {
			HashMap obj= (HashMap) it.next();
			System.out.println(obj.values());
		}
		return list;
		
	}

	@Override
	public void removeSubscription(String channel_name,Long subscriber_id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		String sql="FROM Channels where name=:name";
		List<Channels> channel = session.createQuery(sql).setParameter("name",channel_name).getResultList();
		
		Query<Channels> query = session.createQuery("delete from SubscriptionsDetails s where s.subscriptionDetailsPK.channelId = :channel and s.subscriptionDetailsPK.subscriberID = :subscriber")
				.setParameter("channel",channel.get(0).getId())
				.setParameter("subscriber", subscriber_id);
		Transaction tx=session.beginTransaction();
		query.executeUpdate();
		tx.commit();
	}

	@Override
	public List<Customer> getCustomerDetails(Long customerId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String sql="FROM Customer where subscriberID=:id";
		List<Customer> customers = session.createQuery(sql).setParameter("id",customerId).getResultList();
		return customers;
	}

	@Override
	public List<Channels> getChannelList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String sql="FROM Channels";
		List<Channels> channels = session.createQuery(sql).getResultList();
		return channels;
	}

	@Override
	public Double getCost(List<SubscriptionsDetails> listOfSubscriptions) {
		// TODO Auto-generated method stub
		Double sum=100.0;
		Iterator it = listOfSubscriptions.listIterator();
		List<Double> array;
		HashMap obj;
		
		while(it.hasNext()) {
			obj= (HashMap) it.next();
			array=new ArrayList<Double>(obj.values());
			sum+=array.get(2);
		}
		/*for(SubscriptionsDetails detail:listOfSubscriptions)
		{
			Session session = sessionFactory.openSession();
			String sql="select costPerMonth FROM Channels where channelId="+detail.getSubscriptionDetailsPK().getChannelId();
			List<Channels> channels = session.createQuery(sql).getResultList();
			sum+=channels.get(0).getCostPerMonth();
			
		}	*/
		return sum;
	}

}
