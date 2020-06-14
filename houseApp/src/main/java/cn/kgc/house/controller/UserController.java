package cn.kgc.house.controller;

import cn.kgc.house.domain.Users;
import cn.kgc.house.service.UserService;
import cn.kgc.house.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
   @RequestMapping(value = "/LogOn")
    public BaseResult LogOn(Users users){
     try{
         boolean b = this.userService.insertUsers(users);
         return new BaseResult(BaseResult.RESULT_SUCCESS,"");
     }catch(Exception e){
        e.printStackTrace();
        return new BaseResult(BaseResult.RESULT_FAIL,"");
     }
    }
    //登录、
    @RequestMapping(value = "/login")
    public BaseResult login(String name, String password, HttpSession session) {
        try{
            Users users = this.userService.loginUser(name, password);
            session.setAttribute("user",users);
            System.out.println(users.getId());
            Users user = (Users) session.getAttribute("user");
            System.out.println(user.getName());
           session.setMaxInactiveInterval(600);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"",users);
        }catch(Exception e){
           e.printStackTrace();
           return new BaseResult(BaseResult.RESULT_FAIL,"Error");
        }
    }
}
