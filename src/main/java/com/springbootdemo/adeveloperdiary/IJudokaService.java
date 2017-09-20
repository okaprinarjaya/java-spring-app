package com.springbootdemo.adeveloperdiary;

import java.util.List;

public interface IJudokaService {
	Judoka findOne(String id);
	List<Judoka> findAll();
	List<Judoka> findByName(String name);
	
	void create(Judoka judoka);
	void update(Judoka judoka);
	void delete(Judoka judoka);
}
