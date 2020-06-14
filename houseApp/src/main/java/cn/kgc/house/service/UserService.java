package cn.kgc.house.service;

import cn.kgc.house.domain.Users;

import java.util.List;

public interface UserService {

    //注册用户功能
    public boolean  insertUsers(Users users)throws Exception;

    //检测用户
    public Users loginUser(String username, String password)throws Exception;
}
