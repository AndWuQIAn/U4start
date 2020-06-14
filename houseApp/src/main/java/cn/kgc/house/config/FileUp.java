package cn.kgc.house.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@EnableAutoConfiguration
public class FileUp {
    @Autowired
    private CommonsMultipartResolver resolver;
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);// resolveLazily属性启用是为了推迟文件解析
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(2 * 1024 * 1024);// 上传文件大小 2M 50*1024*1024
        return resolver;
    }
}
