package com.agency.model;

import java.io.Serializable;

public class Tho implements Serializable{
private int id;
private String ten;
private String soDienThoai;
public Tho(int id, String ten, String soDienThoai) {
	super();
	this.id = id;
	this.ten = ten;
	this.soDienThoai = soDienThoai;
}
public Tho(String ten, String soDienThoai) {
	super();
	this.ten = ten;
	this.soDienThoai = soDienThoai;
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
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
@Override
public String toString() {
	return "Tho [id=" + id + ", ten=" + ten + ", soDienThoai=" + soDienThoai + "]";
}

}
