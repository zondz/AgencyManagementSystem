package com.agency.model;

import java.io.Serializable;

public class ThoCongViec implements Serializable{
private int id;
private int idTho;
private int idCongViec;
private int congTho;
public ThoCongViec(int id, int idTho, int idCongViec, int congTho) {
	super();
	this.id = id;
	this.idTho = idTho;
	this.idCongViec = idCongViec;
	this.congTho = congTho;
}
public ThoCongViec(int idTho, int idCongViec, int congTho) {
	super();
	this.idTho = idTho;
	this.idCongViec = idCongViec;
	this.congTho = congTho;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdTho() {
	return idTho;
}
public void setIdTho(int idTho) {
	this.idTho = idTho;
}
public int getIdCongViec() {
	return idCongViec;
}
public void setIdCongViec(int idCongViec) {
	this.idCongViec = idCongViec;
}
public int getCongTho() {
	return congTho;
}
public void setCongTho(int congTho) {
	this.congTho = congTho;
}
@Override
public String toString() {
	return "ThoCongViec [id=" + id + ", idTho=" + idTho + ", idCongViec=" + idCongViec + ", congTho=" + congTho + "]";
}




}
