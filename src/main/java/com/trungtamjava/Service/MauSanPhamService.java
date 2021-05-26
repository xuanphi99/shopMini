package com.trungtamjava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.MauSanPhamDAO;
import com.trungtamjava.entity.MauSanPham;
import com.trungtamjava.lmplement.MauSanPhamIpm;

@Service
public class MauSanPhamService implements MauSanPhamIpm {
	
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	public List<MauSanPham> getMauSanPhams() {
		return mauSanPhamDAO.getMauSanPhams();
	}

}
