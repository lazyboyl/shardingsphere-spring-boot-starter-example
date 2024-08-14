package com.lazyboyl.sharding.encrypt.algorithm;


import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithmMetaData;
import org.apache.shardingsphere.infra.algorithm.core.context.AlgorithmSQLContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import static org.locationtech.jts.io.WKBWriter.bytesToHex;

/**
 * 自定义MD5加盐的加密的实现
 *
 * @author linzf
 */
public class Md5EncryptAlgorithm implements EncryptAlgorithm {

    private Properties props;


    private static final String ALGORITHM_MD5NEW_SLAT_KEY = "slat";

    private String md5Slat;


    @Override
    public String getType() {
        return "MD5NEW";
    }

    @Override
    public void init(final Properties props) {
        this.props = props;
        md5Slat = props.getProperty(ALGORITHM_MD5NEW_SLAT_KEY, "");
    }


    public String getMD5HashWithSalt(String data, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(data.getBytes());

            // Convert the byte array to a hexadecimal representation
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getObjStr(Object o) {
        return o == null ? "" : String.valueOf(o);
    }

    @Override
    public Object encrypt(Object o, AlgorithmSQLContext algorithmSQLContext) {
        if (null == o) {
            return null;
        }
        return getMD5HashWithSalt(getObjStr(o), md5Slat);
    }

    @Override
    public Object decrypt(Object o, AlgorithmSQLContext algorithmSQLContext) {
        return o;
    }

    /**
     * 此处一定要进行配置，否则使用此处自定义的配置会导致启动报错
     *
     * @return
     */
    @Override
    public EncryptAlgorithmMetaData getMetaData() {
        // 是否支持解密，是否支持等效过滤器，是否支持like
        return new EncryptAlgorithmMetaData(false, true, false);
    }

}
