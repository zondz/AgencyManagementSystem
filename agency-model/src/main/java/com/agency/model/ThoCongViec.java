package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class ThoCongViec implements Serializable {
	private static final int MIN_CONG_THO = 0;
	private int id;
	private int idTho;
	private int idCongViec;
	private int congTho;

	
	
	public ThoCongViec(int idTho, int congTho) {
		super();
		this.idTho = idTho;
		this.congTho = congTho;
	}

	public ThoCongViec(int id, int idTho, int idCongViec, int congTho) throws InvalidAttributeValueException {
		super();
		if (!this.validateCongTho(congTho))
			throw new InvalidAttributeValueException("Công thợ không hợp lệ");
		this.id = id;
		this.idTho = idTho;
		this.idCongViec = idCongViec;
		this.congTho = congTho;
	}

	public ThoCongViec(int idTho, int idCongViec, int congTho) throws InvalidAttributeValueException {
		super();
		if (!this.validateCongTho(congTho))
			throw new InvalidAttributeValueException("Công thợ không hợp lệ");

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

	protected boolean validateCongTho(int congTho) {
		return congTho >= this.MIN_CONG_THO;
	}

	@Override
	public String toString() {
		return "ThoCongViec [id=" + id + ", idTho=" + idTho + ", idCongViec=" + idCongViec + ", congTho=" + congTho
				+ "]";
	}

}
