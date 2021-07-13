package com.agency.DAO;

import java.io.Serializable;
import java.util.List;

import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.ThoCongViec;

public class CongViecDAO implements Serializable{
	CongViec congViec;
	List<ThoCongViec> thoCongViecList;
	
	public CongViecDAO() {
		// TODO Auto-generated constructor stub
	}
	public CongViecDAO(CongViec congViec, List<ThoCongViec> thoCongViecList) {
		super();
		this.congViec = congViec;
		this.thoCongViecList = thoCongViecList;
		
	}
	public CongViec getCongViec() {
		return congViec;
	}
	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}
	public List<ThoCongViec> getThoCongViecList() {
		return thoCongViecList;
	}
	public void setThoCongViecList(List<ThoCongViec> thoCongViecList) {
		this.thoCongViecList = thoCongViecList;
	}

	
}
