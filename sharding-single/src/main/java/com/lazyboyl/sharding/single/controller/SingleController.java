package com.lazyboyl.sharding.single.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.single.entity.Single;
import com.lazyboyl.sharding.single.service.SingleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 单表的controller
 *
 * @author linzf
 */
@RestController
@Api(tags = SingleController.TAG_NAME)
public class SingleController {

    protected static final String TAG_NAME = "single单表的相关接口";

    @Resource
    private SingleService singleService;

    /**
     * 保存数据
     *
     * @param single
     */
    @PostMapping("saveSingle")
    @ApiOperation(value = "保存数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public void saveSingle(@RequestBody Single single) {
        singleService.saveSingle(single);
    }


    /**
     * 查询数据
     *
     * @param single
     */
    @PostMapping("querySingle")
    @ApiOperation(value = "查询数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public Single querySingle(@RequestBody Single single) {
        return singleService.querySingle(single);
    }


    /**
     * 删除数据
     *
     * @param single
     */
    @PostMapping("deleteSingle")
    @ApiOperation(value = "删除数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 3)
    public void deleteSingle(@RequestBody Single single) {
        singleService.deleteSingle(single);
    }

}
