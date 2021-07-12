package com.agency.repository.implement;

import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonNhapHangOrderLine;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonNhapHangOrderLineRepository;

public class HoaDonNhapHangOrderLineRepositoryImplement implements HoaDonNhapHangOrderLineRepository{
	Database database;
	
	public HoaDonNhapHangOrderLineRepositoryImplement() {
		database  = Database.getInstance();
	}
	@Override
	public Iterable<HoaDonNhapHangOrderLine> getAll() {
		List<HoaDonNhapHangOrderLine> list = new ArrayList<>();
		String vSQL = "SELECT * FROM HoaDonNhapHangOrderLine";
		
		return null;
	}

	@Override
	public HoaDonNhapHangOrderLine get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(HoaDonNhapHangOrderLine entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HoaDonNhapHangOrderLine entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
