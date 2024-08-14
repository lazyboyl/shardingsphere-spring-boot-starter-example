package com.lazyboyl.sharding.example.service;


import com.lazyboyl.sharding.example.dao.OrderComplexDao;
import com.lazyboyl.sharding.example.dao.OrderDao;
import com.lazyboyl.sharding.example.entity.Order;
import com.lazyboyl.sharding.example.entity.OrderComplex;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 复合分片订单的service
 *
 * @author linzef
 * @since 2024-07-15
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class OrderComplexService {

    @Resource
    private OrderComplexDao orderComplexDao;

    /**
     * 实现新增订单
     *
     * @param orderComplex 订单的实体
     */
    public void saveOrder(OrderComplex orderComplex) {
        orderComplexDao.insertSelective(orderComplex);
    }


    /**
     * 根据订单ID和用户ID来查询订单
     * @param orderComplex
     * @return
     */
    public List<OrderComplex> queryOrderComplex(OrderComplex orderComplex){
        return orderComplexDao.queryOrderComplex(orderComplex);
    }


}
