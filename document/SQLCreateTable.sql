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
trang_thai Varchar(20)
)
Drop table TrangThaiHoaDon
drop table HoaDonXuatHang
Create table HoaDonXuatHang(
id Integer PRIMARY KEY NOT Null Auto_increment ,
id_khach_hang INTEGER ,
tien_van_chuyen INTEGER ,
dat_truoc Integer ,
id_trang_thai_hoa_don Integer NOT NULL,
giam_gia Integer NOT NULL,
foreign key (id_khach_hang) references KhachHang(id) ON DELETE SET NULL,
foreign key(id_trang_thai_hoa_don) references TrangThaiHoaDon(id) ON DELETE CASCADE
)
drop table HoaDonXuatHang
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
Drop table HoaDonXuatHangOrderLine

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

insert into TrangThaiHoaDon(trang_thai)VALUES("ĐãThanhToán"),("CònNợ")

Select * from TrangThaiHoaDon
Select * from HoaDonXuatHang
Select * From HoaDonXuatHangOrderLine
select * from MatHang
Select * from LoaiHang
Select * from MieuTa
Select * from HoaDonNhapHang
Select* from CongViec
Select * from ThoCongViec
Select * from KhachHang
insert Into LoaiHang(loai_hang)VALUES("HộpQueHàn"),("Keo"),("Ống"),("BảnMã"),("ChổiSơn"),("Sơn"),("TúiVít"),("Nhựa"),("Alu"),("Sắt"),("Tôn"),("TấmBêTông");
alter table HoaDonXuatHangOrderLine rename column id_hoa_don to id_hoa_don_xuat_hang
alter table CongViec add column id_hoa_don_xuat_hang Integer references HoaDonXuatHang(id) ON DELETE SET NULL
Insert into HoaDonXuathang(id_khach_hang,tien_van_chuyen,dat_truoc,id_trang_thai_hoa_don,giam_gia)VALUES(1 , 50000 , 20000, 1 , 5000) 
Select * from MatHang
Select * from HoaDonXuatHangOrderLine
Insert into HoaDonXuathangOrderLine(id_hoa_don_xuat_hang,id_mat_hang,so_luong,gia_khong)VALUES (3,1,3,70000)
Insert into MatHang(ten_mat_hang,id_loai_hang,don_vi_tinh,so_luong_ton_kho,gia_niem_yet) VALUES ("Mặt Hàng 1 " ,1 ,"mét",10,50000)
alter table HoaDonXuatHangOrderLine Drop Column don_gia;
 update CongViec Set id_khach_hang =2 ,ten_cong_viec= "Tên công việc updated", ngay_bat_dau =STR_TO_DATE( "2021-7-14","%Y-%m-%d"),id_hoa_don_xuat_hang= 11 Where id = 2
 Select * from HoaDonXuatHang
 update CongViec Set id_hoa_don_xuat_hang = 3 Where id = 2;
 update CongViec Set id_khach_hang =2, ten_cong_viec= "Tên công việc updated", ngay_bat_dau = STR_TO_DATE("2021-07-14"," %Y-%m-%d " ),id_hoa_don_xuat_hang= 17 Where id = 2
 update CongViec Set id_khach_hang =2, ten_cong_viec= "Tên công việc updated", ngay_bat_dau = STR_TO_DATE("2021-07-14","%Y-%m-%d "),id_hoa_don_xuat_hang= 3 Where id = 2;
