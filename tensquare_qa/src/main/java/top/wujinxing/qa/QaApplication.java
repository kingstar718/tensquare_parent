package top.wujinxing.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;
import util.JwtUtil;

/**
 * @author: wujinxing
 * @date: 2019/3/28 15:09
 * @description:
 */
@SpringBootApplication
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
