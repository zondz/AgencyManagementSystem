package com.agency.service;

import java.time.LocalDate;

import com.agency.model.HoaDonXuatHang;

public interface HoaDonXuatHangServiceRepository extends GenericServiceRepository<Integer, HoaDonXuatHang> {

	HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet);

//	HoaDonXuatHang setUpHoaDonXuatHang(HoaDonXuatHangDTO hoaDonXuatHang);
}
