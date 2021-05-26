package com.trungtamjava.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.ChiTietHoaDonDAO;
import com.trungtamjava.entity.ChiTiethoaDon;
import com.trungtamjava.lmplement.ChiTietHoaDonImp;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {

	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;
	
	public boolean ThemChiTietHoaDon(ChiTiethoaDon chiTietHoaDon) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
