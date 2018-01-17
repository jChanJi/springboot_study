package com.chanji.girl.controller;

import com.chanji.girl.aspect.HttpAspect;
import com.chanji.girl.domain.Girl;
import com.chanji.girl.domain.Result;
import com.chanji.girl.respository.GirlRespository;
import com.chanji.girl.service.GirlService;
import com.chanji.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    public  final  static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRespository girlRespository;
    @Autowired
    GirlService girlService = new GirlService();
    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRespository.findAll();
    }

    /**
     * 查询一个女生 by id
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRespository.findOne(id);
    }
    /**
     * 查询一个女生 by  age,需要在girlRespository接口中按照固定的命名规则，定义查询类
     * @param age
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public  List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    /**
     * 添加一个女生信息
     * @return
     */
    @PostMapping("/girls")
    //对添加女生进行验证，验证结果保存你在BindingResult中，如果不通过返回错误信息
    //返回Result这个对象信息，如果成功执行构造的 ResultUtil.success（）函数，否则使用 ResultUtil.error()函数，
    // 其中工具类是为了防止代码重复 ,代码重复就立马优化，千万不能以后再说
    public Result <Girl> addgirls(@Valid  Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRespository.save(girl));
    }


    /**
     * 跟新一个女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("girls/{id}")
    public Girl  girlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age")  Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

    /**
     * 删除一个女生信息
     * @param id
     */
    @DeleteMapping("girls/{id}")
    public void delGirl(@PathVariable("id") Integer id){
        girlRespository.delete(id);
    }

    //插入两个女生的信息，检验事务性
    @PostMapping("/girls/two")
    public  void  girlTwo(){
        girlService.insterTwo();

    }
 //获取年龄，将所有的逻辑都放到service中进行判断，这里直接调用service
    @GetMapping(value ="girls/getAge/{id}" )
    public void getAge(@PathVariable("id") Integer id) throws  Exception{
        girlService.getAge(id);
    }

}