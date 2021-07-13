package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.DonViTinh;
import com.agency.model.LoaiHang;
import com.agency.model.MatHang;
import com.agency.model.database.Database;
import com.agency.repository.MatHangRepository;

public class MatHangRepositoryImplement implements MatHangRepository {
	Database database;

	public MatHangRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();
	}

	public Iterable<MatHang> getAll() {
		String vSQL = "Select * from MatHang";
		List<MatHang> list = new ArrayList<MatHang>();
		ResultSet rs = database.executeSQLReturningResultSet(vSQL);
		try {
			int id;
			String tenMatHang;
			int idLoaiHang;
			String donViTinh;
			int soLuongTonKho;
			int giaNiemYet;
			LoaiHang loaiHang = null;
			MatHang matHang = null;
			while (rs.next()) {
				id = rs.getInt("id");
				tenMatHang = rs.getString("ten_mat_hang");
				idLoaiHang = rs.getInt("id_loai_hang");
				loaiHang = covertFromIdToLoaiHang(idLoaiHang);
				donViTinh = rs.getString("don_vi_tinh");
				soLuongTonKho = rs.getInt("so_luong_ton_kho");
				giaNiemYet = rs.getInt("gia_niem_yet");
				matHang = new MatHang(id, tenMatHang, loaiHang, DonViTinh.valueOf(donViTinh), soLuongTonKho,
						giaNiemYet);
				list.add(matHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public MatHang get(Integer id) {
		String vSQL = "Select * From MatHang where id = " + id;
		MatHang matHang = null;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		try {
			int idMatHang;
			String tenMatHang;
			int idLoaiHang;
			String donViTinh;
			int soLuongTonKho;
			int giaNiemYet;
			LoaiHang loaiHang = null;

			while (rs.next()) {
				idMatHang = rs.getInt("id");
				tenMatHang = rs.getString("ten_mat_hang");
				idLoaiHang = rs.getInt("id_loai_hang");
				loaiHang = covertFromIdToLoaiHang(idLoaiHang);
				donViTinh = rs.getString("don_vi_tinh");
				soLuongTonKho = rs.getInt("so_luong_ton_kho");
				giaNiemYet = rs.getInt("gia_niem_yet");
				matHang = new MatHang(idMatHang, tenMatHang, loaiHang, DonViTinh.valueOf(donViTinh), soLuongTonKho,
						giaNiemYet);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matHang;
	}

	public void add(MatHang entity) {
		int idLoaiHang = convertFromLoaiHangToId(entity.getLoaiHang());
		String vSQL = "Insert Into MatHang(ten_mat_hang,id_loai_hang,don_vi_tinh,so_luong_ton_kho,gia_niem_yet)"
				+ "VALUES(" + entity.getTenMatHang() + "," + idLoaiHang + "," + entity.getDonViTinh().name() + ","
				+ entity.getSoLuong() + "," + entity.getGiaBanTrenDonVi() + ");";
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	public void update(MatHang entity) {
		String vSQL = "Update MatHang Set ten_mat_hang =" + "\"" + entity.getTenMatHang() + "\"" + "id_loai_hang = "
				+ convertFromLoaiHangToId(entity.getLoaiHang()) + "," + "don_vi_tinh = " + "\""
				+ entity.getDonViTinh().name() + "so_luong_ton_kho =" + entity.getSoLuong() + "gia_niem_yet = "
				+ entity.getGiaBanTrenDonVi() + "where id = " + entity.getId();
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	public void deleteById(Integer id) {
		String vSQL = "Delete from MatHang where id = "+id;
		this.database.executeSQLNotReturningResultSet(vSQL);
	}

	public static LoaiHang covertFromIdToLoaiHang(int idLoaiHang) {
		LoaiHang loaiHang = null;
		switch (idLoaiHang) {
		case 1:
			loaiHang = LoaiHang.HộpQueHàn;
			break;
		case 2:
			loaiHang = LoaiHang.Keo;
			break;
		case 3:
			loaiHang = LoaiHang.Ống;
			break;
		case 4:
			loaiHang = LoaiHang.BảnMã;
			break;
		case 5:
			loaiHang = LoaiHang.ChổiSơn;
			break;
		case 6:
			loaiHang = LoaiHang.Sơn;
			break;
		case 7:
			loaiHang = LoaiHang.TúiVít;
			break;
		case 8:
			loaiHang = LoaiHang.Nhựa;
			break;
		case 9:
			loaiHang = LoaiHang.Alu;
			break;
		case 10:
			loaiHang = LoaiHang.Sắt;
			break;
		case 11:
			loaiHang = LoaiHang.Tôn;
			break;
		case 12:
			loaiHang = LoaiHang.TấmBêTông;
			break;
		}
		return loaiHang;
	}

	public static int convertFromLoaiHangToId(LoaiHang loaiHang) {
		int id = 0;

		for (int i = 0; i < LoaiHang.values().length; i++) {
			if (loaiHang.name().contentEquals(LoaiHang.values()[i].name())) {
				id = i++;
				return id;
			}
		}
		return id;
	}
}
