package com.finance.lendo.platform.jwtdemo.service;

import com.finance.lendo.platform.jwtdemo.bean.JWTResponseBean;
import com.finance.lendo.platform.jwtdemo.bean.LoginReqBean;
import com.finance.lendo.platform.jwtdemo.model.UserLogin;

import java.util.List;

public interface UserLoginService {
    UserLogin save(UserLogin user);

    UserLogin findByUsername(String username);

    JWTResponseBean getToken(LoginReqBean loginReqBean);

    List<UserLogin> getAllUsers();
}