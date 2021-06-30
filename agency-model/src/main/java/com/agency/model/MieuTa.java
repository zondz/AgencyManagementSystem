package com.agency.model;

import java.io.Serializable;

public class MieuTa implements Serializable{
	private int id;
	private String nguonGocXuatXu;
	private String congTySanXuat;
	private String mauSac;
	private String thongTinThem;
	private int idKickThuoc;

	public MieuTa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MieuTa(int id, String nguonGocXuatXu, String congTySanXuat, String mauSac, String thongTinThem,
			int idKickThuoc) {
		super();
		this.id = id;
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
		this.mauSac = mauSac;
		this.thongTinThem = thongTinThem;
		this.idKickThuoc = idKickThuoc;
	}

	@Override
	public String toString() {
		return "MieuTa [id=" + id + ", nguonGocXuatXu=" + nguonGocXuatXu + ", congTySanXuat=" + congTySanXuat
				+ ", mauSac=" + mauSac + ", thongTinThem=" + thongTinThem + ", idKickThuoc=" + idKickThuoc + "]";
	}

}
