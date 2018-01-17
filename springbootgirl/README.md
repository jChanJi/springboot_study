# spring boot 基础
### Controller的使用
>Controller的代码中只写mapping的函数，逻辑处理放到其他层当中
### 数据库的操作
>使用jpa封装的hibernate对数据库操作，使用自定义的查询方法的时候
需要新建一个类继承JpaRepository接口，并且方法名要用固定的格式

# spring boot 进阶
### 使用@vaild进行表达验证
>需要在验证的属性值的domian上添加验证条件，在需要验证的地方添加@vaild注解
返回值存放于BindingResult中
### 使用AOP进行处理请求
>面向切面，类似于水平的拦截器，这要指定需要filter的包或者类的路径，在方法里写上before、after等方法
### 统一的异常处理
>自定义异常处理需要继承RuntimeException方法，本案列中girController的getAge()方法使用了GirlSeivce中的getAge
()方法，当出现异常时service中的getAge抛出异常到controller中的getAge方法，然后再次的抛出异常，此时被异常捕获器
ExceptionHandle捕获，捕获后再使用自己定义的异常处理类处理
### 单元测试
>右击go to 可以自动生成测试的文件，使用AutoConfigureMockMvc对http请求进行测试。
