package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonNhapHang;
import com.agency.model.HoaDonNhapHangOrderLine;
import com.agency.repository.HoaDonNhapHangOrderLineRepository;
import com.agency.repository.implement.HoaDonNhapHangOrderLineRepositoryImplement;
import com.agency.service.HoaDonNhapHangServiceRepository;
import com.agency.serviceimplement.HoaDonNhapHangServiceRepositoryImplement;
import com.agency.serviceimplement.MatHangServiceRepositoryImplement;


public class TestService {
		public static void main(String[] args) {
			System.out.println("In test service");
			HoaDonNhapHangServiceRepository hoaDonService = new HoaDonNhapHangServiceRepositoryImplement();
			MatHangServiceRepositoryImplement matHangService = new MatHangServiceRepositoryImplement();
			HoaDonNhapHangOrderLineRepository orderLineRepository = new HoaDonNhapHangOrderLineRepositoryImplement();
			
		System.out.println(hoaDonService.getAll());
			
			
			
			
			
		}
}
