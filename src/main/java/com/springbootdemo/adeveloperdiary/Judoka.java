package com.springbootdemo.adeveloperdiary;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Judoka {
	@Id
	private String id;
	
	@Field
	@NotNull
	private String name;
	
	@Field
	@NotNull
	private String country_origin;
	
	@Field
	@NotNull
	private String photo_profile_url_path;
	
	@Field
	@NotNull
	private DateTime created;
	
	@Field
	private DateTime updated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_origin() {
		return country_origin;
	}

	public void setCountry_origin(String country_origin) {
		this.country_origin = country_origin;
	}

	public String getPhoto_profile_url_path() {
		return photo_profile_url_path;
	}

	public void setPhoto_profile_url_path(String photo_profile_url_path) {
		this.photo_profile_url_path = photo_profile_url_path;
	}

	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}	
}
