package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.DemoService;
import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
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
public class AnnotationTest {
    private static Logger log = LoggerFactory.getLogger(AnnotationTest.class);

    @Reference
    private DemoService demoService;

    @Test
    public void testGet() {
        String str = demoService.sayHello("Jack");
        Assert.assertEquals("hi,Jack", str);

        String str2 = demoService.sayHello("Tom");
        Assert.assertEquals("hi,Tom", str2);
    }


}
