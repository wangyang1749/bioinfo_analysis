package com.wangyang.bioinfo.pojo.vo;

import lombok.Data;

/**
 * @author wangyang
 * @date 2021/6/13
 */
@Data
public class KeyAndValue {
    private int key;
    private String value;

    public KeyAndValue(int key,String value){
        this.key=key;
        this.value=value;
    }
}
