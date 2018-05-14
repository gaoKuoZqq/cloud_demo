package com.guoyicap.micro.config.user.model;

import java.io.Serializable;
import java.util.List;

import com.guoyicap.micro.common.base.BaseModel;


public class User extends BaseModel implements Serializable {
    private static final long serialVersionUID = 6985965045661480463L;

    private Integer id;

    private String username;

    private String password;

    private String salt = "8d78869f470951332959580424d4bf4f";//加密盐
    
    private Integer state;//用户状态 0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    private List<Role> roles;//角色列表


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt + ", state="
				+ state + ", roles=" + roles + "]";
	}

	public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
		return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username == null ? null : username.trim();
		return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password == null ? null : password.trim();
		return this;
    }

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	//重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
