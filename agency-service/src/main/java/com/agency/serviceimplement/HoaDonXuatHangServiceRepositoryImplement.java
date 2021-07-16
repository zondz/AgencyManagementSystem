package com.agency.serviceimplement;

import java.time.LocalDate;
import java.util.List;

import com.agency.DAO.HoaDonXuatHangDTO;
import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.KhachHang;
import com.agency.model.MatHang;
import com.agency.model.TrangThaiHoaDon;
import com.agency.repository.HoaDonXuatHangOrderLineRepository;
import com.agency.repository.HoaDonXuatHangRepository;
import com.agency.repository.implement.HoaDonXuatHangOrderLineRepositoryImplement;
import com.agency.repository.implement.HoaDonXuatHangRepositoryImplement;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.MatHangServiceRepository;

public class HoaDonXuatHangServiceRepositoryImplement implements HoaDonXuatHangServiceRepository{
	HoaDonXuatHangRepository hoaDonXuatHangRepository ;
	MatHangServiceRepository matHangService;
	KhachHangServiceRepository khachHangService;
	HoaDonXuatHangOrderLineRepository hoaDonXuatHangOrderLineRepository;
	public HoaDonXuatHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		hoaDonXuatHangRepository = new HoaDonXuatHangRepositoryImplement();
		matHangService = new MatHangServiceRepositoryImplement();
		khachHangService = new KhachHangServiceRepositoryImplement();
		hoaDonXuatHangOrderLineRepository = new HoaDonXuatHangOrderLineRepositoryImplement();
	}
	
	// tested hiện tại cho mỗi phần Hóa Đơn Xuất Hàng , chưa đính kèm orderLine
	@Override
	public List<HoaDonXuatHangDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	// 
	@Override
	public HoaDonXuatHangDTO getById(Integer id) {
	HoaDonXuatHang hoaDon =	hoaDonXuatHangRepository.get(id);
	List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHangOrderLineRepository.findByHoaDonXuatHangId(id);
	// chỉnh sửa các thuộc tính của các orderLines để trả về
	MatHang matHang ;
	int tongCong = 0;
	for(HoaDonXuatHangOrderLine orderLine : orderLines) {
		matHang = matHangService.getById(id);
		if(orderLine.getGiaKhong()!=0) {
			orderLine.setThanhTien(orderLine.getSoLuong()*orderLine.getGiaKhong());
		}
		else {
			orderLine.setThanhTien(orderLine.getSoLuong()*matHang.getGiaBanTrenDonVi());
			
		}
		orderLine.setDonViTinh(matHang.getDonViTinh());
		orderLine.setDonGia(matHang.getGiaBanTrenDonVi());
		tongCong+=orderLine.getThanhTien();
		
	}
	tongCong+=hoaDon.getVanChuyen();
	// đính kèm các orderLine vào trong Hóa Đơn
	hoaDon.setOrderLines(orderLines);
	hoaDon.setTongCong(tongCong);	
	hoaDon.setConLai(hoaDon.getTongCong()-hoaDon.getDatTruoc()-hoaDon.getGiamGia());

	// tìm khách hàng trả về 
	KhachHang khachHang = khachHangService.getById(hoaDon.getIdKhachHang());
	
	HoaDonXuatHangDTO hoaDonDTO = new HoaDonXuatHangDTO(hoaDon,khachHang);
		return hoaDonDTO;
	}
	
	/**
	 * 2 trường hợp 
	 * Nhận được hóa đơn từ view ,tạo mới hóa đơn
	 * Từ công việc gọi
	 * b1 : add thông tin để tạo một hóa đơn trong bảng hóa đơn
	 * b2 : lấy lại id của hóa đơn mới
	 * b3 : tạo các record mới của các orderLine với id của hóa đơn mới
	 * 
	 */
	@Override
	public void add(HoaDonXuatHangDTO entity) {
	HoaDonXuatHang hoaDonXuatHang =	this.setUpHoaDonXuatHang(entity);
	hoaDonXuatHangRepository.add(hoaDonXuatHang);
	HoaDonXuatHang hoaDonFromDatabase = this.findByIdKhacHangAndNgayViet(hoaDonXuatHang.getIdKhachHang(), hoaDonXuatHang.getNgayViet());
	System.out.println("hoa don from database : "+hoaDonFromDatabase);
	
	hoaDonXuatHangOrderLineRepository.addManyByHoaDonXuatHangId(hoaDonFromDatabase.getId(),hoaDonXuatHang.getOrderLines() );	
		System.out.println("Add hóa đơn service finished");
	}
	
	// test 1 bảng bên HoaDonXuat Hang , chua Test bên HoaDonXuatHangOrderLine
	@Override
	public void update(HoaDonXuatHangDTO entity) {
		// update khách hàng
		KhachHang khachHang =entity.getKhachHang();
		boolean oldUser = khachHangService.checkDuplicateUser(khachHang.getSoDienThoai());
		if(!oldUser) {
			khachHangService.add(khachHang);
		
		}
		
		HoaDonXuatHang hoaDonXuatHang = entity.getHoaDonXuatHang();
		// update orderLines
		List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHang.getOrderLines();
		int sumOrders = 0;
		MatHang matHang;
		for(HoaDonXuatHangOrderLine orderLine : orderLines) {
			matHang = matHangService.getById(orderLine.getIdMatHang());
			if(orderLine.getGiaKhong()!=0) {
				orderLine.setThanhTien(orderLine.getSoLuong()*orderLine.getGiaKhong());
			}
			else {
				orderLine.setThanhTien(orderLine.getSoLuong()*matHang.getGiaBanTrenDonVi());
				
			}
			orderLine.setDonGia(matHang.getGiaBanTrenDonVi());
			orderLine.setDonViTinh(matHang.getDonViTinh());
			
			hoaDonXuatHangOrderLineRepository.updateOne(orderLine);
			sumOrders+=orderLine.getThanhTien();
			
		}
		hoaDonXuatHang.setTongCong(sumOrders + hoaDonXuatHang.getVanChuyen());
		hoaDonXuatHang.setConLai(hoaDonXuatHang.getTongCong()-hoaDonXuatHang.getDatTruoc()-hoaDonXuatHang.getGiamGia());
		if(hoaDonXuatHang.getConLai()>0) {
			hoaDonXuatHang.setTrangThaiHoaDon(TrangThaiHoaDon.CònNợ);
		}
		else {
			hoaDonXuatHang.setTrangThaiHoaDon(TrangThaiHoaDon.ĐãThanhToán);
		}
		hoaDonXuatHangRepository.update(hoaDonXuatHang);
		
		System.err.println("Hoa Don Xuat Hang update service finished");
		
		
	
	}

	// tested
	@Override
	public void deleteById(Integer id) {
		this.hoaDonXuatHangRepository.deleteById(id);
	}


	@Override
	public HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet) {
		// TODO Auto-generated method stub
		return hoaDonXuatHangRepository.findByIdKhacHangAndNgayViet(idKhachHang, ngayViet);
	}

	@Override
	public HoaDonXuatHang setUpHoaDonXuatHang(HoaDonXuatHangDTO hoaDonXuatHangDTO) {
		KhachHang khachHang = hoaDonXuatHangDTO.getKhachHang();
		boolean userDuplicate =khachHangService.checkDuplicateUser(khachHang.getSoDienThoai());
		if(!userDuplicate) {
			khachHangService.add(khachHang);
		}
		
		
		HoaDonXuatHang hoaDon = hoaDonXuatHangDTO.getHoaDonXuatHang();
		hoaDon.setIdKhachHang(khachHang.getId());
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
