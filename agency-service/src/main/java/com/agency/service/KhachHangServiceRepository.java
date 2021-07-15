package com.agency.service;

import com.agency.model.KhachHang;

public interface KhachHangServiceRepository extends GenericServiceRepository<Integer,KhachHang> {
	public boolean checkDuplicateUser(String phoneNumber);

	public KhachHang getLastRecord();

	public KhachHang findByPhoneNumber(String phoneNumber);
	

}
