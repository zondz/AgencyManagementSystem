package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.KichThuoc;
import com.agency.model.MieuTa;
import com.agency.model.Origin;
import com.agency.repository.KichThuocRepository;
import com.agency.repository.MieuTaRepository;
import com.agency.repository.OriginRepository;
import com.agency.repository.implement.KichThuocRepositoryImplement;
import com.agency.repository.implement.MieuTaRepositoryImplement;
import com.agency.repository.implement.OriginRepositoryImplement;
import com.agency.service.MieuTaServiceRepository;

public class MieuTaServiceRepositoryImplement implements MieuTaServiceRepository {
	private MieuTaRepository mieuTaRepository;
	KichThuocRepository kichThuocRepository;
	OriginRepository originRepository;
	public MieuTaServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		mieuTaRepository = new MieuTaRepositoryImplement();
		kichThuocRepository = new KichThuocRepositoryImplement();
		originRepository = new OriginRepositoryImplement();
	}
	/**
	 * b1: lấy các miêu tả trong miêu tả list
	 * b2 : lấy các kích thước tương ứng với miêu tả
	 * b3 : lấy các Orgin tương ứng với miêu tả
	 * 
	 */
	@Override
	public List<MieuTa> getAll() {
		List<MieuTa> mieuTaList = (List<MieuTa>) mieuTaRepository.getAll();
		KichThuoc kichThuoc = null;
		Origin origin = null;
		for(MieuTa mieuTa : mieuTaList) {
			kichThuoc = kichThuocRepository.getByMieuTaId(mieuTa.getId());
			origin = originRepository.getByMieuTaId(mieuTa.getId());
			mieuTa.setKichThuoc(kichThuoc);
			mieuTa.setOrigin(origin);
			
			
		}
		
		return mieuTaList;
	}

	@Override
	public MieuTa getById(Integer id) {
		MieuTa mieuTa = mieuTaRepository.get(id);
		KichThuoc kichThuoc = kichThuocRepository.getByMieuTaId(id);
		Origin origin = originRepository.getByMieuTaId(id);
		mieuTa.setKichThuoc(kichThuoc);
		mieuTa.setOrigin(origin);
		return mieuTa;
	}

	@Override
	public void add(MieuTa entity) {
		KichThuoc kichThuoc = entity.getKichThuoc();
		Origin origin = entity.getOrigin();
		MieuTa mieuTa = null;
		mieuTaRepository.add(entity);
		mieuTa = mieuTaRepository.getByMatHangId(entity.getIdMatHang());
		
		if(kichThuoc!=null) {
			kichThuoc.setIdMieuTa(mieuTa.getId());
			kichThuocRepository.add(kichThuoc);	
		}
		if(origin!=null) {
			origin.setMieuTaId(mieuTa.getId());
			originRepository.add(origin);
			
		}
		
		
		System.out.println("Miêu tả service - add finished");
		
	}

	@Override
	public void update(MieuTa entity) {
		this.mieuTaRepository.update(entity);	
		KichThuoc kichThuoc = entity.getKichThuoc();
		Origin origin = entity.getOrigin();
		if(kichThuoc!=null) {
			this.kichThuocRepository.updateForOneMieuTa(kichThuoc);
			
		}
		if(entity.getOrigin()!=null) {
			this.originRepository.updateForOneMieuTa(entity.getOrigin());

		}
		System.out.println("Miêu tả service - update finished");
	}

	@Override
	public void deleteById(Integer id) {
		this.mieuTaRepository.deleteById(id);
		System.out.println("Miêu tả service - delete finished");
	}
	@Override
	public MieuTa getByMatHangId(int matHangId) {
		MieuTa mieuTa = this.mieuTaRepository.getByMatHangId(matHangId);
		if(mieuTa!=null) {
			
			KichThuoc kichThuoc  = this.kichThuocRepository.getByMieuTaId(mieuTa.getId());
			Origin origin = this.originRepository.getByMieuTaId(mieuTa.getId());
			mieuTa.setKichThuoc(kichThuoc);
			mieuTa.setOrigin(origin);
		}
		
		
		return mieuTa;
	}

}
