package com.agency.repository;

import java.util.List;

import com.agency.model.HoaDonXuatHangOrderLine;

public interface HoaDonXuatHangOrderLineRepository extends GenericRepository<Integer,HoaDonXuatHangOrderLine>{
	List<HoaDonXuatHangOrderLine> getByHoaDonMuaHangId(Integer HoaDonMuaHangId);
	
}
