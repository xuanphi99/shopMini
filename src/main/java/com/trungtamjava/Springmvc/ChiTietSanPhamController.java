package com.trungtamjava.Springmvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trungtamjava.Service.DanhMucSanPhamService;
import com.trungtamjava.Service.SanPhamService;
import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.GioHang;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.lmplement.SanPhamIlm;

@Controller
@RequestMapping("/chitietsanpham")
public class ChiTietSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhmucSPService;
  
	@GetMapping("/{maSanPham}")
	@Transactional
	public String Default(@PathVariable int maSanPham, ModelMap m,HttpSession httpSession) {
		if (httpSession.getAttribute("user")!=null) {
			String email = (String) httpSession.getAttribute("user");
			String chucaidau = email.substring(0, 1);
			m.addAttribute("chucaidau", chucaidau);
			
		}
	
		SanPham sanpham  = sanPhamService.listChiTietSanPham(maSanPham);
		
		List<DanhMucSanPham>  list = danhmucSPService.listDanhMuc();
		m.addAttribute("sanpham",sanpham);
		m.addAttribute("danhmucsanpham",list);
		if (null !=httpSession.getAttribute("giohang") ) {
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		
		m.addAttribute("SumCast",listGioHangs.size());
		}
		return "PageChiTiet";
	}
}
