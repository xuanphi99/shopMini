package com.trungtamjava.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.entity.ChiTietSanPham;
import com.trungtamjava.entity.ChiTiethoaDon;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.lmplement.SanPhamIlm;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamIlm {
	
	@Autowired
	private SessionFactory se;
	
	@Transactional
	public List<SanPham> listSanPham(int start) {
		List<SanPham> list = new ArrayList<SanPham>();
		Session session = se.getCurrentSession();
		if (start<0) {
			
			String sql	= "from sanpham";
			list = (List<SanPham>)session.createQuery(sql).getResultList();
			
		}
		else {
			
			String sql	= "from sanpham";
			list = (List<SanPham>)session.createQuery(sql).setFirstResult(start).setMaxResults(3).getResultList();

		}
		
		
		return list;
	}
	@Transactional
	public SanPham listChiTietSanPham(int maSanPham) {
		
		String sql	= "from sanpham where masanpham="+maSanPham;
		Session session = se.getCurrentSession();
		SanPham list = (SanPham)session.createQuery(sql).getSingleResult();
		
		//	System.out.println("masp :"+ list.getMaSanPham());
			
//			System.out.println("hinh "+list.getHinhSanPham());
//			for (ChiTietSanPham chitiet : list.getLi()) {
//				System.out.println(" ma mau "+ chitiet.getMauSanPham().getMamau());
//			}
		
		
		
		return list;
	}
	@Transactional
	public boolean xoaSanPhambyId(int maSanPham) {
		Session session =se.getCurrentSession();
		SanPham sanPham =session.get(SanPham.class, maSanPham);

		Set<ChiTietSanPham> chiTietSanPhams = sanPham.getLi();
		for (ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
			String sql = "delete chitiethoadon WHERE machitietsanpham = :id_masp ";
			Query query = session.createQuery(sql);
			query.setParameter("id_masp", chiTietSanPham.getMachiTietSanPham()).executeUpdate();
		//	System.out.println("delete ="+chiTietSanPham.getMachiTietSanPham());
		//	session.createQuery("delete chitiethoadon WHERE machitietsanpham="+chiTietSanPham.getMachiTietSanPham()).executeUpdate();	
			
		} 
//		
	//	session.delete(sanPham); do sd @EmbeddedId mặc định có caseCash
		session.createQuery("delete chitietkhuyenmai WHERE maKhuyenMai="+maSanPham).executeUpdate();
		session.createQuery("delete chitietsanpham WHERE maSanPham="+maSanPham).executeUpdate();
		session.createQuery("delete sanpham WHERE maSanPham="+maSanPham).executeUpdate();
		
	
		return false;
	}
	@Transactional
	public int ThemSp(SanPham sanPham) {
		Session session =se.getCurrentSession();
		int masp = (Integer) session.save(sanPham);
		System.out.println("gigig" + masp);
		return masp;
	}
	@Transactional
	public boolean updateSanPham(SanPham sanPham) {
		Session session =se.getCurrentSession();
		 session.update(sanPham);
		
		return false;
	}

}
