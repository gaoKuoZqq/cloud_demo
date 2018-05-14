package com.guoyicap.micro.config.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.common.enums.RespStatusEnum;
import com.guoyicap.micro.config.user.mapper.CompanyMapper;
import com.guoyicap.micro.config.user.model.Company;
import com.guoyicap.micro.config.user.service.CompanyService;
import com.guoyicap.micro.config.user.service.DemoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service()
@RestController()
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DemoService demoService;

	@Override
	@HystrixCommand(fallbackMethod = "findByIdError")
	public MsgModel<Company> findById(@RequestBody Integer id) {
		System.out.println("CompanyServiceImpl.findById()");
		MsgModel<Company> msgModel = null;
		//try {
			//int a = 1/0;
			//System.out.println(a);
			//System.out.println(demoService.getA());
		int i = 1;
		int j  = 0;
		while (i<10000) {
			//System.out.println(1+1);
			i = 1+1;
			j = i-1;
		}
		int z = j;
			//Company company = companyMapper.findById(id);
			//company.setName("oldserver");
			msgModel = new MsgModel<>("查询数据成功", RespStatusEnum.SUCCESS);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//	throw e;
			//msgModel = new MsgModel<>("查询数据失败", RespStatusEnum.FAILURE);
		//}
		return msgModel;
	}

	public MsgModel<Company> findByIdError(@RequestBody Integer id) {
		System.out.println("CompanyServiceImpl.findByIdError()");
		return new MsgModel("service_ERROR,id:" + id);
	}

	@Override
	public MsgModel<PageInfo<Company>> getPageList(@RequestBody Company company) {
		MsgModel<PageInfo<Company>> msgModel = null;
		try {
			PageHelper.startPage(1, 10);
			List<Company> list = companyMapper.getPageList(company);
			PageInfo<Company> page = new PageInfo<Company>(list);
			msgModel = new MsgModel<>("查询数据成功", RespStatusEnum.SUCCESS, page);
		} catch (Exception e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("查询数据失败", RespStatusEnum.FAILURE);
		}
		return msgModel;
	}


	@Override
	@Transactional
	public MsgModel<String> deleteById(@RequestBody Integer id) {
		MsgModel<String> msgModel = null;
		try {
			Integer result = companyMapper.deleteById(id);
			if (result == 1) {
				int a = 1/0;
				System.out.println(a);
				msgModel = new MsgModel<>("操作成功", RespStatusEnum.SUCCESS);
			}else {
				msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return msgModel;
	}


	@Override
	public MsgModel<String> insert(@RequestBody Company company) {
		MsgModel<String> msgModel = null;
		try {
			Integer result = companyMapper.insert(company);
			if (result == 1) {
				msgModel = new MsgModel<>("操作成功", RespStatusEnum.SUCCESS);
			}else {
				msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
		}
		return msgModel;
	}


	@Override
	@Transactional
	public MsgModel<String> update(@RequestBody Company company) {
		MsgModel<String> msgModel = null;
		try {
			Integer result = companyMapper.update(company);
			if (result == 1) {
				int a = 1/0;
				System.out.println(a);
				msgModel = new MsgModel<>("操作成功", RespStatusEnum.SUCCESS);
			}else {
				msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return msgModel;
	}


	@Override
	@Transactional
	public MsgModel<String> insertParams(Integer id, String name, String legalPerson) {
		MsgModel<String> msgModel = null;
		try {
			Company company = new Company(id, name, legalPerson);
			Integer result = companyMapper.insert(company);
			if (result == 1) {
				int a = 1/0;
				System.out.println(a);
				msgModel = new MsgModel<>("操作成功", RespStatusEnum.SUCCESS);
			}else {
				msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return msgModel;
	}

	@Override
	public MsgModel<String> insertTest(Company company) {
		MsgModel<String> msgModel = null;
		try {
			Integer result = companyMapper.insert(company);
			if (result == 1) {
				msgModel = new MsgModel<>("操作成功", RespStatusEnum.SUCCESS);
			}else {
				msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
		}
		return msgModel;
	}

}