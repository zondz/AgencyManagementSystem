package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;

public class MatHang implements Serializable {
	private Integer id;
	private String tenMatHang;
	private LoaiHang loaiHang;
	private DonViTinh donViTinh;
	private LocalDate ngayNhap;
	private int soLuong;
	private int giaBanTrenDonVi;
	private int idMieuTa;

	public MatHang() {
		// TODO Auto-generated constructor stub
	}

	public MatHang(int id, String tenMatHang, LoaiHang loaiHang, DonViTinh donViTinh, LocalDate ngayNhap, int soLuong,
			int giaBanTrenDonVi, int idMieuTa) {
		super();
		this.id = id;
		this.tenMatHang = tenMatHang;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.giaBanTrenDonVi = giaBanTrenDonVi;
		this.idMieuTa = idMieuTa;
	}
	
	

	public MatHang(String tenMatHang, LoaiHang loaiHang, DonViTinh donViTinh, LocalDate ngayNhap, int soLuong,
			int giaBanTrenDonVi, int idMieuTa) {
		super();
		this.tenMatHang = tenMatHang;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;
		this.ngayNhap = ngayNhap;
		this.soLuong = soLuong;
		this.giaBanTrenDonVi = giaBanTrenDonVi;
		this.idMieuTa = idMieuTa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public LoaiHang getLoaiHang() {
		return loaiHang;
	}

	public void setLoaiHang(LoaiHang loaiHang) {
		this.loaiHang = loaiHang;
	}

	public DonViTinh getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(DonViTinh donViTinh) {
		this.donViTinh = donViTinh;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiaBanTrenDonVi() {
		return giaBanTrenDonVi;
	}

	public void setGiaBanTrenDonVi(int giaBanTrenDonVi) {
		this.giaBanTrenDonVi = giaBanTrenDonVi;
	}

	public int getIdMieuTa() {
		return idMieuTa;
	}

	public void setIdMieuTa(int idMieuTa) {
		this.idMieuTa = idMieuTa;
	}

	@Override
	public String toString() {
		return "MatHang [id=" + id + ", tenMatHang=" + tenMatHang + ", loaiHang=" + loaiHang + ", donViTinh="
				+ donViTinh + ", ngayNhap=" + ngayNhap + ", soLuong=" + soLuong + ", giaBanTrenDonVi=" + giaBanTrenDonVi
				+ ", idMieuTa=" + idMieuTa + "]";
	}

}
