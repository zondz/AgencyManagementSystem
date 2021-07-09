package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;
import javax.naming.directory.InvalidAttributesException;

public class MieuTa implements Serializable {
	public static final int MAX_LENGTH_NGUON_GOC_XUAT_XU = 30;
	public static final int MAX_LENGTH_CONG_TY_SAN_XUAT = 50;
	public static final int MAX_LENGTH_MAU_SAC = 20;

	private int id;
	private String nguonGocXuatXu;
	private String congTySanXuat;
	private String mauSac;
	
	private KichThuoc kichThuoc;
	private Origin origin;
	
	
	public MieuTa(int id, String nguonGocXuatXu, String congTySanXuat, String mauSac, KichThuoc kichThuoc,
			Origin origin) {
		super();
		this.id = id;
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
		this.mauSac = mauSac;
		this.kichThuoc = kichThuoc;
		this.origin = origin;
	}
	

	public MieuTa(String nguonGocXuatXu, String congTySanXuat, String mauSac, KichThuoc kichThuoc, Origin origin) {
		super();
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
		this.mauSac = mauSac;
		this.kichThuoc = kichThuoc;
		this.origin = origin;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNguonGocXuatXu() {
		return nguonGocXuatXu;
	}

	public void setNguonGocXuatXu(String nguonGocXuatXu) throws InvalidAttributeValueException {
		if(!this.validateNguonGocXuatXu(nguonGocXuatXu)) throw new InvalidAttributeValueException("Sai thông tin nguồn gốc xuất xứ : "+nguonGocXuatXu);
		this.nguonGocXuatXu = nguonGocXuatXu;
	}

	public String getCongTySanXuat() {
		return congTySanXuat;
	}

	public void setCongTySanXuat(String congTySanXuat) throws InvalidAttributeValueException {
		if(!this.validateCongTySanXuat(congTySanXuat)) throw new InvalidAttributeValueException("Sai thông tin công ty sản xuất: "+congTySanXuat);
		this.congTySanXuat = congTySanXuat;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) throws InvalidAttributeValueException {
		if(!this.validateMauSac(mauSac)) throw new InvalidAttributeValueException("Sai thông tin màu sắc: "+mauSac);
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
		return "MieuTa [id=" + id + ", nguonGocXuatXu=" + nguonGocXuatXu + ", congTySanXuat=" + congTySanXuat
				+ ", mauSac=" + mauSac + ", kichThuoc=" + kichThuoc + ", origin=" + origin + "]";
	}



	
}
