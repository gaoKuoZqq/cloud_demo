package com.guoyicap.micro.config.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.config.user.model.Company;


@FeignClient()
@RequestMapping(value="company")
public interface CompanyService {

    @RequestMapping(value="findById")
    MsgModel<Company> findById(Integer id);

    @RequestMapping(value="deleteById")
    MsgModel<String> deleteById(Integer id);

    @RequestMapping(value = "insert")
    MsgModel<String> insert(Company company);
    @RequestMapping(value = "insertTest")
    MsgModel<String> insertTest(Company company);
    @RequestMapping(value = "insertParams")
    MsgModel<String> insertParams(Integer id, String name, String legalPerson);
  
    @RequestMapping(value = "update")
    MsgModel<String> update(Company company);


    @RequestMapping(value = "getPageList")
    MsgModel<PageInfo<Company>> getPageList(Company company);

}