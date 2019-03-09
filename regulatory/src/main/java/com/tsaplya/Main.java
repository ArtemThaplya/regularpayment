package com.tsaplya;

import com.tsaplya.entries.StartWriteOff;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("fg");

        StartWriteOff startWriteOff = ctx.getBean(StartWriteOff.class);
        startWriteOff.allPayments();
        startWriteOff.verificationOfNeedForWriteOffPayment();
    }
}
