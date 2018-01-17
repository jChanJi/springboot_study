package com.chanji.girl.controller;

import com.chanji.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//RestController=Controller+ResponseBody
//@RequestMapping()也可以给类添加url
public class HelloController {
    //取出properties1中cupsSize的属性值
    //@Value("${cupsSize}")
    private String cupsize;
    @Autowired
    private GirlProperties girlProperties;
    //@RequestMapping(value = {"1"/hello,"2"/hello},method = RequestMethod.GET) 使用a,或者b都能获得值
    //PathVariable中的id和Integer后的id需要命名相同
    @GetMapping("/{id}/hello")
    public String say(@PathVariable("id") Integer id){
        return girlProperties.getCupSize()+"id:"+ id;
    }
    @GetMapping("hello2")
    //require 设置是否必传   defaultValue默认值，必须为字符，其中id和myid不需要命名相同
    public String say2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        return girlProperties.getCupSize()+": id:"+ myId;
    }
}
