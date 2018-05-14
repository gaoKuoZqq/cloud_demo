package com.guoyicap.micro.config.user.ui.fb;

import com.guoyicap.micro.common.base.MsgModel;

public class CompanyControllerFb{
	public MsgModel<?> error(Integer id){
		return new MsgModel("controller_ERROR,id:" + id);
	}
}
