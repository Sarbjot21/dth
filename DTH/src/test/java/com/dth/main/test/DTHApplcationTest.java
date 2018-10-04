package com.dth.main.test;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;

import com.dth.main.dao.SubscriptionDetailsDAO;
import com.dth.main.dao.SubscriptionDetailsDAOImpl;

@RunWith(SpringRunner.class)
@TestPropertySource(value = { "classpath:application-test.properties" })
@SpringBootTest
public class DTHApplcationTest {
	
	@Autowired
	SubscriptionDetailsDAO subscriptionDetailsDao = new SubscriptionDetailsDAOImpl();
	
	@Test
	public void subscribeCorrectCustomer() {
		Long subscriberID=1102345676L;
		String channelName="STAR PLUS";
		LocalDate date = LocalDate.now();
		Date date1=Date.valueOf(date);
		System.out.println(date1);
		try {
			
			assertEquals("Success",subscriptionDetailsDao.saveSubscription(subscriberID, channelName, date1));		
	
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void removeExistingChannelFromCustomer(){
			Integer rows=1;
			assertEquals( rows ,subscriptionDetailsDao.removeSubscription("STAR PLUS",1102345676L));
		
		
	}
	
	@Test
	public void removeNonExistingChannelFromCustomer(){
			
			assertEquals((Integer) 0 , (Integer) subscriptionDetailsDao.removeSubscription("TIMES NOW",1102345676L));
		
		
	}
	
	@Test
	public void subscribeIncorrectCustomer() {
		Long subscriberID=110234567622L;
		String channelName="STAR PLUS";
		LocalDate date = LocalDate.now();
		Date date1=Date.valueOf(date);
		System.out.println(date1);
		try {
			
			subscriptionDetailsDao.saveSubscription(subscriberID, channelName, date1);	
						
		}catch(Exception e) {
			assertEquals(DataIntegrityViolationException.class, e.getClass());
		}
	}
	
	
}
