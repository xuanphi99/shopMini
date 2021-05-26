package com.trungtamjava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.DanhMucSanPhamDAO;
import com.trungtamjava.DAO.SanPhamDAO;
import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.lmplement.DanhMucIpm;

@Service
public class DanhMucSanPhamService implements DanhMucIpm {
	@Autowired 
	DanhMucSanPhamDAO danhMucSanPhamDAO;
	public List<DanhMucSanPham> listDanhMuc() {
		return danhMucSanPhamDAO.listDanhMuc();
		
	}
	public List<SanPham> getListCatetogryById(int madanhmuc) {
		
		return danhMucSanPhamDAO.getListCatetogryById(madanhmuc);
	}
	
}
