package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class HoaDonXuatHangOrderLine implements Serializable {
	public static final int MIN_SO_LUONG = 1;
	public static final int MIN_DON_GIA = 0;
	
	private int id;
	private int idHoaDon;
	private int idMatHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private double donGia;
	private int giaKhong;
	private double thanhTien;
	
	// 
	
	public int getIdHoaDon() {
		return idHoaDon;
	}
	
	
	// constructor for view
	public HoaDonXuatHangOrderLine(int idMatHang, int soLuong, int giaKhong) {
		super();
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.giaKhong = giaKhong;
	}

	


	// day xuong database
	public HoaDonXuatHangOrderLine( int idHoaDon, int idMatHang, DonViTinh donViTinh, int soLuong, double donGia, int giaKhong
			) {
		super();

		this.idHoaDon = idHoaDon;
		this.idMatHang = idMatHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.giaKhong = giaKhong;
		if(giaKhong!=0) {
			this.thanhTien = soLuong*giaKhong;
		}
		else{this.thanhTien = soLuong*donGia;}
	}
	
	

	public HoaDonXuatHangOrderLine(int id, int idHoaDon, int idMatHang, int soLuong,  int giaKhong) {
		super();
		this.id = id;
		this.idHoaDon = idHoaDon;
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.giaKhong = giaKhong;
	
	}
	public HoaDonXuatHangOrderLine() {
		// TODO Auto-generated constructor stub
	}
	public int getGiaKhong() {
		return giaKhong;
	}
	public void setGiaKhong(int giaKhong) {
		this.giaKhong = giaKhong;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
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
	
	public DonViTinh getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong)  {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia)  {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}

	public int getId() {
		return id;
	}

	protected boolean validateSoLuong(int soLuong) {
		return soLuong>=MIN_SO_LUONG;
	}
	
	protected boolean validateDonGia(double donGia) {
		return donGia>=MIN_DON_GIA;
	}
	@Override
	public String toString() {
		return "HoaDonXuatHangOrderLine [id=" + id + ", idHoaDon=" + idHoaDon + ", idMatHang=" + idMatHang
				+ ", donViTinh=" + donViTinh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", giaKhong=" + giaKhong
				+ ", thanhTien=" + thanhTien + "]";
	}
	
	

	
	
}
