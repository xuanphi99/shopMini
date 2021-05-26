package com.trungtamjava.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity(name = "hoadon")

public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mahoaDon ;
	String tenKhachHang ;
	String sdt ;
	String diachiGiaoHang ;
	boolean tinhTrang ;
	String NgayLap ;
	String hinhthucGiaoHang;
	String GhiChu;
	// một hd cần 1 list chitiet HD 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="mahoaDon")
	Set<ChiTiethoaDon> danhsachchitiethoadon;
	
	public Set<ChiTiethoaDon> getDanhsachchitiethoadon() {
		return danhsachchitiethoadon;
	}
	public void setDanhsachchitiethoadon(Set<ChiTiethoaDon> danhsachchitiethoadon) {
		this.danhsachchitiethoadon = danhsachchitiethoadon;
	}
	public String getHinhthucGiaoHang() {
		return hinhthucGiaoHang;
	}
	public void setHinhthucGiaoHang(String hinhthucGiaoHang) {
		this.hinhthucGiaoHang = hinhthucGiaoHang;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public int getMahoaDon() {
		return mahoaDon;
	}
	public void setMahoaDon(int mahoaDon) {
		this.mahoaDon = mahoaDon;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachiGiaoHang() {
		return diachiGiaoHang;
	}
	public void setDiachiGiaoHang(String diachiGiaoHang) {
		this.diachiGiaoHang = diachiGiaoHang;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	
}
