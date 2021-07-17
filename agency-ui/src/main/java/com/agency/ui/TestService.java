package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.DAO.CongViecDAO;
import com.agency.DAO.HoaDonXuatHangDTO;
import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.KhachHang;
import com.agency.model.ThoCongViec;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.HoaDonXuatHangServiceRepositoryImplement;
import com.agency.serviceimplement.KhachHangServiceRepositoryImplement;


public class TestService {
		public static void main(String[] args) {
			System.out.println("In test service");
			HoaDonXuatHangServiceRepository hoaDonService = new HoaDonXuatHangServiceRepositoryImplement();
			KhachHangServiceRepository khachHangService = new KhachHangServiceRepositoryImplement();

			//**************************************************
		System.out.println(hoaDonService.findByIdKhacHangAndNgayViet(4, LocalDate.of(2021, 7, 14)));	;
			
		}
}
