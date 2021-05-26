package com.trungtamjava.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "sanpham")
public class SanPham implements Serializable {
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maSanPham ;
	@OneToOne()
	@JoinColumn(name = "maDanhMuc")
	DanhMucSanPham danhMucSanPham;
	String tenSanPham ; 
	String giaTien ;
	String mota ;
	String hinhSanPham ;
	String gianhcho;
	
	public String getGianhcho() {
		return gianhcho;
	}
	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}
	// @ManyToMany()
//	  @JoinTable(name = "chitietkhuyenmai", 
//	    joinColumns = { @JoinColumn(name = "maSanPham_id") }, 
//	    inverseJoinColumns = {@JoinColumn(name = "maKhuyenMai_id") })
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="maSanPham")
	Set<ChiTietkhuyenMai> chiTietkhuyenMais ;
	
	
	

	public Set<ChiTietkhuyenMai> getChiTietkhuyenMais() {
		return chiTietkhuyenMais;
	}
	public void setChiTietkhuyenMais(Set<ChiTietkhuyenMai> chiTietkhuyenMais) {
		this.chiTietkhuyenMais = chiTietkhuyenMais;
	}
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanPham")
	Set<ChiTietSanPham> li ;
	
	public Set<ChiTietSanPham> getLi() {
		return li;
	}
	public void setLi(Set<ChiTietSanPham> li) {
		this.li = li;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public String getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(String giaTien) {
		this.giaTien = giaTien;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	
}
