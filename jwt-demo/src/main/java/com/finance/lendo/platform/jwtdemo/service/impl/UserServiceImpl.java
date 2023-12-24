package com.finance.lendo.platform.jwtdemo.service.impl;

import com.finance.lendo.platform.jwtdemo.clientUtil.WebClientUtil;
import com.finance.lendo.platform.jwtdemo.model.User;
import com.finance.lendo.platform.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private WebClientUtil webClientUtil;

    @Value("${lendo.user.url}")
    private String usersUrl;

    @Override
    public List<User> getAllUsers() {
        Flux<User> userModelFlux = webClientUtil.getAll(usersUrl, User.class);
        return userModelFlux.collectList().block();
    }

}