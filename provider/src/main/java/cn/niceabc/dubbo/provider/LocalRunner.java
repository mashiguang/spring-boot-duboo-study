package cn.niceabc.dubbo.provider;

import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LocalRunner implements CommandLineRunner {
    private static Logger log = LoggerFactory.getLogger(LocalRunner.class);

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {

        log.debug("in provider's local runner.");

        UserService userService = (UserService) context.getBean("userService");
        log.debug("[registry:zookeeper,protocol:dubbo], return: {}", userService.get(1L).getName());
        log.debug("配置信息:{}\n", RpcContext.getContext().getUrl());
    }
}
