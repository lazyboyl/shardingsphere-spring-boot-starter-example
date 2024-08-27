package com.lazyboyl.sharding.algorithm.encrypt;



import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithmMetaData;
import org.apache.shardingsphere.infra.algorithm.core.context.AlgorithmSQLContext;

import java.util.Properties;

/**
 * 默认不加密的实现
 *
 * @author linzf
 */
public class NoEncryptAlgorithm implements EncryptAlgorithm {

    private Properties props;

    @Override
    public String getType() {
        return "NONE";
    }

    @Override
    public void init(final Properties props) {
        this.props = props;
    }

    private String getObjStr(Object o) {
        return o == null ? "" : String.valueOf(o);
    }


    @Override
    public Object encrypt(Object o, AlgorithmSQLContext algorithmSQLContext) {
        return o;
    }

    @Override
    public Object decrypt(Object o, AlgorithmSQLContext algorithmSQLContext) {
        return o;
    }

    @Override
    public EncryptAlgorithmMetaData getMetaData() {
        return new EncryptAlgorithmMetaData(true, true, true);
    }
}
