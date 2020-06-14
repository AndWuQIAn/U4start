package cn.kgc.house.dao;

import cn.kgc.house.domain.Street;
import cn.kgc.house.domain.StreetExample;
import java.util.List;

public interface StreetMapper {
    int countByExample(StreetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
}