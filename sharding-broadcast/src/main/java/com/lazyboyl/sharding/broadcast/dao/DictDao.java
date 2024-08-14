package com.lazyboyl.sharding.broadcast.dao;

import com.lazyboyl.sharding.broadcast.entity.Dict;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author linzf
 * 类描述： 字典的dao
 */
public interface DictDao extends Mapper<Dict> {

    /**
     * 功能描述： 更新数据字典的数据
     *
     * @param dict
     * @return
     */
    int updateDict(Dict dict);

}
