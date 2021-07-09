package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.KhachHang;
import com.agency.repository.KhachHangRepository;
import com.agency.repository.implement.KhachHangRepositoryImplement;
import com.agency.service.KhachHangServiceRepository;

public class KhachHangServiceRepositoryImplement implements KhachHangServiceRepository{
	KhachHangRepository khachHangRepository  = new KhachHangRepositoryImplement();
	
	// tested
	public List<KhachHang> getAll() {
		// TODO Auto-generated method stub
		return (List<KhachHang>) khachHangRepository.getAll();
	}
	// tested

	public KhachHang getById(Integer id) {
		// TODO Auto-generated method stub
		
		return khachHangRepository.get(id);
	}

	// tested
	public void add(KhachHang entity) {
		khachHangRepository.add(entity);
	}

	// tested
	public void update(KhachHang entity) {
		khachHangRepository.update(entity);
	}
	
	
	public void delete(KhachHang entity) {
		// TODO Auto-generated method stub
		
	}
	
	// tested
	public void deleteById(Integer id) {
		khachHangRepository.deleteById(id);
	}

}
