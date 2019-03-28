package top.wujinxing.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import util.IdWorker;

/**
 * @author: wujinxing
 * @date: 2019/3/27 21:38
 * @description: 启动类
 */

@SpringBootApplication
@CrossOrigin  //跨域
//@ComponentScan(basePackages = "top.wujinxing.base")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }
}
