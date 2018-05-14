package com.guoyicap.micro.config.user.model;

import java.io.Serializable;

public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6057338241581438904L;
	private Integer id;
	private String name;
	private String legalPerson;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public Company(Integer id, String name, String legalPerson) {
		this.id = id;
		this.name = name;
		this.legalPerson = legalPerson;
	}
	public Company() {
		super();
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", legalPerson=" + legalPerson + "]";
	}
	
}
