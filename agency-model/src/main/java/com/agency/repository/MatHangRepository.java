package com.agency.repository;

import com.agency.model.MatHang;

public interface MatHangRepository extends GenericRepository<Integer,MatHang>{

	MatHang findOneByMatHangName(String tenMatHang);

}
