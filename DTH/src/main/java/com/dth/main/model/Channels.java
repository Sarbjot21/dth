package com.dth.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="channels")
public class Channels {

	
	@Id
	@Column(name="CHANNEL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ChannelID;
	
	@Column(name="CHANNEL_NAME")
	private String name;
	
	@Column(name="Cost_per_month")
	private Double costPerMonth;
	
	
	public Integer getId() {
		return ChannelID;
	}
	public void setId(Integer id) {
		this.ChannelID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCostPerMonth() {
		return costPerMonth;
	}
	public void setCostPerMonth(Double costPerMonth) {
		this.costPerMonth = costPerMonth;
	}
	
	@Override
	public String toString(){
		return "id="+this.ChannelID+", name="+this.name+", Cost Per Month="+this.costPerMonth;
	}

	
}
