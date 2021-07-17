package com.agency.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class HoaDonXuatHang implements Serializable {
	public static final int MIN_VAN_CHUYEN = 0;
	public static final int MIN_TONG_CONG = 0;
	public static final int MIN_DAT_TRUOC = 0;

	private int id;
	private int idKhachHang;
	private int vanChuyen;
	private double tongCong;
	private int datTruoc;
	private int giamGia;
	private double conLai ;
	private TrangThaiHoaDon trangThaiHoaDon;
	private LocalDate ngayViet;

	private List<HoaDonXuatHangOrderLine> orderLines;
	

	
	public HoaDonXuatHang(int id, int idKhachHang, int vanChuyen, int datTruoc, int giamGia,
			TrangThaiHoaDon trangThaiHoaDon,  LocalDate ngayViet) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.vanChuyen = vanChuyen;
		this.datTruoc = datTruoc;
		this.giamGia = giamGia;
		this.trangThaiHoaDon = trangThaiHoaDon;
		
	}


	// view

	public HoaDonXuatHang(int vanChuyen, int datTruoc, int giamGia,
			LocalDate ngayViet , List<HoaDonXuatHangOrderLine> orderLines) {
		super();
		this.vanChuyen = vanChuyen;
		this.datTruoc = datTruoc;
		this.giamGia = giamGia;
		this.ngayViet = ngayViet;
		this.orderLines = orderLines;
		// không tính ở đây
//		this.tongCong = this.calTongCong();
//		this.conLai = this.tongCong - this.datTruoc-giamGia;
//		if(conLai < this.tongCong) {
//			this.trangThaiHoaDon = TrangThaiHoaDon.CònNợ;
//		}
//		else {
//			this.trangThaiHoaDon = TrangThaiHoaDon.ĐãThanhToán;
//		}
		
	}




	// day du lieu xuong database
	public HoaDonXuatHang(int idKhachHang, int vanChuyen, int datTruoc ,int giamGia, List<HoaDonXuatHangOrderLine> orderLines
			) {
		super();
		
		this.idKhachHang = idKhachHang;
		this.orderLines = orderLines;
		this.vanChuyen = vanChuyen;
		this.datTruoc = datTruoc;
		this.tongCong = this.calTongCong();
		this.giamGia = giamGia;
		this.conLai = tongCong - giamGia - datTruoc;
		if(this.conLai>0) {
			this.trangThaiHoaDon =TrangThaiHoaDon.CònNợ;
		}
		else {
			this.trangThaiHoaDon = TrangThaiHoaDon.ĐãThanhToán;
		}
	
	}
	
	
	

	// lay du lieu len
	public HoaDonXuatHang(int id, int idKhachHang, int vanChuyen,List<HoaDonXuatHangOrderLine> orderLines,int giamGia, int datTruoc,LocalDate ngayViet
			) {
		super();
		this.id = id;
		this.idKhachHang = idKhachHang;
		this.vanChuyen = vanChuyen;
		this.orderLines = orderLines;
	
		this.giamGia = giamGia;
		this.datTruoc = datTruoc;	
		this.ngayViet = ngayViet;
		
	}

	

	public LocalDate getNgayViet() {
		return ngayViet;
	}




	public void setNgayViet(LocalDate ngayViet) {
		this.ngayViet = ngayViet;
	}




	public int getGiamGia() {
		return giamGia;
	}


	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}


	public TrangThaiHoaDon getTrangThaiHoaDon() {
		return trangThaiHoaDon;
	}


	public void setTrangThaiHoaDon(TrangThaiHoaDon trangThaiHoaDon) {
		this.trangThaiHoaDon = trangThaiHoaDon;
	}


	public void setConLai(double conLai) {
		this.conLai = conLai;
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
	public void setTongCong(double tongCong)  {
		this.tongCong = tongCong;
	}
	public double getDatTruoc() {
		return datTruoc;
	}
	public void setDatTruoc(int datTruoc)  {
		this.datTruoc = datTruoc;
	}
	public double getConLai() {
		return conLai;
	}
	
	public List<HoaDonXuatHangOrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(List<HoaDonXuatHangOrderLine> orderLines) {
		
		
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
		return "HoaDonXuatHang [id=" + id + ", idKhachHang=" + idKhachHang + ", vanChuyen=" + vanChuyen + ", tongCong="
				+ tongCong + ", datTruoc=" + datTruoc + ", giamGia=" + giamGia + ", conLai=" + conLai
				+ ", trangThaiHoaDon=" + trangThaiHoaDon + ", orderLines=" + orderLines + "]";
	}



	
	
}
