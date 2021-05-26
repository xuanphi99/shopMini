package com.trungtamjava.Springmvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trungtamjava.Service.DanhMucSanPhamService;
import com.trungtamjava.Service.SanPhamService;
import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.GioHang;
import com.trungtamjava.entity.SanPham;



@Controller
@RequestMapping( path = {"/trangchu","/"})
public class Trangchu {

	
	
     @Autowired	
	private SanPhamService sanPhamService ; 
     @Autowired
 	DanhMucSanPhamService danhmucSPService;
	
	@GetMapping
	@Transactional
	public String Default(HttpSession httpSession, ModelMap map) {
		
		if (httpSession.getAttribute("user")!=null) {
			String email = (String) httpSession.getAttribute("user");
			String chucaidau = email.substring(0, 1);
			map.addAttribute("chucaidau", chucaidau);
			
		}
		// truyen ds cac san pham co trong csdl
	List<SanPham> listsanPhams = sanPhamService.listSanPham(-1);

	map.addAttribute("listSanPham", listsanPhams);
	map.addAttribute("SizelistSanPham", listsanPhams.size());
	
	// luu session gio hang

	if (null !=httpSession.getAttribute("giohang") ) {
	List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
	
	map.addAttribute("SumCast",listGioHangs.size());
	}
	
	List<DanhMucSanPham>  list = danhmucSPService.listDanhMuc();
	
	map.addAttribute("danhmucsanpham",list);
	
	
	
		return "trangchu";
	}
	
	

}
