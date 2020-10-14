package com.bigger850.springbootwebsocketdemo.controller;

import com.bigger850.springbootwebsocketdemo.model.BaseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: qq895
 * @date: 2020/10/14 14:42
 * @description:
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/chat")
public class RestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Value("${redis.channel.msgToAll}")
    private String msgToAll;

    @Value("${redis.set.onlineUsers}")
    private String onlineUsers;

    @Value("${redis.channel.userStatus}")
    private String userStatus;

    @RequestMapping("/userList")
    public BaseResult<JSONArray> userList() {
        return new BaseResult<>(JSONObject.parseArray(redisTemplate.opsForValue().get(onlineUsers+"list")));
    }
}
