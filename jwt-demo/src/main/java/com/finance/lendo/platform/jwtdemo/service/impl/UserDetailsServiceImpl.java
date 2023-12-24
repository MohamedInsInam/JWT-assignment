package com.finance.lendo.platform.jwtdemo.service.impl;

import com.finance.lendo.platform.jwtdemo.bean.UserInfoDetails;
import com.finance.lendo.platform.jwtdemo.model.UserLogin;
import com.finance.lendo.platform.jwtdemo.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserLoginRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userRepository.findByUsername(username);
        if (null == userLogin) return null;

        return UserInfoDetails.build(userLogin);
    }
}
