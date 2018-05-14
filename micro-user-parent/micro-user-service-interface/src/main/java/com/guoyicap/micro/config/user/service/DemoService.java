package com.guoyicap.micro.config.user.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.pagehelper.Page;
import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.config.user.model.Company;
import com.guoyicap.micro.config.user.model.DemoPageModel;

import io.swagger.annotations.ApiOperation;


/**
 * Created on 2016/7/05 11:44.
 */
@FeignClient(serviceId = "demoService")
public interface DemoService {

    @ApiOperation(value = "demo", httpMethod = "GET", response = List.class)
    //@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @GetMapping(value="/demo")
    List<String> demo(@PathVariable("id") Integer id);
    
    
    @ApiOperation(value = "demo2", httpMethod = "POST", response = MsgModel.class)
    //@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @PostMapping(value="/demo2",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MsgModel<Page> demo2(@RequestBody DemoPageModel model);
    
    @ApiOperation(value = "demo3", httpMethod = "POST", response = MsgModel.class)
    //@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @PostMapping(value="/demo3",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MsgModel<Page> demo3(@RequestBody DemoPageModel model);


    Company getA();

}