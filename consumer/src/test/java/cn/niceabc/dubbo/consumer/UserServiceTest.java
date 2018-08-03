package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Main.class)
@ActiveProfiles("test")
public class UserServiceTest {
    private static Logger log = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void testGet() {
        User user = userService.get(1L);
        String username = user.getName();

        Assert.assertEquals("Jack", username);
    }

    @Test
    public void testAttachment() {
        log.debug("测试隐式参数");

        RpcContext.getContext().setAttachment("nickname", "Jacky");

        User user = userService.get(1L);
        String username = user.getName();
        String nickname = user.getNickname();

        Assert.assertEquals("Jack", username);
        Assert.assertEquals("Jacky", nickname);
    }

    @Test
    public void testStub() {
        User user = userService.get(null);
        String username = user.getName();

        Assert.assertEquals("Mr.Null.", username);
    }
}
