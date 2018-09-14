package com.dth.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="subscription_details")
public class SubscriptionsDetails {
	
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="SUBSCRIPTION_DATE")
	private Date subscriptionDate;
	@EmbeddedId
	private SubscriptionDetailsPK subscriptionDetailsPK;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+this.id+"Subscriber ID "+this.subscriptionDetailsPK.getSubscriberID()+" Channel ID : "+this.subscriptionDetailsPK.getChannelId()+" Date : "+this.subscriptionDate;
	}
	public SubscriptionDetailsPK getSubscriptionDetailsPK() {
		return subscriptionDetailsPK;
	}
	public void setSubscriptionDetailsPK(SubscriptionDetailsPK subscriptionDetailsPK) {
		this.subscriptionDetailsPK = subscriptionDetailsPK;
	}
	
}
