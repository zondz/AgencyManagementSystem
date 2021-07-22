package com.agency.service;

import java.time.LocalDate;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.HoaDonXuatHang;

public interface HoaDonXuatHangServiceRepository {

	HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet);

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
	void add(HoaDonXuatHang entity) throws InvalidAttributeValueException;

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
	List<HoaDonXuatHang> getAll();

	/**
	 * b1 : lấy hóa đơn với id từ database b2 : lấy các orderLines với id hóa đơn
	 * 
	 * 
	 */
	HoaDonXuatHang getById(Integer id);

	/**
	 * 
	 * b1 : set up hóa đơn
	 * 
	 * b2 : cập nhật ở bảng hóa đơn xuất hàng
	 * 
	 * b3 : cập nhật ở bảng hóa đơn xuất hàng OrderLines 3 trường hợp
	 * 
	 * th1 : thêm mới một orderline th2 : xóa bớt một orderline th3 : xóa đi và thêm
	 * những cái khác b1: lấy các orderLine cũ từ database ra b2 : phân loại từng
	 * orderline từ view là cũ hay mới dựa vào id của nó 2.1 : nếu là mới -> gọi
	 * repository để add thêm orderLine 2.2 : nếu là cũ -> gọi repository cập nhật
	 * 
	 * b3 : tìm ra các orderLine bị xóa trên view bằng cách nhìn vào id -> nếu không
	 * trùng -> xóa trong database
	 * 
	 * @throws InvalidAttributeValueException
	 * 
	 */
	void update(HoaDonXuatHang entity) throws InvalidAttributeValueException;

	void deleteById(Integer id);

//	HoaDonXuatHang setUpHoaDonXuatHang(HoaDonXuatHangDTO hoaDonXuatHang);
}
