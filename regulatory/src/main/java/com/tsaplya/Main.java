package com.tsaplya;

import com.tsaplya.service.entries.StartWriteOff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main extends SpringBootServletInitializer {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        StartWriteOff startWriteOff = ctx.getBean(StartWriteOff.class);
        startWriteOff.allPayments();
        startWriteOff.verificationOfNeedForWriteOffPayment();
        System.out.println("regulatory");
    }
}
