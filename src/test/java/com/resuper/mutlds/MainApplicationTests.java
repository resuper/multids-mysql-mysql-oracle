package com.resuper.mutlds;

import com.resuper.mutlds.entity.User;
import com.resuper.mutlds.mapper.mapper1.UserMapper1;
import com.resuper.mutlds.mapper.mapper2.UserMapper2;
import com.resuper.mutlds.mapper.mapper3.UserMapper3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MainApplicationTests {

    @Resource
    private UserMapper1 userMapper1;
    @Resource
    private UserMapper2 userMapper2;
    @Resource
    private UserMapper3 userMapper3;

    MainApplicationTests() {
    }


    @Test
    void contextLoads() {

        List<User> users1 = userMapper1.selAllUser();

        List<User> users2 = userMapper2.selAllUser();

        List<User> users3 = userMapper3.selAllUser();



        System.out.println(users1);
        System.out.println(users2);
        System.out.println(users3);
    }

}
