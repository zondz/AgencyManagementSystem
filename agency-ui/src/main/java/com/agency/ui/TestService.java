package com.agency.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.CongViec;
import com.agency.model.DonViTinh;
import com.agency.model.HoaDonMuaHang;
import com.agency.model.HoaDonMuaHangOrderLine;
import com.agency.model.KhachHang;
import com.agency.model.LoaiNguon;
import com.agency.model.NguonCungCap;
import com.agency.model.Tho;
import com.agency.model.ThoCongViec;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonMuaHangServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.NguonCungCapServiceRepository;
import com.agency.service.ThoCongViecServiceRepository;
import com.agency.service.ThoServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.HoaDonMuaHangServiceRepositoryImplement;
import com.agency.serviceimplement.KhachHangServiceRepositoryImplement;
import com.agency.serviceimplement.NguonCungCapServiceRepositoryImplement;
import com.agency.serviceimplement.ThoCongViecServiceRepositoryImplement;
import com.agency.serviceimplement.ThoServiceRepositoryImplement;

public class TestService {
	HoaDonMuaHangServiceRepository service = new HoaDonMuaHangServiceRepositoryImplement();
	public static void main(String[] args) {

		
		System.out.println("Running in test service");
		TestService temp = new TestService();
		//int idHoaDon, int idMatHang, DonViTinh donViTinh, int soLuong, double donGia
		
		List<HoaDonMuaHangOrderLine> list = new ArrayList<HoaDonMuaHangOrderLine>();
		
		HoaDonMuaHangOrderLine l1 = new HoaDonMuaHangOrderLine(0, 0, DonViTinh.mét, 2, 20000);
		HoaDonMuaHangOrderLine l2 = new HoaDonMuaHangOrderLine(0, 0, DonViTinh.mét, 3, 20000);

		list.add(l1);
		list.add(l2);
		HoaDonMuaHang hdmh = new HoaDonMuaHang(1,50000,20000,list);
		System.out.println("Add a HoaDonMuaHang");
		temp.service.add(hdmh);
		
//		System.out.println("Get all");
//		System.out.println(temp.service.getAll());
//
//		System.out.println("Get by id");
//		System.out.println(temp.service.getById(3));
//		ThoCongViec thoCongViec;
//		System.out.println("delete by id mot tho cong viec");
//
//		temp.service.deleteById(4);

	
		
	}
	
}
