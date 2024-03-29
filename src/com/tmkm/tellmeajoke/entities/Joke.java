package com.tmkm.tellmeajoke.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity
public class Joke {


	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
    @Column(name = "title")
	private String title;

	@NotNull
    @Column(name = "date_inserted")
	private String dateInserted;

	@NotNull

    @Column(name = "inserted_by")
	private String insertedBy;

	@NotNull
	private String path;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDateInserted() {
		return dateInserted;
	}

	public void setDateInserted(String dateInserted) {
		this.dateInserted = dateInserted;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
		
}

