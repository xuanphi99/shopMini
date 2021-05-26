package com.trungtamjava.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietHoaDonId implements Serializable{
	
	int mahoaDon;
	int machiTietSanPham;
	public int getMahoaDon() {
		return mahoaDon;
	}
	public void setMahoaDon(int mahoaDon) {
		this.mahoaDon = mahoaDon;
	}
	public int getMachiTietSanPham() {
		return machiTietSanPham;
	}
	public void setMachiTietSanPham(int machiTietSanPham) {
		this.machiTietSanPham = machiTietSanPham;
	}
	
	
	
}
