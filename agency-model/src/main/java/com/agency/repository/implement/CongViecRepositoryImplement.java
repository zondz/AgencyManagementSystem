package com.agency.repository.implement;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.management.InvalidAttributeValueException;

import com.agency.model.CongViec;
import com.agency.model.database.Database;
import com.agency.repository.CongViecRepository;

public class CongViecRepositoryImplement implements CongViecRepository{
	Database database ;
	public CongViecRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}
	
	//tested
	public Iterable<CongViec> getAll() {
		// TODO Auto-generated method stub
		
		String vSQL = "SELECT * FROM CongViec";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		List<CongViec> cvList = new ArrayList<>();
		
		try {
			int id;
			int idKhachHang;
			String tenCongViec;
			double tongChiPhiMatHang;
			double tongCongTho;
			LocalDate ngayBatDau;
			CongViec cv ;
			while(rs.next()) {
				id = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tenCongViec = rs.getString("ten_cong_viec");
				tongChiPhiMatHang = rs.getDouble("tong_chi_phi_mat_hang");
				tongCongTho = rs.getDouble("tong_cong_tho");
				ngayBatDau = rs.getDate("ngay_bat_dau").toLocalDate();
				//int id, int idKhachHang, String tenCongViec, double tongChiPhiMatHang,
				//double tongCongTho, LocalDate ngayBatDau
				//
				cv = new CongViec(id,idKhachHang,tenCongViec,tongChiPhiMatHang,tongCongTho,ngayBatDau);
				cvList.add(cv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cvList;
	}

	
	// tested
	public CongViec get(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM CongViec WHERE id ="+id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		CongViec cv = null;
		try {
			int idCongViec;
			int idKhachHang;
			String tenCongViec;
			double tongChiPhiMatHang;
			double tongCongTho;
			LocalDate ngayBatDau;
		
			while(rs.next()) {
				idCongViec = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tenCongViec = rs.getString("ten_cong_viec");
				tongChiPhiMatHang = rs.getDouble("tong_chi_phi_mat_hang");
				tongCongTho = rs.getDouble("tong_cong_tho");
				ngayBatDau = rs.getDate("ngay_bat_dau").toLocalDate();
				//int id, int idKhachHang, String tenCongViec, double tongChiPhiMatHang,
				//double tongCongTho, LocalDate ngayBatDau
				//
				cv = new CongViec(idCongViec,idKhachHang,tenCongViec,tongChiPhiMatHang,tongCongTho,ngayBatDau);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return cv;
	}

	
	// tested
	public void add(CongViec entity) {
	String vSQL = "INSERT INTO CongViec(id_khach_hang,ten_cong_viec,tong_chi_phi_mat_hang,tong_cong_tho,ngay_bat_dau)" 
			+"VALUES("+entity.getIdKhachHang()+"," +"\"" + entity.getTenCongViec() +"\"" +"," +entity.getTongChiPhiMatHang()+","
			+entity.getTongCongTho()+","+"\""+Date.valueOf(entity.getNgayBatDau())+"\""+")";
		System.err.println(vSQL);
		database.executeSQLNotReturningResultSet(vSQL);
	}

	
	
	// tested
	public void update(CongViec entity) {
		// TODO Auto-generated method stub
		String vSQL = "update CongViec Set ten_cong_viec= "+"\""+entity.getTenCongViec()+"\""+","+"tong_chi_phi_mat_hang= "+entity.getTongChiPhiMatHang()
		+", tong_cong_tho= "+entity.getTongCongTho()+", ngay_bat_dau = "+"\""+Date.valueOf(entity.getNgayBatDau())+"\""+"Where id = "+entity.getId();
		System.out.println(vSQL);
		database.executeSQLNotReturningResultSet(vSQL);
		
		
	}

	

	
	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "DELETE FROM CongViec Where id = "+id;
		database.executeSQLNotReturningResultSet(vSQL);
		
	}

}
