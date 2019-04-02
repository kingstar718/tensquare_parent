import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wujinxing.user.UserApplication;
import top.wujinxing.user.dao.UserDao;
import top.wujinxing.user.service.UserService;

import javax.annotation.Resource;

/**
 * @author: wujinxing
 * @date: 2019/4/2 09:29
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(value = "UserApplication")
public class test {

    @Resource(name = "")
    private UserService userService;

    @Test
    public void test1(){

    }
}
