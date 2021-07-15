package com.agency.DAO;

import java.io.Serializable;
import java.util.List;

import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.KhachHang;
import com.agency.model.ThoCongViec;

public class CongViecDAO implements Serializable{
	CongViec congViec;
	List<ThoCongViec> thoCongViecList;
	HoaDonXuatHang hoaDonXuatHang;
	KhachHang khachHang;
	public CongViecDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public CongViecDAO(CongViec congViec, List<ThoCongViec> thoCongViecList, HoaDonXuatHang hoaDonXuatHang,KhachHang khachHang) {
		super();
		this.congViec = congViec;
		this.thoCongViecList = thoCongViecList;
		this.hoaDonXuatHang = hoaDonXuatHang;
		this.khachHang = khachHang;
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

	public HoaDonXuatHang getHoaDonXuatHang() {
		return hoaDonXuatHang;
	}

	public void setHoaDonXuatHang(HoaDonXuatHang hoaDonXuatHang) {
		this.hoaDonXuatHang = hoaDonXuatHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "CongViecDAO [congViec=" + congViec + ", thoCongViecList=" + thoCongViecList + ", hoaDonXuatHang="
				+ hoaDonXuatHang + ", khachHang=" + khachHang + "]";
	}

	
}
