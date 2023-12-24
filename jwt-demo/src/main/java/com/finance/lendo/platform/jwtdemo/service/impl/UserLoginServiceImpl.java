package com.finance.lendo.platform.jwtdemo.service.impl;

import com.finance.lendo.platform.jwtdemo.bean.JWTResponseBean;
import com.finance.lendo.platform.jwtdemo.bean.LoginReqBean;
import com.finance.lendo.platform.jwtdemo.bean.UserInfoDetails;
import com.finance.lendo.platform.jwtdemo.model.UserLogin;
import com.finance.lendo.platform.jwtdemo.repository.UserLoginRepository;
import com.finance.lendo.platform.jwtdemo.security.JwtTokenUtil;
import com.finance.lendo.platform.jwtdemo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserLogin save(UserLogin userLogin) {
        return userLoginRepository.save(userLogin);
    }

    @Override
    public UserLogin findByUsername(String username) {
        return userLoginRepository.findByUsername(username);
    }

    @Override
    public JWTResponseBean getToken(LoginReqBean loginReqBean) {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqBean.getUsername(), loginReqBean.getPassword()));
        } catch (Exception e) {
            String ex = e.toString();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JWTResponseBean(jwtTokenUtil.generateToken(UserInfoDetails.build(userLoginRepository.findByUsername(loginReqBean.getUsername()))));

    }

    @Override
    public List<UserLogin> getAllUsers() {
        return userLoginRepository.findAll();
    }

}