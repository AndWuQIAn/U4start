package cn.kgc.house.dao;

import cn.kgc.house.domain.Condition;
import cn.kgc.house.domain.House;
import cn.kgc.house.domain.HouseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> selectByuserId(@Param(value = "userId") Integer userId)throws Exception;

    //condition
    public List<House> selectHouseByCondition(Condition c
    ) throws Exception;

}