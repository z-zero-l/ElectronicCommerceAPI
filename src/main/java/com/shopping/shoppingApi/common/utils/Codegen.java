package com.shopping.shoppingApi.common.utils;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.EntityConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.dialect.IDialect;
import com.zaxxer.hikari.HikariDataSource;

public class Codegen {

    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://192.168.232.128:3306/shopping?characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("1208361250");

        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig, IDialect.MYSQL);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置删除标记
        ColumnConfig deleteFlagColumnConfig = new ColumnConfig();
        deleteFlagColumnConfig.setColumnName("is_deleted");
        deleteFlagColumnConfig.setLogicDelete(true);

        //设置创建时间
        ColumnConfig createTimeColumnConfig = new ColumnConfig();
        createTimeColumnConfig.setColumnName("create_time");
        createTimeColumnConfig.setOnInsertValue("now()");
        createTimeColumnConfig.setLarge(true);

        //设置更新时间
        ColumnConfig updateTimeColumnConfig = new ColumnConfig();
        updateTimeColumnConfig.setColumnName("update_time");
        updateTimeColumnConfig.setOnInsertValue("now()");
        updateTimeColumnConfig.setOnUpdateValue("now()");
        updateTimeColumnConfig.setLarge(true);

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.shopping.shoppingApi");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setTablePrefix("t_")
                .setColumnConfig(deleteFlagColumnConfig)
                .setColumnConfig(createTimeColumnConfig)
                .setColumnConfig(updateTimeColumnConfig);

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity();
        globalConfig.getEntityConfig()
                .setWithLombok(true)
                .setWithSwagger(true)
                .setSwaggerVersion(EntityConfig.SwaggerVersion.DOC)
                .setWithActiveRecord(true);


        //设置生成 mapper
        globalConfig.enableMapper();

        globalConfig.enableService();

        globalConfig.enableServiceImpl();
        globalConfig.getServiceImplConfig()
                .setCacheExample(true);

        globalConfig.enableController();

        //globalConfig.enableTableDef();

        //可以单独配置某个列
        //ColumnConfig columnConfig = new ColumnConfig();
        //columnConfig.setColumnName("tenant_id");
        //columnConfig.setLarge(true);
        //columnConfig.setVersion(true);
        //globalConfig.getStrategyConfig()
        //        .setColumnConfig("tb_account", columnConfig);


        return globalConfig;
    }
}
