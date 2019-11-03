package zengjx.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zengjx.domain.User;

import java.net.URI;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zengjx
 * @Company zengjx
 * @Date 2019/11/3  17:05
 * @Version V1.0
 *
 * 超时测试：
 * a.修改user-provider的com.itheima.controller.UserController的findById方法，让它休眠3秒钟。
 * b.修改user-consumer的application.yml，设置超时时间5秒，此时不会熔断。
 * b.修改user-consumer的application.yml，设置超时时间1秒，此时不会熔断。
 */
@RestController
@RequestMapping(value = "consumer")

@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserContrller {

    @Autowired
    private RestTemplate  restTemplate;
    //此对象用于向注册中心获得服务列表
    @Autowired
    private DiscoveryClient discoveryClient;
 //@HystrixCommand(fallbackMethod ="failBack" )   //熔断器
 @HystrixCommand
@RequestMapping("/{id}")
   public User findUserById(@PathVariable(value ="id") Integer  id){

    List<ServiceInstance> instanceList = discoveryClient.getInstances("user-provider");

    ServiceInstance serviceInstance = instanceList.get(0);
    URI uri= serviceInstance.getUri();
    System.out.println("uri="+uri);
    //String  url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;

    String url = "http://user-provider/user/"+id;
  return   restTemplate.getForObject(url,User.class);


}
    /****
     * 服务降级处理方法
     * 将服务全部停掉，启动eureka-server和user-consumer,然后请求http://localhost:18084/consumer/1 测试效果如下：
     * @return
     */
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,处理！");
        return  user;
    }
    /****
     * 全局的服务降级处理方法
     * @return
     */
    public User defaultFailBack(){
        User user = new User();
        user.setUsername("Default-服务降级,默认处理！");
        return  user;
    }



}
