package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Order;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.service.IOrderService;
@Service
public class OrderService implements IOrderService{
	@Autowired
	private IOrderRepository repository;
	@Override
	public Order create(Order order) {
		return repository.save(order);
	}
}
