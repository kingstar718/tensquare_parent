package top.wujinxing.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: wujinxing
 * @date: 2019/4/1 22:15
 * @description:
 */
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("itheima接受到消息:" + message);
    }
}
