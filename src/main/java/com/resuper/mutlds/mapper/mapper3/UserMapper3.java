package com.resuper.mutlds.mapper.mapper3;

import com.resuper.mutlds.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper3 {

    @Select("select * from sys_user")
    public List<User> selAllUser();


}
