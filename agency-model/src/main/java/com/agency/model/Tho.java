package com.agency.model;

import java.io.Serializable;

import javax.naming.directory.InvalidAttributeValueException;

public class Tho implements Serializable {
	public static final int MAX_LENGTH_TEN = 50;
	public static final int MAX_LENGTH_SO_DIEN_THOAI = 11;
	public static final int MIN_LENGTH_SO_DIEN_THOAI = 10;
	private int id;
	private String ten;
	private String soDienThoai;

	public Tho(int id, String ten, String soDienThoai) throws InvalidAttributeValueException {
		super();

		this.id = id;
		this.ten = ten;
		this.soDienThoai = soDienThoai;
	}

	public Tho(String ten, String soDienThoai) {
		super();

		this.ten = ten;
		this.soDienThoai = soDienThoai;
	}

	public int getId() {
		return id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {

		this.ten = ten;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws InvalidAttributeValueException {
		if (!this.validateSoDienThoai(soDienThoai))
			throw new InvalidAttributeValueException("Số điện thoại không hợp lệ");

		this.soDienThoai = soDienThoai;
	}

	protected boolean validateTen(String ten) {
		return ten != null && ten.length() >= 0 && ten.length() <= this.MAX_LENGTH_TEN;

	}

	protected boolean validateSoDienThoai(String soDienThoai) {
		return soDienThoai != null && soDienThoai.length() >= this.MIN_LENGTH_SO_DIEN_THOAI
				&& soDienThoai.length() <= this.MAX_LENGTH_SO_DIEN_THOAI;

	}

	@Override
	public String toString() {
		return "Tho [id=" + id + ", ten=" + ten + ", soDienThoai=" + soDienThoai + "]";
	}

}
