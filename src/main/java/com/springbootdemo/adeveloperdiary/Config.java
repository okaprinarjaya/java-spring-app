package com.springbootdemo.adeveloperdiary;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;


@Configuration
@EnableCouchbaseRepositories(basePackages={"com.springbootdemo.adeveloperdiary"})
public class Config extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Arrays.asList("localhost");
	}

	@Override
	protected String getBucketName() {
		return "judoka"; 
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}

}
