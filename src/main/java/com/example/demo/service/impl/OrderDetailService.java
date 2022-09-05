package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.OrderDetail;
import com.example.demo.repository.IOrderDetialIdRepository;
import com.example.demo.service.IOrderDetailService;
@Service
public class OrderDetailService implements IOrderDetailService{
	@Autowired
	private IOrderDetialIdRepository repository;
	@Override
	public List<OrderDetail> listOrderDetails(String name){
		return repository.listByName(name);
	}
	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		return repository.save(orderDetail);
	}
}
