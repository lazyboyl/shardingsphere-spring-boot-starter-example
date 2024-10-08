# 1、nacos上的配置内容如下：

```yaml
spring:
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
  main:
    allow-bean-definition-overriding: true
  shardingsphere:
    dataSources:
      db0:
        dataSourceClassName: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://114.132.79.213:3306/sharding_db0?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8
        username: sharding
        password: sharding321!
      db1:
        dataSourceClassName: com.alibaba.druid.pool.DruidDataSource
        driverClassName: com.mysql.jdbc.Driver
        url: jdbc:mysql://114.132.79.213:3306/sharding_db1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2b8
        username: sharding
        password: sharding321!
    rules:
      # 单表
      single:
        # 单表默认的数据源
        defaultDataSource: db0
        tables:
          - db0.t_single
    # 显示转义以后的sql语句
    props:
      # SQL语句打印
      sql-show: true
      # 简化打印SQL语句
      sql-simple: true
      # 禁用执行SQL用于获取数据库元数据
      check-table-metadata-enabled: true

# 配置日志
logging:
  config: classpath:logConfig/logback-dev.xml
  level:
    root: INFO
    com:
      github:
        lazyboyl:
          shardingsphere: DEBUG

# mybatis的配置
mybatis:
  config-location: classpath:mybatis/mybatis-config.xml
  mapper-locations: classpath:mybatis/mapper/*.xml

```

