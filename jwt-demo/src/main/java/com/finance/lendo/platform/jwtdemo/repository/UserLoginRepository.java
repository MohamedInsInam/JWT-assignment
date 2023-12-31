package com.finance.lendo.platform.jwtdemo.repository;

import com.finance.lendo.platform.jwtdemo.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByUsername(String username);
}