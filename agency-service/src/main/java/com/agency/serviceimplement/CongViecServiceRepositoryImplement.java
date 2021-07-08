package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.CongViec;
import com.agency.repository.CongViecRepository;
import com.agency.repository.implement.CongViecRepositoryImplement;
import com.agency.service.CongViecServiceRepository;

public class CongViecServiceRepositoryImplement implements CongViecServiceRepository {
	CongViecRepository congViecRepository ;
	
	public CongViecServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		congViecRepository = new CongViecRepositoryImplement();
	}
	
	
	// tested
	public List<CongViec> getAll() {
		// TODO Auto-generated method stub
		return (List<CongViec>) congViecRepository.getAll();
	}

	//tested
	public CongViec getById(Integer id) {
		// TODO Auto-generated method stub
		return congViecRepository.get(id);
	}

	// tested
	public void add(CongViec entity) {
		// TODO Auto-generated method stub
		congViecRepository.add(entity);
		
	}
	//tested
	public void update(CongViec entity) {
		congViecRepository.update(entity);
	}

	public void delete(CongViec entity) {
		
	}
	
	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		congViecRepository.deleteById(id);
		
	}

}
