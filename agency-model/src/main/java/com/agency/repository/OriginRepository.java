package com.agency.repository;

import com.agency.model.Origin;

public interface OriginRepository {
	Origin getByMieuTaId(int mieuTaid);
	void add(Origin origin);
	void updateForOneMieuTa(Origin origin);
}
