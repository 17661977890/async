package com.example.async.controller;

import com.example.async.entity.User1;
import com.example.async.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 彬
 * @Date 2019/7/11
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save")
    public User1 save(@RequestBody User1 user){
        User1 user1 =userService.save(user);
        return  user1;
    }

    @RequestMapping(value = "/remove")
    public void remove(@RequestParam("id") Integer id){
        userService.remove(id);
    }

    @RequestMapping(value = "/findOne")
    public List<User1> findOne(@RequestBody User1 user){
        List<User1> user1 =userService.findOne(user);
        return  user1;
    }
}
