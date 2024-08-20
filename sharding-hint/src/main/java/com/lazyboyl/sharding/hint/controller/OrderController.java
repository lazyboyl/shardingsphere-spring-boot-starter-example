package com.lazyboyl.sharding.hint.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.hint.entity.Order;
import com.lazyboyl.sharding.hint.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单的controller
 *
 * @author linzef
 * @since 2024-07-15
 */
@RestController
@Api(tags = OrderController.TAG_NAME)
public class OrderController {

    protected static final String TAG_NAME = "订单分片接口";

    @Resource
    private OrderService orderService;


    /**
     * 实现新增订单
     *
     * @param order 订单的实体
     */
    @PostMapping("saveOrder")
    @ApiOperation(value = "新增订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    /**
     * 根据订单ID来获取订单数据
     *
     * @param orderId 订单流水ID
     * @return 返回查询结果
     */
    @PostMapping("getOrderByOrderId")
    @ApiOperation(value = "订单查询", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public Order getOrderByOrderId(Long orderId,Long userId) {
        return orderService.getOrderByOrderId(orderId,userId);
    }


}
