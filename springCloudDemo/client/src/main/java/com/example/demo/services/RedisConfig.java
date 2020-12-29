package com.example.demo.services;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: tangdy
 * @Date: 2020/12/14 15:27
 * @Vision: 1.0
 */
@Configuration
public class RedisConfig {
    @Value("${spring.redis.url}")
    private String url;
    @Value("${spring.redis.port}")
    private int port;
    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig config = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(config,url,port);
        return jedisPool;
    }
    @Bean
    public RedissonClient RedissonClientFactory(){
        Config config = new Config();
//        config.useClusterServers().addNodeAddress("redis://192.168.201.130:6379");
//        config.useClusterServers().addNodeAddress("redis://"+url+":"+port);
        config.useSingleServer().setAddress("redis://"+url+":"+port);
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
