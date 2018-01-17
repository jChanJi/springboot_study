package com.chanji.girl.service;

import com.chanji.girl.domain.Girl;
import com.chanji.girl.enums.ResultEnum;
import com.chanji.girl.exception.GirlException;
import com.chanji.girl.respository.GirlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
*
* 事务性的测试，插入两个女生信息
* */
@Service
public class GirlService {
    @Autowired
   private GirlRespository girlRespository;
    //事物管理，当A和B有一个没有插入成功的时候就不会插入
@Transactional(rollbackFor = Exception.class)
    public void insterTwo(){
        Girl girlA  = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(14);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(15);
        girlRespository.save(girlB);

    }
    //获得年龄的逻辑
    //这里只有两个判断，但是如果判断太多的话就不适合用设置标记的方法返回
    //所以这里就用到了统一的异常处理，但是抛出的异常不能够返回我们定义的ResultUtil中的格式，所以又要对异常进行捕获并且封装，创建ExceptionHandle
    //这里抛出了异常所以调用了他的方法的GirlController.getAge()方法也要抛出异常
    public  void  getAge(Integer id) throws Exception{
        Girl girl = girlRespository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            //这里的返回数字由枚举类型的类进行统一的维护
           throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else{
            throw new GirlException(ResultEnum.MIDDLE__SCHOOL);
        }
    }
/*
* 对findOne()进行测试
* */

    public  Girl findOne(Integer id) {
        return girlRespository.findOne(id);
    }


}