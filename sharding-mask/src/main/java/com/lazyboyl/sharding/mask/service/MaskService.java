package com.lazyboyl.sharding.mask.service;


import com.lazyboyl.sharding.mask.dao.MaskDao;
import com.lazyboyl.sharding.mask.entity.Mask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 脱敏算法的service
 *
 * @author linzf
 */
@Service
@Transactional
public class MaskService {

    @Resource
    private MaskDao maskDao;

    /**
     * 查询数据
     *
     * @param id
     * @return
     */
    public Mask getMask(Long id) {
        return maskDao.selectByPrimaryKey(id);
    }

    /**
     * 保存脱敏数据
     *
     * @param mask
     * @return
     */
    public Mask saveMask(Mask mask) {
        maskDao.insertSelective(mask);
        return mask;
    }

}
