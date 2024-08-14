package com.lazyboyl.sharding.encrypt;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.encrypt.dao")
@EnableShardingSphereSpringStarter
public class ShardingEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingEncryptApplication.class, args);
    }

}
