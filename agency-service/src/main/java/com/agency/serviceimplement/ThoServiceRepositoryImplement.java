package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.Tho;
import com.agency.repository.ThoRepository;
import com.agency.repository.implement.ThoRepositoryImplement;
import com.agency.service.ThoServiceRepository;

public class ThoServiceRepositoryImplement implements ThoServiceRepository{
	private ThoRepository thoRepository;
	public ThoServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		thoRepository  = new ThoRepositoryImplement();
	}
	@Override
	public List<Tho> getAll() {
		return (List<Tho>) thoRepository.getAll();
	}

	@Override
	public Tho getById(Integer id) {
		// TODO Auto-generated method stub
		return thoRepository.get(id);
	}

	@Override
	public void add(Tho entity) {
		thoRepository.add(entity);
	}

	@Override
	public void update(Tho entity) {
		thoRepository.update(entity);
	}

	@Override
	public void deleteById(Integer id) {
		thoRepository.deleteById(id);
	}

}
