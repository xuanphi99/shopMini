package com.trungtamjava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.SanPhamDAO;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.lmplement.SanPhamIlm;

@Service
public class SanPhamService implements SanPhamIlm {
	
	@Autowired 
	SanPhamDAO sanPhamDAO;
	
	
	public List<SanPham> listSanPham(int start) {
		// TODO Auto-generated method stub
		return sanPhamDAO.listSanPham(start);
	}


	public SanPham listChiTietSanPham(int maSanPham) {
		 
		return sanPhamDAO.listChiTietSanPham(maSanPham);
	}


	public boolean xoaSanPhambyId(int maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.xoaSanPhambyId(maSanPham);
	}


	public int ThemSp(SanPham sanPham) {
		
		return sanPhamDAO.ThemSp(sanPham);
	}


	public boolean updateSanPham(SanPham sanPham) {
		
		return sanPhamDAO.updateSanPham(sanPham);
	}

}
