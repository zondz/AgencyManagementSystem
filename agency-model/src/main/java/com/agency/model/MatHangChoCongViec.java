package com.agency.model;

import java.io.Serializable;

public class MatHangChoCongViec implements Serializable{
	private int id;
	private int idCongViec;
	private int idMatHang;
	private int soLuong;
	private double tongTien;
	

	public MatHangChoCongViec(int id, int idCongViec, int idMatHang, int soLuong, double tongTien) {
		super();
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
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "CongViecMatHang [id=" + id + ", idCongViec=" + idCongViec + ", idMatHang=" + idMatHang + ", soLuong="
				+ soLuong + ", tongTien=" + tongTien + "]";
	}
	
}
