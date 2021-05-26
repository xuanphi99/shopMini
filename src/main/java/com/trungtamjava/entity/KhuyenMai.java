package com.trungtamjava.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "khuyenmai")
public class KhuyenMai implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int maKhuyenMai ;
	String tenKhuyenMai ;
	String thoigianbatdau ;
	
	String thoigianketthuc ;
	String mota ;
	String hinhKhuyenMai ;
	float giaGiam;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="maKhuyenMai")
	Set<ChiTietkhuyenMai> chiTietkhuyenMais  ;
	
	
	
	public Set<ChiTietkhuyenMai> getChiTietkhuyenMais() {
		return chiTietkhuyenMais;
	}
	public void setChiTietkhuyenMais(Set<ChiTietkhuyenMai> chiTietkhuyenMais) {
		this.chiTietkhuyenMais = chiTietkhuyenMais;
	}
	public float getGiaGiam() {
		return giaGiam;
	}
	public void setGiaGiam(float giaGiam) {
		this.giaGiam = giaGiam;
	}
	public int getMaKhuyenMai() {
		return maKhuyenMai;
	}
	public void setMaKhuyenMai(int maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public String getThoigianbatdau() {
		return thoigianbatdau;
	}
	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}
	public String getThoigianketthuc() {
		return thoigianketthuc;
	}
	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhKhuyenMai() {
		return hinhKhuyenMai;
	}
	public void setHinhKhuyenMai(String hinhKhuyenMai) {
		this.hinhKhuyenMai = hinhKhuyenMai;
	}
	
}
