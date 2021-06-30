package com.agency.model;

import java.io.Serializable;

public class KhachHang implements Serializable {
private int id;
private String tenKhachHang;
private String soDienThoai;
private String address;
public KhachHang() {
	super();
	// TODO Auto-generated constructor stub
}
public KhachHang(int id, String tenKhachHang, String soDienThoai, String address) {
	super();
	this.id = id;
	this.tenKhachHang = tenKhachHang;
	this.soDienThoai = soDienThoai;
	this.address = address;
}
public KhachHang(String tenKhachHang, String soDienThoai, String address) {
	super();
	this.tenKhachHang = tenKhachHang;
	this.soDienThoai = soDienThoai;
	this.address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTenKhachHang() {
	return tenKhachHang;
}
public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "KhachHang [id=" + id + ", tenKhachHang=" + tenKhachHang + ", soDienThoai=" + soDienThoai + ", address="
			+ address + "]";
}

}
