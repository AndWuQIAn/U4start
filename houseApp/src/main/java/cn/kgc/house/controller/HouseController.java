package cn.kgc.house.controller;

import cn.kgc.house.domain.Condition;
import cn.kgc.house.domain.House;
import cn.kgc.house.domain.Users;
import cn.kgc.house.service.HouseService;
import cn.kgc.house.utils.BaseResult;
import cn.kgc.house.utils.FileUploadUtil;
import cn.kgc.house.utils.PageBean;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;
//
//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
////        factory.setLocation("E:/U4/images"); //服务器用
//             factory.setLocation("/home/temp"); //服务器用
//        return factory.createMultipartConfig();
//    }

    String path = "E:/images";

    @RequestMapping(value = "insertHouse")
    @CrossOrigin(value = "*", allowCredentials = "true")
    public BaseResult insertHouse(House house, @Param(value = "path") MultipartFile multipartFile
            , HttpSession session) throws Exception {
        try {
//             Users user = (Users) session.getAttribute("user");
//             System.out.println(user.getId());
            if (!multipartFile.isEmpty()) {
                String s = FileUploadUtil.uploadFile(path, multipartFile);
//             设置出租房的随机唯一编号(采用时间毫秒)
                house.setPath(path + "/" + s);

//                house.setUserId(1005);
                house.setId(System.currentTimeMillis() + "");
                boolean b = this.houseService.insertHouse(house);
                return new BaseResult(200, String.valueOf(b), house);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            house.setId(System.currentTimeMillis() + "");
            boolean b = this.houseService.insertHouse(house);
            return new BaseResult(500, "fail", house);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       return new BaseResult(500, "fail", house);
    }

       /**
     *
     * @param p        当前页码
     * @param session   获取userId
     * @return         BaseResult
     */
    @RequestMapping(value = "getHouseByuserId")
    public  BaseResult getHouseByuserId(Integer p,HttpSession session) throws Exception {
        try{
            Users user = (Users)session.getAttribute("user");
            PageInfo<House> houseListByUserID = this.houseService.selectByuserId(user.getId(),p);
            Map<String,Object> map =new HashMap<>();
            map.put("pageTatol",houseListByUserID.getPages());
            map.put("p",houseListByUserID.getPageNum());
            return new BaseResult(200,"",houseListByUserID);
        }catch(Exception e){
           e.printStackTrace();
           Integer userid =1007;
            PageInfo<House> houseListByUserID = this.houseService.selectByuserId(userid, p);
            Map<String,Object> map =new HashMap<>();
            map.put("pages",houseListByUserID.getPages());
            map.put("p",houseListByUserID.getPageNum());

            return  new BaseResult(500,"fail",houseListByUserID);
        }
    }
    @RequestMapping(value = "delHouse")
    public BaseResult delHouse(String id){
        try{
            boolean b = this.houseService.delHouse(id, 1);
            if (b){
                return  new BaseResult(BaseResult.RESULT_SUCCESS,b);
            }else {
                return new BaseResult(BaseResult.RESULT_FAIL,b);
            }
        }catch(Exception e){
           e.printStackTrace();
            return new BaseResult(500,"fail");
        }
    }
    @RequestMapping(value = "selectHouseByCondition")
    public BaseResult selectHouseByCondition(Condition condition) throws Exception {
  try{
      PageInfo<House> houseByCondition = this.houseService.selectHouseByCondition(condition);
      return new BaseResult(200,"",houseByCondition);
  }catch(Exception e){
     e.printStackTrace();
      return new BaseResult(500,"fail");
  }
     }
}
