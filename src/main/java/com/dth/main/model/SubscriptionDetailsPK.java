package com.dth.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class SubscriptionDetailsPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1582896115679396868L;
	@Column(name="CHANNEL_ID")
	@NotNull
	private Integer channelId;
	@Column(name="SUBSCRIPTION_ID")
	@NotNull
	private Long subscriberID;
	public SubscriptionDetailsPK() {
		
		
	}

	    public SubscriptionDetailsPK(Integer channelId, Long subscriberID) {
	        this.channelId = channelId;
	        this.subscriberID = subscriberID;
	    }
	    // equals, hashCode
	    
	    @Override
	    public boolean equals(Object arg0) {
	    	// TODO Auto-generated method stub
	    	return this.channelId==((SubscriptionDetailsPK)arg0).channelId && this.subscriberID==((SubscriptionDetailsPK)arg0).subscriberID;
	    }
	    @Override
	    public int hashCode() {
	    	// TODO Auto-generated method stub
	    	return this.channelId.hashCode()+this.subscriberID.hashCode();
	    }

		public Integer getChannelId() {
			return channelId;
		}

		public void setChannelId(Integer channelId) {
			this.channelId = channelId;
		}

		public Long getSubscriberID() {
			return subscriberID;
		}

		public void setSubscriberID(Long subscriberID) {
			this.subscriberID = subscriberID;
		}
	
}
