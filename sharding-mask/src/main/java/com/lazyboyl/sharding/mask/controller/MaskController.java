package com.lazyboyl.sharding.mask.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.mask.entity.Mask;
import com.lazyboyl.sharding.mask.service.MaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 保存脱敏数据的dao
 *
 * @author linzf
 */
@RestController
@Api(tags = MaskController.TAG_NAME)
public class MaskController {

    protected static final String TAG_NAME = "mask脱敏的相关接口";

    @Resource
    private MaskService maskService;


    /**
     * 查询数据
     *
     * @param id
     * @return
     */
    @PostMapping("getMask")
    @ApiOperation(value = "查询脱敏数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public Mask getMask(Long id) {
        return maskService.getMask(id);
    }

    /**
     * 保存脱敏数据
     *
     * @param mask
     * @return
     */
    @PostMapping("saveMask")
    @ApiOperation(value = "保存脱敏数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public Mask saveMask(@RequestBody Mask mask) {
        return maskService.saveMask(mask);
    }

}
