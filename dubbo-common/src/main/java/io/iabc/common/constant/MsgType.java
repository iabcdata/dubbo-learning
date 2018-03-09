package io.iabc.common.constant;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 23:12 2016年07月18日.
 */
public enum MsgType {
    API(0), URI(1);

    private int value;

    MsgType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static MsgType valueOf(int value) {
        switch (value) {
            case 0:
                return API;
            case 1:
            default:
                return URI;
        }
    }
}