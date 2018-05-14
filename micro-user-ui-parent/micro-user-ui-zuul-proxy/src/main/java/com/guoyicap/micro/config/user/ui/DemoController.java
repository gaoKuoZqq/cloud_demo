package com.guoyicap.micro.config.user.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.pagehelper.Page;
import com.guoyicap.micro.config.user.model.DemoPageModel;
import com.guoyicap.micro.config.utils.EntityToMap;
import com.guoyicap.micro.config.utils.HeaderUtils;

/**
 * Created by wuyu on 2016/7/5.
 */
@RestController
@RequestMapping("/zuulDemo")
public class DemoController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Integer selectByPrimaryKey(Integer id,String token) {
        //调用zuul代理服务 http://代理地址:端口/服务的应用名/服务
        //代理地址可以用 应用名代替,前提是开启@EnableEurekaClient
        //restTemplate.getForObject("http://zuul-server/micro-user/user/" + id, User.class);
    	
        return restTemplate.getForObject("http://localhost:10000/micro-user/demo?id=" + id+"&token="+token, Integer.class);
    }
    
    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    @ResponseBody
    public String demo2(@RequestBody DemoPageModel model,HttpServletRequest request) {
    	HttpEntity<Map<String,Object>> formEntity = new HttpEntity<Map<String,Object>>(EntityToMap.ConvertObjToMap(model), HeaderUtils.getHeadersInfo(request));  
    	return restTemplate.postForObject("http://localhost:10000/micro-user/demo2", formEntity, String.class);  
    }
    @RequestMapping(value = "/demo3", method = RequestMethod.POST)
    @ResponseBody
    public String demo3(@RequestBody DemoPageModel model,HttpServletRequest request) {
    	HttpEntity<Map<String,Object>> formEntity = new HttpEntity<Map<String,Object>>(EntityToMap.ConvertObjToMap(model), HeaderUtils.getHeadersInfo(request));  
    	return restTemplate.postForObject("http://localhost:10000/micro-user/demo3", formEntity, String.class);  
    }    
    
    

}
