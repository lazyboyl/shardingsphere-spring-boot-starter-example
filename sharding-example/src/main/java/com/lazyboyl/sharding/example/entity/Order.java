package com.lazyboyl.sharding.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 订单表
 *
 * @author linzef
 * @since 2024-08-12
 */
@ApiModel("订单实体")
@Table(name = "t_order")
@Data
public class Order {

    /**
     * 订单流水ID
     */
    @Id
    @Column(name = "order_id")
    @ApiModelProperty("订单流水ID")
    private Long orderId;

    /**
     * 用户流水ID
     */
    @Column(name = "user_id")
    @ApiModelProperty("用户流水ID")
    private Long userId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    @ApiModelProperty("订单编号")
    private String orderNo;


    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("订单创建时间")
    private Date createTime;

}
