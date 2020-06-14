package cn.kgc.house.controller;

import cn.kgc.house.domain.Type;
import cn.kgc.house.service.TypeService;
import cn.kgc.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;
    @RequestMapping(value = "/getTypeList")
    public BaseResult getTypeList(){
        List<Type> types = this.typeService.selectType();
        return new BaseResult(200,types);
    }
}
