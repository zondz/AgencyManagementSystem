package com.agency.service;

import com.agency.model.MieuTa;

public interface MieuTaServiceRepository extends GenericServiceRepository<Integer,MieuTa>{
	MieuTa getByMatHangId(int matHangId);
}
