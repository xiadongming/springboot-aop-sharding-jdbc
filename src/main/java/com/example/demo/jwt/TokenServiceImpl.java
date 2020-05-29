package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.dto.User;
import com.example.demo.jwt.service.TokenService;
import org.springframework.stereotype.Service;

/***
 add by xiadongming on 2020/5/4
 **/
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
        String token = "";         //通过userId进行验证
        token= JWT.create().withAudience(user.getUserId().toString()).sign(Algorithm.HMAC256(user.getPassWord()));
        return token;
    }
}
