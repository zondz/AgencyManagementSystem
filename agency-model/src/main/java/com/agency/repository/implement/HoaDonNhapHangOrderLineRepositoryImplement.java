package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonNhapHangOrderLine;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonNhapHangOrderLineRepository;

public class HoaDonNhapHangOrderLineRepositoryImplement implements HoaDonNhapHangOrderLineRepository {
	Database database;

	public HoaDonNhapHangOrderLineRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	@Override
	public List<HoaDonNhapHangOrderLine> getByHoaDonId(Integer id) {
		String vSQL = "Select * from HoaDonNhapHangOrderLine Where id_hoa_don_nhap_hang	= " + id;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		List<HoaDonNhapHangOrderLine> result = new ArrayList<HoaDonNhapHangOrderLine>();
		try {
			int idOrderLine;
			int idHoaDonNhapHang;
			int idMatHang;
			int soLuong;
			double donGia;
			HoaDonNhapHangOrderLine orderLine = null;
			while (rs.next()) {
				idOrderLine = rs.getInt("id");
				idHoaDonNhapHang = rs.getInt("id_hoa_don_nhap_hang");
				idMatHang = rs.getInt("id_mat_hang");
				soLuong = rs.getInt("so_luong");
				donGia = rs.getDouble("don_gia");
				orderLine = new HoaDonNhapHangOrderLine(idOrderLine, idHoaDonNhapHang, idMatHang, soLuong, donGia);
				result.add(orderLine);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void addManyForOneHoaDon(List<HoaDonNhapHangOrderLine> orderLines) {
		String vSQL = "Insert Into HoaDonNhapHangOrderLine(id_hoa_don_nhap_hang,id_mat_hang,so_luong,don_gia)"
				+"VALUES";
		int count = 1 ;
		for(HoaDonNhapHangOrderLine orderLine : orderLines) {
			if(count == orderLines.size() ) {
				vSQL += "(" + orderLine.getIdHoaDonNhapHang() +","+orderLine.getIdMatHang() +"," 
						+orderLine.getSoLuong()+","+orderLine.getDonGia()+");";
				break;
				
			}
			vSQL += "(" + orderLine.getIdHoaDonNhapHang() +","+orderLine.getIdMatHang() +"," 
					+orderLine.getSoLuong()+","+orderLine.getDonGia()+"),";  
			
			count++;
		}
		System.out.println(vSQL);
		this.database.executeSQLNotReturningResultSet(vSQL);
		
	}

	@Override
	public void update(HoaDonNhapHangOrderLine updateOrderLine) {
		String vSQL = "Update HoaDonNhapHangOrderLine set id_hoa_don_nhap_hang = "+updateOrderLine.getIdHoaDonNhapHang()
		+","+"id_mat_hang = "+ updateOrderLine.getIdMatHang()+","+"so_luong = "+updateOrderLine.getSoLuong()+","
		+"don_gia = " +updateOrderLine.getDonGia() +" Where id = "+updateOrderLine.getId();
		this.database.executeSQLNotReturningResultSet(vSQL);
		
	}

	@Override
	public void deleteById(int id) {
		String vSQL = "Delete From HoaDonNhapHangOrderLine Where id = "+id;
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	@Override
	public List<HoaDonNhapHangOrderLine> getAll() {
		String vSQL = "Select * from HoaDonNhapHangOrderLine";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		List<HoaDonNhapHangOrderLine> result = new ArrayList<HoaDonNhapHangOrderLine>();
		try {
			int id ;
			int idHoaDonNhapHang;
			int idMatHang;
			int soLuong;
			double donGia;
			HoaDonNhapHangOrderLine orderLine = null ;
			while( rs.next()) {
				id = rs.getInt("id");
				idHoaDonNhapHang = rs.getInt("id_hoa_don_nhap_hang");
				idMatHang = rs.getInt("id_mat_hang");
				soLuong = rs.getInt("so_luong");
				donGia = rs.getDouble("don_gia");
				orderLine = new HoaDonNhapHangOrderLine(id,idHoaDonNhapHang,idMatHang,soLuong,donGia);
				result.add(orderLine);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
