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
	private List<MatHangChoCongViec> cacMatHangChoCongViec;

	
	

	public CongViec(int id, int idKhachHang, int idHoaDonXuatHang, String tenCongViec, LocalDate ngayBatDau) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.idHoaDonXuatHang = idHoaDonXuatHang;
		this.tenCongViec = tenCongViec;
		this.ngayBatDau = ngayBatDau;
	}

	public CongViec(int id, int idKhachHang, String tenCongViec, double tongChiPhiMatHang,
			double tongCongTho, LocalDate ngayBatDau) throws InvalidAttributeValueException {
		super();
		if (!(this.validateTenCongViec(tenCongViec) && this.validateTongChiPhiMatHang(tongChiPhiMatHang)
				&& this.validateTongCongTho(tongCongTho)))
			throw new InvalidAttributeValueException("Thông tin công việc không hợp lệ");

		this.id = id;
		this.idKhachHang = idKhachHang;
	
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.ngayBatDau = ngayBatDau;
		this.cacMatHangChoCongViec = new ArrayList<MatHangChoCongViec>();
	}
	
	public CongViec(int idKhachHang, String tenCongViec, double tongChiPhiMatHang, double tongCongTho,
			LocalDate ngayBatDau) throws InvalidAttributeValueException {
		super();
		if (!(this.validateTenCongViec(tenCongViec) && this.validateTongChiPhiMatHang(tongChiPhiMatHang)
				&& this.validateTongCongTho(tongCongTho)))
			throw new InvalidAttributeValueException("Thông tin công việc không hợp lệ");

		this.idKhachHang = idKhachHang;
	
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.ngayBatDau = ngayBatDau;
		this.cacMatHangChoCongViec = new ArrayList<MatHangChoCongViec>();
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

	public void setTenCongViec(String tenCongViec) throws InvalidAttributeValueException {
		if (!this.validateTenCongViec(tenCongViec))
			throw new InvalidAttributeValueException("Tên công việc không hợp lệ : " + tenCongViec);
		this.tenCongViec = tenCongViec;
	}

	public double getTongChiPhiMatHang() {
		return tongChiPhiMatHang;
	}

	public void setTongChiPhiMatHang(double tongChiPhiMatHang) throws InvalidAttributeValueException {
		if (!this.validateTongChiPhiMatHang(tongChiPhiMatHang))
			throw new InvalidAttributeValueException("Tổng chi phí mặt hàng không hợp lệ: " + tongChiPhiMatHang);

		this.tongChiPhiMatHang = tongChiPhiMatHang;
	}

	public double getTongCongTho() {
		return tongCongTho;
	}

	public void setTongCongTho(double tongCongTho) throws InvalidAttributeValueException {
		if (!this.validateTongCongTho(tongCongTho))
			throw new InvalidAttributeValueException("tổng công thợ không hợp lệ: " + tongCongTho);
		this.tongCongTho = tongCongTho;
	}

	public List<MatHangChoCongViec> getCacMatHangChoCongViec() {
		return cacMatHangChoCongViec;
	}

	public void setCacMatHangChoCongViec(List<MatHangChoCongViec> cacMatHangChoCongViec) {
		this.cacMatHangChoCongViec = cacMatHangChoCongViec;
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
		return "CongViec [id=" + id + ", idKhachHang=" + idKhachHang + ",   tenCongViec="
				+ tenCongViec + ", tongChiPhiMatHang=" + tongChiPhiMatHang + ", tongCongTho=" + tongCongTho
				+ ", cacMatHangChoCongViec=" + cacMatHangChoCongViec + "]";
	}

}
