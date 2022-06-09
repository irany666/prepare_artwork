package com.shujian.server.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by shujian.ou 2022/6/6 15:23
 */
@Configurable
@Component
public class AppConfig {

    @Bean
    public RedissonClient redissonConfig() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.0.107:6379");
        return Redisson.create(config);
    }
}
