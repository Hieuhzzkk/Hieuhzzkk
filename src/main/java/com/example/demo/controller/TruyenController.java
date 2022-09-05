package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.CommonCost;
import com.example.demo.model.entity.TruyenTranh;
import com.example.demo.repository.ITruyenTranhRepository;
import com.example.demo.service.ICartService;
import com.example.demo.service.ITruyenTranhService;


@Controller
@RequestMapping("/truyen")
public class TruyenController {

	@Autowired
	private ITruyenTranhService service;
	@Autowired
	private ITruyenTranhRepository repository;
	@Autowired
	private ICartService cartService;
	
	@GetMapping("/home")
	public String showHomePage(Model model) {
		List<TruyenTranh> tt = service.getAll();
		model.addAttribute("homecart", tt);
		return "home/index";
	}
	@GetMapping("/dssp")
	public String getAll(Model model) {
		List<TruyenTranh> tt = service.getAll();
		model.addAttribute("home", tt);
		return "truyen/dssp";
	}
	@GetMapping("/new")
	public String newTruyen(Model model) {
		model.addAttribute("truyen", new TruyenTranh());
		return "truyen/create";
	}
	
	@PostMapping("/new")
	public String newTruyen(Model model, @ModelAttribute("truyen") TruyenTranh truyenTranh) {
		service.newTruyenTranh(truyenTranh);
		return "redirect:/truyen";	
	}
	
	@GetMapping("/edit/{id}")
	public String getTruyen(Model model, @PathVariable Integer id) {
		TruyenTranh truyenTranh = service.getTruyen(id);
		model.addAttribute("truyen", truyenTranh);
		return "truyen/edit";
	}
	
	@PostMapping("/update")
	public String updateTruyen(Model model, @ModelAttribute("truyen") TruyenTranh truyenTranh) {
		service.updateTruyen(truyenTranh);
		return "redirect:/truyen";
	}
	
	@GetMapping("/delete")
	public String deleteTruyen(Model model, @RequestParam("id") Integer id) {
		service.deleteTruyen(id);
		return "redirect:/truyen";	}
	
	@GetMapping
	public String getAll(Model model, @RequestParam(name = "pageNumber",defaultValue = "0")int pageNumber) {
		Page<TruyenTranh> truyenPage = service.getPage(pageNumber, CommonCost.PAGE_SIZE);
		model.addAttribute("truyen", truyenPage);
		return "truyen/dssp";
	}
	
	@GetMapping("/search")
	public String findTruyen(@RequestParam(name = "name",required = false)String name,
			@RequestParam(name = "theloai",required = false)String theloai, Model model) {
		List<TruyenTranh> list = repository.findAll();
		if (StringUtils.hasText(name)) {
			list = repository.findByTenTruyenLike("%"+name+"%");
		}else if (StringUtils.hasText(theloai)) {
			list = repository.findByTheLoaiLike("%"+theloai+"%");
		}else {
			list = repository.findAll();
		}
		model.addAttribute("truyensearch", list);
		return "truyen/search";
	}
	//nokjoj
}
