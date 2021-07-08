package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.ThoCongViec;
import com.agency.repository.ThoCongViecRepository;
import com.agency.repository.implement.ThoCongViecRepositoryImplement;
import com.agency.service.ThoCongViecServiceRepository;

public class ThoCongViecServiceRepositoryImplement implements ThoCongViecServiceRepository{
	ThoCongViecRepository thoCongViecRepository ;
	public ThoCongViecServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		thoCongViecRepository = new ThoCongViecRepositoryImplement();
	}
	
	
	//tested
	public List<ThoCongViec> getAll() {
		// TODO Auto-generated method stub
		return (List<ThoCongViec>) thoCongViecRepository.getAll();
	}

	// tested
	public ThoCongViec getById(Integer id) {
		// TODO Auto-generated method stub
		return thoCongViecRepository.get(id);
	}

	// tested
	public void add(ThoCongViec entity) {
		thoCongViecRepository.add(entity);
	}
	
	// tested
	public void update(ThoCongViec entity) {
		thoCongViecRepository.update(entity);
	}

	public void delete(ThoCongViec entity) {
		// TODO Auto-generated method stub
		
	}

	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		thoCongViecRepository.deleteById(id);
		
	}

}
