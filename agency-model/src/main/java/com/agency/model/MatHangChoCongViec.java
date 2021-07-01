package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class MatHangChoCongViec implements Serializable{
	public static final int MIN_SO_LUONG = 0;
	private int id;
	private int idCongViec;
	private int idMatHang;
	private String tenMatHang;
	private int soLuong;
	private double tongTien;
	

	public MatHangChoCongViec(int id, int idCongViec, int idMatHang, int soLuong, double tongTien)
			throws InvalidAttributeValueException {
		super();
		if(!this.validateSoLuong(soLuong)) {
			throw new InvalidAttributeValueException("Sai số lượng: "+soLuong) ;
		}
		this.id = id;
		this.idCongViec = idCongViec;
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}
	
	public MatHangChoCongViec(int idCongViec, int idMatHang, int soLuong, double tongTien) {
		super();
		this.idCongViec = idCongViec;
		this.idMatHang = idMatHang;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCongViec() {
		return idCongViec;
	}
	public void setIdCongViec(int idCongViec) {
		this.idCongViec = idCongViec;
	}
	public int getIdMatHang() {
		return idMatHang;
	}
	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) throws InvalidAttributeValueException {
		if(!this.validateSoLuong(soLuong)) {
			throw new InvalidAttributeValueException("Só lượng không hợp lệ: "+soLuong);
		}
		this.soLuong = soLuong;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	protected boolean validateSoLuong(int soLuong) {
		return soLuong>=MIN_SO_LUONG;
	}
	@Override
	public String toString() {
		return "CongViecMatHang [id=" + id + ", idCongViec=" + idCongViec + ", idMatHang=" + idMatHang + ", soLuong="
				+ soLuong + ", tongTien=" + tongTien + "]";
	}
	
}
