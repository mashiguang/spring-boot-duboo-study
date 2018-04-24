package cn.niceabc.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource("provider.xml")
public class Main {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);

        System.in.read();
    }
}
