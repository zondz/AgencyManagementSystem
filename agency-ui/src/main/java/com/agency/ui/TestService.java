package com.agency.ui;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.CongViec;
import com.agency.model.KhachHang;
import com.agency.model.LoaiNguon;
import com.agency.model.NguonCungCap;
import com.agency.model.Tho;
import com.agency.model.ThoCongViec;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.NguonCungCapServiceRepository;
import com.agency.service.ThoCongViecServiceRepository;
import com.agency.service.ThoServiceRepository;
import com.agency.serviceimplement.CongViecServiceRepositoryImplement;
import com.agency.serviceimplement.KhachHangServiceRepositoryImplement;
import com.agency.serviceimplement.NguonCungCapServiceRepositoryImplement;
import com.agency.serviceimplement.ThoCongViecServiceRepositoryImplement;
import com.agency.serviceimplement.ThoServiceRepositoryImplement;

public class TestService {
	ThoCongViecServiceRepository service = new ThoCongViecServiceRepositoryImplement();
	public static void main(String[] args) {
		System.out.println("Running in test service");
		TestService temp = new TestService();
		System.out.println("Get all");
		System.out.println(temp.service.getAll());

		System.out.println("Get by id");
		System.out.println(temp.service.getById(3));
		ThoCongViec thoCongViec;
		System.out.println("delete by id mot tho cong viec");

		temp.service.deleteById(4);

	
		
	}
	
}
