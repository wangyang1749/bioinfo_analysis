package com.wangyang.bioinfo.pojo;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author wangyang
 * @date 2021/6/13
 */
public enum  ProjectStatus {
    ONGOING(0,"正在进行"),COMPLETE(1,"已完成"),PENDING(2,"待进行");

    private final  String name;
    private final   int code;
     ProjectStatus(int code,String name) {
        this.name = name;
        this.code=code;
    }
    public Integer getCode() {
        return code;
    }
    @JsonValue
    public String getValue() {
        return name;
    }


//    @JsonCreator
//    public static EnItemType decode(final String code) {
//        return Stream.of(EnItemType.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
//    }
}
