package com.agency.repository;

import java.util.List;

import com.agency.model.ThoCongViec;

public interface ThoCongViecRepository extends GenericRepository<Integer , ThoCongViec>{

	void updateThoCongViecChoMotCongViec(List<ThoCongViec> thoCongViecList);

	List<ThoCongViec> getListThoCongViecByIdCongViec(Integer id);

}
