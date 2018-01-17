package com.chanji.girl;/*
*Create by ChanJi on 10:40
*/

import com.chanji.girl.domain.Girl;
import com.chanji.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GirlService test
 *
 * @author
 * @create 2018-01-17 10:40
 **/
//表示要在测试环境中跑项目了，底层封装的junit
@RunWith(SpringRunner.class)
//将启动整个的spring工程
@SpringBootTest
public class GirlServiceTest{

@Autowired
private GirlService girlService;
        //测试方法前要加Test注解
        @Test
        public void findonetest(){
            Girl girl = girlService.findOne(14);
            Assert.assertEquals(new Integer(11),girl.getAge());
        }

}
