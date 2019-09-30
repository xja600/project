package com.slabs.pushdata.enums;

/**
 * @Author: XiongFeng
 * @Description: 资产状态
 * @Date: Created in 15:48 2018/5/18
 */
public enum AssetStatus {

    NOT("01", "未标记"),
    PRE("02", "预标记"),
    MARK("03", "正式标记"),
    PROCESSED("04", "已处置"),
    SETTLE("05", "已结清"),
    ARCHIVE("06", "已归档"),
    ;

    private final String value;
    private final String desc;

    AssetStatus(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return desc;
    }

    public static AssetStatus getByValue(String value) {
        for (AssetStatus _enum : AssetStatus.values()) {
            if (_enum.getValue().compareTo(value) == 0) {
                return _enum;
            }
        }
        throw new IllegalArgumentException(String.format("InvoiceContentType code: %s", value));
    }

    @Override
    public String toString() {
        return value;
    }

}
