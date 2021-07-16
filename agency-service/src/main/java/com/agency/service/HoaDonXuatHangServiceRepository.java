package com.agency.service;

import java.time.LocalDate;

import com.agency.DAO.HoaDonXuatHangDTO;
import com.agency.model.HoaDonXuatHang;

public interface HoaDonXuatHangServiceRepository  extends GenericServiceRepository<Integer,HoaDonXuatHangDTO>{



	HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet);
	HoaDonXuatHang setUpHoaDonXuatHang(HoaDonXuatHangDTO hoaDonXuatHang);
}
