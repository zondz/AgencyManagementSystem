package com.agency.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class CongViec implements Serializable {

	public static final int MAX_LENGTH_TEN_CONG_VIEC = 50;
	public static final int MIN_TONG_CHI_PHI_MAT_HANG = 0;
	public static final int MIN_TONG_CONG_THO = 0;
	private int id;
	private int idKhachHang;
	private int idTho;
	private String tenCongViec;
	private double tongChiPhiMatHang;
	private double tongCongTho;
	private List<MatHangChoCongViec> cacMatHangChoCongViec;

	public CongViec(int id, int idKhachHang, int idTho, String tenCongViec, double tongChiPhiMatHang,
			double tongCongTho) throws InvalidAttributeValueException {
		super();
		if (!(this.validateTenCongViec(tenCongViec) && this.validateTongChiPhiMatHang(tongChiPhiMatHang)
				&& this.validateTongCongTho(tongCongTho)))
			throw new InvalidAttributeValueException("Thông tin công việc không hợp lệ");

		this.id = id;
		this.idKhachHang = idKhachHang;
		this.idTho = idTho;
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.cacMatHangChoCongViec = new ArrayList<MatHangChoCongViec>();
	}

	public CongViec(int idKhachHang, int idTho, String tenCongViec, double tongChiPhiMatHang, double tongCongTho
			) throws InvalidAttributeValueException {
		super();
		if (!(this.validateTenCongViec(tenCongViec) && this.validateTongChiPhiMatHang(tongChiPhiMatHang)
				&& this.validateTongCongTho(tongCongTho)))
			throw new InvalidAttributeValueException("Thông tin công việc không hợp lệ");

		this.idKhachHang = idKhachHang;
		this.idTho = idTho;
		this.tenCongViec = tenCongViec;
		this.tongChiPhiMatHang = tongChiPhiMatHang;
		this.tongCongTho = tongCongTho;
		this.cacMatHangChoCongViec = new ArrayList<MatHangChoCongViec>();
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

	public void setTenCongViec(String tenCongViec) throws InvalidAttributeValueException {
		if(!this.validateTenCongViec(tenCongViec)) throw new InvalidAttributeValueException("Tên công việc không hợp lệ : "+tenCongViec);
		this.tenCongViec = tenCongViec;
	}

	public double getTongChiPhiMatHang() {
		return tongChiPhiMatHang;
	}

	public void setTongChiPhiMatHang(double tongChiPhiMatHang) throws InvalidAttributeValueException {
		if(!this.validateTongChiPhiMatHang(tongChiPhiMatHang)) throw new InvalidAttributeValueException("Tổng chi phí mặt hàng không hợp lệ: "+tongChiPhiMatHang);
		
		this.tongChiPhiMatHang = tongChiPhiMatHang;
	}

	public double getTongCongTho() {
		return tongCongTho;
	}

	public void setTongCongTho(double tongCongTho) throws InvalidAttributeValueException {
		if(!this.validateTongCongTho(tongCongTho)) throw new InvalidAttributeValueException("tổng công thợ không hợp lệ: "+tongCongTho);
		this.tongCongTho = tongCongTho;
	}

	public List<MatHangChoCongViec> getCacMatHangChoCongViec() {
		return cacMatHangChoCongViec;
	}

	public void setCacMatHangChoCongViec(List<MatHangChoCongViec> cacMatHangChoCongViec) {
		this.cacMatHangChoCongViec = cacMatHangChoCongViec;
	}

	protected boolean validateTenCongViec(String tenCongViec) {
		return tenCongViec!=null&&this.tenCongViec.length() <= this.MAX_LENGTH_TEN_CONG_VIEC;
	}

	protected boolean validateTongChiPhiMatHang(double chiPhiMatHang) {
		return chiPhiMatHang >= this.MIN_TONG_CHI_PHI_MAT_HANG;

	}

	protected boolean validateTongCongTho(double tongCongTho) {
		return tongCongTho >= this.MIN_TONG_CONG_THO;
	}

	@Override
	public String toString() {
		return "CongViec [id=" + id + ", idKhachHang=" + idKhachHang + ", idTho=" + idTho + ", tenCongViec="
				+ tenCongViec + ", tongChiPhiMatHang=" + tongChiPhiMatHang + ", tongCongTho=" + tongCongTho
				+ ", cacMatHangChoCongViec=" + cacMatHangChoCongViec + "]";
	}

}
