package com.lazyboyl.sharding.shadow.service;


import com.lazyboyl.sharding.shadow.dao.OrderDao;
import com.lazyboyl.sharding.shadow.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 订单的service
 *
 * @author linzef
 * @since 2024-07-15
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 实现更新订单
     *
     * @param order 订单的实体
     */
    public Integer updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    /**
     * 实现删除订单
     *
     * @param order 订单的实体
     */
    public Integer deleteOrder(Order order) {
        return orderDao.deleteOrder(order);
    }

    /**
     * 实现新增订单
     *
     * @param order 订单的实体
     */
    public Integer saveOrder(Order order) {
        return orderDao.insertSelective(order);
    }

    /**
     * 根据订单ID来获取订单数据
     *
     * @param order
     * @return 返回查询结果
     */
    public Order queryOrder(Order order) {
        return orderDao.queryOrder(order);
    }


}
