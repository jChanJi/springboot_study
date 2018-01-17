package com.chanji.girl.util;

import com.chanji.girl.domain.Result;

public class ResultUtil {

    //成功含有对象的方法
    public  static Result success(Object object)
    {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }
    //成功不含有对象的方法
    public  static Result success(){
        return success(null);
    }
    public  static  Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
