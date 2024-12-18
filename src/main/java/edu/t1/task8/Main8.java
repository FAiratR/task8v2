package edu.t1.task8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.*;

@SpringBootApplication(scanBasePackages= "edu.t1.task8")
public class Main8 {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = SpringApplication.run(Main8.class);
    }
}
