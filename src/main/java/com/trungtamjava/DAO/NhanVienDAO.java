package com.trungtamjava.DAO;

import java.io.Serializable;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.entity.NhanVien;
import com.trungtamjava.lmplement.NhanVienImpliment;
	
	
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienImpliment{
	
	@Autowired
	private SessionFactory se;
	
	
	@Transactional
	 public NhanVien XuLyDangNhap( String email , String matkhau) {
		  // xu ly lay csdl them transtional
		    // sd sessionFactory 
		    // sd AutoWire
		    	Session session = se.getCurrentSession();
//		    	
		    	
					
			
		    	if (matkhau.equals("*")) {

		    		NhanVien nv = null;
		    		try {
		    			
			    		String sql = "from nhanvien Where email= ?   ";	
			    		 nv = (NhanVien) session.createQuery(sql).setParameter(0,email).getSingleResult();	
					// bat error
		    		} catch (NoResultException e) {
						return null;
					}
		    		
		    		
		    		return nv;
				
		    	
		    	}
		    
		    		
		    	
		    	else {
		    		
		    	try {
		    	NhanVien  nv	= (NhanVien) session.createQuery("from nhanvien Where email='"+email +"' and  matkhau='"+matkhau+"'" ).getSingleResult();
		    	//	String sql = "from nhanvien Where email= :p1 and matKhau= :p2 ";
		    	// String sql = "from nhanvien Where email= ? and matKhau= ? ";
		    	// NhanVien nv = (NhanVien) session.createQuery(sql).setParameter(0,email).setParameter(1, matkhau).getSingleResult();
//		    	
//		    	if (nv!=null) {
//		    		return true;
//				}
//		    	else {
//					return false;
//				}
		      return nv;
				} catch (Exception ex) {
			
			}
		
					  
				}
		    		return null; 
		
	 }

	@Transactional
	public boolean XuLyDangKy(NhanVien nhanVien) {
		
		Session session = se.getCurrentSession();
		
		
		try {
			NhanVien nVien = new NhanVien();
			 nVien = XuLyDangNhap(nhanVien.getEmail(), "*");
			
			 //nếu emai chưa từng dky
			if (nVien == null ) {
				
			
			int maNhanVien =  (Integer) session.save(nhanVien);
			
			if(maNhanVien > 0){
				return true;
			}
				
		}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}	
		return false;
		
	}

	@Transactional
	public void updateNV(NhanVien nhanVien) {
		Session session = se.getCurrentSession();
		System.out.println(nhanVien.getMaNhanVien());
		 session.update(nhanVien);
		
	}
}
