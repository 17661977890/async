package com.example.async.service;

import com.example.async.entity.User1;

import java.util.List;

/**
 * @Author 彬
 * @Date 2019/7/11
 */
public interface UserService {

    User1 save(User1 user);

    void remove(Integer id);

    List<User1> findOne(User1 user);
}
