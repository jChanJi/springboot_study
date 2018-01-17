package com.chanji.girl.exception;

import com.chanji.girl.enums.ResultEnum;

//继承RuntimeException,sping中继承Exception是不能够回滚的，所以必须要集成RuntimeException
public class GirlException extends  RuntimeException {

    private  Integer code;
//构造方法传入code和message，父类方法中本身就会传入一个message
    public  GirlException(ResultEnum resultEnum){
        super(resultEnum.getMess());
        this.code = resultEnum.getCode();
    }

    public  Integer getCode(){
        return code;
    }
    public  void  setCode(Integer code){
        this.code = code;
    }
}
