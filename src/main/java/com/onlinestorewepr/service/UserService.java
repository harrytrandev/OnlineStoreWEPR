package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.User;

import javax.servlet.ServletException;
import java.io.IOException;

public class UserService {
    public User getUser(String username) {
        UserDAO userDao = new UserDAO();
        User user = userDao.get(username);
        System.out.println(user.getName());

        return user;
    }
}
