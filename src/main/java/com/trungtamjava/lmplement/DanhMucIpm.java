package com.trungtamjava.lmplement;

import java.util.List;

import com.trungtamjava.entity.DanhMucSanPham;
import com.trungtamjava.entity.SanPham;

public interface DanhMucIpm {
	List<DanhMucSanPham> listDanhMuc();
	 List<SanPham> getListCatetogryById(int madanhmuc);
}
