package com.lazyboyl.sharding.single;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.single.dao")
@EnableShardingSphereSpringStarter
public class ShardingSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSingleApplication.class, args);
    }

}
