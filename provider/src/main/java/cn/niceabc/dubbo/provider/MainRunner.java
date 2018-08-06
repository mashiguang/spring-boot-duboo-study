package cn.niceabc.dubbo.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MainRunner implements CommandLineRunner {
    private static Logger log = LoggerFactory.getLogger(MainRunner.class);

    @Override
    public void run(String... args) throws Exception {

        log.debug("running.");

        Thread.currentThread().join();
    }
}
