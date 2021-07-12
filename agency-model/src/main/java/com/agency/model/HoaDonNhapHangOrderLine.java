package com.agency.model;

import java.io.Serializable;

public class HoaDonNhapHangOrderLine implements Serializable {
	public static final int MIN_SO_LUONG = 0;
	private int id;
	private int idHoaDonXuatHang;
	private int idMatHang;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	

	
	public HoaDonNhapHangOrderLine(int id, int idHoaDonXuatHang, int idMatHang, int soLuong,double donGia, double thanhTien) {
		super();
		this.id = id;
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = soLuong*donGia;
	}
	
	public HoaDonNhapHangOrderLine(int idHoaDonXuatHang, int idMatHang, int soLuong,double donGia, double thanhTien) {
		super();
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = soLuong*donGia;
	}
	

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getIdMatHang() {
		return idMatHang;
	}

	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
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
		return "HoaDonNhapHangOrderLine [id=" + id + ", idHoaDonXuatHang=" + idHoaDonXuatHang + ", idMatHang="
				+ idMatHang + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}

	
	
}
