package com.example.exercice1bis.service;

import com.example.exercice1bis.dao.UserDao;
import com.example.exercice1bis.entity.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean createUser(User user) {
        return userDao.create(user);
    }

    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    public User getByNamePassword(User user) {

        System.out.println("User exists: " + user);
        return userDao.getByEmailPassword(user);

    }
}
