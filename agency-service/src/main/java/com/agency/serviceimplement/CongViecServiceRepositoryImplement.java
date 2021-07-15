package com.agency.serviceimplement;

import java.util.ArrayList;
import java.util.List;

import com.agency.DAO.CongViecDAO;
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
		// b1
		List<CongViec> congViecList = (List<CongViec>) congViecRepository.getAll();
		
		
		List<ThoCongViec> thoCongViecList = null;
		HoaDonXuatHang hoaDonXuatHang;
		CongViecDAO congViecDAO = null;
		// b2
		for (CongViec cv : congViecList) {
			thoCongViecList = thoCongViecRepository.getListThoCongViecByIdCongViec(cv.getId());
			// b3 chua xu ly hoa don xuat hang
			hoaDonXuatHang = hoaDonXuatHangService.getById(cv.getIdHoaDonXuatHang());
			
			// b4
			KhachHang khachHang = khachHangServiceRepository.getById(cv.getIdKhachHang());
			
			// b5
			cv.setTongChiPhiMatHang(hoaDonXuatHang.getTongCong()-hoaDonXuatHang.getGiamGia());
			double sumCongTho = 0 ;
			for(int i = 0 ; i< thoCongViecList.size();i++) {
				sumCongTho += thoCongViecList.get(i).getCongTho();
			}
			cv.setTongCongTho(sumCongTho);
			
			congViecDAO = new CongViecDAO(cv, thoCongViecList, hoaDonXuatHang, khachHang);
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

		// b1
		CongViec congViec = congViecRepository.get(id);
		// b2
		List<ThoCongViec> thoCongViecList = thoCongViecRepository.getListThoCongViecByIdCongViec(id);
		// b3
		HoaDonXuatHang hoaDonXuatHang = hoaDonXuatHangService.getById(congViec.getIdHoaDonXuatHang());
		// b4
		KhachHang khachHang = khachHangServiceRepository.getById(congViec.getIdKhachHang());
		// b5
		double sumCongTho = 0 ;
		for(int i = 0 ; i< thoCongViecList.size();i++) {
			sumCongTho += thoCongViecList.get(i).getCongTho();
		}
		congViec.setTongCongTho(sumCongTho);
		
		congViec.setTongChiPhiMatHang(hoaDonXuatHang.getTongCong()-hoaDonXuatHang.getGiamGia());
	
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
			// set up lại hóa đơn

			hoaDonXuatHang = this.setupHoaDonXuatHang(hoaDonXuatHang);
			
			List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHang.getOrderLines();
			
			hoaDonXuatHang.setIdKhachHang(idKhachHang);
			System.out.println("HoaDonXuatHang trong cong viec service: "+hoaDonXuatHang);

			hoaDonXuatHangService.add(hoaDonXuatHang);
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
	 *  b3 : update Công Việc 
	 *  b4 : update ThoCongViec
	 * 
	 */
	
	@Override
	public void update(CongViecDAO entity) {
		// b1
		boolean oldUser = khachHangServiceRepository.checkDuplicateUser(entity.getKhachHang().getSoDienThoai());
		KhachHang khachHang = entity.getKhachHang();
		if(!oldUser) {
			khachHangServiceRepository.add(entity.getKhachHang());
		
		}
		khachHang = khachHangServiceRepository.findByPhoneNumber(khachHang.getSoDienThoai());
		int idKhachHang = khachHang.getId();
		
		HoaDonXuatHang hoaDonXuatHang = entity.getHoaDonXuatHang();
		hoaDonXuatHang.setIdKhachHang(idKhachHang);
		
		CongViec congViec = entity.getCongViec();
		congViec.setIdKhachHang(idKhachHang);
		
		hoaDonXuatHangService.update(hoaDonXuatHang);
		
		congViecRepository.update(congViec);
		// b4
		thoCongViecRepository.updateThoCongViecChoMotCongViec(entity.getThoCongViecList());
		
 
	}
	
	/*
	 * delete Công Việc By Id
	 * 
	 * *
	 */
	@Override
	public void deleteById(Integer id) {
		congViecRepository.deleteById(id);

	}
	
	
	// kiểm tra xem các orderLines 
	//muốn bán theo giá thực hay giá khống để điều chỉnh hóa đơn
	// chỉnh donViTinh theo mặt hàng
	private HoaDonXuatHang setupHoaDonXuatHang(HoaDonXuatHang hoaDon) {
		List<HoaDonXuatHangOrderLine> orderLines = hoaDon.getOrderLines();
		
		int tongCong = 0;
		for(HoaDonXuatHangOrderLine orderLine : orderLines) {
			MatHang matHang = matHangService.getById(orderLine.getIdMatHang());
			orderLine.setDonViTinh(matHang.getDonViTinh());
			 // kiểm tra xem dùng giá khống hay không
			if(orderLine.getGiaKhong()==0) {
				orderLine.setDonGia(matHang.getGiaBanTrenDonVi());
				orderLine.setThanhTien(orderLine.getDonGia()*orderLine.getSoLuong());
			}else {
				orderLine.setThanhTien(orderLine.getGiaKhong()*orderLine.getSoLuong());
			}
			tongCong += orderLine.getThanhTien();
		}
		
		
		// cập nhật hóa đơn
		tongCong += hoaDon.getVanChuyen();
		hoaDon.setOrderLines(orderLines);
		hoaDon.setTongCong(tongCong);
		hoaDon.setConLai(hoaDon.getTongCong()-hoaDon.getDatTruoc()-hoaDon.getGiamGia());
		if(hoaDon.getConLai() > 0) {
			hoaDon.setTrangThaiHoaDon(TrangThaiHoaDon.CònNợ);
		}
		else {
			hoaDon.setTrangThaiHoaDon(TrangThaiHoaDon.ĐãThanhToán);

		}
		
		return hoaDon;
	}

}
