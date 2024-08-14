package com.lazyboyl.sharding.example.service;


import com.lazyboyl.sharding.example.dao.OrderDao;
import com.lazyboyl.sharding.example.entity.Order;
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
     * 实现新增订单
     *
     * @param order 订单的实体
     */
    public void saveOrder(Order order) {
        orderDao.insertSelective(order);
    }

    /**
     * 根据订单ID来获取订单数据
     *
     * @param orderId 订单流水ID
     * @return 返回查询结果
     */
    public Order getOrderByOrderId(Long orderId) {
        return orderDao.selectByPrimaryKey(orderId);
    }


}
