package com.guoyicap.micro.config.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.common.enums.RespStatusEnum;
import com.guoyicap.micro.config.user.dao.DemoDao;
import com.guoyicap.micro.config.user.entity.DemoEntity;
import com.guoyicap.micro.config.user.model.Company;
import com.guoyicap.micro.config.user.model.DemoPageModel;
import com.guoyicap.micro.config.user.service.DemoService;

/**
 * Created on 2016/7/05 11:44.
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
@RestController
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	private DemoDao demoDao;
	
	@Override
	public List<String> demo(Integer id) {
		List<DemoEntity> list =demoDao.demo();
		List<String> result = new ArrayList<String>();
		
		for(int i =0;i<list.size();i++) {
			result.add(list.get(i).getName());
		}
		
		return result;
	}

	@Override
	public MsgModel<Page> demo2(@RequestBody DemoPageModel model) {
		Integer pageNum = model.getPageNum() == null ? 1 : model.getPageNum();  
		Integer pageSize = model.getPageSize() == null ? 10 : model.getPageSize();  
	    PageHelper.startPage(pageNum, pageSize);  
	    List<DemoEntity> list =demoDao.demo();
	    PageInfo pageInfo = new PageInfo(list);  
	    Page page = (Page) list;  
	    return new MsgModel<Page>("数据获取成功",RespStatusEnum.SUCCESS,page);
	    
	}

	@Override
	public MsgModel<Page> demo3(@RequestBody DemoPageModel model) {
		Integer pageNum = model.getPageNum() == null ? 1 : model.getPageNum();  
		Integer pageSize = model.getPageSize() == null ? 10 : model.getPageSize();  
	    PageHelper.startPage(pageNum, pageSize);  
	    List<DemoEntity> list =demoDao.demo();
	    PageInfo pageInfo = new PageInfo(list);  
	    Page page = (Page) list;  
	    return new MsgModel<Page>("数据获取成功",RespStatusEnum.SUCCESS,page);
	}

	@Override
	public Company getA() {
		// TODO Auto-generated method stub
		return new Company(1,"a","a");
	}

}