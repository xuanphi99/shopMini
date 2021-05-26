package com.trungtamjava.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietkhuyenMaiId implements Serializable {
	int maKhuyenMai;
	int maSanPham ;
	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	

	
}
