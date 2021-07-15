package com.agency.repository.implement;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.CongViec;
import com.agency.model.database.Database;
import com.agency.repository.CongViecRepository;

public class CongViecRepositoryImplement implements CongViecRepository {
	Database database;

	public CongViecRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	// tested
	public Iterable<CongViec> getAll() {
		// TODO Auto-generated method stub

		String vSQL = "SELECT * FROM CongViec";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		List<CongViec> cvList = new ArrayList<>();

		try {
			int id;
			int idKhachHang;
			String tenCongViec;

			LocalDate ngayBatDau;
			CongViec cv;
			int idHoaDonXuatHang;
			while (rs.next()) {
				id = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tenCongViec = rs.getString("ten_cong_viec");
				ngayBatDau = rs.getDate("ngay_bat_dau").toLocalDate();
				idHoaDonXuatHang = rs.getInt("id_hoa_don_xuat_hang");

				cv = new CongViec(id, idKhachHang, idHoaDonXuatHang, tenCongViec, ngayBatDau);
				cvList.add(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cvList;
	}

	// tested
	public CongViec get(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM CongViec WHERE id =" + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		CongViec cv = null;
		try {
			int idCongViec;
			int idKhachHang;
			String tenCongViec;
			LocalDate ngayBatDau;
			int idHoaDonXuatHang;

			while (rs.next()) {
				idCongViec = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tenCongViec = rs.getString("ten_cong_viec");
				
				ngayBatDau = rs.getDate("ngay_bat_dau").toLocalDate();
				idHoaDonXuatHang = rs.getInt("id_hoa_don_xuat_hang");

				cv = new CongViec(id, idKhachHang, idHoaDonXuatHang, tenCongViec, ngayBatDau);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cv;
	}

	public void add(CongViec entity) {
		String vSQL = "INSERT INTO CongViec(id_khach_hang,ten_cong_viec,ngay_bat_dau,id_hoa_don_xuat_hang)" + "VALUES("
				+ entity.getIdKhachHang() + "," + "\"" + entity.getTenCongViec() + "\"" + ","
				+"STR_TO_DATE(" + "\""
				+ Date.valueOf(entity.getNgayBatDau()) + "\""+","+"\""+"%Y-%m-%d" +"\""+")"+ "," + entity.getIdHoaDonXuatHang() + ")";

		database.executeSQLNotReturningResultSet(vSQL);

	}

	// tested
	public void update(CongViec entity) {
		// TODO Auto-generated method stub
		String vSQL = "update CongViec Set " + "id_khach_hang =" + entity.getIdKhachHang() + ", ten_cong_viec= " + "\""
				+ entity.getTenCongViec() + "\"" + "," + " ngay_bat_dau = "  +"STR_TO_DATE("+
				"\"" + Date.valueOf(entity.getNgayBatDau()) +"\""+ "," + "\"%Y-%m-%d \""+"),"
				+ "id_hoa_don_xuat_hang= "
				+ entity.getIdHoaDonXuatHang() + " Where id = " + entity.getId()+";";
		System.out.println(vSQL);
		database.executeSQLNotReturningResultSet(vSQL);

	}

	
	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "DELETE FROM CongViec Where id = " + id;
		database.executeSQLNotReturningResultSet(vSQL);

	}

//	@Override
//	public CongViec getLastRecord() {
//		String vSQL = "SELECT * FROM Table ORDER BY ID DESC LIMIT 1";
//		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
//		CongViec congViec = null;
//
//		try {
//			int id ;
//			int idKhachHang;
//			String tenCongViec;
//			LocalDate ngayBatDau;
//			int idHoaDonXuatHang;
//			while(rs.next()){
//				id = rs.getInt("id");
//				idKhachHang = rs.getInt("id_khach_hang");
//				tenCongViec = rs.getString("ten_cong_viec");
//				ngayBatDau = rs.getDate("ngay_bat_dau").toLocalDate();
//				idHoaDonXuatHang = rs.getInt("id_hoa_don_xuat_hang");
//				congViec  = new CongViec(id,idKhachHang,idHoaDonXuatHang,tenCongViec,ngayBatDau);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return congViec;
//	}

	@Override
	public CongViec findByIdKhachHangAndIdHoaDonXuatHang(int idKhachHang, int idNewHoaDonXuatHang) {
		String vSQL = "Select * From CongViec Where id_khach_hang = "+idKhachHang +" AND id_hoa_don_xuat_hang = "+idNewHoaDonXuatHang;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		CongViec congViec = null;
		try {
			int id;
			int idKhach;
			String tenCongViec;
			LocalDate ngayBatDau;
			int idHoaDon;
			while(rs.next()) {
				id = rs.getInt("id");
				idKhach = rs.getInt("id_khach_hang");
				tenCongViec = rs.getString("ten_cong_viec");
				ngayBatDau  = rs.getDate("ngay_bat_dau").toLocalDate();
				idHoaDon = rs.getInt("id_hoa_don_xuat_hang");
				congViec = new CongViec(id,idKhach,idHoaDon,tenCongViec,ngayBatDau);
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return congViec;
	}

//	@Override
//	public void createCongViec(CongViec entity, List<ThoCongViec> thoCongViecList) {
//		// add to CongViec Table
//		this.add(entity);
//		// get newest Cong Viec id
//		List<CongViec> congViecList = (List<CongViec>) this.getAll();
//		CongViec congViec = congViecList.get(congViecList.size() - 1);
//
//		String vSQL = "Insert Into ThoCongViec (id_tho,id_cong_viec,cong_tho) VALUES ( ";
//		for (int i = 0; i < thoCongViecList.size(); i++) {
//			ThoCongViec temp = thoCongViecList.get(i);
//			vSQL += temp.getIdTho() + "," + congViec.getId() + "," + temp.getCongTho();
//		}
//		vSQL += ");";
//		this.database.executeSQLNotReturningResultSet(vSQL);
//	}


	

}
