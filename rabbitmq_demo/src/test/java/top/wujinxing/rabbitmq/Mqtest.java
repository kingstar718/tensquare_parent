package top.wujinxing.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: wujinxing
 * @date: 2019/4/1 17:42
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class Mqtest {

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Test
    public void testSend(){
        rabbitMessagingTemplate.convertAndSend("itcast", "我要红包");
    }

    @Test
    public void testSendFanout(){
        rabbitMessagingTemplate.convertAndSend("chuanzhi", "", "分列模式走起");
    }
}
