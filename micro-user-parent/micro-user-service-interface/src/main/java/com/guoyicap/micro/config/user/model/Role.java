package com.guoyicap.micro.config.user.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6656630823048719890L;
	private Integer id; // 编号
    private String name; //角色名称
    private String description; // 角色描述,UI界面显示使用
    private Integer available; // 是否可用,如果不可用将不会添加给用户 0:可用
    private List<Rule> rules;
    private List<User> users;// 一个角色对应多个用户
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
	public String getDescription() {
		return description;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
