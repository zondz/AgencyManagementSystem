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
		HoaDonXuatHangServiceRepository hoaDonService = new HoaDonXuatHangServiceRepositoryImplement();

		// **************************************************
		// can dien don gia
		HoaDonXuatHangOrderLine orderLine1 = new HoaDonXuatHangOrderLine(1, 2, 0, 100000);
		HoaDonXuatHangOrderLine orderLine2 = new HoaDonXuatHangOrderLine(1, 2, 0, 100000);
		List<HoaDonXuatHangOrderLine> orderLines = new ArrayList<HoaDonXuatHangOrderLine>();
		orderLines.add(orderLine2);
		orderLines.add(orderLine1);

		HoaDonXuatHang hoaDonXuatHang = new HoaDonXuatHang(1, 100000, 2000000, 50000, LocalDate.of(2021, 7, 17),
				orderLines);

	}
}
