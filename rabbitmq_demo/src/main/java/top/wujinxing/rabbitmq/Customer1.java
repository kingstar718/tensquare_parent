package top.wujinxing.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: wujinxing
 * @date: 2019/4/1 21:54
 * @description:
 */
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itcast接受到消息: " + message);
    }
}
