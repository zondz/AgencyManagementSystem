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
	private String tenKhachHang;
	private String soDienThoai;
	private String diaChi;
	//
	private int vanChuyen;
	private double tongCong;
	private int datTruoc;
	private double conLai = tongCong-datTruoc;
	private List<HoaDonMuaHangOrderLine> orderLines;
	public HoaDonMuaHang(int id, int idKhachHang, String tenKhachHang, String soDienThoai, String diaChi, int vanChuyen,
			double tongCong, int datTruoc, double conLai) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.vanChuyen = vanChuyen;
		this.tongCong = tongCong;
		this.datTruoc = datTruoc;
		this.conLai = conLai;
		this.orderLines = new ArrayList<HoaDonMuaHangOrderLine>();
	}
	public HoaDonMuaHang(int idKhachHang, String tenKhachHang, String soDienThoai, String diaChi, int vanChuyen,
			double tongCong, int datTruoc, double conLai) {
		super();
		this.idKhachHang = idKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.vanChuyen = vanChuyen;
		this.tongCong = tongCong;
		this.datTruoc = datTruoc;
		this.conLai = conLai;
		this.orderLines = new ArrayList<HoaDonMuaHangOrderLine>();
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
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
		return "HoaDonMuaHang [id=" + id + ", idKhachHang=" + idKhachHang + ", tenKhachHang=" + tenKhachHang
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", vanChuyen=" + vanChuyen + ", tongCong="
				+ tongCong + ", datTruoc=" + datTruoc + ", conLai=" + conLai + ", orderLines=" + orderLines + "]";
	}
	
	
	
	
}
