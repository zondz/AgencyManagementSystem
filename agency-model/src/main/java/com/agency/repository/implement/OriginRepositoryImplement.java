package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.parser.Entity;

import com.agency.model.Origin;
import com.agency.model.database.Database;
import com.agency.repository.OriginRepository;

public class OriginRepositoryImplement implements OriginRepository {
	Database database;

	public OriginRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	@Override
	public Origin getByMieuTaId(int mieuTaId) {
		String vSQL = "Select * from Origin Where id_mieu_ta= " + mieuTaId;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		Origin result = null;
		try {
			int id;
			int idMieuTa;
			String nguonGocXuatXu;
			String congTySanXuat;
			while (rs.next()) {
				id = rs.getInt("id");
				idMieuTa = rs.getInt("id_mieu_ta");
				nguonGocXuatXu = rs.getString("nguon_goc_xuat_xu");
				congTySanXuat = rs.getString("cong_ty_san_xuat");
				result = new Origin(id, idMieuTa, nguonGocXuatXu, congTySanXuat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void add(Origin origin) {
		String vSQL = "Insert into Origin(id_mieu_ta,nguon_goc_xuat_xu,cong_ty_san_xuat)" + "VALUES( "
				+ origin.getMieuTaId() + "," +"\"" +origin.getNguonGocXuatXu()+"\"" + "," +"\"" +origin.getCongTySanXuat()+"\"" + ")";
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	@Override
	public void updateForOneMieuTa(Origin origin) {
		String vSQL = "Update Origin Set id_mieu_ta = "+origin.getMieuTaId()+","+"nguon_goc_xuat_xu = "
	+"\"" +origin.getNguonGocXuatXu()+"\""+","+"cong_ty_san_xuat = "+"\""+origin.getCongTySanXuat()+"\"" +" Where id_mieu_ta ="+origin.getMieuTaId();
		
		this.database.executeSQLNotReturningResultSet(vSQL);
	}
}
