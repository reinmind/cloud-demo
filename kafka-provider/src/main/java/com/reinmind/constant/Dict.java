package com.reinmind.constant;

import java.io.Serializable;

public enum Dict implements Serializable{
    SUCCESS("SUCCESS",200),
    FAILED("FAILED",500);
    private final String value;
    private final Integer code;
    Dict(String value,Integer code) {
        this.value = value;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "value='" + value + '\'' +
                ", code=" + code +
                '}';
    }

    public String getValue(){
        return this.value;
    }

    public Integer getCode(){
        return this.code;
    }


}
