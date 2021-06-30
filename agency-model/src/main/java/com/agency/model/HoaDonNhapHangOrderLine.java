package com.agency.model;

import java.io.Serializable;

public class HoaDonNhapHangOrderLine implements Serializable {
	private int id;
	private int idHoaDonXuatHang;
	private int idMatHang;
	private String tenMatHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	public HoaDonNhapHangOrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonNhapHangOrderLine(int id, int idHoaDonXuatHang, int idMatHang, String tenMatHang, DonViTinh donViTinh,
			int soLuong, double donGia, double thanhTien) {
		super();
		this.id = id;
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.idMatHang = idMatHang;
		this.tenMatHang = tenMatHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	public HoaDonNhapHangOrderLine(int idHoaDonXuatHang, int idMatHang, String tenMatHang, DonViTinh donViTinh,
			int soLuong, double donGia, double thanhTien) {
		super();
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.idMatHang = idMatHang;
		this.tenMatHang = tenMatHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
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
	public int getIdMatHang() {
		return idMatHang;
	}
	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
	}
	public String getTenMatHang() {
		return tenMatHang;
	}
	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
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
	@Override
	public String toString() {
		return "HoaDonNhapHangOrderLine [id=" + id + ", idHoaDonXuatHang=" + idHoaDonXuatHang + ", idMatHang="
				+ idMatHang + ", tenMatHang=" + tenMatHang + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong
				+ ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}
	
	
}
