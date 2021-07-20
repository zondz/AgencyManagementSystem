package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonNhapHang;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonNhapHangRepository;

public class HoaDonNhapHangRepositoryImplement implements HoaDonNhapHangRepository {
	Database database;

	public HoaDonNhapHangRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	@Override
	public Iterable<HoaDonNhapHang> getAll() {
		List<HoaDonNhapHang> list = new ArrayList<HoaDonNhapHang>();

		String vSQL = "SELECT * From HoaDonNhapHang";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		try {
			int id;
			int idNhaCungCap;
			LocalDate ngayCungCap;
			HoaDonNhapHang hoaDon = null;
			while (rs.next()) {
				id = rs.getInt("id");
				idNhaCungCap = rs.getInt("id_nha_cung_cap");
				ngayCungCap = rs.getDate("ngay_cung_cap").toLocalDate();
				hoaDon = new HoaDonNhapHang(id, idNhaCungCap, ngayCungCap);
				list.add(hoaDon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HoaDonNhapHang get(Integer id) {
		String vSQL = "Select * from HoaDonNhapHang Where id = " + id;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		HoaDonNhapHang hoaDon = null;
		try {
			int idHoaDon;
			int idNhaCungCap;
			LocalDate ngayCungCap;
	
			while (rs.next()) {
				idHoaDon = rs.getInt("id");
				idNhaCungCap = rs.getInt("id_nha_cung_cap");
				ngayCungCap = rs.getDate("ngay_cung_cap").toLocalDate();
				hoaDon = new HoaDonNhapHang(idHoaDon, idNhaCungCap, ngayCungCap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoaDon;
	}

	@Override
	public void add(HoaDonNhapHang entity) {
		String vSQL = "Insert Into HoaDonNhapHang(id_nha_cung_cap,ngay_cung_cap)VALUES("
				+entity.getidNhaCungCap()+","+"STR_TO_DATE("+"\""+entity.getNgayCungCap()+"\""+","
				+"\""+"%Y-%m-%d"+"\"" +")"+");";
		System.out.println(vSQL);
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	@Override
	public void update(HoaDonNhapHang entity) {
		String vSQL = "Update HoaDonNhapHang Set id_nha_cung_cap = " + entity.getidNhaCungCap() +","+"ngay_cung_cap = "
			+"STR_TO_DATE("+"\"" +	entity.getNgayCungCap()+"\""+","+"\"" +"%Y-%m-%d" +"\"" +")"
				+"where id = "+entity.getId();
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	@Override
	public void deleteById(Integer id) {
		String vSQL = "Delete From HoaDonNhapHang Where id = "+id;
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	@Override
	public HoaDonNhapHang getLatestRecord() {
		String vSQL = "select *from HoaDonNhapHang ORDER BY id DESC LIMIT 1;";
		ResultSet rs =this.database.executeSQLReturningResultSet(vSQL);
		HoaDonNhapHang hoaDon = null;
		try {
			int id ;
			int idNhaCungCap;
			LocalDate ngayCungCap;
			while(rs.next()) {
				id = rs.getInt("id");
				idNhaCungCap = rs.getInt("id_nha_cung_cap");
				ngayCungCap = rs.getDate("ngay_cung_cap").toLocalDate();
				hoaDon = new HoaDonNhapHang(id,idNhaCungCap,ngayCungCap);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoaDon;
	}

}
