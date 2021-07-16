package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonXuatHangOrderLine;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonXuatHangOrderLineRepository;

public class HoaDonXuatHangOrderLineRepositoryImplement implements HoaDonXuatHangOrderLineRepository {
	Database database;

	public HoaDonXuatHangOrderLineRepositoryImplement() {
		database = Database.getInstance();
	}

	@Override
	public void addManyByHoaDonXuatHangId(Integer idHoaDonXuatHang, List<HoaDonXuatHangOrderLine> orderLines) {
		String vSQL = "Insert Into HoaDonXuatHangOrderLine(id_hoa_don_xuat_hang,id_mat_hang,so_luong,gia_khong)VALUES";
		for (HoaDonXuatHangOrderLine orderLine : orderLines) {
			if (orderLine == orderLines.get(orderLines.size() - 1)) {
				vSQL += "(" + idHoaDonXuatHang + "," + orderLine.getIdMatHang() + "," + orderLine.getSoLuong() + ","
						+ orderLine.getGiaKhong() + ")";
				break;

			}
			vSQL += "(" + idHoaDonXuatHang + "," + orderLine.getIdMatHang() + "," + orderLine.getSoLuong() + ","
					+ orderLine.getGiaKhong() + "),";
		}

		database.executeSQLNotReturningResultSet(vSQL);

	}

	@Override
	public List<HoaDonXuatHangOrderLine> findByHoaDonXuatHangId(Integer id) {
		List<HoaDonXuatHangOrderLine> list = new ArrayList<HoaDonXuatHangOrderLine>();
		String vSQL = "Select * from HoaDonXuatHangOrderLine Where id_hoa_don_xuat_hang =" + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		try {
			int idOrder;
			int idHoaDon;
			int idMatHang;
			int soLuong;
			int giaKhong;
			HoaDonXuatHangOrderLine orderLine = null;
			while (rs.next()) {
				idOrder = rs.getInt("id");
				idHoaDon = rs.getInt("id_hoa_don_xuat_hang");
				idMatHang = rs.getInt("id_mat_hang");
				soLuong = rs.getInt("so_luong");
				giaKhong = rs.getInt("gia_khong");
				orderLine = new HoaDonXuatHangOrderLine(idOrder, idHoaDon, idMatHang, soLuong, giaKhong);
				list.add(orderLine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public void updateOne(HoaDonXuatHangOrderLine orderLine) {
		String vSQL = "Update HoaDonXuatHangOrderLine Set id_mat_hang = "+orderLine.getIdMatHang()+","+"so_luong="+orderLine.getSoLuong()+
				","+"gia_khong = "+orderLine.getGiaKhong() +" "+"Where id= "+orderLine.getId();
		System.out.println(vSQL);
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

}
