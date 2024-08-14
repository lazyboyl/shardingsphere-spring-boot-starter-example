package com.lazyboyl.sharding.example.algorithm.complex;

import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

/**
 * 数据库自定义分片算法
 *
 * @author linzf
 */
public class OrderDbComplex implements ComplexKeysShardingAlgorithm<Long> {

    private Properties props = new Properties();

    private static final String ALGORITHM_ALGORITHM_DATABASE_KEY = "algorithm-database";

    private String algorithmDatabase;

    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Long> complexKeysShardingValue) {
        List<String> shardingList = new ArrayList();
        // 获取请求参数
        Map<String, Collection<Long>> columnNameAndShardingValuesMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        List orderIdList = (List) columnNameAndShardingValuesMap.get("order_id");
        List userIdList = (List) columnNameAndShardingValuesMap.get("user_id");
        Long order_id = orderIdList != null ? getObjLong(orderIdList.get(0)) : 0L;
        Long user_id = userIdList != null ? getObjLong(userIdList.get(0)) : 0L;
        Long modVal = 0L;
        // 分片的规则首先以订单ID进行分片
        if (order_id > 0L) {
            modVal = order_id % 2;
        }
        // 若订单ID和用户ID同时存在的情况下，以用户ID进行分片
        if (user_id > 0L) {
            modVal = user_id % 2;
        }
        for (Iterator<String> iter = collection.iterator(); iter.hasNext(); ) {
            String str = iter.next();
            if ((algorithmDatabase + modVal).equals(str)) {
                shardingList.add(str);
            }
        }
        return shardingList;
    }

    @Override
    public void init(Properties properties) {
        this.props = properties;
        this.algorithmDatabase = props.getProperty(ALGORITHM_ALGORITHM_DATABASE_KEY, "");
    }

    @Override
    public String getType() {
        return "OrderDbComplex";
    }

    /**
     * 将obj转换为Long
     *
     * @param obj
     * @return
     */
    public static Long getObjLong(Object obj) {
        return Long.parseLong(obj == null ? "0" : obj + "");
    }

}
