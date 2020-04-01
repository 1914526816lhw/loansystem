package com.stu;

import com.stu.property.FileProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession
@EnableConfigurationProperties({
        FileProperties.class
})
@SpringBootApplication
@MapperScan("com.stu.mapper")
public class LoansystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansystemApplication.class, args);
    }

}
