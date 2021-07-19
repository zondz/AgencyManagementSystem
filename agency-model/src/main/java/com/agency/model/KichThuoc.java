package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class KichThuoc implements Serializable {
public static final int MIN_CHU_VI = 0;
public static final int MIN_DIEN_TICH = 0;
public static final int MIN_DO_DAY = 0;
 private int id;
 private int idMieuTa;
 private double chuVi = -1;
 private double dienTich = -1;
 private double doDay = -1;

// add view
public KichThuoc(double chuVi, double dienTich, double doDay) {
	super();
	this.chuVi = chuVi;
	this.dienTich = dienTich;
	this.doDay = doDay;
}
public KichThuoc(int id, int idMieuTa, double chuVi, double dienTich, double doDay) {
	super();
	this.id = id;
	this.idMieuTa = idMieuTa;
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


public int getIdMieuTa() {
	return idMieuTa;
}
public void setIdMieuTa(int idMieuTa) {
	this.idMieuTa = idMieuTa;
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
@Override
public String toString() {
	return "KichThuoc [id=" + id + ", idMieuTa=" + idMieuTa + ", chuVi=" + chuVi + ", dienTich=" + dienTich + ", doDay="
			+ doDay + "]";
}
 
 
 
}
