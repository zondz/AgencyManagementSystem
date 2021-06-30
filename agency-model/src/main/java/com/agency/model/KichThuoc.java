package com.agency.model;

import java.io.Serializable;

public class KichThuoc implements Serializable {
 private Integer id;
 private double chuVi;
 private double dienTich;
 private double doDay;
public KichThuoc() {
	super();
	// TODO Auto-generated constructor stub
}
public KichThuoc(Integer id, double chuVi, double dienTich, double doDay) {
	super();
	this.id = id;
	this.chuVi = chuVi;
	this.dienTich = dienTich;
	this.doDay = doDay;
}
public KichThuoc(double chuVi, double dienTich, double doDay) {
	super();
	this.chuVi = chuVi;
	this.dienTich = dienTich;
	this.doDay = doDay;
}
 
 
 
}
