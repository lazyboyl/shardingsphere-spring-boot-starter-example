package com.lazyboyl.sharding.single.service;


import com.lazyboyl.sharding.single.dao.SingleDao;
import com.lazyboyl.sharding.single.entity.Single;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 单表的service
 *
 * @author linzf
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class SingleService {

    @Resource
    private SingleDao singleDao;

    /**
     * 保存数据
     *
     * @param single
     */
    public void saveSingle(Single single) {
        singleDao.insertSelective(single);
    }


    /**
     * 查询数据
     *
     * @param single
     */
    public Single querySingle(Single single) {
        return singleDao.selectByPrimaryKey(single.getSingleId());
    }


    /**
     * 删除数据
     *
     * @param single
     */
    public void deleteSingle(Single single) {
        singleDao.deleteByPrimaryKey(single.getSingleId());
    }

}
