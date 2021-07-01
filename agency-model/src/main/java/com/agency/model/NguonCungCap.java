package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class NguonCungCap implements Serializable{
public static final int MAX_LENGTH_TEN = 50;
public static final int MIN_LENGTH_SO_DIEN_THOAI = 10;
public static final int MAX_LENGTH_SO_DIEN_THOAI = 11;
public static final int MAX_LENGTH_DIA_CHI = 50;
private int id;
private String ten;
private LoaiNguon loaiNguon;
private String soDienThoai;
private String diaChi;
public NguonCungCap() {
	super();
	// TODO Auto-generated constructor stub
}
public NguonCungCap(int id, String ten, LoaiNguon loaiNguon, String soDienThoai, String diaChi) throws InvalidAttributeValueException {
	super();
	if(!(this.validateTen(ten))){
		throw new InvalidAttributeValueException("Sai thông tin tên: "+ten);
	}
	if(!this.validateDiaChi(diaChi)) {
		throw new InvalidAttributeValueException("Sai thông tin địa chỉ: "+diaChi);
		
	}
	if(!this.validateSoDienThoai(soDienThoai)) {
		throw new InvalidAttributeValueException("Sai thông tin số điện thoại: "+soDienThoai);
	}
	this.id = id;
	this.ten = ten;
	this.loaiNguon = loaiNguon;
	this.soDienThoai = soDienThoai;
	this.diaChi = diaChi;
}
public NguonCungCap(String ten, LoaiNguon loaiNguon, String soDienThoai, String diaChi) throws InvalidAttributeValueException {
	super();
	if(!(this.validateTen(ten))){
		throw new InvalidAttributeValueException("Sai thông tin tên: "+ten);
	}
	if(!this.validateDiaChi(diaChi)) {
		throw new InvalidAttributeValueException("Sai thông tin địa chỉ: "+diaChi);
		
	}
	if(!this.validateSoDienThoai(soDienThoai)) {
		throw new InvalidAttributeValueException("Sai thông tin số điện thoại: "+soDienThoai);
	}
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
public void setTen(String ten) throws InvalidAttributeValueException {
	if(!this.validateTen(ten)) throw new InvalidAttributeValueException("Tên không hợp lệ: "+ten);
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
public void setSoDienThoai(String soDienThoai) throws InvalidAttributeValueException {
	if(!this.validateSoDienThoai(soDienThoai)) throw new InvalidAttributeValueException("Số điện thoại không hợp lệ: "+soDienThoai);
	this.soDienThoai = soDienThoai;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) throws InvalidAttributeValueException {
	if(!this.validateDiaChi(diaChi)) throw new InvalidAttributeValueException("Địa chỉ không hợp lệ: "+diaChi);
	this.diaChi = diaChi;
}

protected boolean validateTen(String ten) {
	return ten!=null&&ten.length()<=MAX_LENGTH_TEN;
}
protected boolean validateSoDienThoai(String soDienThoai) {
	return soDienThoai!=null&&soDienThoai.length()<=MAX_LENGTH_SO_DIEN_THOAI;
}
protected boolean validateDiaChi(String diaChi) {
	return diaChi!=null&&diaChi.length()<=MAX_LENGTH_DIA_CHI;
}
@Override
public String toString() {
	return "NguonCungCap [id=" + id + ", ten=" + ten + ", loaiNguon=" + loaiNguon + ", soDienThoai=" + soDienThoai
			+ ", diaChi=" + diaChi + "]";
}

}
