package com.example.demo.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.model.entity.Cart;
import com.example.demo.service.ICartService;

@Service
@SessionScope
public class CartService implements ICartService{
	Map<Integer, Cart> map = new HashMap<>();
	
	@Override
	public void add(Cart item) {
		Cart cart = map.get(item.getTruyenId());
		if (cart == null) {
			map.put(item.getTruyenId(), item);
		}else {
			cart.setSoLuong(cart.getSoLuong() + 1);
		}
	}
	
	@Override
	public void remove(int id) {
		map.remove(id);
	}
	
	@Override
	public Cart update(int truyenId, int soLuong) {
		Cart cart = map.get(truyenId);
		cart.setSoLuong(soLuong);
		return cart;
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Collection<Cart> getAllItems(){
		return map.values();
	}
	
	@Override
	public int getCount() {
		return map.values().size();
	}
	
	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getSoLuong() * item.getGia()).sum();
	}
}
