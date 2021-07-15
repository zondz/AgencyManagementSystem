package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.MatHang;
import com.agency.repository.MatHangRepository;
import com.agency.repository.implement.MatHangRepositoryImplement;
import com.agency.service.MatHangServiceRepository;

public class MatHangServiceRepositoryImplement implements MatHangServiceRepository {
	MatHangRepository matHangRepository  ;
	public MatHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		matHangRepository = new MatHangRepositoryImplement();
	}
	@Override
	public List<MatHang> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatHang getById(Integer id) {
		// TODO Auto-generated method stub
		return matHangRepository.get(id);
	}

	@Override
	public void add(MatHang entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MatHang entity) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
