package com.lazyboyl.sharding.encrypt.algorithm;


import lombok.EqualsAndHashCode;
import org.apache.shardingsphere.encrypt.api.context.EncryptContext;
import org.apache.shardingsphere.encrypt.api.encrypt.assisted.AssistedEncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import static org.locationtech.jts.io.WKBWriter.bytesToHex;

/**
 * 自定义MD5加盐的加密的实现
 *
 * @author linzf
 */
@EqualsAndHashCode
public class Md5EncryptAlgorithm implements AssistedEncryptAlgorithm {

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
    public Object encrypt(Object o, EncryptContext encryptContext) {
        if (null == o) {
            return null;
        }
        return getMD5HashWithSalt(getObjStr(o), md5Slat);
    }


}
