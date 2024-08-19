package com.lazyboyl.sharding.encrypt.algorithm;

import com.google.common.base.Strings;
import lombok.SneakyThrows;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithmMetaData;
import org.apache.shardingsphere.infra.algorithm.core.context.AlgorithmSQLContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 加密模糊匹配算法
 * 每个字符进行
 *
 * @author linzf
 */
public final class CharDigestLikeEncryptAlgorithm implements EncryptAlgorithm {

    private static final String DELTA_KEY = "delta";

    private static final String MASK_KEY = "mask";

    private static final String START_KEY = "start";

    private static final String DICT_KEY = "dict";

    private static final int DEFAULT_DELTA = 1;

    private static final int DEFAULT_MASK = 0b1111_0111_1101;

    private static final int DEFAULT_START = 0x4e00;

    private static final int MAX_NUMERIC_LETTER_CHAR = 255;

    private int delta;

    private int mask;

    private int start;

    private Map<Character, Integer> charIndexes;

    @Override
    public void init(final Properties props) {
        delta = createDelta(props);
        mask = createMask(props);
        start = createStart(props);
        charIndexes = createCharIndexes(props);
    }

    private int createDelta(final Properties props) {
        if (props.containsKey(DELTA_KEY)) {
            try {
                return Integer.parseInt(props.getProperty(DELTA_KEY));
            } catch (final NumberFormatException ignored) {
                throw new RuntimeException("delta can only be a decimal number");
            }
        }
        return DEFAULT_DELTA;
    }

    private int createMask(final Properties props) {
        if (props.containsKey(MASK_KEY)) {
            try {
                return Integer.parseInt(props.getProperty(MASK_KEY));
            } catch (final NumberFormatException ignored) {
                throw new RuntimeException("mask can only be a decimal number");
            }
        }
        return DEFAULT_MASK;
    }

    private int createStart(final Properties props) {
        if (props.containsKey(START_KEY)) {
            try {
                return Integer.parseInt(props.getProperty(START_KEY));
            } catch (final NumberFormatException ignored) {
                throw new RuntimeException("start can only be a decimal number");
            }
        }
        return DEFAULT_START;
    }

    private Map<Character, Integer> createCharIndexes(final Properties props) {
        String dictContent = props.containsKey(DICT_KEY) && !Strings.isNullOrEmpty(props.getProperty(DICT_KEY)) ? props.getProperty(DICT_KEY) : initDefaultDict();
        return IntStream.range(0, dictContent.length()).boxed().collect(Collectors.toMap(dictContent::charAt, index -> index, (a, b) -> b));
    }

    @SneakyThrows(IOException.class)
    private String initDefaultDict() {
        StringBuilder result = new StringBuilder();
        try (
                InputStream inputStream = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("algorithm/like/common_chinese_character.dict"));
                Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    result.append(line);
                }
            }
        }
        return result.toString();
    }

    private String digest(final String plainValue) {
        StringBuilder result = new StringBuilder(plainValue.length());
        for (char each : plainValue.toCharArray()) {
            char maskedChar = getMaskedChar(each);
            if ('%' == maskedChar || '_' == maskedChar) {
                result.append(each);
            } else {
                result.append(maskedChar);
            }
        }
        return result.toString();
    }

    /**
     * 如果字符是 '%' 或 '_'，直接返回该字符。对于小于等于最大数字字母字符的字符，
     * 通过位运算和掩码mask进行转换。对于在字符索引映射中存在的字符，先通过索引和位运算转换，
     * 然后加上起始值start。对于其他字符，同样进行位运算转换并加上起始值start。
     *
     * @param originalChar
     * @return
     */
    private char getMaskedChar(final char originalChar) {
        if ('%' == originalChar || '_' == originalChar) {
            return originalChar;
        }
        if (originalChar <= MAX_NUMERIC_LETTER_CHAR) {
            return (char) ((originalChar + delta) & mask);
        }
        if (charIndexes.containsKey(originalChar)) {
            return (char) (((charIndexes.get(originalChar) + delta) & mask) + start);
        }
        return (char) (((originalChar + delta) & mask) + start);
    }

    @Override
    public String getType() {
        return "CHAR_DIGEST_LIKE";
    }

    @Override
    public Object encrypt(Object plainValue, AlgorithmSQLContext algorithmSQLContext) {
        return null == plainValue ? null : digest(String.valueOf(plainValue));
    }

    @Override
    public Object decrypt(Object cipherValue, AlgorithmSQLContext algorithmSQLContext) {
        return cipherValue;
    }

    @Override
    public EncryptAlgorithmMetaData getMetaData() {
        return new EncryptAlgorithmMetaData(true, true, true);
    }
}
