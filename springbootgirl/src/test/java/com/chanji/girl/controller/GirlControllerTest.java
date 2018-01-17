package com.chanji.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/*
*Create by ChanJi on 11:06
*对于很多的测试用例并不需要一个个的测试在项目打包的时候会自动测试，mvn clean package
* 如果打包的时候跳过单元测则使用命名: mvn clean package  -Dmaven.test.skip=true
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    //MockMvc对我们的系统的Controller进行单元测试
    private MockMvc mvc;
    @Test

    public  void girlControllerTest() throws  Exception{
        mvc.perform(MockMvcRequestBuilders.get("/girls"))
                //使用MockMvc对http请求的状态进行测试
                .andExpect(MockMvcResultMatchers.status().isOk())
                //对内容进行测试
                .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}