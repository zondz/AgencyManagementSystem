package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agency.model.KichThuoc;
import com.agency.model.database.Database;
import com.agency.repository.KichThuocRepository;

public class KichThuocRepositoryImplement implements KichThuocRepository {
	Database database;

	public KichThuocRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();

	}

	@Override
	public KichThuoc getByMieuTaId(int idMieuTa) {
		String vSQL = "Select * from KichThuoc Where id_mieu_ta = " + idMieuTa;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		KichThuoc kichThuoc = null;

		try {
			int id;
			int mieuTaId;
			double chuVi;
			double dienTich;
			double doDay;
			while (rs.next()) {
				id = rs.getInt("id");
				mieuTaId = rs.getInt("id_mieu_ta");
				chuVi = rs.getDouble("chu_vi");
				dienTich = rs.getDouble("dien_tich");
				doDay = rs.getDouble("do_day");
				kichThuoc = new KichThuoc(id, mieuTaId, chuVi, dienTich, doDay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kichThuoc;
	}

	@Override
	public void add(KichThuoc kichThuoc) {
		String vSQL = "Insert Into KichThuoc(id_mieu_ta,chu_vi,dien_tich,do_day)" + "VALUES(" + kichThuoc.getIdMieuTa()
				+ "," + kichThuoc.getChuVi() + "," + kichThuoc.getDienTich() + "," + kichThuoc.getDoDay() + ")";
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	@Override
	public void updateForOneMieuTa(KichThuoc kichThuoc) {
		String vSQL ="Update KichThuoc Set chu_vi =" +kichThuoc.getChuVi()+","+"dien_tich= "+kichThuoc.getDienTich()+","+"do_day = "+kichThuoc.getDoDay()
					+" Where id_mieu_ta = "+kichThuoc.getId();
		
		this.database.executeSQLNotReturningResultSet(vSQL);
		
	}

}
