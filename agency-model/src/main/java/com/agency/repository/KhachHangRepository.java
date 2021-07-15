package com.agency.repository;

import com.agency.model.KhachHang;

public interface KhachHangRepository extends GenericRepository<Integer,KhachHang>{
	public KhachHang getLastRecord();
	public KhachHang findByPhoneNumber(String phoneNumber);
	public boolean checkDuplicateUserByPhoneNumber(String phoneNumber);
}
