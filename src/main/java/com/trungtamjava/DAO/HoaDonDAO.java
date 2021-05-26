package com.trungtamjava.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.HoaDon;
import com.trungtamjava.lmplement.HoaDonIpm;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonIpm {

	@Autowired
	private SessionFactory se;
	
	@Transactional
	public int themHD(HoaDon hoaDon) {
		Session session = se.getCurrentSession();
		int id =  (Integer) session.save(hoaDon);
		if(id > 0){
			return id;
		}else{
			return 0;
		}
		
		
		
	}

}
