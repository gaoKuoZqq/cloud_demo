package com.guoyicap.micro.config.user.dao;

import java.util.List;

import com.guoyicap.micro.common.base.MyMapper;
import com.guoyicap.micro.config.user.entity.DemoEntity;

/**
 * Created on 2016/7/05 11:44.
 */
public interface DemoDao  extends  MyMapper<DemoEntity> {

    public List<DemoEntity> demo ();

}