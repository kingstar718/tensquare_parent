package top.wujinxing.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author: wujinxing
 * @date: 2019/3/28 11:35
 * @description:
 */
@SpringBootApplication
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class);
    }

    /**
     * 将id生成器放到容器中
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
