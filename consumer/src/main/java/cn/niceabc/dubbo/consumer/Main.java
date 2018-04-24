package cn.niceabc.dubbo.consumer;

import cn.niceabc.dubbo.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("consumer.xml")
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
        log.debug("user.name={}", userService.get(1L).getName());
    }
}
