package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.MieuTa;
import com.agency.model.database.Database;
import com.agency.repository.MieuTaRepository;

public class MieuTaRepositoryImplement implements MieuTaRepository {
	Database database;

	public MieuTaRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	public Iterable<MieuTa> getAll() {
		String vSQL = "Select *From MieuTa";
		List<MieuTa> list = new ArrayList<MieuTa>();
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		try {
			int id;
			int idMatHang;
			String mauSac;
			MieuTa mieuTa = null;
			while (rs.next()) {
				id = rs.getInt("id");
				idMatHang = rs.getInt("id_mat_hang");
				mauSac = rs.getString("mau_sac");
				mieuTa = new MieuTa(id, idMatHang, mauSac);
				list.add(mieuTa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public MieuTa get(Integer id) {
		String vSQL = "Select * From MieuTa Where id = " + id;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		MieuTa mieuTa = null;
		try {
			int idMieuTa;
			int idMatHang;
			String mauSac;

			while (rs.next()) {
				idMieuTa = rs.getInt("id");
				idMatHang = rs.getInt("id_mat_hang");
				mauSac = rs.getString("mau_sac");
				mieuTa = new MieuTa(idMieuTa, idMatHang, mauSac);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mieuTa;
	}

	public void add(MieuTa entity) {
		String vSQL = "Insert Into MieuTa(id_mat_hang,mau_sac)VALUES(" + entity.getIdMatHang() + ","
				+ entity.getMauSac() + ");";
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	public void update(MieuTa entity) {
		String vSQL = "Update MieuTa Set id_mat_hang = " + entity.getIdMatHang() + "," + "mau_sac = "
				+ entity.getMauSac() + "Where id = " + entity.getId();
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	public void deleteById(Integer id) {
		String vSQL = "Delete From MieuTa Where id = "+id;
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

}
