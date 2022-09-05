package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.entity.Cart;

public interface ICartService {

	double getAmount();

	int getCount();

	Collection<Cart> getAllItems();

	void clear();

	Cart update(int truyenId, int soLuong);

	void remove(int id);

	void add(Cart item);
}
