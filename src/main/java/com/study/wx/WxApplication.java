package com.study.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author TangFD@HF
 */
@SpringBootApplication
@EnableScheduling
public class WxApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WxApplication.class);
    }

    public static void main(String[] args) {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("D:\\git-work\\km\\redis-2.4.5-win32-win64\\64bit\\redis-server.exe");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(WxApplication.class, args);
    }
}
