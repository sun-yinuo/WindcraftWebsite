package com.sunyinuo.windcraftbackend.service.impl;

import com.sunyinuo.windcraftbackend.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void getUserList() {
        List<User> userList = userService.getUserList();
        System.out.println(userList);
    }

    @Test
    void getUserById() {
        User userById = userService.getUserById(27);
        System.out.println(userById);
    }

    @Test
    void getUserByName() {
        User testUser1 = userService.getUserByName("TestUser1");
        System.out.println(testUser1);
    }

    @Test
    void getUserByPassword() {
        List<User> testUser1Password = userService.getUserByPassword("TestUser1Password");
        System.out.println(testUser1Password);
    }

    @Test
    void getUserByTime() {
        List<User> userByTime = userService.getUserByTime(2022);
        System.out.println(userByTime);
    }

    @Test
    void getUserByIp() {
        List<User> userByIp = userService.getUserByIp("0.0.0.0");
        System.out.println(userByIp);
    }

    @Test
    void addUser() {
        User user =  new User(0,2022,"0.0.0.0","TestUser2","TestUser2Password");
        int addUser = userService.addUser(user);
        System.out.println(addUser);
    }

    @Test
    void deleteUserByName() {
        int deleteUserByName = userService.deleteUserByName("TestUser2");
        System.out.println(deleteUserByName);
    }
}