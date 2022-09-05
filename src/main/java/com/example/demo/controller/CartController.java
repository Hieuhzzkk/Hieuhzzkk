package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.CommonCost;
import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.TruyenTranh;
import com.example.demo.repository.ITruyenTranhRepository;
import com.example.demo.service.ICartService;
import com.example.demo.service.ITruyenTranhService;

@Controller
@RequestMapping("/shop")
public class CartController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private ITruyenTranhRepository repository;
	@Autowired
	private ITruyenTranhService service;
	
	@GetMapping("/cart")
	public String viewCart(Model model) {
		model.addAttribute("cart", cartService.getAllItems());
		model.addAttribute("TOTAL", cartService.getAmount());
		return "truyen/cart";
	}
	
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		TruyenTranh truyenTranh = service.findTruyenTranhByID(id);
		if (truyenTranh != null) {
			Cart cart = new Cart();
			cart.setTruyenId(truyenTranh.getTruyenId());
			cart.setTenTruyen(truyenTranh.getTenTruyen());
			cart.setSoLuong(1);
			cart.setGia(truyenTranh.getGia());
			cartService.add(cart);
		}
		return "redirect:/shop/cart";
	}
	
	@GetMapping("/clear")
	public String clearCart() {
		cartService.clear();
		return "redirect:/shop/cart";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCart(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/shop/cart";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("id") Integer id, @RequestParam("soLuong") Integer soLuong) {
		cartService.update(id, soLuong);
		return "redirect:/shop/cart";
	}
}
