package com.spx0315.dao;

import com.spx0315.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {
    @Select("select * from user where username=#{username} limit 1")
    User getOneUser(String username);

    //增
    @Insert("insert into user (username,password) values(#{username},#{password})")
    boolean setOneUser(User user);

}
