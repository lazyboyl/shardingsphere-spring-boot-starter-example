package com.lazyboyl.sharding.mask.algorithm;

import org.apache.shardingsphere.mask.spi.MaskAlgorithm;

import java.util.Properties;

/**
 * 自定义脱敏实现
 * @author linzf
 */
public class MyselfMaskAlgorithm implements MaskAlgorithm<Object, String> {

    private Properties props;

    @Override
    public String mask(Object o) {
        String s = (String) o;
        return s.substring(0,1) + "*****";
    }

    @Override
    public void init(Properties props) {
        this.props = props;
    }

    @Override
    public String getType() {
        return "MyselfMask";
    }
}
