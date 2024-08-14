package com.lazyboyl.sharding.broadcast.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author linzf
 * 类描述： 字典表
 */
@Table(name = "t_dict")
public class Dict {

    /**
     * 字典流水ID
     */
    @Id
    @Column(name = "dict_id")
    private Long dictId;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 字典编码
     */
    @Column(name = "dict_code")
    private String dictCode;

    /**
     * 字典描述
     */
    @Column(name = "dict_text")
    private String dictText;

    /**
     * 字典值
     */
    @Column(name = "dict_value")
    private String dictValue;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictText() {
        return dictText;
    }

    public void setDictText(String dictText) {
        this.dictText = dictText;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
