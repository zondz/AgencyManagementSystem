package com.agency.model;

public class Origin {
	private int id;
	private int mieuTaId;
	private String nguonGocXuatXu;
	private String congTySanXuat;
	public Origin() {
		// TODO Auto-generated constructor stub
	}
	
	public Origin(int id, int mieuTaId, String nguonGocXuatXu, String congTySanXuat) {
		super();
		this.id = id;
		this.mieuTaId = mieuTaId;
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
	}
	
	public Origin(int mieuTaId, String nguonGocXuatXu, String congTySanXuat) {
		super();
		this.mieuTaId = mieuTaId;
		this.nguonGocXuatXu = nguonGocXuatXu;
		this.congTySanXuat = congTySanXuat;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMieuTaId() {
		return mieuTaId;
	}
	public void setMieuTaId(int mieuTaId) {
		this.mieuTaId = mieuTaId;
	}
	public String getNguonGocXuatXu() {
		return nguonGocXuatXu;
	}
	public void setNguonGocXuatXu(String nguonGocXuatXu) {
		this.nguonGocXuatXu = nguonGocXuatXu;
	}
	public String getCongTySanXuat() {
		return congTySanXuat;
	}
	public void setCongTySanXuat(String congTySanXuat) {
		this.congTySanXuat = congTySanXuat;
	}
	@Override
	public String toString() {
		return "Origin [id=" + id + ", mieuTaId=" + mieuTaId + ", nguonGocXuatXu=" + nguonGocXuatXu + ", congTySanXuat="
				+ congTySanXuat + "]";
	}
	
	
	
}
