package com.agency.repository;

import java.util.List;

import com.agency.model.CongViec;
import com.agency.model.Tho;
import com.agency.model.ThoCongViec;


public interface CongViecRepository extends GenericRepository<Integer ,CongViec>{
	public void createCongViec(CongViec entity, List<ThoCongViec> thoCongViecList );
	public List<ThoCongViec> getCongViecThoByIdCongViec(Integer id);
	public void updateThoCongViecChoMotCongViec(List<ThoCongViec> thoCongViecList);
}
