package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.HoaDonXuatHangServiceRepositoryImplement;


public class TestService {
		public static void main(String[] args) {
			System.out.println("In test service");
			CongViecServiceRepository congViecService = new CongViecServiceRepositoryImplement();
			System.out.println("Get ALL");
			System.out.println(congViecService.getAll());
			
			
	}
}
