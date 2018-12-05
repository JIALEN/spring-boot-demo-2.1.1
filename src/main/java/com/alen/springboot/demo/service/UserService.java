
package com.alen.springboot.demo.service;

import com.alen.springboot.demo.dao.UsersMapper;
import com.alen.springboot.demo.entity.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UsersMapper usersMapper;

    public PageInfo<Users> findUserList(int page, int size) {
        // 开启分页插件,放在查询语句上面
        PageHelper.startPage(page, size);
        List<Users> listUser = usersMapper.findUserList();
        // 封装分页之后的数据
        PageInfo<Users> pageInfoUser = new PageInfo<Users>(listUser);
        return pageInfoUser;
    }



//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public void createUser(String name, Integer age) {
//        log.info("创建用户：名字-"+name+"年龄--"+age);
//        jdbcTemplate.update("insert into users values(null,?,?);",name,age);
//
//    }


    @Async
    public void sedSms() {
        log.info("##sedSms##开始执行..  2");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
            log.info("i:" + i);
        }
        log.info("##sedSms##结束执行..  3");
    }


}
