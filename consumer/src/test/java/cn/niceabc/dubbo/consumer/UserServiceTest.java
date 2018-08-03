package cn.niceabc.dubbo.consumer;

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
    public void test() {
        String username = userService.get(1L).getName();
        log.debug("[registry:zookeeper,protocol:dubbo], return: {}", username);
        log.debug("配置信息:{}\n", RpcContext.getContext().getUrl());

        Assert.assertEquals("Jack", username);
    }
}
