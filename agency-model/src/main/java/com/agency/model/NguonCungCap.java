package com.agency.model;

import java.io.Serializable;

public class NguonCungCap implements Serializable{
private int id;
private String ten;
private LoaiNguon loaiNguon;
private String soDienThoai;
private String diaChi;
public NguonCungCap() {
	super();
	// TODO Auto-generated constructor stub
}
public NguonCungCap(int id, String ten, LoaiNguon loaiNguon, String soDienThoai, String diaChi) {
	super();
	this.id = id;
	this.ten = ten;
	this.loaiNguon = loaiNguon;
	this.soDienThoai = soDienThoai;
	this.diaChi = diaChi;
}
public NguonCungCap(String ten, LoaiNguon loaiNguon, String soDienThoai, String diaChi) {
	super();
	this.ten = ten;
	this.loaiNguon = loaiNguon;
	this.soDienThoai = soDienThoai;
	this.diaChi = diaChi;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public LoaiNguon getLoaiNguon() {
	return loaiNguon;
}
public void setLoaiNguon(LoaiNguon loaiNguon) {
	this.loaiNguon = loaiNguon;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
@Override
public String toString() {
	return "NguonCungCap [id=" + id + ", ten=" + ten + ", loaiNguon=" + loaiNguon + ", soDienThoai=" + soDienThoai
			+ ", diaChi=" + diaChi + "]";
}

}
