package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.DAO.CongViecDAO;
import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.KhachHang;
import com.agency.model.ThoCongViec;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.KhachHangServiceRepositoryImplement;


public class TestService {
		public static void main(String[] args) {
			System.out.println("In test service");
			KhachHangServiceRepository khachHangService = new KhachHangServiceRepositoryImplement();
			CongViecServiceRepository congViecService = new CongViecServiceRepositoryImplement();
	
			System.out.println("Get ALL");
			System.out.println(congViecService.getAll());
			
		
	}
}
