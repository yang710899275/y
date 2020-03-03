package com.example.demo.config.pagckage1;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
// basePackages 最好分开配置 如果放在同一个文件夹可能会报错
@MapperScan(basePackages = "com.example.demo.dao2", sqlSessionFactoryRef = "user2SqlSessionFactory")
public class DBConfig2 {

    @Bean(name = "symbolPosition")
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
    }

    @Bean(name="user2SqlSessionFactory")
    public SqlSessionFactory user1SqlSessionTemplate(@Qualifier("symbolPosition") DataSource dataSource) throws Exception {
       //重点，解决分包时，使用通用方法 ，报错invalid bound
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/dao2/**/*.xml"));

        return bean.getObject();
    }

    @Bean(name = "user2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("user2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
