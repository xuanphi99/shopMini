package com.trungtamjava.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.trungtamjava.entity.MauSanPham;
import com.trungtamjava.entity.SizeSanPham;
import com.trungtamjava.lmplement.MauSanPhamIpm;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO implements MauSanPhamIpm {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<MauSanPham> getMauSanPhams() {
		Session session = sessionFactory.getCurrentSession();
		String sql = " from mausanpham";
		List<MauSanPham> list = session.createQuery(sql).getResultList();
		return list;
	}

}
