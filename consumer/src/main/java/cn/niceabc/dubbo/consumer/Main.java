package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.FileService;
import cn.niceabc.dubbo.api.User;
import cn.niceabc.dubbo.api.UserService;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource("consumer.xml")
@PropertySource("dubbo.properties")
public class Main implements CommandLineRunner {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws ExecutionException, InterruptedException {
        log.debug("consumer running.");

        RpcContext.getContext().setAttachment("param1", "隐式参数1");

        EchoService echoService = (EchoService) context.getBean("userService");
        String status = (String) echoService.$echo("ok");
        log.debug("userService回声测试, return: {}", status);

        UserService userService = (UserService) context.getBean("userService");
        log.debug("[registry:zookeeper,protocol:dubbo], return: {}", userService.get(1L).getName());

        //异步
        userService.getAll();
        Future<List<User>> usersFuture = RpcContext.getContext().getFuture();

        List<User> users = usersFuture.get();
        log.debug("异步调用返回users:{}", users);


        FileService fileService = (FileService) context.getBean("fileService");
        log.debug("[registry:redis,protocol:rmi], return:"+new String(fileService.download()));

        log.debug("本端是否为consumer端:{}", RpcContext.getContext().isConsumerSide());
        log.debug("最后一次调用provider端地址:{}", RpcContext.getContext().getRemoteHost());
        log.debug("配置信息:{}", RpcContext.getContext().getUrl());

    }
}
