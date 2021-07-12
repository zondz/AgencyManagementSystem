create table LoaiHang(
id Integer NOT NULL PRIMARY KEY auto_increment,
loai_hang Varchar(20) NOT NULL
)

Create Table MatHang(
id Integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
ten_mat_hang Varchar(50),
id_loai_hang Integer NOT NULL,
don_vi_tinh Varchar(20),
so_luong_ton_kho Integer NOT NULL,
gia_niem_yet Integer NOT NULL,
Foreign key (id_loai_hang) references LoaiHang(id)
)

Create table TrangThaiHoaDon(
id Integer NOT NULL PRIMARY KEY AUTO_INCREMENT ,
trang_thai Varchar(10)
)

drop table HoaDonXuatHang
Create table HoaDonXuatHang(
id Integer PRIMARY KEY NOT Null Auto_increment ,
id_khach_hang INTEGER ,
tien_van_chuyen INTEGER ,
dat_truoc Integer ,
id_trang_thai_hoa_don Integer NOT NULL,
giam_gia Integer NOT NULL,
foreign key (id_khach_hang) references KhachHang(id) ON DELETE SET NULL,
foreign key(id_trang_thai_hoa_don) references TrangThaiHoaDon(id)
)

create table HoaDonXuatHangOrderLine(
id Integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_hoa_don INTEGER NOT NULL ,
id_mat_hang Integer ,
so_luong Integer ,
don_gia Double NOT NULL,
gia_khong Double ,
foreign key (id_hoa_don) references HoaDonXuatHang(id) ON DELETE CASCADE,
foreign key(id_mat_hang) references MatHang(id) ON DELETE SET NULL 
)

Create table MieuTa(
id Integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_mat_hang INTEGER NOT NULL ,
mau_sac VARCHAR (10),
foreign key (id_mat_hang) references MatHang(id) ON DELETE CASCADE 
)


Create table KichThuoc(
id Integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_mieu_ta INTEGER NOT NULL,
chu_vi Double ,
dien_tich Double ,
do_day Double ,
foreign key(id_mieu_ta) references MieuTa(id) ON DELETE CASCADE 
)
Create Table Origin (
id Integer NOT NULL PRIMARY KEY AUTO_INCREMENT ,
id_mieu_ta Integer NOT NULL ,
nguon_goc_xuat_xu Varchar(30),
cong_ty_san_xuat Varchar (30),
foreign key(id_mieu_ta) references MieuTa(id) ON DELETE CASCADE 
)

create table NhaCungCap(
id Integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
ten Varchar(50) NOT NULL,
id_loai_nha_cung_cap Integer ,
so_dien_thoai Varchar(11),
dia_chi Varchar(50),
foreign key(id_loai_nha_cung_cap) References LoaiNhaCungCap(id) ON DELETE SEt NULL

)
Create table LoaiNhaCungCap(
id Integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
loai_nguon Varchar(20) NOT NULL 
)

Create table HoaDonNhapHang(
id Integer Primary Key Auto_increment Not NULL ,
id_nha_cung_cap Integer ,
ngay_cung_cap Date NOT NULL ,
foreign key (id_nha_cung_cap ) references NhaCungCap(id) ON DELETE SET NULL 
)

Create table HoaDonNhapHangOrderLine(
id Integer Primary key NOT NULL Auto_Increment ,
id_hoa_don_nhap_hang Integer NOT NULL , 
id_mat_hang Integer ,
so_luong Integer ,
don_gia Double ,
foreign key (id_hoa_don_nhap_hang ) references HoaDonNhapHang(id) ON DELETE CASCADE , 
foreign key (id_mat_hang) references MatHang(id) ON DELETE SET NULL
)
drop table HoaDonNhapHangOrderLine

loaihang