package com.company.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Environment env = context.getBean(Environment.class);
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port") == null ? "8080" : env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path") == null ? "" : env.getProperty("server.servlet.context-path");
        log.info("系统启动成功，访问入口：http://{}:{}/{}", ip,port,contextPath);
    }
}

