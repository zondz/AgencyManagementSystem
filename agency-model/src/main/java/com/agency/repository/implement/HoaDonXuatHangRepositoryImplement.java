package com.agency.repository.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.agency.model.HoaDonXuatHang;
import com.agency.model.TrangThaiHoaDon;
import com.agency.model.database.Database;
import com.agency.repository.HoaDonXuatHangRepository;

public class HoaDonXuatHangRepositoryImplement implements HoaDonXuatHangRepository {
	Database database;

	public HoaDonXuatHangRepositoryImplement() {
		// TODO Auto-generated constructor stub
		database = Database.getInstance();

	}

	// tested
	@Override
	public Iterable<HoaDonXuatHang> getAll() {
		List<HoaDonXuatHang> list = new ArrayList<HoaDonXuatHang>();
		String vSQL = "SELECT * FROM HoaDonXuatHang";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		try {
			int id;
			int idKhachHang;
			int tienVanChuyen;
			int datTruoc;
			int idTrangThaiHoaDon;
			TrangThaiHoaDon trangThaiHoaDon;
			int giamGia;
			LocalDate ngayViet;
			HoaDonXuatHang hoaDonXuatHang = null;

			while (rs.next()) {
				id = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tienVanChuyen = rs.getInt("tien_van_chuyen");
				datTruoc = rs.getInt("dat_truoc");
				giamGia = rs.getInt("giam_gia");
				idTrangThaiHoaDon = rs.getInt("id_trang_thai_hoa_don");
				ngayViet = rs.getDate("ngay_viet").toLocalDate();
				if (idTrangThaiHoaDon == 1) {
					trangThaiHoaDon = TrangThaiHoaDon.ĐãThanhToán;
				} else {
					trangThaiHoaDon = TrangThaiHoaDon.CònNợ;
				}
				// id , idKhachHang,vanChuyen , orderLine, giam gia , dat truoc
				hoaDonXuatHang = new HoaDonXuatHang(id, idKhachHang, tienVanChuyen, datTruoc, giamGia, trangThaiHoaDon,
						ngayViet);
				list.add(hoaDonXuatHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// tested
	@Override
	public HoaDonXuatHang get(Integer id) {
		String vSQL = "SELECT* FROM HoaDonXuatHang Where id = " + id;
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		HoaDonXuatHang hoaDonXuatHang = null;

		try {
			int idHoaDon;
			int idKhachHang;
			int tienVanChuyen;
			int datTruoc;
			int idTrangThaiHoaDon;
			TrangThaiHoaDon trangThaiHoaDon;
			LocalDate ngayViet;
			int giamGia;
			while (rs.next()) {
				idHoaDon = rs.getInt("id");
				idKhachHang = rs.getInt("id_khach_hang");
				tienVanChuyen = rs.getInt("tien_van_chuyen");
				datTruoc = rs.getInt("dat_truoc");
				giamGia = rs.getInt("giam_gia");
				idTrangThaiHoaDon = rs.getInt("id_trang_thai_hoa_don");
				ngayViet = rs.getDate("ngay_viet").toLocalDate();
				if (idTrangThaiHoaDon == 1) {
					trangThaiHoaDon = TrangThaiHoaDon.ĐãThanhToán;
				} else {
					trangThaiHoaDon = TrangThaiHoaDon.CònNợ;
				}
				// id , idKhachHang,vanChuyen , orderLine, giam gia , dat truoc
				hoaDonXuatHang = new HoaDonXuatHang(idHoaDon, idKhachHang, tienVanChuyen, datTruoc, giamGia,
						trangThaiHoaDon, ngayViet);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoaDonXuatHang;
	}

	// tested
	@Override
	public void add(HoaDonXuatHang entity) {

		int idTrangThaiHoaDon = 0;
		TrangThaiHoaDon status = entity.getTrangThaiHoaDon();
		TrangThaiHoaDon[] statusList = TrangThaiHoaDon.values();
		for (int i = 0; i < statusList.length; i++) {
			if (statusList[i].name().equalsIgnoreCase(status.name())) {
				switch (statusList[i].name()) {
				case "ĐãThanhToán":
					idTrangThaiHoaDon = 1;
					break;
				case "CònNợ":
					idTrangThaiHoaDon = 2;

				}
			} else {

			}
		}
		String vSQL = "Insert into HoaDonXuatHang(id_khach_hang,tien_van_chuyen,dat_truoc,id_trang_thai_hoa_don,giam_gia,ngay_viet)VALUES("
				+ entity.getIdKhachHang() + "," + entity.getVanChuyen() + "," + entity.getDatTruoc() + ","
				+ idTrangThaiHoaDon + "," + entity.getGiamGia() + "," + "STR_TO_DATE(" + "\"" + entity.getNgayViet()
				+ "\"" + "," + "\"" + "%Y-%m-%d" + "\"" + ")" + ")";

		database.executeSQLNotReturningResultSet(vSQL);

	}

	// tested
	@Override
	public void update(HoaDonXuatHang entity) {
		// TODO Auto-generated method stub
		int idTrangThaiHoaDon = entity.getTrangThaiHoaDon().equals(TrangThaiHoaDon.CònNợ) ? 2 : 1;

		String vSQL = "Update HoaDonXuatHang Set tien_van_chuyen= " + entity.getVanChuyen() + "," + "dat_truoc= "
				+ entity.getDatTruoc() + "," + "id_trang_thai_hoa_don = " + idTrangThaiHoaDon + "," + "giam_gia= "
				+ entity.getGiamGia() + "," + "ngay_viet= " + "STR_TO_DATE("
				+ "\"" + entity.getNgayViet() + "\"" + ","+"\"" +"%Y-%m-%d" +"\"" +") "
				+ " Where id= " + entity.getId() + ";";
		System.out.println(vSQL);
		database.executeSQLNotReturningResultSet(vSQL);

	}

	// tested

	@Override
	public void deleteById(Integer id) {
		String vSQL = "Delete from HoaDonXuatHang Where id  = " + id;
		this.database.executeSQLNotReturningResultSet(vSQL);

	}

	@Override
	public HoaDonXuatHang findByIdKhacHangAndNgayViet(int idKhachHang, LocalDate ngayViet) {
		String vSQL = "Select * from HoaDonXuatHang Where id_khach_hang =" + idKhachHang + " " + "AND ngay_viet ="
				+ "STR_TO_DATE(" + "\"" + ngayViet + "\"" + "," + "\"" + "%Y-%m-%d" + "\"" + ")";
		ResultSet rs = this.database.executeSQLReturningResultSet(vSQL);
		HoaDonXuatHang hoaDonXuatHang = null;
		try {
			int id;
			int idKhach;
			int tienVanChuyen;
			int datTruoc;
			int idTrangThaiHoaDon;
			TrangThaiHoaDon status;
			int giamGia;
			LocalDate ngayVietHoaDon;
			while (rs.next()) {
				id = rs.getInt("id");
				idKhach = rs.getInt("id_khach_hang");
				tienVanChuyen = rs.getInt("tien_van_chuyen");
				datTruoc = rs.getInt("dat_truoc");
				idTrangThaiHoaDon = rs.getInt("id_trang_thai_hoa_don");
				if (idTrangThaiHoaDon == 1) {
					status = TrangThaiHoaDon.ĐãThanhToán;
				} else {
					status = TrangThaiHoaDon.CònNợ;
				}
				giamGia = rs.getInt("giam_gia");
				ngayVietHoaDon = rs.getDate("ngay_viet").toLocalDate();
				hoaDonXuatHang = new HoaDonXuatHang(id, idKhach, tienVanChuyen, datTruoc, giamGia, status,
						ngayVietHoaDon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hoaDonXuatHang;
	}

}
