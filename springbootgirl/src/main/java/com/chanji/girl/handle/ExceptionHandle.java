package com.chanji.girl.handle;

import com.chanji.girl.controller.GirlController;
import com.chanji.girl.domain.Result;
import com.chanji.girl.exception.GirlException;
import com.chanji.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*ControllerAdvice 即把@ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute
 注解的方法应用到所有的 @RequestMapping注解的方法。
 只有当使用@ExceptionHandler最有用，另外两个用处不大。*/
@ControllerAdvice
    public class ExceptionHandle {
    public  final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    //声明需要捕获的异常类
    @ExceptionHandler(value = Exception.class)
    //因为返回的是json格式,但是类上没有restcontroller，所以使用ResponseBody这个类
    @ResponseBody
    public Result handle(Exception e){
        //判断是否为我们自己定义的异常，如果是就返回信息，不是就返回
        if (e instanceof GirlException){
            //自己定义一个异常类GirlException
            GirlException girlException = (GirlException)e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());

        }else {
            logger.error("【系统错误】：{}",e);
            //未知错误不能够定位bug，所以使用日志打印出异常
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
