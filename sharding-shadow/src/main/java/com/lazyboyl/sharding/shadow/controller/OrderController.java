package com.lazyboyl.sharding.shadow.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.shadow.entity.Order;
import com.lazyboyl.sharding.shadow.service.OrderService;
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

    protected static final String TAG_NAME = "影子库订单分片接口";

    @Resource
    private OrderService orderService;
    /**
     * 实现更新订单
     *
     * @param order 订单的实体
     */
    @PostMapping("updateOrder")
    @ApiOperation(value = "更新影子库订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 5)
    public Integer updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    /**
     * 实现删除订单
     *
     * @param order 订单的实体
     */
    @PostMapping("deleteOrder")
    @ApiOperation(value = "删除影子库订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 4)
    public Integer deleteOrder(@RequestBody Order order) {
        return orderService.deleteOrder(order);
    }

    /**
     * 实现新增订单
     *
     * @param order 订单的实体
     */
    @PostMapping("saveOrder")
    @ApiOperation(value = "新增影子库订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    /**
     * 根据订单ID来获取订单数据
     *
     * @param order
     * @return 返回查询结果
     */
    @PostMapping("queryOrder")
    @ApiOperation(value = "影子库订单查询非xml", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public Order queryOrder(@RequestBody Order order) {
        Order orderQuery = orderService.queryOrder(order);
        return orderQuery;
    }


}
