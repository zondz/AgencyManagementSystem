package com.agency.serviceimplement;

import java.util.ArrayList;
import java.util.List;

import com.agency.DAO.CongViecDAO;
import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.ThoCongViec;
import com.agency.repository.CongViecRepository;
import com.agency.repository.implement.CongViecRepositoryImplement;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonXuatHangServiceRepository;

public class CongViecServiceRepositoryImplement implements CongViecServiceRepository{
	CongViecRepository congViecRepository;
	HoaDonXuatHangServiceRepository hoaDonXuatHangService;
	public CongViecServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		congViecRepository = new CongViecRepositoryImplement();
		hoaDonXuatHangService = new HoaDonXuatHangServiceRepositoryImplement();
	}

	/**
	 * b1 : lấy tất cả các Công Việc
	 * b2 : Với mỗi công việc -> lấy được tất cả các công việc - thợ tương ứng
	 * b3 : Với mỗi công việc -> lấy ra Hóa đơn xuất hàng tương ứng 
	 * b4 : tạo một công việc hoàn chỉnh
	 * 
	 * 
	 */
	@Override
	public List<CongViecDAO> getAll() {
		List<CongViecDAO> congViecDAOList = new ArrayList<CongViecDAO>();
		// b1
		List<CongViec>congViecList = (List<CongViec>) congViecRepository.getAll();
		CongViecDAO congViecDAO = null;
		List<ThoCongViec> thoCongViecList = null;
		HoaDonXuatHang hoaDonXuatHang;
		// b2
			for(CongViec cv : congViecList) {
				thoCongViecList = congViecRepository.getCongViecThoByIdCongViec(cv.getId());
		// b3
				hoaDonXuatHang = 	hoaDonXuatHangService.getById(cv.getIdHoaDonXuatHang());
				// stop here
				
				congViecDAO = new CongViecDAO(cv,thoCongViecList);
				congViecDAOList.add(congViecDAO);
				
			}
		return congViecDAOList;
	}

	// CongViecId
	@Override
	public CongViecDAO getById(Integer id) {
		
		CongViecDAO congViecDAO = null;
		CongViec congViec  = null ;
		List<ThoCongViec> thoCongViecList = null;
		List<CongViec>congViecList = (List<CongViec>) congViecRepository.getAll();
		for(CongViec vc : congViecList) {
			if(vc.getId()==id) {
				congViec = vc;
				thoCongViecList = congViecRepository.getCongViecThoByIdCongViec(id);
				congViecDAO = new CongViecDAO(congViec,thoCongViecList);
			}
		}
		return congViecDAO;
	}

	@Override
	public void add(CongViecDAO entity) {
		congViecRepository.createCongViec(entity.getCongViec(), entity.getThoCongViecList());
		
		
	}

	@Override
	public void update(CongViecDAO entity) {
		congViecRepository.update(entity.getCongViec());	
		congViecRepository.updateThoCongViecChoMotCongViec(entity.getThoCongViecList());
	}

	@Override
	public void deleteById(Integer id) {
		congViecRepository.deleteById(id);
		
	}

	
	

}
