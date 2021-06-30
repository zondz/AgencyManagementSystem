package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class HoaDonMuaHangOrderLine implements Serializable {
	public static final int MIN_SO_LUONG = 1;
	public static final int MIN_DON_GIA = 0;
	
	private int id;
	private int idHoaDon;
	private int idMatHang;
	private int soThuTu;
	private DonViTinh donViTinh;
	private int soLuong;
	private double donGia;
	private double thanhTien = soLuong*donGia;
	public HoaDonMuaHangOrderLine(int idHoaDon, int idMatHang, int soThuTu, DonViTinh donViTinh, int soLuong,
			double donGia, double thanhTien) throws InvalidAttributeValueException {
		super();
		if(!(this.validateDonGia(donGia)&&this.validateSoLuong(soLuong))) throw new InvalidAttributeValueException("Sai thông tin nhập");
		
		this.idHoaDon = idHoaDon;
		this.idMatHang = idMatHang;
		this.soThuTu = soThuTu;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}
	public HoaDonMuaHangOrderLine(int idMatHang, int soThuTu, DonViTinh donViTinh, int soLuong, double donGia,
			double thanhTien) throws InvalidAttributeValueException {
		super();
		if(!(this.validateDonGia(donGia)&&this.validateSoLuong(soLuong))) throw new InvalidAttributeValueException("Sai thông tin nhập");
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
	public void setSoLuong(int soLuong) throws InvalidAttributeValueException {
		if(!this.validateSoLuong(soLuong)) throw new InvalidAttributeValueException("Nhập sai số lượng : "+soLuong);
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) throws InvalidAttributeValueException {
		if(!this.validateDonGia(donGia)) throw new InvalidAttributeValueException("Nhập sai đơn giá: "+donGia);
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
		return "HoaDonMuaHangOrderLine [idHoaDon=" + idHoaDon + ", idMatHang=" + idMatHang + ", soThuTu=" + soThuTu
				+ ", donViTinh=" + donViTinh + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien="
				+ thanhTien + "]";
	}
	
	
	
}
