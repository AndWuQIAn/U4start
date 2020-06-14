package cn.kgc.house.service.impl;

import cn.kgc.house.dao.HouseMapper;
import cn.kgc.house.domain.Condition;
import cn.kgc.house.domain.House;
import cn.kgc.house.service.HouseService;
import cn.kgc.house.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    @Transactional
    public boolean insertHouse(House house) throws Exception {
        return this.houseMapper.insertSelective(house)>0?true:false;
    }

    /**
     *
     * @param userId  用户id
     * @param p   分页参数
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public PageInfo<House> selectByuserId(Integer userId,Integer p) throws Exception {
        PageBean pb =new PageBean();
        PageHelper.startPage(p,pb.getPageSize());
        List<House> houses = this.houseMapper.selectByuserId(userId);
        return new PageInfo<>(houses);
    }

    @Override
    @Transactional
    public boolean delHouse(String id, Integer isdel) throws Exception {
       House house =new House();
       house.setId(id);
       house.setIsdel(isdel);
        int i = this.houseMapper.updateByPrimaryKeySelective(house);
        return i>0?true:false;
    }

    @Override
    @Transactional
    public PageInfo<House> selectHouseByCondition(Condition condition) throws Exception {
       PageHelper.startPage(condition.getP(),condition.getPageSize());
        List<House> houses = this.houseMapper.selectHouseByCondition(condition);
        return new PageInfo<>(houses);
    }
}
