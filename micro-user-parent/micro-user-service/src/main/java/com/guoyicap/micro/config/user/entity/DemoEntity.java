package com.guoyicap.micro.config.user.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.guoyicap.micro.common.base.BaseEntity;

@Table(name = "`TB_test`")
public class DemoEntity  extends BaseEntity {
	private static final long serialVersionUID = -6695722256864729383L;


    @Column(name = "`id`")
    private Integer id;


    @Column(name = "`name`")
    private String name;


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

   
}