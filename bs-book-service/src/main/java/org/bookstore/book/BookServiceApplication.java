package org.bookstore.book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BookServiceApplication {
    @Value("${info.description:default}")
    private String value;

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BookServiceApplication.class, args);

    }

    @RequestMapping("/")
    public String home() {
        return port + " X " + value + " " + Long.toString(new Random().nextLong());
    }
}
