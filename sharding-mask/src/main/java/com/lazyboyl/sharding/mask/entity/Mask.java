package com.lazyboyl.sharding.mask.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 脱敏的测试表
 * 更多脱敏算法详见：https://shardingsphere.apache.org/document/current/cn/dev-manual/mask/
 * @author linzf
 */
@Table(name = "t_mask")
public class Mask {

    /**
     * 字典流水ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 遮盖自 x 至 y 数据脱敏算法
     */
    @Column(name="mask_from_x_to_y")
    private String maskFromXToY;

    /**
     * 自定义的脱敏算法
     */
    @Column(name="myself_mask")
    private String myselfMask;

    /**
     * 基于 MD5 的数据脱敏算法
     */
    @Column(name="md5_mask")
    private String md5Mask;

    /**
     * 特殊字符前遮盖数据脱敏算法
     */
    @Column(name="mask_before_special_chars_mask")
    private String maskBeforeSpecialCharsMask;

    /**
     * 保留前 n 后 m 数据脱敏算法
     */
    @Column(name="keep_first_n_last_m_mask")
    private String keepFirstNLastMMask;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaskFromXToY() {
        return maskFromXToY;
    }

    public void setMaskFromXToY(String maskFromXToY) {
        this.maskFromXToY = maskFromXToY;
    }

    public String getMyselfMask() {
        return myselfMask;
    }

    public void setMyselfMask(String myselfMask) {
        this.myselfMask = myselfMask;
    }

    public String getMd5Mask() {
        return md5Mask;
    }

    public void setMd5Mask(String md5Mask) {
        this.md5Mask = md5Mask;
    }

    public String getMaskBeforeSpecialCharsMask() {
        return maskBeforeSpecialCharsMask;
    }

    public void setMaskBeforeSpecialCharsMask(String maskBeforeSpecialCharsMask) {
        this.maskBeforeSpecialCharsMask = maskBeforeSpecialCharsMask;
    }

    public String getKeepFirstNLastMMask() {
        return keepFirstNLastMMask;
    }

    public void setKeepFirstNLastMMask(String keepFirstNLastMMask) {
        this.keepFirstNLastMMask = keepFirstNLastMMask;
    }
}
