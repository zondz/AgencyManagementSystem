package com.agency.model;

import java.io.Serializable;

import javax.management.InvalidAttributeValueException;

public class KhachHang implements Serializable {

	public static final int MAX_LENGTH_TEN_KHACH_HANG = 50;
	public static final int MIN_LENGTH_SO_DIEN_THOAI = 10;
	public static final int MAX_LENGTH_SO_DIEN_THOAI = 11;
	public static final int MAX_LENGTH_DIA_CHI = 50;

	private int id;
	private String tenKhachHang;
	private String soDienThoai;
	private String diaChi;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int id, String tenKhachHang, String soDienThoai, String diaChi)
		 {
		super();
		
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public KhachHang(String tenKhachHang, String soDienThoai, String diaChi) {
		super();
		
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) throws InvalidAttributeValueException {
		if (!this.validateTenKhachHang(tenKhachHang))
			throw new InvalidAttributeValueException("tên khách hàng sai: " + tenKhachHang);
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws InvalidAttributeValueException {
		if(!this.validateSoDienThoai(soDienThoai)) throw new InvalidAttributeValueException("số điện thoại sai: "+soDienThoai);
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws InvalidAttributeValueException {
		if(!this.validateDiaChi(diaChi)) throw new InvalidAttributeValueException("địa chỉ sai: "+diaChi);
		this.diaChi = diaChi;
	}

	protected boolean validateTenKhachHang(String tenKhachHang) {
		return tenKhachHang != null && tenKhachHang.length() <= MAX_LENGTH_TEN_KHACH_HANG;
	}

	protected boolean validateSoDienThoai(String soDienThoai) {
		return soDienThoai != null && soDienThoai.length() >= MIN_LENGTH_SO_DIEN_THOAI
				&& soDienThoai.length() <= MAX_LENGTH_SO_DIEN_THOAI;
	}

	protected boolean validateDiaChi(String diaChi) {
		return diaChi != null && diaChi.length() <= MAX_LENGTH_DIA_CHI;
	}

	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai + ", address="
				+ diaChi + "]";
	}

}
