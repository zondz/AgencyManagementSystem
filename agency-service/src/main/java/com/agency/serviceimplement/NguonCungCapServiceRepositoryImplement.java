package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.NguonCungCap;
import com.agency.repository.NguonCungCapRepository;
import com.agency.repository.implement.NguonCungCapRepositoryImplement;
import com.agency.service.NguonCungCapServiceRepository;

public class NguonCungCapServiceRepositoryImplement implements NguonCungCapServiceRepository {
	NguonCungCapRepository nguonCungCapRepository = new NguonCungCapRepositoryImplement();
	
	// tested
	public List<NguonCungCap> getAll() {
		// TODO Auto-generated method stub
		return (List<NguonCungCap>) nguonCungCapRepository.getAll();
	}
	
	//tested

	public NguonCungCap getById(Integer id) {
		// TODO Auto-generated method stub
		return nguonCungCapRepository.get(id);
	}

	// tested
	public void add(NguonCungCap entity) {
		nguonCungCapRepository.add(entity);
	}

	// tested
	public void update(NguonCungCap entity) {
		nguonCungCapRepository.update(entity);
	}

	
	 // ?
	public void delete(NguonCungCap entity) {
		// TODO Auto-generated method stub
		
	}
	
	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		nguonCungCapRepository.deleteById(id);
	}

}
