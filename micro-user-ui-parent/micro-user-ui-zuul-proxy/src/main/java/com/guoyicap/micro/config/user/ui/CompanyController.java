package com.guoyicap.micro.config.user.ui;

import java.net.URL;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.guoyicap.micro.common.base.MsgModel;
import com.guoyicap.micro.common.enums.RespStatusEnum;
import com.guoyicap.micro.config.user.model.Company;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.ui.fb.CompanyControllerFb;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * miaoshu : 测试类
 * author:gaokuo
 */
@RestController
@RequestMapping("company")
public class CompanyController extends CompanyControllerFb{

    @Autowired
    RestTemplate restTemplate;
    
    private final static String url = "http://localhost:10000/micro-user/company/";

    @RequiresPermissions("company:view")
    @RequestMapping(value = "gopage")
    public ModelAndView gopage() {
    	User user = (User) SecurityUtils.getSubject().getPrincipal();
    	System.out.println(user);
    	return new ModelAndView("/companyPage");
    }
    //-------------------------------------------------------基本操作
    @RequestMapping(value = "findById")
    //@HystrixCommand(fallbackMethod = "error")
    public MsgModel<?> findById(Integer id) {
		MsgModel<?> msgModel = null;
			@SuppressWarnings("rawtypes")
			ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "findById", id, MsgModel.class);
			msgModel = responseEntity.getBody();
			//e.printStackTrace();
			//msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
    	return msgModel;
    }
    //public MsgModel<?> error(Integer id){
     //   return new MsgModel("测试通过,id:" + id);
    //}
    @RequestMapping(value = "deleteById")
    public MsgModel<?> deleteById(Integer id) {
		MsgModel<?> msgModel = null;
		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "deleteById", id, MsgModel.class);
			msgModel = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
		}
    	return msgModel;
    }
    
    @RequestMapping(value = "update")
    public MsgModel<?> update(Company company) {
		MsgModel<?> msgModel = null;
		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "update", company, MsgModel.class);
			msgModel = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
		}
    	return msgModel;
    }
    
    @RequestMapping(value = "insert")
    public MsgModel<?> insert(Company company) {
    	MsgModel<?> msgModel = null;
    	try {
    		@SuppressWarnings("rawtypes")
    		ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "insert", company, MsgModel.class);
    		msgModel = responseEntity.getBody();
    	} catch (RestClientException e) {
    		e.printStackTrace();
    		msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
    	}
    	return msgModel;
    }
    
    @RequestMapping(value = "getPageList")
    public MsgModel<?> getPageList(Company company) {
		MsgModel<?> msgModel = null;
		try {
			@SuppressWarnings("rawtypes")
			ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "getPageList", company, MsgModel.class);
			msgModel = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("请求数据失败", RespStatusEnum.FAILURE);
		}
    	return msgModel;
    }
    //-----------------------------------------------json参数例子
    @RequestMapping(value = "deleteByIdJson")
    public MsgModel<?> deleteByIdJson(@RequestBody Company company) {
    	MsgModel<?> msgModel = null;
    	try {
    		@SuppressWarnings("rawtypes")
    		ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "deleteById", company.getId(), MsgModel.class);
    		msgModel = responseEntity.getBody();
    	} catch (RestClientException e) {
    		e.printStackTrace();
    		msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
    	}
    	return msgModel;
    }
    //-------------------------------------本层多参数
    @RequestMapping(value = "updateParams")
    public MsgModel<?> updateParams(String name, Integer id) {
		MsgModel<?> msgModel = null;
		try {
			Company company = new Company();
			company.setId(id);
			company.setName(name);
			@SuppressWarnings("rawtypes")
			ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "update", company, MsgModel.class);
			msgModel = responseEntity.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
			msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
		}
    	return msgModel;
    }
    //-------------------------------------服务层多参数
    @RequestMapping(value = "insertParamsOne")
    public MsgModel<?> insertParams(Company company) {
    	MsgModel<?> msgModel = null;
    	try {
    		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
            requestEntity.add("name", company.getName());
            requestEntity.add("id", company.getId().toString());
            requestEntity.add("legalPerson", company.getLegalPerson());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestEntity, headers);
    		@SuppressWarnings("rawtypes")
    		ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "insertTest", request, MsgModel.class);
    		msgModel = responseEntity.getBody();
    	} catch (RestClientException e) {
    		e.printStackTrace();
    		msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
    	}
    	return msgModel;
    }
    @RequestMapping(value = "insertParamsTwo")
    public MsgModel<?> insertParamsTwo(Company company) {
    	MsgModel<?> msgModel = null;
    	try {
    		MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
            requestEntity.add("name", company.getName());
            requestEntity.add("id", company.getId().toString());
            requestEntity.add("legalPerson", company.getLegalPerson());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestEntity, headers);
    		@SuppressWarnings("rawtypes")
    		ResponseEntity<MsgModel> responseEntity = restTemplate.postForEntity(url + "insertParams", request, MsgModel.class);
    		msgModel = responseEntity.getBody();
    	} catch (RestClientException e) {
    		e.printStackTrace();
    		msgModel = new MsgModel<>("操作失败", RespStatusEnum.FAILURE);
    	}
    	return msgModel;
    }

}
