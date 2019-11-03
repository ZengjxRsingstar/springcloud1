package zengjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
@EnableDiscoveryClient
@EnableCircuitBreaker   //开启熔断器
public class ConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class);
    }

  //将RestTemplate 实例放入Spring容器
  @LoadBalanced//负载均衡
  @Bean
  public RestTemplate restTemplate(){
      return new RestTemplate();
  }


}
