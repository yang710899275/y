package y.y.yadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 单数据源配置
 */
@Configuration
@ConditionalOnProperty(prefix = "y.muti-datasource", name = "open", havingValue = "false", matchIfMissing = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"y.y.yadmin.module.*.dao"})
public class SingleDataSourceConfig {

    @Bean
    public DruidDataSource dataSource(DruidProperties druidProperties){
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }
}

