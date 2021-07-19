package com.agency.ui;

import com.agency.model.DonViTinh;
import com.agency.model.KichThuoc;
import com.agency.model.LoaiHang;
import com.agency.model.LoaiNguon;
import com.agency.model.MatHang;
import com.agency.model.MieuTa;
import com.agency.model.NhaCungCap;
import com.agency.model.Origin;
import com.agency.service.MatHangServiceRepository;
import com.agency.serviceimplement.MatHangServiceRepositoryImplement;


public class TestService {
		public static void main(String[] args) {
			System.out.println("In test service");
			MatHangServiceRepository matHangService = new MatHangServiceRepositoryImplement();

			//**************************************************
			System.out.println("delete mot mat hang");
			matHangService.deleteById(1);
			
			
		}
}
