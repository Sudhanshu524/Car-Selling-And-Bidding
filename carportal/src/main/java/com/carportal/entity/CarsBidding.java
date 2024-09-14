package com.carportal.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CarBidding")
public class CarsBidding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bidId;
	private String bidPrice;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User userBid;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="car_id")
    private Cars carsBid;
    
	@CreationTimestamp
	private Date datetime;

	public CarsBidding() {
		super();
	}

	public CarsBidding(int bidId, String bidPrice, User userBid, Cars carsBid, Date datetime) {
		super();
		this.bidId = bidId;
		this.bidPrice = bidPrice;
		this.userBid = userBid;
		this.carsBid = carsBid;
		this.datetime = datetime;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public User getUserBid() {
		return userBid;
	}

	public void setUserBid(User userBid) {
		this.userBid = userBid;
	}

	public Cars getCarsBid() {
		return carsBid;
	}

	public void setCarsBid(Cars carsBid) {
		this.carsBid = carsBid;
	}

	@Override
	public String toString() {
		return "CarsBidding [bidId=" + bidId + ", bidPrice=" + bidPrice + ", userBid=" + userBid + ", carsBid="
				+ carsBid + ", datetime=" + datetime + "]";
	}

	

	
    
    
}
