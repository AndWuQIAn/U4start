package cn.kgc.house.service.impl;

import cn.kgc.house.dao.StreetMapper;
import cn.kgc.house.domain.Street;
import cn.kgc.house.domain.StreetExample;
import cn.kgc.house.service.StreetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetsServiceImpl implements StreetsService {
   @Autowired(required = false)
   private StreetMapper streetMapper;
    @Override
    public List<Street> streetList(Integer id) throws Exception {
        StreetExample streetExample =new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> streets = this.streetMapper.selectByExample(streetExample);
        return streets;
    }
}
