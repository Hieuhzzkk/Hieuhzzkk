package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.TruyenTranh;
import com.example.demo.repository.ITruyenTranhRepository;
import com.example.demo.service.ITruyenTranhService;

@Service
public class TruyenTranhService implements ITruyenTranhService{
	@Autowired
	private ITruyenTranhRepository repository;
	
	@Override
	public List<TruyenTranh> getAll(){
		return repository.findAll();
	}
	
	@Override
	public TruyenTranh newTruyenTranh(TruyenTranh truyenTranh) {
		truyenTranh.setTruyenId(null);
		return repository.save(truyenTranh);
	}
	
	@Override
	public TruyenTranh getTruyen(Integer id) {
		Optional<TruyenTranh> optional =repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public TruyenTranh updateTruyen(TruyenTranh truyenTranh) {
		Integer updateId = truyenTranh.getTruyenId();
		boolean isTruyenExisted = repository.existsById(updateId);
		if (isTruyenExisted) {
			repository.save(truyenTranh);
		}
		return null;
	}
	
	@Override
	public Integer deleteTruyen(Integer id) {
		boolean isTruyenExisted = repository.existsById(id);
		if (isTruyenExisted) {
			repository.deleteById(id);
			return id;
		}
		return null;
	}
	
	public Page<TruyenTranh> getPage(int pageNumber, int maxRecord){
		Pageable pageable = PageRequest.of(pageNumber, maxRecord);
		Page<TruyenTranh> page = repository.findAll(pageable);
		return page;
	}
	
	@Override
	public TruyenTranh findTruyenTranhByID(int id) {
		for (TruyenTranh truyenTranh : repository.findAll()) {
			if (truyenTranh.getTruyenId() == id) {
				return truyenTranh;
			}
		}
		return null;
	}
	
}
