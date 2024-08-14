package com.lazyboyl.sharding.mask;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.mask.dao")
@EnableShardingSphereSpringStarter
public class ShardingMaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingMaskApplication.class, args);
    }

}
