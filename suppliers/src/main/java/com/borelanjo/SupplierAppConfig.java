package com.borelanjo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SupplierAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(SupplierAppConfig.class, args);
    }

}
