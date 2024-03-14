package com.ecommerce_plant.plant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce_plant.plant.config.JwtTokenProvider;
import com.ecommerce_plant.plant.mapping.modelmapping.JwtToken;
import com.ecommerce_plant.plant.model.User;
import com.ecommerce_plant.plant.service.UserService;

@RequestMapping("api/user")
@Controller
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("")
    public ResponseEntity<?> insertUser(@RequestBody User user) {
        String result = userService.insertUser(user);
        return result.equals("Insert successfully") ? ResponseEntity.ok().body(result)
                : ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        User result = userService.signIn(user);
        if (result == null) {
            return ResponseEntity.badRequest().body("doesn't exist");
        } else {
            String token = jwtTokenProvider.createJWT(result.getId(), result.getUsername(), result.getEmail(),
                    result.getRole_id(), false);
            String refreshToken = jwtTokenProvider.createJWT(result.getId(), result.getUsername(), result.getEmail(),
                    result.getRole_id(), true);
            JwtToken tokens = new JwtToken(token, refreshToken);
            return ResponseEntity.ok().body(tokens);
        }
    }
}
