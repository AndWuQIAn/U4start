package cn.kgc.house.dao;

import cn.kgc.house.domain.Type;
import cn.kgc.house.domain.TypeExample;
import java.util.List;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}