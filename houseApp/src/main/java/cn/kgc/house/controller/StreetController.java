package cn.kgc.house.controller;

import cn.kgc.house.dao.StreetMapper;
import cn.kgc.house.domain.Street;
import cn.kgc.house.service.StreetsService;
import cn.kgc.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StreetController {

    @Autowired
    private StreetsService streetsService;

    @RequestMapping(value = "getStreet")
    public BaseResult getStreet(Integer districtId){
        try{
            List<Street> streets = this.streetsService.streetList(districtId);
           return new BaseResult(200,"",streets);
        }catch(Exception e){
           e.printStackTrace();
           return    new BaseResult(500,"fail","");

        }
    }
}
