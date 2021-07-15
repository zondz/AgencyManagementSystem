package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class CongViec implements Serializable {

	public static final int MAX_LENGTH_TEN_CONG_VIEC = 50;
	public static final int MIN_TONG_CHI_PHI_MAT_HANG = 0;
	public static final int MIN_TONG_CONG_THO = 0;
	private int id;
	private int idKhachHang;
	// moi co cai nay
	private int idHoaDonXuatHang;
	private String tenCongViec;
	private double tongChiPhiMatHang;
	private double tongCongTho;
	private LocalDate ngayBatDau;


	
	

	public CongViec(int id, int idKhachHang, int idHoaDonXuatHang, String tenCongViec, LocalDate ngayBatDau) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.tenCongViec = tenCongViec;
		this.ngayBatDau = ngayBatDau;
	}

	
	
	//view 
	public CongViec(String tenCongViec, LocalDate ngayBatDau) {
		this.tenCongViec = tenCongViec;
		this.ngayBatDau = ngayBatDau;
		
	}




	public int getIdHoaDonXuatHang() {
		return idHoaDonXuatHang;
	}

	public void setIdHoaDonXuatHang(int idHoaDonXuatHang) {
		this.idHoaDonXuatHang = idHoaDonXuatHang;
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


	public String getTenCongViec() {
		return tenCongViec;
	}

	public void setTenCongViec(String tenCongViec) {
		
		this.tenCongViec = tenCongViec;
	}

	public double getTongChiPhiMatHang() {
		return tongChiPhiMatHang;
	}

	public void setTongChiPhiMatHang(double tongChiPhiMatHang)  {
	

		this.tongChiPhiMatHang = tongChiPhiMatHang;
	}

	public double getTongCongTho() {
		return tongCongTho;
	}

	public void setTongCongTho(double tongCongTho) {

		this.tongCongTho = tongCongTho;
	}

	

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	protected boolean validateTenCongViec(String tenCongViec) {
		return tenCongViec != null && tenCongViec.length() <= this.MAX_LENGTH_TEN_CONG_VIEC;
	}

	protected boolean validateTongChiPhiMatHang(double chiPhiMatHang) {
		return chiPhiMatHang >= this.MIN_TONG_CHI_PHI_MAT_HANG;

	}

	protected boolean validateTongCongTho(double tongCongTho) {
		return tongCongTho >= this.MIN_TONG_CONG_THO;
	}




	@Override
	public String toString() {
		return "CongViec [id=" + id + ", idKhachHang=" + idKhachHang + ", idHoaDonXuatHang=" + idHoaDonXuatHang
				+ ", tenCongViec=" + tenCongViec + ", tongChiPhiMatHang=" + tongChiPhiMatHang + ", tongCongTho="
				+ tongCongTho + ", ngayBatDau=" + ngayBatDau + "]";
	}


}
