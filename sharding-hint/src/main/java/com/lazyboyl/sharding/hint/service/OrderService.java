package com.lazyboyl.sharding.hint.service;


import com.lazyboyl.sharding.hint.dao.OrderDao;
import com.lazyboyl.sharding.hint.entity.Order;
import org.apache.shardingsphere.infra.hint.HintManager;
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
        // 获取强制分片算法实例
        HintManager hintManager = HintManager.getInstance();
        // 设置表的强制分片键的值
        hintManager.addTableShardingValue("t_order", order.getUserId());
        // 设置数据库强制分片键的值
        hintManager.addDatabaseShardingValue("t_order", order.getUserId());
        // 强制指定路由到某个数据库
//        hintManager.setDataSourceName("db0");
        orderDao.insertSelective(order);
        hintManager.close();
    }

    /**
     * 根据订单ID来获取订单数据
     *
     * @param orderId 订单流水ID
     * @return 返回查询结果
     */
    public Order getOrderByOrderId(Long orderId, Long userId) {
        // 获取强制分片算法实例
        HintManager hintManager = HintManager.getInstance();
        // 设置表的强制分片键的值
        hintManager.addTableShardingValue("t_order", userId);
        // 设置数据库强制分片键的值
        hintManager.addDatabaseShardingValue("t_order", userId);
        Order order = orderDao.querOrder(orderId, userId);
        hintManager.close();
        return order;
    }


}
