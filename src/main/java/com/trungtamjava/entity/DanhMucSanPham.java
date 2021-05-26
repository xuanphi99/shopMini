package com.trungtamjava.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name ="danhmucsanpham")
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maDanhMuc ;
	String tenDanhMuc ;
	String hinhDanhMuc ;
	
	@OneToMany()
	@JoinColumn(name = "maDanhMuc")
	Set<SanPham> sPhams ;
	
	
	public Set<SanPham> getsPhams() {
		return sPhams;
	}
	public void setsPhams(Set<SanPham> sPhams) {
		this.sPhams = sPhams;
	}
	public int getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}
	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	}
	
}
