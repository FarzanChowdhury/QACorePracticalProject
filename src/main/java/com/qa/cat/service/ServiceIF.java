package com.qa.cat.service;

import java.util.List;

public interface ServiceIF<T> {
	
	T create(T t);
	
	List<T> getAll();
	
	T getId(Integer id);
	
	T replace(Integer id, T t);
	
	void remove(Integer id);
}

