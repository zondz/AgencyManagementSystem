package com.agency.model;

import java.io.Serializable;

public class CongViec implements Serializable {
	private int id;
	private int idKhachHang;
	private int idTho;
	private String tenCongViec;
	private double tongChiPhiMatHang;
	private double tongCongTho ;
	private int idCongViecMatHang;
	public CongViec(int id, int idKhachHang, int idTho, String tenCongViec, double tongChiPhiMatHang,
			double tongCongTho, int idCongViecMatHang) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.idTho = idTho;
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.idCongViecMatHang = idCongViecMatHang;
	}
	public CongViec(int idKhachHang, int idTho, String tenCongViec, double tongChiPhiMatHang, double tongCongTho,
			int idCongViecMatHang) {
		super();
		this.idKhachHang = idKhachHang;
		this.idTho = idTho;
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.idCongViecMatHang = idCongViecMatHang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public int getIdTho() {
		return idTho;
	}
	public void setIdTho(int idTho) {
		this.idTho = idTho;
	}
	public String getTenCongViec() {
		return tenCongViec;
	}
	public void setTenCongViec(String tenCongViec) {
		this.tenCongViec = tenCongViec;
	}
	public double getTongChiPhiMatHang() {
		return tongChiPhiMatHang;
	}
	public void setTongChiPhiMatHang(double tongChiPhiMatHang) {
		this.tongChiPhiMatHang = tongChiPhiMatHang;
	}
	public double getTongCongTho() {
		return tongCongTho;
	}
	public void setTongCongTho(double tongCongTho) {
		this.tongCongTho = tongCongTho;
	}
	public int getIdCongViecMatHang() {
		return idCongViecMatHang;
	}
	public void setIdCongViecMatHang(int idCongViecMatHang) {
		this.idCongViecMatHang = idCongViecMatHang;
	}
	@Override
	public String toString() {
		return "CongViec [id=" + id + ", idKhachHang=" + idKhachHang + ", idTho=" + idTho + ", tenCongViec="
				+ tenCongViec + ", tongChiPhiMatHang=" + tongChiPhiMatHang + ", tongCongTho=" + tongCongTho
				+ ", idCongViecMatHang=" + idCongViecMatHang + "]";
	}
	
}
