package com.sf.spring.cloud.bus.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RabbitMqProducerApplication {
    @RequestMapping("/")
    public String home() {
        return "home page";
    }
    @RequestMapping("/info")
    public String info() {
        return "info page";
    }
    public static void main(String[] args) throws IOException {
        Properties configProperties = new Properties();
        InputStream config = RabbitMqProducerApplication.class.getClassLoader().getResourceAsStream("application-client.properties");
        configProperties.load(config);
        SpringApplication springApplication = new SpringApplication(RabbitMqProducerApplication.class);
        springApplication.setDefaultProperties(configProperties);
        springApplication.run(args);
    }
}