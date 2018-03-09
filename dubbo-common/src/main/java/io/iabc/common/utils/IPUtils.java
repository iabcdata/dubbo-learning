package io.iabc.common.utils;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:06 2016年06月02日.
 */
public class IPUtils {

    private static final String DEFALUT_IP_WILDCARD = "%"; // IP字段通配符
    private static final int IP_FIELD_CNT = 4; // IPv4最大字段数
    private static final int IP_FIELD_MIN_VALUE = 0; // IP字段最小值
    private static final int IP_FIELD_MAX_VALUE = 255; // IP字段最大值
    private static final long IP_MIN_LONG_VALUE = 0L; // IP转成长整形后的最小值
    private static final long IP_MAX_LONG_VALUE = 4294967295L; // IP转成长整形后的最大值

    public final static long ipv4ToLong(String ipv4) {
        String[] octets = ipv4.split("\\.");
        if (IP_FIELD_CNT != octets.length) {
            throw new IllegalArgumentException("IPv4 invalid!");
        }
        long ip = 0;
        for (int i = IP_FIELD_CNT - 1; i >= 0; i--) {
            final long octet = Long.parseLong(octets[3 - i]);
            if (IP_FIELD_MIN_VALUE > octet || IP_FIELD_MAX_VALUE < octet) {
                throw new IllegalArgumentException("IPv4 invalid!");
            }
            ip |= octet << (i * 8);
        }
        return ip;
    }

    public final static String longToIpv4(long ipv4) {
        if (IP_MIN_LONG_VALUE > ipv4 || IP_MAX_LONG_VALUE < ipv4) {
            // if ip is out of range 0.0.0.0~255.255.255.255
            throw new IllegalArgumentException("IPv4 invalid!");
        }
        final StringBuilder ipAddress = new StringBuilder(15);
        for (int i = IP_FIELD_CNT - 1; i >= 0; i--) {
            final int shift = i * 8;
            ipAddress.append((ipv4 & (0xFF << shift)) >> shift);
            if (i > 0) {
                ipAddress.append(".");
            }
        }
        return ipAddress.toString();
    }

    /**
     * 最后的%
     * <p>
     * <pre>
     * e.g.
     *      192.168.%
     *      192.168.12%
     *      192.168.3.%
     *      192.168.3.1%
     * </pre>
     *
     * @param ipv4WithWildcard 要计算的ipv4的长整形值
     * @return 范围数组
     */
    public final static long[] calcLowAndHigh(String ipv4WithWildcard) {
        return calcLowAndHigh(ipv4WithWildcard, DEFALUT_IP_WILDCARD);
    }

    /**
     * 假设最后的通配符为%
     * <p>
     * <pre>
     * e.g.
     *      192.168.%
     *      192.168.12%
     *      192.168.3.%
     *      192.168.3.1%
     * </pre>
     *
     * @param ipv4WithWildcard 要计算的ipv4的长整形值
     * @param wildcard         通配符
     * @return 范围数组
     */
    public final static long[] calcLowAndHigh(String ipv4WithWildcard, final String wildcard) {

        String[] octets = ipv4WithWildcard.split("\\.");
        if (IP_FIELD_CNT < octets.length) {
            throw new IllegalArgumentException("IPv4 invalid!");
        }
        long minIP = 0;
        long maxIP = 0;
        long ip = 0;
        for (int i = IP_FIELD_CNT - 1; i >= IP_FIELD_CNT - octets.length; i--) {
            String field = octets[3 - i];
            if (field.endsWith(wildcard)) {
                long[] pair = calcFieldLowAndHigh(field, wildcard);
                minIP = ip | (pair[0] << (i * 8));
                maxIP = ip | (pair[1] << (i * 8));
                break; // 结束
            }
            final long octet = Long.parseLong(field);
            if (IP_FIELD_MIN_VALUE > octet || IP_FIELD_MAX_VALUE < octet) {
                throw new IllegalArgumentException("IPv4 invalid!");
            }
            ip |= octet << (i * 8);
        }
        return new long[]{minIP, maxIP};
    }

    private final static long[] calcFieldLowAndHigh(String ipv4FieldWithWildcard, final String wildcard) {

        long minIP = 0;
        long maxIP = 0;
        int index = ipv4FieldWithWildcard.indexOf(wildcard);
        switch (index) {
            case 0: // 只有通配符
                minIP = IP_FIELD_MIN_VALUE;
                maxIP = IP_FIELD_MAX_VALUE;
                break;
            case 1: // 有一位前缀
                final int prefix = Integer.parseInt(ipv4FieldWithWildcard.substring(0, index));
                switch (prefix) {
                    case 1:
                        minIP = prefix * 10;
                        maxIP = prefix * 100 + 99;
                        break;
                    case 2:
                        minIP = prefix * 10;
                        maxIP = prefix * 100 + 55;
                        break;
                    default:
                        minIP = prefix * 10;
                        maxIP = prefix * 10 + 9;
                        break;
                }
                break;
            case 2:
                final int triple = Integer.parseInt(ipv4FieldWithWildcard.substring(0, index));
                if (triple < 25) {
                    maxIP = triple * 10 + 9;
                } else if (triple == 25) {
                    maxIP = triple * 10 + 5;
                } else {
                    throw new IllegalArgumentException("IPv4 field invalid!");
                }
                minIP = triple * 10;
                break;
            default:
                throw new IllegalArgumentException("IPv4 field invalid!");
        }

        return new long[]{minIP, maxIP};
    }

}