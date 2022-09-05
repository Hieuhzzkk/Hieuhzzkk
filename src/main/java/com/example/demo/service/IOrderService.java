package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Order;
@Service
public interface IOrderService {
	public Order create(Order order);
}
