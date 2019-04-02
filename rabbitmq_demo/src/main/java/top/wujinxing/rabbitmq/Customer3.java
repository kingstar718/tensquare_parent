package top.wujinxing.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: wujinxing
 * @date: 2019/4/1 22:20
 * @description:
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("kudingyu接受到消息:" + message);
    }
}
