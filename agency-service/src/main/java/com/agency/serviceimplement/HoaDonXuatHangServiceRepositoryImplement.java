package com.agency.serviceimplement;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	/**
	 * b1 : lấy tất cả các Hóa đơn trong bảng ở database
	 * b2 : lấy tất cả các orderLines ở trong bảng database
	 * b3 : lồng các orderLine vào với các Hóa đơn với id tương ứng 
	 * b5 : lấy lại thông tin khách hàng
	 * 	 * b4 : set up lại từng hóa  hóa đơn 

	 * b6 : add các hóa đơn + khách hàng  vào list DTO trả về
	 *
	 * 
	 * 
	 */
	@Override
	public List<HoaDonXuatHangDTO> getAll() {
		List<HoaDonXuatHangDTO> result = new ArrayList<>();
		List<HoaDonXuatHang>hoaDonList  = (List<HoaDonXuatHang>) hoaDonXuatHangRepository.getAll();
		List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHangOrderLineRepository.getAll();

		HoaDonXuatHangDTO hoaDonXuatHangDTO;

		for(HoaDonXuatHang hoaDon : hoaDonList) {
			
			KhachHang khachHang = khachHangService.getById(hoaDon.getIdKhachHang());
			
			List<HoaDonXuatHangOrderLine> orderLinesForOneHoaDon = new ArrayList<HoaDonXuatHangOrderLine>();
			
			for(HoaDonXuatHangOrderLine orderLine : orderLines) {
				if(orderLine.getIdHoaDon() == hoaDon.getId()) {
					
					orderLinesForOneHoaDon.add(orderLine);
					
				}

			}
			
			hoaDon.setOrderLines(orderLinesForOneHoaDon);
			hoaDon = this.setUpHoaDonXuatHang(new HoaDonXuatHangDTO(hoaDon,khachHang));
			hoaDonXuatHangDTO = new HoaDonXuatHangDTO(hoaDon, khachHang);
			result.add(hoaDonXuatHangDTO);
		}
		
		return result;
	}

	
	
	/**
	 * b1 : lấy hóa đơn với id từ database
	 * b2 : lấy các orderLines với id hóa đơn
	 * b3 : lấy thông tin khách hàng
	 * b4 : set up hóa đơn
	 * b5 : tạo DTO trả về 
	 * 
	 */
	@Override
	public HoaDonXuatHangDTO getById(Integer id) {
	HoaDonXuatHang hoaDon =	hoaDonXuatHangRepository.get(id);
	List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHangOrderLineRepository.findByHoaDonXuatHangId(id);
	
	KhachHang khachHang = khachHangService.getById(hoaDon.getIdKhachHang());
	hoaDon.setOrderLines(orderLines);
	hoaDon = this.setUpHoaDonXuatHang(new HoaDonXuatHangDTO(hoaDon,khachHang));
	
	HoaDonXuatHangDTO hoaDonDTO = new HoaDonXuatHangDTO(hoaDon,khachHang);
	System.out.println("Hoá đơn xuất hàng service - get by id - finished");
		return hoaDonDTO;
	}

	
	
	/**
	 * 
	 * 
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
	
	hoaDonXuatHangOrderLineRepository.addManyByHoaDonXuatHangId(hoaDonFromDatabase.getId(),hoaDonXuatHang.getOrderLines() );	
		System.out.println("Add hóa đơn service finished");
	}

	
	
	/**
	 * 
	 * b1 : set up hóa đơn 
	 * 
	 * b2 : cập nhật ở bảng hóa đơn xuất hàng
	 * 
	 * b3 : cập nhật ở bảng hóa đơn xuất hàng OrderLines
	 * 		3 trường hợp 
	 * 
	 * th1 : thêm mới một orderline
	 * th2 : xóa bớt một orderline
	 * th3 : xóa đi và thêm những cái khác
	 * b1: lấy các orderLine cũ từ database ra
	 * b2 : phân loại từng orderline từ view là cũ hay mới dựa vào id của nó
	 * 2.1 : nếu là mới -> gọi repository để add thêm orderLine
	 * 2.2 : nếu là cũ -> gọi repository cập nhật
	 * 
	 * b3 : tìm ra các orderLine bị xóa trên view bằng cách nhìn vào id -> nếu không trùng -> xóa trong database
	 * 
	 */
	@Override
	public void update(HoaDonXuatHangDTO entity) {
		HoaDonXuatHang hoaDonXuatHang = entity.getHoaDonXuatHang();
		KhachHang khachHang = entity.getKhachHang();
		
		
		hoaDonXuatHang = this.setUpHoaDonXuatHang(new HoaDonXuatHangDTO(hoaDonXuatHang,khachHang));
		
		hoaDonXuatHangRepository.update(hoaDonXuatHang);
		
		// old set orderLine
		List<HoaDonXuatHangOrderLine> oldOrderLines = hoaDonXuatHangOrderLineRepository.findByHoaDonXuatHangId(hoaDonXuatHang.getId());
		
		// update set orderLine
		List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHang.getOrderLines();
		
		for(HoaDonXuatHangOrderLine orderLine : oldOrderLines) {
			boolean keptOrderLine = false;

			for(HoaDonXuatHangOrderLine newOrderLine : orderLines) {
				if(orderLine.getId()== newOrderLine.getId()) {
					keptOrderLine = true;				
				}
			}
			
			if(keptOrderLine==false) {
				
				hoaDonXuatHangOrderLineRepository.deleteOneById(orderLine.getId());
				
			}
			
		}
		
		// new orderLine
		List<HoaDonXuatHangOrderLine> newOrderLines = new ArrayList<>();
	
		for(HoaDonXuatHangOrderLine orderLine : orderLines) {
			
			if(orderLine.getId()!=0) {
				
				hoaDonXuatHangOrderLineRepository.updateOne(orderLine);
				
			}
			else {
				newOrderLines.add(orderLine);
				
			}
			
			
		}
		
		hoaDonXuatHangOrderLineRepository.addManyByHoaDonXuatHangId(hoaDonXuatHang.getId(), newOrderLines);
		
		
		
		
		System.out.println("Hoa Don Xuat Hang update service finished");
		
		
	
	}

	
	
	
	// tested
	@Override
	public void deleteById(Integer id) {
		this.hoaDonXuatHangRepository.deleteById(id);
		System.out.println("Hoá đơn xuất hàng service - delete by id finished");
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
