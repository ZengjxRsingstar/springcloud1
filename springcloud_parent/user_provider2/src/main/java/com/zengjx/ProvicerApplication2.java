package com.zengjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/11/3  11:29
 * @Version V1.0
 */

@SpringBootApplication
@EnableDiscoveryClient//开启Eureka 客户端发现功能
//@EnableEurekaClient     //开启Eureka客户端发现功能，注册中心只能是Eureka
public class ProvicerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProvicerApplication2.class);
    }

  //将RestTemplate 实例放入Spring容器

//  @Bean
//  public RestTemplate restTemplate(){
//      return new RestTemplate();
//
//  }


}
