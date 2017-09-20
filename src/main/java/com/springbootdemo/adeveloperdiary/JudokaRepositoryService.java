package com.springbootdemo.adeveloperdiary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("JudokaRepositoryService")
public class JudokaRepositoryService implements IJudokaService {
	
	@Autowired
	private IJudokaRepository repository;
	
	
	@Override
	public Judoka findOne(String id) {
		return repository.findOne(id);
	}

	@Override
	public List<Judoka> findAll() {
		List<Judoka> judokas = new ArrayList<Judoka>();
		Iterator<Judoka> iter = repository.findAll().iterator();
		while (iter.hasNext()) {
			judokas.add(iter.next());
		}

		return judokas;
	}

	@Override
	public List<Judoka> findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public void create(Judoka judoka) {
		judoka.setCreated(DateTime.now());
		repository.save(judoka);
	}

	@Override
	public void update(Judoka judoka) {
		judoka.setUpdated(DateTime.now());
		repository.save(judoka);
	}

	@Override
	public void delete(Judoka judoka) {
		repository.delete(judoka);
	}
	
}
