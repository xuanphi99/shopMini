package com.trungtamjava.Springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trungtamjava.Service.DanhMucSanPhamService;
import com.trungtamjava.Service.MauSanPhamService;
import com.trungtamjava.Service.SanPhamService;
import com.trungtamjava.Service.SizeSanPhamService;
import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.MauSanPham;
import com.trungtamjava.entity.SanPham;
import com.trungtamjava.entity.SizeSanPham;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucSanPhamService danhmucsanpham;

	@Autowired
	SizeSanPhamService sizespService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;

	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listSanPhams =  sanPhamService.listSanPham(0);
		List<SanPham> allSanPham = sanPhamService.listSanPham(-1);
			
		double tongsopage = Math.ceil((double) allSanPham.size() / 3);
		modelMap.addAttribute("listSanPham", listSanPhams);
		modelMap.addAttribute("allSanPham", allSanPham);
		modelMap.addAttribute("tongsopage", tongsopage);
	List<DanhMucSanPham> listdMucSanPhams	= danhmucsanpham.listDanhMuc();
		modelMap.addAttribute("listDM", listdMucSanPhams);
		
	List<SizeSanPham> sizeSanPhams = sizespService.getSizeSanPhams();
	modelMap.addAttribute("listsize", sizeSanPhams);
	
	List<MauSanPham> mauSanPhams = mauSanPhamService.getMauSanPhams();
	modelMap.addAttribute("listmau", mauSanPhams);
	
		
		return "themsanpham";
	}
	
}
