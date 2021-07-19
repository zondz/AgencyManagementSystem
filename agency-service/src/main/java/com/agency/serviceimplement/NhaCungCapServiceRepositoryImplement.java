package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.NhaCungCap;
import com.agency.repository.NhaCungCapRepository;
import com.agency.repository.implement.NhaCungCapRepositoryImplement;
import com.agency.service.NhaCungCapServiceRepository;

public class NhaCungCapServiceRepositoryImplement implements NhaCungCapServiceRepository{
	private NhaCungCapRepository nhaCungCapRepository;
	
	public NhaCungCapServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		nhaCungCapRepository = new NhaCungCapRepositoryImplement();
	}
	@Override
	public List<NhaCungCap> getAll() {
		// TODO Auto-generated method stub
		return (List<NhaCungCap>) nhaCungCapRepository.getAll();
	}

	@Override
	public NhaCungCap getById(Integer id) {
		// TODO Auto-generated method stub
		return nhaCungCapRepository.get(id);
	}

	@Override
	public void add(NhaCungCap entity) {
		nhaCungCapRepository.add(entity);
		System.out.println("Nhà cung cấp service - add finished");
	}

	@Override
	public void update(NhaCungCap entity) {
		nhaCungCapRepository.update(entity);
		System.out.println("Nhà cung cấp service - update finished");
	}

	@Override
	public void deleteById(Integer id) {
		nhaCungCapRepository.deleteById(id);
		System.out.println("Nhà cung cấp service - deleteById finished");

	}

}
