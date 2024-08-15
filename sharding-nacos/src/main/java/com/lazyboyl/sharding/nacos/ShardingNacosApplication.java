package com.lazyboyl.sharding.nacos;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.nacos.dao")
@EnableShardingSphereSpringStarter
@EnableDiscoveryClient
public class ShardingNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingNacosApplication.class, args);
    }

}
