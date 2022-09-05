package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.OrderDetail;
@Service
public interface IOrderDetailService {
	public List<OrderDetail> listOrderDetails(String name);
	public OrderDetail create(OrderDetail orderDetail);
	
}
