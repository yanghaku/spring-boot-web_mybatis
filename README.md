# spring-boot-web + mybatis + mybatis-generator



此工程是maven管理的spring-boot-web + mybatis + mybatis-generator的配置模板, 无需繁琐配置, 打开即用, 修改一下```application.properities```文件里面的数据库源之类的即可.



## 搞这个模板的原因:

1. spring-boot-initialize 之后, 每次还都得更改好多东西

2. mybatis, mybatis-generator是连接数据库都用到的东西, 每次xml的配置都好麻烦, 这次终于趁写作业的机会整合到一个文件里面了.

2. 每一个配置的地方都加了很全的注释  (虽然也是现在我对此片面的理解)

   
   

## 需要修改的信息:

1. pom.xml  (**第7行-第12行**)  改成自己工程的名字/版本等

   ```xml
       <!-- 这个工程的元信息, 组织-名称-版本-描述等  -->
       <groupId>edu.nju</groupId>
       <artifactId>spring-boot-template</artifactId>
       <version>0.1.0</version>
       <name>Web</name>
       <description>template project for Spring-boot web</description>
   ```

2. src/java/main 里面的包名, 把edu.nju.example改成自己的.

3. application.properities:  

   首先数据的用户名/密码, 包名之类的都要改一下, 其他的按需修改

   ```properties
   # ------------------------------------------------------------------  mysql 数据库连接配置
   spring.datasource.deviceClassName=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://127.0.0.1:3306/example?characterEncoding=UTF-8 & useSSL=false & serverTimezone=Asia/Shanghai & allowPublicKeyRetrieval=true & autoReconnect=true & failOverReadOnly=false
   spring.datasource.username=root
   spring.datasource.password=123
   # ------------------------------------------------------------------ mybatis 配置
   # 指定model类的位置
   mybatis.type-aliases-package=edu.nju.example.model
   # 指定mapper文件的位置
   mybatis.mapper-locations=classpath:mapper/*.xml
   mybatis.check-config-location=true
   # 开启驼峰命名法
   mybatis.configuration.map-underscore-to-camel-case=true
   # ------------------------------------------------------------------  mybatis-generator 插件配置
   # mbg要指定驱动jar包的位置
   mbg.jdbc.driverPath=D:/lib/mvn-repo/mysql/mysql-connector-java/8.0.28/mysql-connector-java-8.0.28.jar
   # 生成的model的位置
   mbg.model.package=edu.nju.example.model
   mbg.model.project=src/main/java
   # 生成的mapper接口的位置
   mbg.mapper.java.package=edu.nju.example.dao
   mbg.mapper.java.project=src/main/java
   # 生成的mapper的xml文件的位置
   mbg.mapper.xml.package=mapper
   mbg.mapper.xml.project=src/main/resources
   ```

   

4. src/resource/plugins/config-mybatis-generator.xml里面 (**第62-63行**): 增加数据库对应的table

   ```xml
   <!-- 配置生成的table -->
   <table tableName="item" domainObjectName="Item"/>
   ```

5. 初始化数据库后(可以看```deploy```里面```example.sql```的例子), 使用mybatis-generator生成对应的类/mapper操作, 就可以按需修改, 快速开发了~~~    

6. example的文件(可以直接删掉的)有:

   * ```deloy/example.sql```
   * ```src/main/java/edu/nju/example/controller/ExampleController.java```
   * ```src/main/java/edu/nju/example/dao/ItemMapper.java```   (mybatis-generator生成的)
   * ```src/main/java/edu/nju/example/model/Item.java ``` (mybatis-generator生成的)
   * ```src/main/java/edu/nju/example/service/ExampleService.java```
   * ```src/main/java/edu/nju/example/service/impl/ExampleServiceImpl.java```
   * ```src/main/resources/mapper/itemMapper.xml ``` (mybatis-generator生成的)






## 有哪些地方可以修改, 欢迎提出~~





顺便打广告: <a href="https://space.bilibili.com/347527982/channel/seriesdetail?sid=408707" target="_blank"> https://space.bilibili.com/347527982/channel/seriesdetail?sid=408707  </a>, 来看曹老师讲的spring吧!