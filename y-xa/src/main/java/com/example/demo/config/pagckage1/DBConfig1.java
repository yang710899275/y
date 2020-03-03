package com.example.demo.config.pagckage1;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.demo.config.DruidProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// basePackages 最好分开配置 如果放在同一个文件夹可能会报错
@MapperScan(basePackages = "com.example.demo.dao", sqlSessionFactoryRef = "user1SqlSessionFactory")
public class DBConfig1 {

    @Bean(name = "symbolOrder")
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
    }

    @Primary
    @Bean(name="user1SqlSessionFactory")
    public SqlSessionFactory user1SqlSessionTemplate(@Qualifier("symbolOrder") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/dao/**/*.xml"));
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("symbolOrder") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Primary
    @Bean(name = "user1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("user1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
