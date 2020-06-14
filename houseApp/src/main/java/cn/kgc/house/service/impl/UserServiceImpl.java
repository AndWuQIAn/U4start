package cn.kgc.house.service.impl;

import cn.kgc.house.dao.UsersMapper;
import cn.kgc.house.domain.Users;
import cn.kgc.house.domain.UsersExample;
import cn.kgc.house.service.DistrictService;
import cn.kgc.house.service.UserService;
import cn.kgc.house.utils.MD5Util;
import cn.kgc.house.utils.MD5Util2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
     @Autowired(required = false)
     public UsersMapper usersMapper;

      //注册
    @Override
    @Transactional
    public boolean insertUsers(Users users) throws Exception {
      users.setPassword(MD5Util2.string2Md5(users.getPassword()));
        int i = this.usersMapper.insertSelective(users);
        return i>0?true:false;
    }
    //检测登录
    @Override
    public Users loginUser(String username, String password) throws Exception {
        UsersExample usersExample =new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Util2.string2Md5(password));
        return  this.usersMapper.selectByExample(usersExample).get(0);
    }
}
