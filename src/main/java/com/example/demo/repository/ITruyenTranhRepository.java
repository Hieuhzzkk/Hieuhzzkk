package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.TruyenTranh;

public interface ITruyenTranhRepository extends JpaRepository<TruyenTranh, Integer>{
	List<TruyenTranh> findByTenTruyenLike(String tenTruyen);
	List<TruyenTranh> findByTheLoaiLike(String theLoai);
}
