package com.agency.ui;

import com.agency.repository.HoaDonXuatHangRepository;
import com.agency.repository.implement.HoaDonXuatHangRepositoryImplement;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.service.MatHangServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.HoaDonXuatHangServiceRepositoryImplement;
import com.agency.serviceimplement.MatHangServiceRepositoryImplement;

public class TestService {
	public static void main(String[] args) {
		System.out.println("In test service");

		CongViecServiceRepository congViecService = new CongViecServiceRepositoryImplement();
		HoaDonXuatHangServiceRepository hoaDonService = new HoaDonXuatHangServiceRepositoryImplement();
		MatHangServiceRepository matHangServiceRepository = new MatHangServiceRepositoryImplement();
		HoaDonXuatHangRepository hoaDonRepository = new HoaDonXuatHangRepositoryImplement();

		hoaDonService.deleteById(3);

		// hoaDonXuatHang.setOrderLines(orderLines);
		// try {
		//// hoaDonService.update(hoaDonXuatHang);
		// } catch (InvalidAttributeValueException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}
