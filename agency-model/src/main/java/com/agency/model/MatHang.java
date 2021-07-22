package com.agency.model;

import java.io.Serializable;

import javax.management.InvalidAttributeValueException;

public class MatHang implements Serializable {
	public static final int MAX_LENGTH_TEN_MAT_HANG = 50;
	public static final int MIN_SO_LUONG = 0;
	public static final int MIN_GIA_BAN_TREN_DON_VI = 0;

	private int id;
	private String tenMatHang;
	private LoaiHang loaiHang;
	private DonViTinh donViTinh;
	private int soLuong;
	private int giaBanTrenDonVi;
	private MieuTa mieuTa;

	public MatHang() {
		// TODO Auto-generated constructor stub
	}

	public MatHang(String tenMatHang, LoaiHang loaiHang, DonViTinh donViTinh, int soLuong, int giaBanTrenDonVi,
			MieuTa mieuTa) {
		super();
		this.tenMatHang = tenMatHang;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.giaBanTrenDonVi = giaBanTrenDonVi;
		this.mieuTa = mieuTa;
	}

	public MatHang(int id, String tenMatHang, LoaiHang loaiHang, DonViTinh donViTinh, int soLuong, int giaBanTrenDonVi,
			MieuTa mieuTa) throws InvalidAttributeValueException {
		super();
		if (!(this.validateTenMatHang(tenMatHang) && this.validateSoLuong(soLuong)
				&& this.validateGiaBanTrenDonVi(giaBanTrenDonVi)))
			throw new InvalidAttributeValueException("Sai thông tin mặt hàng");
		this.id = id;
		this.tenMatHang = tenMatHang;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;

		this.soLuong = soLuong;
		this.giaBanTrenDonVi = giaBanTrenDonVi;
		this.mieuTa = mieuTa;
	}

	public MatHang(int id, String tenMatHang, LoaiHang loaiHang, DonViTinh donViTinh, int soLuong,
			int giaBanTrenDonVi) {
		super();
		this.id = id;
		this.tenMatHang = tenMatHang;
		this.loaiHang = loaiHang;
		this.donViTinh = donViTinh;
		this.soLuong = soLuong;
		this.giaBanTrenDonVi = giaBanTrenDonVi;
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

	public MieuTa getMieuTa() {
		return mieuTa;
	}

	public void setMieuTa(MieuTa mieuTa) {
		this.mieuTa = mieuTa;
	}

	protected boolean validateTenMatHang(String tenMatHang) {
		return tenMatHang != null && tenMatHang.length() <= MAX_LENGTH_TEN_MAT_HANG;
	}

	protected boolean validateSoLuong(int soLuong) {
		return soLuong >= MIN_SO_LUONG;
	}

	protected boolean validateGiaBanTrenDonVi(int giaBanTrenDonVi) {
		return giaBanTrenDonVi >= MIN_GIA_BAN_TREN_DON_VI;
	}

	@Override
	public String toString() {
		return "MatHang [id=" + id + ", tenMatHang=" + tenMatHang + ", loaiHang=" + loaiHang + ", donViTinh="
				+ donViTinh + ", soLuong=" + soLuong + ", giaBanTrenDonVi=" + giaBanTrenDonVi + ", mieuTa=" + mieuTa
				+ "]";
	}

}
