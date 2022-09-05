package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.OrderDetail;
import com.example.demo.model.entity.OrderDetailId;
import com.example.demo.model.entity.TruyenTranh;
import com.example.demo.service.ICartService;
import com.example.demo.service.impl.CartService;
import com.example.demo.service.impl.OrderDetailService;
import com.example.demo.service.impl.OrderService;
import com.example.demo.service.impl.TruyenTranhService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private HttpSession session;
	@Autowired
	private TruyenTranhService truyenTranhService;
	@Autowired
	private CartService cartService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ICartService iCartService;
	@Autowired
	private OrderDetailService orderDetailService;
	@GetMapping
	public String Oder(ModelMap modelMap,Model model) {
		String name = ((TruyenTranh) request.getSession().getAttribute("truyen")).getTenTruyen();
		List<OrderDetail> listOrderDetail = orderDetailService.listOrderDetails(name);
		modelMap.addAttribute("order", listOrderDetail);
		return "truyen/order";
	}
	@GetMapping("/checkout")
	public String checkOut() {
		//Integer truyenId = ((TruyenTranh) request.getSession().getAttribute("truyen")).getTruyenId();
		//String tenTruyen = ((TruyenTranh) request.getSession().getAttribute("truyen")).getTenTruyen();
		
		Order order = new Order();
		order.setName("New Order");
		order.setStatus(false);
		order.setCustomerName("Truyen");
		Long newOrderId = orderService.create(order).getId();
		cartService.getAllItems();
		for (Cart x : cartService.getAllItems()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setId(new OrderDetailId(x.getTruyenTranh().getTruyenId(),newOrderId));
			orderDetail.setGia(x.getTruyenTranh().getGia());
			orderDetail.setSoLuong(x.getSoLuong());
			TruyenTranh purchased = truyenTranhService.findTruyenTranhByID(x.getTruyenTranh().getTruyenId());
			orderDetailService.create(orderDetail);
			purchased.setSoLuong(purchased.getSoLuong()- x.getSoLuong());
			iCartService.clear();
		}
		return "redirect:/shop/cart";
	}
}
