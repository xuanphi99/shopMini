package com.trungtamjava.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.ChiTietHoaDonId;
import com.trungtamjava.entity.ChiTiethoaDon;
import com.trungtamjava.lmplement.ChiTietHoaDonImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp {

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTiethoaDon chiTietHoaDon) {
		Session session = sessionFactory.getCurrentSession();
		ChiTietHoaDonId id = (ChiTietHoaDonId) session.save(chiTietHoaDon);
		if(null != id ){
			return true;
		}else{
			return false;
		}
		
	}
	
	
}
