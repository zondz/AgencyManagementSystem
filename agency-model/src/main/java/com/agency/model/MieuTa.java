package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;

public class MieuTa implements Serializable {
	public static final int MAX_LENGTH_NGUON_GOC_XUAT_XU = 30;
	public static final int MAX_LENGTH_CONG_TY_SAN_XUAT = 50;
	public static final int MAX_LENGTH_MAU_SAC = 20;

	private int id;
	private int idMatHang;
	private String mauSac;
	private KichThuoc kichThuoc;
	private Origin origin;
	
	

	public MieuTa(String mauSac, KichThuoc kichThuoc, Origin origin) {
		super();
		this.mauSac = mauSac;
		this.kichThuoc = kichThuoc;
		this.origin = origin;
	}

	public MieuTa(int id, int idMatHang, String mauSac) {
		super();
		this.id = id;
		this.idMatHang = idMatHang;
		this.mauSac = mauSac;
	}
	
	public MieuTa(int id, int idMatHang, String mauSac, KichThuoc kichThuoc, Origin origin) {
		super();
		this.id = id;
		this.idMatHang = idMatHang;
		this.mauSac = mauSac;
		this.kichThuoc = kichThuoc;
		this.origin = origin;
	}

	public int getIdMatHang() {
		return idMatHang;
	}

	public void setIdMatHang(int idMatHang) {
		this.idMatHang = idMatHang;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	
	public KichThuoc getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(KichThuoc kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	protected boolean validateNguonGocXuatXu(String nguonGocXuatXu) {
		return nguonGocXuatXu != null && nguonGocXuatXu.length() <= MAX_LENGTH_NGUON_GOC_XUAT_XU;
	}

	protected boolean validateCongTySanXuat(String congTySanXuat) {
		return congTySanXuat != null && congTySanXuat.length() <= MAX_LENGTH_CONG_TY_SAN_XUAT;
	}

	protected boolean validateMauSac(String mauSac) {
		return mauSac != null && mauSac.length() <= MAX_LENGTH_MAU_SAC;
	}

	@Override
	public String toString() {
		return "MieuTa [id=" + id + ", idMatHang=" + idMatHang + ", mauSac=" + mauSac + ", kichThuoc=" + kichThuoc
				+ ", origin=" + origin + "]";
	}




	
}
