package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.Tho;
import com.agency.model.database.Database;
import com.agency.repository.ThoRepository;

public class ThoRepositoryImplement implements ThoRepository {
	Database database = Database.getInstance();

	// tested
	public Iterable<Tho> getAll() {
		int id;
		String ten;
		String soDienThoai;
		List<Tho> result = new ArrayList<Tho>();
		String vSQL = "Select*from Tho";
		ResultSet resultSet = database.executeSQLReturningResultSet(vSQL);
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				ten = resultSet.getString("ten");
				soDienThoai = resultSet.getString("so_dien_thoai");
				Tho temp = new Tho(id, ten, soDienThoai);
				result.add(temp);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAttributeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// tested
	public Tho get(Integer id) {
		int thoId;
		String ten;
		String soDienThoai;
		Tho temp = null;
		String vSQL = "SELECT*FROM Tho where id =" + id;
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		try {
			while (rs.next()) {
				thoId = rs.getInt("id");
				ten = rs.getString("ten");
				soDienThoai = rs.getString("so_dien_thoai");
				temp = new Tho(thoId, ten, soDienThoai);
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

	
	// tested
	public void add(Tho entity) {
		// TODO Auto-generated method stub
		String vSQL = "INSERT INTO Tho(ten,so_dien_thoai) VALUES ("+"\""+ entity.getTen() +"\""+ ","
				+"\""+ entity.getSoDienThoai()+"\"" + ");";
		database.executeSQLNotReturningResultSet(vSQL);
	}
	
	
	// tested
	public void update(Tho entity) {
		// TODO Auto-generated method stub
		String vSQL = "UPDATE Tho SET ten = "+"\""+entity.getTen()+"\""+",so_dien_thoai= "+"\"" +entity.getSoDienThoai()+"\"" +" WHERE id= "+entity.getId();
		database.executeSQLNotReturningResultSet(vSQL);
	}
	

	// tested
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		String vSQL = "DELETE FROM Tho Where id = "+id;
		database.executeSQLNotReturningResultSet(vSQL);
	}

}
