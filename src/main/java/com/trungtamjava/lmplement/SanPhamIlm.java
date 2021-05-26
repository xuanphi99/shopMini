package com.trungtamjava.lmplement;

import java.util.List;

import com.trungtamjava.entity.SanPham;

public interface SanPhamIlm {
	// ham lay N sanPham
	List<SanPham> listSanPham( int start);
	SanPham listChiTietSanPham( int maSanPham);
	
	boolean xoaSanPhambyId( int maSanPham);
	int ThemSp( SanPham sanPham);
	
	boolean updateSanPham(SanPham sanPham);
}
