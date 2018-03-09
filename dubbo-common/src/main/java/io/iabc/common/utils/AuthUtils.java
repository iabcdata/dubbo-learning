package io.iabc.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 11:45 2016年07月12日.
 */
public class AuthUtils {
    private static final String READ = "r";
    private static final String WRITE = "w";
    private static final String EXCUTE = "x";

    private static String _switchType(int pos) {
        switch (pos) {
            case 1:
                return EXCUTE;
            case 2:
                return WRITE;
            case 3:
                return READ;
            default:
                return null;
        }
    }

    private static int _switchValue(String type) {
        if (StringUtils.isEmpty(type)) {
            return 0;
        }
        switch (type.toLowerCase()) {
            case EXCUTE:
                return (1 << 0);
            case WRITE:
                return (1 << 1);
            case READ:
                return (1 << 2);
            default:
                return 0;
        }
    }


    /**
     * 操作类型权限字符串转整形
     * "rwx" -> 7
     * "rw" -> 6
     * "rx" -> 5
     * "r" -> 4
     * "wx" -> 3
     * "w" -> 2
     * "x" -> 1
     * "" -> 0
     *
     * @param permission 权限操作类型[r][w][x]
     * @return 对应的整形
     */
    public static int permission2value(String permission) {

        if (null == permission) {
            return 0;
        }
        int sum = 0;
        for (int pos = 0; pos < permission.length(); pos++) {
            sum += _switchValue(permission.substring(pos, pos + 1));
        }

        return sum;
    }

    /**
     * 7 -> "rwx"
     * 6 -> "rw"
     * 5 -> "rx"
     * 4 -> "r"
     * 3 -> "wx"
     * 2 -> "w"
     * 1 -> "x"
     * 0 -> ""
     *
     * @param value 操作
     * @return 操作类型[r][w][x]
     */
    public static String value2permission(int value) {
        String strValue = Integer.toBinaryString(value);
        StringBuilder sb = new StringBuilder();
        String permission = null;
        int pos = 0;
        int len = strValue.length();
        for (int i = 0; i < len; i++) {
            pos = len - i;
            if ("0".endsWith(strValue.substring(i, i + 1))) {
                continue;
            }

            permission = _switchType(pos);
            if (null == permission) {
                continue;
            }
            sb.append(permission);
        }

        return sb.toString();
    }

    /**
     * 校验权限是否许可
     *
     * @param permission 被授予的操作权限
     * @param opration   待校验的操作权限
     * @return 是否许可 true:许可 false:禁止
     */
    public static boolean isPermitted(final int permission, String opration) {
        return isPermitted(permission, permission2value(opration));
    }

    /**
     * 校验权限是否许可
     *
     * @param permission 被授予的操作权限
     * @param opration   待校验的操作权限
     * @return 是否许可 true:许可 false:禁止
     */
    public static boolean isPermitted(final int permission, int opration) {
        return opration > 0 ? (permission & opration) == opration : false;
    }

    public static void main(String[] args) {
        final int permission = 5;
        System.out.println(isPermitted(permission, 6));
        System.out.println(isPermitted(permission, "rw"));
        System.out.println();
        System.out.println(isPermitted(permission, 5));
        System.out.println(isPermitted(permission, "rx"));
        System.out.println();
        System.out.println(isPermitted(permission, 4));
        System.out.println(isPermitted(permission, "r"));
        System.out.println();
        System.out.println(isPermitted(permission, 3));
        System.out.println(isPermitted(permission, "wx"));
        System.out.println();
        System.out.println(isPermitted(permission, 2));
        System.out.println(isPermitted(permission, "w"));
        System.out.println();
        System.out.println(isPermitted(permission, 1));
        System.out.println(isPermitted(permission, "x"));

        System.out.println();
        System.out.println(isPermitted(permission, ""));
        System.out.println(isPermitted(permission, null));
        return;
    }

}
