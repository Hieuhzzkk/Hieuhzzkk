package com.example.demo.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TruyenTranh {
	@Id
	@Column(name = "truyenid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer truyenId;
	@Column(name = "tentruyen")
	private String tenTruyen;
	@Column
	private Integer gia;
	@Column
	private Integer soLuong;
	@Column(name = "sotap")
	private Integer soTap;
	@Column(name = "theloai")
	private String theLoai;
	
	
	public Integer getTruyenId() {
		return truyenId;
	}
	public void setTruyenId(Integer truyenId) {
		this.truyenId = truyenId;
	}
	public String getTenTruyen() {
		return tenTruyen;
	}
	public void setTenTruyen(String tenTruyen) {
		this.tenTruyen = tenTruyen;
	}
	
	public Integer getGia() {
		return gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	public Integer getSoTap() {
		return soTap;
	}
	public void setSoTap(Integer soTap) {
		this.soTap = soTap;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	
}
