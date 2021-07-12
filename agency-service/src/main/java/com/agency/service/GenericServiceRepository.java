package com.agency.service;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceRepository<I extends Serializable, E extends Serializable>{
	List<E> getAll();
	E getById(I id);
	void add(E entity);
	void update(E entity);
	
	void deleteById(I id);
	
}
