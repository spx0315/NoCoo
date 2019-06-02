package com.spx0315.service;

import com.spx0315.dao.UserDao;
import com.spx0315.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    //自动注入一个userDao
    @Autowired
    private UserDao userDao;

    public String  register(User user) {
        if (userDao.getOneUser(user.getUsername()) == null) {
            userDao.setOneUser(user);
            return "注册成功";
        }
        else {
            return "该用户名已被使用";
        }
    }
    //用户登陆逻辑
    public String login(User user) {
        //通过用户名获取用户
        User dbUser = userDao.getOneUser(user.getUsername());
        //若获取失败
        if (dbUser == null) {
            return "该用户不存在";
        }
        else if (!dbUser.getPassword().equals(user.getPassword())){
            return "密码错误";
        }
        else {
            user.setId(dbUser.getId());
            user.setCreateTime(dbUser.getCreateTime());
            return "登陆成功";
        }
    }
}
