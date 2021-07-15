package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.ThoCongViec;
import com.agency.model.database.Database;
import com.agency.repository.ThoCongViecRepository;

public class ThoCongViecRepositoryImplement implements ThoCongViecRepository {
	Database database;

	public ThoCongViecRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	@Override
	public Iterable<ThoCongViec> getAll() {
		String vSQL = "Select * from ThoCongViec";
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		List<ThoCongViec> list = new ArrayList<ThoCongViec>();
		try {
			int id;
			int idTho;
			int idCongViec;
			int congTho;
			ThoCongViec thoCongViec;
			while (rs.next()) {
				id = rs.getInt("id");
				idTho = rs.getInt("id_tho");
				idCongViec = rs.getInt("id_cong_viec");
				congTho = rs.getInt("cong_tho");
				thoCongViec = new ThoCongViec(id, idTho, idCongViec, congTho);
				list.add(thoCongViec);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ThoCongViec get(Integer id) {
		String vSQL = "Select from ThoCongViec Where id = " + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		ThoCongViec thoCongViec = null;
		try {
			int idThoCongViec;
			int idTho;
			int idCongViec;
			int congTho;

			while (rs.next()) {
				idThoCongViec = rs.getInt("id");
				idTho = rs.getInt("id_tho");
				idCongViec = rs.getInt("id_cong_viec");
				congTho = rs.getInt("cong_tho");
				thoCongViec = new ThoCongViec(idThoCongViec, idTho, idCongViec, congTho);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thoCongViec;
	}

	@Override
	public void deleteById(Integer id) {
		String vSQL = "Delete from ThoCongViec Where id = " + id;
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	@Override
	public void add(ThoCongViec entity) {
		String vSQL = " Insert into ThoCongViec(id_tho,id_cong_viec,cong_tho)VALUES(" + entity.getIdTho() + ","
				+ entity.getIdCongViec() + "," + entity.getCongTho()+");";
		System.out.println(vSQL);
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	@Override
	public void update(ThoCongViec entity) {
		String vSQL = "Update ThoCongViec Set id_tho= " + entity.getIdTho() + ",id_cong_viec = "
				+ entity.getIdCongViec() + ",cong_tho= " + entity.getCongTho()

				+ "where id = " + entity.getId();
		this.database.executeSQLNotReturningResultSet(vSQL);
	}
	
	@Override
	public void updateThoCongViecChoMotCongViec(List<ThoCongViec> thoCongViecList) {
		ThoCongViec temp;
		for (int i = 0; i < thoCongViecList.size(); i++) {
			temp = thoCongViecList.get(i);
			String vSQL = "Update ThoCongViec Set id_tho = " + temp.getIdTho() + "," + "id_cong_viec = "
					+ temp.getIdCongViec() + "," + "cong_tho= " + temp.getCongTho() + " where id= " + temp.getId();
			
			//System.out.println(vSQL);
			this.database.executeSQLNotReturningResultSet(vSQL);
		}

	}
	
	
	@Override
	public List<ThoCongViec> getListThoCongViecByIdCongViec(Integer id) {
		String vSQL = "Select * from ThoCongViec Where id_cong_viec =" + id;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		List<ThoCongViec> list = new ArrayList<ThoCongViec>();
		try {
			int idThoCongViec;
			int idTho;
			int idCongViec;
			int congTho;
			ThoCongViec thoCongViec = null;
			while (rs.next()) {
				idThoCongViec = rs.getInt("id");
				idTho = rs.getInt("id_tho");
				idCongViec = rs.getInt("id_cong_viec");
				congTho = rs.getInt("cong_tho");
				thoCongViec = new ThoCongViec(idThoCongViec, idTho, idCongViec, congTho);
				list.add(thoCongViec);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
