package com.guoyicap.micro.config.user.mapper;

import java.util.List;

import com.guoyicap.micro.config.user.model.Company;

public interface CompanyMapper {

	Company selectByPrimaryKey(Integer id);

	List<Company> getPageList(Company company);

	Company findById(Integer id);

	Integer deleteById(Integer id);

	Integer update(Company company);

	Integer insert(Company company);

}
