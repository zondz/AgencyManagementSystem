package com.agency.serviceimplement;

import java.util.ArrayList;
import java.util.List;

import com.agency.DAO.CongViecDAO;
import com.agency.DAO.HoaDonXuatHangDTO;
import com.agency.model.CongViec;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.KhachHang;
import com.agency.model.MatHang;
import com.agency.model.ThoCongViec;
import com.agency.model.TrangThaiHoaDon;
import com.agency.repository.CongViecRepository;
import com.agency.repository.ThoCongViecRepository;
import com.agency.repository.implement.CongViecRepositoryImplement;
import com.agency.repository.implement.ThoCongViecRepositoryImplement;
import com.agency.service.CongViecServiceRepository;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.MatHangServiceRepository;

public class CongViecServiceRepositoryImplement implements CongViecServiceRepository {
	CongViecRepository congViecRepository;
	ThoCongViecRepository thoCongViecRepository;
	HoaDonXuatHangServiceRepository hoaDonXuatHangService;
	KhachHangServiceRepository khachHangServiceRepository;
	MatHangServiceRepository matHangService ;
	public CongViecServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		congViecRepository = new CongViecRepositoryImplement();
		thoCongViecRepository = new ThoCongViecRepositoryImplement();
		hoaDonXuatHangService = new HoaDonXuatHangServiceRepositoryImplement();
		khachHangServiceRepository = new KhachHangServiceRepositoryImplement();
		matHangService = new MatHangServiceRepositoryImplement();
	}

	/**
	 * b1 : lấy tất cả các Công Việc
	 *  b2 : Với mỗi công việc -> lấy được tất cả các
	 * công việc - thợ tương ứng 
	 * b3 : Với mỗi công việc -> lấy ra Hóa đơn xuất hàng
	 * tương ứng 
	 * b4 : Xử lý hóa đơn xuất hàng, set lại các thuộc tính bằng cách query đến
	 * b4 : Với mỗi công viêc - > lấy ra Thông tin khách hàng tương ứng 
	 * b5: tạo một công việc DAO hoàn chỉnh trả cho view
	 * 
	 * Cần đợi service của HoaDonXuatHang
	 */
	@Override
	public List<CongViecDAO> getAll() {
		List<CongViecDAO> congViecDAOList = new ArrayList<CongViecDAO>();
//		// b1
		List<CongViec> congViecList = (List<CongViec>) congViecRepository.getAll();
	
		CongViecDAO congViecDAO = null;
		for(CongViec congViec : congViecList) {
			congViecDAO = this.getById(congViec.getId());
			congViecDAOList.add(congViecDAO);
		}
		
		return congViecDAOList;

	}

	/**
	 * Trả về cho view thông tin một công việc DAO dựa vào id 
	 * b1 : tìm công việc với id
	 * 
	 * b2 : tìm List< ThoCongViec > với id Công việc
	 *  b3 : Tìm Hóa đơn xuất hàng  với id công việc
	 * b4 : Tìm Khách Hàng với id khách hàng tìm được từ công việc
	 * b5 : Trả về 1 DAO cho View
	 */
	@Override
	public CongViecDAO getById(Integer id) {

		CongViecDAO congViecDAO = null;

//		// b1
		CongViec congViec = congViecRepository.get(id);
//		// b2
		List<ThoCongViec> thoCongViecList = thoCongViecRepository.getListThoCongViecByIdCongViec(id);
//		// b3 hoaDonXuatHang phai lam
		HoaDonXuatHangDTO hoaDonDTO = hoaDonXuatHangService.getById(congViec.getIdHoaDonXuatHang());
		HoaDonXuatHang hoaDonXuatHang =hoaDonXuatHangService.getById(congViec.getIdHoaDonXuatHang()).getHoaDonXuatHang();
//		// b4
		KhachHang khachHang = hoaDonDTO.getKhachHang();
//		// b5
		double sumCongTho = 0 ;
		for(int i = 0 ; i< thoCongViecList.size();i++) {
			sumCongTho += thoCongViecList.get(i).getCongTho();
		}
		congViec.setTongCongTho(sumCongTho);
		
		congViec.setTongChiPhiMatHang(hoaDonXuatHang.getTongCong()-hoaDonXuatHang.getGiamGia());
//	
		congViecDAO = new CongViecDAO(congViec, thoCongViecList, hoaDonXuatHang, khachHang);

		return congViecDAO;
	}

	/**
	 * Tạo một công việc , view truyền cho 1 object thông tin khách hàng ,1 object
	 * Hóa Đơn Xuất Hàng , 1 List<ThoCongViec>
	 * b1 : Kiểm tra khách hàng cũ hay mới dựa vào số điện thoại
	 * 		nếu mới -> tạo khách hàng mới -> đưa vào database 
	 * -> lấy lại id khách hàng mới
	 * b2 : Tạo một Hóa đơn xuất hàng và đẩy vào db -> lấy lại id hóa đơn mới
	 * b3 : Tạo một công việc và đẩy vào db với id khách hàng và id hóa đơn lấy được , lấy lại id của Cong_viec
	 *  b4 : Tạo các ThoCongViec với id của công việc tìm được và đẩy vào db
	 * 
	 */

	// tested
	@Override
	public void add(CongViecDAO entity) {
		// b1 :
		boolean userDuplicate = khachHangServiceRepository.checkDuplicateUser(entity.getKhachHang().getSoDienThoai());
		// neu duplicate -> khong tao them khach hang , neu khong duplicate - > tao them khach hang
		if(!userDuplicate) {
			khachHangServiceRepository.add(entity.getKhachHang());
			
		}
		
		
		KhachHang khachHang= khachHangServiceRepository.findByPhoneNumber(entity.getKhachHang().getSoDienThoai());

		int idKhachHang = khachHang.getId();
		
			HoaDonXuatHang hoaDonXuatHang = entity.getHoaDonXuatHang();
			
			// gửi thông tin hóa đơn và khách hàng cho bên Hóa đơn service xử lý
			HoaDonXuatHangDTO hoaDonXuatHangDTO = new HoaDonXuatHangDTO(hoaDonXuatHang,khachHang);
			hoaDonXuatHangService.add(hoaDonXuatHangDTO);

			hoaDonXuatHang = hoaDonXuatHangService.findByIdKhacHangAndNgayViet(idKhachHang,hoaDonXuatHang.getNgayViet());
			int idNewHoaDonXuatHang = hoaDonXuatHang.getId();
		// b3  
			CongViec congViec = entity.getCongViec();
			congViec.setIdHoaDonXuatHang(idNewHoaDonXuatHang);
			congViec.setIdKhachHang(idKhachHang);
			congViecRepository.add(congViec);
			
			congViec = congViecRepository.findByIdKhachHangAndIdHoaDonXuatHang(idKhachHang,idNewHoaDonXuatHang);
			int idNewCongViec = congViec.getId();
		// b4 : 
			ThoCongViec thoCongViec = null ;
			for(int i = 0 ; i < entity.getThoCongViecList().size();i++) {
				thoCongViec = entity.getThoCongViecList().get(i);
				thoCongViec.setIdCongViec(idNewCongViec);
				thoCongViecRepository.add(thoCongViec);
			}
			
		
	}
	
	/**
	 * sửa một công việc
	 *  View truyền cho CongViecDTO 
	 * b1 : check thông tin khách hàng, có thể là mới có thể là cũ
	 * 		Nếu mới -> cập nhật lại id khach hang của hóa đơn xuất hàng và của công việc
	 * 	b2   :upate Hóa Đơn Xuất Hàng 
	 *  
	 *  b4 : update ThoCongViec
	 *  b3 : update Công Việc 
	 * 
	 */
	
	@Override
	public void update(CongViecDAO entity) {
		// b1
		KhachHang khachHang = entity.getKhachHang();
		boolean oldUser = khachHangServiceRepository.checkDuplicateUser(khachHang.getSoDienThoai());
		if(!oldUser) {
			khachHangServiceRepository.add(khachHang);
		
		}
		khachHang = khachHangServiceRepository.findByPhoneNumber(khachHang.getSoDienThoai());
		int idKhachHang = khachHang.getId();


		HoaDonXuatHang hoaDonXuatHang = entity.getHoaDonXuatHang();
		HoaDonXuatHangDTO hoaDonXuatHangDTO = new HoaDonXuatHangDTO(hoaDonXuatHang,khachHang);
		hoaDonXuatHangService.update(hoaDonXuatHangDTO);
		hoaDonXuatHang = hoaDonXuatHangService.findByIdKhacHangAndNgayViet(idKhachHang, hoaDonXuatHang.getNgayViet());
		
		//update ThoCongViec
		List<ThoCongViec> thoCongViecList = entity.getThoCongViecList();
		int sumCongTho = 0 ;
		for(ThoCongViec thoCongViec : thoCongViecList) {
			sumCongTho+= thoCongViec.getCongTho();
			thoCongViecRepository.update(thoCongViec);
		}
		
		// update công việc
		CongViec congViec = entity.getCongViec();
		congViec.setIdKhachHang(idKhachHang);
		congViecRepository.update(congViec);
		
 
	}
	
	/*
	 * delete Công Việc By Id
	 * tested
	 * *
	 */
	@Override
	public void deleteById(Integer id) {
		congViecRepository.deleteById(id);

	}
}
	
	
	
