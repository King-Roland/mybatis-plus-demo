package com.example.mybatisplustest;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.example.mybatisplustest.mapper.UserMapper;
import com.example.mybatisplustest.pojo.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@MapperScan("com.example.mybatisplustest.mapper")
@SpringBootTest
class MybatisPlusTestApplicationTests {

    @Autowired
    private UserMapper userMapper;


    /*
    * 自动生成代码
    * <dependency>
    *   <groupId>com.baomidou</groupId>
    *       <artifactId>mybatis-plus-generator</artifactId>
    *   <version>3.3.1.tmp</version>
    *</dependency>
    *<dependency>添加 模板引擎 依赖
    *   <groupId>org.apache.velocity</groupId>
    *       <artifactId>velocity-engine-core</artifactId>
    *       <version>2.2</version>
    * <dependency>
    * */
//    @Test
//    public void genCodePkg(){
//        // Step1：代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // Step2：全局配置
//        GlobalConfig gc = new GlobalConfig();
//        // 填写代码生成的项目目录(需要修改)
//        String projectPath = "E:\\VueProjects\\mybatisPlusTest";
//        // 拼接出代码最终输出的目录
//        gc.setOutputDir(projectPath + "/src/main/java");
//        // 配置开发者信息（可选）（需要修改）
////        gc.setAuthor("lyh");
//        // 配置是否打开目录，false 为不打开（可选）
//        gc.setOpen(false);
//        // 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
//        //gc.setSwagger2(true);
//        // 重新生成文件时是否覆盖，false 表示不覆盖（可选）
//        gc.setFileOverride(true);
//        // 配置主键生成策略，此处为 ASSIGN_ID（可选）
//        gc.setIdType(IdType.ASSIGN_ID);
//        // 配置日期类型，此处为 ONLY_DATE（可选）
//        gc.setDateType(DateType.ONLY_DATE);
//        // 默认生成的 service 会有 I 前缀
//        gc.setServiceName("%sService");
//        mpg.setGlobalConfig(gc);
//
//        // Step3：数据源配置（需要修改）
//        DataSourceConfig dsc = new DataSourceConfig();
//        // 配置数据库 url 地址
//        dsc.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
//        // dsc.setSchemaName("testMyBatisPlus"); // 可以直接在 url 中指定数据库名
//        // 配置数据库驱动
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        // 配置数据库连接用户名
//        dsc.setUsername("root");
//        // 配置数据库连接密码
//        dsc.setPassword("mysql123");
//        mpg.setDataSource(dsc);
//
//        // Step:4：包配置
//        PackageConfig pc = new PackageConfig();
//        // 配置父包名（需要修改）
//        pc.setParent("com.example");
//        // 配置模块名（需要修改）
//        pc.setModuleName("mybatisplustest");
//        // 配置 entity 包名
//        pc.setEntity("pojo");
//        // 配置 mapper 包名
//        pc.setMapper("mapper");
//        // 配置 service 包名
//        pc.setService("service");
//        // 配置 controller 包名
//        pc.setController("controller");
//        mpg.setPackageInfo(pc);
//
//        // Step5：策略配置（数据库表配置）
//        StrategyConfig strategy = new StrategyConfig();
//        // 指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
//        strategy.setInclude("table_user");
//        // 配置数据表与实体类名之间映射的策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        // 配置数据表的字段与实体类的属性名之间映射的策略
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        // 配置 lombok 模式
//        strategy.setEntityLombokModel(true);
//        // 配置 rest 风格的控制器（@RestController）
//        strategy.setRestControllerStyle(true);
//        // 配置驼峰转连字符
//        strategy.setControllerMappingHyphenStyle(true);
//        // 配置表前缀，生成实体时去除表前缀
//        // 此处的表名table_user,去除前缀后剩下为 user。
//        strategy.setTablePrefix("table_");
//        mpg.setStrategy(strategy);
//
//        // Step6：执行代码生成操作
//        mpg.execute();
//    }

    /*
    * 插入语句
    * */
    @Test
    void insertTest() {
        User user = new User();
        user.setUserName("张三");
        user.setAddress("昆明");
        user.setUserEmail("slkfja");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    /*
    * 查询语句
    * */
    @Test
    void selectAll(){
        List<User> users = userMapper.selectList(null);
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    /*
    * 分页测试，需要先配置MybatisPlusConfig
    * */
    @Test
    void pageTest(){
        Page<User> page = new Page<>(1,4);//传递两个参数（当前页，每页显示的条数）
//        List<User> userList = userMapper.selectAllByUserName("张三");
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", "张三");
        userMapper.selectPage(page,queryWrapper);

        System.out.println("====================================");
        System.out.println(page.getRecords());//每页数据的集合
        System.out.println("总记录数：" + page.getTotal());//总的记录数
        System.out.println("每页的记录数：" + page.getSize());//每页的记录数
        System.out.println("当前页：" + page.getCurrent());//获取当前页
        System.out.println("总的页数：" + page.getPages());//总的页数
        System.out.println("是否存在下一页：" + page.hasNext());//是否存在下一页
        System.out.println("是否存在上一页：" + page.hasPrevious());//是否存在上一页
        System.out.println();
    }


}
