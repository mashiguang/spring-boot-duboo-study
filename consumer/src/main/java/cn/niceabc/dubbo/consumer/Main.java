package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.FileService;
import cn.niceabc.dubbo.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

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
    public void run(String... args) {
        log.debug("consumer running.");

        UserService userService = (UserService) context.getBean("userService");
        log.debug("[registry:zookeeper,protocol:dubbo], return: {}", userService.get(1L).getName());

        FileService fileService = (FileService) context.getBean("fileService");
        log.debug("[registry:redis,protocol:rmi], return:"+new String(fileService.download()));
    }
}
