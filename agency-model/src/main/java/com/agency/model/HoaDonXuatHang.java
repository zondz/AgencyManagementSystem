package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;

public class HoaDonXuatHang implements Serializable{
private int id;
private int idNguonCungCap;
private LocalDate ngayCungCap;
private double tongTien;
public HoaDonXuatHang() {
	super();
	// TODO Auto-generated constructor stub
}
public HoaDonXuatHang(int id, int idNguonCungCap, LocalDate ngayCungCap, double tongTien) {
	super();
	this.id = id;
	this.idNguonCungCap = idNguonCungCap;
	this.ngayCungCap = ngayCungCap;
	this.tongTien = tongTien;
}
public HoaDonXuatHang(int idNguonCungCap, LocalDate ngayCungCap, double tongTien) {
	super();
	this.idNguonCungCap = idNguonCungCap;
	this.ngayCungCap = ngayCungCap;
	this.tongTien = tongTien;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdNguonCungCap() {
	return idNguonCungCap;
}
public void setIdNguonCungCap(int idNguonCungCap) {
	this.idNguonCungCap = idNguonCungCap;
}
public LocalDate getNgayCungCap() {
	return ngayCungCap;
}
public void setNgayCungCap(LocalDate ngayCungCap) {
	this.ngayCungCap = ngayCungCap;
}
public double getTongTien() {
	return tongTien;
}
public void setTongTien(double tongTien) {
	this.tongTien = tongTien;
}
@Override
public String toString() {
	return "HoaDonXuatHang [id=" + id + ", idNguonCungCap=" + idNguonCungCap + ", ngayCungCap=" + ngayCungCap
			+ ", tongTien=" + tongTien + "]";
}


	
	
}
