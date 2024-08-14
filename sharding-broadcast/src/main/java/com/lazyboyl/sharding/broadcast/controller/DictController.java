package com.lazyboyl.sharding.broadcast.controller;


import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.lazyboyl.sharding.broadcast.entity.Dict;
import com.lazyboyl.sharding.broadcast.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author linzf
 * @since 2021/11/20
 * 类描述：
 */
@RestController
@Api(tags = DictController.TAG_NAME)
public class DictController {

    protected static final String TAG_NAME = "broadcast广播表的相关接口";

    @Resource
    private DictService dictService;

    /**
     * 功能描述： 更新数据字典的数据
     *
     * @param dict
     */
    @PostMapping("updateDict")
    @ApiOperation(value = "更新数据字典的数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 1)
    public void updateDict(@RequestBody Dict dict) {
        dictService.updateDict(dict);
    }

    /**
     * 功能描述： 删除字典数据
     *
     * @param dictId
     */
    @PostMapping("deleteDict")
    @ApiOperation(value = "删除字典数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 2)
    public void deleteDict(Long dictId) {
        dictService.deleteDict(dictId);
    }

    /**
     * 功能描述： 保存字典数据
     *
     * @param dict
     */
    @PostMapping("saveDict")
    @ApiOperation(value = "保存字典数据", tags = TAG_NAME)
    @ApiOperationSupport(order = 3)
    public void saveDict(@RequestBody Dict dict) {
        dictService.saveDict(dict);
    }

}
