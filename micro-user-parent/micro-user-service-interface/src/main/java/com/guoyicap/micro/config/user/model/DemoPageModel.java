package com.guoyicap.micro.config.user.model;

import java.io.Serializable;

import org.springframework.web.bind.annotation.PathVariable;

import com.guoyicap.micro.common.base.BaseModel;

/**
 * Created on 2016/7/05 11:44.
 * 
 * id 	INTEGER 	10 	
 * username 	VARCHAR 	32 	
 * password 	VARCHAR 	32 	
 */

public class DemoPageModel extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8494364379970557021L;
    
	private Integer pageNum;
	private Integer pageSize;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
