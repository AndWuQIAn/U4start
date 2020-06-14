package cn.kgc.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import com.youth.controller.fileupload.MultipartListenerResolver
import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan(value = "cn.kgc.house.dao")
@ServletComponentScan(basePackages = "cn.kgc.house.filter")
public class HouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

//    @Bean
//    MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
////        factory.setLocation("E:/U4/images"); //服务器用
//        factory.setLocation("/home/temp"); //服务器用
//        return factory.createMultipartConfig();
//    }

    public HouseApplication() {
    }

}
