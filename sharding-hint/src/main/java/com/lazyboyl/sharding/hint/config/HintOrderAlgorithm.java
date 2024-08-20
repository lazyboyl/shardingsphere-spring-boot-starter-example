package com.lazyboyl.sharding.hint.config;

import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.Collections;

public class HintOrderAlgorithm implements HintShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection availableTargetNames, HintShardingValue shardingValue) {
        Collection values =  shardingValue.getValues();
        if (values.size() > 0) {
            Long orderId = (Long) values.iterator().next();
            return Collections.singletonList("db" + (orderId % 2));
        }
        return Collections.emptyList();
    }

}
