package com.agency.serviceimplement;

import java.util.List;

import com.agency.model.HoaDonXuatHang;
import com.agency.repository.HoaDonXuatHangRepository;
import com.agency.repository.implement.HoaDonXuatHangRepositoryImplement;
import com.agency.service.HoaDonXuatHangServiceRepository;

public class HoaDonXuatHangServiceRepositoryImplement implements HoaDonXuatHangServiceRepository{
	HoaDonXuatHangRepository hoaDonXuatHangRepository ;
	public HoaDonXuatHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		hoaDonXuatHangRepository = new HoaDonXuatHangRepositoryImplement();
	}
	
	// tested hiện tại cho mỗi phần Hóa Đơn Xuất Hàng , chưa đính kèm orderLine
	@Override
	public List<HoaDonXuatHang> getAll() {
		// TODO Auto-generated method stub
		return (List<HoaDonXuatHang>) hoaDonXuatHangRepository.getAll();
	}

	// tested cho Mỗi Hóa Đơn Xuất Hàng , chưa đính kèm orderlIne
	@Override
	public HoaDonXuatHang getById(Integer id) {
		// TODO Auto-generated method stub
		return hoaDonXuatHangRepository.get(id);
	}
	
	// tested , chưa đính kèm orderLine
	@Override
	public void add(HoaDonXuatHang entity) {
		hoaDonXuatHangRepository.add(entity);
		
	}
	
	// test 1 bảng bên HoaDonXuat Hang , chua Test bên HoaDonXuatHangOrderLine
	@Override
	public void update(HoaDonXuatHang entity) {
		 this.hoaDonXuatHangRepository.update(entity);
	}

	// tested
	@Override
	public void deleteById(Integer id) {
		this.hoaDonXuatHangRepository.deleteById(id);
	}

}
