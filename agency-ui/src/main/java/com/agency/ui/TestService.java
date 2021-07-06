package com.agency.ui;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.KhachHang;
import com.agency.model.LoaiNguon;
import com.agency.model.NguonCungCap;
import com.agency.model.Tho;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.NguonCungCapServiceRepository;
import com.agency.service.ThoServiceRepository;
import com.agency.serviceimplement.KhachHangServiceRepositoryImplement;
import com.agency.serviceimplement.NguonCungCapServiceRepositoryImplement;
import com.agency.serviceimplement.ThoServiceRepositoryImplement;

public class TestService {
	NguonCungCapServiceRepository service = new NguonCungCapServiceRepositoryImplement();
	public static void main(String[] args) {
		System.out.println("Running in test service");
		TestService temp = new TestService();
		System.out.println("Get all");
		System.out.println(temp.service.getAll());

		System.out.println("Get by id");
		System.out.println(temp.service.getById(1));
		
		System.out.println("delete a Nguon Cung Cap by id");
		temp.service.deleteById(4);
		
	
		
	}
	
}
