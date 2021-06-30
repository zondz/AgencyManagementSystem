package com.agency.model;

import java.io.Serializable;

public class HoaDonMuaHangOrderLine implements Serializable {
	private int id;
	private int idHoaDon;
	private int idMatHang;
	private int soThuTu;
	private DonViTinh donViTinh;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	public HoaDonMuaHangOrderLine(int idHoaDon, int idMatHang, int soThuTu, DonViTinh donViTinh, int soLuong,
			double donGia, double thanhTien) {
		super();
		this.idHoaDon = idHoaDon;
		this.idMatHang = idMatHang;
		this.soThuTu = soThuTu;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	public HoaDonMuaHangOrderLine(int idMatHang, int soThuTu, DonViTinh donViTinh, int soLuong, double donGia,
			double thanhTien) {
		super();
		this.idMatHang = idMatHang;
		this.soThuTu = soThuTu;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	
	public int getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public int getIdMatHang() {
		return idMatHang;
	}
	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
	}
	public int getSoThuTu() {
		return soThuTu;
	}
	public void setSoThuTu(int soThuTu) {
		this.soThuTu = soThuTu;
	}
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "HoaDonMuaHangOrderLine [idHoaDon=" + idHoaDon + ", idMatHang=" + idMatHang + ", soThuTu=" + soThuTu
				+ ", donViTinh=" + donViTinh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
	
}
