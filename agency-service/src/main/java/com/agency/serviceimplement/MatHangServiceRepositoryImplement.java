package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.MatHang;
import com.agency.model.MieuTa;
import com.agency.repository.MatHangRepository;
import com.agency.repository.implement.MatHangRepositoryImplement;
import com.agency.service.MatHangServiceRepository;
import com.agency.service.MieuTaServiceRepository;

public class MatHangServiceRepositoryImplement implements MatHangServiceRepository {
	MatHangRepository matHangRepository;
	MieuTaServiceRepository mieuTaServiceRepository;

	public MatHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		matHangRepository = new MatHangRepositoryImplement();
		mieuTaServiceRepository = new MieuTaServiceRepositoryImplement();
	}

	/**
	 * 
	 * b1 : lấy tất cả các mặt hàng b2 : lấy tất cả các Miêu tả b3 : Lồng các miêu
	 * tả vào các mặt hàng
	 * 
	 */
	@Override
	public List<MatHang> getAll() {
		List<MatHang> matHangList = (List<MatHang>) matHangRepository.getAll();

		List<MieuTa> mieuTaList = (List<MieuTa>) mieuTaServiceRepository.getAll();
		for (MatHang matHang : matHangList) {
			for (MieuTa mieuTa : mieuTaList) {
				if (mieuTa.getIdMatHang() == matHang.getId()) {
					matHang.setMieuTa(mieuTa);
				}

			}

		}

		return matHangList;
	}

	@Override
	public MatHang getById(Integer id) {
		System.out.println("idmh : " + id);
		MatHang matHang = matHangRepository.get(id);
		System.out.println(matHang);
		MieuTa mieuTa = mieuTaServiceRepository.getByMatHangId(id);
		matHang.setMieuTa(mieuTa);
		return matHang;
	}

	@Override
	public void add(MatHang entity) {
		this.matHangRepository.add(entity);
		// MieuTa chua biet id cua mat hang moi
		MatHang matHang = matHangRepository.findOneByMatHangName(entity.getTenMatHang());
		MieuTa mieuTa = entity.getMieuTa();
		if (mieuTa != null) {
			mieuTa.setIdMatHang(matHang.getId());
			this.mieuTaServiceRepository.add(mieuTa);

		}

	}

	@Override
	public void update(MatHang entity) {
		this.matHangRepository.update(entity);
		if (entity.getMieuTa() != null) {
			this.mieuTaServiceRepository.update(entity.getMieuTa());
		}
		System.out.println("Mặt hàng service - update finished");

	}

	@Override
	public void deleteById(Integer id) {
		this.matHangRepository.deleteById(id);
	}

}
