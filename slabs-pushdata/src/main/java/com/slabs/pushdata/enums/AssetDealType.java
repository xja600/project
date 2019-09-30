package com.slabs.pushdata.enums;

public enum AssetDealType {
    IN("01", "进包"),
    OUT("02", "退包"),
    ;

    private final String value;
    private final String desc;

    AssetDealType(String value, String desc) {
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
