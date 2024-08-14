package com.lazyboyl.sharding.readwrite;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.readwrite.dao")
@EnableShardingSphereSpringStarter
public class ShardingReadwriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingReadwriteApplication.class, args);
    }

}
