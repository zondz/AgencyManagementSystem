package com.agency.repository;

import com.agency.model.KichThuoc;

public interface KichThuocRepository {
	KichThuoc getByMieuTaId(int mieuTaId);
	void add(KichThuoc kichThuoc);
	void updateForOneMieuTa(KichThuoc kichThuoc);
}
