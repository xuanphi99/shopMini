package com.trungtamjava.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity(name ="chitietsanpham")

public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int machiTietSanPham ;
	
	@OneToOne()
	@JoinColumn(name = "maSanPham")
	SanPham sanPham;
	
	@OneToOne()
	@JoinColumn(name = "maSize")
	SizeSanPham sizeSanPham; 
	
	@OneToOne()
	@JoinColumn(name = "maMau")
	MauSanPham mauSanPham;
	
	
	int soluong ;
	String ngaynhap ;
	public int getMachiTietSanPham() {
		return machiTietSanPham;
	}
	public void setMachiTietSanPham(int machiTietSanPham) {
		this.machiTietSanPham = machiTietSanPham;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public SizeSanPham getSizeSanPham() {
		return sizeSanPham;
	}
	public void setSizeSanPham(SizeSanPham sizeSanPham) {
		this.sizeSanPham = sizeSanPham;
	}
	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}
	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	
	
	
	
}
