package com.alen.springboot.demo.controller;

import com.alen.springboot.demo.dao.UsersMapper;
import com.alen.springboot.demo.entity.Users;
import com.alen.springboot.demo.service.UserService;
import com.alen.springboot.demo.util.RedisUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alen
 * @create 2018-12-03 12:08
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @GetMapping("/list/all")
    public Object listAll() {
        return usersMapper.selectByPrimaryKey(1);
    }


    @RequestMapping("/findUserList")
    public PageInfo<Users> findUserList(int page, int size) {
        return userService.findUserList(page, size);
    }

    @RequestMapping("/getUser")
    public Users findUserList(@RequestParam Integer id) {
        return usersMapper.selectUser(id);
    }

    @RequestMapping("/testRedis")
    public String testRedis(@RequestParam String key) {
        redisUtil.set(key, "asasasa");
        return "OK";
    }


//    @RequestMapping("/createUser")
//    public String createUser(@RequestParam String name,@RequestParam Integer age) {
//        userService.createUser(name,age);
//        return "OK";
//    }

}
