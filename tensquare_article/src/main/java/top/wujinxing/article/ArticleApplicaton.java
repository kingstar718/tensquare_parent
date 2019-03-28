package top.wujinxing.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author: wujinxing
 * @date: 2019/3/28 16:00
 * @description:
 */
@SpringBootApplication
public class ArticleApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplicaton.class);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}
