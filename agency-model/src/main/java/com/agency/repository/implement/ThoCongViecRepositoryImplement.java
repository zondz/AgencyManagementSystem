package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.ThoCongViec;
import com.agency.model.database.Database;
import com.agency.repository.ThoCongViecRepository;

public class ThoCongViecRepositoryImplement implements ThoCongViecRepository{
	
	Database database ;
	public ThoCongViecRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}
	
	//tested
	public Iterable<ThoCongViec> getAll() {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM ThoCongViec ";
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		List<ThoCongViec> list = new ArrayList<>();
		ThoCongViec temp = null;
		try {
			int id;
			int idTho;
			int idCongViec;
			int congTho;
			
			while(rs.next()) {
				id  = rs.getInt("id");
				idTho = rs.getInt("id_tho");
				idCongViec = rs.getInt("id_cong_viec");
				congTho = rs.getInt("cong_tho");
				temp = new ThoCongViec(id,idTho,idCongViec,congTho);
				list.add(temp);
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
	public ThoCongViec get(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "SELECT * FROM ThoCongViec Where id = "+id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		ThoCongViec temp = null;
		try {
			int idThoCongViec;
			int idTho;
			int idCongViec;
			int congTho;
			
			while(rs.next()) {
				idThoCongViec  = rs.getInt("id");
				idTho = rs.getInt("id_tho");
				idCongViec = rs.getInt("id_cong_viec");
				congTho = rs.getInt("cong_tho");
				temp = new ThoCongViec(idThoCongViec,idTho,idCongViec,congTho);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	//tested
	public void add(ThoCongViec entity) {
		String vSQL = "INSERT INTO ThoCongViec(id_tho,id_cong_viec,cong_tho) VALUES ("+entity.getIdTho()+","+entity.getIdCongViec()+","+entity.getCongTho()+");";
		database.executeSQLNotReturningResultSet(vSQL);
	}
	
	// tested
	public void update(ThoCongViec entity) {
		// TODO Auto-generated method stub
		String vSQL = "UPDATE ThoCongViec Set id_tho ="+entity.getIdTho() +", id_cong_viec= "+entity.getIdCongViec()+", cong_tho= "+entity.getCongTho() +" where id= "+entity.getId();
		database.executeSQLNotReturningResultSet(vSQL);
	}

	
	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "DELETE FROM ThoCongViec Where id = "+id;
		database.executeSQLNotReturningResultSet(vSQL);
		
	}

}
