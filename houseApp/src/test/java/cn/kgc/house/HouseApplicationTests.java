package cn.kgc.house;

import cn.kgc.house.dao.DistrictMapper;
import cn.kgc.house.dao.HouseMapper;
import cn.kgc.house.dao.UsersMapper;
import cn.kgc.house.domain.*;
import cn.kgc.house.utils.MD5Util2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseApplicationTests {

    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Test
    public void contextLoads() {
        //测试成功！！
        List<House> houses = this.houseMapper.selectByExample(new HouseExample());
        houses.stream().forEach(s-> System.out.println(s.getId()));
    }
  @Test
    public void  login(){
      Users users = this.usersMapper.selectByPrimaryKey(1005);
      //登录
      String s1 = MD5Util2.string2Md5("123456");
      if (s1.equals(users.getPassword())){
          System.out.println("true");
      }else {
          System.out.println("false");
      }
  }
  @Test
    public void t1() throws UnsupportedEncodingException {
      List<Type> list=new ArrayList<Type>();
      Type t=new Type();
      t.setName("张三");
      list.add(t); //将一个对象多次存放到集合中
      list.add(t); //将一个对象多次存放到集合中
      list.add(t);  //将一个对象多次存放到集合中
      list.get(0).setName("李四");
      System.out.println(list.get(2).getName());
  }
  @Test
    public void t2(){
      List<District> districts = this.districtMapper.selectByExample(new DistrictExample());
      districts.stream().forEach(s-> System.out.println(s.getName()));
  }
}
