package com.alen.springboot.demo.dao;

import com.alen.springboot.demo.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "baseCache")
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    @Select("SELECT * FROM USERS ")
    List<Users> findUserList();


    @Select(" select * from users where id = #{id} ")
    //@Cacheable的value一定要指定
    @Cacheable(value = "cache1")
     Users selectUser(@Param("id") Integer id);

}
