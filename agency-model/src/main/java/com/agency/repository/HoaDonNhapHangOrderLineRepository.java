package com.agency.repository;

import java.util.List;

import com.agency.model.HoaDonNhapHangOrderLine;

public interface HoaDonNhapHangOrderLineRepository {

	List<HoaDonNhapHangOrderLine> getByHoaDonId(Integer id);

	void addManyForOneHoaDon(List<HoaDonNhapHangOrderLine> orderLines);

	void update(HoaDonNhapHangOrderLine updateOrderLine);

	void deleteById(int id);
	
	List<HoaDonNhapHangOrderLine> getAll();
	
}
