package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class HoaDonNhapHang implements Serializable{

private int id;
private int idNhaCungCap;
List<HoaDonNhapHangOrderLine> orderLines;
private LocalDate ngayCungCap;
private double tongTien;

public HoaDonNhapHang(int idNhaCungCap, List<HoaDonNhapHangOrderLine> orderLines, LocalDate ngayCungCap,
		double tongTien) {
	super();
	this.idNhaCungCap = idNhaCungCap;
	this.orderLines = orderLines;
	this.ngayCungCap = ngayCungCap;
	this.tongTien = this.calculateTongTien(orderLines);
}
public HoaDonNhapHang(int id, int idNhaCungCap, List<HoaDonNhapHangOrderLine> orderLines, LocalDate ngayCungCap,
		double tongTien) {
	super();
	this.id = id;
	this.idNhaCungCap = idNhaCungCap;
	this.orderLines = orderLines;
	this.ngayCungCap = ngayCungCap;
	this.tongTien = this.calculateTongTien(orderLines);
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getidNhaCungCap() {
	return idNhaCungCap;
}
public void setidNhaCungCap(int idNhaCungCap) {
	this.idNhaCungCap = idNhaCungCap;
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

private double calculateTongTien( List<HoaDonNhapHangOrderLine> orderLines) {
	double sum = 0; 
	for(HoaDonNhapHangOrderLine temp : orderLines) {
		sum += temp.getThanhTien();
	}
	return sum;
}

@Override
public String toString() {
	return "HoaDonNhapHang [id=" + id + ", idNhaCungCap=" + idNhaCungCap + ", orderLines=" + orderLines
			+ ", ngayCungCap=" + ngayCungCap + ", tongTien=" + tongTien + "]";
}


}
