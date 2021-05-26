package com.trungtamjava.lmplement;

import com.trungtamjava.entity.NhanVien;

public interface NhanVienImpliment {
	NhanVien XuLyDangNhap(String email , String matkhau) ;
	 boolean XuLyDangKy(NhanVien nhanVien) ;
	 void updateNV(NhanVien nhanVien);
}
