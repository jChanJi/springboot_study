package com.chanji.girl.respository;

import com.chanji.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
*
* 继承jpa接口的类以实现jpa对数据库的操作
* Girl为类名，Integer为id类型
* */

public interface GirlRespository extends JpaRepository<Girl,Integer>{
//通过年龄查询,方法名要用固定的格式
    public List<Girl> findByAge(Integer age);
}
