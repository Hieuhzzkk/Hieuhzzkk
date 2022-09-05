package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable{
	private Integer truyentranhId;
	private Integer orderId;
	
	public OrderDetailId() {
		super();
	}

	public OrderDetailId(Integer truyentranhId, Integer orderId) {
		super();
		this.truyentranhId = truyentranhId;
		this.orderId = orderId;
	}

	public OrderDetailId(Integer truyenId, Long newOrderId) {
		super();
	}

	public Integer getTruyentranhId() {
		return truyentranhId;
	}

	public void setTruyentranhId(Integer truyentranhId) {
		this.truyentranhId = truyentranhId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	
	
}
