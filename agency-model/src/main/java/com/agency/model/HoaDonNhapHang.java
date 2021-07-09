package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class HoaDonNhapHang implements Serializable{

private int id;
private int idNguonCungCap;
List<HoaDonNhapHangOrderLine> orderLines;
private LocalDate ngayCungCap;
private double tongTien;

public HoaDonNhapHang(int idNguonCungCap, List<HoaDonNhapHangOrderLine> orderLines, LocalDate ngayCungCap,
		double tongTien) {
	super();
	this.idNguonCungCap = idNguonCungCap;
	this.orderLines = orderLines;
	this.ngayCungCap = ngayCungCap;
	this.tongTien = tongTien;
}
public HoaDonNhapHang(int id, int idNguonCungCap, List<HoaDonNhapHangOrderLine> orderLines, LocalDate ngayCungCap,
		double tongTien) {
	super();
	this.id = id;
	this.idNguonCungCap = idNguonCungCap;
	this.orderLines = orderLines;
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

public List<HoaDonNhapHangOrderLine> getOrderLines() {
	return orderLines;
}
public void setOrderLines(List<HoaDonNhapHangOrderLine> orderLines) {
	this.orderLines = orderLines;
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
	return "HoaDonNhapHang [id=" + id + ", idNguonCungCap=" + idNguonCungCap + ", orderLines=" + orderLines
			+ ", ngayCungCap=" + ngayCungCap + ", tongTien=" + tongTien + "]";
}


}
