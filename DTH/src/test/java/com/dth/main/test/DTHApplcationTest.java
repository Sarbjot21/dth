package com.dth.main.test;


import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dth.main.dao.SubscriptionDetailsDAO;
import com.dth.main.dao.SubscriptionDetailsDAOImpl;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:application-dev.properties"})
@SpringBootTest
public class DTHApplcationTest {
	
	@Autowired
	SubscriptionDetailsDAO subscriptionDetailsDao = new SubscriptionDetailsDAOImpl();
	
	@Test
	public void subscribeCustomer() {
		Long subscriberID=1102345676L;
		String channelName="STAR PLUS";
		LocalDate date = LocalDate.now();
		Date date1=Date.valueOf(date);
		System.out.println(date1);
		SimpleDateFormat format=new SimpleDateFormat("mm/dd/yyyy");
		try {
			
			assertEquals("Success",subscriptionDetailsDao.saveSubscription(subscriberID, channelName, date1));		
	
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	

	}
	
	@Test
	public void removeCustomer(){

			assertEquals("Success",subscriptionDetailsDao.removeSubscription("STAR PLUS",1102345676L));
		
		
	}
	
}
