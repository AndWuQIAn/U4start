package cn.kgc.house.controller;

import cn.kgc.house.domain.District;
import cn.kgc.house.service.DistrictService;
import cn.kgc.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {


         @Autowired(required = false)
    private DistrictService districtService;

         @RequestMapping("/getDistrict")
         public BaseResult getDistrict(){
          try{
              List<District> districts = this.districtService.districtList();
              return new BaseResult(200,districts);
          }catch(Exception e){
             e.printStackTrace();
              return new BaseResult(500,"fail");
          }
         }
}
