package com.agency.serviceimplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.agency.model.HoaDonNhapHang;
import com.agency.model.HoaDonNhapHangOrderLine;
import com.agency.repository.HoaDonNhapHangOrderLineRepository;
import com.agency.repository.HoaDonNhapHangRepository;
import com.agency.repository.implement.HoaDonNhapHangOrderLineRepositoryImplement;
import com.agency.repository.implement.HoaDonNhapHangRepositoryImplement;
import com.agency.service.HoaDonNhapHangServiceRepository;

public class HoaDonNhapHangServiceRepositoryImplement implements HoaDonNhapHangServiceRepository{
	private HoaDonNhapHangRepository hoaDonNhapHangRepository;
	private HoaDonNhapHangOrderLineRepository hoaDonNhapHangOrderLineRepository;
	public HoaDonNhapHangServiceRepositoryImplement() {
		// TODO Auto-generated constructor stub
		hoaDonNhapHangRepository = new HoaDonNhapHangRepositoryImplement();
		hoaDonNhapHangOrderLineRepository = new HoaDonNhapHangOrderLineRepositoryImplement();
	}
	
	@Override
	public List<HoaDonNhapHang> getAll() {
		List<HoaDonNhapHang> result = (List<HoaDonNhapHang>) hoaDonNhapHangRepository.getAll();
		List<HoaDonNhapHangOrderLine> allOrderLines = hoaDonNhapHangOrderLineRepository.getAll();
		List<HoaDonNhapHangOrderLine> orderLines ;
		HoaDonNhapHang hoaDon;
		for(int i = 0 ; i< result.size();i++) {

			hoaDon = result.get(i); 
			orderLines = new ArrayList<HoaDonNhapHangOrderLine>();
			for(int j = 0 ; j < allOrderLines.size();j++) {
				HoaDonNhapHangOrderLine orderLine = allOrderLines.get(j);
				if(orderLine.getIdHoaDonNhapHang() == hoaDon.getId()) {
					
					orderLines.add(orderLine);
					
				}
				
			}
			hoaDon.setOrderLines(orderLines);
			
			
		}
		
		System.out.println("Hóa đơn nhập hàng service - get all finished");
		return result;
	}

	@Override
	public HoaDonNhapHang getById(Integer id) {
	HoaDonNhapHang hoaDon= 	hoaDonNhapHangRepository.get(id);
	List<HoaDonNhapHangOrderLine> orderLines = hoaDonNhapHangOrderLineRepository.getByHoaDonId(id);
	hoaDon.setOrderLines(orderLines);
	System.out.println("Hóa đơn nhập hàng service - get by id finished");
		return hoaDon;
	}

	@Override
	public void add(HoaDonNhapHang entity) {
		hoaDonNhapHangRepository.add(entity);
		HoaDonNhapHang hoaDon = hoaDonNhapHangRepository.getLatestRecord();
		List<HoaDonNhapHangOrderLine> orderLines = entity.getOrderLines();
		for(HoaDonNhapHangOrderLine orderLine : orderLines) {
			orderLine.setIdHoaDonNhapHang(hoaDon.getId());
		}
		hoaDonNhapHangOrderLineRepository.addManyForOneHoaDon(orderLines);
		System.out.println("Hoá đơn nhập hàng - add finished");
		
		
		
	}
	/**
	 * update Hóa Đơn nhập hàng
	 * b1 : lấy các orderline trong trong database với id hóa đơn
	 * b2 : phân loại các orderLine từ view thành mới hoặc cũ dựa vào id
	 * nếu mới -> thêm id hóa đơn cho nó rồi add vào db
	 * nếu cũ  -> check xem các orderLine từ database có trùng id không , nếu không , xóa khỏi db , nếu có update
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	public void update(HoaDonNhapHang entity) {
		hoaDonNhapHangRepository.update(entity);
		
		List<HoaDonNhapHangOrderLine> orderLinesFromDb = hoaDonNhapHangOrderLineRepository.getByHoaDonId(entity.getId());
		
		List<HoaDonNhapHangOrderLine> updateOrderLines = entity.getOrderLines();
		
		List<HoaDonNhapHangOrderLine> newOrderLines = new ArrayList<HoaDonNhapHangOrderLine>();
		
		for(HoaDonNhapHangOrderLine orderLine : updateOrderLines) {
			
			if(orderLine.getId()==0) {
				orderLine.setIdHoaDonNhapHang(entity.getId());
				newOrderLines.add(orderLine);
			//	updateOrderLines.remove(orderLine);
				
			}
			
		}
		if(newOrderLines.size()!=0) {
			hoaDonNhapHangOrderLineRepository.addManyForOneHoaDon(newOrderLines);

			
		}
		
		for (HoaDonNhapHangOrderLine orderLine: orderLinesFromDb) {
			boolean keptOrderLine = false; 
			for(HoaDonNhapHangOrderLine updateOrderLine : updateOrderLines) {
				if(orderLine.getId()== updateOrderLine.getId()) {
					
					keptOrderLine = true;	
					hoaDonNhapHangOrderLineRepository.update(updateOrderLine);
					
					break;
				}
						
			}
			if(keptOrderLine == false) {
				
				hoaDonNhapHangOrderLineRepository.deleteById(orderLine.getId());
				
			}
			
		}
		
		
		
		System.out.println("Hoá đơn nhập hàng service - update finished");
		
	}

	
	@Override
	public void deleteById(Integer id) {
		this.hoaDonNhapHangRepository.deleteById(id);
		System.out.println("Hóa đơn nhập hàng service - delete by id finished");
	}

}
