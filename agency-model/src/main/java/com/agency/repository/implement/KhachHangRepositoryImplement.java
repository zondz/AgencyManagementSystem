package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import com.agency.model.KhachHang;
import com.agency.model.database.Database;
import com.agency.repository.KhachHangRepository;

public class KhachHangRepositoryImplement implements KhachHangRepository {
	Database database = Database.getInstance();

	// tested
	public Iterable<KhachHang> getAll() {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM KhachHang";
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		List<KhachHang> khList = new ArrayList<KhachHang>();
		;
		KhachHang kh = null;

		try {
			int id;
			String tenKhachHang;
			String soDienThoai;
			String diaChi;
			while (rs.next()) {
				id = rs.getInt("id");
				tenKhachHang = rs.getString("ten_khach_hang");
				soDienThoai = rs.getString("so_dien_thoai");
				diaChi = rs.getString("dia_chi");
				kh = new KhachHang(id, tenKhachHang, soDienThoai, diaChi);
				khList.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khList;
	}

	// tested
	public KhachHang get(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM KhachHang WHERE id = " + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		KhachHang kh = null;

		try {
			int khId;
			String tenKhachHang;
			String soDienThoai;
			String diaChi;
			while (rs.next()) {
				khId = rs.getInt("id");
				tenKhachHang = rs.getString("ten_khach_hang");
				soDienThoai = rs.getString("so_dien_thoai");
				diaChi = rs.getString("dia_chi");

				kh = new KhachHang(khId, tenKhachHang, soDienThoai, diaChi);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kh;

	}

	// tested
	public void add(KhachHang entity) {
		// TODO Auto-generated method stub
		String vSQL = "INSERT INTO KhachHang(ten_khach_hang,so_dien_thoai,dia_chi)" + " VALUES(" + "\""
				+ entity.getTenKhachHang() + "\"" + "," + "\"" + entity.getSoDienThoai() + "\"" + "," + "\""
				+ entity.getDiaChi() + "\"" + ")";

		database.executeSQLNotReturningResultSet(vSQL);

	}

	// tested
	public void update(KhachHang entity) {
		// TODO Auto-generated method stub
		String vSQL = "UPDATE KhachHang Set ten_khach_hang = " + "\"" + entity.getTenKhachHang() + "\"" + ","
				+ "so_dien_thoai= " + "\"" + entity.getSoDienThoai() + "\"" + "," + " dia_chi=" + "\""
				+ entity.getDiaChi() + "\"" + "WHERE id = " + entity.getId();

		database.executeSQLNotReturningResultSet(vSQL);

	}

	
	
	// tested
	public void deleteById(Integer id) {
		String vSQL = "DELETE FROM KhachHang WHERE id = "+id;
		database.executeSQLNotReturningResultSet(vSQL);
	}

}
