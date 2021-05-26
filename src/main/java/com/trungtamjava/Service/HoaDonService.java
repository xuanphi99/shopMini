package com.trungtamjava.Service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.DAO.HoaDonDAO;
import com.trungtamjava.entity.HoaDon;
import com.trungtamjava.lmplement.HoaDonIpm;

@Service
public class HoaDonService implements HoaDonIpm {

	@Autowired
	private HoaDonDAO hoaDonDAO;
	
 public int themHD(HoaDon hoaDon) {
		
		return hoaDonDAO.themHD(hoaDon);
	}

}
