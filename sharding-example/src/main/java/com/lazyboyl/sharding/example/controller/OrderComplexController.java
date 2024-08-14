package com.lazyboyl.sharding.example.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.example.entity.Order;
import com.lazyboyl.sharding.example.entity.OrderComplex;
import com.lazyboyl.sharding.example.service.OrderComplexService;
import com.lazyboyl.sharding.example.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 复合订单分片的controller
 *
 * @author linzef
 * @since 2024-08-12
 */
@RestController
@RequestMapping("complex")
@Api(tags = OrderComplexController.TAG_NAME)
public class OrderComplexController {

    protected static final String TAG_NAME = "复合订单分片接口";

    @Resource
    private OrderComplexService orderComplexService;


    /**
     * 实现新增订单
     *
     * @param orderComplex 订单的实体
     */
    @PostMapping("saveOrder")
    @ApiOperation(value = "复合分片新增订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public void saveOrder(@RequestBody OrderComplex orderComplex) {
        orderComplexService.saveOrder(orderComplex);
    }



    /**
     * 根据订单ID和用户ID来查询订单
     * @param orderComplex
     * @return
     */
    @PostMapping("queryOrderComplex")
    @ApiOperation(value = "根据订单ID和用户ID来查询订单", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public List<OrderComplex> queryOrderComplex(@RequestBody OrderComplex orderComplex){
        return orderComplexService.queryOrderComplex(orderComplex);
    }


}
