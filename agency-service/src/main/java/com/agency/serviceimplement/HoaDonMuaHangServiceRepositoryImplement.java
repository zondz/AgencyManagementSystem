package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.HoaDonMuaHang;
import com.agency.repository.HoaDonMuaHangRepository;
import com.agency.repository.implement.HoaDonMuaHangRepositoryImplement;
import com.agency.service.HoaDonMuaHangServiceRepository;

public class HoaDonMuaHangServiceRepositoryImplement implements HoaDonMuaHangServiceRepository{
	HoaDonMuaHangRepository hoaDonMuaHangRepository;
	
	public HoaDonMuaHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		hoaDonMuaHangRepository = new HoaDonMuaHangRepositoryImplement();
	}
	public List<HoaDonMuaHang> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public HoaDonMuaHang getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// dang o day
	public void add(HoaDonMuaHang entity) {
		
		
		hoaDonMuaHangRepository.add(entity);
	}

	public void update(HoaDonMuaHang entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(HoaDonMuaHang entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
