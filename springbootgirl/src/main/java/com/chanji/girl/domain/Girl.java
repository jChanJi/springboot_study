package com.chanji.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
/*
* 不需要建表
* 和数据库对应的类
* */
@Entity
public class Girl {
    //主键，自增
    @Id
    @GeneratedValue
    private  Integer id;
    private String cupSize;
    //最小值为18，还需要在对象前加@Vaild注解，见GirlController的addgirls
    @Min(value=18, message = "未成年人禁止入内")
    private  Integer age;
    //无参数的构造方法必须要有
    public  Girl(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
