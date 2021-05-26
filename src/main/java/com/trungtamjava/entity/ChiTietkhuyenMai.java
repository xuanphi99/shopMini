package com.trungtamjava.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity(name = "chitietkhuyenmai")
public class ChiTietkhuyenMai {
	@EmbeddedId
	ChiTietkhuyenMaiId chiTietkhuyenMaiId;

	public ChiTietkhuyenMaiId getChiTietkhuyenMaiId() {
		return chiTietkhuyenMaiId;
	}

	public void setChiTietkhuyenMaiId(ChiTietkhuyenMaiId chiTietkhuyenMaiId) {
		this.chiTietkhuyenMaiId = chiTietkhuyenMaiId;
	}
	
}
