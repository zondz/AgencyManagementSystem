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
			KhachHangServiceRepository khachHangService = new KhachHangServiceRepositoryImplement();
			CongViecServiceRepository congViecService = new CongViecServiceRepositoryImplement();
			HoaDonXuatHangServiceRepository hoaDonService = new HoaDonXuatHangServiceRepositoryImplement();
//	
//			System.out.println("Get By Id");
//			System.out.println(congViecService.getById(1));			
//			
//			
			// view gửi xuống
			
//			KhachHang khachHang = new KhachHang("khachHang3","01232564646","diaChi3");
//			HoaDonXuatHangOrderLine order1 = new HoaDonXuatHangOrderLine(1, 2, 70000);
//			HoaDonXuatHangOrderLine order2 = new HoaDonXuatHangOrderLine(1, 2, 70000);
//			List<HoaDonXuatHangOrderLine> orderLines = new ArrayList<HoaDonXuatHangOrderLine>();
//			orderLines.add(order2);
//			orderLines.add(order1);
//			HoaDonXuatHang hoaDonXuatHang = new HoaDonXuatHang(50000,20000,10000,LocalDate.of(2021, 7, 14),orderLines);
//		
//			List<ThoCongViec> thoCongViecList= new ArrayList<ThoCongViec>();
//			ThoCongViec thoCongViec1 = new ThoCongViec(1,500000);
//			ThoCongViec thoCongViec2 = new ThoCongViec(2,500000);
//			thoCongViecList.add(thoCongViec1);
//			thoCongViecList.add(thoCongViec2);
//			CongViec congViec = new CongViec("Công việc mẫu",LocalDate.of(2021, 7, 14));
//			
//			CongViecDAO congViecDAO = new CongViecDAO(congViec,thoCongViecList,hoaDonXuatHang,khachHang);
//			// chua test
//			congViecService.add(congViecDAO);	
//			
			//************************************************************************
//			HoaDonXuatHangDTO hoaDonDTO = hoaDonService.getById(1);
//			KhachHang khachHang = new KhachHang("khachhang4","0912011951","63 truong chinh");
//			
//			HoaDonXuatHang hoaDonXuatHang = hoaDonDTO.getHoaDonXuatHang();
//			hoaDonXuatHang.setDatTruoc(1000000);
//			List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHang.getOrderLines();
//			// fake
//			for(HoaDonXuatHangOrderLine orderLine : orderLines) {
//				System.out.println(orderLine);
//				orderLine.setGiaKhong(0);
//				orderLine.setSoLuong(3);
//			}
//			hoaDonXuatHang.setNgayViet(LocalDate.of(2022, 1, 1));
//			CongViecDAO congViecDAO = congViecService.getById(1);
//			CongViec congViec = congViecDAO.getCongViec();
//			congViec.setTenCongViec("ten cong viec updated");
//			List<ThoCongViec> thoCongViecList = congViecDAO.getThoCongViecList();
//			for(ThoCongViec temp : thoCongViecList) {
//				temp.setCongTho(200000);
//			}
//			CongViecDAO congViecDAOUpdate = new CongViecDAO(congViec,thoCongViecList,hoaDonXuatHang,khachHang);
//
//			congViecService.update(congViecDAOUpdate);

			//**************************************************
			congViecService.deleteById(1);
			

		}
}
