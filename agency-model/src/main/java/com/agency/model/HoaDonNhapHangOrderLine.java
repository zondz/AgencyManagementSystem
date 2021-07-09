package com.agency.model;

import java.io.Serializable;

public class HoaDonNhapHangOrderLine implements Serializable {
	public static final int MIN_SO_LUONG = 0;
	private int id;
	private int idHoaDonXuatHang;
	// 3 cái này đã nằm trong bảng khác rồi -> có cần tạo các thuộc tính này không
	// 
	private int soLuong;
	private double thanhTien;
	

	public HoaDonNhapHangOrderLine(int idHoaDonXuatHang, int soLuong, double thanhTien) {
		super();
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public HoaDonNhapHangOrderLine(int id, int idHoaDonXuatHang, int soLuong, double thanhTien) {
		super();
		this.id = id;
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHoaDonXuatHang() {
		return idHoaDonXuatHang;
	}
	public void setIdHoaDonXuatHang(int idHoaDonXuatHang) {
		this.idHoaDonXuatHang = idHoaDonXuatHang;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "HoaDonNhapHangOrderLine [id=" + id + ", idHoaDonXuatHang=" + idHoaDonXuatHang + ", soLuong=" + soLuong
				+ ", thanhTien=" + thanhTien + "]";
	}

	
}
