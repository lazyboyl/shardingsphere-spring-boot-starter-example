package com.lazyboyl.sharding.example;

import com.github.lazyboyl.shardingsphere.springboot.starter.scanner.EnableShardingSphereSpringStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lazyboyl.sharding.example.dao")
@EnableShardingSphereSpringStarter
public class ShardingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingExampleApplication.class, args);
	}

}
