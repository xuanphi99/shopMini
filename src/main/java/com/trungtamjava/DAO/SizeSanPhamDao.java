package com.trungtamjava.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.trungtamjava.entity.SizeSanPham;
import com.trungtamjava.lmplement.SizeSanPhamIpm;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDao implements SizeSanPhamIpm {

	@Autowired
	private SessionFactory se;
	
	@Transactional
	public List<SizeSanPham> getSizeSanPhams() {
		Session session = se.getCurrentSession();
		String sql = " from sizesanpham";
		List<SizeSanPham> list = session.createQuery(sql).getResultList();
		return list;
	}

}
