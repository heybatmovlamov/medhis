package com.qrcoderesultaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class QrCodeResultAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrCodeResultAccessApplication.class, args);
    }
}
