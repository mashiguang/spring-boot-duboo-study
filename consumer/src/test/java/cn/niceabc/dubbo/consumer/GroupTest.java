package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.DemoService;
import cn.niceabc.dubbo.api.IndexService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 服务分组
 * */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Main.class)
@ActiveProfiles("test")
public class GroupTest {
    private static Logger log = LoggerFactory.getLogger(GroupTest.class);

    @Reference(group = "foo")
    private IndexService indexServiceFoo;

    @Reference(group = "bar")
    private IndexService indexServiceBar;

    @Reference(group = "*")
    private IndexService indexServiceAny;

    @Test
    public void test() {

        Assert.assertEquals("foo", indexServiceFoo.index());
        Assert.assertEquals("bar", indexServiceBar.index());

        for (int i = 0; i < 10; i++) {

            String any = indexServiceAny.index();
            log.debug("'any' is {}", any);
            Assert.assertTrue("foo".equals(any) || "bar".equals(any));
        }


    }


}
