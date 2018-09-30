package com.dth.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
		@Id
		@Column (name="SUBSCRIBER_ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long subscriberID;
		
		@Column( name= "REGISTERED_MOBILE")
		private long mobile;
		@Column(name="FIRST_NAME")
		private String firstName;
		
		@Column(name="LAST_NAME")
		private String lastName;
		
		public long getSubscriberID() {
			return subscriberID;
		}
		public void setSubscriberID(long subscriberID) {
			this.subscriberID = subscriberID;
		}
		public long getMobile() {
			return mobile;
		}
		public void setMobile(long mobile) {
			this.mobile = mobile;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
}
