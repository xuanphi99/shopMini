package com.trungtamjava.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.lmplement.DanhMucIpm;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDAO implements DanhMucIpm {
	@Autowired
	private SessionFactory se;
	
	
	@Transactional
	public List<DanhMucSanPham> listDanhMuc() {
		Session session = se.getCurrentSession();
		String sql = "from danhmucsanpham";
		List<DanhMucSanPham> list = session.createQuery(sql).getResultList();
		
		
		return list;
	}
	
	@Transactional
	public List<SanPham> getListCatetogryById(int madanhmuc) {
		Session session = se.getCurrentSession();
		String sql = "from sanpham sp where sp.danhMucSanPham.maDanhMuc = "+madanhmuc ;
		List<SanPham> list =(List<SanPham>)  session.createQuery(sql).getResultList();
		
		
		return list;
	}

}
