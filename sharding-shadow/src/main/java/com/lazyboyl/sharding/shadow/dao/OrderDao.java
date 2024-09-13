package com.lazyboyl.sharding.shadow.dao;

import com.lazyboyl.sharding.shadow.entity.Order;
import tk.mybatis.mapper.common.Mapper;


/**
 * 订单的dao
 *
 * @author linzef
 * @since 2024-07-15
 */
public interface OrderDao extends Mapper<Order> {

    /**
     * 更新订单
     * @param order
     * @return
     */
    Integer updateOrder(Order order);

    /**
     * 删除订单
     * @param order
     * @return
     */
    Integer deleteOrder(Order order);

    /**
     * 订单查询
     * @param order
     * @return
     */
    Order queryOrder(Order order);


}
