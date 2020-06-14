package cn.kgc.house.service.impl;

import cn.kgc.house.dao.TypeMapper;
import cn.kgc.house.domain.Type;
import cn.kgc.house.domain.TypeExample;
import cn.kgc.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;

    @Override
    @Transactional
    public List<Type> selectType() {
        return this.typeMapper.selectByExample(new TypeExample());
    }
}
