package com.finance.lendo.platform.jwtdemo.controller.Auth;

import com.finance.lendo.platform.jwtdemo.bean.LoginReqBean;
import com.finance.lendo.platform.jwtdemo.model.UserLogin;
import com.finance.lendo.platform.jwtdemo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginReqBean loginReqBean) {
        if (null == userLoginService.findByUsername(loginReqBean.getUsername())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userLoginService.getToken(loginReqBean));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserLogin userLogin) {
        if (null != userLoginService.findByUsername(userLogin.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        userLoginService.save(userLogin);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/userLogins")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userLoginService.getAllUsers());
    }

}
