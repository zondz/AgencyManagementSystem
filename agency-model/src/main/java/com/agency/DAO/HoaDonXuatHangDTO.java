package com.agency.DAO;

import java.io.Serializable;

import com.agency.model.HoaDonXuatHang;
import com.agency.model.KhachHang;

public class HoaDonXuatHangDTO implements Serializable{
	private HoaDonXuatHang hoaDonXuatHang ;
	private KhachHang khachHang;
	public HoaDonXuatHangDTO(HoaDonXuatHang hoaDonXuatHang, KhachHang khachHang) {
		super();
		this.hoaDonXuatHang = hoaDonXuatHang;
		this.khachHang = khachHang;
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
		return "HoaDonXuatHangDTO [hoaDonXuatHang=" + hoaDonXuatHang + ", khachHang=" + khachHang + "]";
	}
	
}
