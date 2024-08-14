package com.lazyboyl.sharding.shadow;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.shadow.dao")
@EnableShardingSphereSpringStarter
public class ShardingShadowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingShadowApplication.class, args);
    }

}
