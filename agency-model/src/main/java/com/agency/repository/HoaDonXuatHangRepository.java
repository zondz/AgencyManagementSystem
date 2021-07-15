package com.agency.repository;

import java.time.LocalDate;

import com.agency.model.HoaDonXuatHang;

public interface HoaDonXuatHangRepository extends GenericRepository<Integer,HoaDonXuatHang>{
	HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet);
}
