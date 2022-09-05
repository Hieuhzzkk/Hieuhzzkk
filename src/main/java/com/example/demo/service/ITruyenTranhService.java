package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.entity.TruyenTranh;

public interface ITruyenTranhService {
	List<TruyenTranh> getAll();
	TruyenTranh newTruyenTranh(TruyenTranh truyenTranh);
	TruyenTranh getTruyen(Integer id);
	TruyenTranh updateTruyen(TruyenTranh truyenTranh);
	Integer deleteTruyen(Integer id);
	Page<TruyenTranh> getPage(int pageNumber, int maxRecord);
	public TruyenTranh findTruyenTranhByID(int id);
	
}
