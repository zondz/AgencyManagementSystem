package com.agency.model;

import java.io.Serializable;

public class HoaDonMuaHang implements Serializable {
	private int id;
	private int idKhachHang;
	private int vanChuyen;
	private double tongCong;
	private double datTruoc;
	private double conLai;
	public HoaDonMuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonMuaHang(int id, int idKhachHang, int vanChuyen, double tongCong, double datTruoc, double conLai) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.vanChuyen = vanChuyen;
		this.tongCong = tongCong;
		this.datTruoc = datTruoc;
		this.conLai = conLai;
	}
	public HoaDonMuaHang(int idKhachHang, int vanChuyen, double tongCong, double datTruoc, double conLai) {
		super();
		this.idKhachHang = idKhachHang;
		this.vanChuyen = vanChuyen;
		this.tongCong = tongCong;
		this.datTruoc = datTruoc;
		this.conLai = conLai;
	}
	
	
	
}
