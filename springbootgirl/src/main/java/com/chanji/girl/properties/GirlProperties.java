package com.chanji.girl.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//声明为组件，这样HelloController中才能找到他
@Component
//j将applicable。properties中前缀为girl的属性取出来
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;
    private Integer age;

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
}
