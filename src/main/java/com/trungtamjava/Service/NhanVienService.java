package com.trungtamjava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.NhanVienDAO;
import com.trungtamjava.entity.NhanVien;
import com.trungtamjava.lmplement.NhanVienImpliment;

@Service
public class NhanVienService implements NhanVienImpliment {
	// khai bao class bên DaO vào IOC
	@Autowired
	private NhanVienDAO nVienDAO;

	public NhanVien XuLyDangNhap(String email, String matkhau) {
	 
	return	nVienDAO.XuLyDangNhap(email,matkhau);
	
		
	}

	public boolean XuLyDangKy(NhanVien nhanVien) {
		
		boolean ktrathem = nVienDAO.XuLyDangKy(nhanVien);

		return ktrathem;
	}

	public void updateNV(NhanVien nhanVien) {
		nVienDAO.updateNV(nhanVien);
		
	}
	
	
	
}
