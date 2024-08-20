package com.lazyboyl.sharding.hint.dao;

import com.lazyboyl.sharding.hint.entity.Order;
import tk.mybatis.mapper.common.Mapper;


/**
 * 订单的dao
 *
 * @author linzef
 * @since 2024-07-15
 */
public interface OrderDao extends Mapper<Order> {

    /**
     * 根据订单id和用户id查询订单
     * @param orderId
     * @param userId
     * @return
     */
    Order querOrder(Long orderId,Long userId);

}
