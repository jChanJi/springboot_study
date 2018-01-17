package com.chanji.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
//加上切面的注解，并使用Component将类加载到容器当中去
@Aspect
@Component
public class HttpAspect {

    //spring 中自带的日志类，可以将端口，包，类的信息都打印出来，其中的参数要改成类名
    public  final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //拦截GirlControllerz中的任何方法

    //@Before("execution(* com.chanji.girl.controller.GirlController.addgirls(..))")
   // @Before("execution(* com.chanji.girl.controller.GirlController.*(..))")
   /* public  void log1(){

    }
*/
    //切点
    //每次都写"execution(* com.chanji.girl...."这个类造成代码的重复，可以定义一个切点，将拦截的目录定义一个方法，这样其他操作只要调用这些方法就行
    @Pointcut("execution(public * com.chanji.girl.controller.GirlController.*(..))")
    public  void log(){
    }
    //方法执行前就已经执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        //javax.servlet.http.HttpServletRequest
        HttpServletRequest request = attributes.getRequest();

        //url，内容会记录到{}里面
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={},",request.getRemoteAddr());
        //类方法，获取类名，需要传入JoinPoint对象
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() +"."+
                joinPoint.getSignature().getName());
        //参数，只用http传入参数时才能传入
        logger.info("args={}",joinPoint.getArgs());

    }
    //方法执行后执行
    @After("log()")
    public void doAfter(){
        logger.info("2222");
    }
    @AfterReturning(returning = "object", pointcut = "log()")

    //获得返回的内容，服务器发送给客户端的内容，打印出来为哈希码，所以在类中定义toString()方法
    public  void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
