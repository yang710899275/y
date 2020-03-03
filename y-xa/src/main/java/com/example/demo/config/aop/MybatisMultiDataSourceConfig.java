package com.example.demo.config.aop;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;

//@Configuration
//@EnableTransactionManagement(order = 2)
//@MapperScan(basePackages = {"com.example.demo.dao"})
public class MybatisMultiDataSourceConfig {

    @Bean
    public DynamicDataSource mutilDataSource(@Qualifier("symbolOrder") AtomikosDataSourceBean one,
                                             @Qualifier("symbolPosition") AtomikosDataSourceBean two){
        HashMap<Object,Object> map = new HashMap<>();
        map.put(one.getUniqueResourceName(),one);
        map.put(two.getUniqueResourceName(),two);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(two);

        return dynamicDataSource;
    }


 /*   @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceOne") DataSource dataSource)
            throws Exception {
        return createSqlSessionFactory(dataSource);
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo") DataSource dataSource)
            throws Exception {
        return createSqlSessionFactory(dataSource);
    }*/




/*    @Bean(name = "sqlSessionTemplate")
    public CustomSqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactoryOne")SqlSessionFactory factoryOne,@Qualifier("sqlSessionFactoryTwo")SqlSessionFactory factoryTwo) throws Exception {
        Map<Object,SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
        sqlSessionFactoryMap.put("one",factoryOne);
        sqlSessionFactoryMap.put("two",factoryTwo);

        CustomSqlSessionTemplate customSqlSessionTemplate = new CustomSqlSessionTemplate(factoryOne);
        customSqlSessionTemplate.setTargetSqlSessionFactorys(sqlSessionFactoryMap);
        return customSqlSessionTemplate;
    }

    *//**
     * 创建数据源
     * @param dataSource
     * @return
     *//*
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage(ALIASES_PACKAGE);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }*/

    /**
     * 注册AOP
     */
    @Bean
    public MutiDataSourceAop mutiDataSourceAop(){
        return new MutiDataSourceAop();
    }
}
