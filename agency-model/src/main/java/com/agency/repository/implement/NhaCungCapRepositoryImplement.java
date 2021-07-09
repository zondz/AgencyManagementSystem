package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.LoaiNguon;
import com.agency.model.NhaCungCap;
import com.agency.model.database.Database;
import com.agency.repository.NhaCungCapRepository;

public class NhaCungCapRepositoryImplement implements NhaCungCapRepository {
	Database database;

	public NhaCungCapRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	// tested
	public Iterable<NhaCungCap> getAll() {
		String vSQL = "SELECT * FROM NhaCungCap";
		List<NhaCungCap> list = new ArrayList<NhaCungCap>();
		NhaCungCap ncc = null;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		try {
			int id;
			String ten;
			LoaiNguon loaiNguon;
			String soDienThoai;
			String diaChi;

			while (rs.next()) {
				id = rs.getInt("id");
				ten = rs.getString("ten");
				loaiNguon = LoaiNguon.valueOf(rs.getString("loai_nguon"));
				soDienThoai = rs.getString("so_dien_thoai");
				diaChi = rs.getString("dia_chi");
				ncc = new NhaCungCap(id, ten, loaiNguon, soDienThoai, diaChi);
				list.add(ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// tested
	public NhaCungCap get(Integer id) {
		String vSQL = "SELECT * FROM NhaCungCap WHERE id = " + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		NhaCungCap ncc = null;
		try {
			int nguonId;
			String ten;
			LoaiNguon loaiNguon;
			String soDienThoai;
			String diaChi;
			while (rs.next()) {
				nguonId = rs.getInt("id");
				ten = rs.getString("ten");
				loaiNguon = LoaiNguon.valueOf(rs.getString("loai_nguon"));
				soDienThoai = rs.getString("so_dien_thoai");
				diaChi = rs.getString("dia_chi");
				ncc = new NhaCungCap(nguonId, ten, loaiNguon, soDienThoai, diaChi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ncc;
	}

	// tested
	public void add(NhaCungCap entity) {
		// TODO Auto-generated method stub
		String vSQL = "INSERT INTO NguonCungCap(ten,loai_nguon,so_dien_thoai,dia_chi)" + "VALUES(" + "\""
				+ entity.getTen() + "\"" + "," + "\"" + entity.getLoaiNguon() + "\"" + "," + "\""
				+ entity.getSoDienThoai() + "\"" + "," + "\"" + entity.getDiaChi() + "\"" + ");";
		database.executeSQLNotReturningResultSet(vSQL);
	}
	
	//tested
	public void update(NhaCungCap entity) {
		String vSQL = "UPDATE NguonCungCap SET ten =" + "\"" + entity.getTen() + "\"" + "," + "loai_nguon= " + "\""
				+ entity.getLoaiNguon() + "\"" + "," + "so_dien_thoai= " + "\"" + entity.getSoDienThoai() + "\"" + ","
				+ "dia_chi = " + "\"" + entity.getDiaChi() + "\"" + " WHERE id= " + entity.getId();
		
		database.executeSQLNotReturningResultSet(vSQL);
	}

	
	// ?
	public void delete(NhaCungCap entity) {
		// TODO Auto-generated method stub

	}

	// tested
	public void deleteById(Integer id) {
		String vSQL = "DELETE FROM NhaCungCap WHERE id = "+id;
		database.executeSQLNotReturningResultSet(vSQL);
	}

}
