package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.serviceimplement.HoaDonXuatHangServiceRepositoryImplement;


public class TestService {
	
	HoaDonXuatHangServiceRepository hoaDon  = new HoaDonXuatHangServiceRepositoryImplement();
	public static void main(String[] args) {
		System.out.println("In Test Service");
		TestService test = new TestService();
		System.out.println("get all Hoa Don Xuat Hang");
//		HoaDonXuatHangOrderLine orderLine = new HoaDonXuatHangOrderLine();
//		List<HoaDonXuatHangOrderLine> list = new ArrayList<HoaDonXuatHangOrderLine>();
//		list.add(orderLine);
//		HoaDonXuatHang hoaDon1  = new HoaDonXuatHang(1,50000,20000,10000,list);
	//	test.hoaDon.add(hoaDon1);
		System.out.println(test.hoaDon.getAll());;
		System.out.println("Get By id");
		System.out.println(test.hoaDon.getById(2));
		System.out.println("delete a hoa Don");
//		HoaDonXuatHang hdxh = test.hoaDon.getById(2);
//		hdxh.setGiamGia(0);
		test.hoaDon.deleteById(2);
		
	}
}
