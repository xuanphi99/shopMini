package com.trungtamjava.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "chitiethoadon")
public class ChiTiethoaDon {
	@EmbeddedId
	ChiTietHoaDonId chiTietHoaDonId;
	
	int soLuong ;
	String giaTien ;
	public ChiTietHoaDonId getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}
	public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	
}
