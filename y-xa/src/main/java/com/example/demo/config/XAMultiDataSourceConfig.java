package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
//@MapperScan(basePackages = {"com.example.demo.dao"})
public class XAMultiDataSourceConfig {
    /**
     * db1的 XA datasource
     *
     * @return
     */
    //使用druid驱动
   /* @Bean(name = "symbolOrder")
    @Primary
    @Qualifier("symbolOrder")
    public AtomikosDataSourceBean symbolOrderBean() {
        DruidXADataSource dataSource = new DruidXADataSource();
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("symbolOrder");
        DruidProperties dataSource1 = new DruidProperties();
        BeanUtils.copyProperties(dataSource1,dataSource);
        atomikosDataSourceBean.setXaDataSource(dataSource);
        return atomikosDataSourceBean;
    }*/

    /**
     * db2的 XA datasource
     *
     * @return
     */
    //不使用驱动的方式
   /* @Bean(name = "symbolPosition")
    @Qualifier("symbolPosition")
    public AtomikosDataSourceBean symbolPositionDataSourceBean() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("symbolPosition");
        atomikosDataSourceBean.setXaDataSourceClassName(
                "com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        Properties properties = new Properties();
        properties.put("URL", "jdbc:mysql://192.168.10.93:3306/gdca_mc?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useOldAliasMetadataBehavior=true");
        //properties.put("url", "jdbc:mysql://192.168.10.93:3306/gdca_mc?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useOldAliasMetadataBehavior=true");
        properties.put("user", "gdca");
        //properties.put("username", "gdca");
        properties.put("password", "gdca1234");
        atomikosDataSourceBean.setXaProperties(properties);
        return atomikosDataSourceBean;
    }*/

/*    *//**
     * transaction manager
     *
     * @return
     *//*

    @Bean(destroyMethod = "close", initMethod = "init")
    public UserTransactionManager userTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    *//**
     * jta transactionManager
     *
     * @return
     *//*

    @Bean
    public JtaTransactionManager transactionManager() {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(userTransactionManager());
        return jtaTransactionManager;
    }*/
}
