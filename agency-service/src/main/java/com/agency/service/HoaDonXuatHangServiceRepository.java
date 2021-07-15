package com.agency.service;

import java.time.LocalDate;

import com.agency.model.HoaDonXuatHang;

public interface HoaDonXuatHangServiceRepository  extends GenericServiceRepository<Integer,HoaDonXuatHang>{

	HoaDonXuatHang getLastRecord();

	HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet);

}
