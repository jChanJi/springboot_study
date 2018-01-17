package com.chanji.girl.enums;

//枚举类型的类用来统一的管理返回的result中数字和信息
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知的系统错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE__SCHOOL(101,"你可能还在上初中");
    private Integer code;
    private  String mess;

    ResultEnum(Integer code,String mess) {
        this.code = code;
        this.mess = mess;
    }

    public Integer getCode() {
        return code;
    }

    public String getMess() {
        return mess;
    }
}
