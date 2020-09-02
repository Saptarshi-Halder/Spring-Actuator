package com.example.bo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CS_Topic")
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ObjId")
	private int id;
	
	@Basic
	@Column(name = "TopicName")
	private String name;
	
	@Basic
	@Column(name = "Description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
