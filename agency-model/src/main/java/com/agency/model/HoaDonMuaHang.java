package com.agency.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class HoaDonMuaHang implements Serializable {
	public static final int MIN_VAN_CHUYEN = 0;
	public static final int MIN_TONG_CONG = 0;
	public static final int MIN_DAT_TRUOC = 0;

	private int id;
	private int idKhachHang;
	// co can thiet khong ?
	private int vanChuyen;
	private double tongCong;
	private int datTruoc;
	private double conLai ;
	private List<HoaDonMuaHangOrderLine> orderLines;
	

	
	// day du lieu xuong database
	public HoaDonMuaHang(int idKhachHang, int vanChuyen, int datTruoc , List<HoaDonMuaHangOrderLine> orderLines
			) {
		super();
		
		this.idKhachHang = idKhachHang;
		this.orderLines = orderLines;
		this.vanChuyen = vanChuyen;
		this.datTruoc = datTruoc;
		this.tongCong = this.calTongCong();
		this.conLai = tongCong - datTruoc;
	}


	// lay du lieu len
	public HoaDonMuaHang(int id, int idKhachHang, int vanChuyen, double tongCong, int datTruoc, double conLai,
			List<HoaDonMuaHangOrderLine> orderLines) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.vanChuyen = vanChuyen;
		this.tongCong = tongCong;
		this.datTruoc = datTruoc;
		this.conLai = conLai;
		this.orderLines = orderLines;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	
	public int getVanChuyen() {
		return vanChuyen;
	}
	public void setVanChuyen(int vanChuyen) throws InvalidAttributeValueException {
		if(!this.validateVanChuyen(vanChuyen)) throw new InvalidAttributeValueException("Sai thông tin tiền vận chuyền: "+vanChuyen);
		this.vanChuyen = vanChuyen;
	}
	public double getTongCong() {
		return tongCong;
	}
	public void setTongCong(double tongCong) throws InvalidAttributeValueException {
		if(!this.validateTongCong(tongCong)) throw new InvalidAttributeValueException("Sai thông tin tổng cộng tiền: "+tongCong);
		//
		this.tongCong = tongCong;
	}
	public double getDatTruoc() {
		return datTruoc;
	}
	public void setDatTruoc(int datTruoc) throws InvalidAttributeValueException {
		if(!this.validateDatTruoc(datTruoc)) throw new InvalidAttributeValueException("Sai thông tin tiền đặt trước: "+datTruoc);
		this.datTruoc = datTruoc;
	}
	public double getConLai() {
		return conLai;
	}
	
	public List<HoaDonMuaHangOrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<HoaDonMuaHangOrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	// validate
	private double calTongCong() {
		double sum = 0 ;
		for(int i = 0 ; i < this.orderLines.size() ; i ++) {
			sum += this.orderLines.get(i).getThanhTien();
		}
		sum += this.vanChuyen;
		return sum;
		
	}
	
	protected boolean validateVanChuyen(int vanChuyen) {
		return vanChuyen>=MIN_VAN_CHUYEN;
	}
	protected boolean validateTongCong(double tongCong ) {
		return tongCong >= MIN_TONG_CONG;
	}
	
	protected boolean validateDatTruoc(int datTruoc) {
		return datTruoc>=MIN_DAT_TRUOC&&datTruoc<=this.tongCong;
	}


	@Override
	public String toString() {
		return "HoaDonMuaHang [id=" + id + ", idKhachHang=" + idKhachHang + ", vanChuyen=" + vanChuyen + ", tongCong="
				+ tongCong + ", datTruoc=" + datTruoc + ", conLai=" + conLai + ", orderLines=" + orderLines + "]";
	}
	
	
	
}
