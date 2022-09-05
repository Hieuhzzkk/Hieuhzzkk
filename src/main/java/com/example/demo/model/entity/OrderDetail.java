package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{
	@Id
	private OrderDetailId id;
	@ManyToOne
	@JoinColumn(name = "oderId", insertable = false, updatable = false)
	private Order order;
	@ManyToOne
	@JoinColumn(name = "truyentranhId", insertable = false, updatable = false)
	private TruyenTranh truyentranh;
	@Column
	private Integer gia;
	@Column
	private Integer soLuong;
	
	public OrderDetail() {
		super();
	}

	

	public OrderDetail(OrderDetailId id, Order order, TruyenTranh truyentranh, Integer gia, Integer soLuong) {
		super();
		this.id = id;
		this.order = order;
		this.truyentranh = truyentranh;
		this.gia = gia;
		this.soLuong = soLuong;
	}



	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public TruyenTranh getTruyentranh() {
		return truyentranh;
	}

	public void setTruyentranh(TruyenTranh truyentranh) {
		this.truyentranh = truyentranh;
	}

	public Integer getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	
	
	
}
