package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.commonutils.TokenUtil;
import com.example.demo.dto.User;
import com.example.demo.jwt.service.TokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/***
 add by xiadongming on 2020/5/4
 **/
@RestController
@RequestMapping("/user")
public class TokenController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    // 登录
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public Object login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.getByName(user.getUserName());
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassWord().equals(user.getPassWord())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);

                response.setHeader("token",token);
                return jsonObject;
            }
        }
    }


    @UserLoginToken
    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
    public String getMessage() {
        // 取出token中带的用户id 进行操作,获取当前的用户id，，，，其实是解析token，解析之后查询数据库
        String userId = TokenUtil.getTokenUserId();
        System.out.println(userId);

        return "您已通过验证";
    }

}
