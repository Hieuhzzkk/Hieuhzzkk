package com.example.demo.model.entity;

import java.math.BigDecimal;
//import java.util.Map;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@ManyToOne
	@JoinColumn
	private TruyenTranh truyenTranh;
	
	public TruyenTranh getTruyenTranh() {
		return truyenTranh;
	}
	public void setTruyenTranh(TruyenTranh truyenTranh) {
		this.truyenTranh = truyenTranh;
	}
	private Integer truyenId;
	private String tenTruyen;
	private Integer gia;
	private Integer soLuong = 1;
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
	
	
	
	
//	private Map<Integer, Integer> cartDetails;
//	public Map<Integer, Integer> getCartDetail(){
//		return cartDetails;
//	}
//	public void setCartDetails(Map<Integer, Integer> cartDetails) {
//		this.cartDetails = cartDetails;
//	}
}
