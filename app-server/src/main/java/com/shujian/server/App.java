package com.shujian.server;

import cn.hutool.cron.CronUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by shujian.ou 2022/6/6 15:18
 */
@SpringBootApplication
public class App  {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        CronUtil.start();
    }
}
