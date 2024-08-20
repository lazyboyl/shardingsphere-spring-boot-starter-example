package com.lazyboyl.sharding.hint;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.hint.dao")
@EnableShardingSphereSpringStarter
public class ShardingHintApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingHintApplication.class, args);
    }

}
