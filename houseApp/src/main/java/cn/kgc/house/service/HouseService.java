package cn.kgc.house.service;

import cn.kgc.house.domain.Condition;
import cn.kgc.house.domain.House;
import cn.kgc.house.utils.PageBean;
import com.github.pagehelper.PageInfo;

public interface HouseService {

   public boolean insertHouse(House house) throws Exception;

   //byuserID pageinfo
   public PageInfo<House> selectByuserId(Integer userId, Integer p)throws Exception;


    //逻辑删除
   public boolean delHouse(String id,Integer isdel)throws Exception;


    //condiiton
    public PageInfo<House> selectHouseByCondition(Condition condition) throws Exception;

}
