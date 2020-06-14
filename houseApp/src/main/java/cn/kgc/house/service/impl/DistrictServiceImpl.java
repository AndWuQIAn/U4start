package cn.kgc.house.service.impl;

import cn.kgc.house.dao.DistrictMapper;
import cn.kgc.house.domain.District;
import cn.kgc.house.domain.DistrictExample;
import cn.kgc.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Override
    public List<District> districtList() throws Exception {
        return this.districtMapper.selectByExample(new DistrictExample());
    }
}
