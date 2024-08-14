package com.lazyboyl.sharding.example.dao;

import com.lazyboyl.sharding.example.entity.OrderComplex;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * 复合分片订单的dao
 *
 * @author linzef
 * @since 2024-07-15
 */
public interface OrderComplexDao extends Mapper<OrderComplex> {

    /**
     * 订单查询
     * @param orderComplex
     * @return
     */
    List<OrderComplex> queryOrderComplex(OrderComplex orderComplex);

}
