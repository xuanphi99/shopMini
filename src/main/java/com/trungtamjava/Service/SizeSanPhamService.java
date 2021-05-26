package com.trungtamjava.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.SizeSanPhamDao;
import com.trungtamjava.entity.SizeSanPham;
import com.trungtamjava.lmplement.SizeSanPhamIpm;

@Service
public class SizeSanPhamService implements SizeSanPhamIpm {

	@Autowired
	SizeSanPhamDao sizeSanPhamDao;
	
	public List<SizeSanPham> getSizeSanPhams() {
		
		return sizeSanPhamDao.getSizeSanPhams();
	}

}
