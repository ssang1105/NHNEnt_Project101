package com.nhnent;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;

@Configuration
@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.nhnent")
public class GuestBookApplication extends SpringBootServletInitializer{
    private static Logger logger = Logger.getLogger(GuestBookApplication.class.getName());
    
    public static void main(String[] args) {
        logger.info("SPRING VERSION: " + SpringVersion.getVersion());
        SpringApplication.run(GuestBookApplication.class, args);
    }
}
