package com.lazyboyl.sharding.single.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_single")
public class Single {

    /**
     * 单表流水ID
     */
    @Id
    @Column(name = "single_id")
    private Long singleId;

    /**
     * 单表名称
     */
    @Column(name = "single_name")
    private String singleName;

    public Long getSingleId() {
        return singleId;
    }

    public void setSingleId(Long singleId) {
        this.singleId = singleId;
    }

    public String getSingleName() {
        return singleName;
    }

    public void setSingleName(String singleName) {
        this.singleName = singleName;
    }
}
