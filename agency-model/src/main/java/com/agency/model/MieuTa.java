package com.agency.model;

import java.io.Serializable;

public class MieuTa implements Serializable{
	private int id;
	private String nguonGocXuatXu;
	private String congTySanXuat;
	private String mauSac;
	private String thongTinThem;
	private KichThuoc kichThuoc;
	public MieuTa(int id, String nguonGocXuatXu, String congTySanXuat, String mauSac, String thongTinThem,
			KichThuoc kichThuoc) {
		super();
		this.id = id;
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
		this.mauSac = mauSac;
		this.thongTinThem = thongTinThem;
		this.kichThuoc = kichThuoc;
	}
	public MieuTa(String nguonGocXuatXu, String congTySanXuat, String mauSac, String thongTinThem,
			KichThuoc kichThuoc) {
		super();
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
		this.mauSac = mauSac;
		this.thongTinThem = thongTinThem;
		this.kichThuoc = kichThuoc;
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
	public void setNguonGocXuatXu(String nguonGocXuatXu) {
		this.nguonGocXuatXu = nguonGocXuatXu;
	}
	public String getCongTySanXuat() {
		return congTySanXuat;
	}
	public void setCongTySanXuat(String congTySanXuat) {
		this.congTySanXuat = congTySanXuat;
	}
	public String getMauSac() {
		return mauSac;
	}
	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}
	public String getThongTinThem() {
		return thongTinThem;
	}
	public void setThongTinThem(String thongTinThem) {
		this.thongTinThem = thongTinThem;
	}
	public KichThuoc getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(KichThuoc kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	@Override
	public String toString() {
		return "MieuTa [id=" + id + ", nguonGocXuatXu=" + nguonGocXuatXu + ", congTySanXuat=" + congTySanXuat
				+ ", mauSac=" + mauSac + ", thongTinThem=" + thongTinThem + ", kichThuoc=" + kichThuoc + "]";
	}


}
