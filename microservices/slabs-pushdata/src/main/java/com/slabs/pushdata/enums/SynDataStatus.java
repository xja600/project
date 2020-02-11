package com.slabs.pushdata.enums;

public enum SynDataStatus {
    NO("01", "未同步"),
    YES("02", "已同步"),
    ;

    private final String value;
    private final String desc;

    SynDataStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return desc;
    }

    @Override
    public String toString() {
        return value;
    }
}
