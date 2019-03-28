package top.wujinxing.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import top.wujinxing.base.service.LabelServie;

/**
 * @author: wujinxing
 * @date: 2019/3/28 09:53
 * @description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class test1 {

    @Before
    public void before(){
        System.out.println("before");
    }

    @Autowired
    private LabelServie labelServie;

    @Test
    public void findAll(){
        labelServie.findAll();
    }


    @After
    public void after(){
        System.out.println("after");
    }
}
