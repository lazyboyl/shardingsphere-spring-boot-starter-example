package com.lazyboyl.sharding.broadcast;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.broadcast.dao")
@EnableShardingSphereSpringStarter
public class ShardingBroadcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingBroadcastApplication.class, args);
    }

}
