package y.y.yadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import y.y.yadmin.aop.MutiDataSourceAop;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * 多数据源配置
 */
@Configuration
@ConditionalOnProperty(prefix = "y.muti-datasource", name = "open", havingValue = "true", matchIfMissing = true)
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"y.y.yadmin.module.*.dao"})
public class MultiDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.db2")
    public DruidProperties druidProperties2(){
        return new DruidProperties();
    }

    public DruidDataSource dataSource(DruidProperties druidProperties){
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    @Bean
    public DynamicDataSource mutilDataSource(DruidProperties druidProperties,DruidProperties druidProperties2){
        DruidDataSource d1 = dataSource(druidProperties);
        DruidDataSource d2 = dataSource(druidProperties2);
        try {
            d1.init();
            d2.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HashMap<Object,Object> map = new HashMap<>();
        map.put(druidProperties.getDataSourceName(),d1);
        map.put(druidProperties2.getDataSourceName(),d2);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(d1);

        return dynamicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DynamicDataSource mutiDataSource) {
        return new DataSourceTransactionManager(mutiDataSource);
    }

    /**
     * 注册AOP
     */
    @Bean
    public MutiDataSourceAop mutiDataSourceAop(){
        return new MutiDataSourceAop();
    }
}
