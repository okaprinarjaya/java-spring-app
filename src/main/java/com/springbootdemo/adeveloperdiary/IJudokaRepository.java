package com.springbootdemo.adeveloperdiary;

import java.util.List;

import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJudokaRepository extends CrudRepository<Judoka, String> {
	@View(designDocument = "judoka", viewName = "byName")
	List<Judoka> findByName(String name);
}
