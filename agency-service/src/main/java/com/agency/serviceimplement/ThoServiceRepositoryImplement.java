package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.Tho;
import com.agency.model.database.Database;
import com.agency.repository.ThoRepository;
import com.agency.repository.implement.ThoRepositoryImplement;
import com.agency.service.ThoServiceRepository;

public class ThoServiceRepositoryImplement implements ThoServiceRepository {
	// model
	ThoRepository thoRepository ;
	public ThoServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		thoRepository = new ThoRepositoryImplement();
	}
	//tested
	public List<Tho> getAll() {
		// TODO Auto-generated method stub
		return (List<Tho>)thoRepository.getAll();
	}
	
	// tested
	public Tho getById(Integer id) {
	
		return thoRepository.get(id);
	}
	
	//tested
	public void add(Tho entity) {
		// TODO Auto-generated method stub
		thoRepository.add(entity);
		
	}
	
	// tested
	public void update(Tho entity) {
		thoRepository.update(entity);
		
	}

	public void delete(Tho entity) {
		// TODO Auto-generated method stub
		
	}
	
	// tested
	public void deleteById(Integer id) {
		thoRepository.deleteById(id);
	}


}
