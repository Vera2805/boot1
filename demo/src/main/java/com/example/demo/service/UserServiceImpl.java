package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NEVER)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional(timeout = 10)
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    public void deleteUser(Long id) {
        userDao.deleteUser(id);

    }

}


