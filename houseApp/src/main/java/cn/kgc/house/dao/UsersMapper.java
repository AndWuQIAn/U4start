package cn.kgc.house.dao;

import cn.kgc.house.domain.Users;
import cn.kgc.house.domain.UsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    //检测登录
    Users login(@Param(value = "username")String username,@Param(value = "password")String password) throws Exception;
}