package com.resuper.mutlds.mapper.mapper2;

import com.resuper.mutlds.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper2 {


    @Select("select * from user")
    public List<User> selAllUser();


}
