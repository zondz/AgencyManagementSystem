package com.agency.repository.implement;

import com.agency.model.HoaDonMuaHang;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonMuaHangRepository;

public class HoaDonMuaHangRepositoryImplement implements HoaDonMuaHangRepository {
	Database database ;
	public HoaDonMuaHangRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}
	public Iterable<HoaDonMuaHang> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public HoaDonMuaHang get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(HoaDonMuaHang entity) {
		String vSQL = "INSERT INTO HoaDonMuaHang(id_khach_hang,tien_van_chuyen,tong_cong,dat_truoc,con_lai)"+"VALUES("
				+entity.getIdKhachHang()+","+entity.getVanChuyen()+","+entity.getTongCong()+","+entity.getDatTruoc()+","+entity.getConLai()+");";
		
		database.executeSQLNotReturningResultSet(vSQL);
	}

	public void update(HoaDonMuaHang entity) {
		// TODO Auto-generated method stub

	}

	public void delete(HoaDonMuaHang entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
