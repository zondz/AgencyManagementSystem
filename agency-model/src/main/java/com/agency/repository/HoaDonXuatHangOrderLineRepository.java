package com.agency.repository;

import java.util.List;

import com.agency.model.HoaDonXuatHangOrderLine;

public interface HoaDonXuatHangOrderLineRepository {
	void addManyByHoaDonXuatHangId(Integer hoaDonXuatHangId, List<HoaDonXuatHangOrderLine> orderLines);

	List<HoaDonXuatHangOrderLine> findByHoaDonXuatHangId(Integer id);

	void updateOne(HoaDonXuatHangOrderLine orderLine);

	List<HoaDonXuatHangOrderLine> getAll();

	void deleteOneById(int id);

	HoaDonXuatHangOrderLine getById(int id);

}
