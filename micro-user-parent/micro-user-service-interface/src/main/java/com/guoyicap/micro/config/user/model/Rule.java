package com.guoyicap.micro.config.user.model;

import java.io.Serializable;
import java.util.List;

public class Rule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 668413134711926586L;
	private Integer id;//主键
	private String name;//名称
	private String rule; //权限 如:create
	private String describe;//描述
	private List<Role> roles;//角色  
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
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
