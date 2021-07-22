package com.agency.serviceimplement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.HoaDonXuatHang;
import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.MatHang;
import com.agency.repository.HoaDonXuatHangOrderLineRepository;
import com.agency.repository.HoaDonXuatHangRepository;
import com.agency.repository.implement.HoaDonXuatHangOrderLineRepositoryImplement;
import com.agency.repository.implement.HoaDonXuatHangRepositoryImplement;
import com.agency.service.HoaDonXuatHangServiceRepository;
import com.agency.service.KhachHangServiceRepository;
import com.agency.service.MatHangServiceRepository;

public class HoaDonXuatHangServiceRepositoryImplement implements HoaDonXuatHangServiceRepository {
	HoaDonXuatHangRepository hoaDonXuatHangRepository;
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
	 * b1 : lấy tất cả các Hóa đơn trong bảng ở database b2 : lấy tất cả các
	 * orderLines ở trong bảng database b3 : lồng các orderLine vào với các Hóa đơn
	 * với id tương ứng b5 : lấy lại thông tin khách hàng * b4 : set up lại từng hóa
	 * hóa đơn
	 * 
	 * b6 : add các hóa đơn + khách hàng vào list DTO trả về
	 *
	 * 
	 * 
	 */

	@Override
	public List<HoaDonXuatHang> getAll() {
		List<HoaDonXuatHang> result = (List<HoaDonXuatHang>) hoaDonXuatHangRepository.getAll();

		List<HoaDonXuatHangOrderLine> allOrderLines = hoaDonXuatHangOrderLineRepository.getAll();

		for (HoaDonXuatHang hoaDon : result) {

			List<HoaDonXuatHangOrderLine> orderLinesForOneHoaDon = new ArrayList<HoaDonXuatHangOrderLine>();

			for (HoaDonXuatHangOrderLine orderLine : allOrderLines) {
				if (orderLine.getIdHoaDon() == hoaDon.getId()) {

					orderLinesForOneHoaDon.add(orderLine);

				}

			}

			hoaDon.setOrderLines(orderLinesForOneHoaDon);

		}

		return result;
	}

	/**
	 * b1 : lấy hóa đơn với id từ database 
	 * b2 : lấy các orderLines với id hóa đơn
	 * 
	 * 
	 */
	@Override

	public HoaDonXuatHang getById(Integer id) {
		HoaDonXuatHang hoaDon = hoaDonXuatHangRepository.get(id);
		List<HoaDonXuatHangOrderLine> orderLines = hoaDonXuatHangOrderLineRepository.findByHoaDonXuatHangId(id);
		hoaDon.setOrderLines(orderLines);

		return hoaDon;
	}

	/**
	 * 
	 * 
	 * Từ công việc gọi b1 : add thông tin để tạo một hóa đơn trong bảng hóa đơn b2
	 * : lấy lại id của hóa đơn mới b3 : tạo các record mới của các orderLine với id
	 * của hóa đơn mới b4 : nếu không đủ hàng
	 * 
	 * @throws InvalidAttributeValueException
	 * 
	 */
	@Override
	public void add(HoaDonXuatHang entity) throws InvalidAttributeValueException {

		List<HoaDonXuatHangOrderLine> orderLines = entity.getOrderLines();

		// nếu không đủ hàng -> thông báo thiếu hàng
		this.checkSoLuongMatHang(orderLines);

		MatHang matHang;
		for (HoaDonXuatHangOrderLine orderLine : orderLines) {
			matHang = matHangService.getById(orderLine.getIdMatHang());
			matHang.setSoLuong(matHang.getSoLuong() - orderLine.getSoLuong());
			matHangService.update(matHang);
		}

		hoaDonXuatHangRepository.add(entity);
		HoaDonXuatHang hoaDon = hoaDonXuatHangRepository.getLatestRecord();

		hoaDonXuatHangOrderLineRepository.addManyByHoaDonXuatHangId(hoaDon.getId(), orderLines);
	}

	/**
	 * b1 : lấy tất cả các orderline với hóa đơn id
	 * b2 : lấy ra các orderline view truyền vào
	 * b3 : xóa các orderline không cần từ db , xóa luôn trong list 
	 * b4 :	các orderLine mới -> kiểm tra số lượng -> add vào database  
	 * b6 : với các orderLine cũ  -> kiểm tra sự lệch về số lượng -> đối chiếu vào database 
	 * b7  : update orderLine cũ
	 *  b8 : update hóa đơn
	 * @throws InvalidAttributeValueException
	 * 
	 */
	@Override
	public void update(HoaDonXuatHang entity) throws InvalidAttributeValueException {

		// b1
		List<HoaDonXuatHangOrderLine> orderLinesFromDb = hoaDonXuatHangOrderLineRepository
				.findByHoaDonXuatHangId(entity.getId());

		// b2
		List<HoaDonXuatHangOrderLine> updateOrderLines = entity.getOrderLines();
		System.out.println(updateOrderLines);

		// b3
		for (int i = 0; i < orderLinesFromDb.size() - 1; i++) {
			boolean keptOrderLine = false;
			HoaDonXuatHangOrderLine orderLineFromDb = orderLinesFromDb.get(i);
			for (HoaDonXuatHangOrderLine updateOrderLine : updateOrderLines) {
				if (orderLineFromDb.getId() == updateOrderLine.getId()) {
					keptOrderLine = true;
				}
			}

			if (keptOrderLine == false) {

				hoaDonXuatHangOrderLineRepository.deleteOneById(orderLineFromDb.getId());
				orderLinesFromDb.remove(orderLineFromDb);

			}

		}

		// b6
		List<HoaDonXuatHangOrderLine> newOrderLines = new ArrayList<HoaDonXuatHangOrderLine>();
		MatHang matHang;
		for (HoaDonXuatHangOrderLine orderLine : updateOrderLines) {
			matHang = matHangService.getById(orderLine.getIdMatHang());
			// new orderline
			if (orderLine.getId() == 0) {
				newOrderLines.add(orderLine);
				matHang.setSoLuong(matHang.getSoLuong() - orderLine.getSoLuong());
			}
			// update orderline
			else {
				int chenhLechSoLuong;
				HoaDonXuatHangOrderLine oldRecord = hoaDonXuatHangOrderLineRepository.getById(orderLine.getId());
				chenhLechSoLuong = orderLine.getSoLuong() - oldRecord.getSoLuong();
				// lấy nhiều hơn
				if (chenhLechSoLuong > 0) {
					// số lượng còn lại ít hơn
					if (matHang.getSoLuong() < chenhLechSoLuong) {
						throw new InvalidAttributeValueException("Không đủ số lượng cho : " + matHang.getTenMatHang());

					}

				}
				// đã đảm bảo số lượng k vượt quá
				matHang.setSoLuong(matHang.getSoLuong() - chenhLechSoLuong);
				matHangService.update(matHang);
				hoaDonXuatHangOrderLineRepository.updateOne(orderLine);

			}

		}

		// b4
		if (newOrderLines.size() != 0)

		{
			this.checkSoLuongMatHang(newOrderLines);
			hoaDonXuatHangOrderLineRepository.addManyByHoaDonXuatHangId(entity.getId(), newOrderLines);
		}

		hoaDonXuatHangRepository.update(entity);

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

	private void checkSoLuongMatHang(List<HoaDonXuatHangOrderLine> orderLines) throws InvalidAttributeValueException {
		MatHang matHang = null;
		for (HoaDonXuatHangOrderLine orderLine : orderLines) {
			matHang = matHangService.getById(orderLine.getIdMatHang());
			if (orderLine.getSoLuong() > matHang.getSoLuong()) {
				throw new InvalidAttributeValueException("Không có đủ số lượng cho : " + matHang.getTenMatHang());
			}

		}

	}

}
