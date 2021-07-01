package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class KichThuoc implements Serializable {
public static final int MIN_CHU_VI = 0;
public static final int MIN_DIEN_TICH = 0;
public static final int MIN_DO_DAY = 0;
 private int id;
 private double chuVi;
 private double dienTich;
 private double doDay;
public KichThuoc() {
	super();
	// TODO Auto-generated constructor stub
	id = -1;
	chuVi = -1;
	dienTich = -1;
	doDay = -1;
	
}
public KichThuoc(Integer id, double chuVi, double dienTich, double doDay) throws InvalidAttributeValueException {
	super();
	if(!this.validateChuVi(chuVi)) {
		throw new InvalidAttributeValueException("sai thông tin chu vi: "+chuVi);
	}
	if(!this.validateDienTich(dienTich)) {
		throw new InvalidAttributeValueException("sai thông tin diện tích: "+dienTich);
	}
	if(!this.validateDoDay(doDay)) {
		throw new InvalidAttributeValueException("Sai thông tin độ dày : "+doDay);
	}
	
	this.id = id;
	this.chuVi = chuVi;
	this.dienTich = dienTich;
	this.doDay = doDay;
}
public KichThuoc(double chuVi, double dienTich, double doDay) throws InvalidAttributeValueException {
	super();
	if(!this.validateChuVi(chuVi)) {
		throw new InvalidAttributeValueException("sai thông tin chu vi: "+chuVi);
	}
	if(!this.validateDienTich(dienTich)) {
		throw new InvalidAttributeValueException("sai thông tin diện tích: "+dienTich);
	}
	if(!this.validateDoDay(doDay)) {
		throw new InvalidAttributeValueException("Sai thông tin độ dày : "+doDay);
	}
	
	this.chuVi = chuVi;
	this.dienTich = dienTich;
	this.doDay = doDay;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getChuVi() {
	return chuVi;
}
public void setChuVi(double chuVi) throws InvalidAttributeValueException {
	if(!this.validateChuVi(chuVi)) throw new InvalidAttributeValueException("Sai chu vi: "+chuVi);
	this.chuVi = chuVi;
}
public double getDienTich() {
	return dienTich;
}
public void setDienTich(double dienTich) throws InvalidAttributeValueException {
	if(!this.validateDienTich(dienTich)) throw new InvalidAttributeValueException("Sai diện tích: "+dienTich);
	this.dienTich = dienTich;
}
public double getDoDay() {
	return doDay;
}
public void setDoDay(double doDay) throws InvalidAttributeValueException {
	if(!this.validateDoDay(doDay)) throw new InvalidAttributeValueException("Sai độ dày: "+doDay);
	this.doDay = doDay;
}
protected boolean validateChuVi(double chuVi) {
	return chuVi >= MIN_CHU_VI;
}

protected boolean validateDienTich(double dienTich) {
	return dienTich >= MIN_DIEN_TICH;
}

protected boolean validateDoDay(double doDay) {
	return doDay>=MIN_DO_DAY;
}
 
 
 
}
